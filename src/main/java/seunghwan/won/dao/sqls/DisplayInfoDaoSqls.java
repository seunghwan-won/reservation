package seunghwan.won.dao.sqls;

public class DisplayInfoDaoSqls {
    public static final String SELECT_BY_ID = "select id, product_id, opening_hours, place_name, place_lot, place_street," +
            "tel, homepage, email, create_date, modify_date from display_info where id=:id";

    public static final String UPDATE_BY_ID = "update display_info set opening_hours=:openingHours, place_name=:placeName," +
            "place_lot=:placeLot, place_street=:placeStreet, tel=:tel, email=:email, modify_date=:modifyDate where id=:id";

    public static final String DELETE_BY_ID = "delete from display_info where id=:id";

    public static final String SELECT_DISPLAY_INFO = "select p.id as productId, c.id as categoryId, d.id as displayInfoId, " +
            "c.name as categoryName, p.description as productDescription, p.content as productContent, " +
            "p.event as productEvent, d.opening_hours as openingHours, d.place_name as placeName, d.place_lot as placeLot, " +
            "d.place_street as placeStreet, d.tel as telephone, d.homepage as homepage, d.email as email, " +
            "d.create_date as createDate, d.modify_date as modifyDate  " +
            "from category c " +
            "inner join product p on c.id = p.category_id " +
            "inner join display_info d on p.id = d.product_id where d.id = :id";
    public static final String SELECT_PRODUCT_IMAGE = "SELECT pi.product_id as productId, pi.id as productImageId, " +
            "pi.type as type, f.id as fileInfoId,\n" +
            "f.file_name as fileName, f.save_file_name as saveFileName, f.content_type as contentType,\n" +
            "f.delete_flag as deleteFlag, f.create_date as createDate, f.modify_date as modifyDate\n" +
            "from display_info d\n" +
            "inner JOIN product p on d.product_id = p.id\n" +
            "INNER JOIN product_image pi on p.id = pi.product_id\n" +
            "INNER JOIN file_info f on pi.file_id = f.id\n" +
            "WHERE d.id = :id AND pi.type !=\"th\"";

    public static final String SELECT_DISPLAY_INFO_IMAGE = "SELECT dii.id as displayInfoImageId, di.id as displayInfoId," +
            " f.id as fileId, f.file_name as fileName,\n" +
            "       f.save_file_name as saveFileName, f.content_type as contentType, f.delete_flag as deleteFlag,\n" +
            "           f.create_date as createDate, f.modify_date as modifyDate\n" +
            "FROM display_info di\n" +
            "INNER JOIN display_info_image dii\n" +
            "on di.id = dii.display_info_id\n" +
            "INNER JOIN file_info f on dii.file_id = f.id\n" +
            "WHERE di.id = :id";
    public static final String SELECT_COMMENTS = "SELECT c.id as commentId,\n" +
            "       p.id                as productId,\n" +
            "       r.id                as reservationInfoId,\n" +
            "       c.score             as score,\n" +
            "       r.reservation_name  as reservationName,\n" +
            "       r.reservation_tel   as reservationTelephone,\n" +
            "       r.reservation_email as reservationEmail,\n" +
            "       r.reservation_date  as reservationDate,\n" +
            "       r.create_date       as createDate,\n" +
            "       r.modify_date       as modifyDate,\n" +
            "       c.comment           as comment\n" +
            "FROM display_info di\n" +
            "         INNER JOIN product p\n" +
            "                    ON di.product_id = p.id\n" +
            "         INNER JOIN reservation_user_comment c\n" +
            "                    ON p.id = c.product_id\n" +
            "         INNER JOIN reservation_info r ON c.reservation_info_id = r.id\n" +
            "WHERE di.id = :id\n" +
            "ORDER BY c.id\n" +
            "    DESC";
    public static final String CALC_AVERAGE = "select round(avg(ruc.score ),9) from display_info di\n" +
            "inner join  product p on di.product_id = p.id\n" +
            "inner join  reservation_user_comment ruc on p.id = ruc.product_id\n" +
            "where di.id = :id";
    public static final String SELECT_PRODUCT_PRICE = "SELECT pp.id              as productPriceId,\n" +
            "       p.id               as productId,\n" +
            "       pp.price_type_name as priceTypeName,\n" +
            "       pp.price           as price,\n" +
            "       pp.discount_rate   as discountRate,\n" +
            "       pp.create_date     as createDate,\n" +
            "       pp.modify_date     as modifyDate\n" +
            "FROM display_info d\n" +
            "         INNER JOIN product p on d.product_id = p.id\n" +
            "         INNER JOIN product_price pp on p.id = pp.product_id\n" +
            "WHERE d.id = 1\n" +
            "ORDER BY pp.id\n" +
            "    DESC";
}
