package seunghwan.won.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.Category;

import javax.sql.DataSource;
import java.util.List;

import static seunghwan.won.dao.CategoryDaoSqls.SELECT_ALL;

@Repository
public class CategoryDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Category> rowMapper;

    public CategoryDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
    }

    public List<Category> categoryList() {
        return jdbc.query(SELECT_ALL, rowMapper);
    }
}
