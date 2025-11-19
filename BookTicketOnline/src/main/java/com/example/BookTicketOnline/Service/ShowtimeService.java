package com.example.BookTicketOnline.Service;

import com.example.BookTicketOnline.Entity.Cinemas;
import com.example.BookTicketOnline.Entity.Movies;
import com.example.BookTicketOnline.Entity.Showtime;
import com.example.BookTicketOnline.Repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showTimeRepository;

    public List<Showtime> getShowtimeByCinemaMovieAndDate(Integer cinemaId, Integer movieId, LocalDate date) {
        return showTimeRepository.findByCinemaMovieAndDate(cinemaId, movieId, date);
    }

    public Showtime getShowtimeById(Integer showtimeId) {
        return showTimeRepository.findById(showtimeId).orElse(null);
    }

    public List<Showtime> getShowtimesByMovie(Integer movieId) {
        return showTimeRepository.findByMovieId(movieId);
    }
}