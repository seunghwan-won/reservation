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
@RequestMapping(path = "detail")
public class DetailController {
    @Autowired
    DetailService detailService;

    @GetMapping()
    public String detailPage(@RequestParam(name = "id", required = true) int productId, Model model) {
        Map<String, Object> result = detailService.getDetail(productId);
        System.out.println(result.get("productImages"));
        System.out.println(result.get("displayInfo"));
        System.out.println(result.get("averageScore"));
        System.out.println(result.get("comments"));
        model.addAttribute("productImageList", result.get("productImages"));
        model.addAttribute("displayInfo", result.get("displayInfo"));
        model.addAttribute("averageScore", result.get("averageScore"));
        model.addAttribute("commentList", result.get("comments"));
        return "detail";
    }
}
