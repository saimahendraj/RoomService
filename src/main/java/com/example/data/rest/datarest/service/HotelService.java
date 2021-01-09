package com.example.data.rest.datarest.service;

import com.example.data.rest.datarest.pojo.Hotel;

import java.util.List;

public interface HotelService {
    Hotel getHotel(int id);

    Hotel getHotel(String hotelName, String roomNumber);

    Hotel save(Hotel hotel);

    List<Hotel> getHotels();
}
