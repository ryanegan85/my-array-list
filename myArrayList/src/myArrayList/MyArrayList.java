package myArrayList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import myArrayList.util.Results;


public class MyArrayList {
	private Integer[] array = new Integer[50];
	Queue<Integer> insertionQueue = new LinkedList<>();
	Results res;
	
	public MyArrayList() {
		for(int i=0; i<array.length; i++) {
			array[i] = null;
		}
		res = new Results();
	}
	
	//Inserts value at next free spot in array then sorts; if array
	//is full, more space is added, then value is inserted and the
	//array is sorted.
	//Utilizes Integer.valueOf(...), as this saves on space and time
	//over using the Integer(int x) constructor due to caching.
	public void insertSorted(int newValue) {
		if(newValue < 0 || newValue > 10000) {
			res.writeToStdout("ERROR: Added values must be between 0 and 10000.");
			return;
		}
		boolean inserted = false;
		for(int i=0; i<array.length; i++) {
			if(array[i] == null) {
				array[i] = Integer.valueOf(newValue);
				inserted = true;
				break;
			}
		}
		if(!inserted) {
			this.addSize();
			for(int j=1; j<array.length; j++) {
				if(array[j] == null) {
					array[j] = Integer.valueOf(newValue);
					break;
				}
			}
		}
		
		insertionQueue.add(Integer.valueOf(newValue));
		
		for(int i=0; i<array.length; i++) {
			if(array[i] == null) array[i] = Integer.valueOf(10001);
		}
		Arrays.sort(array);
		for(int i=0; i<array.length; i++) {
			if(array[i].intValue() == 10001) array[i] = null;
		}
	}
	
	
	public void printInsertionOrder() {
		Queue<Integer> temp = new LinkedList<>();
		int counter = insertionQueue.size();
		String insertionOrder = "";
		if(insertionQueue.size() == 0) {
			System.out.println("Insertion queue empty");
		} else {
			for(int i=0; i<counter; i++) {
				insertionOrder = insertionOrder + insertionQueue.peek() + " ";
				temp.add(insertionQueue.remove());
			}
		}
		res.writeToStdout(insertionOrder);
		insertionQueue = temp;
	}
	
	public void removeValue(int value) {
		for(int i=0; i<array.length; i++) {
			if(array[i] != null && array[i].intValue() == value) {
				array[i] = null;
			}
		}
		
		Queue<Integer> temp = new LinkedList<>();
		for(int i=0; i<insertionQueue.size(); i++) {
			if(insertionQueue.peek() != value) {
				temp.add(insertionQueue.remove());
			} else {
				insertionQueue.remove();
			}
		}
		insertionQueue = temp;
	}
	
	public void compact() {
		int newSize = 0;
		int index = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i] != null) newSize++; 
		}
		
		Integer[] temp = new Integer[newSize];
		for(int i=0; i<array.length; i++) {
			if(array[i] != null) {
				temp[index] = array[i];
				index++;
			}
		}
		
		array = temp;
	}
	
	public int indexOf(int value) {
		int notFound = -1;
		
		for(int i=0; i<array.length; i++) {
			if(array[i] != null && array[i].intValue() == value) return i;
		}
		return notFound;
	}
	
	public int size() {
		int size = array.length;
		return size;
	}
	
	public int sum() {
		int sum = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i] != null) sum += array[i].intValue();
		}
		return sum;
	}
	
	private void addSize() {
		int newSize = array.length + 25;
		Integer[] temp = new Integer[newSize];
		
		for(int i=0; i<temp.length; i++) {
			temp[i] = null;
		}
		
		for(int i=0; i<array.length; i++) {
			temp[i] = array[i];
		}
		
		array = temp;
	}
	
	public Integer[] getArr() {
		return array;
	}
	
	private void setArr(Integer[] newArr) {
		array = newArr;
	}
	
	private Queue<Integer> getInsertionQueue() {
		return insertionQueue;
	}
	
	private void setInsertionQueue(Queue<Integer> newQueue) {
		insertionQueue = newQueue;
	}
	
	public int getNumValues() {
		int values = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i] != null) values++;
		}
		return values;
	}
	
	public String toString() {
		String s = "[";
		
		if(array.length == 0) return "[]";
		
		for(int i=0; i<array.length; i++) {
			if(i < array.length-1) {
				s = s + array[i] + ", ";
			} else {
				s = s + array[i] + "]";
			}	
		}
		return s;
	}

}
