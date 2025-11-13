package com.example.BookTicketOnline.Service;

import com.example.BookTicketOnline.Entity.Cinemas;
import com.example.BookTicketOnline.Repository.CinemasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemasService {
    @Autowired
    private CinemasRepository cinemasRepository;

    public List<Cinemas> getAllCinema() {
        return cinemasRepository.findAll();
    }
}
