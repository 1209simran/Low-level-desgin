package model;

import java.time.LocalDateTime;

public class PaymentReceipt {

    private int floorId;
    private int parkingSlotid;
    private LocalDateTime startTime;
    private int MaxNumberOfHrs;

    public int getMaxNumberOfHrs() {
        return MaxNumberOfHrs;
    }

    public void setMaxNumberOfHrs(int maxNumberOfHrs) {
        MaxNumberOfHrs = maxNumberOfHrs;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getParkingSlotid() {
        return parkingSlotid;
    }

    public void setParkingSlotid(int parkingSlotid) {
        this.parkingSlotid = parkingSlotid;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
