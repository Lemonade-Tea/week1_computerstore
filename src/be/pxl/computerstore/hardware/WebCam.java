package be.pxl.computerstore.hardware;

public class WebCam extends Peripheral {

    private int frameRate;

    public WebCam(String vendor, String name, double price, int frameRate) {
        super(vendor, name, price);
        setFrameRate(frameRate);
    }

    public int getFrameRate() {
        return frameRate;
    }

    private void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

}
