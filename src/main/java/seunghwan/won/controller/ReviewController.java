package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import seunghwan.won.service.DetailService;

import java.util.Map;

@Controller
@RequestMapping(path = "review")
public class ReviewController {
    @Autowired
    DetailService detailService;

    @GetMapping()
    public String reviewPage(@RequestParam(name = "id", required = true) int productId, Model model) {
        Map<String, Object> result = detailService.getDetail(productId);
        model.addAttribute("commentList", result.get("comments"));
        model.addAttribute("displayInfo", result.get("displayInfo"));
        model.addAttribute("averageScore", result.get("averageScore"));
        return "review";
    }
}
