package seunghwan.won.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static seunghwan.won.dao.sqls.ProductImageDaoSqls.SELECT_PRODUCT_IMAGE_URL_BY_PRODUCT_ID;
import static seunghwan.won.dao.sqls.ProductImageDaoSqls.SELECT_PROMOTION_IMAGE_URL_BY_PRODUT_ID_AND_PROMOTION_ID;

@Repository
public class ProductImageDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<String> rowMapper;

    public ProductImageDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.rowMapper = BeanPropertyRowMapper.newInstance(String.class);
    }


    public String getProductImageUrl(int productId, String type) {
        Map<String, Object> param = new HashMap<>();
        param.put("productId", productId);
        param.put("type", type);
        return jdbcTemplate.queryForObject(SELECT_PRODUCT_IMAGE_URL_BY_PRODUCT_ID, param, String.class);
    }

    public String getPromotionImageUrl(int productId, int promotionId, String type) {
        Map<String, Object> param = new HashMap<>();
        param.put("productId", productId);
        param.put("promotionId", promotionId);
        param.put("type", type);
        return jdbcTemplate.queryForObject(SELECT_PROMOTION_IMAGE_URL_BY_PRODUT_ID_AND_PROMOTION_ID, param, String.class);
    }
}
