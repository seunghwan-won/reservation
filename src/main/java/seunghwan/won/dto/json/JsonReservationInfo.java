package seunghwan.won.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonReservationInfo {
    private List<Reservation> reservations;
    private long size;

    @JsonProperty("reservations")
    public List<Reservation> getReservations() { return reservations; }
    @JsonProperty("reservations")
    public void setReservations(List<Reservation> value) { this.reservations = value; }

    @JsonProperty("size")
    public long getSize() { return size; }
    @JsonProperty("size")
    public void setSize(long value) { this.size = value; }
}
