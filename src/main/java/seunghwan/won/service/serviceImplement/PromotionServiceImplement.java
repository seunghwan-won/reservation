package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.PromotionDao;
import seunghwan.won.dto.Promotion;
import seunghwan.won.service.PromotionService;

import java.util.List;

@Service
public class PromotionServiceImplement implements PromotionService {
    @Autowired
    PromotionDao promotionDao;
    @Override
    public List<Promotion> getPromotionList() {
        return promotionDao.selectAll();
    }
}
