package seunghwan.won.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import seunghwan.won.dto.Promotion;
import seunghwan.won.dto.PromotionJoinProductJoinProductImageJoinFileInfo;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static seunghwan.won.dao.sqls.PromotionDaoSqls.SELECT_ALL;

@Repository
public class PromotionDao {
    private SimpleJdbcInsert insert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<Promotion> rowMapper;
    private RowMapper<PromotionJoinProductJoinProductImageJoinFileInfo> promotionJoinProductJoinProductImageJoinFileInfoRowMapper;
    private final String TABLE_NAME = "promotion";
    private final String ID = "id";

    public PromotionDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.insert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME).usingGeneratedKeyColumns(ID);
        this.rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
        this.promotionJoinProductJoinProductImageJoinFileInfoRowMapper = BeanPropertyRowMapper
                .newInstance(PromotionJoinProductJoinProductImageJoinFileInfo.class);

    }

    public List<PromotionJoinProductJoinProductImageJoinFileInfo> selectAll() {
        return jdbcTemplate.query(SELECT_ALL, Collections.singletonMap("type", "th"),
                promotionJoinProductJoinProductImageJoinFileInfoRowMapper);
    }
}