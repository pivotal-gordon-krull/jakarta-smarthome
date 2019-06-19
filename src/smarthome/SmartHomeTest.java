package smarthome;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SmartHomeTest {

    @Test
    public void turnBulbOn_whenSwitchIsOn() {
        SpyBulb spyBulb = new SpyBulb();
        AlwaysOnSwitch lightSwitch = new AlwaysOnSwitch();

        new SmartHome(spyBulb, lightSwitch);

        assertThat(spyBulb.turnOn_wasCalled(), equalTo(true));
        assertThat(spyBulb.turnOff_wasCalled(), equalTo(false));
    }

    @Test
    public void turnBulbOff_whenSwitchIsOff() {
        SpyBulb spyBulb = new SpyBulb();
        AlwaysOffSwitch lightSwitch = new AlwaysOffSwitch();

        new SmartHome(spyBulb, lightSwitch);

        assertThat(spyBulb.turnOff_wasCalled(), equalTo(true));
        assertThat(spyBulb.turnOn_wasCalled(), equalTo(false));
    }
}

interface Switchable {
    void turnOn();
    void turnOff();
}

class SpyBulb implements Switchable {
    private boolean turnOn_wasCalled;
    private boolean turnOff_wasCalled;

    @Override
    public void turnOn() {
        turnOn_wasCalled = true;
    }

    @Override
    public void turnOff() {
        turnOff_wasCalled = true;
    }

    public boolean turnOn_wasCalled() {
        return turnOn_wasCalled;
    }

    public boolean turnOff_wasCalled() {
        return turnOff_wasCalled;
    }
}

interface Switch {
    boolean isOn();
}

class AlwaysOnSwitch implements Switch {
    @Override
    public boolean isOn() {
        return true;
    }
}

class AlwaysOffSwitch implements Switch {
    @Override
    public boolean isOn() {
        return false;
    }
}
