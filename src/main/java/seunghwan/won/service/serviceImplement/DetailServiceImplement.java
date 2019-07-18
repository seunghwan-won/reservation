package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.DisplayInfoDao;
import seunghwan.won.service.DetailService;

import java.util.HashMap;
import java.util.Map;

@Service
public class DetailServiceImplement implements DetailService {
    @Autowired
    DisplayInfoDao displayInfoDao;

    @Override
    public Map<String, Object> getDetail(int displayInfoId) {
        Map<String, Object> result = new HashMap<>();
        result.put("displayInfo", displayInfoDao.getData(displayInfoId));
        result.put("productImages", displayInfoDao.getProductImages(displayInfoId));
        result.put("displayInfoImage", displayInfoDao.getDisplayInfoImage(displayInfoId));
        result.put("comments", displayInfoDao.getComments(displayInfoId));
        result.put("averageScore", displayInfoDao.getAverageScore(displayInfoId));
        result.put("productPrices", displayInfoDao.getProductPrice(displayInfoId));
        return result;
    }
}
