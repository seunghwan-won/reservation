package seunghwan.won.dao.sqls;

public class ReservationInfoDaoSqls {
    public static final String SELECT_BY_ID = "select id, product_id, display_info_id, reservation_name, reservation_tel," +
            "reservation_email, reservation_date, cancel_flag, create_date, modify_date from reservation_info where id=:id ";
    public static final String UPDATE_BY_ID = "update reservation_info set reservation_name=:reservationName, " +
            "reservation_tel=:reservationTel ,reservation_email=:reservationEmail, reservation_date=:reservationDate," +
            "cancel_flag=:cancelFlag, modify_date=:modifyDate where id=:id";
    public static final String DELETE_BY_ID = "delete from reservation_info where id=:id";
}
