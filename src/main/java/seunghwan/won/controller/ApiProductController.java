package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import seunghwan.won.dto.ProductJoinDisplayInfoJoinFileInfo;
import seunghwan.won.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/products")
public class ApiProductController {
    @Autowired
    ProductService productService;

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
}
