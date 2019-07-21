package seunghwan.won.dto;

import java.util.List;
import java.util.Objects;

public class DisplayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfo {
    private int commentId;
    private int productId;
    private int reservationInfoId;
    private float score;
    private String reservationName;
    private String reservationTelephone;
    private String reservationEmail;
    private String reservationDate;
    private String comment;
    private List<ReservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfo> commentImages;
    private String createDate;
    private String modifyDate;

    public int getCommentId() {
        return commentId;
    }

    public List<ReservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfo> getCommentImages() {
        return commentImages;
    }

    public void setCommentImages(List<ReservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfo> commentImages) {
        this.commentImages = commentImages;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(int reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationTelephone() {
        return reservationTelephone;
    }

    public void setReservationTelephone(String reservationTelephone) {
        this.reservationTelephone = reservationTelephone;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "DisplayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfo{" +
                "commentId=" + commentId +
                ", productId=" + productId +
                ", reservationInfoId=" + reservationInfoId +
                ", score=" + score +
                ", reservationName='" + reservationName + '\'' +
                ", reservationTelephone='" + reservationTelephone + '\'' +
                ", reservationEmail='" + reservationEmail + '\'' +
                ", reservationDate='" + reservationDate + '\'' +
                ", comment='" + comment + '\'' +
                ", commentImages=" + commentImages +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisplayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfo that =
                (DisplayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfo) o;
        return commentId == that.commentId &&
                productId == that.productId &&
                reservationInfoId == that.reservationInfoId &&
                Float.compare(that.score, score) == 0 &&
                Objects.equals(reservationName, that.reservationName) &&
                Objects.equals(reservationTelephone, that.reservationTelephone) &&
                Objects.equals(reservationEmail, that.reservationEmail) &&
                Objects.equals(reservationDate, that.reservationDate) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(commentImages, that.commentImages) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyDate, that.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, productId, reservationInfoId, score, reservationName, reservationTelephone,
                reservationEmail, reservationDate, comment, commentImages, createDate, modifyDate);
    }
}
