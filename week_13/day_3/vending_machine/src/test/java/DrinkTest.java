import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import products.Drink;
import products.DrinkType;

public class DrinkTest {
    Drink drink1, drink2, drink3;

    @Before
    public void before(){
        drink1 = new Drink("Sprite", DrinkType.FIZZY, "Lemon");
        drink2 = new Drink("Volvic", DrinkType.STILL, "Orange");
        drink3 = new Drink("Pepsi", DrinkType.DIET, "Cola");
    }

    @Test
    public void hasName(){
        assertEquals("Sprite", drink1.getName());
        assertEquals("Volvic", drink2.getName());
        assertEquals("Pepsi", drink3.getName());
    }

    @Test
    public void hasType(){
        assertEquals(DrinkType.FIZZY, drink1.getType());
        assertEquals(DrinkType.STILL, drink2.getType());
        assertEquals(DrinkType.DIET, drink3.getType());
    }

    @Test
    public void hasFlavour(){
        assertEquals("Lemon", drink1.getFlavour());
        assertEquals("Orange", drink2.getFlavour());
        assertEquals("Cola", drink3.getFlavour());
    }
}
