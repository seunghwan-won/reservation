package seunghwan.won.dto;

import java.util.Date;
import java.util.Objects;

public class ReservationUserComment {
    private int id;
    private int productId;
    private int reservation_info_id;
    private double score;
    private String comment;
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

    public int getReservation_info_id() {
        return reservation_info_id;
    }

    public void setReservation_info_id(int reservation_info_id) {
        this.reservation_info_id = reservation_info_id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        return "ReservationUserComment{" +
                "id=" + id +
                ", productId=" + productId +
                ", reservation_info_id=" + reservation_info_id +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationUserComment that = (ReservationUserComment) o;
        return id == that.id &&
                productId == that.productId &&
                reservation_info_id == that.reservation_info_id &&
                Double.compare(that.score, score) == 0 &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyDate, that.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, reservation_info_id, score, comment, createDate, modifyDate);
    }
}
