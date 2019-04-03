package com.work.request.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RequestNotFoundException extends RuntimeException {

    private Long requestId;

    public RequestNotFoundException(Long requestId) {
        super(String.format("Request no.%s not found.", requestId));
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
}
