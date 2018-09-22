package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Computable;
import be.pxl.computerstore.util.TooManyPeripheralsException;

public class ComputerSystem implements Computable {

    public static final int MAX_PERIPHERAL = 3;
    private Processor processor;
    private HardDisk hardDisk;
    private ComputerCase computerCase;

    private Peripheral[] peripherals = new Peripheral[MAX_PERIPHERAL];

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
        if (getNumberOfPeripherals() >= MAX_PERIPHERAL) {
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
        double totalPriceExcluding = 0;
        for (int i = 1; i < getNumberOfPeripherals(); i++) {
            totalPriceExcluding += peripherals[i - 1].getPrice();
        }
        if (processor != null){
            totalPriceExcluding += processor.getPrice();
        }
        if (getHardDisk() != null) {
            totalPriceExcluding += hardDisk.getPrice();
        }
        if (getComputerCase() != null) {
            totalPriceExcluding += computerCase.getPrice();
        }
        return Math.round(totalPriceExcluding);
    }

    @Override
    public double totalPriceIncl() {
        return Math.round(totalPriceExcl() * (1 + BTW / 100.0) * 100) / 100.0;
    }
}
