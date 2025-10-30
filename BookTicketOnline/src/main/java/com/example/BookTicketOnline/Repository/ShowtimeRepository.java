package com.example.BookTicketOnline.Repository;

import com.example.BookTicketOnline.Entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, String> {
}
