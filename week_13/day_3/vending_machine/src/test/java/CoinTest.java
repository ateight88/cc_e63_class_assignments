import coins.Coin;
import coins.CoinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    Coin coin1, coin2;

    @Before
    public void before() {
        coin1 = new Coin(CoinType.ONEPOUND);
        coin2 = new Coin(CoinType.TWOPOUND);
    }

    @Test
    public void hasType(){
        assertEquals(CoinType.ONEPOUND, coin1.getType());
        assertEquals(CoinType.TWOPOUND, coin2.getType());
    }

    @Test
    public void hasValue(){
        assertEquals(1.0, coin1.getValue(),0.01);
        assertEquals(2.0, coin2.getValue(),0.01);
    }
}