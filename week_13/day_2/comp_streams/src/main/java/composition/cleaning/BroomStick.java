package composition.cleaning;

import composition.behaviours.IFlyable;

public class BroomStick extends CleaningImplement implements IFlyable {
    int speed;

    public BroomStick(String brand, int speed){
        super(brand);
        this.speed = speed;
    }

    public int getSpeed(){
        return this.speed;
    }

    public String fly(){
        return "mounting broom, running, skipping, flying!";
    }
}


