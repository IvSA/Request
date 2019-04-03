package com.work.request.controller;

import com.work.request.exception.RequestNotFoundException;
import com.work.request.model.Request;
import com.work.request.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;

//    RequestController(RequestRepository requestRepository) {
//        this.requestRepository = requestRepository;
//    }

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
    public Request createRequest(@Valid @RequestBody Request request) {
        return requestRepository.save(request);
    }

    @PutMapping("/requests/{id}")
    public Request updateRequest(@PathVariable(value = "id") Long requestId,
                           @Valid @RequestBody Request requestUpdate) {

        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new RequestNotFoundException(requestId));

        request.setDescription(requestUpdate.getDescription());
        request.setStatus(requestUpdate.getStatus());

        return requestRepository.save(request);
    }

    @DeleteMapping("/requests/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable(value = "id") Long requestId) {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new RequestNotFoundException(requestId));

        requestRepository.delete(request);

        return ResponseEntity.ok().build();
    }
}
