package seunghwan.won.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "reviewWrite")
public class ReviewWriteController {
    @GetMapping()
    public String form() {
        return "reviewWrite";
    }
}
