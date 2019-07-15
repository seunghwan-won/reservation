package seunghwan.won.dao.sqls;

public class ProductImageDaoSqls {
    public static final String SELECT_BY_ID = "select id, product_id, type, file_id from product_image where id=:id";
    public static final String SELECT_PRODUCT_IMAGE_URL_BY_PRODUCT_ID = "SELECT file_info.save_file_name FROM product INNER JOIN product_image" +
            " ON product.id = product_image.product_id INNER JOIN file_info ON product_image.file_id = file_info.id" +
            " WHERE product.id=:productId AND type=:type";
    public static final String SELECT_PROMOTION_IMAGE_URL_BY_PRODUT_ID_AND_PROMOTION_ID = "SELECT file_info.save_file_name" +
            " FROM promotion INNER JOIN product ON product.id = promotion.product_id INNER JOIN product_image ON " +
            "product.id = product_image.product_id INNER JOIN file_info on file_info.id = product_image.file_id " +
            "WHERE type=:type AND product.id = :productId AND promotion.id = :promotionId";
    public static final String UPDATE_BY_ID = "update product_image set typ=:type where id=:id";

    public static final String DELETE_BY_ID = "delete from product_image where id=:id";
}
