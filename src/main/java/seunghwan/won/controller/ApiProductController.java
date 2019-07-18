package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seunghwan.won.dto.ProductJoinDisplayInfoJoinFileInfo;
import seunghwan.won.service.DetailService;
import seunghwan.won.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/products")
public class ApiProductController {
    @Autowired
    ProductService productService;

    @Autowired
    DetailService detailService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public Map<String, Object> getProductList(@RequestParam(name = "categoryId", required = false, defaultValue = "0") Integer categoryId,
                                              @RequestParam(name = "start", required = false, defaultValue = "0") Integer start) {
        Map<String, Object> result = new HashMap<>();
        List<ProductJoinDisplayInfoJoinFileInfo> productJoinDisplayInfoJoinFileInfoList = productService.getProductList(categoryId, start);
        int totalCount = productService.getProductCount(categoryId);
        result.put("totalCount", totalCount);
        result.put("items", productJoinDisplayInfoJoinFileInfoList);
        return result;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "{displayInfoId}")
    public Map<String, Object> detailPage(@PathVariable(name = "displayInfoId") int displayInfoId) {
        return detailService.getDetail(displayInfoId);
    }
}
