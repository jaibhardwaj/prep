package dev.jaib.parkinglot.model;

public class ParkingSpot {
    private int spotNumber;
    private ParkingSpotType type;
    private boolean isFree;
    private Vehicle currentVehicle;

    public ParkingSpot(int spotNumber, ParkingSpotType type) {
        this.spotNumber = spotNumber;
        this.type = type;
        this.isFree = true;
        this.currentVehicle = null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        if (!isFree) {
            return false;
        }
        switch (type) {
            case LARGE:
                // Large spots can fit any vehicle
                return true;
            case COMPACT:
                // Compact spots can fit cars and motorcycles
                return vehicle.getType() == VehicleType.CAR || vehicle.getType() == VehicleType.MOTORCYCLE;
            case MOTORCYCLE:
                // Motorcycle spots can only fit motorcycles
                return vehicle.getType() == VehicleType.MOTORCYCLE;
            default:
                return false;
        }
    }

    public boolean park(Vehicle vehicle) {
        if (!canFitVehicle(vehicle)) {
            return false;
        }
        this.currentVehicle = vehicle;
        this.isFree = false;
        return true;
    }

    public boolean unpark() {
        if (isFree) {
            return false;
        }
        this.currentVehicle = null;
        this.isFree = true;
        return true;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public boolean isFree() {
        return isFree;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
}
