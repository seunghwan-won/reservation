package seunghwan.won.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.Collections;

public class DaoUtil {
    public final static String ID = "id";

    public static NamedParameterJdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    public static RowMapper<?> getRowMapper(Class<?> targetClass) {
        return BeanPropertyRowMapper.newInstance(targetClass);

    }

    public static SimpleJdbcInsert getInsert(DataSource dataSource, String tableName) {
        return new SimpleJdbcInsert(dataSource).withTableName(tableName).usingGeneratedKeyColumns(ID);
    }

    public static int insert(Object object, SimpleJdbcInsert insert) {
        return insert.executeAndReturnKey(new BeanPropertySqlParameterSource(object)).intValue();
    }

    public static Object select(NamedParameterJdbcTemplate jdbcTemplate, String sql, int id, RowMapper<?> rowMapper) {
        return jdbcTemplate.queryForObject(sql, Collections.singletonMap(ID, id), rowMapper);
    }

    public static int update(NamedParameterJdbcTemplate jdbcTemplate, String sql, Object object) {
        return jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(object));
    }

    public static int delete(NamedParameterJdbcTemplate jdbcTemplate, String sql, int id) {
        return jdbcTemplate.update(sql, Collections.singletonMap(ID, id));
    }
}
