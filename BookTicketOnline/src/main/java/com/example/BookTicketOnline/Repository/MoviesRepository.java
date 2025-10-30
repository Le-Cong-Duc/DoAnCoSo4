package com.example.BookTicketOnline.Repository;

import com.example.BookTicketOnline.Entity.Booking;
import com.example.BookTicketOnline.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, String> {
}
