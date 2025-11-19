package com.example.BookTicketOnline.Repository;

import com.example.BookTicketOnline.Entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {
    @Query(value = "SELECT st.* FROM showtime st " +
            "JOIN rooms r ON st.room_id = r.room_id " +
            "JOIN cinemas c ON r.cinema_id = c.cinema_id " +
            "WHERE c.cinema_id = :cinemaId " +
            "AND st.movie_id = :movieId " +
            "AND DATE(st.start_time) = :date " +
            "ORDER BY r.room_name, st.start_time",
            nativeQuery = true)
    List<Showtime> findByCinemaMovieAndDate(
            @Param("cinemaId") Integer cinemaId,
            @Param("movieId") Integer movieId,
            @Param("date") LocalDate date
    );

    @Query(value = "SELECT st.* FROM showtime st " +
            "WHERE st.movie_id = :movieId " +
            "ORDER BY st.start_time",
            nativeQuery = true)
    List<Showtime> findByMovieId(@Param("movieId") Integer movieId);
}