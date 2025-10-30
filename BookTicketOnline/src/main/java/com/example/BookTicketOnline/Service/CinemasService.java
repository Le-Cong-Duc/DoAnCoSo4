package com.example.BookTicketOnline.Service;

import com.example.BookTicketOnline.Repository.CinemasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemasService {
    @Autowired
    private CinemasRepository cinemasRepository;
}
