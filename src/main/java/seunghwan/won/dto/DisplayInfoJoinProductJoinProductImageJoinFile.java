package seunghwan.won.dto;

import java.util.Objects;

public class DisplayInfoJoinProductJoinProductImageJoinFile {
    private int productId;
    private int productImageId;
    private int fileInfoId;
    private String type;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private boolean delete_flag;
    private String createDate;
    private String modifyDate;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(int productImageId) {
        this.productImageId = productImageId;
    }

    public int getFileInfoId() {
        return fileInfoId;
    }

    public void setFileInfoId(int fileInfoId) {
        this.fileInfoId = fileInfoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public boolean isDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(boolean delete_flag) {
        this.delete_flag = delete_flag;
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
        return "DisplayInfoJoinProductJoinProductImageJoinFile{" +
                "productId=" + productId +
                ", productImageId=" + productImageId +
                ", fileInfoId=" + fileInfoId +
                ", type='" + type + '\'' +
                ", fileName='" + fileName + '\'' +
                ", saveFileName='" + saveFileName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", delete_flag=" + delete_flag +
                ", createDate='" + createDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisplayInfoJoinProductJoinProductImageJoinFile that = (DisplayInfoJoinProductJoinProductImageJoinFile) o;
        return productId == that.productId &&
                productImageId == that.productImageId &&
                fileInfoId == that.fileInfoId &&
                delete_flag == that.delete_flag &&
                Objects.equals(type, that.type) &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(saveFileName, that.saveFileName) &&
                Objects.equals(contentType, that.contentType) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyDate, that.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productImageId, fileInfoId, type, fileName, saveFileName,
                contentType, delete_flag, createDate, modifyDate);
    }
}
