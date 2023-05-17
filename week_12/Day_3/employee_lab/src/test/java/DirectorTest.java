import management.Director;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DirectorTest {
    Director director;
    @Before
    public void before() {
        director = new Director("Alvin Kerswell", "ABC123456", 60000, "IT", 650000.00);
    }

    @Test
    public void hasName() {
        assertEquals("Alvin Kerswell", director.getName());
    }

    @Test
    public void hasNiNumber() {
        assertEquals("ABC123456", director.getNiNumber());
    }

    @Test
    public void hasSalary() {
        assertEquals(60000, director.getSalary());
    }

    @Test
    public void hasDeptName() {
        assertEquals("IT", director.getDeptName());
    }

    @Test
    public void canSetName() {
        director.setName("Barry Tell");
        assertEquals("Barry Tell", director.getName());
    }

    @Test
    public void nameNotNull() {
        director.setName(null);
        assertEquals("Alvin Kerswell", director.getName());
    }

    @Test
    public void canRaiseSalary() {
        director.incSalary(500);
        assertEquals(60500, director.getSalary());
    }

    @Test
    public void canPayBonus() {
        assertEquals(1200, director.payBonus(), 0.1);
    }

    @Test
    public void hasBudget(){
        assertEquals(650000.00, director.getBudget(), 0.1);
    }
}
