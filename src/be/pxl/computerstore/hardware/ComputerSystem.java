package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Computable;
import be.pxl.computerstore.util.TooManyPeripheralsException;

public class ComputerSystem implements Computable {

    private Processor processor;
    private HardDisk hardDisk;
    private ComputerCase computerCase;

    private Peripheral[] peripherals = new Peripheral[3];

    public ComputerSystem() {
    }

    public ComputerSystem(Processor processor, HardDisk hardDisk, ComputerCase computerCase) {
        setProcessor(processor);
        setComputerCase(computerCase);
        setHardDisk(hardDisk);
    }

    public Peripheral[] getPeripherals() {
        return peripherals;
    }

    public void addPeripheral(Peripheral peripheral) throws TooManyPeripheralsException {
        if (getNumberOfPeripherals() >= 3) {
            throw new TooManyPeripheralsException("Er mogen maar 3 peripherals per computersystem toegevoegd worden.");
        } else {
            peripherals[getNumberOfPeripherals()] = peripheral;
        }
    }

    public int getNumberOfPeripherals() {
        int count = 0;
        for (Peripheral k : peripherals) {
            if (k != null) {
                count++;
            }
        }
        return count;
    }


    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public ComputerCase getComputerCase() {
        return computerCase;
    }

    public void setComputerCase(ComputerCase computerCase) {
        this.computerCase = computerCase;
    }

    @Override
    public double totalPriceExcl() {
        return 0;
    }

    @Override
    public double totalPriceIncl() {
        double totalPriceIncluding = 0;
        for (int i = 1; i < getNumberOfPeripherals(); i++) {
            totalPriceIncluding += peripherals[i - 1].getPrice();
        }
        totalPriceIncluding += processor.getPrice();
        totalPriceIncluding += hardDisk.getPrice();
        totalPriceIncluding += computerCase.getPrice();
        return totalPriceIncluding;
    }
}
