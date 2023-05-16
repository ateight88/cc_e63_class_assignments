import ArraysList.NumberList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class NumbersListClassTest {
    private NumberList myNumbers;

    @Before
    public void before(){
        ArrayList<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(1);
        testNumbers.add(2);
        testNumbers.add(3);
        testNumbers.add(4);
        myNumbers = new NumberList(testNumbers);
    }

    @Test
    public void hasNumberOfEntries(){
        assertEquals(4, myNumbers.getNumberCount());
    }

    @Test
    public void canAddNumberToList(){
        myNumbers.addNumber(12);
        myNumbers.addNumber(24);
        assertEquals(6, myNumbers.getNumberCount());
    }

    @Test
    public void canGetFirstNumber(){
        myNumbers.addNumber(12);
        myNumbers.addNumber(24);
        assertEquals(24, myNumbers.getNumberAtIndex(5));
    }

    @Test
    public void canGetTotal(){
        myNumbers.addNumber(5);
        assertEquals(15, myNumbers.getTotal());
    }
}
