package com.example.data.rest.datarest.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "USER")
public class UserEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BONUS_POINTS")
    private Long bonusPoints;

    @OneToOne(mappedBy = "user")
    private HotelEntity hotelEntity;
}
