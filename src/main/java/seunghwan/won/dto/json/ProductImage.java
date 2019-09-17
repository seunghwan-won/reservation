package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductImage {
    private String contentType;
    private String createDate;
    private boolean deleteFlag;
    private long fileInfoID;
    private String fileName;
    private String modifyDate;
    private long productID;
    private long productImageID;
    private String saveFileName;
    private String type;

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

    @JsonProperty("fileInfoId")
    public long getFileInfoID() {
        return fileInfoID;
    }

    @JsonProperty("fileInfoId")
    public void setFileInfoID(long value) {
        this.fileInfoID = value;
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

    @JsonProperty("productId")
    public long getProductID() {
        return productID;
    }

    @JsonProperty("productId")
    public void setProductID(long value) {
        this.productID = value;
    }

    @JsonProperty("productImageId")
    public long getProductImageID() {
        return productImageID;
    }

    @JsonProperty("productImageId")
    public void setProductImageID(long value) {
        this.productImageID = value;
    }

    @JsonProperty("saveFileName")
    public String getSaveFileName() {
        return saveFileName;
    }

    @JsonProperty("saveFileName")
    public void setSaveFileName(String value) {
        this.saveFileName = value;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String value) {
        this.type = value;
    }
}
