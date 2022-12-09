package org.example.homework.controller;

import org.example.homework.dto.ReservationDtoRq;
import org.example.homework.dto.ReservationDtoRs;
import org.example.homework.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/reservations/{userName}")
    public ResponseEntity getAllReservations(@PathVariable String userName) {
        List<ReservationDtoRs> reservations = reservationService.getAllReservationsByUser(userName);
        return new ResponseEntity(reservations, HttpStatus.OK);
    }

    @GetMapping("/reservation/{reservationNumber}")
    public ResponseEntity getReservationByNumber(@PathVariable UUID reservationNumber) {
        Optional<ReservationDtoRs> reservation = reservationService.getReservationByNumber(reservationNumber);
        return new ResponseEntity(reservation, HttpStatus.OK);
    }

    @PostMapping("/reserve")
    public ResponseEntity createReservation(@RequestBody ReservationDtoRq reservationDtoRq) {
        UUID uuid = reservationService.createReservation(reservationDtoRq);
        if (uuid == null ) {
            return new ResponseEntity("бронь существует", HttpStatus.I_AM_A_TEAPOT);
        } else {
            return new ResponseEntity(uuid, HttpStatus.OK);
        }
    }

    @GetMapping("/delete/{uuid}")
    public ResponseEntity deleteReservation(@PathVariable UUID uuid) {
        reservationService.delete(uuid);
        return ResponseEntity.ok().build();
    }

}
