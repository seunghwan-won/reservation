package seunghwan.won.dao.sqls;

public class CategoryDaoSqls {
    public static final String SELECT_BY_ID = "select id, name from category where id=:id";

    public static final String SELECT_ALL = "select id, name from category";

    public static final String SELECT_COUNT_BY_CATEGORY_ID = "select count(*) from product join category on " +
            "product.category_id = category.id where category_id = :categoryId";

    public static final String UPDATE_BY_ID = "update category set name=:name where id=:id";

    public static final String DELETE_BY_ID = "delete from category where id=:id";

}
