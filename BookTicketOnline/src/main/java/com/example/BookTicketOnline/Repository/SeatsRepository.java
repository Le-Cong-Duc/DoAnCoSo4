package com.example.BookTicketOnline.Repository;

import com.example.BookTicketOnline.Entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, Integer> {
}
