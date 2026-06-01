package dev.jaib.parkinglot;

import dev.jaib.parkinglot.model.ParkingSpot;
import dev.jaib.parkinglot.model.ParkingSpotType;
import dev.jaib.parkinglot.model.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floorNumber;
    private List<ParkingSpot> spots;

    public Level(int floorNumber, int motorcycleCount, int compactCount, int largeCount) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
        
        int spotIndex = 1;
        for (int i = 0; i < motorcycleCount; i++) {
            spots.add(new ParkingSpot(spotIndex++, ParkingSpotType.MOTORCYCLE));
        }
        for (int i = 0; i < compactCount; i++) {
            spots.add(new ParkingSpot(spotIndex++, ParkingSpotType.COMPACT));
        }
        for (int i = 0; i < largeCount; i++) {
            spots.add(new ParkingSpot(spotIndex++, ParkingSpotType.LARGE));
        }
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.canFitVehicle(vehicle)) {
                return spot;
            }
        }
        return null;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle);
        if (spot != null) {
            return spot.park(vehicle);
        }
        return false;
    }

    public int getFreeSpotsCount(ParkingSpotType type) {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (spot.getType() == type && spot.isFree()) {
                count++;
            }
        }
        return count;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}
