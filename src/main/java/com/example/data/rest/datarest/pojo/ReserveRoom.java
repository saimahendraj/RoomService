package com.example.data.rest.datarest.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReserveRoom {

    private String hotelName;

    private String roomNumber;

    private String userName;

    private Integer userId;
}
