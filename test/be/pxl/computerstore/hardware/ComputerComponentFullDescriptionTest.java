package be.pxl.computerstore.hardware;

import be.pxl.computerstore.hardware.builder.ComputerCaseBuilder;
import be.pxl.computerstore.hardware.builder.DimensionBuilder;
import be.pxl.computerstore.hardware.builder.ProcessorBuilder;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ComputerComponentFullDescriptionTest {
	@Test
	public void processorFullDescriptionTest() {
		Processor processor = new ProcessorBuilder().build();
		String stringUnderTest = processor.getFullDescription();
		assertTrue(stringUnderTest.contains("ArticleNumber = " + processor.getArticleNumber()));
		assertTrue(stringUnderTest.contains("Vendor = " + ProcessorBuilder.VENDOR));
		assertTrue(stringUnderTest.contains("Name = " + ProcessorBuilder.NAME));
		assertTrue(stringUnderTest.contains("Price = " + ProcessorBuilder.PRICE));
		assertTrue(stringUnderTest.contains("Clock speed = " + ProcessorBuilder.CLOCK_SPEED + "GHz"));
	}
	
	@Test
	public void computerCaseFullDescriptionTest() {
		ComputerCase computerCase = new ComputerCaseBuilder().build();
		String stringUnderTest = computerCase.getFullDescription();
		assertTrue(stringUnderTest.contains("ArticleNumber = " + computerCase.getArticleNumber()));
		assertTrue(stringUnderTest.contains("Vendor = " + ComputerCaseBuilder.VENDOR));
		assertTrue(stringUnderTest.contains("Name = " + ComputerCaseBuilder.NAME));
		assertTrue(stringUnderTest.contains("Price = " + ComputerCaseBuilder.PRICE));
		assertTrue(stringUnderTest.contains("Width = " + DimensionBuilder.WIDTH + "mm"));
		assertTrue(stringUnderTest.contains("Height = " + DimensionBuilder.HEIGHT + "mm"));
		assertTrue(stringUnderTest.contains("Depth = " + DimensionBuilder.DEPTH + "mm"));
		assertTrue(stringUnderTest.contains("Weight = " + ComputerCaseBuilder.WEIGHT + "kg"));
	}
}
