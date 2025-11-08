package com.example.BookTicketOnline.Controller;

import com.example.BookTicketOnline.Entity.Movies;
import com.example.BookTicketOnline.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class indexController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/UserPage")
    public String UserPage(Model model) {
        List<Movies> movies = moviesService.getAllMovies();

        System.out.println("Total movies: " + movies.size());

        model.addAttribute("movies", movies);

        return "User/index";
    }
}

