package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.DisplayInfoDao;
import seunghwan.won.dao.ReservationInfoDao;
import seunghwan.won.dao.ReservationInfoPriceDao;
import seunghwan.won.dto.Data;
import seunghwan.won.dto.ReservationInfo;
import seunghwan.won.dto.ReservationInfoPrice;
import seunghwan.won.dto.json.JsonReservationInfo;
import seunghwan.won.dto.json.Reservation;
import seunghwan.won.service.ReservationService;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImplement implements ReservationService {
    @Autowired
    ReservationInfoDao reservationInfoDao;

    @Autowired
    DisplayInfoDao displayInfoDao;

    @Autowired
    ReservationInfoPriceDao reservationInfoPriceDao;

    //    @Override
//    public Map<String, Object> getReservations(String email) {
//        Map<String, Object> result = new HashMap<>();
//        List<ReservationInfo> reservations = reservationInfoDao.getReservationInfo(email);
//        for (ReservationInfo reservationInfo : reservations) {
//            reservationInfo.setDisplayInfo(displayInfoDao.getData(reservationInfo.getDisplayInfoId()));
//            reservationInfo.setTotalPrice(reservationInfoDao.calculatePrice(reservationInfo.getId()));
//        }
//        result.put("reservations", reservations);
//        result.put("size", reservations.size());
//        return result;
//    }
    @Override
    public JsonReservationInfo getReservations(String email) {
        JsonReservationInfo result = new JsonReservationInfo();
        List<Reservation> reservations = reservationInfoDao.getReservationInfo(email);
        for (Reservation reservation : reservations) {
            reservation.setDisplayInfo(displayInfoDao.getData(reservation.getDisplayInfoID()));
            reservation.setTotalPrice(reservationInfoDao.calculatePrice(reservation.getReservationInfoID()));
        }
        result.setReservations(reservations);
        result.setSize(reservations.size());
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
        LocalDateTime localDateTime = LocalDateTime.now();
        reservationInfo.setCreateDate(Date.valueOf
                (LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth())));
        reservationInfo.setModifyDate(Date.valueOf
                (LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth())));
        int reservationInfoId = reservationInfoDao.insert(reservationInfo);
        for (ReservationInfoPrice reservationInfoPrice : reservationInfoPrices) {
            reservationInfoPrice.setReservationInfoId(reservationInfoId);
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
