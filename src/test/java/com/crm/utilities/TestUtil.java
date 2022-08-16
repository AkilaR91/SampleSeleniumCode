package com.crm.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.testng.annotations.DataProvider;

import com.crm.base.TestBase;
import com.crm.listeners.CustomListeners;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestUtil extends TestBase {

//	public static String screenshotPath;
//	public static String screenshotName;
	public static String ScreenShotPath;

//	public static void captureScreenshot() throws IOException {
//
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//		Date d = new Date();
//		screenshotName = "FailSS_" + d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
//
//		FileUtils.copyFile(scrFile,
//				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
//		FileUtils.copyFile(scrFile, new File(".\\reports\\" + screenshotName));
//
//	}
//
//	public static void capturePassScreenshot(String methodName) throws IOException {
//
//		// TakesScreenshot ts= (TakesScreenshot) driver;
//
//		Date d = new Date();
//		screenshotName = methodName.toUpperCase() + "_PassSS_" + d.toString().replace(":", "_").replace(" ", "_")
//				+ ".jpeg";
//		screenshotPath = ".\\POT\\Date_" + d.toString().replace(":", "_").replace(" ", "_") + "\\" + screenshotName;
//
//		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
//				.takeScreenshot(driver);
//		ImageIO.write(screenshot.getImage(), "JPEG", new File(screenshotPath));
//
//	}

	public static void PassScreenShot(String methodName) throws IOException, InterruptedException {

		ScreenShotPath = CustomListeners.ScreenShotFolder + "\\" + " " + methodName.toUpperCase() + ".jpeg";

		// String
		// ScreenShotPath="./target/Passcreenshots/"+DS.TestCaseDes+DS.PassScreenShot+".jpeg";
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenShotPath));

	}

	public static void FailScreenShot(String methodName) throws IOException, InterruptedException {

		ScreenShotPath=CustomListeners.FailedScreenShotFolder+"\\"+" "+methodName.toUpperCase()+".jpeg";
		//String ScreenShotPath="./target/Failscreenshots/"+DS.TestCaseDes+DS.FailedScreenShot+".jpeg";
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenShotPath));
		
	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		//System.out.println("Sheet name in current data provider is::"+sheetName);
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}

	public static boolean isTestRunnable(String testName, ExcelReader excel) {

		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String testCase = excel.getCellData(sheetName, "TC Name", rNum);

			if (testCase.equalsIgnoreCase(testName)) {

				String runmode = excel.getCellData(sheetName, "Runmode", rNum);

				if (runmode.equalsIgnoreCase("Yes"))
					return true;
				else
					return false;
			}

		}
		return false;
	}

}
