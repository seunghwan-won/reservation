package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPrice {
    private String createDate;
    private long discountRate;
    private String modifyDate;
    private long price;
    private String priceTypeName;
    private long productID;
    private long productPriceID;

    @JsonProperty("createDate")
    public String getCreateDate() {
        return createDate;
    }

    @JsonProperty("createDate")
    public void setCreateDate(String value) {
        this.createDate = value;
    }

    @JsonProperty("discountRate")
    public long getDiscountRate() {
        return discountRate;
    }

    @JsonProperty("discountRate")
    public void setDiscountRate(long value) {
        this.discountRate = value;
    }

    @JsonProperty("modifyDate")
    public String getModifyDate() {
        return modifyDate;
    }

    @JsonProperty("modifyDate")
    public void setModifyDate(String value) {
        this.modifyDate = value;
    }

    @JsonProperty("price")
    public long getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(long value) {
        this.price = value;
    }

    @JsonProperty("priceTypeName")
    public String getPriceTypeName() {
        return priceTypeName;
    }

    @JsonProperty("priceTypeName")
    public void setPriceTypeName(String value) {
        this.priceTypeName = value;
    }

    @JsonProperty("productId")
    public long getProductID() {
        return productID;
    }

    @JsonProperty("productId")
    public void setProductID(long value) {
        this.productID = value;
    }

    @JsonProperty("productPriceId")
    public long getProductPriceID() {
        return productPriceID;
    }

    @JsonProperty("productPriceId")
    public void setProductPriceID(long value) {
        this.productPriceID = value;
    }
}
