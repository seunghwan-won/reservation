package seunghwan.won.dao.sqls;

public class ReservationUserCommentDaoSqls {
    public static final String SELECT_BY_ID = "select id, product_id, reservation_info_id, score, comment," +
            "create_date, modify_date from reservation_user_comment where id=:id ";
    public static final String UPDATE_BY_ID = "update reservation_user_comment set score=:score, " +
            "comment=:comment, modify_date=:modifyDate where id=:id";
    public static final String DELETE_BY_ID = "delete from reservation_user_comment where id=:id";
}
