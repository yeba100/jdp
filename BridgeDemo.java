// Implementor
interface Device {
    void turnOn();
    void turnOff();
}

// Concrete Implementors
class TV implements Device {
    public void turnOn() {
        System.out.println("TV is ON");
    }
    public void turnOff() {
        System.out.println("TV is OFF");
    }
}

class Radio implements Device {
    public void turnOn() {
        System.out.println("Radio is ON");
    }
    public void turnOff() {
        System.out.println("Radio is OFF");
    }
}

// Abstraction
class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void turnOnDevice() {
        device.turnOn();
    }

    public void turnOffDevice() {
        device.turnOff();
    }
}

// Usage
public class BridgeDemo {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl(new TV());
        remote.turnOnDevice();
        remote.turnOffDevice();
    }
}
