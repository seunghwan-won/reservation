package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.ReservationInfoPrice;
import seunghwan.won.dto.ReservationUserComment;

import javax.sql.DataSource;

import static seunghwan.won.dao.sqls.ReservationUserCommentDaoSqls.*;

@Repository
public class ReservationUserCommentDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "reservation_user_comment";

    public ReservationUserCommentDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(ReservationUserComment.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public int insertReservationUserComment(ReservationUserComment reservationUserComment) {
        return DaoUtil.insert(reservationUserComment, insert);

    }

    public ReservationUserComment selectReservationUserCommentById(int id) {
        return (ReservationUserComment) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int updateReservationUserComment(ReservationUserComment reservationUserComment) {
        return DaoUtil.update(jdbcTemplate, UPDATE_BY_ID, reservationUserComment);
    }

    public int deleteReservationUserCommentById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
    }
}
