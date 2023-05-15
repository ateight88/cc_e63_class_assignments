import org.junit.Test;

import static org.junit.Assert.*;


public class BearTest {
    @Test
    public void hasName() {
        Bear bear = new Bear("Baloo", 25, 45.44);
        assertEquals( "Baloo", bear.getName() );
    }

    @Test
    public void hasAge() {
        Bear bear = new Bear("Baloo", 25, 56.80);
        assertEquals( 25, bear.getAge() );
    }

    @Test
    public void hasWeight(){
        Bear bear = new Bear("Baloo", 35, 95.63);
        double delta = 0.01;
        assertEquals(95.63, bear.getWeight(), delta);
    }

    @Test
    public void readyToHibernateIfGreaterThan80(){
        Bear fatBear = new Bear("Baloo", 25, 105.44);
        assertTrue(fatBear.readyToHibernate());
    }
    @Test
    public void notReadyToHibernateIfLessThan80(){
        Bear thinBear = new Bear("Baloo", 25, 65.44);
        assertFalse(thinBear.readyToHibernate());
    }
}
