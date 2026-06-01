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
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: ParkingSpot.canFitVehicle");
    }

    public boolean park(Vehicle vehicle) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: ParkingSpot.park");
    }

    public boolean unpark() {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: ParkingSpot.unpark");
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
