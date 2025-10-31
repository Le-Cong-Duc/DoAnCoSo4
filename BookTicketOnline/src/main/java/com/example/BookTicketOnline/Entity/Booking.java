package com.example.BookTicketOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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


}
