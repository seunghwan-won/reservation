package seunghwan.won.dto;

import java.util.Objects;

public class Promotion {
    private int id;
    private int productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", productId=" + productId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promotion promotion = (Promotion) o;
        return id == promotion.id &&
                productId == promotion.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId);
    }
}
