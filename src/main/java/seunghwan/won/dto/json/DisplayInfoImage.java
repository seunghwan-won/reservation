package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisplayInfoImage {
    private String contentType;
    private String createDate;
    private boolean deleteFlag;
    private long displayInfoID;
    private long displayInfoImageID;
    private long fileID;
    private String fileName;
    private String modifyDate;
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

    @JsonProperty("displayInfoId")
    public long getDisplayInfoID() {
        return displayInfoID;
    }

    @JsonProperty("displayInfoId")
    public void setDisplayInfoID(long value) {
        this.displayInfoID = value;
    }

    @JsonProperty("displayInfoImageId")
    public long getDisplayInfoImageID() {
        return displayInfoImageID;
    }

    @JsonProperty("displayInfoImageId")
    public void setDisplayInfoImageID(long value) {
        this.displayInfoImageID = value;
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

    @JsonProperty("modifyDate")
    public String getModifyDate() {
        return modifyDate;
    }

    @JsonProperty("modifyDate")
    public void setModifyDate(String value) {
        this.modifyDate = value;
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
