package polymorphismTest;

import org.junit.Before;
import org.junit.Test;
import polymorphism.Printer;

import static org.junit.Assert.assertEquals;

public class PrinterTest {
    Printer printer;

    @Before
    public void before() {
        printer = new Printer(18);
    }

    @Test
    public void canPrint(){
        assertEquals("printing: Laser Scan Test", printer.print("Laser Scan Test"));
    }

    @Test
    public void hasInkLevel(){
        assertEquals(18, printer.getInkLevel());
    }

    @Test
    public void statusIsInkLowWhenLessThan20(){
        assertEquals("Ink Low", printer.getStatus());
    }

    @Test
    public void statusIsInkHighWhen20OrMore(){
        Printer printerInkHigh = new Printer(20);
        assertEquals("Ink High", printerInkHigh.getStatus());
    }
}
