package com.example.data.rest.datarest.service;

import com.example.data.rest.datarest.pojo.ReserveRoom;
import com.example.data.rest.datarest.pojo.ReservedRoom;

public interface ReserveRoomService {
    ReservedRoom reserveRoom(ReserveRoom reserveRoom);

    ReservedRoom roomStatus(Integer id);
}
