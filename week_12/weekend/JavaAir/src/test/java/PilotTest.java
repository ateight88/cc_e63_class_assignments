import org.junit.Before;
import org.junit.Test;
import people.CrewRank;
import people.Pilot;

import static org.junit.Assert.*;

public class PilotTest {

    Pilot pilot;

    @Before
    public void before(){
        pilot  = new Pilot("Tim Robbins", CrewRank.CAPTAIN, "TKL140Y");
    }

    @Test
    public void canGetLicenseNum(){
        assertEquals("TKL140Y", pilot.getLicenseNumber());
    }

    @Test
    public void canFly(){
        assertEquals("I Believe I Can Fly", pilot.fly());
    }

}