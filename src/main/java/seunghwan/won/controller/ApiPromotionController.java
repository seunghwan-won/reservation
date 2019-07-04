package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seunghwan.won.dto.Promotion;
import seunghwan.won.service.PromotionService;

import java.util.List;

@RestController
@RequestMapping(path = "api/promotions")
public class ApiPromotionController {
    @Autowired
    PromotionService promotionService;
    @GetMapping
    public List<Promotion> getPromotionList() {
        return promotionService.getPromotionList();
    }
}
