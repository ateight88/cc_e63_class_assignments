import org.junit.Before;
import org.junit.Test;
import products.ChocBarType;
import products.ChocBars;

import static org.junit.Assert.assertEquals;
public class ChocBarsTest {
    ChocBars chocBar1, chocBar2, chocBar3, chocBar4;

    @Before
    public void before(){

        chocBar1 = new ChocBars("Mars", ChocBarType.CARAMEL, "Milk Chocolate");
        chocBar2 = new ChocBars("Snickers", ChocBarType.NUT, "Milk Chocolate");
        chocBar3 = new ChocBars("Bucaneer", ChocBarType.NUGGET, "Milk Chocolate");
        chocBar4 = new ChocBars("DairyMilk", ChocBarType.RAISIN, "Dark Chocolate");
    }

    @Test
    public void hasName(){
        assertEquals("Mars", chocBar1.getName());
        assertEquals("Snickers", chocBar2.getName());
        assertEquals("Bucaneer", chocBar3.getName());
        assertEquals("DairyMilk", chocBar4.getName());
    }

    @Test
    public void hasType(){
        assertEquals(ChocBarType.CARAMEL, chocBar1.getType());
        assertEquals(ChocBarType.NUT, chocBar2.getType());
        assertEquals(ChocBarType.NUGGET, chocBar3.getType());
        assertEquals(ChocBarType.RAISIN, chocBar4.getType());
    }

    @Test
    public void hasFlavour(){
        assertEquals("Milk Chocolate", chocBar1.getFlavour());
        assertEquals("Dark Chocolate", chocBar4.getFlavour());
    }

}
