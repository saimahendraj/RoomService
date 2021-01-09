package com.example.data.rest.datarest.service;

import com.example.data.rest.datarest.exception.NotFoundException;
import com.example.data.rest.datarest.jpa.HotelEntity;
import com.example.data.rest.datarest.jpa.HotelJpaClient;
import com.example.data.rest.datarest.jpa.RoomStatus;
import com.example.data.rest.datarest.pojo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelJpaClient hotelJpaClient;

    @Override
    public Hotel getHotel(int id) {
        HotelEntity hotelEntity = hotelJpaClient.findById(id).orElseThrow(NotFoundException::new);
        return getHotel(hotelEntity);
    }

    @Override
    public Hotel getHotel(String hotelName, String roomNumber) {
        HotelEntity hotelEntity = hotelJpaClient.findByHotelNameAndAndRoomNumber(hotelName, roomNumber).orElseThrow(NotFoundException::new);
        return getHotel(hotelEntity);
    }

    @Override
    public Hotel save(Hotel hotel) {
        HotelEntity entity = new HotelEntity();
        entity.setHotelName(hotel.getHotelName());
        entity.setRoomPrice(hotel.getRoomPrice());
        entity.setRoomNumber(hotel.getRoomNumber());
        entity.setStatus(RoomStatus.OPEN);
        HotelEntity save = hotelJpaClient.save(entity);
        return getHotel(save);
    }

    @Override
    public List<Hotel> getHotels() {
        return hotelJpaClient.findAll().stream().map(this::getHotel).collect(Collectors.toList());
    }

    private Hotel getHotel(HotelEntity hotelEntity) {
        return Hotel.builder()
                .id(hotelEntity.getId())
                .hotelName(hotelEntity.getHotelName())
                .roomNumber(hotelEntity.getRoomNumber())
                .roomPrice(hotelEntity.getRoomPrice())
                .status(hotelEntity.getStatus().getValue())
                .build();
    }
}
