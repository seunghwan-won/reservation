package seunghwan.won.dao.sqls;

public class ReservationUserCommentImageDaoSqls {
    public static final String SELECT_BY_ID = "select id, reservation_info_id, reservation_user_comment_id, " +
            "file_id from reservation_user_comment_image where id=:id ";

    public static final String DELETE_BY_ID = "delete from reservation_user_comment_image where id=:id";

    public static final String  SELECT_COMMENT_THUMBNAIL_IMAGE_BY_COMMENT_ID = "SELECT f.save_file_name FROM reservation_user_comment_image ruci" +
            " INNER JOIN file_info f ON f.id = ruci.file_id" +
            " INNER JOIN reservation_user_comment ruc on ruci.reservation_user_comment_id = ruc.id" +
            " WHERE ruc.id = :id";
}
