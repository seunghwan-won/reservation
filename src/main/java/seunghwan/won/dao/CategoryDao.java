package seunghwan.won.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.Category;

import javax.sql.DataSource;
import java.util.List;

import static seunghwan.won.dao.sqls.CategoryDaoSqls.SELECT_ALL;

@Repository
public class CategoryDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Category> rowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "category";
    private final String ID = "id";

    public CategoryDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
        this.insert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME).usingGeneratedKeyColumns(ID);
    }

    public List<Category> selectAll() {
        return jdbc.query(SELECT_ALL, rowMapper);
    }
}
