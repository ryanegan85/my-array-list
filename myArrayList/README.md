# Design Patterns Assignment 1
## Ryan Egan

-----------------------------------------------------------------------
-----------------------------------------------------------------------


## Instruction to clean:

####Command: ant -buildfile myArrayList/src/build.xml clean

Description: It cleans up all the .class files that were generated when code is compiled.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile myArrayList/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile coursesRegistration/src/build.xml run -Darg0=<input_file.txt> -Darg1=<output.txt>

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

MyArrayList: A class that stores values in a custom array, code contains comments describing methods.
Driver: Contains code to create a MyArrayList, insert values in input.txt, call tests from MyArrayListTest, and write 
  results to output.txt.
MyArrayListTest: Contains tests to test the methods of MyArrayList.
FileDisplayInterface: Interface that contains method to write to a file.
FileProcessor: Contains methods that read from the input file.
Results: Stores the results of tests from MyArrayListTest, and implements methods from FileDisplayInterface and StdoutDisplayInterface.
StdoutDisplayInterface: Contains method to print to stdout.

In MyArrayList, a queue is used to store the insertion order into the array. This is because it is only O(1) to remove from the queue,
which is done when reading values to be printed. A queue is also more space efficient than other potential options.
