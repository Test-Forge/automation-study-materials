class objectExample {

    /*
     Stores the value for light:
     true - if light is on
     false - if light is off
     */
    boolean isOn;

    // Method to turn on the light
    void turnOn() {
        isOn = true;
        System.out.println("Light on? " + isOn);

    }

    // Method to turnoff the light
    void turnOff() {
        isOn = false;
        System.out.println("Light on? " + isOn);
    }
}

class Main {
    public static void main(String[] args) {

        // Create objects led and halogen
        Lamp led = new Lamp();
        Lamp halogen = new Lamp();

        // Turn on the light by calling method turnOn()
        led.turnOn();

        // Turn off the light by calling method turnOff()
        halogen.turnOff();
    }
}