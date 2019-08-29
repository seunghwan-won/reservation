package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seunghwan.won.dto.Data;
import seunghwan.won.dto.ReservationInfo;
import seunghwan.won.service.ReservationService;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping(path = "api/myReservation")
public class ApiMyReservationContorller {
    @Autowired
    ReservationService reservationService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping()
    public Map<String, Object> myReservation(@RequestParam(name = "resrv_email", required = true) String email, HttpSession session) {
        session.setAttribute("userEmail", email);
        return reservationService.getReservations(email);
    }

    @PostMapping()
    public int insertReservation(@RequestBody Data data) {
        System.out.println(data);
        return reservationService.insert(data);
    }

    @PutMapping(path = "{reservationId}")
    public ReservationInfo cancel(@PathVariable(name = "reservationId") int reservationInfoId) {
        return reservationService.cancel(reservationInfoId);
    }
}
