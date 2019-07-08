package seunghwan.won.dao.sqls;

public class ProductImageDaoSqls {
    public static final String SELECT_URL = "select file_info.save_file_name from product inner join product_image" +
            "on :productId = :productImageId inner join file_info on product_image.file_id = file_info.id";
}
