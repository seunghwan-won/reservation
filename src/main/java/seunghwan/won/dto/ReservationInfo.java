package seunghwan.won.dto;

import java.util.Date;
import java.util.Objects;

public class ReservationInfo {
    private int id;
    private int productId;
    private int displayInfoId;
    private String reservationName;
    private String reservationTel;
    private String reservationEmail;
    private Date reservationDatel;
    private int cancelFlag;
    private Date createDate;
    private Date modifyDate;

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

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationTel() {
        return reservationTel;
    }

    public void setReservationTel(String reservationTel) {
        this.reservationTel = reservationTel;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public Date getReservationDatel() {
        return reservationDatel;
    }

    public void setReservationDatel(Date reservationDatel) {
        this.reservationDatel = reservationDatel;
    }

    public int getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(int cancelFlag) {
        this.cancelFlag = cancelFlag;
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
        return "ReservationInfo{" +
                "id=" + id +
                ", productId=" + productId +
                ", displayInfoId=" + displayInfoId +
                ", reservationName='" + reservationName + '\'' +
                ", reservationTel='" + reservationTel + '\'' +
                ", reservationEmail='" + reservationEmail + '\'' +
                ", reservationDatel=" + reservationDatel +
                ", cancelFlag=" + cancelFlag +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationInfo that = (ReservationInfo) o;
        return id == that.id &&
                productId == that.productId &&
                displayInfoId == that.displayInfoId &&
                cancelFlag == that.cancelFlag &&
                Objects.equals(reservationName, that.reservationName) &&
                Objects.equals(reservationTel, that.reservationTel) &&
                Objects.equals(reservationEmail, that.reservationEmail) &&
                Objects.equals(reservationDatel, that.reservationDatel) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyDate, that.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, displayInfoId, reservationName, reservationTel, reservationEmail, reservationDatel, cancelFlag, createDate, modifyDate);
    }
}
