package com.example.BookTicketOnline.Service;

import com.example.BookTicketOnline.Repository.BookingRepository;
import com.example.BookTicketOnline.Repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatsService {
    @Autowired
    private SeatsRepository seatsRepository;
}
