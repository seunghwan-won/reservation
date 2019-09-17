package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonReservationCreation {
    private boolean cancelYn;
    private String createDate;
    private long displayInfoID;
    private String modifyDate;
    private List<Price> prices;
    private long productID;
    private String reservationDate;
    private String reservationEmail;
    private long reservationInfoID;
    private String reservationName;
    private String reservationTelephone;

    @JsonProperty("cancelYn")
    public boolean getCancelYn() {
        return cancelYn;
    }

    @JsonProperty("cancelYn")
    public void setCancelYn(boolean value) {
        this.cancelYn = value;
    }

    @JsonProperty("createDate")
    public String getCreateDate() {
        return createDate;
    }

    @JsonProperty("createDate")
    public void setCreateDate(String value) {
        this.createDate = value;
    }

    @JsonProperty("displayInfoId")
    public long getDisplayInfoID() {
        return displayInfoID;
    }

    @JsonProperty("displayInfoId")
    public void setDisplayInfoID(long value) {
        this.displayInfoID = value;
    }

    @JsonProperty("modifyDate")
    public String getModifyDate() {
        return modifyDate;
    }

    @JsonProperty("modifyDate")
    public void setModifyDate(String value) {
        this.modifyDate = value;
    }

    @JsonProperty("prices")
    public List<Price> getPrices() {
        return prices;
    }

    @JsonProperty("prices")
    public void setPrices(List<Price> value) {
        this.prices = value;
    }

    @JsonProperty("productId")
    public long getProductID() {
        return productID;
    }

    @JsonProperty("productId")
    public void setProductID(long value) {
        this.productID = value;
    }

    @JsonProperty("reservationDate")
    public String getReservationDate() {
        return reservationDate;
    }

    @JsonProperty("reservationDate")
    public void setReservationDate(String value) {
        this.reservationDate = value;
    }

    @JsonProperty("reservationEmail")
    public String getReservationEmail() {
        return reservationEmail;
    }

    @JsonProperty("reservationEmail")
    public void setReservationEmail(String value) {
        this.reservationEmail = value;
    }

    @JsonProperty("reservationInfoId")
    public long getReservationInfoID() {
        return reservationInfoID;
    }

    @JsonProperty("reservationInfoId")
    public void setReservationInfoID(long value) {
        this.reservationInfoID = value;
    }

    @JsonProperty("reservationName")
    public String getReservationName() {
        return reservationName;
    }

    @JsonProperty("reservationName")
    public void setReservationName(String value) {
        this.reservationName = value;
    }

    @JsonProperty("reservationTelephone")
    public String getReservationTelephone() {
        return reservationTelephone;
    }

    @JsonProperty("reservationTelephone")
    public void setReservationTelephone(String value) {
        this.reservationTelephone = value;
    }
}
