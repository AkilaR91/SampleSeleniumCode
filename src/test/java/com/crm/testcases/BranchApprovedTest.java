package com.crm.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.LeadsPage;
import com.crm.pages.CommonFunctionPage;
import com.crm.utilities.TestUtil;

public class BranchApprovedTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void branchApprovedTest(Hashtable<String, String> data) throws Exception {

		if (!(TestUtil.isTestRunnable("branchApprovedTest", excel))) {

			throw new SkipException(
					"Skipping the test " + "branchApprovedTest".toUpperCase() + "as the Run mode is NO");
		}

		setUp();
		LeadsPage lead = new LeadsPage();
		CommonFunctionPage common = new CommonFunctionPage();
		
		common.userLogin(data.get("BM Username"), data.get("Password"));
		common.selectRole(data.get("Role"));
		lead.findLeadFromView(data.get("View Category"), data.get("View Sub Category"), data.get("View Sub Sub Category"), data.get("Lead Id"));
		lead.clickOnBranchApproveBtn();
		lead.verifyStatusSuccessPopup();
	}
	
}
