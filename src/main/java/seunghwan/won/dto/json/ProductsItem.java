package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductsItem {
    private long displayInfoID;
    private String placeName;
    private String productContent;
    private String productDescription;
    private long productID;
    private String productImageURL;

    @JsonProperty("displayInfoId")
    public long getDisplayInfoID() {
        return displayInfoID;
    }

    @JsonProperty("displayInfoId")
    public void setDisplayInfoID(long value) {
        this.displayInfoID = value;
    }

    @JsonProperty("placeName")
    public String getPlaceName() {
        return placeName;
    }

    @JsonProperty("placeName")
    public void setPlaceName(String value) {
        this.placeName = value;
    }

    @JsonProperty("productContent")
    public String getProductContent() {
        return productContent;
    }

    @JsonProperty("productContent")
    public void setProductContent(String value) {
        this.productContent = value;
    }

    @JsonProperty("productDescription")
    public String getProductDescription() {
        return productDescription;
    }

    @JsonProperty("productDescription")
    public void setProductDescription(String value) {
        this.productDescription = value;
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
