package com.hsptsdb.hospitalproject.hspt.model;

public enum StatusRequest {
    ACTIVE ("Активный"),
    WAIT ("Рассматривается"),
    END("Завершено");
    private final String statusTextDisplay;
    StatusRequest(String statusTextDisplay) {
        this.statusTextDisplay = statusTextDisplay;
    }

    public String getStatusTextDisplay(){return statusTextDisplay;}
}
