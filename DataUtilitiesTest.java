package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.*;
import org.jmock.*; import org.junit.*;

public class DataUtilitiesTest {

	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }


//    @Before
//    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
//    }
	
	 @Test
	 /**
	  * 
	  */
	 public void calculateColumnTotalForTwoValues() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals("Expected result is 10", 10.0, result, .000000001d);
	 }
	 
	 @Test
	 /**
	  * 
	  */
	 public void calculateColumnTotalZeroValues() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(0));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals("Expected result is 0", 0, result, .000000001d);
	 }
	 
	 @Test
	 /**
	  * 
	  */
	 public void calculateRowTotalForTwoValues() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(0, 1);
	             will(returnValue(2.5));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("Expected result is 10", 10.0, result, .000000001d);
	 }
	 
	 @Test
	 /**
	  * 
	  */
	 public void calculateRowTotalZeroValues() {
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getColumnCount();
	             will(returnValue(0));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("Expected result is 0", 0, result, .000000001d);
	 }
	 
	 @Test
	 /**
	  * 
	  */
	 public void createNumberArrayTestTwoValueArray() {
		 final double array[] = {0,2};
		 final java.lang.Number expected[] = new java.lang.Number[2];
		 expected[0] = 0.0;
		 expected[1] = 2.0;
		 java.lang.Number[] result = DataUtilities.createNumberArray(array);
		 assertArrayEquals("Expected result is [0,2]", expected, result);
	 }
	 
	 @Test
	 /**
	  * 
	  */
	 public void createNumberArrayTestZeroValueArray() {
		 final double array[] = {};
		 final java.lang.Number expected[] = new java.lang.Number[0];
		 java.lang.Number[] result = DataUtilities.createNumberArray(array);
		 assertArrayEquals("Expected result is []", expected, result);
	 }
	 
	 @Test
	 /**
	  * 
	  */
	 public void createNumberArray2DTestTwoByTwoArray() {
		 final double array[][] = {{0,2},{1,3}};
		 final java.lang.Number expected[][] = new java.lang.Number[2][2];
		 expected[0][0] = 0.0;
		 expected[0][1] = 2.0;
		 expected[1][0] = 1.0;
		 expected[1][1] = 3.0;
		 
		 java.lang.Number[][] result = DataUtilities.createNumberArray2D(array);
		 assertArrayEquals("Expected result is [[0,2],[1,3]]", expected, result);
	 }
	 
	 @Test
	 /**
	  * 
	  */
	 public void createNumberArray2DTestZeroValue2DArray() {
		 final double array[][] = {};
		 final java.lang.Number expected[][] = new java.lang.Number[0][0];
		 java.lang.Number[][] result = DataUtilities.createNumberArray2D(array);
		 assertArrayEquals("Expected result is [[]]", expected, result);
	 }
	 
	 @Test
	 /**
	  * 
	  */
	 public void getCumulativePercentagesTestThreeKeyValuePairs() {
	     Mockery mockingContext = new Mockery();
	     KeyedValues keyedValues = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(keyedValues).getValue(0);
	             will(returnValue(5));
	             one(keyedValues).getValue(1);
	             will(returnValue(9));
	             one(keyedValues).getValue(2);
	             will(returnValue(2));
	             one(keyedValues).getKey(0);
	             will(returnValue(0));             
	             one(keyedValues).getKey(1);
	             will(returnValue(1));
	             one(keyedValues).getKey(2);
	             will(returnValue(2));
//	             one(keyedValues).getItemCount();
//	        	 will(returnValue(3));
	         }
	     });
//	     Mockery mockingExpected = new Mockery();
//	     KeyedValues expected = mockingExpected.mock(KeyedValues.class);
//	     mockingExpected.checking(new Expectations() {
//	         {
//	        	 one(expected).getValue(0);
//	             will(returnValue(0.3125));
//	             one(expected).getValue(1);
//	             will(returnValue(0.875));
//	             one(expected).getValue(2);
//	             will(returnValue(1.0));
//	             one(expected).getKey(0);
//	             will(returnValue(0));   
//	             one(expected).getKey(1);
//	             will(returnValue(1));
//	             one(expected).getKey(2);
//	             will(returnValue(2));
//	             one(expected).getItemCount();
//	        	 will(returnValue(3));
//	         }
//	     });
	     KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
//	     assertEquals("Expected result is {0,0.3125},{1,0.875},{2,1.0}", expected, result);
//		 Mockery mockingContext = new Mockery();
//		 final KeyedValues keyValues = mockingContext.mock(KeyedValues.class);
//		 mockingContext.checking(new Expectations() {
//			 {
//				 one(keyValues).getItemCount();
//				 will(returnValue(3));
//				 one(keyValues).getValue(keyValues.getKey(0));
//				 will(returnValue(5));
//			 }
//		 });
	 }
	 
	@After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
