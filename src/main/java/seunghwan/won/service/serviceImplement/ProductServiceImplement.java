package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seunghwan.won.dao.ProductDao;
import seunghwan.won.dto.ProductJoinDisplayInfoJoinFileInfo;
import seunghwan.won.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImplement implements ProductService {
    @Autowired
    ProductDao productDao;


    @Override
    @Transactional
    public int getProductCount(Integer categoryId) {
        return categoryId == 0 ?  productDao.getTotalCount() : productDao.getTotalCount(categoryId);
    }

    @Override
    @Transactional
    public List<ProductJoinDisplayInfoJoinFileInfo> getProductList(Integer categoryId, Integer start) {
        return categoryId == 0 ? productDao.selectAll(start,ProductService.LIMIT):
                productDao.selectByCategoryId(categoryId, start, ProductService.LIMIT);
    }

}
