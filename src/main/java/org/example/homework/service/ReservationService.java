package org.example.homework.service;

import org.example.homework.dto.ReservationDtoRq;
import org.example.homework.dto.ReservationDtoRs;
import org.example.homework.entity.Reservation;
import org.example.homework.mapper.ReservationMapper;
import org.example.homework.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationMapper reservationMapper;

    public UUID createReservation(ReservationDtoRq reservationDtoRq) {
          Reservation reservation = reservationMapper.castFromDto(reservationDtoRq);
          reservation.setReservationNumber(UUID.randomUUID());
          List<Reservation> check =
                  reservationRepository.findAllByRoomIdAndDateFromGreaterThanAndDateToLessThan(reservationDtoRq.getRoomId(), reservationDtoRq.getDateFrom(), reservationDtoRq.getDateTo());
            if (check.isEmpty()) {
                reservationRepository.save(reservation);
                return reservation.getReservationNumber();
            } else {
                return null;
            }
    }

    public List<ReservationDtoRs> getAllReservationsByUser(String userName) {
        return reservationRepository.findAllByUserName(userName).stream()
                .map(e -> reservationMapper.castToRs(e)).collect(Collectors.toList());
    }

    public Optional<ReservationDtoRs> getReservationByNumber(UUID number) {
        return reservationRepository.findByReservationNumber(number).map(e -> reservationMapper.castToRs(e));
    }

    @Transactional
    public void delete(UUID uuid) {
        reservationRepository.deleteByReservationNumber(uuid);
    }
}
