import org.junit.Before;
import org.junit.Test;
import people.Passenger;

import static org.junit.Assert.*;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Marcus Miller", 4);
    }

    @Test
    public void canGetName(){
        assertEquals("Marcus Miller", passenger.getName());
    }

    @Test
    public void canSetName(){
        passenger.setName("William");
        assertEquals("William", passenger.getName());
    }

    @Test
    public void canGetNumberOfBags(){
        assertEquals(4, passenger.getBags());
    }

    @Test
    public void canSetNumberOfBags(){
        passenger.setBags(6);
        assertEquals(6, passenger.getBags());
    }
}
