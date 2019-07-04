package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seunghwan.won.dto.Product;
import seunghwan.won.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "api/products")
public class ApiProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProductList() {
        return productService.getProductList();
    }
}
