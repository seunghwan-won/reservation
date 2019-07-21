package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.DisplayInfoDao;
import seunghwan.won.dto.DisplayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfo;
import seunghwan.won.dto.ReservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfo;
import seunghwan.won.service.DetailService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DetailServiceImplement implements DetailService {
    @Autowired
    DisplayInfoDao displayInfoDao;

    @Override
    public Map<String, Object> getDetail(int displayInfoId) {
        Map<String, Object> result = new HashMap<>();
        List<DisplayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfo>
                commentList = displayInfoDao.getComments(displayInfoId);
        List<ReservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfo> commentImageList
                = displayInfoDao.getCommentList(displayInfoId);
        for (DisplayInfoJoinProductJoinReservationUserCommentJoinReservationInfoJoinReservationCommentImageJoinFileInfo element : commentList) {
            int commentId = element.getCommentId();
            List<ReservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfo>
                    tempList = new ArrayList<>();
            for (ReservationUserCommentImageJoinReservationInfoJoinReservationUserCommentJoinFileInfo element2 : commentImageList) {
                if (commentId == element2.getReservationUserCommentId()) {
                    tempList.add(element2);
                }
            }
            element.setCommentImages(tempList);
        }

        result.put("displayInfo", displayInfoDao.getData(displayInfoId));
        result.put("productImages", displayInfoDao.getProductImages(displayInfoId));
        result.put("displayInfoImage", displayInfoDao.getDisplayInfoImage(displayInfoId));
        result.put("comments", commentList);
        result.put("averageScore", displayInfoDao.getAverageScore(displayInfoId));
        result.put("productPrices", displayInfoDao.getProductPrice(displayInfoId));
        return result;
    }
}
