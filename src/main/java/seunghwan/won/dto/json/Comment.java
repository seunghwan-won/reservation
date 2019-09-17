package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Comment {
    private String comment;
    private long commentID;
    private List<CommentImage> commentImages;
    private String createDate;
    private String modifyDate;
    private long productID;
    private String reservationDate;
    private String reservationEmail;
    private long reservationInfoID;
    private String reservationName;
    private String reservationTelephone;
    private long score;

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String value) {
        this.comment = value;
    }

    @JsonProperty("commentId")
    public long getCommentID() {
        return commentID;
    }

    @JsonProperty("commentId")
    public void setCommentID(long value) {
        this.commentID = value;
    }

    @JsonProperty("commentImages")
    public List<CommentImage> getCommentImages() {
        return commentImages;
    }

    @JsonProperty("commentImages")
    public void setCommentImages(List<CommentImage> value) {
        this.commentImages = value;
    }

    @JsonProperty("createDate")
    public String getCreateDate() {
        return createDate;
    }

    @JsonProperty("createDate")
    public void setCreateDate(String value) {
        this.createDate = value;
    }

    @JsonProperty("modifyDate")
    public String getModifyDate() {
        return modifyDate;
    }

    @JsonProperty("modifyDate")
    public void setModifyDate(String value) {
        this.modifyDate = value;
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

    @JsonProperty("score")
    public long getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(long value) {
        this.score = value;
    }
}
