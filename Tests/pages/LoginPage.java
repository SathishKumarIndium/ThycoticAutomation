package pages;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;

public class LoginPage extends ApplicationKeywords{
	
	public static int ElementCount = 0;
	
	
	public static final String Btn_Browser_dashboard = "Browser Button in DashBoard#xpath=//td[text()='Browse']";
	
	
	public LoginPage(BaseClass obj) {
		super(obj);
	}
	
	
	
	public void LaunchUrlWithoutVstsUpdate(String url) {
		navigateTo(url);
		if (elementPresent(OR.txt_ThycoticLoginPage)) {
			testStepPassed("Launch Url Successfully");
		}
		else {
			testStepFailed("Launch Url Not successfully");
		}
	}
	
	public void LaunchUrl(String url, String WithVstsStepUpdate) {
		deleteAllCookies();
		navigateTo(url);
		if (elementPresent(OR.txt_ThycoticLoginPage)) {
			testStepPassed("Launch Url Successfully");
			if(WithVstsStepUpdate.equalsIgnoreCase("Yes"))
			vstsTestStepPassed("Launch Url Successfully", false);
		}
		else {
			testStepFailed("Launch Url Not successfully");
			if(WithVstsStepUpdate.equalsIgnoreCase("Yes"))
			vstsTestStepFailed("Launch Url Not successfully", true);
		}
	}
	
	public void LaunchAllUrl(String url) {
		navigateTo(url);
	}
	
	public void Login(String username, String password, String WithVstsStepupdate) {
		
		typeIn(OR.typin_Username, username);
		typeIn(OR.typin_Password,password);
		clickOn(OR.btn_login_page);

		if (elementPresent("Browser Button in DashBoard#xpath=//td[text()='Browse']")) {
			testStepPassed("Successfully Login to SecretServer");
			if(WithVstsStepupdate.equalsIgnoreCase("Yes"))
			vstsTestStepPassed("Successfully Login to SecretServer", true);
		}
		else {
			testStepFailed("Failed to Login SecretServer");
			if(WithVstsStepupdate.equalsIgnoreCase("Yes"))
			vstsTestStepFailed("Failed to Login SecretServer", true);
		}
	}
		
	public void ValidateLoginScenarios(String username, String password, String ExpectedMessage) {
	
		boolean Usernamestatus = false, Passwordstatus = false;
		boolean EmptyUsernamePassword = false;
		
		if (!username.isEmpty()) {
			typeIn(OR.typin_Username, username);
			Usernamestatus = ValidateEnterValusInTextField(OR.typin_Username, username, "UserName");
		}
		
		if (!password.isEmpty()) {
			typeIn(OR.typin_Password, password);
			Passwordstatus = ValidateEnterValusInTextField(OR.typin_Password, password, "Password");
		}
		
		if (!username.isEmpty() && !password.isEmpty()) {
			if (Usernamestatus && Passwordstatus) {
				testStepPassed("Username or Password is able to enter in textfield");
				vstsTestStepPassed("Username or Password is able to enter in textfield", false);
			}
			else {
				testStepFailed("Username or Password is able to enter in textfield");
				vstsTestStepFailed("Username or Password is able to enter in textfield", true);
			}
		}
		else if (username.isEmpty() && password.isEmpty()) {
			clickOn(OR.btn_login_page);
			String[] erreormessage =ExpectedMessage.split("##");
			EmptyUsernamePassword = true;
			if (isElementDisplayed("Error Message#xpath=//div[@id='ValidationSummary' and text()='"+erreormessage[1]+"' and contains(text(),'"+erreormessage[0]+"')]")) {
				testStepPassed("Successfully Error Message is displayed");
				vstsTestStepPassed("Successfully Error Message is displayed", false);
			}
			else {
				testStepFailed("Error Message is not displayed");
				vstsTestStepFailed("Error Message is not displayed", true);
			}
			
		}
		else {
			if (Usernamestatus || Passwordstatus) {
				testStepPassed("Username or Password is able to enter in textfield");
				vstsTestStepPassed("Username or Password is able to enter in textfield", false);
			}
			else {
				testStepFailed("Username or Password is not able to enter in textfield");
				vstsTestStepFailed("Username or Password is not able to enter in textfield", true);
			}
		}
	
		if (ExpectedMessage.isEmpty()) {
			clickOn(OR.btn_login_page);
			validateDashboardPageDisplayed();
		}
		else {
			clickOn(OR.btn_login_page);
			if (!EmptyUsernamePassword) {
				ValidateLoginSingleErrorMessage(ExpectedMessage);
			}
		}
		
	}

	public void ValidateLoginSingleErrorMessage(String ErrrorText) {
		if (isElementDisplayed("Error Message#xpath=//div[@id='ValidationSummary' and contains(text(),'"+ErrrorText+"')]")) {
			testStepPassed("Successfully Error Message is displayed");
			vstsTestStepPassed("Successfully Error Message is displayed", true);
		}
		else {
			testStepFailed("Error Message is not displayed");
			vstsTestStepFailed("Error Message is not displayed", false);
		}
	}
	
	public void Logout() {

		mouseOver(OR.btn_Profile_Icon);
		waitForElementToDisplay(OR.btn_Logout, 10);
		clickOn(OR.btn_Logout);
		if (elementPresent(OR.Logout_Dialogbox)) {
			testStepPassed("Successfully Logout from SecretServer");
		}
		else {
			testStepFailed("Successfully Logout from SecretServer");
		}
	}
	
	public void ValidateLoginPageElements() {
	    
		ElementCount = 0;
		validateElementisdispalyed("Element for Thycotic Secret Server logo#xpath=//ul[@class='productText']/li[text()='Thycotic Secret Server ']", "Thycotic Secret Server logo");
		validateElementisdispalyed("Thycotic Logo in copyrights#xpath=//img[contains(@src,'thycotic_logo')]","Image for Thycotic Logo");
		validateElementisdispalyed("Thycotic Edition#xpath=//ul[@class='productText']/li/span[text()='Enterprise Plus Edition']", "Thycotic Edition field");
		validateElementisdispalyed("Thycotic Copyright#xpath=//a[text()='Copyright © Thycotic,']", "CopyRights");
		validateElementisdispalyed("Login table#xpath=//td[text()='Login']", "Login table");
		validateElementisdispalyed("Login fields #xpath=//span[text()='Username']", "Login Fields");
		validateElementisdispalyed("Password fields#xpath=//span[text()='Password']", "Password Fields");
	    validateElementisdispalyed("Login Button#xpath=//button[@value='Login']", "Login Button");
	    
	    if (ElementCount == 8) {
	    	testStepPassed("All Elements are present");
	    	vstsTestStepPassed("All Elements are present", false);
	    }
	    else {
	    	vstsTestStepFailed("Some Elements are not Present", true);
	    }
	    
	}
	
	public void verifyThycoticpagedisplayedclickingcopyright() {
		clickOn("Thycotic Copyright#xpath=//a[text()='Copyright © Thycotic,']");
		SwitchtoWindow(1);
		if (isElementDisplayed("title vale#xpath=//div[@id='logo']/parent::a")) {
			testStepPassed("Thycotic Page is displayed");
			vstsTestStepPassed("Thycotic Page is displayed", false);
		}
		else {
			testStepFailed("Thycotic Page is not displayed");
			vstsTestStepFailed("Thycotic Page is not displayed", true);
		}
		CloseSecondWindow();
	}
	
	public void verifyThycoticpagedisplayedclickingThycotic() {
		clickOn("Thycotic Logo in footer#xpath=//img[contains(@src,'thycotic_logo')]");
		SwitchtoWindow(1);
		if (isElementDisplayed("title vale#xpath=//div[@id='logo']/parent::a")) {
			testStepPassed("Thycotic Page is displayed");
			vstsTestStepPassed("Thycotic Page is displayed", false);
		}
		else {
			testStepFailed("Thycotic Page is not displayed");
			vstsTestStepFailed("Thycotic Page is not displayed", true);
		}
		CloseSecondWindow();
	}
	
	
	public void VerifyRefreshthepage() {
		clickOn("Thycotic Secret Server Logot#xpath=//ul[@class='productText']/li[text()='Thycotic Secret Server ']");
	    waitTime(2);
		if (isElementDisplayed("Thycotic Secret Server Logot#xpath=//ul[@class='productText']/li[text()='Thycotic Secret Server ']")) {
			testStepPassed("Secret server page is displayed");
			vstsTestStepPassed("Secret server page is displayed", false);
		}
		else {
			testStepFailed("Secret server page is not displayed");
			vstsTestStepFailed("Secret server page is not displayed", true);
		}
	}
	
	public void validateElementisdispalyed(String xpath, String Field) {
		
		if (isElementDisplayed(xpath)) {
			testStepInfo("'"+Field+"' element is displayed");
			ElementCount++;
		}
		else {
			testStepFailed("'"+Field+"' element is not displayed");
		}
		
	}
}