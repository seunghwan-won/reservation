package seunghwan.won.dto;

import java.util.Date;
import java.util.Objects;

public class ProductPrice {
    private int id;
    private int produectId;
    private String priceTypeName;
    private int price;
    private double discountRate;
    private Date createDate;
    private Date modifyDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduectId() {
        return produectId;
    }

    public void setProduectId(int produectId) {
        this.produectId = produectId;
    }

    public String getPriceTypeName() {
        return priceTypeName;
    }

    public void setPriceTypeName(String priceTypeName) {
        this.priceTypeName = priceTypeName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "id=" + id +
                ", produectId=" + produectId +
                ", priceTypeName='" + priceTypeName + '\'' +
                ", price=" + price +
                ", discountRate=" + discountRate +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPrice that = (ProductPrice) o;
        return id == that.id &&
                produectId == that.produectId &&
                price == that.price &&
                Double.compare(that.discountRate, discountRate) == 0 &&
                Objects.equals(priceTypeName, that.priceTypeName) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyDate, that.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produectId, priceTypeName, price, discountRate, createDate, modifyDate);
    }
}
