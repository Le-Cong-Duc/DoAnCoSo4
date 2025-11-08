package com.example.BookTicketOnline.Controller;

import com.example.BookTicketOnline.Entity.Movies;
import com.example.BookTicketOnline.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class BookTicketController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping("/BookTicket/{movieId}")
    public String bookTicket(@PathVariable Integer movieId, Model model) {
        Movies movie = moviesService.getMovieById(movieId);
        if (movie == null) {
            return "redirect:/"; // Nếu không tìm thấy phim, quay về trang chủ
        }

        List<Map<String, String>> dates = generateDates();

        List<Map<String, String>> cinemas = Arrays.asList(
                createCinema("1", "Galaxy Nguyễn Du", "116 Nguyễn Du, Q1, TP.HCM"),
                createCinema("2", "Galaxy Sala", "Lầu 3, TTTM Sala, Q2, TP.HCM"),
                createCinema("3", "Galaxy Tân Bình", "246 Nguyễn Hồng Đào, Q.Tân Bình"),
                createCinema("4", "Galaxy Kinh Dương Vương", "718 Kinh Dương Vương, Q6")
        );

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

        return "User/BookTicket";
    }

    private List<Map<String, String>> generateDates() {
        List<Map<String, String>> dates = new ArrayList<>();
        LocalDate today = LocalDate.now();
        String[] dayNames = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};

        for (int i = 0; i < 7; i++) {
            LocalDate date = today.plusDays(i);
            String dayName = i == 0 ? "Hôm Nay" : dayNames[date.getDayOfWeek().getValue() % 7];
            String dateNumber = date.format(DateTimeFormatter.ofPattern("dd/MM"));
            String dateValue = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Map<String, String> dateMap = new HashMap<>();
            dateMap.put("dayName", dayName);
            dateMap.put("dateNumber", dateNumber);
            dateMap.put("dateValue", dateValue);
            dates.add(dateMap);
        }

        return dates;
    }

    private Map<String, String> createCinema(String id, String name, String address) {
        Map<String, String> cinema = new HashMap<>();
        cinema.put("id", id);
        cinema.put("name", name);
        cinema.put("address", address);
        return cinema;
    }

    private Map<String, String> createShowtime(String id, String timeSlot) {
        Map<String, String> showtime = new HashMap<>();
        showtime.put("id", id);
        showtime.put("timeSlot", timeSlot);
        return showtime;
    }
}
