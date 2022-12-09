package org.example.homework.mapper;

import org.example.homework.dto.ReservationDtoRq;
import org.example.homework.dto.ReservationDtoRs;
import org.example.homework.entity.Reservation;
import org.example.homework.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    @Autowired
    RoomRepository roomRepository;


    public Reservation castFromDto(ReservationDtoRq reservationDtoRq) {
        return new Reservation(
                roomRepository.findById(reservationDtoRq.getRoomId()).get(),
                reservationDtoRq.getDateFrom(),
                reservationDtoRq.getDateTo(),
                reservationDtoRq.getUserName()
        );
    }

    public ReservationDtoRs castToRs(Reservation reservation) {
        return ReservationDtoRs.builder().reservationNumber(reservation.getReservationNumber())
                .dateFrom(reservation.getDateFrom()).dateTo(reservation.getDateTo())
                .roomName(reservation.getRoom().getRoomName()).userName(reservation.getUserName()).build();
    }
}
