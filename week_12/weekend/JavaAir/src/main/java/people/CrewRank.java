package people;

public enum CrewRank {
    CAPTAIN("Captain"),
    FIRSTOFFCER("First Officer"),
    FLIGHTENGINEER("Flight Engineer"),
    FLIGHTATTENDANT("Flight Attendant");

    private final String rank;

    CrewRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}
