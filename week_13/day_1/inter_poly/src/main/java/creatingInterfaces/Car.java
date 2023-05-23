package creatingInterfaces;

public class Car implements IMove, IStart, IStop {
    private String make;
    private String model;
    private int odomoterReading;

    public Car(String make, String model){
        this.make = make;
        this.model = model;
        this.odomoterReading = 0;
    }


    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getOdometerReading() {
        return odomoterReading;
    }

    public void move(int distance){
        this.odomoterReading += distance;
    }

    public String start(){
        return "Switch on the ignition";
    }

    public String stop() {
        return "Ease off the accelerator, apply the brake";
    }
}
