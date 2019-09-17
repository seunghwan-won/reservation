package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonProducts {
    private List<ProductsItem> items;
    private long totalCount;

    @JsonProperty("items")
    public List<ProductsItem> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<ProductsItem> value) {
        this.items = value;
    }

    @JsonProperty("totalCount")
    public long getTotalCount() {
        return totalCount;
    }

    @JsonProperty("totalCount")
    public void setTotalCount(long value) {
        this.totalCount = value;
    }
}
