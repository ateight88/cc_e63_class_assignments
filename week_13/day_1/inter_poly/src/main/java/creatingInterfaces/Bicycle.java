package creatingInterfaces;

public class Bicycle implements IMove, IStop {
    private int distanceTravelled;

    public Bicycle() {
        this.distanceTravelled = 0;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void move(int distance) {
        this.distanceTravelled +=  distance;
    }

    public String stop() {
        return "Stop pedalling and apply the brakes";
    }
}
