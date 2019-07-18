package seunghwan.won.dto;

import java.util.Date;
import java.util.Objects;

public class DisplayInfoJoinProductJoinProductPrice {
    private int productPriceId;
    private int productId;
    private String priceTypeName;
    private int price;
    private int discountRate;
    private Date createDate;
    private Date modifyDate;

    public int getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(int productPriceId) {
        this.productPriceId = productPriceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPriceTypeName() {
        return priceTypeName;
    }

    public void setPriceTypeName(String priceTypeName) {
        this.priceTypeName = priceTypeName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "DisplayInfoJoinProductJoinProductPrice{" +
                "productPriceId=" + productPriceId +
                ", productId=" + productId +
                ", priceTypeName='" + priceTypeName + '\'' +
                ", price=" + price +
                ", discountRate=" + discountRate +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisplayInfoJoinProductJoinProductPrice that = (DisplayInfoJoinProductJoinProductPrice) o;
        return productPriceId == that.productPriceId &&
                productId == that.productId &&
                price == that.price &&
                discountRate == that.discountRate &&
                Objects.equals(priceTypeName, that.priceTypeName) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyDate, that.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPriceId, productId, priceTypeName, price, discountRate, createDate, modifyDate);
    }
}
