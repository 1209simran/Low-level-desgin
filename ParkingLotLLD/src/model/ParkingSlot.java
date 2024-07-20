package model;

import enums.VehicleType;

public class ParkingSlot {

    private int parkingId;
    private Vehicle parkedVehicle;
    private VehicleType vehicleType;
    private boolean isAvailable;

    public ParkingSlot(int parkingId, VehicleType vehicleType) {
        this.parkingId = parkingId;
        this.vehicleType = vehicleType;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getParkingId() {
        return parkingId;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicleType.equals(vehicle.getVehicleType());
    }

    public void parkVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
        setAvailable(false);
    }

    public void unParkVehicle() {
        this.parkedVehicle = null;
        setAvailable(true);
    }

}
