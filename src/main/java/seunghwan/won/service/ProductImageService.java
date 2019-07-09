package seunghwan.won.service;

import javax.servlet.http.HttpServletRequest;

public interface ProductImageService {
    byte[] getPromotionImageUrl(int productId, int productImageId, String type, HttpServletRequest request);

    byte[] getProductImageUrl(int id, String type, HttpServletRequest request);
}
