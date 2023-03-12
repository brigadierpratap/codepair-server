package com.example.codepair.controller;

import com.example.codepair.model.ResponseDTO;
import com.example.codepair.model.Room;
import com.example.codepair.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseDTO> getRoom(@PathVariable String id){
        try{
            Room room = roomService.find(id);
            return new ResponseEntity<>(
                    ResponseDTO.builder()
                            .success(Boolean.TRUE)
                            .message("Room fetched!")
                            .data(room)
                            .build(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(
                    ResponseDTO.builder()
                            .success(Boolean.FALSE)
                            .message(e.getMessage())
                            .data(null)
                            .build(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping@CrossOrigin
    public ResponseEntity<ResponseDTO> createRoom() {
        try {
            Room room = roomService.createRoom();
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .message("Room Created")
                    .data(room)
                    .success(Boolean.TRUE)
                    .build();

            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .message(e.getMessage())
                    .data(null)
                    .success(Boolean.FALSE)
                    .build();

            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
