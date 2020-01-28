package myArrayList.test;

import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest {
	
	private MyArrayList array;
	private Results res;
	private final String PASS = "pass";
	private final String FAIL = "fail";
	
	public void testMe(MyArrayList myArrayList, Results results) {
		array = myArrayList;
		res = results;
		res.storeNewResult("testInsertSorted", testInsertSorted());
		reset();
		res.storeNewResult("testRemoveValue", testRemoveValue());
		reset();
		res.storeNewResult("testCompact", testCompact());
		reset();
		res.storeNewResult("testIndexOf", testIndexOf());
		reset();
		res.storeNewResult("testSizeAndConstructor", testSizeAndConstructor());
		reset();
		res.storeNewResult("testSum", testSum());
		reset();
		res.storeNewResult("testAddSize", testAddSize());
		reset();
		res.storeNewResult("testToString", testToString());
		reset();
		res.storeNewResult("testInsertionBoundaries", testInsertionBoundaries());
		reset();
		res.storeNewResult("testDuplicates", testDuplicates());
		reset();
		
		res.printResults();
	}
	
	//Tests if a given collection of unsorted integers will be
	//sorted correctly after being added to the array with
	//the insertSorted() method.
	private String testInsertSorted() {
		boolean pass = true;
		
		int[] values = {5, 10, 7, 4, 9, 2};
		int[] sortedValues = {2, 4, 5, 7, 9, 10};
		
		for(int i=0; i<values.length; i++) {
			array.insertSorted(values[i]);
		}
		
		for(int i=0; i<sortedValues.length; i++) {
			if(array.getArr()[i] != sortedValues[i]) {
				pass = false;
			}
		}
		if(pass) {
			return PASS;
		} else {
			return FAIL;
		}
		
	}
	
	//Tests if the removeValue() method correctly
	//removes the specified value, with multiple instances
	//of the value appearing in the array
	private String testRemoveValue() {
		boolean pass = true;
		Integer[] correctArray = {1, 2, 3, 4, 5, 6, null, null, 8, 9};
		
		for(int i=1; i<10; i++) {
			array.insertSorted(i);
		}
		array.insertSorted(7);
		
		array.removeValue(7);
		for(int i=0; i<correctArray.length; i++) {
			if(array.getArr()[i] != correctArray[i]) pass = false;
		}
		
		if(pass) {
			return PASS;
		} else {
			return FAIL;
		}
		
	}
	
	//Tests if the compact() method correctly reduces the size
	//of the array after values have been added with insertSorted()
	//and some being removed with removeValue().
	private String testCompact() {
		Integer[] insertedArray = {1, 2, 3, 4, 5};
		Integer[] correctArray = {1, 4, 5};
		
		array.compact();
		if(array.size() != 0) return FAIL;
		reset();
		
		for(int i=0; i<insertedArray.length; i++) {
			array.insertSorted(insertedArray[i]);
		}
		
		array.compact();
		
		if(array.size() != insertedArray.length) return FAIL;
		
		array.removeValue(2);
		array.removeValue(3);
		
		array.compact();
		
		if(array.size() != correctArray.length) return FAIL;
		
		for(int i=0; i<array.size(); i++) {
			if(array.getArr()[i] != correctArray[i]) return FAIL;
		}
		return "pass";
	}
	
	//Tests the indexOf() method to see if it returns
	//the correct index of the given number, and also checks
	//if it returns -1 when a number not in the array is passed.
	private String testIndexOf() {
		int correctIndex = 5;
		int checkedIndex = 0;
		
		for(int i=1; i<10; i++) {
			array.insertSorted(i);
		}
		
		checkedIndex = array.indexOf(6);
		
		if((checkedIndex == correctIndex) && (array.indexOf(45) == -1)) {
			return PASS;
		} else {
			return FAIL;
		}
	}
	
	//Checks if constructor correctly sets size to 50,
	//and then uses compact() to check if size also changes
	//correctly.
	private String testSizeAndConstructor() {
		if(array.size() != 50 && array.getNumValues() != 0) return "fail";
		
		for(int i=1; i<10; i++) {
			array.insertSorted(i);
		}
		array.compact();
		
		if(array.size() != 9) return FAIL;
		
		return PASS;
	}
	
	//tests to see if the sum() method correctly returns the sum
	//of all the values in the array, and that it correctly
	//returns 0 when no values are in the array.
	private String testSum() {
		int correctSum = 139;
		int checkedSum = 0;
		Integer[] values = {4, 17, 22, 55, 41};
		
		if(array.sum() != 0) return FAIL;
		
		for(int i=0; i<values.length; i++) {
			array.insertSorted(values[i]);
		}
		
		checkedSum = array.sum();
		
		if(correctSum == checkedSum) {
			return PASS;
		} else {
			return FAIL;
		}
	}
	
	//Tests the addSize() method to see if it correctly adds
	//25 spaces to the array when the array is full and a new
	//value is being added through insertSorted.
	private String testAddSize() {
		for(int i=1;i<51; i++) {
			array.insertSorted(i);
		}
		if(array.size() != 50) return FAIL;
		
		array.insertSorted(51);
		
		if(array.size() != 75) return FAIL;
		
		return PASS;
	}
	
	//Checks to see if the toString() method correctly
	//returns a string of the current array.
	private String testToString() {
		String correctString = "[1, 2, 3, 4, 5]";
		String checkedString;
		
		for(int i=1; i<6; i++) {
			array.insertSorted(i);
		}
		
		array.compact();
		checkedString = array.toString();
		
		if(checkedString.equals(correctString)) {
			return PASS;
		} else {
			return FAIL;
		}
	}
	
	private String testInsertionBoundaries() {
		array.insertSorted(0);
		array.insertSorted(10050);
		array.insertSorted(-5);
		array.insertSorted(10000);
		array.insertSorted(9999);
		
		array.compact();
		
		if(array.size() != 3) {
			return FAIL;
		} else {
			return PASS;
		}
	}
	
	//Checks to make sure duplicates added through
	//insertSorted() are correctly added in and
	//sorted into the array.
	private String testDuplicates() {
		int sizeA;
		int sizeB;
		
		Integer[] correctArray = {1, 2, 3, 4, 5, 5, 6, 7};
		array.insertSorted(4);
		array.insertSorted(2);
		array.insertSorted(7);
		array.insertSorted(1);
		array.insertSorted(5);
		array.insertSorted(3);
		array.insertSorted(6);
		sizeA = array.getNumValues();
		
		array.insertSorted(5);
		sizeB = array.getNumValues();
		
		if(sizeA == sizeB) return FAIL;

		for(int i=0; i<correctArray.length; i++) {
			if(array.getArr()[i] != correctArray[i]) return FAIL;
		}
		return PASS;
	}
	
	private void reset() {
		array = new MyArrayList();
	}
}