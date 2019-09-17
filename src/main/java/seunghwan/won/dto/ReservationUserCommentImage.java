package seunghwan.won.dto;

import java.util.Objects;

public class ReservationUserCommentImage {
    private int id;
    private int reservationInfoId;
    private int reservationUserCommentId;
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

    public int getReservationUserCommentId() {
        return reservationUserCommentId;
    }

    public void setReservationUserCommentId(int reservationUserCommentId) {
        this.reservationUserCommentId = reservationUserCommentId;
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
                ", reservationUserCommentId=" + reservationUserCommentId +
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
                reservationUserCommentId == that.reservationUserCommentId &&
                fileId == that.fileId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservationInfoId, reservationUserCommentId, fileId);
    }
}
