package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.ReservationInfo;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static seunghwan.won.dao.sqls.ReservationInfoDaoSqls.*;

@Repository
public class ReservationInfoDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "reservation_info";

    public ReservationInfoDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(ReservationInfo.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public List<ReservationInfo> getReservationInfo(String email) {
        return (List<ReservationInfo>) jdbcTemplate.query(SELECT_ALL_BY_EMAIL, Collections.singletonMap("email", email), rowMapper);
    }

    public int calculatePrice(int id) {
        return jdbcTemplate.queryForObject(CALC_PRICE_BY_ID, Collections.singletonMap("id", id), Integer.class);
    }

    public int insert(ReservationInfo reservationInfo) {
        return DaoUtil.insert(reservationInfo, insert);
    }

    public ReservationInfo getReservationInfo(int id) {
        return (ReservationInfo) jdbcTemplate.queryForObject(SELECT_BY_ID, Collections.singletonMap("id", id), rowMapper);
    }

    public void cancel(int id) {
        jdbcTemplate.update(CANCEL_BY_ID, Collections.singletonMap("id", id));
    }
}
