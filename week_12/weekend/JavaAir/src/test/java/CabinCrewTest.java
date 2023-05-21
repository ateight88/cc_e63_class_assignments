import org.junit.Before;
import org.junit.Test;
import people.CabinCrew;
import people.CrewRank;

import static org.junit.Assert.*;

public class CabinCrewTest {

    CabinCrew cabinCrew;

    @Before
    public void before(){
        cabinCrew = new CabinCrew("Allister", CrewRank.FLIGHTATTENDANT);
    }

    @Test
    public void canGetName(){
        assertEquals("Allister", cabinCrew.getName());
    }

    @Test
    public void canSetName(){
        cabinCrew.setName("Geoffry");
        assertEquals("Geoffry", cabinCrew.getName());
    }

    @Test
    public void canGetRank(){
        assertEquals("Flight Attendant", cabinCrew.getRank().getRank());
    }

    @Test
    public void canMakeAnnouncement(){
        String announcement = cabinCrew.messageTannoy("Welcome on board this flight today");
        assertEquals("Ladies and Gentlemen: Welcome on board this flight today", announcement);
    }

    @Test
    public void canServeFoodAndBeverages(){
        String foodAndBeverages = cabinCrew.foodBeverages("30 minutes");
        assertEquals("Food and drinks service will begin in 30 minutes", foodAndBeverages);
    }
}
