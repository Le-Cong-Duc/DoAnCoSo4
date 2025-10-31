package com.example.BookTicketOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinemas cinemaId;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "seat_rows")
    private Integer seatRows;

    @Column(name = "seat_columns")
    private Integer seatColumns;

    @OneToMany(mappedBy = "roomId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Showtime> showtimes;

    @OneToMany(mappedBy = "roomId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seats> seats;


}
