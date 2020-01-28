package myArrayList.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {
	
	File file;
	
	public FileProcessor(File f) {
		file = f;
	}
	
	//Returns the given line from the given file.
	public String readline(int line) {
		int count = 1;
		String temp = "a";
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				if(count == line) {
					temp = scanner.nextLine();
					scanner.close();
					return temp;
				} else {
					scanner.nextLine();
					count++;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public int numLines() {
		int num = 0;
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				num++;
				scanner.nextLine();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return num;
	}
}
