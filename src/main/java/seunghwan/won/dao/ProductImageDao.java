package seunghwan.won.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static seunghwan.won.dao.sqls.ProductImageDaoSqls.SELECT_URL;

@Repository
public class ProductImageDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<String> rowMapper;

    public ProductImageDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.rowMapper = BeanPropertyRowMapper.newInstance(String.class);
    }


    public String getUrl(int productId, int productImageId) {
        Map<String, Integer> param = new HashMap<>();
        param.put("productId", productId);
        param.put("productImageId", productImageId);
        return jdbcTemplate.queryForObject(SELECT_URL, param, String.class);
    }
}
