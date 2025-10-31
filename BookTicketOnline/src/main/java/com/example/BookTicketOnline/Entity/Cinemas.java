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
@Table(name = "cinemas")
public class Cinemas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    private Integer cinemaId;

    @Column(name = "cinema_name")
    private String cinemaName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "hotline")
    private String hotline;

    @OneToMany(mappedBy = "cinemaId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Rooms> rooms;

}
