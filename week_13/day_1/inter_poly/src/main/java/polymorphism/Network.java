package polymorphism;

import java.util.ArrayList;

public class Network {
    private String name;
    private ArrayList<INetworkable> devices;

    public Network(String name){
        this.name = name;
        this.devices = new ArrayList<INetworkable>();
    }

    public String getName(){
        return name;
    }

    public int deviceCount(){
        return devices.size();
    }

    public void connect(INetworkable device){
        devices.add(device);
    }

    public void disconnectAll(){
        devices.clear();
    }

    public String produceReport(){
        String report = "";
        for (INetworkable device : this.devices){
            report += device.getStatus();
        }
        return report;
    }
}
