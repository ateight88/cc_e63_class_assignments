import management.Manager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ManagerTest {

    Manager manager;
    @Before
    public void before() {
         manager = new Manager("Tom Delaney", "ABC123456", 60000, "IT");
    }

    @Test
    public void hasName() {
        assertEquals("Tom Delaney", manager.getName());
    }

    @Test
    public void hasNiNumber() {
        assertEquals("ABC123456", manager.getNiNumber());
    }

    @Test
    public void hasSalary() {
        assertEquals(60000, manager.getSalary());
    }

    @Test
    public void hasDeptName() {
        assertEquals("IT", manager.getDeptName());
    }

    @Test
    public void canSetName() {
        manager.setName("Barry Tell");
        assertEquals("Barry Tell", manager.getName());
    }

    @Test
    public void nameNotNull() {
        manager.setName(null);
        assertEquals("Tom Delaney", manager.getName());
    }

    @Test
    public void canRaiseSalary() {
        manager.incSalary(500);
        assertEquals(60500, manager.getSalary());
    }

    @Test
    public void canPayBonus() {
        assertEquals(600, manager.payBonus(), 0.1);
    }
}
