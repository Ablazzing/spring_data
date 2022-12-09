package org.example.homework.repository;

import org.example.homework.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUserName(String userName);
    Optional<Reservation> findByReservationNumber(UUID reservationNumber);
    List<Reservation> findAllByRoomIdAndDateFromGreaterThanAndDateToLessThan(Long roomId, Date start, Date to);
    void deleteByReservationNumber(UUID uuid);
}
