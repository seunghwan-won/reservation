package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {
    private long count;
    private long productPriceID;
    private long reservationInfoID;
    private long reservationInfoPriceID;

    @JsonProperty("count")
    public long getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(long value) {
        this.count = value;
    }

    @JsonProperty("productPriceId")
    public long getProductPriceID() {
        return productPriceID;
    }

    @JsonProperty("productPriceId")
    public void setProductPriceID(long value) {
        this.productPriceID = value;
    }

    @JsonProperty("reservationInfoId")
    public long getReservationInfoID() {
        return reservationInfoID;
    }

    @JsonProperty("reservationInfoId")
    public void setReservationInfoID(long value) {
        this.reservationInfoID = value;
    }

    @JsonProperty("reservationInfoPriceId")
    public long getReservationInfoPriceID() {
        return reservationInfoPriceID;
    }

    @JsonProperty("reservationInfoPriceId")
    public void setReservationInfoPriceID(long value) {
        this.reservationInfoPriceID = value;
    }
}
