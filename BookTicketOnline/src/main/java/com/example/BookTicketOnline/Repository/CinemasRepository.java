package com.example.BookTicketOnline.Repository;

import com.example.BookTicketOnline.Entity.Cinemas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemasRepository extends JpaRepository<Cinemas, Integer> {
}
