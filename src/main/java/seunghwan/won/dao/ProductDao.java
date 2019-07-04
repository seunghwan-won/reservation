package seunghwan.won.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.Product;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static seunghwan.won.dao.sqls.ProductDaoSqls.SELECT_ALL;
import static seunghwan.won.dao.sqls.ProductDaoSqls.SELECT_COUNT_BY_CATEGORY_ID;

@Repository
public class ProductDao {
    private SimpleJdbcInsert insert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<Product> rowMapper;
    private final String TABLE_NAME = "product";
    private final String ID = "id";

    public ProductDao(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME).usingGeneratedKeyColumns(ID);
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
    }

    public List<Product> selectAll() {
        return jdbcTemplate.query(SELECT_ALL, rowMapper);
    }

    public int countByCategoryId(int categoryId) {
        Map<String, ?> param = Collections.singletonMap("categoryId",categoryId);
        return jdbcTemplate.queryForObject(SELECT_COUNT_BY_CATEGORY_ID, param, Integer.class);
    }
}
