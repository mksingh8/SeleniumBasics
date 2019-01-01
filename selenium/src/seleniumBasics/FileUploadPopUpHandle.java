package seleniumBasics;

public class FileUploadPopUpHandle {

	public static void main(String[] args) {
		
		FileUploadPopUpHandle obj = new FileUploadPopUpHandle();//creating object
		
		int c = obj.sum(20, 50);//instead of 'c' you can input any variable name
		System.out.println(c);	//printing the result

	}
	
	public int sum(int a, int b) {//return type is integer
		
		int c = a+b;
		return c;
	}

}
