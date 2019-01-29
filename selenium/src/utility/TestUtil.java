package utility;

import java.util.ArrayList;
import java.util.Iterator;

public class TestUtil {
	static Xls_Reader reader;
	static String sheetName = "RegData";
	static String userNameCol = "username";
	static String passCol = "password";

	public static ArrayList<Object[]> getExcelData() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader(
					"/home/manish/git/SeleniumBasics/selenium" + "/src/test/Data/WebDriverTestDataDemo.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = reader.getRowCount(sheetName);

		for (int rowNum = 2; rowNum <= count; rowNum++) {
			String uName = reader.getCellData(sheetName, userNameCol, rowNum);
			String pass = reader.getCellData(sheetName, passCol, rowNum);
			myData.add(new Object[] { uName, pass });
		}
		return myData;
	}

	public static Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getExcelData();
		return testData.iterator();

	}
}
