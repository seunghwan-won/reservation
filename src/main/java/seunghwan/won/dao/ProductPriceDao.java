package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dao.DaoUtil;
import seunghwan.won.dto.ProductPrice;

import javax.sql.DataSource;

import static seunghwan.won.dao.sqls.ProductPriceDaoSqls.*;

@Repository
public class ProductPriceDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "product_price";

    public ProductPriceDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(ProductPrice.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public int insertProductPrice(ProductPrice productPrice) {
        return DaoUtil.insert(productPrice, insert);

    }

    public ProductPrice selectProductPriceById(int id) {
        return (ProductPrice) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int updateProductPrice(ProductPrice category) {
        return DaoUtil.update(jdbcTemplate, UPDATE_BY_ID, category);
    }

    public int deleteProductPriceById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
    }
}
