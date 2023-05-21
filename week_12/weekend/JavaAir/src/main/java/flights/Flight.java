package flights;

import people.CrewMember;
import people.Passenger;
import people.Pilot;

import java.util.ArrayList;

public class Flight {
    private ArrayList<Pilot> pilots;
    private ArrayList<CrewMember> crew;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private Airports departureAirport;
    private Airports destinationAirport;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, Airports destinationAirport, Airports departureAirport, String departureTime) {
        this.pilots = new ArrayList<Pilot>();
        this.crew = new ArrayList<CrewMember>();
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destinationAirport = destinationAirport;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }


//    Getters
    public ArrayList<Pilot> getPilots() {
        return pilots;
    }

    public ArrayList<CrewMember> getCrew() {
        return crew;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airports getDepartureAirport() {
        return departureAirport;
    }

    public Airports getDestinationAirport() {
        return destinationAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

//    Setters
public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
}

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int remainingSeats(){
        return (this.plane.getAircraftCapacity() - this.passengers.size());
    }

    public void addPilot(Pilot pilot){
        this.pilots.add(pilot);
    }

    public void addCabinCrew(CrewMember cabinCrew){
        this.crew.add(cabinCrew);
    }

    public void addPassenger(Passenger passenger){
        if (this.plane.getAircraftCapacity() > this.passengers.size()){
            this.passengers.add(passenger);
        }
    }
}
