package com.example.BookTicketOnline.Service;

import com.example.BookTicketOnline.Repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsService {
    @Autowired
    private RoomsRepository roomsRepository;
}
