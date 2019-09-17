package seunghwan.won.dto;

import java.util.Date;
import java.util.Objects;

public class FileInfo {
    private int id;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private int deleteFlag;
    private Date createDate;
    private Date modifyDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
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
        return "FileInfo{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", saveFileName='" + saveFileName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileInfo fileInfo = (FileInfo) o;
        return id == fileInfo.id &&
                deleteFlag == fileInfo.deleteFlag &&
                Objects.equals(fileName, fileInfo.fileName) &&
                Objects.equals(saveFileName, fileInfo.saveFileName) &&
                Objects.equals(contentType, fileInfo.contentType) &&
                Objects.equals(createDate, fileInfo.createDate) &&
                Objects.equals(modifyDate, fileInfo.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName, saveFileName, contentType, deleteFlag, createDate, modifyDate);
    }
}
