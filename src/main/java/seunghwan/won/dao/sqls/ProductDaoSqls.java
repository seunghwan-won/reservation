package seunghwan.won.dao.sqls;

public class ProductDaoSqls {
    public static final String SELECT_COUNT_BY_CATEGOTY_ID = "select count(*) from product inner join category " +
            "on product.category_id = :categoryId where category.id = :categoryId";
    public static final String SELECT_COUNT_ALL = "select count(*) from product inner join category " +
            "on product.category_id = category.id";

    public static final String SELECT_ALL = "SELECT display_info.id as displayInfoId, " +
            "product.id as productId, product.description as productDescription, display_info.place_name as placeName, " +
            "product.content as productContent, file_info.save_file_name as productImageUrl " +
            "FROM product INNER JOIN display_info ON display_info.product_id = product.id " +
            "INNER JOIN product_image ON product.id = product_image.product_id " +
            "INNER JOIN file_info ON product_image.file_id = file_info.id " +
            "WHERE product_image.type =\"th\" limit :start, :limit";

    public static final String SELECT_PASING_BY_CATEGORY_ID = "SELECT display_info.id as displayInfoId, " +
            "product.id as productId, product.description as productDescription, display_info.place_name as placeName, " +
            "product.content as productContent, file_info.save_file_name as productImageUrl " +
            "FROM product INNER JOIN display_info ON display_info.product_id = product.id " +
            "INNER JOIN product_image ON product.id = product_image.product_id " +
            "INNER JOIN file_info ON product_image.file_id = file_info.id " +
            "WHERE product.category_id = :categoryId AND product_image.type =:type limit :start, :limit";
}
