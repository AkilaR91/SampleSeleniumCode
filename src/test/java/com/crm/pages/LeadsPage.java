package com.crm.pages;

import java.io.IOException;

import com.crm.base.TestBase;

public class LeadsPage extends TestBase {

	public void selectLayout(String LayoutName) throws IOException, InterruptedException {

		ak.navigate("LeadObject_URL");
		ak.mouseHover("NewOptn_XPATH");
		Thread.sleep(3000);
		ak.mouseHoverAndClick(LayoutName);
		Thread.sleep(3000);

	}

	public void findLeadFromView(String ViewCategory, String ViewSubCategory, String ViewSubSubCategory, String LeadId)
			throws Exception {

		ak.navigate("LeadObject_URL");

		ak.select("View_Category_XPATH", ViewCategory);
		// System.out.println("View_Category"+ ex.getCellData(1,
		// 0,Constants.Sheet_View));

		ak.select("View_SubCategory_XPATH", ViewSubCategory);
		// System.out.println("View_SubCategory"+ ex.getCellData(1,
		// 2,Constants.Sheet_View));

		ak.select("View_SubSubCategory_XPATH", ViewSubSubCategory);
		// System.out.println("View_SubSubCategory"+ ex.getCellData(1,
		// 1,Constants.Sheet_View));

		ak.flash("View_Srch_XPATH", driver);
		ak.click("View_Srch_XPATH");
		// ak.CLICK("View_Lead", null); //Click on Letest created lead from the view
		Thread.sleep(2000);

		// ***********************************Again Seleting View for data
		// ************************************

//	    ak.SELECTwithDATA("View_Category", ex.getCellData(1, 0,Constants.Sheet_View));
//	     ak.SELECTwithDATA("View_SubCategory", ex.getCellData(1, 2,Constants.Sheet_View));
//	     ak.SELECTwithDATA("View_SubSubCategory", ex.getCellData(1, 1,Constants.Sheet_View));
//	    ak.CLICK("View_Srch");
//	    Thread.sleep(2000);
		// ak.VERIFY("view_lead_number_col", "Lead Number");

		// *****************************************************************************************************

		ak.CLICKONVIEWELEMENT(LeadId); // Passing extracted lead number

	}

	public void clickOnAppointmentFixBtn() throws IOException, InterruptedException {

		ak.flash("Appointment_Fixed_XPATH", driver);
		ak.click("Appointment_Fixed_XPATH");
	}

	public void clickOnDocCollectedBtn() throws IOException, InterruptedException {

		ak.flash("Docs_Collected_XPATH", driver);
		ak.click("Docs_Collected_XPATH");
	}

	public void clickOnReceivedAtBranchBtn() throws IOException, InterruptedException {

		ak.flash("Received_at_Branch_XPATH", driver);
		ak.click("Received_at_Branch_XPATH");
	}

	public void clickOnBranchApproveBtn() throws IOException, InterruptedException {

		ak.flash("Branch_Approved_XPATH", driver);
		ak.click("Branch_Approved_XPATH");
		ak.click("Update_XPATH");
	}

	public void clickOnDispatchedToCpuBtn() throws IOException, InterruptedException {

		ak.flash("Dispatched_To_Cpu_XPATH", driver);
		ak.click("Dispatched_To_Cpu_XPATH");
		ak.click("Update_XPATH");

	}
	
	public void clickOnReceivedAtCpuBtn() throws IOException, InterruptedException {
		ak.flash("Received_At_Cpu_XPATH", driver);
		ak.click("Received_At_Cpu_XPATH");
	}
	
	public void clickOnDVUPassedBtn() throws IOException, InterruptedException {
		ak.flash("DVU_Passed_XPATH", driver);
		ak.click("DVU_Passed_XPATH");
	}
	
	public void clickOnAcceptBPOBtn() throws IOException, InterruptedException {
		ak.flash("Accepted_BPO_XPATH", driver);
		ak.click("Accepted_BPO_XPATH");
	}
	
	public void clickOnAccountOpenedBtn() throws IOException, InterruptedException {
		
		ak.flash("Account_Opened_XPATH", driver);
		ak.click("Account_Opened_XPATH");
		ak.click("Update_XPATH");
	}

	public void selectCustomerMetBy(String BMUsername) throws IOException, InterruptedException {
		ak.click("Cust_Met_By_Srch_XPATH");
		ak.input("Grid_Search_XPATH", BMUsername);
		ak.ENTER("Grid_Search_XPATH");
		ak.CLICKNEXTTEXTPATH1(BMUsername);
		ak.flash("Update_XPATH", driver);
		ak.click("Update_XPATH");

	}

	public void handleAppointmentFixPopup() throws Exception {

		ak.click("Today_Date_XPATH");
		ak.click("Clock_XPATH");
		ak.click("First_TimeSlot_Clock_XPATH");
		ak.input("Comments_XPATH", "Appointment fixed Comment");
		ak.flash("Update_XPATH", driver);
		ak.click("Update_XPATH");

	}

	public void verifyStatusSuccessPopup() throws IOException, InterruptedException {

		ak.verifyNotificationText("Success_Msg_XPATH", "Success");

		ak.flash("Custom_ok_XPATH", driver);
		ak.click("Custom_ok_XPATH");

	}

	

	

	

}
