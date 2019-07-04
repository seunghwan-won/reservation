package seunghwan.won.dao.sqls;

public class ProductDaoSqls {
    public static final String SELECT_ALL = "select id, category_id, description, content, event, create_date, " +
            "modify_date from product;";
    public static final String SELECT_COUNT_BY_CATEGORY_ID = "select count(*) from product join category on product.category_id = category.id where category_id = :categoryId";
}
