package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentImage {
    private String contentType;
    private String createDate;
    private boolean deleteFlag;
    private long fileID;
    private String fileName;
    private long imageID;
    private String modifyDate;
    private long reservationInfoID;
    private long reservationUserCommentID;
    private String saveFileName;

    @JsonProperty("contentType")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("contentType")
    public void setContentType(String value) {
        this.contentType = value;
    }

    @JsonProperty("createDate")
    public String getCreateDate() {
        return createDate;
    }

    @JsonProperty("createDate")
    public void setCreateDate(String value) {
        this.createDate = value;
    }

    @JsonProperty("deleteFlag")
    public boolean getDeleteFlag() {
        return deleteFlag;
    }

    @JsonProperty("deleteFlag")
    public void setDeleteFlag(boolean value) {
        this.deleteFlag = value;
    }

    @JsonProperty("fileId")
    public long getFileID() {
        return fileID;
    }

    @JsonProperty("fileId")
    public void setFileID(long value) {
        this.fileID = value;
    }

    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("fileName")
    public void setFileName(String value) {
        this.fileName = value;
    }

    @JsonProperty("imageId")
    public long getImageID() {
        return imageID;
    }

    @JsonProperty("imageId")
    public void setImageID(long value) {
        this.imageID = value;
    }

    @JsonProperty("modifyDate")
    public String getModifyDate() {
        return modifyDate;
    }

    @JsonProperty("modifyDate")
    public void setModifyDate(String value) {
        this.modifyDate = value;
    }

    @JsonProperty("reservationInfoId")
    public long getReservationInfoID() {
        return reservationInfoID;
    }

    @JsonProperty("reservationInfoId")
    public void setReservationInfoID(long value) {
        this.reservationInfoID = value;
    }

    @JsonProperty("reservationUserCommentId")
    public long getReservationUserCommentID() {
        return reservationUserCommentID;
    }

    @JsonProperty("reservationUserCommentId")
    public void setReservationUserCommentID(long value) {
        this.reservationUserCommentID = value;
    }

    @JsonProperty("saveFileName")
    public String getSaveFileName() {
        return saveFileName;
    }

    @JsonProperty("saveFileName")
    public void setSaveFileName(String value) {
        this.saveFileName = value;
    }
}
