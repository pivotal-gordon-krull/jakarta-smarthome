package smarthome;

public class SmartHome {
    public SmartHome(Switchable bulb, Switch lightSwitch) {
        if(lightSwitch.isOn()) {
            bulb.turnOn();
        } else {
            bulb.turnOff();
        }
    }
}
