package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.ProductDao;
import seunghwan.won.dto.ProductJoinDisplayInfoJoinFileInfo;
import seunghwan.won.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImplement implements ProductService {
    @Autowired
    ProductDao productDao;


    @Override
    public int getProductCount(Integer categoryId) {
        return categoryId == 0 ? 0 : productDao.getTotalCount(categoryId);
    }

    @Override
    public List<ProductJoinDisplayInfoJoinFileInfo> getProductList(Integer categoryId, Integer start) {
        return categoryId == 0 ? new ArrayList<>() :
                productDao.selectAll(categoryId, start, ProductService.LIMIT);
    }

}