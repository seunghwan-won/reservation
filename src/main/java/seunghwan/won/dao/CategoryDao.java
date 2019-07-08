package seunghwan.won.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.Category;
import seunghwan.won.dto.CategoryJoinProduct;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static seunghwan.won.dao.sqls.CategoryDaoSqls.SELECT_ALL;
import static seunghwan.won.dao.sqls.CategoryDaoSqls.SELECT_COUNT_BY_CATEGORY_ID;

@Repository
public class CategoryDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<Category> rowMapper;
    private RowMapper<CategoryJoinProduct> categoryJoinProductRowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "category";
    private final String ID = "id";

    public CategoryDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
        this.categoryJoinProductRowMapper = BeanPropertyRowMapper.newInstance(CategoryJoinProduct.class);
        this.insert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME).usingGeneratedKeyColumns(ID);
    }

    public int insert(Category category) {
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(category);
        return insert.executeAndReturnKey(sqlParameterSource).intValue();
    }

    public List<CategoryJoinProduct> selectAll() {
        return jdbcTemplate.query(SELECT_ALL, categoryJoinProductRowMapper);
    }

    public int countByCategoryId(int categoryId) {
        Map<String, ?> param = Collections.singletonMap("categoryId", categoryId);
        return jdbcTemplate.queryForObject(SELECT_COUNT_BY_CATEGORY_ID, param, Integer.class);
    }
}
