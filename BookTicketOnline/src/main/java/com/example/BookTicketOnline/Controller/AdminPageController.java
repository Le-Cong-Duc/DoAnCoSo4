package com.example.BookTicketOnline.Controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminPageController {

    @GetMapping({ "/admin", "/admin/" })
    public String adminIndex() {
        return "Admin/index";
    }

    @GetMapping("/admin/{page}")
    public String adminIndexWithPage(@PathVariable String page) {
        return "Admin/index";
    }

    @GetMapping(path = "/admin/{page}.html", produces = MediaType.TEXT_HTML_VALUE)
    public String serveAdminPageHtml(@PathVariable String page, Model model) {
        return "Admin/" + page;
    }

    @GetMapping(path = "/admin/admin/{page}.html", produces = MediaType.TEXT_HTML_VALUE)
    public String serveAdminPrefixedPageHtml(@PathVariable String page, Model model) {
        return "Admin/" + page;
    }
}
