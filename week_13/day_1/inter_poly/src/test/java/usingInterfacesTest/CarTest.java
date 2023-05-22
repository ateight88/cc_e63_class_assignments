package usingInterfacesTest;

import org.junit.Test;
import usingInterfaces.Car;
import usingInterfaces.Converter;

import static org.junit.Assert.assertEquals;

public class CarTest {

    @Test
    public void canConvertCar(){
        // Given we have a car
        Car car = new Car("Tesla", 3);

        // When we pass it to the converter
        String message = Converter.process(car);
        // Then we should see some converted string
        assertEquals("usingInterfaces.Car data", message);
    }
}
