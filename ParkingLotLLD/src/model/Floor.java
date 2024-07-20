package model;

import java.util.Map;

public class Floor {

    private int floorId;
    private int numOfParkingSlots;
    private Map<Integer, ParkingSlot> parkingSlotMap;

    public Floor(int floorId, int numOfParkingSlots) {
        this.floorId = floorId;
        this.numOfParkingSlots = numOfParkingSlots;
    }

    public int getNumOfParkingSlots() {
        return numOfParkingSlots;
    }

    public void setNumOfParkingSlots(int numOfParkingSlots) {
        this.numOfParkingSlots = numOfParkingSlots;
    }

    public ParkingSlot getParkingSlotByParkingId(int parkingId) {
        if (parkingSlotMap.containsKey(parkingId))
            parkingSlotMap.get(parkingId);
        return null;
    }
    

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public void addParkingSlot(ParkingSlot parkingSlot) {
        if (numOfParkingSlots > parkingSlotMap.size()) {
            parkingSlotMap.put(parkingSlot.getParkingId(), parkingSlot);
        } else {
            System.out.println("Cannot add more slots.");
        }
    }

    public void removeParkingSlot(ParkingSlot parkingSlot) {
        if (!parkingSlotMap.isEmpty()) {
            parkingSlotMap.remove(parkingSlot.getParkingId());
        } else {
            System.out.println("Cannot remove parking slot.");
        }
    }

}
