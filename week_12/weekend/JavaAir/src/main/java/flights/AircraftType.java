package flights;

public enum AircraftType {
    AIRBUS_A380(853, 575),
    CESSNA_172(4, 175),
    BOEING_737(245,227);


    private final int capacity;
    private final int totalWeight;

    AircraftType(int capacity, int totalWeight) {
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}
