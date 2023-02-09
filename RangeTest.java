package org.jfree.data;
import org.jmock.Mockery;


import static org.junit.Assert.*; import org.junit.*;

public class RangeTest {
	
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
    
   
	@Test
	/**
	 * getLengthTestDifferentValues tests the getLength() method to see if returns the correct length of the range when lower != upper
	 */
    public void getLengthTestDifferentValues(){
    	Range testRange = new Range(-5, 5);
    	double actualLength = testRange.getLength();
    	assertEquals("Expected length is 10.0", 10.0, actualLength, 0.00000000d);
    	
    }
	
	@Test
	/**
	 * getLengthTestEqualValues tests the getLength() method to see if returns the correct length of the range when lower == upper
	 */
    public void getLengthTestEqualValues(){
    	Range testRange = new Range(5, 5);
    	double actualLength = testRange.getLength();
    	assertEquals("Expected length is 0", 0, actualLength, 0.00000000d);
    	
    }
	
	@Test
	/**
	 * getUpperBoundTestDifferentValues tests the the getUpperBound() method to see if it returns the correct upper bound of the range
	 * when lower != upper  
	 */
	public void getUpperBoundTestDifferentValues() {
		Range testRange = new Range(-5, 5);
		double actualUpperBound = testRange.getUpperBound();
		assertEquals("Expected upper bound is 5.0", 5.0, actualUpperBound, 0.00000000d);
	}
	
	@Test
	/**
	 * getUpperBoundTestEqualValues tests the the getUpperBound() method to see if it returns the correct upper bound of the range
	 * when lower == upper
	 */
	public void getUpperBoundTestEqualValues() {
		Range testRange = new Range(5, 5);
		double actualUpperBound = testRange.getUpperBound();
		assertEquals("Expected upper bound is 5.0", 5.0, actualUpperBound, 0.00000000d);
	}
	
	@Test
	/**
	 * getLowerBoundTestDifferentValues tests the the getLowerBound() method to see if it returns the correct lower bound of the range
	 * when lower != upper
	 */
	public void getLowerBoundDifferentValues() {
		Range testRange = new Range(-5, 5);
		double actualUpperBound = testRange.getUpperBound();
		assertEquals("Expected lower bound is 5.0", -5.0, actualUpperBound, 0.00000000d);
	}
	
	@Test
	/**
	 * getLowerBoundTestEqualValues tests the the getUpperBound() method to see if it returns the correct upper bound of the range
	 * when lower == upper 
	 */
	public void getLowerBoundTestEqualValues() {
		Range testRange = new Range(5, 5);
		double actualUpperBound = testRange.getUpperBound();
		assertEquals("Expected lower bound is 5.0", 5.0, actualUpperBound, 0.00000000d);
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value is below the lower bound
	 */
	public void containsTestBLB() {
		Range testRange = new Range(-5, 5);
		assertEquals("Expected to return false", false, testRange.contains(-7));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value is at the lower bound
	 */
	public void containsTestLB() {
		Range testRange = new Range(-5, 5);
		assertEquals("Expected to return true", true, testRange.contains(-5));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value is within the given range
	 */
	public void containsTestNOM() {
		Range testRange = new Range(-5, 5);
		assertEquals("Expected to return true", true, testRange.contains(0));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value at the upper bound
	 */
	public void containsTestUB() {
		Range testRange = new Range(-5, 5);
		assertEquals("Expected to return true", true, testRange.contains(5));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value above the upper bound
	 */
	public void containsTestAUB() {
		Range testRange = new Range(-5, 5);
		assertEquals("Expected to return false", false, testRange.contains(7));
	}

    @After
    public void tearDown() throws Exception {
    	
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
