package seunghwan.won.dto;

import java.util.Objects;

public class ReservationUserCommentImage {
    private int id;
    private int reservationInfoId;
    private int reservationInfoCommentId;
    private int fileId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(int reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public int getReservationInfoCommentId() {
        return reservationInfoCommentId;
    }

    public void setReservationInfoCommentId(int reservationInfoCommentId) {
        this.reservationInfoCommentId = reservationInfoCommentId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "ReservationUserCommentImage{" +
                "id=" + id +
                ", reservationInfoId=" + reservationInfoId +
                ", reservationInfoCommentId=" + reservationInfoCommentId +
                ", fileId=" + fileId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationUserCommentImage that = (ReservationUserCommentImage) o;
        return id == that.id &&
                reservationInfoId == that.reservationInfoId &&
                reservationInfoCommentId == that.reservationInfoCommentId &&
                fileId == that.fileId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservationInfoId, reservationInfoCommentId, fileId);
    }
}
