package com.example.BookTicketOnline.Repository;

import com.example.BookTicketOnline.Entity.Rooms;
import com.example.BookTicketOnline.Entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SeatsRepository extends JpaRepository<Seats, Integer> {

}
