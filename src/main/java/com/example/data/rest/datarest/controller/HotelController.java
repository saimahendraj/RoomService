package com.example.data.rest.datarest.controller;

import com.example.data.rest.datarest.pojo.Hotel;
import com.example.data.rest.datarest.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelService service;

    @GetMapping("/hotel/{id}")
    public Hotel getHotel(@PathVariable int id) {
        return service.getHotel(id);
    }

    @GetMapping("/hotel")
    public List<Hotel> getHotel() {
        return service.getHotels();
    }

    @PostMapping("/hotel")
    public Hotel saveHotel(@RequestBody Hotel hotel) {
        return service.save(hotel);
    }
}
