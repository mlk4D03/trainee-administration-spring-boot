package com.trivadis.administration.trainee.service;

import com.trivadis.administration.trainee.dto.RoomDTO;
import com.trivadis.administration.trainee.entities.Habitat;
import com.trivadis.administration.trainee.entities.Room;
import com.trivadis.administration.trainee.repository.HabitatRepository;
import com.trivadis.administration.trainee.repository.RoomRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomService {

    private RoomRepository roomRepository;

    private HabitatRepository habitatRepository;

    public RoomService(RoomRepository roomRepository, HabitatRepository habitatRepository) {
        this.roomRepository = roomRepository;
        this.habitatRepository = habitatRepository;
    }

    public Room saveRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setCapacity(roomDTO.getCapacity());
        Habitat habitat = this.habitatRepository.findById(roomDTO.getHabitat()).orElse(null);
        room.setHabitat(habitat);
        return this.roomRepository.save(room);
    }

    public Room findRoomById(Long roomId) {
        return this.roomRepository.findById(roomId).orElse(null);
    }

    public List<Room> getAllRooms() {
        return (List<Room>) this.roomRepository.findAll();
    }
}
