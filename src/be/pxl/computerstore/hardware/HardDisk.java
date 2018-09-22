package be.pxl.computerstore.hardware;

public class HardDisk extends ComputerComponent {

    private int capacity;

    public HardDisk(String vendor, String name, double price, int capacity) {
        super(vendor, name, price);
        setCapacity(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
