package usingInterfaces;

//public class usingInterfaces.Car extends usingInterfaces.Vehicle {
public class Car implements Convert {
    private String name;
    private int age;


    public Car(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    Using "inheritance" of usingInterfaces.Vehicle class and "Overriding" the convert method
//    vs
//    Using "interface" and "implementing" the convert method
    public String convert() {
        return "usingInterfaces.Car data";
    }
}

/*
 * A class implementing an interface also takes on the "type" of that interface.
 * This means that once a Java class implements a Java interface you can use an
 * instance of that class as an instance of that interface.
 *
 * We can now treat a `usingInterfaces.Car` as being both a `usingInterfaces.Car` and a `usingInterfaces.Convert` object.
 * Thus we can say that our `usingInterfaces.Car` can have __many types__ or  __many forms__.
 * This is what we mean by the term *polymorphism* - one of the "Four Pillars"
 * of Object Oriented Programming
 *
 * An interface provides a contract when implemented as well as giving our objects
 * the ability to be of that type as well as their primary type (in our case our `car`
 * object is of type `usingInterfaces.Car` and of type `usingInterfaces.Convert` )
 */

