package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.ReservationIUserCommentImageDao;
import seunghwan.won.dao.ReservationUserCommentDao;
import seunghwan.won.dto.ReservationUserComment;
import seunghwan.won.dto.ReservationUserCommentImage;
import seunghwan.won.service.CommentService;

import java.util.Calendar;

@Service
public class CommentServiceImplement implements CommentService {
    @Autowired
    ReservationUserCommentDao reservationUserCommentDao;

    @Autowired
    ReservationIUserCommentImageDao reservationIUserCommentImageDao;

    @Override
    public int save(String text, int productId, int reservationInfoId, int score) {
        Calendar time = Calendar.getInstance();
        ReservationUserComment comment = new ReservationUserComment();
        comment.setComment(text);
        comment.setProductId(productId);
        comment.setReservation_info_id(reservationInfoId);
        comment.setScore(score);
        comment.setCreateDate(time.getTime());
        comment.setModifyDate(time.getTime());
        return reservationUserCommentDao.insertReservationUserComment(comment);
    }

    @Override
    public int commentImageSave(int reservationInfoId, int commentId, int fileId) {
        ReservationUserCommentImage reservationUserCommentImage = new ReservationUserCommentImage();
        reservationUserCommentImage.setReservationInfoId(reservationInfoId);
        reservationUserCommentImage.setReservationUserCommentId(commentId);
        reservationUserCommentImage.setFileId(fileId);
        return reservationIUserCommentImageDao.insertReservationUserCommentImage(reservationUserCommentImage);
    }
}
