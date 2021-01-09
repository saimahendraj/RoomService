package com.example.data.rest.datarest.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "HOTEL")
public class HotelEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "HOTEL_NAME")
    private String hotelName;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    @Column(name = "ROOM_PRICE")
    private Long roomPrice;

    @Column(name = "STATUS")
    private RoomStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user", referencedColumnName = "id")
    private UserEntity user;
}
