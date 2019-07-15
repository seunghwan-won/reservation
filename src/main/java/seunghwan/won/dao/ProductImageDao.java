package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.ProductImage;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static seunghwan.won.dao.sqls.ProductImageDaoSqls.*;

@Repository
public class ProductImageDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> stringRowMapper;
    private RowMapper<?> rowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "product_image";


    public ProductImageDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.stringRowMapper = DaoUtil.getRowMapper(String.class);
        this.rowMapper = DaoUtil.getRowMapper(ProductImage.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public int insertProductImage(ProductImage productImage) {
        return DaoUtil.insert(productImage, insert);
    }

    public ProductImage selectProductImageById(int id) {
        return (ProductImage) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int updateProductImage(ProductImage productImage) {
        return DaoUtil.update(jdbcTemplate, UPDATE_BY_ID, productImage);
    }

    public int deleteProductImageById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
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
