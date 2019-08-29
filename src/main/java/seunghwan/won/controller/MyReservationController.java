package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import seunghwan.won.service.ReservationService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "myReservation")
public class MyReservationController {
    @Autowired
    ReservationService reservationService;
    @GetMapping()
    public String myReservation(@RequestParam(name = "resrv_email", required = true) String email, HttpSession session) {
        session.setAttribute("userEmail", email);
        return "myreservation";
    }
}
