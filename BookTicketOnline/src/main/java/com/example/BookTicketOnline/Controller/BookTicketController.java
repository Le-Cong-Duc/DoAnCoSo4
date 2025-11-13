package com.example.BookTicketOnline.Controller;

import com.example.BookTicketOnline.Entity.Cinemas;
import com.example.BookTicketOnline.Entity.Genre;
import com.example.BookTicketOnline.Entity.Movies;
import com.example.BookTicketOnline.Service.CinemasService;
import com.example.BookTicketOnline.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class BookTicketController {
    @Autowired
    private MoviesService moviesService;

    @Autowired
    private CinemasService cinemasService;

    @GetMapping("/BookTicket/{movieId}")
    public String bookTicket(@PathVariable Integer movieId, Model model) {
        Movies movie = moviesService.getMovieById(movieId);
        List<Cinemas> cinemas = cinemasService.getAllCinema();

        if (movie == null) {
            return "redirect:/"; // Nếu không tìm thấy phim, quay về trang chủ
        }

        List<Map<String, String>> dates = generateShowDates(movie.getReleaseDate(), movie.getEndDate());

        System.out.println(dates);

        List<Map<String, String>> showtimes = Arrays.asList(
                createShowtime("1", "14:00"),
                createShowtime("2", "14:45"),
                createShowtime("3", "17:00"),
                createShowtime("4", "19:00"),
                createShowtime("5", "20:15"),
                createShowtime("6", "22:15")
        );

        List<String> seatRows = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");
        List<Integer> seatCols = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> occupiedSeats = Arrays.asList("A5", "A6", "B5", "B6", "C3", "D7", "D8", "E4", "E5");

        model.addAttribute("movie", movie);
        model.addAttribute("dates", dates);
        model.addAttribute("cinemas", cinemas);
        model.addAttribute("showtimes", showtimes);
        model.addAttribute("seatRows", seatRows);
        model.addAttribute("seatCols", seatCols);
        model.addAttribute("occupiedSeats", occupiedSeats);

        return "User/BookTicketPage";
    }

    private Map<String, String> createShowtime(String id, String timeSlot) {
        Map<String, String> showtime = new HashMap<>();
        showtime.put("id", id);
        showtime.put("timeSlot", timeSlot);
        return showtime;
    }

    private List<Map<String, String>> generateShowDates(LocalDate releaseDate, LocalDate endDate) {
        List<Map<String, String>> dates = new ArrayList<>();
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM");
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("EEEE", new Locale("vi"));

        LocalDate actualEndDate = endDate != null ? endDate : releaseDate.plusDays(30);
        if (actualEndDate.isBefore(releaseDate)) actualEndDate = releaseDate;

        // Chỉ lấy từ hôm nay (nếu phim đã chiếu rồi)
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
