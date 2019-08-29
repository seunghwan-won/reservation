package seunghwan.won.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Data {
    private int displayInfoId;
    private List<ReservationInfoPrice> prices;
    private int productId;
    private String reservationEmail;
    private String reservationName;
    private String reservationTel;
    private String reservationYearMonthDay;

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public List<ReservationInfoPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ReservationInfoPrice> prices) {
        this.prices = prices;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    @JsonProperty("reservationTelephone")
    public String getReservationTel() {
        return reservationTel;
    }

    public void setReservationTel(String reservationTel) {
        this.reservationTel = reservationTel;
    }

    public String getReservationYearMonthDay() {
        return reservationYearMonthDay;
    }

    public void setReservationYearMonthDay(String reservationYearMonthDay) {
        this.reservationYearMonthDay = reservationYearMonthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return displayInfoId == data.displayInfoId &&
                productId == data.productId &&
                Objects.equals(prices, data.prices) &&
                Objects.equals(reservationEmail, data.reservationEmail) &&
                Objects.equals(reservationName, data.reservationName) &&
                Objects.equals(reservationTel, data.reservationTel) &&
                Objects.equals(reservationYearMonthDay, data.reservationYearMonthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayInfoId, prices, productId, reservationEmail, reservationName,
                reservationTel, reservationYearMonthDay);
    }

    @Override
    public String toString() {
        return "Data{" +
                "displayInfoId=" + displayInfoId +
                ", prices=" + prices +
                ", productId=" + productId +
                ", reservationEmail='" + reservationEmail + '\'' +
                ", reservationName='" + reservationName + '\'' +
                ", reservationTel='" + reservationTel + '\'' +
                ", reservationYearMonthDay='" + reservationYearMonthDay + '\'' +
                '}';
    }
}
