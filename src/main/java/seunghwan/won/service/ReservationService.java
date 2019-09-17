package seunghwan.won.service;

import seunghwan.won.dto.Data;
import seunghwan.won.dto.ReservationInfo;
import seunghwan.won.dto.json.JsonReservationInfo;

import java.util.Map;

public interface ReservationService {
    JsonReservationInfo getReservations(String email);

    int insert(Data data);

    ReservationInfo cancel(int reservationInfoId);
}
