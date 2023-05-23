package usingInterfacesTest;

import org.junit.Test;
import usingInterfaces.Car;
import usingInterfaces.Converter;

import static org.junit.Assert.assertEquals;

public class CarTest {

    @Test
    public void canConvertCar(){
        Car car = new Car("Tesla", 3);

        String message = Converter.process(car);
        assertEquals("usingInterfaces.Car data", message);
    }
}
