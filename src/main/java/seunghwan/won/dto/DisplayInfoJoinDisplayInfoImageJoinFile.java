package seunghwan.won.dto;

import java.util.Objects;

public class DisplayInfoJoinDisplayInfoImageJoinFile {
    private int displayInfoImageId;
    private int displayInfoId;
    private int fileId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private boolean deleteFlag;
    private String createDate;
    private String modifyDate;

    public int getDisplayInfoImageId() {
        return displayInfoImageId;
    }

    public void setDisplayInfoImageId(int displayInfoImageId) {
        this.displayInfoImageId = displayInfoImageId;
    }

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
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

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
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
        return "DisplayInfoJoinDisplayInfoImageJoinFile{" +
                "displayInfoImageId=" + displayInfoImageId +
                ", displayInfoId=" + displayInfoId +
                ", fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", saveFileName='" + saveFileName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", createDate='" + createDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisplayInfoJoinDisplayInfoImageJoinFile that = (DisplayInfoJoinDisplayInfoImageJoinFile) o;
        return displayInfoImageId == that.displayInfoImageId &&
                displayInfoId == that.displayInfoId &&
                fileId == that.fileId &&
                deleteFlag == that.deleteFlag &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(saveFileName, that.saveFileName) &&
                Objects.equals(contentType, that.contentType) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyDate, that.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayInfoImageId, displayInfoId, fileId, fileName, saveFileName, contentType, deleteFlag,
                createDate, modifyDate);
    }
}
