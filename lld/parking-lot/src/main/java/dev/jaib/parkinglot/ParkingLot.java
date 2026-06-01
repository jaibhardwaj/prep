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

    // Thread-safe method to park a vehicle
    public synchronized ParkingTicket parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            ParkingSpot spot = level.findAvailableSpot(vehicle);
            if (spot != null) {
                if (spot.park(vehicle)) {
                    ParkingTicket ticket = new ParkingTicket(vehicle, spot);
                    activeTickets.put(ticket.getTicketNumber(), ticket);
                    return ticket;
                }
            }
        }
        return null; // Parking Lot is full for this vehicle type
    }

    // Thread-safe method to unpark a vehicle and calculate the payment fee
    public synchronized double unparkVehicle(ParkingTicket ticket) {
        if (ticket == null || !activeTickets.containsKey(ticket.getTicketNumber())) {
            throw new IllegalArgumentException("Invalid parking ticket.");
        }
        
        ticket.setExitTime(System.currentTimeMillis());
        ParkingSpot spot = ticket.getSpot();
        spot.unpark();
        activeTickets.remove(ticket.getTicketNumber());

        return calculateFee(ticket);
    }

    private double calculateFee(ParkingTicket ticket) {
        long durationMillis = ticket.getExitTime() - ticket.getEntryTime();
        // Convert to hours (ceil to nearest hour), minimum 1 hour for testing
        long durationHours = (long) Math.ceil(durationMillis / 1000.0 / 3600.0);
        if (durationHours <= 0) {
            durationHours = 1;
        }

        VehicleType type = ticket.getVehicle().getType();
        switch (type) {
            case MOTORCYCLE:
                return durationHours * 10.0;
            case CAR:
                return durationHours * 20.0;
            case TRUCK:
                return durationHours * 30.0;
            default:
                return durationHours * 15.0;
        }
    }

    public int getFreeSpotsCount(ParkingSpotType type) {
        int total = 0;
        for (Level level : levels) {
            total += level.getFreeSpotsCount(type);
        }
        return total;
    }
}
