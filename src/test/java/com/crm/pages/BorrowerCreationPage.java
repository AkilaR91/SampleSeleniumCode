package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.crm.base.TestBase;
import com.crm.utilities.TestConfig;

public class BorrowerCreationPage extends TestBase {

//	RRPActionKeywords ak = new RRPActionKeywords();
//	String PAN = "ABCDE"+ak.generatePanNo()+"F";
//	String BorrowerName = "Service Borrower   "+ ak.generateBorrowerName();

	public BorrowerCreationPage(WebDriver driver) {
		this.driver = driver;
	   // PageFactory.initElements(driver,this);
	}

//	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div/nav/ul/li[1]/div")
//	public WebElement newCarsMenu;

	// Action Methods

	public void userLogin(String Username, String Password) throws IOException, InterruptedException {

		System.out.println("*****User Login Started******************************");

		ak.input("Username_XPATH", Username);
		ak.input("Password_XPATH", Password);
		Thread.sleep(3000);
		ak.click("Login_XPATH");

	}

	public void createBorrower(String Pan, String Borrowername, String Dateofcommencement, String Assetclass,
			String Lendingtype, String Businesstype, String Constitution, String Marketsegment, String Groupname,
			String RBICode1, String RRPIndustry1) throws IOException, InterruptedException {

		ak.navigate("Borrower_Creation_URL");
		ak.input("PAN_XPATH", Pan);
		ak.tab("PAN_XPATH");
		Thread.sleep(2000);
		ak.Clear("Borrower_Name_XPATH");
		Thread.sleep(2000);

		ak.Clear("Borrower_Name_XPATH");
		ak.input("Borrower_Name_XPATH", Borrowername);
		ak.input("Date_of_Commencement_XPATH", Dateofcommencement);
		// ak.Select("Company_Type",8);
		ak.input("Asset_Class_XPATH", Assetclass);
		ak.PickerSelect("Asset_Class_XPATH", Assetclass);
		ak.input("Lending_Type_XPATH", Lendingtype);
		ak.PickerSelect("Lending_Type_XPATH", Lendingtype);

		ak.input("Business_Type_XPATH", Businesstype);
		ak.PickerSelect("Business_Type_XPATH", Businesstype);

		ak.click("Constitution_XPATH");
		Thread.sleep(3000);
		ak.input("Grid_Search_Box_XPATH", Constitution);

		ak.ENTER("Grid_Search_Box_XPATH");
		Thread.sleep(3000);
		ak.CLICKNEXTTEXTPATH1(Constitution);
		Thread.sleep(2000);
		ak.click("Market_Segment_XPATH");
		Thread.sleep(2000);
		ak.input("Grid_Search_Box_XPATH", Marketsegment);
		Thread.sleep(2000);
		ak.ENTER("Grid_Search_Box_XPATH");
		Thread.sleep(2000);
		ak.CLICKNEXTTEXTPATH1(Marketsegment);
		Thread.sleep(2000);

		ak.click("Group_Name_XPATH");
		ak.input("Grid_Search_Box_XPATH", Groupname);
		ak.ENTER("Grid_Search_Box_XPATH");
		Thread.sleep(2000);
		ak.CLICKNEXTTEXTPATH1(Groupname);
		Thread.sleep(2000);

		ak.click("RBI_Code1_XPATH");
		Thread.sleep(2000);
		ak.input("Grid_Search_Box_XPATH", RBICode1);
		ak.ENTER("Grid_Search_Box_XPATH");
		Thread.sleep(2000);
		ak.CLICKNEXTTEXTPATH1(RBICode1);
		Thread.sleep(2000);
		ak.click("RRP_Industry1_XPATH");
		ak.input("Grid_Search_Box_XPATH", RRPIndustry1);
		Thread.sleep(2000);
		ak.ENTER("Grid_Search_Box_XPATH");
		Thread.sleep(3000);
		ak.CLICKNEXTTEXTPATH1(RRPIndustry1);
		Thread.sleep(2000);
		ak.click("Save_Proceed_XPATH");
		Thread.sleep(7000);

//		ak.DS.BorrowerIDFinance.add(ak.DS.BorrowerID);
//		ak.DS.BorrowerTypeFinance.add("Services");
//
//		ak.DS.BorrowerIDArray.add(ak.DS.BorrowerID);
//		ak.DS.BorrowerType.add("Services");
//
//		ak.DS.SSBorrowerID = ak.DS.BorrowerID;
//
//		Thread.sleep(5000);
//
//		ak.ValidateString(ak.GetText("PAN_Detail"), ex.GetCellData(ak.DS.initialTestCase, 5, ak.DS.SheetName));
//		// ak.ValidateString(ak.GetText("PAN_Detail"),"Testing");
//		ak.ValidateString(ak.GetText("Borrower_Name_Detail"),
//				ex.GetCellData(ak.DS.initialTestCase, 6, ak.DS.SheetName));
//		Thread.sleep(2000);
//		ak.ValidateString(ak.GetText("Asset_Class_Detail"), ex.GetCellData(ak.DS.initialTestCase, 9, ak.DS.SheetName));
//		Thread.sleep(2000);
//		ak.ValidateString(ak.GetText("Lending_Type_Detail"),
//				ex.GetCellData(ak.DS.initialTestCase, 10, ak.DS.SheetName));
//		Thread.sleep(2000);
//		ak.ValidateString(ak.GetText("Business_Type_Detail"),
//				ex.GetCellData(ak.DS.initialTestCase, 11, ak.DS.SheetName));
//		Thread.sleep(2000);
//		JavascriptExecutor je = (JavascriptExecutor) ak.driver;
//		je.executeScript("window.scrollBy(0,300)");
//		// Assert.assertEquals(ak.GetText("Constitution_Detail"),
//		// ex.GetCellData(ak.DS.initialTestCase, 12, ak.DS.SheetName));
//		ak.ValidateString(ak.GetText("Market_Segment_Detail"),
//				ex.GetCellData(ak.DS.initialTestCase, 13, ak.DS.SheetName));
//		Thread.sleep(2000);
//		ak.ValidateString(ak.GetText("Group_Name_Detail"), ex.GetCellData(ak.DS.initialTestCase, 14, ak.DS.SheetName));
//
//		String RBICode = ak.GetText("RBI_Code1_Detail");
//		String[] RBIArrary = RBICode.split("-");
//		String RBIcodeextract = RBIArrary[0];
//		RBIcodeextract = RBIcodeextract.trim();
//		// System.out.println("extracted RBI code ="+RBIcodeextract);
//		ak.ValidateString(RBIcodeextract, ex.GetCellData(ak.DS.initialTestCase, 16, ak.DS.SheetName));
//		ak.ValidateString(ak.GetText("RRP_Industry1_Detail"),
//				ex.GetCellData(ak.DS.initialTestCase, 17, ak.DS.SheetName));		

//		ak.WarningSheetUpdate(ak.DS.BorrowerID, "Services");
//		ak.RASubmitSheetUpdate(ak.DS.BorrowerID, "Services");
//
//		ex.setcelldatawithrow(ak.DS.SSBorrowerID, 1, 4, RRPConstants.SS_Model_Sheet, RRPConstants.Path_Excel);// Update
//																												
//		ex.setcelldatawithrow(ak.DS.SSBorrowerID, 1, 4, RRPConstants.OverrideApproveSheet, RRPConstants.Path_Excel);// Update
//																													
	}

	public void extractBorrowerId(String sheetName) throws InterruptedException, IOException {

		ak.ExWait("Borrower_ID_XPATH");
		BorrowerID = ak.EXTRCT("Borrower_ID_XPATH");
		// excel.setcelldata(BorrowerID, 18);
		excel.setCellData(sheetName, "Borrower ID", 2, BorrowerID);
		Thread.sleep(3000);
	}

	public void financialSheetUpdate(String BorrowerType) throws IOException {

		ak.FinacialSheetUpdate(BorrowerID, BorrowerType);
	}

	public void docSheetUpdate(String BorrowerType) throws IOException {

		ak.DocSheetUpdate(BorrowerID, BorrowerType);
	}

	public void sentSheetUpdate(String BorrowerType) throws IOException {

		ak.SentSheetUpdate(BorrowerID, BorrowerType);
	}

	public void needMoreInfoSheetUpdate(String BorrowerType) throws IOException {

		ak.NeedMoreInfoSheetUpdate(BorrowerID, BorrowerType);

	}

	public void infoProvidedSheetUpdate(String BorrowerType) throws IOException {

		ak.InfoProvidedSheetUpdate(BorrowerID, BorrowerType);

	}

	public void authorizeSheetUpdate(String BorrowerType) throws IOException {

		ak.AuthorizeSheetUpdate(BorrowerID, BorrowerType);

	}

	public void rejectBorrowerSheetUpdate(String BorrowerType) throws IOException {

		ak.RejectSheetUpdate(BorrowerID, BorrowerType);

	}

	public void corporateQualityChecklistSheetUpdate(String BorrowerType) throws IOException {

		ak.CorporateQualityChecklistSheetUpdate(BorrowerID, BorrowerType);
		
	}

	public void AllRatingSheetUpdate(String SheetName) throws IOException {

		ak.RatingSheetUpdate(BorrowerID, SheetName);
	}

	public void WarningSignalSheetUpdate(String SheetName) throws IOException {

		ak.WarningSignalSheetUpdate(BorrowerID, SheetName);
	}

	public void submitForApprovalUpdate(String BorrowerType) throws IOException {

		ak.SubmitForApprovalSheetUpdate(BorrowerID, BorrowerType);

	}

	public void RAApproveUpdate(String BorrowerType) throws IOException {

		ak.RAApproveSheetUpdate(BorrowerID, BorrowerType);
	}

	public void AllSheetUpdate(String BorrowerType) throws IOException {

		ak.AllSheetUpdate(BorrowerID, BorrowerType);

	}

	public void searchBorrowerId(String BorrowerID) throws IOException, InterruptedException {

		ak.navigate("Borrower_Homepage");
		Thread.sleep(3000);

		ak.input("Borrower_ID_Search_XPATH", BorrowerID);

		Thread.sleep(2000);
		ak.click("Search_Button_XPATH");
		Thread.sleep(2000);
		ak.click("Proceed_Button_XPATH");
	}

	public void childBorrowerTab(String Parent_Borrower) throws IOException, InterruptedException {
		ak.navigate("Borrower_Homepage");
		ak.input("Borrower_ID_Search_XPATH", Parent_Borrower);
		Thread.sleep(4000);
		ak.click("Search_Button_XPATH");
		ak.click("Proceed_Button_XPATH");
		Thread.sleep(3000);
		ak.click("Child_Borrower_tab_XPATH");
		ak.click("Child_New_Borrower_link_XPATH");
	}

	public void corporateSpreadSheetUpdate(String BorrowerID, String BorrowerType)
			throws IOException, InterruptedException {

		// Financial file upload
		// ak.RatingFinancialpath();
		// BorrowerID = ak.EXTRCT("Borrower_ID");

		ak.WriteBorrowerID(BorrowerID, BorrowerType);
		Thread.sleep(3000);

	}

	public void finantialUpload(String BorrowerType) throws InterruptedException, IOException {

		// Financial upload
		ak.click("Finacial_upload_tab_XPATH");
		ak.click("Upload_Data_XPATH");
		ak.STOREWINDOWID();
		ak.SWITCHWINDOW();
		Thread.sleep(3000);
		ak.click("File_Financial_Upload_XPATH");
		String FilePath = ak.RatingFinancialpath(BorrowerType);
		ak.FILEUPLOADROBO(FilePath);
		Thread.sleep(3000);
		// ak.Select("Select_year",0);
		ak.Select("Select_year11_XPATH", "2021");
		Thread.sleep(2000);
		ak.click("Import_Button_XPATH");
		Thread.sleep(3000);
		ak.SWICHTOPARENTWIN();
		driver.navigate().refresh();
		Thread.sleep(7000);
		ak.click("Finacial_upload_tab_XPATH");
		Thread.sleep(2000);
		// if (ak.IsDisplyed("No_Data") == true) {
		// ak.akFlag = false;
		// }
		//
		// String temp = ak.PassScreenShot();
		// RRPDriverScript.ExtentTest.log(Status.PASS,
		// RRPDriverScript.TestCaseIDName + " " + " " + RRPDriverScript.TestCaseDes + "
		// is passed successfully ",
		// MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		//
		// RRPLog.EndTestCase("TC19");

	}

	public void docUpload() throws InterruptedException, IOException {

		ak.click("Documents_Tab_XPATH");
		ak.click("Attach_New_Document_XPATH");
		ak.STOREWINDOWID();
		ak.SWITCHWINDOW();

		Thread.sleep(2000);
		ak.ExWait("Attachment_Icon_XPATH");
		ak.click("Attachment_Icon_XPATH");
		String FilePath = TestConfig.DocUpload;
		ak.FILEUPLOADROBO(FilePath);
		Thread.sleep(2000);
		ak.input("Description", "Test");
		Thread.sleep(2000);
		ak.click("Save_Button_XPATH");
		ak.SWICHTOPARENTWIN();
		Thread.sleep(2000);

		ak.SWICHTOPARENTWIN();
		ak.driver.navigate().refresh();
		ak.click("Documents_Tab_XPATH");

	}

	public void sendForApproval() throws IOException, InterruptedException {

		ak.click("Send_for_Approval_Button_XPATH");
		ak.STOREWINDOWID();
		ak.SWITCHWINDOW();
		// ak.BorderHighlight("Confirmation_OK_XPATH");
		Thread.sleep(2000);
		ak.click("Confirmation_OK_XPATH");
		Thread.sleep(2000);
		ak.SWICHTOPARENTWIN();
		Thread.sleep(2000);

		ak.ExWait("Confirmation_OK_XPATH");
		// ak.BorderHighlight("Confirmation_OK_XPATH");
		Thread.sleep(2000);
		ak.click("Confirmation_OK_XPATH");
		Thread.sleep(2000);
		ak.SWICHTOPARENTWIN();
		Thread.sleep(2000);

	}

	public void NeedMoreInfo() throws IOException, InterruptedException {
		ak.ExWait("Self_Assign_Button_XPATH");
		ak.click("Self_Assign_Button_XPATH");
		ak.STOREWINDOWID();
		ak.SWITCHWINDOW();
		Thread.sleep(2000);
		ak.click("Confirmation_OK_XPATH");
		ak.SWICHTOPARENTWIN();
		Thread.sleep(2000);
		ak.click("NeedMoreInfo_Button_XPATH");
		Thread.sleep(3000);
		ak.input("NeedMoreInfo_Comment_XPATH", excel.getCellData("NeedMoreInfoTest", "NeedMoreInfo_Comment", 2));
		Thread.sleep(2000);
		// ak.click("Feedback_Reason", null);
		// ak.click("Double_Click",null);
		ak.Select("Feedback_Reason_XPATH", excel.getCellData("NeedMoreInfoTest", "Feedback Reason", 2));
		ak.click("Update_Comment_XPATH");
		ak.STOREWINDOWID();
		ak.SWITCHWINDOW();
		ak.click("Confirmation_OK_XPATH");
		Thread.sleep(2000);
		ak.SWICHTOPARENTWIN();

	}

	public void InfoProvided() throws IOException, InterruptedException {
		ak.click("Edit_Button_XPATH");
		ak.click("Information_Provided_XPATH");
		ak.input("NeedMoreInfo_Comment_XPATH", excel.getCellData("InfoProvidedTest", "NeedMoreInfo_Comment", 2));
		ak.click("Save_Proceed_XPATH");

	}

	public void authorizeTest() throws IOException, InterruptedException {
		ak.ExWait("Self_Assign_Button_XPATH");
		ak.click("Self_Assign_Button_XPATH");
		ak.STOREWINDOWID();
		ak.SWITCHWINDOW();
		Thread.sleep(2000);
		ak.click("Confirmation_OK_XPATH");
		ak.SWICHTOPARENTWIN();
		Thread.sleep(2000);
		ak.ExWait("Authorize_Button_XPATH");
		ak.click("Authorize_Button_XPATH");
		ak.STOREWINDOWID();
		ak.SWITCHWINDOW();
		Thread.sleep(2000);
		ak.click("Confirmation_OK_XPATH");
		ak.SWICHTOPARENTWIN();
		Thread.sleep(2000);
		ak.STOREWINDOWID();
		ak.SWITCHWINDOW();
		Thread.sleep(2000);
		ak.click("Confirmation_OK_XPATH");
		ak.SWICHTOPARENTWIN();

	}

	public void rejectBorrowerTest() throws IOException, InterruptedException {
		ak.ExWait("Self_Assign_Button_XPATH");
		ak.click("Self_Assign_Button_XPATH");
		ak.STOREWINDOWID();
		ak.SWITCHWINDOW();
		Thread.sleep(2000);
		ak.click("Confirmation_OK_XPATH");
		ak.SWICHTOPARENTWIN();
		Thread.sleep(2000);
		ak.ExWait("Reject_Borrower_Button_XPATH");
		ak.click("Reject_Borrower_Button_XPATH");
		Thread.sleep(2000);
		ak.STOREWINDOWID();
		ak.SWITCHWINDOW();
		ak.ExWait("Reject_Comment_XPATH");
		ak.input("Reject_Comment_XPATH", excel.getCellData("RejectBorrowerTest", "Reject Comment", 2));
		ak.ExWait("Update_Comment_XPATH");
		ak.click("Update_Comment_XPATH");
		Thread.sleep(3000);
		ak.SWICHTOPARENTWIN();
		ak.STOREWINDOWID();
		ak.SWITCHWINDOW();
		ak.click("Confirmation_OK_XPATH");
		Thread.sleep(3000);
		ak.SWICHTOPARENTWIN();
	}

	public void RMReassignmentTest() throws IOException, InterruptedException {

		ak.click("Helpdesk_Reassignment_XPATH");
		ak.click("RM_Search_icon_XPATH");
		Thread.sleep(2000);
		ak.input("Grid_Search_Box_XPATH", excel.getCellData("RMReassignmentTest", "RM", 2));
		ak.ENTER("Grid_Search_Box_XPATH");
		ak.CLICKNEXTTEXTPATH1(excel.getCellData("RMReassignmentTest", "RM", 2));
		ak.click("Update_Comment_XPATH");
		Thread.sleep(3000);

		ak.SWITCHWINDOW();
		ak.click("Confirmation_OK_XPATH");
		Thread.sleep(3000);
		ak.SWICHTOPARENTWIN();

	}

}
