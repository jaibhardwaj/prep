package dev.jaib.parkinglot;

import dev.jaib.parkinglot.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;

    @BeforeEach
    public void setUp() {
        parkingLot = new ParkingLot("Standard Parking Plaza");
        // Level 1: 2 Motorcycle, 2 Compact (Car), 1 Large (Truck) spots
        parkingLot.addLevel(new Level(1, 2, 2, 1));
    }

    @Test
    public void testParkCarSuccess() {
        Vehicle car = new Car("MH12-AB-1234");
        ParkingTicket ticket = parkingLot.parkVehicle(car);
        
        assertNotNull(ticket);
        assertEquals(car, ticket.getVehicle());
        assertFalse(ticket.getSpot().isFree());
        // Since it's a car, it should park in COMPACT spot (or Large if compact is not available, but compact is checked first)
        assertEquals(ParkingSpotType.COMPACT, ticket.getSpot().getType());
    }

    @Test
    public void testParkMotorcycleSuccess() {
        Vehicle moto = new Motorcycle("KA01-ZZ-9999");
        ParkingTicket ticket = parkingLot.parkVehicle(moto);
        
        assertNotNull(ticket);
        assertEquals(ParkingSpotType.MOTORCYCLE, ticket.getSpot().getType());
    }

    @Test
    public void testParkTruckSuccess() {
        Vehicle truck = new Truck("HR55-T-5678");
        ParkingTicket ticket = parkingLot.parkVehicle(truck);
        
        assertNotNull(ticket);
        assertEquals(ParkingSpotType.LARGE, ticket.getSpot().getType());
    }

    @Test
    public void testLotFullForTruck() {
        Vehicle truck1 = new Truck("TRK-01");
        Vehicle truck2 = new Truck("TRK-02");

        ParkingTicket ticket1 = parkingLot.parkVehicle(truck1);
        assertNotNull(ticket1); // First truck parks successfully

        ParkingTicket ticket2 = parkingLot.parkVehicle(truck2);
        assertNull(ticket2); // Second truck fails because there is only 1 LARGE spot
    }

    @Test
    public void testUnparkAndCalculateFee() {
        Vehicle car = new Car("CAR-8888");
        ParkingTicket ticket = parkingLot.parkVehicle(car);
        assertNotNull(ticket);

        double fee = parkingLot.unparkVehicle(ticket);
        // Minimum duration falls to 1 hour, so price should be 20.0 for car
        assertEquals(20.0, fee);
        assertTrue(ticket.getSpot().isFree());
    }

    @Test
    public void testInvalidTicketThrowsException() {
        ParkingTicket fakeTicket = new ParkingTicket(new Car("FAKE"), new ParkingSpot(99, ParkingSpotType.COMPACT));
        assertThrows(IllegalArgumentException.class, () -> {
            parkingLot.unparkVehicle(fakeTicket);
        });
    }
}
