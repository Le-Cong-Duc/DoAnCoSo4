package com.example.BookTicketOnline.Service;

import com.example.BookTicketOnline.Entity.Movies;
import com.example.BookTicketOnline.Repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }
}
