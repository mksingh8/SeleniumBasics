package exceptionsInJava;

public class ExampleOfExceptions {

	public static void main(String[] args) {
		// System.out.println(divide(4, 2));

		if (args.length > 1) {
			// Convert a string to an integer
			int arg0 = Integer.parseInt(args[0]);
			int arg1 = Integer.parseInt(args[1]);
			System.out.println(divide(arg0, arg1));

			tryCatch();
		}

	}

	public static int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("You can't divide by zero!");
		} else {
			return a / b;
		}
	}
	
	public static int tryCatch() {
		int m = 5;
		int n = 0;
		int result = 0;
		try {
			int k = m / n;
			result = k;
		} catch (ArithmeticException ex) {
			result = 0;
		}
		return result;
	}
	 

}
