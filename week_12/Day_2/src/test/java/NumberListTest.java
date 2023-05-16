//import ArraysList.NumberList;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//
//public class NumberListTest {
//    private NumberList myNumbers;
//
//    @Before
//    public void before(){
//        myNumbers = new NumberList();
//    }
//
//    @Test
//    public void hasNumberOfEntries(){
//        assertEquals(0, myNumbers.getNumberCount());
//    }
//
//    @Test
//    public void canAddNumberToList(){
//        myNumbers.addNumber(12);
//        myNumbers.addNumber(24);
//        assertEquals(2, myNumbers.getNumberCount());
//    }
//
//    @Test
//    public void canGetFirstNumber(){
//        myNumbers.addNumber(12);
//        myNumbers.addNumber(24);
//        assertEquals(24, myNumbers.getNumberAtIndex(1));
//    }
//
//    @Test
//    public void canGetTotal(){
//        myNumbers.addNumber(1);
//        myNumbers.addNumber(2);
//        myNumbers.addNumber(3);
//        myNumbers.addNumber(4);
//        myNumbers.addNumber(5);
//        assertEquals(15, myNumbers.getTotal());
//    }
//}
