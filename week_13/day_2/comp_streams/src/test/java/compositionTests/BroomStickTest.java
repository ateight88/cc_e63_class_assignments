package compositionTests;

import composition.cleaning.BroomStick;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BroomStickTest {
    BroomStick broom;

    @Before
    public void before(){
        broom = new BroomStick("Nimbus",10);
    }

    @Test
    public void hasBrand(){
        assertEquals("Nimbus", broom.getBrand());
    }

    @Test
    public void hasSpeed(){
        assertEquals(10, broom.getSpeed());
    }

    @Test
    public void canFly(){
        assertEquals(broom.fly(),"mounting broom, running, skipping, flying!");
    }
}
