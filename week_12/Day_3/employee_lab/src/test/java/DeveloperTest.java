import techStaff.Developer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class DeveloperTest {

    Developer developer;

    @Before
    public void before() {
        developer = new Developer("Jamey Allbright", "AB2345678", 45000);
    }

    @Test
    public void hasName(){
        assertEquals("Jamey Allbright", developer.getName());
    }

    @Test
    public void hasNiNumber(){
        assertEquals("AB2345678", developer.getNiNumber());
    }

    @Test
    public void hasSalary(){
        assertEquals(45000, developer.getSalary());
    }

    @Test
    public void canSetName(){
        developer.setName("Paul Hancock");
        assertEquals("Paul Hancock", developer.getName());
    }

    @Test
    public void nameNotNull(){
        developer.setName(null);
        assertEquals("Jamey Allbright", developer.getName());
    }

    @Test
    public void canRaiseSalary(){
        developer.incSalary(600);
        assertEquals(45600, developer.getSalary());
    }

    @Test
    public void canPayBonus(){
        assertEquals(450, developer.payBonus(), 0.1);
    }
}
