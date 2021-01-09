package com.example.data.rest.datarest.jpa;

public enum RoomStatus {
    OPEN("OPEN"), PENDING("PENDING_APPROVAL"), BOOKED("BOOKED");

    RoomStatus(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return this.value;
    }
}
