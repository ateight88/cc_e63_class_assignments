import machine.Drawer;
import machine.KeyCode;
import org.junit.Before;
import org.junit.Test;
import products.*;

import static org.junit.Assert.*;

public class DrawerTest {
    Drawer drawer;
    Drink drink;
    Sweet sweet;
    ChocBars chocBar;

    @Before
    public void before(){
        drawer = new Drawer(KeyCode.A1, 0.50);
        drink = new Drink("Cola", DrinkType.FIZZY, "Cola");
        chocBar = new ChocBars("Snickers", ChocBarType.NUT, "Caramel");
        sweet =  new Sweet("Jelly Babies");

    }

    @Test
    public void hasCode(){
        assertEquals(KeyCode.A1, drawer.getCode());
    }

    @Test
    public void hasPrice(){

    }

    @Test
    public void beginsEmpty(){
        assertEquals(0, drawer.productCount());
    }

    @Test
    public void canAddProduct(){
        drawer.addProduct(drink);
        assertEquals(1, drawer.productCount());
    }


    @Test
    public void canSellProduct(){
        drawer.addProduct(drink);
        Drink drink = (Drink)drawer.sellProduct();
        assertEquals("Cola", drink.getName());
    }

    @Test
    public void canSellProducts(){
        drawer.addProduct(drink);
        drawer.addProduct(chocBar);
        drawer.addProduct(sweet);

        Product product1 = drawer.sellProduct();
        Product product2 = drawer.sellProduct();
        Product product3 = drawer.sellProduct();

        assertTrue(product1 instanceof Drink);
        assertEquals("Cola", ((Drink) product1).getName());

        assertTrue(product2 instanceof ChocBars);
        assertEquals("Snickers", ((ChocBars) product2).getName());

        assertTrue(product3 instanceof Sweet);
        assertEquals("Jelly Babies", ((Sweet) product3).getName());
    }

}
