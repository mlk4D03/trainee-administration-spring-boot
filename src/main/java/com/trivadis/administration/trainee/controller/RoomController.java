package com.trivadis.administration.trainee.controller;

import com.trivadis.administration.trainee.dto.RoomDTO;
import com.trivadis.administration.trainee.entities.Room;
import com.trivadis.administration.trainee.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public RoomDTO saveRoom(@RequestBody RoomDTO roomDTO) {
        return transformToRoomDTO(this.roomService.saveRoom(roomDTO));
    }

    @GetMapping("/{roomId}")
    public RoomDTO getRoomById(@PathVariable Long roomId) {
        return transformToRoomDTO(this.roomService.findRoomById(roomId));
    }

    @GetMapping("/allRooms")
    public List<RoomDTO> getAllRooms() {
        List<Room> rooms = this.roomService.getAllRooms();
        return rooms.stream().map(this::transformToRoomDTO).collect(Collectors.toList());
    }

    private RoomDTO transformToRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setRoomNumber(room.getRoomNumber());
        roomDTO.setCapacity(room.getCapacity());
        if (room.getHabitat() != null) {
            roomDTO.setHabitat(room.getHabitat().getId());
        }
        return roomDTO;
    }
}
