import coins.Coin;
import coins.CoinType;
import machine.CoinReturn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class CoinReturnTest {

    CoinReturn coinReturn;
    Coin fiftyPence, onePound, twoPound;

    @Before
    public void before(){
        fiftyPence = new Coin(CoinType.FIFTPENCE);
        onePound = new Coin(CoinType.ONEPOUND);
        twoPound = new Coin(CoinType.TWOPOUND);
        coinReturn = new CoinReturn();
    }

    @Test
    public void beginEmpty(){
        assertEquals(0.0, coinReturn.getValueOfCoins(), 0.01);
    }

    @Test
    public void canGetTotal(){
        coinReturn.addCoin(fiftyPence);
        coinReturn.addCoin(onePound);
        coinReturn.addCoin(twoPound);
        assertEquals(3.50, coinReturn.getValueOfCoins(), 0.1);
    }


}
