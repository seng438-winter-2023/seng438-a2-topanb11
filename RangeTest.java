package org.jfree.data;
import org.jmock.Mockery;


import static org.junit.Assert.*; import org.junit.*;

public class RangeTest {
	Range testRangeDifferent;
	Range testRangeEqual;
	
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setUpDifferentValueRange() throws Exception { 
    	testRangeDifferent = new Range(-5, 5);
    }
    
    @Before
    public void setUpEqualValueRange() throws Exception { 
    	testRangeEqual = new Range(5, 5);
    }
    
   
	@Test
	/**
	 * getLengthTestDifferentValues tests the getLength() method to see if returns the correct length of the range when lower != upper
	 */
    public void getLengthTestDifferentValues(){
    	assertEquals("Expected length is 10.0", 10.0, testRangeDifferent.getLength(), 0.00000000d);
    }
	
	@Test
	/**
	 * getLengthTestEqualValues tests the getLength() method to see if returns the correct length of the range when lower == upper
	 */
    public void getLengthTestEqualValues(){
    	assertEquals("Expected length is 0", 0, testRangeEqual.getLength(), 0.00000000d);
    }
	
	@Test
	/**
	 * getUpperBoundTestDifferentValues tests the the getUpperBound() method to see if it returns the correct upper bound of the range
	 * when lower != upper  
	 */
	public void getUpperBoundTestDifferentValues() {
		assertEquals("Expected upper bound is 5.0", 5.0, testRangeDifferent.getUpperBound(), 0.00000000d);
	}
	
	@Test
	/**
	 * getUpperBoundTestEqualValues tests the the getUpperBound() method to see if it returns the correct upper bound of the range
	 * when lower == upper
	 */
	public void getUpperBoundTestEqualValues() {
		assertEquals("Expected upper bound is 5.0", 5.0, testRangeEqual.getUpperBound(), 0.00000000d);
	}
	
	@Test
	/**
	 * getLowerBoundTestDifferentValues tests the the getLowerBound() method to see if it returns the correct lower bound of the range
	 * when lower != upper
	 */
	public void getLowerBoundTestDifferentValues() {
		assertEquals("Expected lower bound is -5.0", -5.0, testRangeDifferent.getLowerBound(), 0.00000000d);
	}
	
	@Test
	/**
	 * getLowerBoundTestEqualValues tests the the getUpperBound() method to see if it returns the correct upper bound of the range
	 * when lower == upper 
	 */
	public void getLowerBoundTestEqualValues() {
		assertEquals("Expected lower bound is 5.0", 5.0, testRangeEqual.getLowerBound(), 0.00000000d);
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value is below the lower bound
	 */
	public void containsTestBLB() {
		assertEquals("Expected to return false", false, testRangeDifferent.contains(-7));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value is at the lower bound
	 */
	public void containsTestLB() {
		assertEquals("Expected to return true", true, testRangeDifferent.contains(-5));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value is within the given range
	 */
	public void containsTestNOM() {
		assertEquals("Expected to return true", true, testRangeDifferent.contains(0));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value at the upper bound
	 */
	public void containsTestUB() {
		assertEquals("Expected to return true", true, testRangeDifferent.contains(5));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value above the upper bound
	 */
	public void containsTestAUB() {
		assertEquals("Expected to return false", false, testRangeDifferent.contains(7));
	}

	 @Test
	    /**
	 * intersectionOutOfLowerBound tests the intersection value when the intersection range you are testing
	 * is outside of the lower bound of the original range.
	 * Expected value: False
	 */
	public void intersectionTestBLB() {
	    assertEquals("Expected intersection result is false", false, testRangeDifferent.intersects(-10,-8));
	}

	@Test
	/**
	 * intersectionTestAtLB tests the intersection value when the intersection range you are testing
	 * is exactly at the upper-bound. The range is half within bounds and half outside.
	 * Expected Value: True
	 */
	public void intersectionTestLB() {
	    assertEquals("Expected intersection result is true", true, testRangeDifferent.intersects(-10,0));
	}    
	 
	@Test
	/**
	 * intersectionOutOfLowerBound tests the intersection value when the intersection range you are testing
	 * is exactly within the range you are given.
	 * Expected Value: True
	 */
	public void intersectionTestNOM() {
	    assertEquals("Expected intersection result is true", true, testRangeDifferent.intersects(-1,-1));
	}
	
	@Test
	/**
	 * intersectionTestAtUB tests the intersection value when the intersection range you are testing
	 * is exactly at the upper-bound. The range is half within bounds and half outside.
	 * Expected Value: True
	 */
	public void intersectionTestUB() {
	    assertEquals("Expected intersection result is true", true, testRangeDifferent.intersects(0, 10));
	}
	
	@Test
	/**
	 * intersectionTestOutofUpperBound tests the intersection value when the intersection range you are testing
	 * is completely outside of the upper bound of the range you are testing.
	 * Expected Value: False
	 */
	public void intersectionTestAUB() {
	    assertEquals("Expected intersection result is true", false, testRangeDifferent.intersects(10, 20));
	}
	
    @After
    public void tearDown() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
