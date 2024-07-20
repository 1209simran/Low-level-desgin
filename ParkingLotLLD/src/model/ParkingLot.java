package model;

import java.util.Map;

public class ParkingLot {

    private int numOfFloors;
    private Map<Integer, Floor> floorMap;

    public ParkingLot(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public void addFloors(Floor floor) {
        if (numOfFloors > floorMap.size()) {
            floorMap.put(floor.getFloorId(), floor);
        } else {
            System.out.println("Cannot add more floors.");
        }
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }
}
