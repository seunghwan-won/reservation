package seunghwan.won.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "reservation")
public class ReservationController {
    @GetMapping
    public String myReservation() {
        return "myreservation";
    }
}