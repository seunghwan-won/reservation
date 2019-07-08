package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.ProductImageDao;
import seunghwan.won.service.ProductImageService;

import java.util.Map;

@Service
public class ProductImageServiceImplement implements ProductImageService {
    @Autowired
    private ProductImageDao productImageDao;

    @Override
    public String getImageUrl(int productId, int productImageId) {
        return productImageDao.getUrl(productId, productImageId);

    }
}
