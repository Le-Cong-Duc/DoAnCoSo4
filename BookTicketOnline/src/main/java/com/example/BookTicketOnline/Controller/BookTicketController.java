package com.example.BookTicketOnline.Controller;

import com.example.BookTicketOnline.Entity.*;
import com.example.BookTicketOnline.Service.CinemasService;
import com.example.BookTicketOnline.Service.MoviesService;
import com.example.BookTicketOnline.Service.SeatsService;
import com.example.BookTicketOnline.Service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class BookTicketController {
    @Autowired
    private MoviesService moviesService;
    @Autowired
    private CinemasService cinemasService;
    @Autowired
    private ShowtimeService showTimeService;
    @Autowired
    private SeatsService seatsService;
    @GetMapping("/BookTicket/{movieId}")
    public String bookTicket(@PathVariable Integer movieId,
                             @RequestParam(required = false) String date,
                             Model model) {
        Movies movie = moviesService.getMovieById(movieId);

        if (movie == null) {
            return "redirect:/";
        }

        List<Map<String, String>> dates = generateShowDates(movie.getReleaseDate(), movie.getEndDate());

        String selectedDate = (date != null) ? date : LocalDate.now().toString();

        List<Map<String, Object>> cinemasWithShowtimes = getCinemasWithShowtimes(movieId, selectedDate);

        System.out.println("Cinemas with showtimes count: " + cinemasWithShowtimes.size());
        System.out.println("===================================");

        model.addAttribute("movie", movie);
        model.addAttribute("dates", dates);
        model.addAttribute("cinemasWithShowtimes", cinemasWithShowtimes);
        model.addAttribute("selectedDate", selectedDate);

        return "User/BookTicketPage";
    }


    private List<Map<String, Object>> getCinemasWithShowtimes(Integer movieId, String dateStr) {
        List<Map<String, Object>> result = new ArrayList<>();
        LocalDate selectedDate = LocalDate.parse(dateStr);

        // Get all cinemas
        List<Cinemas> cinemas = cinemasService.getAllCinema();

        for (Cinemas cinema : cinemas) {
            // Get showtimes for this cinema, movie and date
            List<Showtime> showtimes = showTimeService.getShowtimeByCinemaMovieAndDate(cinema.getCinemaId(), movieId, selectedDate);

            if (!showtimes.isEmpty()) {
                Map<String, Object> cinemaData = new HashMap<>();
                cinemaData.put("cinema", cinema);

                // Group showtimes by room
                Map<String, List<Map<String, Object>>> roomShowtimes = new LinkedHashMap<>();

                for (Showtime showtime : showtimes) {
                    Rooms room = showtime.getRoomId();
                    String roomKey = room.getRoomName();

                    if (!roomShowtimes.containsKey(roomKey)) {
                        roomShowtimes.put(roomKey, new ArrayList<>());
                    }

                    Map<String, Object> showtimeData = new HashMap<>();
                    showtimeData.put("showtimeId", showtime.getShowtimeId());
                    showtimeData.put("startTime", showtime.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm")));
                    showtimeData.put("price", showtime.getPrice());
                    showtimeData.put("roomId", room.getRoomId());

                    roomShowtimes.get(roomKey).add(showtimeData);
                }

                for (List<Map<String, Object>> times : roomShowtimes.values()) {
                    times.sort(Comparator.comparing(t -> (String) t.get("startTime")));
                }

                cinemaData.put("roomShowtimes", roomShowtimes);
                result.add(cinemaData);
            }
        }

        return result;
    }

    private List<Map<String, String>> generateShowDates(LocalDate releaseDate, LocalDate endDate) {
        List<Map<String, String>> dates = new ArrayList<>();
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM");
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("EEEE", new Locale("vi"));

        LocalDate actualEndDate = endDate != null ? endDate : releaseDate.plusDays(30);
        if (actualEndDate.isBefore(releaseDate)) actualEndDate = releaseDate;

        LocalDate startDate = releaseDate.isBefore(today) ? today : releaseDate;

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(actualEndDate)) {
            Map<String, String> dateMap = new HashMap<>();

            String dayName;
            if (currentDate.equals(today)) {
                dayName = "Hôm nay";
            } else if (currentDate.equals(today.plusDays(1))) {
                dayName = "Ngày mai";
            } else {
                dayName = capitalizeFirst(dayFormatter.format(currentDate));
            }

            dateMap.put("dayName", dayName);
            dateMap.put("dateNumber", dateFormatter.format(currentDate));
            dateMap.put("dateValue", currentDate.toString());
            dateMap.put("status", currentDate.equals(today) ? "today" : "future");

            dates.add(dateMap);
            currentDate = currentDate.plusDays(1);
        }

        return dates;
    }

    private String capitalizeFirst(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}