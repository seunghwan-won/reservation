package seunghwan.won.dto;

import java.util.Objects;

public class PromotionJoinProductJoinProductImageJoinFileInfo {
    private int productId;
    private int promotionId;
    private String productImageUrl;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    @Override
    public String toString() {
        return "PromotionJoinProductJoinProductImageJoinFileInfo{" +
                "productId=" + productId +
                ", promotionId=" + promotionId +
                ", productImageUrl='" + productImageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionJoinProductJoinProductImageJoinFileInfo that = (PromotionJoinProductJoinProductImageJoinFileInfo) o;
        return productId == that.productId &&
                promotionId == that.promotionId &&
                Objects.equals(productImageUrl, that.productImageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, promotionId, productImageUrl);
    }
}
