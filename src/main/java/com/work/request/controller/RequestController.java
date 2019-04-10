package com.work.request.controller;

import com.work.request.enums.StatusEnum;
import com.work.request.exception.RequestNotFoundException;
import com.work.request.exception.StatusNotFoundException;
import com.work.request.model.Request;
import com.work.request.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("/requests")
    public List<Request> getRequests() {
        return requestRepository.findAll();
    }

    @GetMapping(path = {"/requests/{id}"})
    public Request getRequestById(@PathVariable(value = "id") Long requestId){
        return requestRepository.findById(requestId)
                .orElseThrow(() -> new RequestNotFoundException(requestId));
    }

    @PostMapping("/requests")
    @ResponseStatus(HttpStatus.CREATED)
    public Request createRequest(@RequestBody String description) {
        return requestRepository.save(new Request(description));
    }

    @PutMapping("/requests/{id}/description")
    public Request updateRequest(@PathVariable(value = "id") Long requestId,
                                 @Valid @RequestBody Request requestUpdate) {


        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new RequestNotFoundException(requestId));

        request.setDescription(requestUpdate.getDescription());
        return requestRepository.save(request);
    }

    @PutMapping("/requests/{id}/status")
    public Request updateStatus(@PathVariable(value = "id") Long requestId,
                                @RequestBody Request requestUpdate) {

        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new RequestNotFoundException(requestId));

        return StatusEnum.stream()
                .filter(s -> s.getStatus().equals(requestUpdate.getStatus()))
                .findFirst()
                .map( upd -> { request.setStatus(upd.getStatus()); return requestRepository.save(request); })
                .orElseThrow(() -> new StatusNotFoundException());
    }

    @DeleteMapping("/requests/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable(value = "id") Long requestId) {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new RequestNotFoundException(requestId));

        requestRepository.delete(request);

        return ResponseEntity.ok().build();
    }
}
