package com.example.BookTicketOnline.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
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
    private Duration duration;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

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

    @OneToMany(mappedBy = "movieId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Showtime> showtimes;

    @OneToMany(mappedBy = "movieId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Review> reviews;

    public Movies() {
    }

    public Movies(Integer movieId, String movieName, String description, Duration duration, Set<Genre> genres, String director, String casts, LocalDate releaseDate, String language, String posterUrl, String bannerUrl, Integer rating, Integer ageLimit) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.description = description;
        this.duration = duration;
        this.genres = genres;
        this.director = director;
        this.casts = casts;
        this.releaseDate = releaseDate;
        this.language = language;
        this.posterUrl = posterUrl;
        this.bannerUrl = bannerUrl;
        this.rating = rating;
        this.ageLimit = ageLimit;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCasts() {
        return casts;
    }

    public void setCasts(String casts) {
        this.casts = casts;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public List<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(List<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
