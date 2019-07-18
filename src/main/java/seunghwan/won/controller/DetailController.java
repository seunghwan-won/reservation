package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import seunghwan.won.service.DetailService;

@Controller
@RequestMapping(path = "detail")
public class DetailController {
    @Autowired
    DetailService detailService;

    @GetMapping()
    public String detailPage(@RequestParam(name = "id", required = true) int productId) {
        return "detail";
    }
}
