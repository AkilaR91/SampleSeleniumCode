package com.crm.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.BorrowerCreationPage;
import com.crm.utilities.TestUtil;

public class SSBorrowerCreationTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void ssborrowerCreationTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("ssborrowerCreationTest", excel))) {

			throw new SkipException(
					"Skipping the test " + "ssborrowerCreationTest".toUpperCase() + "as the Run mode is NO");
		}

//		setUp();

		BorrowerCreationPage borrower = new BorrowerCreationPage(driver);
		
		borrower.userLogin(data.get("Username"), data.get("Password"));
		borrower.createBorrower(data.get("PAN"), data.get("Borrower Name"), data.get("Date of Commencement"),
				data.get("Asset Class"), data.get("Lending Type"), data.get("Business Type"), data.get("Constitution"),
				data.get("Market Segment"), data.get("Group name"), data.get("RBI Code1"), data.get("RRP Industry1"));

		// Assert.assertTrue(driver.findElement(By.xpath(OR.getProperty("Status_Code_XPATH"))).getText().equals("New
		// Borrower"));

		ak.validateStatusCode("New Borrower");

		// Update Required Sheets
		borrower.extractBorrowerId("SSBorrowerCreationTest");
		borrower.financialSheetUpdate(data.get("Borrower Type"));
		borrower.docSheetUpdate(data.get("Borrower Type"));
		borrower.sentSheetUpdate(data.get("Borrower Type"));
		borrower.needMoreInfoSheetUpdate(data.get("Borrower Type"));
		borrower.infoProvidedSheetUpdate(data.get("Borrower Type"));
		borrower.authorizeSheetUpdate(data.get("Borrower Type"));
		borrower.rejectBorrowerSheetUpdate(data.get("Borrower Type"));
		borrower.WarningSignalSheetUpdate(data.get("Borrower Type"));
		borrower.corporateQualityChecklistSheetUpdate(data.get("Borrower Type"));
		borrower.AllRatingSheetUpdate("SmallServiceRatingTest");
		borrower.submitForApprovalUpdate(data.get("Borrower Type"));
		borrower.RAApproveUpdate(data.get("Borrower Type"));
		borrower.AllSheetUpdate(data.get("Borrower Type"));


	}

}
