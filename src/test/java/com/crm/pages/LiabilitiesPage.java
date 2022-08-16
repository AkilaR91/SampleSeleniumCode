package com.crm.pages;

import java.io.IOException;

import com.crm.base.TestBase;

public class LiabilitiesPage extends TestBase {

	public void createLiabilityLead(String CustomerName, String InputType, String ProcessingEntity, String FirstName,
			String MiddleName, String LastName, String Mobile, String Product, String StatusCode, String LeadSource,
			String ModeofInteraction, String InitialPayin, String ProgramMasterInitiative, String BranchName,
			String AccountNo, String FDAccountNumber, String RDAccountNumber, String CustomerProfile,
			String LeadPriority, String CustomerType, String BranchDecision, String NotContactableReason,
			String NotEligibleReason, String SURUBranch, String IsyourcountryofTaxResidencyOtherthanIndia)
			throws InterruptedException, IOException {

		ak.select("Salutation_XPATH", CustomerName);
		ak.select("Input_Type_XPATH", InputType);
		ak.select("Processing_Entity_XPATH", ProcessingEntity);
		// ak.click("help_close");
		ak.input("First_name_XPATH", FirstName);
		ak.input("Mid_name_XPATH", MiddleName);
		ak.input("Last_name_XPATH", LastName);
		ak.input("ApplicationNum_XPATH", "JJ" + ak.generateRanNum());
		ak.click("Today_Date_XPATH");
		// ak.SELECT("form_type", 62);
		ak.input("Phone_or_Mobile_XPATH", Mobile);
		ak.select("Product_XPATH", Product);
		ak.select("Status_Code_XPATH", StatusCode);
		ak.select("Lead_Source_XPATH", LeadSource);
		ak.select("Mode_Of_Interaction_XPATH", ModeofInteraction); // newly added v3 instance
		ak.Clear("Initial_Payin_XPATH");
		ak.input("Initial_Payin_XPATH", InitialPayin);
		ak.select("Program_Master_Initiative_XPATH", ProgramMasterInitiative);
		ak.input("Source_Branch_Name_XPATH", BranchName);
		ak.mouseHoverAndClick(BranchName);
		ak.input("Account_Number_XPATH", AccountNo);
		ak.input("FD_Account_Number_XPATH", FDAccountNumber);
		ak.input("RD_Account_Number_XPATH", RDAccountNumber);
		ak.select("Customer_Profile_XPATH", CustomerProfile);
		ak.select("Lead_Priority_XPATH", LeadPriority);
		ak.select("Customer_Type_XPATH", CustomerType);
		ak.select("Branch_Decision_XPATH", BranchDecision);
		ak.select("Not_Contactable_Reason_XPATH", NotContactableReason);
		ak.select("Not_Eligible_Reason_XPATH", NotEligibleReason);
		ak.select("suru_branch_XPATH", SURUBranch);
		ak.select("Is_your_country_of_Tax_Residency_Other_than_India_XPATH", IsyourcountryofTaxResidencyOtherthanIndia);
		ak.click("clk_save_XPATH");
		Thread.sleep(2000);

	}

	

}
