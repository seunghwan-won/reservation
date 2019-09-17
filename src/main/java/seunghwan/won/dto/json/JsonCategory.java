package seunghwan.won.dto.json;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class JsonCategory {
    private List<CategoryItem> categoryItems;

    @JsonProperty("categoryItems")
    public List<CategoryItem> getCategoryItems() { return categoryItems; }
    @JsonProperty("categoryItems")
    public void setCategoryItems(List<CategoryItem> value) { this.categoryItems = value; }
}