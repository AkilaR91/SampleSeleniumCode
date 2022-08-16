package com.crm.pages;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import com.crm.base.TestBase;
import com.crm.listeners.CustomListeners;

public class CommonFunctionPage extends TestBase {
	
	public void userLogin(String Username, String Password) throws IOException, InterruptedException {

		System.out.println("*****User Login Started******************************");

		ak.input("Username_XPATH", Username);
		ak.input("Password_XPATH", Password);
		Thread.sleep(3000);
		ak.click("Login_XPATH");

	}
	
	public void selectRole(String role) throws IOException, InterruptedException {
		
		ak.click("Profile_XPATH");
		ak.select("roles_XPATH", role);
		Thread.sleep(1000);
	}
	
	public void selectAppLauncher() throws IOException, InterruptedException {
		
		ak.click("AppLauncher_Icon_XPATH");
		ak.click("AppLauncher_Explore_XPATH");
		Thread.sleep(2000);
	}
	
	public void extractLeadId(String sheetName) throws InterruptedException, IOException {

		ak.ExWait("Lead_ID_XPATH");
		LeadID = ak.EXTRCT("Lead_ID_XPATH");

		excel.setCellData(sheetName, "Lead ID", 2, LeadID);
		Thread.sleep(3000);
	}
	
	public void appointmentSheetUpdate(String ViewCategory, String ViewSubCategory, String ViewSubSubCategory, int RowNum) {

		try {

			excel.setCellData("AppointmentFixTest", "Lead Id", RowNum, LeadID);
			excel.setCellData("AppointmentFixTest", "View Category", RowNum, ViewCategory);
			excel.setCellData("AppointmentFixTest", "View Sub Category", RowNum, ViewSubCategory);
			excel.setCellData("AppointmentFixTest", "View Sub Sub Category", RowNum, ViewSubSubCategory);

			CustomListeners.testReport.get().log(Status.INFO, "****Successfully Updated The Appointment Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Appointment Sheet**** ");
		}
	}

	public void docCollectedSheetUpdate(String ViewCategory, String ViewSubCategory, String ViewSubSubCategory, int RowNum) {

		try {

			excel.setCellData("DocCollectedTest", "Lead Id", RowNum, LeadID);
			excel.setCellData("DocCollectedTest", "View Category", RowNum, ViewCategory);
			excel.setCellData("DocCollectedTest", "View Sub Category", RowNum, ViewSubCategory);
			excel.setCellData("DocCollectedTest", "View Sub Sub Category", RowNum, ViewSubSubCategory);

			CustomListeners.testReport.get().log(Status.INFO, "****Successfully Updated The Doc Collected Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Doc Collected Sheet**** ");
		}
	}

	public void receivedAtBranchSheetUpdate(String ViewCategory, String ViewSubCategory, String ViewSubSubCategory, int RowNum) {

		try {

			excel.setCellData("ReceivedAtBranchTest", "Lead Id", RowNum, LeadID);
			excel.setCellData("ReceivedAtBranchTest", "View Category", RowNum, ViewCategory);
			excel.setCellData("ReceivedAtBranchTest", "View Sub Category", RowNum, ViewSubCategory);
			excel.setCellData("ReceivedAtBranchTest", "View Sub Sub Category", RowNum, ViewSubSubCategory);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The Received At Branch Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Received At Branch Sheet**** ");
		}
	}

	public void branchApproveSheetUpdate(String ViewCategory, String ViewSubCategory, String ViewSubSubCategory, int RowNum) {

		try {

			excel.setCellData("BranchApprovedTest", "Lead Id", RowNum, LeadID);
			excel.setCellData("BranchApprovedTest", "View Category", RowNum, ViewCategory);
			excel.setCellData("BranchApprovedTest", "View Sub Category", RowNum, ViewSubCategory);
			excel.setCellData("BranchApprovedTest", "View Sub Sub Category", RowNum, ViewSubSubCategory);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The Branch Approved Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Branch Approved Sheet**** ");
		}
	}

	public void dispatchedToCPUSheetUpdate(String ViewCategory, String ViewSubCategory, String ViewSubSubCategory, int RowNum) {
		try {

			excel.setCellData("DispatchedToCPUTest", "Lead Id", RowNum, LeadID);
			excel.setCellData("DispatchedToCPUTest", "View Category", RowNum, ViewCategory);
			excel.setCellData("DispatchedToCPUTest", "View Sub Category", RowNum, ViewSubCategory);
			excel.setCellData("DispatchedToCPUTest", "View Sub Sub Category", RowNum, ViewSubSubCategory);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The Dispatched To CPU Test Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL,
					"****Fail to Updated The Dispatched To CPU Test Sheet**** ");
		}

	}

	public void receivedAtCPUSheetUpdate(String ViewCategory, String ViewSubCategory, String ViewSubSubCategory, int RowNum) {
		try {

			excel.setCellData("ReceivedAtCPUTest", "Lead Id", RowNum, LeadID);
			excel.setCellData("ReceivedAtCPUTest", "View Category", RowNum, ViewCategory);
			excel.setCellData("ReceivedAtCPUTest", "View Sub Category", RowNum, ViewSubCategory);
			excel.setCellData("ReceivedAtCPUTest", "View Sub Sub Category", RowNum, ViewSubSubCategory);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The Received At CPU Test Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL,
					"****Fail to Updated The Received At CPU Test Sheet**** ");
		}

	}

	public void dvuPassedSheetUpdate(String ViewCategory, String ViewSubCategory, String ViewSubSubCategory, int RowNum) {
		try {

			excel.setCellData("DVUPassedTest", "Lead Id", RowNum, LeadID);
			excel.setCellData("DVUPassedTest", "View Category", RowNum, ViewCategory);
			excel.setCellData("DVUPassedTest", "View Sub Category", RowNum, ViewSubCategory);
			excel.setCellData("DVUPassedTest", "View Sub Sub Category", RowNum, ViewSubSubCategory);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The DVU Passed Test Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The DVU Passed Test Sheet**** ");
		}

	}

	public void acceptedBpoSheetUpdate(String ViewCategory, String ViewSubCategory, String ViewSubSubCategory, int RowNum) {

		try {

			excel.setCellData("AcceptedBPOTest", "Lead Id", RowNum, LeadID);
			excel.setCellData("AcceptedBPOTest", "View Category", RowNum, ViewCategory);
			excel.setCellData("AcceptedBPOTest", "View Sub Category", RowNum, ViewSubCategory);
			excel.setCellData("AcceptedBPOTest", "View Sub Sub Category", RowNum, ViewSubSubCategory);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The Accepted BPO Test Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Accepted BPO Test Sheet**** ");
		}
	}

	public void accountOpenedSheetUpdate(String ViewCategory, String ViewSubCategory, String ViewSubSubCategory, int RowNum) {

		try {

			excel.setCellData("AccountOpenedTest", "Lead Id", RowNum, LeadID);
			excel.setCellData("AccountOpenedTest", "View Category", RowNum, ViewCategory);
			excel.setCellData("AccountOpenedTest", "View Sub Category", RowNum, ViewSubCategory);
			excel.setCellData("AccountOpenedTest", "View Sub Sub Category", RowNum, ViewSubSubCategory);

			CustomListeners.testReport.get().log(Status.INFO,
					"****Successfully Updated The Account Opened Test Sheet**** ");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			assertion.fail("***********Not Able To Update************");
			CustomListeners.testReport.get().log(Status.FAIL, "****Fail to Updated The Account Opened Test Sheet**** ");
		}
	}

}
