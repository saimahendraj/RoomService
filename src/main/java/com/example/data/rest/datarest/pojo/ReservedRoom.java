package com.example.data.rest.datarest.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservedRoom {

    private String hotelName;

    private String roomNumber;

    private String status;

    private String userName;

    private Long userBonusPoints;
}
