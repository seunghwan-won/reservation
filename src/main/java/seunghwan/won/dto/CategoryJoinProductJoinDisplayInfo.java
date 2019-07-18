package seunghwan.won.dto;

import java.util.Objects;

public class CategoryJoinProductJoinDisplayInfo {
    private int productId;
    private int categoryId;
    private int displayInfoId;
    private String categoryName;
    private String productDescription;
    private String productContent;
    private String productEvent;
    private String openingHours;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String telephone;
    private String homepage;
    private String email;
    private String createDate;
    private String modifyDate;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getProductEvent() {
        return productEvent;
    }

    public void setProductEvent(String productEvent) {
        this.productEvent = productEvent;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLot() {
        return placeLot;
    }

    public void setPlaceLot(String placeLot) {
        this.placeLot = placeLot;
    }

    public String getPlaceStreet() {
        return placeStreet;
    }

    public void setPlaceStreet(String placeStreet) {
        this.placeStreet = placeStreet;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "CategoryJoinProductJoinDisplayInfo{" +
                "productId=" + productId +
                ", categoryId=" + categoryId +
                ", displayInfoId=" + displayInfoId +
                ", categoryName='" + categoryName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productContent='" + productContent + '\'' +
                ", productEvent='" + productEvent + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeLot='" + placeLot + '\'' +
                ", placeStreet='" + placeStreet + '\'' +
                ", telephone='" + telephone + '\'' +
                ", homepage='" + homepage + '\'' +
                ", email='" + email + '\'' +
                ", createDate='" + createDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryJoinProductJoinDisplayInfo that = (CategoryJoinProductJoinDisplayInfo) o;
        return productId == that.productId &&
                categoryId == that.categoryId &&
                displayInfoId == that.displayInfoId &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(productDescription, that.productDescription) &&
                Objects.equals(productContent, that.productContent) &&
                Objects.equals(productEvent, that.productEvent) &&
                Objects.equals(openingHours, that.openingHours) &&
                Objects.equals(placeName, that.placeName) &&
                Objects.equals(placeLot, that.placeLot) &&
                Objects.equals(placeStreet, that.placeStreet) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(homepage, that.homepage) &&
                Objects.equals(email, that.email) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyDate, that.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, categoryId, displayInfoId, categoryName, productDescription, productContent, productEvent, openingHours, placeName, placeLot, placeStreet, telephone, homepage, email, createDate, modifyDate);
    }
}
