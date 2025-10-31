package com.example.BookTicketOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Duration showtimeId;

    @Column(name = "genre")
    private Integer genre;

    @Column(name = "director")
    private String director;

    @Column(name = "casts")
    private String casts;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "language")
    private String language;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "banner_url")
    private String bannerUrl;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "age_limit")
    private Integer ageLimit;

    @OneToMany(mappedBy = "movieId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Showtime> showtimes;

    @OneToMany(mappedBy = "movieId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Review> reviews;
}
