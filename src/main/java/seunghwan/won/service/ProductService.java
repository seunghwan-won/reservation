package seunghwan.won.service;

import seunghwan.won.dto.ProductJoinDisplayInfoJoinFileInfo;

import java.util.List;

public interface ProductService {
    Integer LIMIT = 4;

    int getProductCount(Integer categoryId);

    List<ProductJoinDisplayInfoJoinFileInfo> getProductList(Integer categoryId, Integer start);

}
