package org.example.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column(unique = true)
    private UUID reservationNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    @NonNull
    private Room room;

    @NonNull
    private Date dateFrom;

    @NonNull
    private Date dateTo;

    @NonNull
    private String userName;

    public Reservation(@NonNull Room room, @NonNull Date dateFrom, @NonNull Date dateTo, @NonNull String userName) {
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.userName = userName;
    }
}
