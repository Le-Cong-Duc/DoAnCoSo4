package com.example.BookTicketOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
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

    public Users() {
    }

    public Users(Integer userId, String userName, String email, String password, String numberPhone, Integer role, List<Review> reviews, List<Booking> bookings) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.numberPhone = numberPhone;
        this.role = role;
        this.reviews = reviews;
        this.bookings = bookings;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
