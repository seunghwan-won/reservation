package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.DisplayInfoImage;

import javax.sql.DataSource;

import java.util.Collections;

import static seunghwan.won.dao.sqls.DisplayInfoImageDaoSqls.*;

@Repository
public class DisplayInfoImageDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "display_info_image";

    public DisplayInfoImageDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(DisplayInfoImage.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public int insertDisplayInfoImage(DisplayInfoImage displayInfoImage) {
        return DaoUtil.insert(displayInfoImage, insert);
    }

    public DisplayInfoImage selectDisplayInfoImageById(int id) {
        return (DisplayInfoImage) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int deleteDisplayInfoImageById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
    }

    public String getMapImagePath(int id) {
        return jdbcTemplate.queryForObject(SELECT_PATH_BY_ID, Collections.singletonMap("id", id), String.class);
    }

    public String getDisplayImagePath(int id) {
        return jdbcTemplate.queryForObject(SELECT_MAIN_IMAGE_BY_DISPLAY_ID, Collections.singletonMap("id", id), String.class);
    }
}
