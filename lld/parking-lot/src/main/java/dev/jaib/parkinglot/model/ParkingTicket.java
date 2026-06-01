package dev.jaib.parkinglot.model;

import java.util.UUID;

public class ParkingTicket {
    private String ticketNumber;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private long entryTime;
    private long exitTime;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketNumber = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = System.currentTimeMillis();
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }
}
