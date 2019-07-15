package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.Product;
import seunghwan.won.dto.ProductJoinDisplayInfoJoinFileInfo;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static seunghwan.won.dao.sqls.ProductDaoSqls.*;

@Repository
public class ProductDao {
    private SimpleJdbcInsert insert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
    private RowMapper<?> productJoinDisplayInfoJoinFileInfoRowMapper;
    private final String TABLE_NAME = "product";

    public ProductDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(Product.class);
        this.productJoinDisplayInfoJoinFileInfoRowMapper = DaoUtil.getRowMapper(ProductJoinDisplayInfoJoinFileInfo.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public int insertProduct(Product product) {
        return DaoUtil.insert(product, insert);
    }

    public Product selectProductById(int id) {
        return (Product) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int updateProduct(Product product) {
        return DaoUtil.update(jdbcTemplate, UPDATE_BY_ID, product);
    }

    public int deleteProductById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
    }


    public List<ProductJoinDisplayInfoJoinFileInfo> selectByCategoryId(Integer categoryId, Integer start, Integer limit) {
        Map<String, Object> param = new HashMap<>();
        param.put("categoryId", categoryId);
        param.put("type", "th");
        param.put("start", start);
        param.put("limit", limit);
        return (List<ProductJoinDisplayInfoJoinFileInfo>)jdbcTemplate.query(SELECT_PASING_BY_CATEGORY_ID, param,
                productJoinDisplayInfoJoinFileInfoRowMapper);
    }


    public int getTotalCount(Integer categoryId) {
        Map<String, Integer> param = Collections.singletonMap("categoryId", categoryId);
        return jdbcTemplate.queryForObject(SELECT_COUNT_BY_CATEGOTY_ID, param, Integer.class);
    }

    public List<ProductJoinDisplayInfoJoinFileInfo> selectAll(Integer start, Integer limit) {
        Map<String, Object> param = new HashMap<>();
        param.put("start", start);
        param.put("limit", limit);
        return (List<ProductJoinDisplayInfoJoinFileInfo>)jdbcTemplate.query(SELECT_ALL, param,
                productJoinDisplayInfoJoinFileInfoRowMapper);
    }

    public int getTotalCount() {
        return jdbcTemplate.queryForObject(SELECT_COUNT_ALL, new HashMap<>(), Integer.class);
    }
}
