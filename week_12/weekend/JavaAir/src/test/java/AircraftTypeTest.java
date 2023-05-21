import flights.AircraftType;
import flights.Plane;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class AircraftTypeTest {

    Plane plane;

    @Before
    public void before(){
        plane = new Plane(AircraftType.BOEING_737);
    }

    @Test
    public void canGetCapacity() {
        assertEquals(245, plane.getAircraftCapacity());
    }

    @Test
    public void canGetTotalWeight() {
        assertEquals(227, plane.getAircraftTotalWeight());
    }
}
