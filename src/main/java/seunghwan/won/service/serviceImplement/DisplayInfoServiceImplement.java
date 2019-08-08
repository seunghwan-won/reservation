package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.DisplayInfoDao;
import seunghwan.won.dto.DisplayInfo;
import seunghwan.won.service.DisplayInfoService;

@Service
public class DisplayInfoServiceImplement implements DisplayInfoService {
    @Autowired
    DisplayInfoDao displayInfoDao;

    @Override
    public DisplayInfo getDisplayInfo(int displayInfoId) {
        return displayInfoDao.selectDisplayInfoById(displayInfoId);
    }
}
