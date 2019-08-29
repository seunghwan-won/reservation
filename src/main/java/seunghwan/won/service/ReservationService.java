package seunghwan.won.service;

import seunghwan.won.dto.Data;
import seunghwan.won.dto.ReservationInfo;

import java.util.Map;

public interface ReservationService {
    Map<String, Object> getReservations(String email);

    int insert(Data data);

    ReservationInfo cancel(int reservationInfoId);
}
