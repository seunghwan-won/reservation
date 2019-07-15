package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.DisplayInfo;

import javax.sql.DataSource;

import static seunghwan.won.dao.sqls.CategoryDaoSqls.*;


@Repository
public class DisplayInfoDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "display_info";

    public DisplayInfoDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(DisplayInfo.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public int insertDisplayInfo(DisplayInfo displayInfo) {
        return DaoUtil.insert(displayInfo, insert);
    }

    public DisplayInfo selectDisplayInfoById(int id) {
        return (DisplayInfo) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int updateDisplayInfo(DisplayInfo displayInfo) {
        return DaoUtil.update(jdbcTemplate, UPDATE_BY_ID, displayInfo);
    }

    public int deleteDisplayInfoById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
    }

}
