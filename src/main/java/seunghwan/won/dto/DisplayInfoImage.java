package seunghwan.won.dto;

import java.util.Objects;

public class DisplayInfoImage {
    private int id;
    private int displayInfoId;
    private int fileId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "DisplayInfoImage{" +
                "id=" + id +
                ", displayInfoId=" + displayInfoId +
                ", fileId=" + fileId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisplayInfoImage that = (DisplayInfoImage) o;
        return id == that.id &&
                displayInfoId == that.displayInfoId &&
                fileId == that.fileId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, displayInfoId, fileId);
    }
}
