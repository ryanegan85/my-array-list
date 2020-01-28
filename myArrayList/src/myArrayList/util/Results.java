package myArrayList.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface,StdoutDisplayInterface {
	private String[] tests = new String[50];
	private String[] results = new String[50];
	private int index = 0;
	private File file;
	
	public Results() {}
	
	public Results(File f) {
		file = f;
	}
	
	public void storeNewResult(String testName, String result) {
		tests[index] = testName;
		results[index] = result;
		index++;
	}
	
	public void printResults() {
		for(int i=0; i<index; i++) {
			System.out.println(tests[i] + ": " + results[i]);
		}
	}

	@Override
	public void writeToStdout(String s) {
		System.out.println(s);
		
	}

	@Override
	public void writeToFile(String s) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(s);
			bw.close();
		} catch (IOException e) {
			writeToStdout("Error writing to file.");
		}
		
	}
	
	private String[] getTests() {
		return tests;
	}
	
	private String[] getResults() {
		return results;
	}
	
	private int getIndex() {
		return index;
	}
	
	private void setTests(String[] newTests) {
		tests = newTests;
	}
	
	private void setResults(String[] newResults) {
		results = newResults;
	}
	
	private void setIndex(int newIndex) {
		index = newIndex;
	}
	
	private File getFile() {
		return file;
	}
	
	public void setFile(File f) {
		file = f;
	}
	
}
