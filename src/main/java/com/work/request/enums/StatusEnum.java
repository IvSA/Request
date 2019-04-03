package com.work.request.enums;

public enum StatusEnum {
    NEW("Новая"),
    WORK("В работе"),
    RESOLVED("Решена"),
    REJECTED("Отклонена1");

    private String status;

    StatusEnum(String status) {
    }

    public final String getStatus() {
        return status;
    }
}
