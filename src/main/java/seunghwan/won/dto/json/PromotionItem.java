package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PromotionItem {
    private long id;
    private long productID;
    private String productImageURL;

    @JsonProperty("id")
    public long getID() {
        return id;
    }

    @JsonProperty("id")
    public void setID(long value) {
        this.id = value;
    }

    @JsonProperty("productId")
    public long getProductID() {
        return productID;
    }

    @JsonProperty("productId")
    public void setProductID(long value) {
        this.productID = value;
    }

    @JsonProperty("productImageUrl")
    public String getProductImageURL() {
        return productImageURL;
    }

    @JsonProperty("productImageUrl")
    public void setProductImageURL(String value) {
        this.productImageURL = value;
    }
}
