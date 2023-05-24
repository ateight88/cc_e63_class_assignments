import org.junit.Before;
import org.junit.Test;
import products.Sweet;

import static org.junit.Assert.assertEquals;
public class SweetTest {
    Sweet sweet;

    @Before
    public void before(){
        sweet = new Sweet("Jelly Babies");
    }

    @Test
    public void hasName(){
        assertEquals("Jelly Babies", sweet.getName());
    }
}
