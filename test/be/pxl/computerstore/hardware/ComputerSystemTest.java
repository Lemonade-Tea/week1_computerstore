package be.pxl.computerstore.hardware;

import be.pxl.computerstore.hardware.builder.ComputerCaseBuilder;
import be.pxl.computerstore.hardware.builder.MouseBuilder;
import be.pxl.computerstore.hardware.builder.ProcessorBuilder;
import be.pxl.computerstore.util.TooManyPeripheralsException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerSystemTest {

	@Test
	public void setterAndGetterForComputerCase() {
		ComputerSystem computerSystem = new ComputerSystem();
		ComputerCase computerCase = new ComputerCaseBuilder().build();
		computerSystem.setComputerCase(computerCase);
		assertNotNull(computerSystem.getComputerCase());
		assertEquals(computerCase, computerSystem.getComputerCase());
	}
	
	@Test
	public void setterAndGetterForProcessor() {
		ComputerSystem computerSystem = new ComputerSystem();
		Processor processor = new ProcessorBuilder().build();
		computerSystem.setProcessor(processor);
		assertNotNull(computerSystem.getProcessor());
		assertEquals(processor, computerSystem.getProcessor());
	}
	
	@Test
	public void addPeripheralAddsObjectToArray() throws TooManyPeripheralsException {
		ComputerSystem computerSystem = new ComputerSystem();
		Mouse mouse = new MouseBuilder().build();
		computerSystem.addPeripheral(mouse);
		assertNotNull(computerSystem.getPeripherals()[0]);
		assertEquals(mouse, computerSystem.getPeripherals()[0]);
	}
	
	@Test
	public void addPeripheralIncreasesNumberOfPeripherals() throws TooManyPeripheralsException {
		ComputerSystem computerSystem = new ComputerSystem();
		int countBefore = computerSystem.getNumberOfPeripherals();
		Mouse mouse = new MouseBuilder().build();
		computerSystem.addPeripheral(mouse);
		assertEquals(countBefore + 1, computerSystem.getNumberOfPeripherals());
	}
	
	@Test
	public void initialNumberOfPeripheralsIsZero() {
		ComputerSystem computerSystem = new ComputerSystem();
		assertEquals(0, computerSystem.getNumberOfPeripherals());
	}
	
	@Test(expected=TooManyPeripheralsException.class)
	public void tooManyPeripheralsExceptionIsThrownWhenAllowedNumberOfPeripheralsExceeded() throws TooManyPeripheralsException {
		ComputerSystem computerSystem = new ComputerSystem();
		for(int i = 0; i <= ComputerSystem.MAX_PERIPHERAL; i++) {
			computerSystem.addPeripheral(new MouseBuilder().build());
		}
	}
	
}
