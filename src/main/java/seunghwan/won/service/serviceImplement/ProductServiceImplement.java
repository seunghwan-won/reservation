package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.ProductDao;
import seunghwan.won.dto.Product;
import seunghwan.won.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImplement implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getProductList() {
        return productDao.selectAll();
    }
}
