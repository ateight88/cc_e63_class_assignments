package polymorphismTest;

import org.junit.Before;
import org.junit.Test;
import polymorphism.Computer;

import static org.junit.Assert.assertEquals;

public class ComputerTest {

    Computer computer;
    @Before
    public void before() {
        computer = new Computer("Mike's Laptop", "Apple", "Macbook Air Pro");
    }

    @Test
    public void hasName(){
        assertEquals("Mike's Laptop", computer.getName());
    }

    @Test
    public void hasMake(){
        assertEquals("Apple", computer.getMake());
    }

    @Test
    public void hasModel(){
        assertEquals("Macbook Air Pro", computer.getModel());
    }

    @Test
    public void canGetStatus(){
        assertEquals("Hard drive crash", computer.getStatus());
    }
}
