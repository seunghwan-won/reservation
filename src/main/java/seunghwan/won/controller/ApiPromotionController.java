package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seunghwan.won.service.PromotionService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/promotions")
public class ApiPromotionController {
    @Autowired
    PromotionService promotionService;

    @GetMapping
    public Map<String, List> getPromotionList() {
        return promotionService.getPromotionList();
    }
}
