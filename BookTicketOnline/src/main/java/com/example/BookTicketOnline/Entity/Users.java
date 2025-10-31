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
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "number_phone")
    private String numberPhone;

    @Column(name = "role")
    private Integer role;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Booking> bookings;
}
