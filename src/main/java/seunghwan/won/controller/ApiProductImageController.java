package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import seunghwan.won.service.ProductImageService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(path = "api/productImages")
public class ApiProductImageController {
    @Autowired
    private ProductImageService productImageService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "{productId}/{productImageId}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getPromotionImage(@PathVariable(name = "productId", required = true) int productId,
                             @PathVariable(name = "productImageId", required = true) int productImageId,
                             @RequestParam(name = "type", required = false, defaultValue = "ma") String type,
                             HttpServletRequest request) {
        return productImageService.getPromotionImageUrl(productId, productImageId, type, request);
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getProductImage(
            @PathVariable(name = "id", required = true) int id,
            @RequestParam(name = "type", required = true, defaultValue = "th") String type,
            HttpServletRequest request) throws IOException {
        return productImageService.getProductImageUrl(id, type, request);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "detail/img/{resourcePath}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getProductImageByUrl(
            @PathVariable(name = "resourcePath", required = true) String resourcePath, HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder("img/");
        sb.append(resourcePath);
        sb.append(".png");
        return productImageService.getProductImageUrl(sb.toString(), request);
    }
}