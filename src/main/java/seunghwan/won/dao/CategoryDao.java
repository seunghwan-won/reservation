package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.Category;
import seunghwan.won.dto.CategoryJoinProduct;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static seunghwan.won.dao.sqls.CategoryDaoSqls.*;

@Repository
public class CategoryDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
    private RowMapper<?> categoryJoinProductRowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "category";

    public CategoryDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(Category.class);
        this.categoryJoinProductRowMapper = DaoUtil.getRowMapper(CategoryJoinProduct.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public int insertCategory(Category category) {
        return DaoUtil.insert(category, insert);
    }

    public Category selectCategoryById(int id) {
        return (Category) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int updateCategory(Category category){
        return DaoUtil.update(jdbcTemplate, UPDATE_BY_ID, category);
    }

    public int deleteCategoryById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
    }

    public List<CategoryJoinProduct> selectAll() {
        return (List<CategoryJoinProduct>) jdbcTemplate.query(SELECT_ALL, categoryJoinProductRowMapper);
    }

    public int countByCategoryId(int categoryId) {
        Map<String, ?> param = Collections.singletonMap("categoryId", categoryId);
        return jdbcTemplate.queryForObject(SELECT_COUNT_BY_CATEGORY_ID, param, Integer.class);
    }
}
