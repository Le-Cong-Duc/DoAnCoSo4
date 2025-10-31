package com.example.BookTicketOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seats")
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Rooms roomId;

    @Column(name = "seat_row")
    private Integer seatRow;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "status")
    private Integer status;
}
