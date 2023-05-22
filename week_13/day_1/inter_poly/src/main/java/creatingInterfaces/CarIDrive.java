package creatingInterfaces;

public class CarIDrive implements ICanDrive{
    private String make;
    private String model;
    private int odomoterReading;


    public CarIDrive(String make, String model){
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

    public int getOdomoterReading() {
        return odomoterReading;
    }

    public void move(int distance){
        this.odomoterReading += distance;
    }


    public String start(){ // ADDED
        return "Switch on the ignition";
    }

    public String stop() { // ADDED
        return "Ease off the accelerator, apply the brake";
    }

    public void steer(){
    }

}
