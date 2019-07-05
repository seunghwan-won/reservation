package seunghwan.won.dao.sqls;

public class PromotionDaoSqls {
    public static final String SELECT_ALL = "Select promotion.id as promotionId, product.id as productId, " +
            "file_info.save_file_name as productImageUrl\n" +
            "From file_info\n" +
            "Inner join product_image\n" +
            "On file_info.id = product_image.file_id\n" +
            "Inner join  product\n" +
            "On product.id = product_image.product_id\n" +
            "Inner join promotion\n" +
            "On promotion.product_id = product.id\n" +
            "Where product_image.type=:type;";
}
