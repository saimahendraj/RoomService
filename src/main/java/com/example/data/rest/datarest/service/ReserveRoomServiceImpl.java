package com.example.data.rest.datarest.service;

import com.example.data.rest.datarest.exception.NotFoundException;
import com.example.data.rest.datarest.jpa.HotelEntity;
import com.example.data.rest.datarest.jpa.HotelJpaClient;
import com.example.data.rest.datarest.jpa.RoomStatus;
import com.example.data.rest.datarest.jpa.UserEntity;
import com.example.data.rest.datarest.pojo.Hotel;
import com.example.data.rest.datarest.pojo.ReserveRoom;
import com.example.data.rest.datarest.pojo.ReservedRoom;
import com.example.data.rest.datarest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class ReserveRoomServiceImpl implements ReserveRoomService {

    @Autowired
    HotelService hotelService;

    @Autowired
    UserService userService;

    @Autowired
    HotelJpaClient hotelJpaClient;

    public ReservedRoom reserveRoom(ReserveRoom reserveRoom) {
        User user = getUser(reserveRoom);
        Hotel hotel = hotelService.getHotel(reserveRoom.getHotelName(), reserveRoom.getRoomNumber());
        if ("OPEN".equals(hotel.getStatus())) {
            HotelEntity hotelEntity = getHotelEntity(user, hotel);
            HotelEntity savedEntity = hotelJpaClient.save(hotelEntity);
            return getReservedRoom(savedEntity);
        } else {
            throw new RuntimeException("Room Already Booked");
        }
    }

    @Override
    public ReservedRoom roomStatus(Integer id) {
        HotelEntity hotelEntity = hotelJpaClient.findById(id).orElseThrow(NotFoundException::new);
        return getReservedRoom(hotelEntity);
    }

    private ReservedRoom getReservedRoom(HotelEntity savedEntity) {
        return ReservedRoom.builder()
                .hotelName(savedEntity.getHotelName())
                .roomNumber(savedEntity.getRoomNumber())
                .status(savedEntity.getStatus().getValue())
                .userName(savedEntity.getUser().getName())
                .userBonusPoints(savedEntity.getUser().getBonusPoints())
                .build();
    }

    private HotelEntity getHotelEntity(User user, Hotel hotel) {
        if (user.getBonusPoints() > hotel.getRoomPrice()) {
            return getHotel(user, hotel, RoomStatus.BOOKED);
        } else {
            return getHotel(user, hotel, RoomStatus.PENDING);
        }
    }

    private HotelEntity getHotel(User user, Hotel hotel, RoomStatus status) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        long bonusPoints = user.getBonusPoints() - hotel.getRoomPrice();
        userEntity.setBonusPoints(bonusPoints > 0 ? bonusPoints : 0);
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setId(hotel.getId());
        hotelEntity.setHotelName(hotel.getHotelName());
        hotelEntity.setRoomNumber(hotel.getRoomNumber());
        hotelEntity.setRoomPrice(hotel.getRoomPrice());
        hotelEntity.setStatus(status);
        hotelEntity.setUser(userEntity);
        return hotelEntity;
    }

    private User getUser(ReserveRoom reserveRoom) {
        if (!ObjectUtils.isEmpty(reserveRoom.getUserId())) {
            return userService.getUser(reserveRoom.getUserId());
        } else if (!ObjectUtils.isEmpty(reserveRoom.getUserName())) {
            return userService.getUser(reserveRoom.getUserName());
        }
        throw new NotFoundException("user");
    }
}
