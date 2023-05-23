package composition.people;
//import com.composition.cleaning.BroomStick;
import composition.behaviours.IFlyable;
public class Wizard {
    String name;
//    BroomStick broomstick;
    private IFlyable ride;

//    public Wizard(String name, BroomStick broomstick){
//        this.name = name;
//        this.broomstick = broomstick;
//    }
    public Wizard(String name, IFlyable ride){
        this.name = name;
        this.ride = ride;
    }

    public String getName(){
        return this.name;
    }

//    public BroomStick getBroomstick(){
//        return this.broomStick;
//    }
    public IFlyable getRide(){
        return this.ride;
    }

    public String fly(){
//        return this.broomStick.fly();
        return this.ride.fly();
    }

    public void setRide(IFlyable ride){
        this.ride = ride;
    }
}