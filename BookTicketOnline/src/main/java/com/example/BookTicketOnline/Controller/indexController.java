package com.example.BookTicketOnline.Controller;

import com.example.BookTicketOnline.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public String index() {
        return "index";
    }


}

