package be.pxl.computerstore.hardware;

import be.pxl.computerstore.hardware.ComputerCase;
import be.pxl.computerstore.hardware.builder.ComputerCaseBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerCaseArticleNumberTest {
	
	@Test
	public void articleNumberIsGeneratedWhenCreatingNewComputerCase() {
		ComputerCase computerCase = new ComputerCase(ComputerCaseBuilder.VENDOR, ComputerCaseBuilder.NAME, ComputerCaseBuilder.PRICE);
		assertNotNull(computerCase.getArticleNumber());
	}
	
	@Test
	public void articleNumberStartsWithFirstThreeLettersOfVendor() {
		ComputerCase computerCase = new ComputerCaseBuilder().vendor("Intel").build();
		assertTrue(computerCase.getArticleNumber().startsWith("INT-"));
	}
	
	@Test
	public void articleNumberStartsWithUppercaseLettersOfVendorWithXs() {
		ComputerCase computerCase = new ComputerCaseBuilder().vendor("TU").build();
		assertTrue(computerCase.getArticleNumber().startsWith("TUX-"));
	}
	
	
	@Test
	public void articleNumberContainsDashAtIndexThree() {
		ComputerCase computerCase = new ComputerCaseBuilder().vendor("TU").build();
		assertEquals(3, computerCase.getArticleNumber().indexOf("-"));
	}
	
	@Test
	public void articleNumberContainsNumbersBetweenIndexFiveAndTen() {
		ComputerCase computerCase = new ComputerCaseBuilder().vendor("TU").build();
		assertTrue(computerCase.getArticleNumber().substring(4, 9).matches("^[0-9]{5}$"));
	}
}
