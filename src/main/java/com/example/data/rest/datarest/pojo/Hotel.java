package com.example.data.rest.datarest.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hotel {
    private Integer id;

    private String hotelName;

    private String roomNumber;

    private Long roomPrice;

    private String status;

}
