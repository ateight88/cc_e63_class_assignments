import coins.Coin;
import coins.CoinType;
import machine.CoinReturn;
import machine.Drawer;
import machine.KeyCode;
import machine.VendMachine;
import org.junit.Before;
import org.junit.Test;
import products.ChocBarType;
import products.ChocBars;
import products.Drink;
import products.DrinkType;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class VendMachineTest {
    Coin onePence, twoPence, fiftyPence, onePound, twoPound;
    Drawer drawer;
    CoinReturn coinReturn;
    VendMachine vendMachine;
    Drink drink;
    ChocBars choc;

    @Before
    public void before(){
        onePence = new Coin(CoinType.ONEPENCE);
        twoPence = new Coin(CoinType.TWOPENCE);
        fiftyPence = new Coin(CoinType.FIFTPENCE);
        onePound = new Coin(CoinType.ONEPOUND);
        twoPound = new Coin(CoinType.TWOPOUND);
        drawer = new Drawer(KeyCode.A1, 1.50);
        drink = new Drink("Cola", DrinkType.FIZZY, "Cherry");
        choc = new ChocBars("Mars", ChocBarType.CARAMEL, "Caramel");
        drawer.addProduct(drink);
        ArrayList<Drawer> drawers = new ArrayList<>();
        drawers.add(drawer);
        coinReturn = new CoinReturn();
        vendMachine = new VendMachine(drawers, 0.0, coinReturn);
    }

    @Test
    public void canAddCoins(){
        vendMachine.addCoins(twoPound);
        assertEquals(2.0, vendMachine.getCredit(), 0.01);
    }

    @Test
    public void canRejectInvalidCoins(){
         vendMachine.addCoins(onePence);
         vendMachine.addCoins(twoPence);
         assertEquals(0.0, vendMachine.getCredit(), 0.1);
         assertEquals(0.03, vendMachine.getCoinReturn().getValueOfCoins(), 0.1);
    }

    @Test
    public void getInvalidReturnedCoins(){
         vendMachine.addCoins(twoPence);
        assertEquals(0.02, vendMachine.getCoinReturn().getValueOfCoins(), 0.1);
    }

    @Test
    public void canBuyProducts(){
        vendMachine.addCoins(twoPound);
        Drink drink = (Drink) vendMachine.sellProducts(KeyCode.A1);
        assertEquals("Cola", drink.getName());
        assertEquals(0.0, vendMachine.getCredit(), 0.1);
    }

    @Test
    public void notEnoughCredit(){
        vendMachine.addCoins(onePence);
        vendMachine.addCoins(twoPence);
        ChocBars choc = (ChocBars) vendMachine.sellProducts(KeyCode.A2);
        assertNull(choc);
    }
}
