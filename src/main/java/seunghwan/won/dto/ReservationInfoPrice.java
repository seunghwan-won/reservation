package seunghwan.won.dto;

import java.util.Objects;

public class ReservationInfoPrice {
    private int id;
    private int reservationInfoId;
    private int productPriceId;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(int reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public int getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(int productPriceId) {
        this.productPriceId = productPriceId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ReservationInfoPrice{" +
                "id=" + id +
                ", reservationInfoId=" + reservationInfoId +
                ", productPriceId=" + productPriceId +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationInfoPrice that = (ReservationInfoPrice) o;
        return id == that.id &&
                reservationInfoId == that.reservationInfoId &&
                productPriceId == that.productPriceId &&
                count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservationInfoId, productPriceId, count);
    }
}
