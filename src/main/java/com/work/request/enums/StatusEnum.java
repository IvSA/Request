package com.work.request.enums;

import java.util.stream.Stream;

public enum StatusEnum {
    NEW("Новая"),
    WORK("В работе"),
    RESOLVED("Решена"),
    REJECTED("Отклонена");

    private String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public final String getStatus() {
        return status;
    }

    public static Stream<StatusEnum> stream() {
        return Stream.of(StatusEnum.values());
    }
}
