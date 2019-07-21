package seunghwan.won.service.serviceImplement;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seunghwan.won.dao.ProductImageDao;
import seunghwan.won.service.ProductImageService;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ProductImageServiceImplement implements ProductImageService {
    @Autowired
    private ProductImageDao productImageDao;

    @Override
    @Transactional
    public byte[] getPromotionImageUrl(int productId, int productImageId, String type, HttpServletRequest request) {
        String url = productImageDao.getPromotionImageUrl(productId, productImageId, type);
        return getBytes(request, url);
    }

    @Override
    @Transactional
    public byte[] getProductImageUrl(int productId, String type, HttpServletRequest request) {
        String url = productImageDao.getProductImageUrl(productId, type);
        return getBytes(request, url);
    }

    @Override
    @Transactional
    public byte[] getProductImageUrl(String imagePath, HttpServletRequest request) {
        return getBytes(request, imagePath);
    }

    private byte[] getBytes(HttpServletRequest request, String url) {
        String imagePath = request.getServletContext().getRealPath("resource/" + url);
        InputStream imageStream = null;
        byte[] imageByteArray = null;
        try {
            imageStream = new FileInputStream(imagePath);
            imageByteArray = IOUtils.toByteArray(imageStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                imageStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageByteArray;
    }
}
