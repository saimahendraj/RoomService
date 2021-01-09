package com.example.data.rest.datarest.controller;

import com.example.data.rest.datarest.pojo.ReserveRoom;
import com.example.data.rest.datarest.pojo.ReservedRoom;
import com.example.data.rest.datarest.service.ReserveRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReserveRoomController {

    @Autowired
    private ReserveRoomService reserveRoomService;

    @PostMapping("/reserve")
    public ReservedRoom reserveRoom(@RequestBody ReserveRoom reserveRoom) {
        return reserveRoomService.reserveRoom(reserveRoom);
    }

    @GetMapping("/room/status/{id}")
    public ReservedRoom status(@PathVariable Integer id) {
        return reserveRoomService.roomStatus(id);
    }
}
