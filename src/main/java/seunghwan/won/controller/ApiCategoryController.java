package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seunghwan.won.dto.Category;
import seunghwan.won.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(path = "api/categories")
public class ApiCategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getCategoryList() {
        return categoryService.selectAll();
    }
}
