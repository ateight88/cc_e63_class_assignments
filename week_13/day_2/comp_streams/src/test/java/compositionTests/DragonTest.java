package compositionTests;

import composition.beasts.Dragon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DragonTest {
    Dragon dragon;

    @Before
    public void before(){
        dragon = new Dragon("Bob");
    }

    @Test
    public void hasName(){
        assertEquals("Bob", dragon.getName());
    }

    @Test
    public void canFly(){
        assertEquals(dragon.fly(),"Standing up tall, beating wings, lift off!");
    }
}
