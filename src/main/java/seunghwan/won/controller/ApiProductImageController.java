package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seunghwan.won.service.ProductImageService;

@RestController
@RequestMapping(path = "api/productImages")
public class ApiProductImageController {
    @Autowired
    private ProductImageService productImageService;

    @GetMapping(path = "{productId}/{productImageId}")
    public String imageUrl(@PathVariable(name = "productId") int productId, @PathVariable(name = "productImageId") int
            productImageId) {
        return productImageService.getImageUrl(productId, productImageId);
    }
}
