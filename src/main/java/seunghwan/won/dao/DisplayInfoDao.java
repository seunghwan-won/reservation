package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.*;
import seunghwan.won.dto.json.DisplayInfo;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static seunghwan.won.dao.sqls.DisplayInfoDaoSqls.*;

@Repository
public class DisplayInfoDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
//    private RowMapper<?> categoryJoinProductJoinDisplayInfoMapper;
    private RowMapper<?> displayInfoJoinProductJoinProductImageJoinFileInfoMapper;
    private RowMapper<?> displayInfoJoinDisplayInfoImageJoinFileInfoMapper;
    private RowMapper<?> displayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfoMapper;
    private RowMapper<?> displayInfoJoinProductJoinProductPriceMapper;
    private RowMapper<?> reservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfoMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "display_info";

    public DisplayInfoDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(seunghwan.won.dto.DisplayInfo.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public int insertDisplayInfo(seunghwan.won.dto.DisplayInfo displayInfo) {
        return DaoUtil.insert(displayInfo, insert);
    }

    public seunghwan.won.dto.DisplayInfo selectDisplayInfoById(int id) {
        return (seunghwan.won.dto.DisplayInfo) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int updateDisplayInfo(seunghwan.won.dto.DisplayInfo displayInfo) {
        return DaoUtil.update(jdbcTemplate, UPDATE_BY_ID, displayInfo);
    }

    public int deleteDisplayInfoById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
    }

//    public CategoryJoinProductJoinDisplayInfo getData(int displayInfoId) {
//        this.categoryJoinProductJoinDisplayInfoMapper = DaoUtil.getRowMapper(CategoryJoinProductJoinDisplayInfo.class);
//        return (CategoryJoinProductJoinDisplayInfo) jdbcTemplate.queryForObject(SELECT_DISPLAY_INFO,
//                Collections.singletonMap(DaoUtil.ID, displayInfoId),
//                categoryJoinProductJoinDisplayInfoMapper);
//    }

    public seunghwan.won.dto.json.DisplayInfo getData(long displayInfoId) {
        RowMapper<?> rowMapper =
                DaoUtil.getRowMapper(DisplayInfo.class);
//        this.categoryJoinProductJoinDisplayInfoMapper = DaoUtil.getRowMapper(seunghwan.won.dto.json.DisplayInfo.class);
        return (DisplayInfo) jdbcTemplate.queryForObject(SELECT_DISPLAY_INFO,
                Collections.singletonMap(DaoUtil.ID, displayInfoId),
                rowMapper);
    }

    public List<DisplayInfoJoinProductJoinProductImageJoinFile> getProductImages(int displayInfoId) {
        this.displayInfoJoinProductJoinProductImageJoinFileInfoMapper =
                DaoUtil.getRowMapper(DisplayInfoJoinProductJoinProductImageJoinFile.class);
        return (List<DisplayInfoJoinProductJoinProductImageJoinFile>) jdbcTemplate.query(SELECT_PRODUCT_IMAGE,
                Collections.singletonMap(DaoUtil.ID, displayInfoId), displayInfoJoinProductJoinProductImageJoinFileInfoMapper);
    }

    public Object getDisplayInfoImage(int displayInfoId) {
        this.displayInfoJoinDisplayInfoImageJoinFileInfoMapper = DaoUtil.getRowMapper(DisplayInfoJoinDisplayInfoImageJoinFile.class);
        return DaoUtil.select(jdbcTemplate, SELECT_DISPLAY_INFO_IMAGE, displayInfoId, displayInfoJoinDisplayInfoImageJoinFileInfoMapper);
    }

    public List<DisplayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfo> getComments(int displayInfoId) {
        this.displayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfoMapper
                = DaoUtil.getRowMapper(DisplayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfo.class);
        return (List<DisplayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfo>)
                jdbcTemplate.query(SELECT_COMMENTS, Collections.singletonMap(DaoUtil.ID, displayInfoId),
                        displayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfoMapper);
    }

    public double getAverageScore(int displayInfoId) {
        try {
            return jdbcTemplate.queryForObject(CALC_AVERAGE, Collections.singletonMap(DaoUtil.ID, displayInfoId), Double.class);
        } catch (NullPointerException e) {
            return 0;
        }

    }

    public List<DisplayInfoJoinProductJoinProductPrice> getProductPrice(int displayInfoId) {
        this.displayInfoJoinProductJoinProductPriceMapper = DaoUtil.getRowMapper(DisplayInfoJoinProductJoinProductPrice.class);
        return (List<DisplayInfoJoinProductJoinProductPrice>) jdbcTemplate.query(SELECT_PRODUCT_PRICE,
                Collections.singletonMap(DaoUtil.ID, displayInfoId), displayInfoJoinProductJoinProductPriceMapper);
    }

    public List<ReservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfo> getCommentList(int displayInfoId) {
        this.reservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfoMapper =
                DaoUtil.getRowMapper(ReservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfo.class);
        return (List<ReservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfo>)
                jdbcTemplate.query(SELECT_COMMENT_IMAGE, Collections.singletonMap(DaoUtil.ID, displayInfoId),
                        reservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfoMapper);
    }
}
