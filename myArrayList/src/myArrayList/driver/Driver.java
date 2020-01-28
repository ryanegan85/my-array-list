package myArrayList.driver;

import java.io.File;
import java.io.IOException;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

public class Driver {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Correct usage is 'run input.txt output.txt'");
			System.exit(0);
		}
		File input = new File(args[0]);
		File output = new File(args[1]);
		int sum = 0;
		int numLines = 0;
		try {
			//input = new File(args[1]);
			if(!input.exists()) {
				System.out.println("Input file does not exist. Exiting program.");
				System.exit(0);
			}
			//output = new File(args[2]);
			if(output.createNewFile()) {
				System.out.println("Output file not found, creating one.");
			} else {
				System.out.println("Output file found.");
			}
		} catch (IOException e) {
			System.out.println("Error with files.");
		}
		
		MyArrayListTest test = new MyArrayListTest();
		MyArrayList myArray = new MyArrayList();
		Results results = new Results(output);
		test.testMe(myArray, results);
		
		
		FileProcessor fp = new FileProcessor(input);
		numLines = fp.numLines();
		for(int i=1; i<=numLines; i++) {
			myArray.insertSorted(Integer.parseInt(fp.readline(i)));
		}
		sum = myArray.sum();
		results.writeToFile("The sum of all the values in the array list is: " + sum);

	}
}
