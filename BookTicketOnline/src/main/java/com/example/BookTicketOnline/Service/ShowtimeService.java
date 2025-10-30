package com.example.BookTicketOnline.Service;

import com.example.BookTicketOnline.Repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeService {
    @Autowired
    private ShowtimeRepository showtimeRepository;
}
