package seunghwan.won.dao.sqls;

public class ProductDaoSqls {
    public static final String SELECT_ALL = "select id, category_id, description, content, event, create_date, " +
            "modify_date from product;";
}
