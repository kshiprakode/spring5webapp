package web.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.springframework.spring5webapp.repositories.PublisherRepository;

@Controller
public class PublisherController {

    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping("/publishs")
    public String getPublisher(Model model) {
        model.addAttribute("publishs", publisherRepository.findAll());
        return "publishs";
    }
}
