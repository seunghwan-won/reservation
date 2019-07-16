package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.ReservationInfoPrice;

import javax.sql.DataSource;

import static seunghwan.won.dao.sqls.ReservationInfoPriceDaoSqls.*;

@Repository
public class ReservationInfoPriceDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "reservation_info_price";

    public ReservationInfoPriceDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(ReservationInfoPrice.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public int insertReservationInfoPrice(ReservationInfoPrice reservationInfoPrice) {
        return DaoUtil.insert(reservationInfoPrice, insert);

    }

    public ReservationInfoPrice selectReservationInfoPriceById(int id) {
        return (ReservationInfoPrice) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int updateReservationInfoPrice(ReservationInfoPrice reservationInfoPrice) {
        return DaoUtil.update(jdbcTemplate, UPDATE_BY_ID, reservationInfoPrice);
    }

    public int deleteReservationInfoPriceById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
    }
}
