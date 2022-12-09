package org.example.homework.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class ReservationDtoRs {
    private UUID reservationNumber;
    private String roomName;
    private Date dateFrom;
    private Date dateTo;
    private String userName;
}
