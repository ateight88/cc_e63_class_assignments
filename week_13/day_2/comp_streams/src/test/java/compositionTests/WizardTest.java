package compositionTests;

import composition.beasts.Dragon;
import composition.carpets.Carpet;
import composition.carpets.MagicCarpet;
import composition.cleaning.BroomStick;
import composition.people.Wizard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    Wizard wizard;
    BroomStick broomstick;

    Carpet carpet;

    @Before
    public void before(){
        broomstick = new BroomStick("Nimbus", 10);
        wizard = new Wizard("Toby", broomstick);
    }

    @Test
    public void hasName(){
        assertEquals("Toby", wizard.getName());
    }

//    @Test
//    public void canFlyDragon(){
//        Dragon dragon = new Dragon("Tilly");
//        wizard = new Wizard("Toby", dragon);
//        assertEquals("Standing up tall, beating wings, lift off!", wizard.fly());
//    }

    @Test
    public void hasBroomstick(){
        BroomStick ride = (BroomStick) wizard.getRide();
        assertEquals("Nimbus", ride.getBrand());
    }

    @Test
    public void can_fly_broomstick(){
        assertEquals("mounting broom, running, skipping, flying!", wizard.fly());
    }

    @Test
    public void canFlyMagicCarpet(){
        MagicCarpet carpet = new MagicCarpet("Purple");
        wizard = new Wizard("Toby", carpet);
        assertEquals("Hovering up, straightening out, flying off!", wizard.fly());
    }

    @Test
    public void canSetRide(){
        Dragon dragon = new Dragon("Erik");
        MagicCarpet carpet = new MagicCarpet("Purple");

        wizard.setRide(dragon);
        assertEquals("Standing up tall, beating wings, lift off!", wizard.fly());

        wizard.setRide(carpet);
        assertEquals("Hovering up, straightening out, flying off!", wizard.fly());
    }


}
