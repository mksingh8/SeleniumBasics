package exceptionsInJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionConcept {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// Checked Exceptions: are the exceptions that are checked at compile time. If
		// some code within a method throws a checked exception, then the method must
		// either handle the exception or it must specify the exception using throws
		// keyword.
		FileReader file = new FileReader("/home/manish/Documents/example.txt");// FileNotFoundException
		BufferedReader fileInput = new BufferedReader(file);

		// print first 5 lines
		for (int counter = 0; counter < 5; counter++) {
			System.out.println(fileInput.readLine()); // IOException
		}

		fileInput.close();

		ExceptionConcept ec = new ExceptionConcept();

		// System.out.println(ec.divideByZero()); //java.lang.ArithmeticException
		//ec.throwsExcept();//java.lang.NullPointerException
		ec.arrCollections();
		ec.fileConcept();
	}

	// Unchecked Exception: are the exceptions that are not checked at compiled
	// time. In Java exceptions under Error and RuntimeException classes are
	// unchecked exceptions, everything else under throwable is checked.

	public int divideByZero() {
		int x = 0;
		int y = 10;
		int z = y / x;
		return z;
	}

	public void throwsExcept() {

		String str = null;
		System.out.println(str.length());
	}

	// An array created using new Object[10] has 10 null pointers. That's 10 more
	// than we want, so use collections instead, or explicitly fill the array at
	// initialization with:
	public void arrCollections() {

		Object[] objects;
		objects = new Object[] {"blah", 5, new File("/home/manish/Documents/example.txt")};
		System.out.println("Length of the collections ===>" +objects.length);
		System.out.println("Collections contains ====>" +objects);
		String abc = objects.toString();
		System.out.println("abc===>" +abc);

	}
	
	//Many methods that can return a reference null reference. Make sure you check these. For example: 
	public void fileConcept() {
		File file = new File("/home/manish/Documents/example.txt");
		File[] files = file.listFiles();
		if(files !=null) {
			System.out.println("file name is ===> "+file.getName());
		}
		
		
		
	}

}
