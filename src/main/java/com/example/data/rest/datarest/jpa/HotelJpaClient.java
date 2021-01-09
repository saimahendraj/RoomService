package com.example.data.rest.datarest.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelJpaClient extends JpaRepository<HotelEntity, Integer> {
    Optional<HotelEntity> findByHotelNameAndAndRoomNumber(String hotelName, String roomNumber);
}
