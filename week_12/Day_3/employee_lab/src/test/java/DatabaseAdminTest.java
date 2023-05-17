import techStaff.DatabaseAdmin;
import org.junit.Before;
import org.junit.Test;
import techStaff.Developer;
import static org.junit.Assert.*;


public class DatabaseAdminTest {

    DatabaseAdmin databaseAdmin;

    @Before
    public void before() {
        databaseAdmin = new DatabaseAdmin("Susan Cauldwell", "AB23456789", 45000);
    }

    @Test
    public void hasName(){
        assertEquals("Susan Cauldwell", databaseAdmin.getName());
    }

    @Test
    public void hasNiNumber(){
        assertEquals("AB23456789", databaseAdmin.getNiNumber());
    }

    @Test
    public void hasSalary(){
        assertEquals(45000, databaseAdmin.getSalary());
    }

    @Test
    public void canSetName(){
        databaseAdmin.setName("Paul Hancock");
        assertEquals("Paul Hancock", databaseAdmin.getName());
    }

    @Test
    public void nameNotNull(){
        databaseAdmin.setName(null);
        assertEquals("Susan Cauldwell", databaseAdmin.getName());
    }

    @Test
    public void canRaiseSalary(){
        databaseAdmin.incSalary(600);
        assertEquals(45600, databaseAdmin.getSalary());
    }

    @Test
    public void canPayBonus(){
        assertEquals(450, databaseAdmin.payBonus(), 0.1);
    }
}
