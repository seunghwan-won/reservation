package seunghwan.won.dao.sqls;

public class ProductPriceDaoSqls {
    public static final String SELECT_BY_ID = "select id, product_id, price_type_name, price, discount_rate, create_date," +
            "modify_date from product_price where id=:id";
    public static final String UPDATE_BY_ID = "update product_price set price_type_name=:priceTypeName, price=price" +
            ",discount_rate=:discountRate, modify_date=:modifyDate where id=:id";
    public static final String DELETE_BY_ID = "delete from product_price where id=:id";

}
