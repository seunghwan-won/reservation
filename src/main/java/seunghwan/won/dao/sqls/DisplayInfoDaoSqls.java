package seunghwan.won.dao.sqls;

public class DisplayInfoDaoSqls {
    public static final String SELECT_BY_ID = "select id, product_id, opening_hours, place_name, place_lot, place_street," +
            "tel, homepage, email, create_date, modify_date from display_info where id=:id";

    public static final String UPDATE_BY_ID = "update display_info set opening_hours=:openingHours, place_name=:placeName," +
            "place_lot=:placeLot, place_street=:placeStreet, tel=:tel, email=:email, modify_date=:modifyDate where id=:id";

    public static final String DELETE_BY_ID = "delete from display_info where id=:id";
}
