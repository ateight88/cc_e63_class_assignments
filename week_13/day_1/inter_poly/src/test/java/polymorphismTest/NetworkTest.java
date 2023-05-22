package polymorphismTest;

import org.junit.Before;
import org.junit.Test;
import polymorphism.INetworkable;
import polymorphism.Computer;
import polymorphism.Network;
import polymorphism.Printer;

import static org.junit.Assert.assertEquals;


public class NetworkTest {
    Network network;
    Computer computer;
    Printer printer;

    @Before
    public void before() {
        network = new Network("NetWithinNets");
        computer = new Computer("Mike's Computer", "Apple", "Macbook Air Pro");
        printer = new Printer(18);
        INetworkable device = computer;
    }

    @Test
    public void hasName(){
        assertEquals("NetWithinNets", network.getName());
    }


    @Test
    public void deviceListStartsEmpty() {
        assertEquals(0, network.deviceCount());
    }


    @Test
    public void canConnectDesktop() {
        network.connect(computer);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void canConnectPrinter() {  //NEW TEST
        network.connect(printer);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void shouldEmptyDeviceListAfterDisconnectingAll(){
        network.connect(computer);
        network.connect(printer);
        network.disconnectAll();
        assertEquals(0, network.deviceCount());
    }
}
