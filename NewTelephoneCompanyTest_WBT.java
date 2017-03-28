package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany ntc;

	@Before
	public void setUp() throws Exception {
	    ntc = new NewTelephoneCompany();
    }
	
	@Test (expected = UnsupportedOperationException.class)
	public void testComputeChargeNegativeStartTime() {
		ntc.setStartTime(-5);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testComputeChargeNegativeBoundaryStartTime() {
		ntc.setStartTime(-1);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	@Test (expected = UnsupportedOperationException.class)
	public void testComputeAbove2400StartTime() {
		ntc.setStartTime(2544);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	@Test (expected = UnsupportedOperationException.class)
	public void testComputeChargeAboveBounaryStartTime() {
		ntc.setStartTime(2400);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	@Test (expected = UnsupportedOperationException.class)
	public void testComputeChargeAboveBounaryStartTime2() {
		ntc.setStartTime(2401);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	@Test (expected = UnsupportedOperationException.class)
	public void testComputeAbove60StartTime() {
		ntc.setStartTime(1578);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	@Test (expected = UnsupportedOperationException.class)
	public void testComputeChargeAt60StartTime() {
		ntc.setStartTime(1160);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	@Test (expected = UnsupportedOperationException.class)
	public void testComputeChargeAbove60BoundaryStartTime() {
		ntc.setStartTime(1161);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	@Test (expected = UnsupportedOperationException.class)
	public void testComputeChargeInvalidStartTimeAndInputLength() {
		ntc.setStartTime(799);
		ntc.setDuration(-5);
		ntc.computeCharge();
	}


	@Test (expected = UnsupportedOperationException.class)
	public void testDurationAtZero() {
		ntc.setStartTime(1800);
		ntc.setDuration(0);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testNegativeDuration() {
		ntc.setStartTime(1801);
		ntc.setDuration(-1);
		ntc.computeCharge();
	}

	@Test
	public void testDiscountedTimeAndDuration1() {
		ntc.setStartTime(500);
		ntc.setDuration(100);
		
		assertTrue("The output should be 1768.0", ntc.computeCharge() == 1768.0);
	}

	@Test
	public void testDiscountedTimeAndDuration2() {
		ntc.setStartTime(759);
		ntc.setDuration(61);
		
		assertTrue("The output should be 1078.48", ntc.computeCharge() == 1078.48);
	}

	@Test
	public void testDiscountedTimeAndDuration3() {
		ntc.setStartTime(1959);
		ntc.setDuration(61);
		
		assertTrue("The output should be 1078.48", ntc.computeCharge() == 1078.48);
	}
	
	@Test
	public void testDiscountedTimeAndDuration4() {
		ntc.setStartTime(2359);
		ntc.setDuration(65);
		
		assertTrue("The output should be 1149.20", ntc.computeCharge() == 1149.20);
	}
	
	@Test
	public void testDiscountedStartTimeOnly() {
		ntc.setStartTime(0);
		ntc.setDuration(60);
		
		assertTrue("The output should be 1248.00", ntc.computeCharge() == 1248.00);
	}
	
	@Test
	public void testDiscountedStarTime2() {
		ntc.setStartTime(400);
		ntc.setDuration(59);
		
		assertTrue("The output should be 1227.20", ntc.computeCharge() == 1227.20);
	}
	
	@Test
	public void testDiscountedTimeStartTime3() {
		ntc.setStartTime(759);
		ntc.setDuration(1);
		
		assertTrue("The output should be 20.80", ntc.computeCharge() == 20.80);
	}
	
	@Test
	public void testDiscountedTimeStartTime4() {
		ntc.setStartTime(1800);
		ntc.setDuration(10);
		
		assertTrue("The output should be 20.80", ntc.computeCharge() == 208.0);
	}
	
	@Test
	public void testDiscountedTimeStartTime5() {
		ntc.setStartTime(1801);
		ntc.setDuration(10);
		
		assertTrue("The output should be 208.80", ntc.computeCharge() == 208.0);
	}
	
	@Test
	public void testDiscountedTimeStartTime6() {
		ntc.setStartTime(2359);
		ntc.setDuration(10);
		
		assertTrue("The output should be 208.80", ntc.computeCharge() == 208.0);
	}
	
	@Test
	public void testDiscountedDurationOnly() {
		ntc.setStartTime(800);
		ntc.setDuration(65);
		
		assertTrue("The output should be 2298.40", ntc.computeCharge() == 2298.40);
	}
	
	@Test
	public void testDiscountedDurationOnly2() {
		ntc.setStartTime(900);
		ntc.setDuration(61);
		
		assertTrue("The output should be 2156.96", ntc.computeCharge() == 2156.96);
	}
	
	@Test
	public void testNoDiscount() {
		ntc.setStartTime(1000);
		ntc.setDuration(40);
		
		assertTrue("The output should be 1664.00", ntc.computeCharge() == 1664.00);
	}
	
	@Test
	public void testNoDiscount2() {
		ntc.setStartTime(800);
		ntc.setDuration(1);
		
		assertTrue("The output should be 41.6", ntc.computeCharge() == 41.6);
	}

	@Test
	public void testNoDiscount3() {
		ntc.setStartTime(801);
		ntc.setDuration(59);
		
		assertTrue("The output should be 2454.40", ntc.computeCharge() == 2454.40);
	}
	
	@Test
	public void testNoDiscount4() {
		ntc.setStartTime(1759);
		ntc.setDuration(60);
		
		assertTrue("The output should be 2496.00", ntc.computeCharge() == 2496.00);
	}

}
