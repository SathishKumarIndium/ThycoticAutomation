package pages;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;

public class GettingStartedPage extends ApplicationKeywords {

	public static final String btn_helpIcon= "Help icon#xpath=//a[@href='Help']//i[contains(@class,'question-circle')]";
	public static final String btn_gettingStarted = "Getting started button#xpath=//ul[@class='AccountSubMenu']//a[text()='Getting Started']";
	public static final String btn_EmailTab = "Email tab in getting started#xpath=//li[@class='wizTab']/a[@id='EmailWizardTab' and text()='Email']";
	public static final String txt_EmailServer = "Email server text box#xpath=//table[@id='JsonListTable']//input[@id='SmtpServer']";
	public static final String txt_FromEmailAddress = "Email server text box#xpath=//table[@id='JsonListTable']//input[@id='FromEmailAddress']";
	public static final String btn_AdvancedOptional = "click on advanced optional button#xpath=//a[text()='Advanced (Optional)']";
	public static final String chk_UseCredentials = "Check the CheckBox Use Credentials#xpath=//input[@id='SmtpUseCredentials']";
	public static final String chk_UseCustomPort = "Check the CheckBox Use Custom Port#xpath=//input[@id='SmtpUseCustomPort']";
	public static final String btn_next = "click on next button#xpath=//button[@id='ValidateNext']/i";
	public static final String btn_groupsTab = "click on groups Tab#xpath=//a[@id='GroupsWizardTab']";
	public static final String btn_finish = "click on finish button#xpath=//button[@id='Finish']/i";
	public static final String btn_Admin_Tab = "Admin Tab#xpath=//a[contains(@id,'AdministrationLink') and text()='Admin']";
	public static final String lbl_EmailserverValue = "Retrive the corresponding value of Email server#xpath=//label[text()='Email Server']/../div//span[contains(@data-bind,'editMode()')]";
	public static final String lbl_FromEmailaddrValue = "Retrive the corresponding value of from Email address#xpath=//label[text()='From Email Address']/../div//span[contains(@data-bind,'editMode()')]";


	public GettingStartedPage(BaseClass obj) 
	{
		super(obj);
	}


	public void GettingStartedValidation(String Emailserver, String FromEmailAddress, String AdvancedOptElements, String UseCredentialsElements, String UseCustomPortElements,String[] VisibleElemements) 
	{
		clickOn(OR.btn_home_icon);
		if(elementPresent(btn_helpIcon))
		{
			testStepPassed("Help Icon is Present");
			vstsTestStepPassed("Help Icon is Present", false);
		}
		else
		{
			testStepFailed("Help icon is not displayed");
			vstsTestStepFailed("Help icon is not displayed", true);
		}
		mouseOver(btn_helpIcon);
		clickOn(btn_gettingStarted);

		if(elementPresent("server setup#xpath=//table[@class='dialogTable']//td[@class='dialog_top']"))
		{
			testStepPassed("Message is verified");
			vstsTestStepPassed("Message is verified", false);
		}
		else
		{
			testStepFailed("Unable to verify message");
			vstsTestStepFailed("Unable to verify message", true);
		}

		if(elementPresent(btn_EmailTab))
		{
			testStepPassed("Email tab is validated");
			vstsTestStepPassed("Email tab is validated", false);
		}
		else
		{
			testStepFailed("Unable to verify Email tab");
			vstsTestStepFailed("Unable to verify Email tab", true);
		}
		clickOn(btn_EmailTab);

		typeIn(txt_EmailServer, Emailserver);
		typeIn(txt_FromEmailAddress, FromEmailAddress);

		boolean  mail = ValidateEnterValusInTextField(txt_EmailServer, Emailserver, Emailserver);
		boolean adr = ValidateEnterValusInTextField(txt_FromEmailAddress, FromEmailAddress, FromEmailAddress);
		if(mail == true && adr == true)
		{
			testStepPassed("Text Entered");
			vstsTestStepPassed("Text Entered", false);
		}
		else
		{
			testStepFailed("Unable to enter text");
			vstsTestStepFailed("Unable to enter text", true);
		}

		clickOn(btn_AdvancedOptional);
		if(validateAllElementisDisplay("advanced elements#xpath=//tr[@class='CollapsibleControl']//table//td//strong", AdvancedOptElements)==true)
		{
			testStepPassed("Advanced elements validated");
			vstsTestStepPassed("Advanced elements validated", false);
		}
		else
		{
			testStepFailed("Failed to validate advanced elements ");
			vstsTestStepFailed("Failed to validate advanced elements ", true);
		}


		String PresentEmailservername = getAttributeValue(txt_EmailServer, "value");


		if(PresentEmailservername.equals(Emailserver))
		{
			testStepPassed("Verified able to enter text in Email Server TextBox");
		}
		else
		{
			testStepFailed("Unable to enter text in Email Server TextBox");
		}

		String PresentFromEmailAddress = getAttributeValue(txt_FromEmailAddress, "value");

		if(PresentFromEmailAddress.equals(FromEmailAddress))
		{
			testStepPassed("Verified able to enter text in From Email Address  TextBox");
		}
		else
		{
			testStepFailed("Unable to enter text in From Email Address TextBox");
		}



		selectCheckBox(chk_UseCredentials);


		if(validateAllElementisDisplay("credentials#xpath=//tr[@class='CollapsibleControl']//table//td//strong", UseCredentialsElements)==true)
		{
			testStepPassed("Credentials found");
			vstsTestStepPassed("Credentials found", false);
		}
		else
		{
			testStepFailed("Credentials not found");
			vstsTestStepFailed("Credentials not found", true);
		}


		selectCheckBox(chk_UseCustomPort);
		if(elementPresent(chk_UseCustomPort))
		{
			testStepPassed("Checkbox is checked");
			vstsTestStepPassed("Checkbox is checked", false);
		}
		else
		{
			testStepFailed("Checkbox is not checked");
			vstsTestStepFailed("Checkbox is not checked", true);
		}

		if(validateElementisDisplay("customport#xpath=//tr[@class='CollapsibleControl']//table//td//strong", UseCustomPortElements)==1)
		{
			testStepPassed("Port elements found");
			vstsTestStepPassed("Port elements found", false);
		}
		else
		{
			testStepFailed("Port elements not found");
			vstsTestStepFailed("Port elements not found", true);
		}

		waitTime(4);


		unSelectCheckBox(chk_UseCredentials);
		unSelectCheckBox(chk_UseCustomPort);

		String[] Elements = VisibleElemements;

		for(String element:Elements)
		{
			if(!isElementDisplayed("validating elements#xpath=//tr[@class='CollapsibleControl']//table//td//strong[text()='"+element+"']"))
			{
				testStepPassed("Verified The Fields are not present");
			}
			else
			{
				testStepFailed("Verified that the fields are present");
			}
		}

		waitTime(2);
		clickOn(btn_next);
		waitTime(2);
		validateWebElements("//a[@id='GroupsWizardTab']", "Groups");

		if(validateElementisDisplay("group#xpath=//a[@id='GroupsWizardTab']", "Groups")==1)
		{
			testStepPassed("Groups found");
			vstsTestStepPassed("Groups found", false);
		}
		else
		{
			testStepFailed("Groups not foumd");
			vstsTestStepFailed("Groups not foumd", true);
		}
		waitTime(2);
		clickOn(btn_next);
		waitTime(2);
		
		if(validateElementisDisplay("next steps#xpath=//a[@id='Next StepsWizardTab']", "Next Steps")==1)
		{
			testStepPassed("Next steps found");
			vstsTestStepPassed("Next steps found", false);
		}
		else
		{
			testStepFailed("Next steps not found");
			vstsTestStepFailed("Next steps not found", true);
		}
		
		waitTime(2);
		clickOn(btn_finish);
		String confirmDashboard = getText(OR.lbl_Browse);

		if(confirmDashboard.equalsIgnoreCase("Browse"))
		{
			testStepPassed("Navigated to DashBoard Page");
			vstsTestStepPassed("Navigated to DashBoard Page", false);
		}

		else
		{
			testStepFailed("Unable to navigate to DashBoard Page");
			vstsTestStepFailed("Unable to navigate to DashBoard Page", true);
		}
		clickOn(btn_Admin_Tab);
		if(validateElementisDisplay("admin#xpath=//div[@class='formGrid']//div[@class='row']/div[contains(@class,'column')]/preceding-sibling::div", "Administration")==1)
		{
			testStepPassed("Admin page found");
			vstsTestStepPassed("Admin page found", false);
		}
		else
		{
			testStepFailed("Admin page not found");
			vstsTestStepFailed("Admin page not found", true);
		}
		
		clickOn("Email button#xpath=//a[text()='Email']");



		String EmailServerValue=getText(lbl_EmailserverValue);

		if(EmailServerValue.equals(Emailserver))
		{
			testStepPassed("Verified the presence of Email server");
			vstsTestStepPassed("Verified the presence of Email server", false);
		}
		else
		{
			testStepFailed("Unable to Verify the presence of Email server got["+EmailServerValue+"] expected["+Emailserver+"]");
			vstsTestStepFailed("Unable to Verify the presence of Email server got["+EmailServerValue+"] expected["+Emailserver+"]", true);
		}


		String fromEmailaddrValue = getText(lbl_FromEmailaddrValue);

		if(fromEmailaddrValue.equals(FromEmailAddress.trim()))
		{
			testStepPassed("Verified the presence of from email address");
			vstsTestStepPassed("Verified the presence of from email address",false);
		}
		else
		{
			testStepFailed("Unable to Verify the presence of from email address");
			vstsTestStepFailed("Unable to Verify the presence of from email address", true);
		}


	}

}
