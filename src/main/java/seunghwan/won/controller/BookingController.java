package seunghwan.won.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "booking")
public class BookingController {
    @GetMapping
    public String test() {
        return "bookinglogin";
    }
}
