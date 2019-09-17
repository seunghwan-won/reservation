package seunghwan.won.service;

import seunghwan.won.dto.json.JsonComment;

public interface CommentService {
    int save(String comment, int productId, int reservationInfoId, int score);

    int commentImageSave(int reservationInfoId, int commentId, int fileId);
}
