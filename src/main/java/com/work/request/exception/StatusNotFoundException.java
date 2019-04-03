package com.work.request.exception;

import com.work.request.enums.StatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StatusNotFoundException extends RuntimeException {
    public StatusNotFoundException() {
        super(String.format("Неверный статус заявки. Допустимые статусы: \"%s\", \"%s\", \"%s\", \"%s\"",
                StatusEnum.NEW.getStatus(), StatusEnum.WORK.getStatus(), StatusEnum.RESOLVED.getStatus(), StatusEnum.REJECTED.getStatus() ));
    }
}
