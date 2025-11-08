package com.example.BookTicketOnline.Controller;

import com.example.BookTicketOnline.Entity.Movies;
import com.example.BookTicketOnline.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class UserController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping("/UserPage")
    public String userPage(Model model) {
        List<Movies> movies = moviesService.getAllMovies();
        model.addAttribute("movies", movies);

        return "User/index";
    }
}
