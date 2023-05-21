import flights.AircraftType;
import flights.Airports;
import flights.Flight;
import flights.Plane;
import org.junit.Before;
import org.junit.Test;
import people.CabinCrew;
import people.CrewRank;
import people.Passenger;
import people.Pilot;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlightTest {

    Flight flight;
    Plane plane;
    Pilot pilot;
    CabinCrew cabinCrew;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void before(){
        passenger1 = new Passenger("Billy", 3);
        passenger2 = new Passenger("Bob", 2);
        passenger3 = new Passenger("Martin", 1);
        cabinCrew = new CabinCrew("Delores", CrewRank.FLIGHTATTENDANT);
        pilot = new Pilot("Irena", CrewRank.CAPTAIN, "SD43TR");
        plane = new Plane(AircraftType.CESSNA_172);
        flight = new Flight(plane, "EY6072", Airports.NEWYORK, Airports.LONDON, "2023, July, 30, 14:50");    }

    @Test
    public void pilotBeginsEmpty() {
        assertEquals(0, flight.getPilots().size());
    }

    @Test
    public void canAddPilot() {
        flight.addPilot(pilot);
        assertEquals(1, flight.getPilots().size());
    }

    @Test
    public void crewBeginsEmpty() {
        assertEquals(0, flight.getCrew().size());
    }

    @Test
    public void canAddCrew() {
        flight.addCabinCrew(cabinCrew);
        assertEquals(1, flight.getCrew().size());
    }

    @Test
    public void passengersBeginsEmpty() {
        assertEquals(0, flight.getPassengers().size());
    }

    @Test
    public void canAddPassengers() {
        flight.addPassenger(passenger1);
        assertEquals(1, flight.getPassengers().size());
    }

    @Test
    public void cannotAddPassengers() {
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertNotEquals(2, flight.getPassengers().size());
    }

    @Test
    public void canGetPlane() {
        Plane planeInfo = flight.getPlane();
        assertEquals("CESSNA_172", planeInfo.getType().toString());
    }

    @Test
    public void canGetFlightNumber() {
        assertEquals("EY6072", flight.getFlightNumber());
    }

    @Test
    public void canSetFLightNumber() {
        flight.setFlightNumber("BAA4620");
        assertEquals("BAA4620", flight.getFlightNumber());
    }

    @Test
    public void canGetDestinationAirportCode() {
        assertEquals("NY", flight.getDestinationAirport().getCode());
    }

    @Test
    public void canGetDepartureAirportCode() {
        assertEquals("LDN", flight.getDepartureAirport().getCode());
    }

    @Test
    public void canGetDepartureTime() {
        assertEquals("2023, July, 30, 14:50", flight.getDepartureTime());
    }

    @Test
    public void canSetDepartureTime() {
        flight.setDepartureTime("2024, August, 30, 14:50");
        assertEquals("2024, August, 30, 14:50", flight.getDepartureTime());
    }

    @Test
    public void canReturnRemainingSeats() {
        flight.addPassenger(passenger1);
        assertEquals(3, flight.remainingSeats());
    }

}
