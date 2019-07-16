package seunghwan.won.dao.sqls;

public class ReservationUserCommentImageDaoSqls {
    public static final String SELECT_BY_ID = "select id, reservation_info_id, reservation_user_comment_id, " +
            "file_id from reservation_user_comment_image where id=:id ";

    public static final String DELETE_BY_ID = "delete from reservation_user_comment_image where id=:id";
}
