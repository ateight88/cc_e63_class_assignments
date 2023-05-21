package flights;

public class Plane {

    private AircraftType type;

    public Plane(AircraftType type) {
        this.type = type;
    }

    public AircraftType getType() {
        return type;
    }

    public int getAircraftCapacity(){
        return this.type.getCapacity();
    }

    public int getAircraftTotalWeight(){
        return this.type.getTotalWeight();
    }
}
