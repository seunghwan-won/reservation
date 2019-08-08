package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seunghwan.won.dto.DisplayInfo;
import seunghwan.won.service.DisplayInfoService;

@RestController
@RequestMapping(path = "api/reservation")
public class ApiDisplayInfoController {
    @Autowired
    DisplayInfoService displayInfoService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "{displayInfoId}")
    public DisplayInfo getDate(@PathVariable int displayInfoId) {
        return displayInfoService.getDisplayInfo(displayInfoId);
    }
}
