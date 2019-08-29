package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.DisplayInfoDao;
import seunghwan.won.dao.ReservationInfoDao;
import seunghwan.won.dao.ReservationInfoPriceDao;
import seunghwan.won.dto.Data;
import seunghwan.won.dto.ReservationInfo;
import seunghwan.won.dto.ReservationInfoPrice;
import seunghwan.won.service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationServiceImplement implements ReservationService {
    @Autowired
    ReservationInfoDao reservationInfoDao;

    @Autowired
    DisplayInfoDao displayInfoDao;

    @Autowired
    ReservationInfoPriceDao reservationInfoPriceDao;

    @Override
    public Map<String, Object> getReservations(String email) {
        Map<String, Object> result = new HashMap<>();
        List<ReservationInfo> reservations = reservationInfoDao.getReservationInfo(email);
        for (ReservationInfo reservationInfo : reservations) {
            reservationInfo.setDisplayInfo(displayInfoDao.getData(reservationInfo.getDisplayInfoId()));
            reservationInfo.setTotalPrice(reservationInfoDao.calculatePrice(reservationInfo.getId()));
        }
        result.put("reservations" , reservations);
        result.put("size", reservations.size());
        return result;
    }

    @Override
    public int insert(Data data) {
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<ReservationInfoPrice> reservationInfoPrices = data.getPrices();
        ReservationInfo reservationInfo = new ReservationInfo();
        reservationInfo.setDisplayInfoId(data.getDisplayInfoId());
        reservationInfo.setCancelFlag(0);
        reservationInfo.setProductId(data.getProductId());
        reservationInfo.setReservationEmail(data.getReservationEmail());
        reservationInfo.setReservationName(data.getReservationName());
        reservationInfo.setReservationTel(data.getReservationTel());
        reservationInfo.setReservationDate(data.getReservationYearMonthDay());
        try {
            reservationInfo.setCreateDate(transFormat.parse(data.getReservationYearMonthDay()));
            reservationInfo.setModifyDate(transFormat.parse(data.getReservationYearMonthDay()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        int reservationInfoId = reservationInfoDao.insert(reservationInfo);
        for(ReservationInfoPrice reservationInfoPrice : reservationInfoPrices){
            reservationInfoPrice.setReservationInfoId(reservationInfoId);
            System.out.println(reservationInfoPrice);
            reservationInfoPriceDao.insertReservationInfoPrice(reservationInfoPrice);
        }
        return reservationInfoId;
    }

    @Override
    public ReservationInfo cancel(int reservationInfoId) {
        reservationInfoDao.cancel(reservationInfoId);
        ReservationInfo reservationInfo = reservationInfoDao.getReservationInfo(reservationInfoId);
        return reservationInfo;
    }
}
