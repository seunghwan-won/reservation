package seunghwan.won.dao.sqls;

public class ReservationInfoPriceDaoSqls {
    public static final String SELECT_BY_ID = "select id, reservation_info_id, product_price_id, count " +
            "from reservation_info_price where id=:id";
    public static final String UPDATE_BY_ID = "update reservation_info_price set count=:count   where id=:id";
    public static final String DELETE_BY_ID = "delete from reservation_info_price where id=:id";
}
