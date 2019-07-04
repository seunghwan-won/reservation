package seunghwan.won.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.Product;

import javax.sql.DataSource;
import java.util.List;

import static seunghwan.won.dao.sqls.ProductDaoSqls.SELECT_ALL;

@Repository
public class ProductDao {
    private SimpleJdbcInsert insert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<Product> rowMapper;

    public ProductDao(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource).withTableName("product").usingGeneratedKeyColumns("id");
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
    }

    public List<Product> getProductList() {
        return jdbcTemplate.query(SELECT_ALL, rowMapper);
    }
}
