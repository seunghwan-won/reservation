package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.ReservationUserCommentImage;

import javax.sql.DataSource;

import java.util.Collections;

import static seunghwan.won.dao.sqls.ReservationUserCommentImageDaoSqls.*;

@Repository
public class ReservationIUserCommentImageDao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
    private SimpleJdbcInsert insert;
    private final String TABLE_NAME = "reservation_user_comment_image";

    public ReservationIUserCommentImageDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(ReservationUserCommentImage.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);
    }

    public int insertReservationUserCommentImage(ReservationUserCommentImage reservationUserCommentImage) {
        return DaoUtil.insert(reservationUserCommentImage, insert);

    }

    public ReservationUserCommentImage selectReservationUserCommentImageById(int id) {
        return (ReservationUserCommentImage) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int deleteReservationUserCommentImageById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
    }

    public String getCommentThumbnailImagePath(int commentImageId) {
        return jdbcTemplate.queryForObject(SELECT_COMMENT_THUMBNAIL_IMAGE_BY_COMMENT_ID, Collections.singletonMap("id", commentImageId), String.class);
    }
}
