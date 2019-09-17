package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisplayInfo {
    private long categoryID;
    private String categoryName;
    private String createDate;
    private long displayInfoID;
    private String email;
    private String homepage;
    private String modifyDate;
    private String openingHours;
    private String placeLot;
    private String placeName;
    private String placeStreet;
    private String productContent;
    private String productDescription;
    private String productEvent;
    private long productID;
    private String telephone;

    @JsonProperty("categoryId")
    public long getCategoryID() { return categoryID; }
    @JsonProperty("categoryId")
    public void setCategoryID(long value) { this.categoryID = value; }

    @JsonProperty("categoryName")
    public String getCategoryName() { return categoryName; }
    @JsonProperty("categoryName")
    public void setCategoryName(String value) { this.categoryName = value; }

    @JsonProperty("createDate")
    public String getCreateDate() { return createDate; }
    @JsonProperty("createDate")
    public void setCreateDate(String value) { this.createDate = value; }

    @JsonProperty("displayInfoId")
    public long getDisplayInfoID() { return displayInfoID; }
    @JsonProperty("displayInfoId")
    public void setDisplayInfoID(long value) { this.displayInfoID = value; }

    @JsonProperty("email")
    public String getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(String value) { this.email = value; }

    @JsonProperty("homepage")
    public String getHomepage() { return homepage; }
    @JsonProperty("homepage")
    public void setHomepage(String value) { this.homepage = value; }

    @JsonProperty("modifyDate")
    public String getModifyDate() { return modifyDate; }
    @JsonProperty("modifyDate")
    public void setModifyDate(String value) { this.modifyDate = value; }

    @JsonProperty("openingHours")
    public String getOpeningHours() { return openingHours; }
    @JsonProperty("openingHours")
    public void setOpeningHours(String value) { this.openingHours = value; }

    @JsonProperty("placeLot")
    public String getPlaceLot() { return placeLot; }
    @JsonProperty("placeLot")
    public void setPlaceLot(String value) { this.placeLot = value; }

    @JsonProperty("placeName")
    public String getPlaceName() { return placeName; }
    @JsonProperty("placeName")
    public void setPlaceName(String value) { this.placeName = value; }

    @JsonProperty("placeStreet")
    public String getPlaceStreet() { return placeStreet; }
    @JsonProperty("placeStreet")
    public void setPlaceStreet(String value) { this.placeStreet = value; }

    @JsonProperty("productContent")
    public String getProductContent() { return productContent; }
    @JsonProperty("productContent")
    public void setProductContent(String value) { this.productContent = value; }

    @JsonProperty("productDescription")
    public String getProductDescription() { return productDescription; }
    @JsonProperty("productDescription")
    public void setProductDescription(String value) { this.productDescription = value; }

    @JsonProperty("productEvent")
    public String getProductEvent() { return productEvent; }
    @JsonProperty("productEvent")
    public void setProductEvent(String value) { this.productEvent = value; }

    @JsonProperty("productId")
    public long getProductID() { return productID; }
    @JsonProperty("productId")
    public void setProductID(long value) { this.productID = value; }

    @JsonProperty("telephone")
    public String getTelephone() { return telephone; }
    @JsonProperty("telephone")
    public void setTelephone(String value) { this.telephone = value; }
}
