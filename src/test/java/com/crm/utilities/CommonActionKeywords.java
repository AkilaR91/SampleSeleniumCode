package com.crm.utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.crm.base.TestBase;
import com.crm.listeners.CustomListeners;

public class CommonActionKeywords extends TestBase {

	// public static WebElement element;
	public static JavascriptExecutor je;
	public static String parentwindow;
	

	public void navigate(String locator) throws IOException, InterruptedException {

		try {
			driver.get(config.getProperty(locator));
			log.info("Navigated Successfully To_  " + locator);

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Navigate************");

		}

	}

	public void click(String locator) throws IOException, InterruptedException {

		je = (JavascriptExecutor) driver;

		try {

			if (locator.endsWith("_CSS")) {

				driver.findElement(By.cssSelector(OR.getProperty(locator))).click();

			} else if (locator.endsWith("_XPATH")) {
				ExWait(locator);

				element = driver.findElement(By.xpath(OR.getProperty(locator)));
				je.executeScript("arguments[0].scrollIntoView(true);", element);
				element.click();

			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locator))).click();

			}

			log.info("  Clicked Successfully On_  " + locator);
			CustomListeners.testReport.get().log(Status.INFO, "Clicking on : " + locator);

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			CustomListeners.testReport.get().log(Status.FAIL, "Clicking on : " + locator);
			assertion.fail("***********Not Able To Click************");
		}
	}

	public void input(String locator, String value) {

		try {
			if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);

			} else if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);

			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
			}

			CustomListeners.testReport.get().log(Status.INFO, "Typing in : " + locator + " entered value as " + value);
			log.info("Sent value as: " + value + "    In field: " + locator);

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			CustomListeners.testReport.get().log(Status.FAIL, "Typing in : " + locator + " entered value as " + value);
			assertion.fail("***********Not Able To SendKey************");
		}
	}

	// To handle mouse hover actions
	public void mouseHoverAndClick(String value) throws IOException, InterruptedException {

		try {
			element = driver.findElement(By.xpath("//*[normalize-space()='" + value + "']"));

			Actions a = new Actions(driver);
			// ExWait(locator);
			// a.moveToElement(driver.findElement(By.xpath(OR.getProperty(locator)))).perform();

			ExWait(element);
			a.moveToElement(element).click().build().perform();

			CustomListeners.testReport.get().log(Status.INFO, "Mouse Hover in : " + value);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			CustomListeners.testReport.get().log(Status.FAIL, "Failed to Mouse Hover in : " + value);
			assertion.fail("***********Not Able To Hover And Click************");
		}
	}

	// To handle mouse hover actions
	public void mouseHover(String locator) throws IOException, InterruptedException {
		Actions a = new Actions(driver);
		ExWait(locator);
		element = driver.findElement(By.xpath(OR.getProperty(locator)));
		a.moveToElement(element).perform();
	}

	public void select(String locator, String value) {

		je = (JavascriptExecutor) driver;

		try {
			if (locator.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(OR.getProperty(locator)));
			} else if (locator.endsWith("_XPATH")) {
				element = driver.findElement(By.xpath(OR.getProperty(locator)));
			} else if (locator.endsWith("_ID")) {
				element = driver.findElement(By.id(OR.getProperty(locator)));
			}

			je.executeScript("arguments[0].scrollIntoView(true);", element);
			Select select = new Select(element);
			select.selectByVisibleText(value);
			Thread.sleep(1000);

			CustomListeners.testReport.get().log(Status.INFO,
					"Selecting from dropdown : " + locator + " value as " + value);

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			CustomListeners.testReport.get().log(Status.FAIL,
					"Selecting from dropdown : " + locator + " value as " + value);
			assertion.fail("***********Not Able To Select************");
		}

	}

	public void CLICKONVIEWELEMENT(String value) throws Exception {

		try {
			Thread.sleep(3000);

			JavascriptExecutor je = (JavascriptExecutor) driver;
			element = driver.findElement(By.xpath("//div[text()='" + value
					+ "']/parent::span[1]/parent::div/parent::div/parent::div/following-sibling::div[last()]"));
			// wait.until(ExpectedConditions.visibilityOf(element));
			ak.ExWait(element);
			je.executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();
			CustomListeners.testReport.get().log(Status.INFO, "Selected value as " + value + "From View");

		} catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
			CustomListeners.testReport.get().log(Status.FAIL, "Not Able to Select value as " + value + "From View");
			assertion.fail("***********Not Able To Select************");

		}
	}

	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public void validateIsTrue(String actual, String expected) {

		System.out.println("Actual Value is::" + actual);
		System.out.println("Expected Value is::" + expected);

		Assert.assertTrue(actual.contains(expected));
		System.out.println("Is True Validation Passed::::");

	}

	public void validateStatusCode(String expected) throws IOException, InterruptedException {

		je = (JavascriptExecutor) driver;

		String data = expected;

		element = driver.findElement(
				By.xpath("//div[@class='flex-1 flexbox-row items-center label-field']//span[@title='" + data + "']"));
		ExWait(element);
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		String actual = element.getText();

		System.out.println("Actual Value is::" + actual);
		System.out.println("Expected Value is::" + expected);

		Assert.assertTrue(actual.equals(expected));

		System.out.println("Status Code Validation Passed::::");

	}

	public void verifyNotificationText(String locator, String msg) throws IOException {

		try {

			je = (JavascriptExecutor) driver;

			element = driver.findElement(By.xpath(OR.getProperty(locator)));
			ak.ExWait(element);
			je.executeScript("arguments[0].scrollIntoView(true);", element);

			String actual = element.getText();

			System.out.println("Actual Value is::" + actual);
			System.out.println("Expected Value is::" + msg);

			Assert.assertTrue(actual.equals(msg));

			System.out.println("Notification Text Validation Passed::::");

		} catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
			CustomListeners.testReport.get().log(Status.FAIL, "Notification Text Verification Get Failed");
			assertion.fail("***********Notification Text Verification Get Failed************");

		}

	}

	public void BorderHighlight(String locator) {
		try {
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			JavascriptExecutor js = (JavascriptExecutor) augmentedDriver;
			js.executeScript("arguments[0].setAttribute('style','border: solid 3px red');", OR.getProperty(locator));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tab(String locator) {
		try {

			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(Keys.TAB);
		} catch (Exception e) {

			log.error("Unable to tab " + locator + " " + e.getMessage());
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Tab************");
		}
	}

	public void Clear(String locator) throws InterruptedException {

		driver.findElement(By.xpath(OR.getProperty(locator))).clear();
		Thread.sleep(3000);

	}

	public void PickerSelect(String object, String value) throws IOException, InterruptedException {

		String data = value;

		try {

			element = driver.findElement(By.xpath("//td[contains(text(),'" + data + "')]"));

			element.click();
			log.info("Selected " + data);

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To PickerSelect************");

		}

	}

	public void ENTER(String locator) {

		try {

			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Enter************");

		}
	}

	public void CLICKNEXTTEXTPATH1(String value) throws InterruptedException, IOException {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		String data = value;

		try {
			element = driver.findElement(By.xpath(".//*[contains(@title,'" + data + "')]"));
			je.executeScript("arguments[0].scrollIntoView(true);", element);

			ExWait(element);

			element.click();
			log.info("Element Clicked Sucessfully " + data);

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To CLICKNEXTTEXTPATH1************");
		}

	}

	public void ExWait(String locator) throws IOException, InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(locator))));

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Wait************");

		}

	}

	public void ExWait(WebElement element) throws IOException, InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To ExWait************");
		}

	}

	public String generateRanNum() {
		String Num = RandomStringUtils.randomNumeric(6);
		return (Num);
	}

	public String generateBorrowerName() {
		String UserName = RandomStringUtils.randomAlphabetic(8);
		return (UserName);
	}
	
	
	public void flash(String locator, WebDriver driver) throws IOException, InterruptedException {
		
		je = (JavascriptExecutor) driver;
		
		element = driver.findElement(By.xpath(OR.getProperty(locator)));
		ExWait(element);
		
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<2;i++) {
			changeColor("rgb(255,13,13)",element,driver);
			changeColor(bgcolor,element,driver);
		}
		
	}
	
	
	public void changeColor(String color,WebElement element,WebDriver driver) {
		je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	

	public String EXTRCT(String object) {

		try {
			element = driver.findElement(By.xpath(OR.getProperty(object)));

			String Result = element.getText();
			log.info("Successfully extracted value ");
			System.out.println("Lead Extracted");
			CustomListeners.testReport.get().log(Status.INFO, "****Sucessfully extracted value**** " + object);

			return Result;
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To EXTRCT************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to extract value**** " + object);
			return "";
		}

	}
	

	public void FinacialSheetUpdate(String BorrowerID, String BorrowerType) throws IOException {

		try {
			excel.setCellData("FinancialUploadTest", "TC No", 2, "TC19");
			excel.setCellData("FinancialUploadTest", "Login Role", 2, "RM1");
			excel.setCellData("FinancialUploadTest", "Username", 2, "R6106");
			excel.setCellData("FinancialUploadTest", "Password", 2, "acid_qa");
			excel.setCellData("FinancialUploadTest", "Borrower ID", 2, BorrowerID);
			excel.setCellData("FinancialUploadTest", "Borrower Type", 2, BorrowerType);

			CustomListeners.testReport.get().log(Status.INFO, "****Successfully Updated The Financial Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Financial Sheet**** ");
		}
	}

	public void DocSheetUpdate(String BorrowerID, String BorrowerType) throws IOException {

		try {
			excel.setCellData("DocUploadTest", "TC No", 2, "TC20");
			excel.setCellData("DocUploadTest", "Login Role", 2, "RM1");
			excel.setCellData("DocUploadTest", "Username", 2, "R6106");
			excel.setCellData("DocUploadTest", "Password", 2, "acid_qa");
			excel.setCellData("DocUploadTest", "Borrower ID", 2, BorrowerID);
			excel.setCellData("DocUploadTest", "Borrower Type", 2, BorrowerType);

			CustomListeners.testReport.get().log(Status.INFO, "****Successfully Updated The Doc Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Doc Sheet**** ");
		}
	}

	public void SentSheetUpdate(String BorrowerID, String BorrowerType) throws IOException {

		try {
			excel.setCellData("SendForApprovalTest", "TC No", 2, "TC21");
			excel.setCellData("SendForApprovalTest", "Login Role", 2, "RM1");
			excel.setCellData("SendForApprovalTest", "Username", 2, "R6106");
			excel.setCellData("SendForApprovalTest", "Password", 2, "acid_qa");
			excel.setCellData("SendForApprovalTest", "Borrower ID", 2, BorrowerID);
			excel.setCellData("SendForApprovalTest", "Borrower Type", 2, BorrowerType);

			CustomListeners.testReport.get().log(Status.INFO, "****Successfully Updated The Approval Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Approval Sheet**** ");
		}
	}

	public void AuthorizeSheetUpdate(String BorrowerID, String BorrowerType) throws IOException {

		try {
			excel.setCellData("AuthorizeTest", "TC No", 2, "TC24");
			excel.setCellData("AuthorizeTest", "Login Role", 2, "Helpdesk1");
			excel.setCellData("AuthorizeTest", "Username", 2, "ADFC12313");
			excel.setCellData("AuthorizeTest", "Password", 2, "acid_qa");
			excel.setCellData("AuthorizeTest", "Borrower ID", 2, BorrowerID);
			excel.setCellData("AuthorizeTest", "Borrower Type", 2, BorrowerType);
			excel.setCellData("AuthorizeTest", "Comment of info provided", 2, "Authorized Successfully");

			CustomListeners.testReport.get().log(Status.INFO, "****Successfully Updated The Authorize Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Authorize Sheet**** ");
		}
	}

	public void RejectSheetUpdate(String BorrowerID, String BorrowerType) throws IOException {

		try {
			excel.setCellData("RejectBorrowerTest", "Borrower ID", 2, BorrowerID);
			excel.setCellData("RejectBorrowerTest", "Borrower Type", 2, BorrowerType);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The Reject Borrower Sheet **** ");
		} catch (Exception e) {
			e.printStackTrace();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Reject Borrower Sheet**** ");
		}
	}

	public void NeedMoreInfoSheetUpdate(String BorrowerID, String BorrowerType) throws IOException {

		try {
			excel.setCellData("NeedMoreInfoTest", "Borrower ID", 2, BorrowerID);
			excel.setCellData("NeedMoreInfoTest", "Borrower Type", 2, BorrowerType);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The Need More Info Sheet **** ");
		} catch (Exception e) {
			e.printStackTrace();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Need More Info Sheet**** ");
		}
	}

	public void InfoProvidedSheetUpdate(String BorrowerID, String BorrowerType) throws IOException {

		try {
			excel.setCellData("InfoProvidedTest", "Borrower ID", 2, BorrowerID);
			excel.setCellData("InfoProvidedTest", "Borrower Type", 2, BorrowerType);

			CustomListeners.testReport.get().log(Status.INFO, "****Successfully Updated The Info Provided Sheet **** ");
		} catch (Exception e) {
			e.printStackTrace();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Info Provided Sheet**** ");
		}
	}

	public void WarningSignalSheetUpdate(String BorrowerID, String BorrowerType) throws IOException {

		try {
			excel.setCellData("WarningSignalTest", "Borrower ID", 2, BorrowerID);
			excel.setCellData("WarningSignalTest", "Borrower Type", 2, BorrowerType);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The Warning Signal Sheet **** ");
		} catch (Exception e) {
			e.printStackTrace();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Warning Signal Sheet**** ");
		}
	}

	public void CorporateQualityChecklistSheetUpdate(String BorrowerID, String BorrowerType) throws IOException {

		try {
			excel.setCellData("CorporateQualityChecklistTest", "TC No", 2, "TC24");
			excel.setCellData("CorporateQualityChecklistTest", "Login Role", 2, "RA");
			excel.setCellData("CorporateQualityChecklistTest", "Username", 2, "A28430");
			excel.setCellData("CorporateQualityChecklistTest", "Password", 2, "acid_qa");
			excel.setCellData("CorporateQualityChecklistTest", "Borrower ID", 2, BorrowerID);
			excel.setCellData("CorporateQualityChecklistTest", "Borrower Type", 2, BorrowerType);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The Corporate Quality Checklist Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL,
					"****Fail to Updated The The Corporate Quality Checklist Sheet**** ");
		}
	}

	public void RatingSheetUpdate(String BorrowerID, String SheetName) throws IOException {

		try {
			excel.setCellData(SheetName, "Borrower ID", 2, BorrowerID);

			CustomListeners.testReport.get().log(Status.INFO, "****Successfully Updated" + SheetName);
		} catch (Exception e) {
			e.printStackTrace();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Update" + SheetName);
		}
	}

	public void SubmitForApprovalSheetUpdate(String BorrowerID, String BorrowerType) {
		try {
			excel.setCellData("SubmitForApprovalToRATest", "TC No", 2, "TC24");
			excel.setCellData("SubmitForApprovalToRATest", "Login Role", 2, "RM");
			excel.setCellData("SubmitForApprovalToRATest", "Username", 2, "R6106");
			excel.setCellData("SubmitForApprovalToRATest", "Password", 2, "acid_qa");
			excel.setCellData("SubmitForApprovalToRATest", "Borrower ID", 2, BorrowerID);
			excel.setCellData("SubmitForApprovalToRATest", "Borrower Type", 2, BorrowerType);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The Submit For Approval Sheet**** ");

		} catch (Exception e) {
			e.printStackTrace();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Submit For Approval Sheet**** ");
		}
	}

	public void RAApproveSheetUpdate(String BorrowerID, String BorrowerType) {
		try {
			excel.setCellData("RAApproveTest", "TC No", 2, "TC24");
			excel.setCellData("RAApproveTest", "Login Role", 2, "RA");
			excel.setCellData("RAApproveTest", "Username", 2, "A28430");
			excel.setCellData("RAApproveTest", "Password", 2, "acid_qa");
			excel.setCellData("RAApproveTest", "Borrower ID", 2, BorrowerID);
			excel.setCellData("RAApproveTest", "Borrower Type", 2, BorrowerType);

			CustomListeners.testReport.get().log(Status.INFO, "****Successfully Updated The RA Approve Sheet **** ");
		} catch (Exception e) {
			e.printStackTrace();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The RA Approve Sheet**** ");
		}
	}

	public String RatingFinancialpath(String BorrowerType) {

		if (BorrowerType.equalsIgnoreCase("Services")) {

			String UploadFinancialPath = TestConfig.ServiceFilePath;
			return UploadFinancialPath;

		} else if (BorrowerType.equalsIgnoreCase("Large Services")) {
			String UploadFinancialPath = TestConfig.LargeServiceFilePath;
			return UploadFinancialPath;

		} else if (BorrowerType.equalsIgnoreCase("Manufacturing")) {
			String UploadFinancialPath = TestConfig.SmallManufacturingFilePath;
			return UploadFinancialPath;

		} else if (BorrowerType.equalsIgnoreCase("NBFC")) {
			String UploadFinancialPath = TestConfig.NBFCFilePath;
			return UploadFinancialPath;

		} else if (BorrowerType.equalsIgnoreCase("Large Manufacturing")) {
			String UploadFinancialPath = TestConfig.LargeManufacturingFilePath;
			return UploadFinancialPath;

		} else if (BorrowerType.equalsIgnoreCase("Trader")) {
			String UploadFinancialPath = TestConfig.TraderFilePath;
			return UploadFinancialPath;
		}
		return "";

	}

	public void WriteBorrowerID(String BorrowerId, String BorrowerType) throws IOException {

		System.out.println("Borrower Type is = " + BorrowerType);

		if (BorrowerType.equalsIgnoreCase("Services")) {

			excel = new ExcelReader(TestConfig.ServiceFilePath);

			excel.setCellDataWithRow("Sheet1", 2, 8, BorrowerId);
			System.out.println("SS Sheet Updated.... ");

			excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

		} else if (BorrowerType.equalsIgnoreCase("Large Services")) {
			// brokercode

			excel = new ExcelReader(TestConfig.LargeServiceFilePath);

			excel.setCellDataWithRow("Sheet1", 2, 8, BorrowerId);
			System.out.println("LS Sheet Updated.... ");

			excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

		} else if (BorrowerType.equalsIgnoreCase("Manufacturing")) {
			// brokercode

			excel = new ExcelReader(TestConfig.SmallManufacturingFilePath);

			excel.setCellDataWithRow("Sheet1", 2, 8, BorrowerId);
			System.out.println("Manufacturing Sheet Updated.... ");

			excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

		} else if (BorrowerType.equalsIgnoreCase("NBFC")) {
			// brokercode

			excel = new ExcelReader(TestConfig.NBFCFilePath);

			excel.setCellDataWithRow("Sheet1", 2, 8, BorrowerId);
			System.out.println("NBFC Sheet Updated.... ");

			excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

		} else if (BorrowerType.equalsIgnoreCase("Large Manufacturing")) {
			// brokercode

			excel = new ExcelReader(TestConfig.LargeManufacturingFilePath);

			excel.setCellDataWithRow("Sheet1", 2, 8, BorrowerId);
			System.out.println("LM Sheet Updated.... ");

			excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

		} else if (BorrowerType.equalsIgnoreCase("Trader")) {

			excel = new ExcelReader(TestConfig.TraderFilePath);

			excel.setCellDataWithRow("Sheet1", 2, 8, BorrowerId);
			System.out.println("Trader Sheet Updated.... ");

			excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

		}

	}

	public void STOREWINDOWID() {

		try {
			parentwindow = driver.getWindowHandle();
			log.info("Parent window is stored as " + parentwindow);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void SWITCHWINDOW() {
		try {

			for (String winhandle : driver.getWindowHandles()) {
				driver.switchTo().window(winhandle);
				log.info("Swiched to window name" + driver.getTitle() + " with id " + winhandle);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void SWICHTOPARENTWIN() {

		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.switchTo().window(parentwindow);
			log.info("Swiched to parent window " + driver.getTitle() + " with ID " + parentwindow);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void FILEUPLOADROBO(String filepath) {

		try {
			Robot robo = new Robot();
			/*
			 * element=driver.findElement(By.xpath(object)); robo.setAutoDelay(3000);
			 * element.click();
			 */

			robo.setAutoDelay(3000);
			StringSelection StringSel = new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSel, null);

			robo.setAutoDelay(3000);

			robo.keyPress(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			robo.keyRelease(KeyEvent.VK_V);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);

			log.info("File uploaded succesfully");
			CustomListeners.testReport.get().log(Status.INFO, "****File uploaded succesfully**** ");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void Select(String locator, String data) throws IOException, InterruptedException {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(locator))));

			element = driver.findElement(By.xpath(OR.getProperty(locator)));
			// String data1 = RRPExcelUtility.GetCellData(DS.initialTestCase, ColNum,
			// DS.SheetName);
			// String data = excel.getCellData("BorrowerCreationTest", "Date of
			// Commencement", 2);

			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();

			Select sel = new Select(element);
			sel.selectByVisibleText(data);
			log.info("Sucessfully selected value " + data + "in" + locator);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void CHECKBOX(String locator) throws IOException, InterruptedException {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			element = driver.findElement(By.xpath(OR.getProperty(locator)));
			je.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			element.click();
			// RRPLog.info("CHECKBOX selected for " + object);
			log.info("Sucessfully selected value in " + locator);
			// akFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			// RRPLog.info(" CHECKBOX Not Selected " + object + e.getMessage());
			// ScreenShot(object);
			// akFlag = false;
		}
	}

	public void AllSheetUpdate(String BorrowerID, String BorrowerType) throws IOException {

		// RRPDriverScript.AllSheetUpdate= RRPDriverScript.AllSheetUpdate+1;

		// for (int k= RRPDriverScript.AllSheetUpdate;k<=
		// RRPDriverScript.AllSheetUpdate;k++) {

		excel.setCellData("PendingForDisaggrementTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("PendingForDisaggrementTest", "Borrower Type", 2, BorrowerType);

		excel.setCellData("PendingForDisaggreSendBackTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("PendingForDisaggreSendBackTest", "Borrower Type", 2, BorrowerType);
		excel.setCellData("NBFCQualityChecklistTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("NBFCQualityChecklistTest", "Borrower Type", 2, BorrowerType);
		excel.setCellData("RAReverseTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("RAReverseTest", "Borrower Type", 2, BorrowerType);
		excel.setCellData("RARejectTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("RARejectTest", "Borrower Type", 2, BorrowerType);
		excel.setCellData("RatingReviewProvidedTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("RatingReviewProvidedTest", "Borrower Type", 2, BorrowerType);
		excel.setCellData("ReviewSentbackTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("ReviewSentbackTest", "Borrower Type", 2, BorrowerType);
		excel.setCellData("OverrideAprrovedTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("OverrideAprrovedTest", "Borrower Type", 2, BorrowerType);
		excel.setCellData("OverrideSentBackTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("OverrideSentBackTest", "Borrower Type", 2, BorrowerType);
		excel.setCellData("OverrideSpecialApproveTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("OverrideSpecialApproveTest", "Borrower Type", 2, BorrowerType);
		excel.setCellData("WithdrawRatingTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("WithdrawRatingTest", "Borrower Type", 2, BorrowerType);
		excel.setCellData("GenerateICRTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("GenerateICRTest", "Borrower Type", 2, BorrowerType);
		excel.setCellData("GenerateFCRTest", "Borrower ID", 2, BorrowerID);
		excel.setCellData("GenerateFCRTest", "Borrower Type", 2, BorrowerType);

	}

}