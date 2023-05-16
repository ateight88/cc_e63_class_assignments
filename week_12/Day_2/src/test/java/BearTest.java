import BearRiverFish.Bear;
import BearRiverFish.River;
import BearRiverFish.Salmon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BearTest {
    private Bear bear;
    private Salmon salmon;
    private River river;

    @Before
    public void before() {
        bear = new Bear("Baloo");
        salmon = new Salmon();
        river = new River();
        river.addFish(salmon);
    }

    @Test
    public void bellyStartsEmpty(){
        assertEquals(0, bear.foodCount());
    }

    @Test
    public void canEatSalmon(){
        bear.eat(salmon);
        assertEquals(1, bear.foodCount());
    }
    @Test
    public void canEatSalmonRiver(){
        bear.eatFishFromRiver(river);
        assertEquals(1, bear.foodCount());
    }

    @Test
    public void shouldEmptyBellyAfterSleeping(){
        bear.eat(salmon);
        bear.sleep();
        assertEquals(0, bear.foodCount());
    }

    @Test
    public void shouldEmptyBellyAfterSleepingRiver(){
        bear.eatFishFromRiver(river);
        bear.sleep();
        assertEquals(0, bear.foodCount());
    }
}
