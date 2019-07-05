package seunghwan.won.dto;

import java.util.Objects;

public class ProductJoinDisplayInfoJoinFileInfo {
    private int displayInfoId;
    private int productId;
    private String productDescription;
    private String placeName;
    private String productContent;
    private String productImageUrl;

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    @Override
    public String toString() {
        return "ProductJoinDisplayInfoJoinFileInfo{" +
                "displayInfoId=" + displayInfoId +
                ", productId=" + productId +
                ", productDescription='" + productDescription + '\'' +
                ", placeName='" + placeName + '\'' +
                ", productContent='" + productContent + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductJoinDisplayInfoJoinFileInfo productJoinDisplayInfoJoinFileInfo = (ProductJoinDisplayInfoJoinFileInfo) o;
        return displayInfoId == productJoinDisplayInfoJoinFileInfo.displayInfoId &&
                productId == productJoinDisplayInfoJoinFileInfo.productId &&
                Objects.equals(productDescription, productJoinDisplayInfoJoinFileInfo.productDescription) &&
                Objects.equals(placeName, productJoinDisplayInfoJoinFileInfo.placeName) &&
                Objects.equals(productContent, productJoinDisplayInfoJoinFileInfo.productContent) &&
                Objects.equals(productImageUrl, productJoinDisplayInfoJoinFileInfo.productImageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayInfoId, productId, productDescription, placeName, productContent, productImageUrl);
    }
}
