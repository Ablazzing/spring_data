package org.example.homework.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReservationDtoRq {
    private Long roomId;
    private Date dateFrom;
    private Date dateTo;
    private String userName;
}
