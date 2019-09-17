package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class    JsonComment {
    private String comment;
    private long commentID;
    private CommentImage commentImage;
    private String createDate;
    private String modifyDate;
    private long productID;
    private long reservationInfoID;
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

    @JsonProperty("commentImage")
    public CommentImage getCommentImage() {
        return commentImage;
    }

    @JsonProperty("commentImage")
    public void setCommentImage(CommentImage value) {
        this.commentImage = value;
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

    @JsonProperty("reservationInfoId")
    public long getReservationInfoID() {
        return reservationInfoID;
    }

    @JsonProperty("reservationInfoId")
    public void setReservationInfoID(long value) {
        this.reservationInfoID = value;
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
