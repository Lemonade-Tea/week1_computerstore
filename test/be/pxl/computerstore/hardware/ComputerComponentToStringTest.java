package be.pxl.computerstore.hardware;

import be.pxl.computerstore.hardware.builder.MouseBuilder;
import be.pxl.computerstore.hardware.builder.ProcessorBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ComputerComponentToStringTest {
	@Test
	public void processorToStringTest() {
		Processor processor = new ProcessorBuilder().build();
		String stringUnderTest = processor.toString();
		assertEquals(processor.getName() + " (" + processor.getArticleNumber() + ")", stringUnderTest);
	}
	
	@Test
	public void mouseToStringTest() {
		Mouse mouse = new MouseBuilder().build();
		String stringUnderTest = mouse.toString();
		assertEquals("Mouse " + mouse.getName() + " (" + mouse.getArticleNumber() + ")", stringUnderTest);
	}
}
