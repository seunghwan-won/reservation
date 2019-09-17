package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonDisplayInfo {
    private long averageScore;
    private List<Comment> comments;
    private DisplayInfo displayInfo;
    private DisplayInfoImage displayInfoImage;
    private List<ProductImage> productImages;
    private List<ProductPrice> productPrices;

    @JsonProperty("averageScore")
    public long getAverageScore() {
        return averageScore;
    }

    @JsonProperty("averageScore")
    public void setAverageScore(long value) {
        this.averageScore = value;
    }

    @JsonProperty("comments")
    public List<Comment> getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(List<Comment> value) {
        this.comments = value;
    }

    @JsonProperty("displayInfo")
    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    @JsonProperty("displayInfo")
    public void setDisplayInfo(DisplayInfo value) {
        this.displayInfo = value;
    }

    @JsonProperty("displayInfoImage")
    public DisplayInfoImage getDisplayInfoImage() {
        return displayInfoImage;
    }

    @JsonProperty("displayInfoImage")
    public void setDisplayInfoImage(DisplayInfoImage value) {
        this.displayInfoImage = value;
    }

    @JsonProperty("productImages")
    public List<ProductImage> getProductImages() {
        return productImages;
    }

    @JsonProperty("productImages")
    public void setProductImages(List<ProductImage> value) {
        this.productImages = value;
    }

    @JsonProperty("productPrices")
    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    @JsonProperty("productPrices")
    public void setProductPrices(List<ProductPrice> value) {
        this.productPrices = value;
    }
}
