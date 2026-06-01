package dev.jaib.parkinglot;

import dev.jaib.parkinglot.model.ParkingSpot;
import dev.jaib.parkinglot.model.ParkingSpotType;
import dev.jaib.parkinglot.model.ParkingTicket;
import dev.jaib.parkinglot.model.Vehicle;
import dev.jaib.parkinglot.model.VehicleType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String name;
    private List<Level> levels;
    private Map<String, ParkingTicket> activeTickets;

    public ParkingLot(String name) {
        this.name = name;
        this.levels = new ArrayList<>();
        this.activeTickets = new HashMap<>();
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public synchronized ParkingTicket parkVehicle(Vehicle vehicle) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: ParkingLot.parkVehicle");
    }

    public synchronized double unparkVehicle(ParkingTicket ticket) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: ParkingLot.unparkVehicle");
    }

    public int getFreeSpotsCount(ParkingSpotType type) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: ParkingLot.getFreeSpotsCount");
    }
}
