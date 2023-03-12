package com.example.codepair.service;

import com.example.codepair.model.Room;
import com.example.codepair.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;
    public Room createRoom(){
        Room room = new Room();
        return roomRepository.save(room);
    }

    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }
    @Async
    public void saveRoomAsync(Room room){
        roomRepository.save(room);
    }

    public Room find(String id) throws Exception {
        Optional<Room> roomOptional =  roomRepository.findById(id);
        if(roomOptional.isPresent())return roomOptional.get();
        else throw new Exception("ROOM_NOT_FOUND");
    }
}
