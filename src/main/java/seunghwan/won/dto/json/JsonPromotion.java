package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonPromotion {
    private List<PromotionItem> items;

    @JsonProperty("items")
    public List<PromotionItem> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<PromotionItem> value) {
        this.items = value;
    }
}
