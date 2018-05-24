package pages;



import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;

public class ProfilePage extends ApplicationKeywords{
	
	public ProfilePage(BaseClass obj) {
		super(obj);
	}
	

	
	public static final String Error_Msg_Confirme= "Error message for Confirm password#xpath=//div[@id='ValidationSummary' and text()='Please confirm your password.']";
	public static final String Error_msg_password = "Error Message for passsword#xpath=//div[@id='ValidationSummary' and contains(text(),'Please enter a password.')]";
	public static final String Change_Doublelock_password = "Change Doublelock Password in profile page#xpath=//a[text()='Change DoubleLock Password']";
	public static final String Reset_Doublelock_password = "Reset Doublelock Password in profile page#xpath=//a[text()='Reset DoubleLock Password']";
	public static final String Doublelock_reset_Password_title = "Double lock reset title#xpath=//table[@id='DoubleLockDialog_DialogTable']//td[@class='dialog_top']";
	
	
	// sathish
	
	public static final String btn_changePassword = "To click on change the password#xpath=//ul[@class='linkList']/li//a[(text()='Change Password')]";

	public static final String btn_sessions = "To click sessions button in myprofile page#xpath=//ul[@class='linkList']//li//a[text()='Sessions']";
	public static final String lbl_MyprofileHeader = "Header of the page My Profile#xpath=//div[@class='formGrid']//div";
	public static final String lbl_CurrentLoggedInSessionsHeader = "Header of the page current logged in sessions#xpath=//table[@id='SessionsDialog_DialogTable']//td[@class='dialog_top' and contains(text(),'Current')]";
	public static final String btn_save = "save the password#xpath=//button[@value='Save']";
	public static final String lbls_profilepage = "To verify the presence of elements#xpath=//ul[@class='linkList']/li/a/following-sibling::a";
	public static final String lbl_ChangeMyPassword_page = "Change my password page#xpath=//table[@class='dialogTable']//td";

	
	
	public void profileValidationFields(String MyProfile_labels)
	{
		mouseOver(OR.btn_Profile_Icon);
		clickOn(OR.btn_My_Profile);
		validateWebElements(OR.lbl_General,"General");
		validateWebElements("//ul[@class='linkList']/li/a/following-sibling::a",MyProfile_labels);
	}
	
//	public void changePassword(String current_pwd, String updated_pwd)
//	{
//		mouseOver(OR.btn_Profile_Icon);
//		clickOn(OR.btn_My_Profile);
//		clickOn(OR.btn_changePassword);
//		typeIn(OR.txt_currentPassword, current_pwd);
//		typeIn(OR.txt_newPassword, updated_pwd);
//		typeIn(OR.txt_ConfirmPassword,updated_pwd);
//	}

    public void verifyCurrentSessionpage() {
    	
		clickOn(OR.btn_Profile_Icon);
		//String profilepagetext = getText("My profile page text#xpath=//div[text()='My Profile']");
		if (isElementDisplayed("My profile page text#xpath=//div[text()='My Profile']")) {
			testStepPassed("Profile page is displayed");
			vstsTestStepPassed("Profile page is displayed", false);
		}
		else {
			testStepFailed("Profile page is not displayed");
			vstsTestStepFailed("Profile page is not displayed", true);
		}
		
		clickOn(OR.tab_Session);
		
		String sessionpageText = getText(OR.txt_Session_page);
	    if(sessionpageText.equals("Current Logged in Sessions")) {
	    	testStepPassed("Session Page is Displayed");
	    	vstsTestStepPassed("Session Page is Displayed", false);
	    }
	    else {
	    	testStepFailed("Session Page is Not Displayed");
	    	vstsTestStepFailed("Session Page is Not Displayed", true);
	    }
	}
    
    public void CreateDoubleLockPassword(String loginPassword, String newDoublelockPassword) {
		mouseOver(OR.btn_Profile_Icon);
		clickOn(OR.btn_My_Profile); 
		if (isElementDisplayed("My profile page text#xpath=//div[text()='My Profile']")) {
			testStepPassed("Profile page is displayed");
			vstsTestStepPassed("Profile page is displayed", false);
		}
		else {
			testStepFailed("Profile page is not displayed");
			vstsTestStepFailed("Profile page is not displayed", true);
		}
		openCreateDoubleLockPasswordPage(loginPassword, false);
		creteDoublePasswordPage(newDoublelockPassword, false);
    }
    
    public void validateDoubleLockPasswordErrorMessage(String NewPassword, String ConfirmNewPassword, String ExpectedMessage) {
    	
		mouseOver(OR.btn_Profile_Icon);
		clickOn(OR.btn_My_Profile);
		
		if (isElementDisplayed("My profile page text#xpath=//div[text()='My Profile']")) {
			testStepPassed("Profile page is displayed");
			vstsTestStepPassed("Profile page is displayed", true);
		}
		else {
			testStepFailed("Profile page is not displayed");
			vstsTestStepFailed("Profile page is not displayed", true);
		}
		
		if (elementPresent("Create DoubleLock Password#xpath=//a[text()='Create DoubleLock Password']")) {
			clickOn("Create DoubleLock Password#xpath=//a[text()='Create DoubleLock Password']");
		}
	
		if (elementPresent(OR.txtbox_Doublelock_password)) {
			
			testStepPassed("Create DoubleLock page is  displayed");
			vstsTestStepPassed("Create DoubleLock page is  displayed", true);
			
			if (ExpectedMessage.equals("Please enter a password.")) {
				clickOn(OR.btn_CreatePasswordButton);
				
				waitTime(2);
				if (isElementDisplayed(Error_Msg_Confirme) && isElementDisplayed(Error_msg_password)) {
					testStepPassed("Error message for Password and Confirm Password is displayed");
					vstsTestStepPassed("Error message for Password and Confirm Password is displayed", true);
				}
				else {
					testStepFailed("Error message for Password and Confirm Password is not displayed");
					vstsTestStepFailed("Error message for Password and Confirm Password is not displayed", true);
				}
			}
			else if(ExpectedMessage.equals("Please enter a password that is between 8 and 500 characters long.") 
					|| ExpectedMessage.equals("Please enter matching passwords.")) {
				typeIn(OR.txtbox_Doublelock_password, NewPassword);
				boolean Password = ValidateEnterValusInTextField(OR.txtbox_Doublelock_password, NewPassword, "Password");
				waitTime(2);
				typeIn(OR.txtbox_Doublelock_Confirm_Password, ConfirmNewPassword);
				boolean ConfirmPassword = ValidateEnterValusInTextField(OR.txtbox_Doublelock_Confirm_Password, ConfirmNewPassword, "ConfirmNewPassword");
				
				
				
				if (Password && ConfirmPassword) {
					testStepPassed("Password amd Confirm password able to enter");
					vstsTestStepPassed("Password amd Confirm password able to enter", true);
				}
				else {
					testStepFailed("Password amd Confirm password are not able to enter");
					vstsTestStepFailed("Password amd Confirm password are not able to enter", true);
				}
				clickOn(OR.btn_CreatePasswordButton);
				
				if (isElementDisplayed("Error message for Doublic password#xpath=//div[@id='ValidationSummary' and contains(text(),'"+ExpectedMessage+"')]")) {
					testStepPassed("Error message for Password and Confirm Password is displayed");
					vstsTestStepPassed("Error message for Password and Confirm Password is displayed", true);
				}
				else {
					testStepFailed("Error message for Password and Confirm Password is not displayed");
					vstsTestStepFailed("Error message for Password and Confirm Password is not displayed", true);
				}
			}
			else {
				testStepFailed("Expected Message is Not Mached");
			}
		}
		else {
			testStepFailed("Create DoubleLock page is not displayed");
		}
    	
    }
    
//    public void validateDoubleLockPasswordErrorMessage(String loginPassword, String DoublelockPasswor, String ConfirmPassword, String ErrorMessage) {
//    	
//		mouseOver(OR.btn_Profile_Icon);
//		clickOn(OR.btn_My_Profile);   	    
//		openCreateDoubleLockPasswordPage(loginPassword);
//		
//		if (elementPresent(OR.txtbox_Doublelock_password)) {
//			typeIn(OR.txtbox_Doublelock_password, DoublelockPasswor);
//			waitTime(2);
//			typeIn(OR.txtbox_Doublelock_Confirm_Password, ConfirmPassword);
//			clickOn(OR.btn_CreatePasswordButton);
//			String doublelocksuccessmsg = getText("Error message for DoubleLockPassword#id=ValidationSummary");
//			if (doublelocksuccessmsg.equals(ErrorMessage)) {
//				testStepPassed("DoubleLock Error Message is Same");
//			}
//			else {
//				testStepFailed("DoubleLock Error Message  Different got[ '"+doublelocksuccessmsg+ "' ] Expected [ '"+ErrorMessage+" ']");
//			}
//		}
//		else {
//			testStepFailed("Create DoubleLock page is not displayed");
//		}
//    	
//    }

    public void ResetDoubleLockPassword(String loginPassword, String newDoublelockPassword) {
    	
    	mouseOver(OR.btn_Profile_Icon);
 		clickOn(OR.btn_My_Profile);   	    

 		if (elementPresent(Change_Doublelock_password)) {
// 			clickOn(OR.Link_Create_DoubleLock);
// 			creteDoublePasswordPage(newDoublelockPassword);
// 			mouseOver(OR.btn_Profile_Icon);
// 	 		clickOn(OR.btn_My_Profile)
 			testStepPassed("Change Doublelock password link is displayed");
 			vstsTestStepPassed("Change Doublelock password link is displayed", true);
		}
 		else {
 			testStepFailed("Change Double Password is not displayed");
 		}
 		
		if(elementPresent(OR.link_Reset_Doublelock)) {
			
			testStepPassed("Reset Doublelock password is present");
			vstsTestStepPassed("Reset Doublelock Password link is present", true);
			
			clickOn(OR.link_Reset_Doublelock);
		
			if (elementPresent(Doublelock_reset_Password_title)) {
				testStepPassed("Reset Doublelock Password page is present");
				vstsTestStepPassed("Reset Doublelock Password page is present", true);
				
				typeIn(OR.txtbox_Reset_Doublelock_password, loginPassword);
				if (ValidateEnterValusInTextField(OR.txtbox_Reset_Doublelock_password, loginPassword, "Password")) {
					testStepPassed("Password is able to entered");
					vstsTestStepPassed("Password is able to enter", true);
				}
				else {
					testStepPassed("Password is not able to enter");
					vstsTestStepFailed("Password is not able to enter", true);
				}
				clickOn(OR.btn_ResetPasswordButton);
				
				String Alerttext = getAlertText();
				if (Alerttext.contains("Are you absolutely sure that you want to reset your DoubleLock password?")) {
					testStepPassed("Reset PopUp Message is Same  ");
					vstsTestStepPassed("Reset PopUp Message is Same ", false);
				}
				else { 
					testStepFailed("Reset PopUp Message is Different");
					vstsTestStepFailed("Reset PopUp Message is Different", true);
				}
				
				alertOk();
				creteDoublePasswordPage(newDoublelockPassword, true);
				
			}
			else {
				testStepFailed("Reset Doublelock Password page is not present");
				vstsTestStepFailed("Reset Doublelock Password page is not present", true);
			}
		}
		else {
			testStepFailed("Reset Doublelock Password is not present");
			vstsTestStepFailed("Reset Doublelock Paswword is not Present", true);
		}
     }
    
    public boolean openCreateDoubleLockPasswordPage(String loginPassword, boolean withvstsupdate) {
    	mouseOver(OR.btn_Profile_Icon);
 		clickOn(OR.btn_My_Profile);  
    	boolean Status = false;
    	if (elementPresent(OR.Link_Create_DoubleLock)) {
			if(withvstsupdate)
				vstsTestStepPassed("Double lock password should able to set", true);
			Status = true;
			clickOn(OR.Link_Create_DoubleLock);
		}
		else if(elementPresent(OR.link_Reset_Doublelock)) {
			clickOn(OR.link_Reset_Doublelock);
			typeIn(OR.txtbox_Reset_Doublelock_password, loginPassword);
			clickOn(OR.btn_ResetPasswordButton);
			alertOk();
			if (elementPresent("title for create double password#xpath=//table[@id='DoubleLockDialog_DialogTable']//td[@class='dialog_top']")) {
				if(withvstsupdate)
					vstsTestStepPassed("Double lock password should able to set", true);
				Status = true;
			}
			else {
				if(withvstsupdate)
					vstsTestStepFailed("Double lock password should able to not set", true);
				Status = false;
			}
		}
		else {
			testStepFailed("Create DoubleLock Password and Reset DoubleLock is not present in My profilepage");
		}
    	return Status;
    }
    
    public void verifydeleteCurrentSession(String fields, String Buttonfields, String IPAddress) {
    	
    	verifyCurrentSessionpage();
    	//validateWebElements("//tr[@class='DataGridHeader']/td", fields);
    	
    	boolean Gridfieldstatus = validateAllElementisDisplay("Data Grid Header pages#xpath=//td", fields);
    	boolean Buttonfieldstatus = validateAllElementisDisplay("Ok and Delete button#xpath=//button", Buttonfields);
    	
    	if (Gridfieldstatus && Buttonfieldstatus) {
    		testStepPassed("Grid and button fields are present");
    		vstsTestStepPassed("Grid and button fields are present", true);
    	}
    	else {
    		testStepFailed("Grid and button fields are present");
    		vstsTestStepFailed("Grid and button fields are present", true);
    	}
    	
//    	clickOn("Revoke Other Sessions#xpath=//button[@id='DeleteAllButton']");
//    	alertOk();
    	
    	//validateWebElements("//button[@class='Button']", Buttonfields);
//    	clickOn(OR.btn_Delete_Current_Session_button);
//    	verifyAlertTextShouldContain("Are you sure you want to revoke this session and log it out of Secret Server?");
    	
    	clickOn("delete a Current session#xpath=//td[text()='"+IPAddress+"']/following-sibling::td/span");
    	
    	String Alerttext = getAlertText();
		if (Alerttext.contains("Are you sure you want to revoke this session and log it out of Secret Server?")) {
			testStepPassed("Reset PopUp Message is Same  ");
			vstsTestStepPassed("Reset PopUp Message is Same ", false);
		}
		else { 
			testStepFailed("Reset PopUp Message is Different");
			vstsTestStepFailed("Reset PopUp Message is Different", true);
		}
		
		alertOk();
    	
		waitTime(3);
		
		if (!elementPresent("current session #xpath=//td[@data-bind=\"text: IpAddress\" and text()='"+IPAddress+"']")) {
			testStepPassed("Current session is deleted");
			vstsTestStepPassed("Current session is delete from session page", true);
		}
		else {
			testStepFailed("Current session is not deleted from session page");
			vstsTestStepFailed("Current Session is not deleted from session page", true);
		}
    	clickOn(OR.btn_logo_icon);
    	
    	if (elementPresent(OR.Logout_Dialogbox)) {
			testStepPassed("Successfully Logout from SecretServer After clicking LOGO in home Page");
			vstsTestStepPassed("Successfully Logout from SecretServer After clicking LOGO in home Page", true);
		}
		else {
			testStepFailed(" Failied to Logout from SecretServer After clicking LOGO in home Page");
			vstsTestStepFailed(" Failied to Logout from SecretServer After clicking LOGO in home Page", true);
		}
    }
    
    
    
    public void creteDoublePasswordPage(String newDoublelockPassword, boolean usernamepasswordsinglestepvstsupdate) {
    	if (elementPresent(OR.txtbox_Doublelock_password)) {
    		testStepInfo("Create Doublelock password is displayed");
    		vstsTestStepPassed("Create Doublelock password is displayed", false);
			typeIn(OR.txtbox_Doublelock_password, newDoublelockPassword);
			typeIn(OR.txtbox_Doublelock_Confirm_Password, newDoublelockPassword);
			
			if (usernamepasswordsinglestepvstsupdate) {
				if (ValidateEnterValusInTextField(OR.txtbox_Doublelock_password, newDoublelockPassword, "new Password")
						&& ValidateEnterValusInTextField(OR.txtbox_Doublelock_Confirm_Password, newDoublelockPassword, "Confirm Password")) {
					testStepPassed("User is able to enter a values in New Password Field");
					vstsTestStepPassed("Username and password is able to enter a values in New Password Field", true);
				}
				else {
					testStepFailed("User is not able to enter a values in New Password Field");
					vstsTestStepFailed("Username and password is not able to enter a values in New Password Field", true);
				}
			}
			else {
				if (ValidateEnterValusInTextField(OR.txtbox_Doublelock_password, newDoublelockPassword, "new Password")) {
					testStepPassed("User is able to enter a values in New Password Field");
					vstsTestStepPassed("User is able to enter a values in New Password Field", false);
				}
				else {
					testStepFailed("User is not able to enter a values in New Password Field");
					vstsTestStepFailed("User is not able to enter a values in New Password Field", true);
				}
				if (ValidateEnterValusInTextField(OR.txtbox_Doublelock_Confirm_Password, newDoublelockPassword, "Confirm Password")) {
					testStepPassed("User is able to enter a values in Confirm Password Field");
					vstsTestStepPassed("User is able to enter a values in Confirm Password Field", false);
				}
				else {
					testStepFailed("User is not able to enter a values in Confirm Password Field");
					vstsTestStepFailed("User is not able to enter a values in Confirm Password Field", true);
				}
			}
			clickOn(OR.btn_CreatePasswordButton);
			String doublelocksuccessmsg = getText(OR.txt_DoublelockSuccessmsg);
			if (doublelocksuccessmsg.equals("You have successfully created a DoubleLock password.")) {
				testStepPassed("'You have successfully created a DoubleLock password' message is displayes");
				vstsTestStepPassed("'You have successfully created a DoubleLock password' message is displayes", false);
			}
			else {
				testStepFailed("'You have successfully created a DoubleLock password' message is not displayed");
				vstsTestStepFailed("'You have successfully created a DoubleLock password' message is not displayed", true);
			}
		}
    	else {
			testStepFailed("Create DoubleLock page is not displayed");
			vstsTestStepFailed("Create DoubleLock page is not displayed", true);
		}
    }
    
    
    public void CreateDoubleLockPasswordWithoutVsts(String NewPassword, String ConfirmPassword) {
 		
    	if (elementPresent(OR.txtbox_Doublelock_password)) {
    		testStepInfo("Create Doublelock password is displayed");
    		vstsTestStepPassed("Create Doublelock password is displayed", false);
			typeIn(OR.txtbox_Doublelock_password, NewPassword);
			typeIn(OR.txtbox_Doublelock_Confirm_Password, ConfirmPassword);
			clickOn(OR.btn_CreatePasswordButton);
			String doublelocksuccessmsg = getText(OR.txt_DoublelockSuccessmsg);
			if (doublelocksuccessmsg.equals("You have successfully created a DoubleLock password.")) {
				testStepPassed("'You have successfully created a DoubleLock password' message is displayes");
				vstsTestStepPassed("'You have successfully created a DoubleLock password' message is displayes", false);
			}
			else {
				testStepFailed("'You have successfully created a DoubleLock password' message is not displayed");
				vstsTestStepFailed("'You have successfully created a DoubleLock password' message is not displayed", true);
			}
		}
    	else {
			testStepFailed("Create DoubleLock page is not displayed");
			vstsTestStepFailed("Create DoubleLock page is not displayed", true);
		}
    }
    
    
    // sathish
    
    public void changePasswordwithVSTS(String current_pwd, String updated_pwd,String fields, String Buttons)
	{
		try
		{
			mouseOver(OR.btn_Profile_Icon);
			clickOn(OR.btn_My_Profile);
			
			if(validateElementisDisplay(lbl_MyprofileHeader, "My Profile")==1)
			{
				testStepPassed("Navigated to My profile page");
				vstsTestStepPassed("Navigated to My profile page", false);
			}
			else
			{
				testStepFailed("Unable to navigate to My Profile page");
				vstsTestStepFailed("Unable to navigate to My Profile page", true);
			}
			
			clickOn(OR.btn_changePassword);
			
			if(validateElementisDisplay(lbl_ChangeMyPassword_page, "Change")==1)
			{
				testStepPassed("Navigated to Change My Password page");
				vstsTestStepPassed("Navigated to Change My Password page", false);
			}
			else
			{
				testStepFailed("Unable to navigate to Change My Password page");
				vstsTestStepFailed("Unable to navigate to Change My Password page", true);
			}
			
			if(validateAllElementisDisplay("Validating elements in change password page#xpath=//td[@class='FormFieldLabelContainer']//span", fields)==true && validateAllElementisDisplay("buttons in My profile page#xpath=//button", Buttons)==true)
			{
				testStepPassed("Elements found");
				vstsTestStepPassed("Elements found", false);
			}
			else
			{
				testStepFailed("Elements not found");
				vstsTestStepFailed("Elements not found", true);	
			}
			
			
			typeIn(OR.txt_currentPassword, current_pwd);
			typeIn(OR.txt_newPassword, updated_pwd);
			typeIn(OR.txt_ConfirmPassword,updated_pwd);
			
			if(ValidateEnterValusInTextField(OR.txt_currentPassword, current_pwd, current_pwd)==true)
			{
				testStepPassed("Able to enter the text in Textbox Current Password");
				vstsTestStepPassed("Able to enter the text in Textbox Current Password", false);
			}
			else
			{
				testStepFailed("Unable to enter the text in Textbox Current Password");
				vstsTestStepFailed("Unable to enter the text in Textbox Current Password", true);
			}
			
			if(ValidateEnterValusInTextField(OR.txt_newPassword, updated_pwd, updated_pwd)==true)
			{
				testStepPassed("Able to enter the text in Textbox Updated Password");
				vstsTestStepPassed("Able to enter the text in Textbox Updated Password", false);
			}
			else
			{
				testStepFailed("Unable to enter the text in Textbox Updated Password");
				vstsTestStepFailed("Unable to enter the text in Textbox Updated Password", true);
			}
			
			if(ValidateEnterValusInTextField(OR.txt_ConfirmPassword, updated_pwd, updated_pwd)==true)
			{
				testStepPassed("Able to enter the text in Textbox Confirm Password");
				vstsTestStepPassed("Able to enter the text in Textbox Confirm Password", false);
			}
			else
			{
				testStepFailed("Unable to enter the text in Textbox Confirm Password");
				vstsTestStepFailed("Unable to enter the text in Textbox Confirm Password", true);
			}
			
			clickOn(btn_save);
			
			if(validateDashboardwithVSTS()==true)
			{
				testStepPassed("dashboard page displayed");
				vstsTestStepPassed("dashboard page displayed", false);
			}
			else
			{
				testStepFailed("Unabale to navigate to dashboard page");
				vstsTestStepFailed("Unabale to navigate to dashboard page", true);
			}
			
		}catch(Exception ex)
		{
			System.out.println("Exception in changePassword "+ex);
			ex.printStackTrace();
		}
	}
    
    public void changePassword(String current_pwd, String updated_pwd,String fields, String Buttons)
	{
		try
		{
			mouseOver(OR.btn_Profile_Icon);
			clickOn(OR.btn_My_Profile);
			
			/*if(validateElementisDisplay(OR.lbl_MyprofileHeader, "My Profile")==1)
			{
				testStepPassed("Navigated to My profile page");
				
			}
			else
			{
				testStepFailed("Unable to navigate to My Profile page");
				
			}*/
			
			clickOn(OR.btn_changePassword);
			
			/*if(validateElementisDisplay(lbl_ChangeMyPassword_page, "Change My Password")==1)
			{
				testStepPassed("Navigated to Change My Password");
				
			}
			else
			{
				testStepFailed("Unable to navigate to Change My Password");
				
			}
			
			if(validateAllElementisDisplay("Validating elements in change password page#xpath=//span", fields)==true && validateAllElementisDisplay("buttons in My profile page#xpath=//button", Buttons)==true)
			{
				testStepPassed("Elements found");
				
			}
			else
			{
				testStepFailed("Elements not found");
				
			}*/
			
			
			typeIn(OR.txt_currentPassword, current_pwd);
			typeIn(OR.txt_newPassword, updated_pwd);
			typeIn(OR.txt_ConfirmPassword,updated_pwd);
			
			/*if(ValidateEnterValusInTextField(OR.txt_currentPassword, current_pwd, current_pwd)==true)
			{
				testStepPassed("Able to enter the text in Textbox Current Password");
				
			}
			else
			{
				testStepFailed("Unable to enter the text in Textbox Current Password");
				
			}
			
			if(ValidateEnterValusInTextField(OR.txt_newPassword, updated_pwd, updated_pwd)==true)
			{
				testStepPassed("Able to enter the text in Textbox Updated Password");
				
			}
			else
			{
				testStepFailed("Unable to enter the text in Textbox Updated Password");
				
			}
			
			if(ValidateEnterValusInTextField(OR.txt_ConfirmPassword, updated_pwd, updated_pwd)==true)
			{
				testStepPassed("Able to enter the text in Textbox Confirm Password");
				
			}
			else
			{
				testStepFailed("Unable to enter the text in Textbox Confirm Password");
				
			}*/
			
			clickOn(btn_save);
			/*if(validateDashboardwithVSTS()==true)
			{
				testStepPassed("Dashboard verifies");
				vstsTestStepPassed("Dashboard verifies", false);
			}
			else
			{
				testStepFailed("failed to verify dashboard");
				vstsTestStepFailed("failed to verify dashboard", true);
			}*/
			
		}catch(Exception ex)
		{
			System.out.println("Exception in changePassword "+ex);
			ex.printStackTrace();
		}
	}
    
    public void MyProfileSessionsValidation(String SessionElements, String SessionButtons,String Browser, String IpAddr)
	{
		try
		{
			mouseOver(OR.btn_Profile_Icon);
			clickOn(OR.btn_My_Profile);

			if(elementPresent(lbl_MyprofileHeader))
			{
				testStepPassed("Sucessfully Navigated to My Profile Page");
				vstsTestStepPassed("Sucessfully Navigated to My Profile Page", false);
			}
			else
			{
				testStepFailed("Unable to Navigate to My Profile page");
				vstsTestStepFailed("Unable to Navigate to My Profile page", true);
			}

			clickOn(btn_sessions);

			if(elementPresent(lbl_CurrentLoggedInSessionsHeader))
			{
				testStepPassed("Sucessfully Navigated to Current Logged In Sessions Page");
				vstsTestStepPassed("Sucessfully Navigated to Current Logged In Sessions Page", false);
			}
			else
			{
				testStepFailed("Unable to Navigate to Current Logged In Sessions page");
				vstsTestStepFailed("Unable to Navigate to Current Logged In Sessions page", true);
			}
			
			boolean elements = validateAllElementisDisplay("Session Elements#xpath=//table[@class='DataGrid']//tr[@class='DataGridHeader']/td[contains(@data-bind,'text')]", SessionElements);
			boolean buttons = validateAllElementisDisplay("Session buttons#xpath=//button[@type='submit']", SessionButtons);
			
	
			if(elements==true && buttons==true)
			{
				testStepPassed("Elements validated");
				vstsTestStepPassed("Elements validated", false);
				
			}
			else
			{
				testStepFailed("Unable to validate Elements");
				vstsTestStepFailed("Unable to validate Elements", true);
			}
			
			int brow = validateElementisDisplay("Browser#xpath=//tbody[@data-bind='foreach:items']/tr[contains(@data-bind,'css')]/td[contains(@data-bind,'Browser')]", Browser);
			int ip =validateElementisDisplay("Ipaddr#xpath=//tbody[@data-bind='foreach:items']/tr[contains(@data-bind,'css')]/td[contains(@data-bind,'IpAddress')]", IpAddr);
			
			if(brow==1 && ip==1)
			{
				testStepPassed("Browser and ip validated");
				vstsTestStepPassed("Browser and ip validated", false);
			}
			else
			{
				testStepFailed("Unable to validate Browser and ip");
				vstsTestStepFailed("Unable to validate Browser and ip", true);
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception in changePassword "+ex);
			ex.printStackTrace();
		}

	}
    
}
