package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.FileInfo;

import javax.sql.DataSource;

import static seunghwan.won.dao.sqls.FileInfoDaoSqls.*;

@Repository
public class FileInfoDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "file_info";

    public FileInfoDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(FileInfo.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public int insertFileInfoImage(FileInfo fileInfo) {
        return DaoUtil.insert(fileInfo, insert);
    }

    public FileInfo selectFileInfoImageById(int id) {
        return (FileInfo) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int updateFileInfo(FileInfo fileInfo) {
        return DaoUtil.update(jdbcTemplate, UPDATE_BY_ID, fileInfo);
    }

    public int deleteFileInfoImageById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
    }
}
