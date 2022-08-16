package com.crm.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.LeadsPage;
import com.crm.pages.LiabilitiesPage;
import com.crm.pages.CommonFunctionPage;
import com.crm.utilities.TestUtil;

public class LiabilityFlow_CreateLeadTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void liabilityFlow_CreateLeadTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("liabilityFlow_CreateLeadTest", excel))) {

			throw new SkipException(
					"Skipping the test " + "liabilityFlow_CreateLeadTest".toUpperCase() + "as the Run mode is NO");
		}

		setUp();
		LeadsPage lead = new LeadsPage();
		CommonFunctionPage common = new CommonFunctionPage();
		LiabilitiesPage liab = new LiabilitiesPage();
		
		common.userLogin(data.get("BM Username"), data.get("Password"));
		common.selectRole(data.get("Role"));
		common.selectAppLauncher();
		lead.selectLayout(data.get("Layout Name"));

		liab.createLiabilityLead(data.get("Customer Name"), data.get("Input Type"), data.get("Processing Entity"),
				data.get("First Name"), data.get("Middle Name"), data.get("Last Name"), data.get("Mobile"),
				data.get("Product"), data.get("Status Code"), data.get("Lead Source"), data.get("Mode of Interaction"),
				data.get("Initial Payin"), data.get("Program Master Initiative"), data.get("Branch Name"),
				data.get("Account No"), data.get("FD Account Number"), data.get("RD Account Number"),
				data.get("Customer Profile"), data.get("Lead Priority"), data.get("Customer Type"),
				data.get("Branch Decision"), data.get("Not Contactable Reason"), data.get("Not Eligible Reason"),
				data.get("SURU Branch"), data.get("Is your country of Tax Residency Other than India"));

		// StatusCode Validation
		ak.validateStatusCode("Fresh");
		
		//Update Lead Number in Required Sheets
		common.extractLeadId("LiabilityFlow_CreateLeadTest");
		common.appointmentSheetUpdate(data.get("View Category"), data.get("View Sub Category Fresh"), data.get("View Sub Sub Category"),2);
		common.docCollectedSheetUpdate(data.get("View Category"), data.get("View Sub Category Appointment"), data.get("View Sub Sub Category"),2);
		common.receivedAtBranchSheetUpdate(data.get("View Category"), data.get("View Sub Category DocsCollected"), data.get("View Sub Sub Category"),2);
		common.branchApproveSheetUpdate(data.get("View Category"), data.get("View Sub Category ReceivedAtBranch"), data.get("View Sub Sub Category"),2);
		common.dispatchedToCPUSheetUpdate(data.get("View Category"), data.get("View Sub Category BranchApproved"), data.get("View Sub Sub Category"),2);
		common.receivedAtCPUSheetUpdate(data.get("View Category"), data.get("View Sub Category DispatchedtoCPU"), data.get("View Sub Sub Category"),2);
		common.dvuPassedSheetUpdate(data.get("View Category"), data.get("View Sub Category ReceivedAtCPU"), data.get("View Sub Sub Category"),2);
		common.acceptedBpoSheetUpdate(data.get("View Category"), data.get("View Sub Category DVUPassed"), data.get("View Sub Sub Category"),2);
		common.accountOpenedSheetUpdate(data.get("View Category"), data.get("View Sub Category AcceptedBPO"), data.get("View Sub Sub Category"),2);

	}
	
	

}
