package be.pxl.computerstore.hardware;

public class Keyboard extends Peripheral {

    public Keyboard(String vendor, String name, double price, KeyboardLayout qwerty) {
        super(vendor, name, price);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n KeyboardLayout = " + "help";
    }
}
