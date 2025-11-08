package com.example.BookTicketOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtimeId;

    @Column(name = "total_bill")
    private Double totalBill;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    @Column(name = "payment_status")
    private Integer paymentStatus;

    @Column(name = "payment_method")
    private Integer paymentMethod;

    public Booking() {
    }

    public Booking(Integer bookingId, Users userId, Showtime showtimeId, Double totalBill, LocalDateTime bookingTime, Integer paymentStatus, Integer paymentMethod) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.showtimeId = showtimeId;
        this.totalBill = totalBill;
        this.bookingTime = bookingTime;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Showtime getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Showtime showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
