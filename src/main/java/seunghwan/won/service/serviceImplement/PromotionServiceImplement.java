package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seunghwan.won.dao.PromotionDao;
import seunghwan.won.dto.PromotionJoinProductJoinProductImageJoinFileInfo;
import seunghwan.won.service.PromotionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PromotionServiceImplement implements PromotionService {
    @Autowired
    PromotionDao promotionDao;

    @Override
    @Transactional
    public Map<String, List> getPromotionList() {
        Map<String, List> result = new HashMap<>();
        List<PromotionJoinProductJoinProductImageJoinFileInfo> promotionJoinProductJoinProductImageJoinFileInfoList
                = promotionDao.selectAll();
        result.put("items", promotionJoinProductJoinProductImageJoinFileInfoList);
        return result;
    }
}
