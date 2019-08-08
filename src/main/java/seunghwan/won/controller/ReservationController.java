package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import seunghwan.won.service.DisplayInfoService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(path = "reservation")
public class ReservationController {
    @Autowired
    DisplayInfoService displayInfoService;

    private List<Long> values = Arrays.asList(-5l, -4l, -3l, -2l, -1l, 1l, 2l, 3l, 4l, 5l);

    @GetMapping
    public String myReservation(@RequestParam(name = "id", required = true) int displayInfoId, Model model) {
        model.addAttribute("displayInfo", displayInfoService.getDisplayInfo(displayInfoId));
        Collections.shuffle(values);
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(values.get(0));
        model.addAttribute("year", localDateTime.getYear());
        model.addAttribute("month", localDateTime.getMonthValue());
        model.addAttribute("day", localDateTime.getDayOfMonth());
        return "reserve";
    }
}
