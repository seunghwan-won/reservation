package seunghwan.won.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.Promotion;
import seunghwan.won.dto.PromotionJoinProductJoinProductImageJoinFileInfo;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static seunghwan.won.dao.sqls.PromotionDaoSqls.*;

@Repository
public class PromotionDao {
    private SimpleJdbcInsert insert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<?> rowMapper;
    private RowMapper<?> promotionJoinProductJoinProductImageJoinFileInfoRowMapper;
    private final String TABLE_NAME = "promotion";

    public PromotionDao(DataSource dataSource) {
        this.jdbcTemplate = DaoUtil.getJdbcTemplate(dataSource);
        this.rowMapper = DaoUtil.getRowMapper(Promotion.class);
        this.promotionJoinProductJoinProductImageJoinFileInfoRowMapper =
                DaoUtil.getRowMapper(PromotionJoinProductJoinProductImageJoinFileInfo.class);
        this.insert = DaoUtil.getInsert(dataSource, TABLE_NAME);

    }

    public int insertPromotion(Promotion promotion) {
        return DaoUtil.insert(promotion, insert);
    }

    public Promotion selectPromotionById(int id) {
        return (Promotion) DaoUtil.select(jdbcTemplate, SELECT_BY_ID, id, rowMapper);
    }

    public int deletePromotionById(int id) {
        return DaoUtil.delete(jdbcTemplate, DELETE_BY_ID, id);
    }


    public List<PromotionJoinProductJoinProductImageJoinFileInfo> selectAll() {
        return (List<PromotionJoinProductJoinProductImageJoinFileInfo>) jdbcTemplate.query(SELECT_ALL,
                Collections.singletonMap("type", "th"), promotionJoinProductJoinProductImageJoinFileInfoRowMapper);
    }
}
