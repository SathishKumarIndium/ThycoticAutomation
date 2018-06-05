package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;

public class UsersPage extends ApplicationKeywords{
	
	public static final String btn_Admin_User_Icon = "Folders icon in Admin Tab#xpath=//a[text()='Users']";
  	public static final String users_page_header = "user page header#xpath=//td[@class='dialog_top' and text()='Users']";
  	public static final String btn_CreteNewUser_User_page = "create new user button#id=CreateNewUserButton";
  	public static final String txtbox_Username_Userpage = "UserName for Userpage#xpath=//span[text()='User Name']/parent::td/following-sibling::td/input";
  	public static final String txtbox_DispalyName_Userpage = "Display Name for Userpage#xpath=//span[text()='Display Name']/parent::td/following-sibling::td/input";;
  	public static final String txtbox_Email_Address_Userpage = "Email Address for Userpage#xpath=//span[text()='Email Address']/parent::td/following-sibling::td/input";
  	public static final String txtbox_Password_Userpage = "Password for Userpage#xpath=//span[text()='Password']/parent::td/following-sibling::td/input";
  	public static final String txtbox_confirmpassword_Userpage = "Confirm for Userpage#xpath=//span[text()='Confirm']/parent::td/following-sibling::td/input";
  	public static final String drd_Two_Factor_Userpage = "select a TwoFactor option#id=TwoFactorTypeDropDown";
  	public static final String chkbox_Enable_Userpage = "Enable option in userpage#xpath=//span[text()='Enabled']/parent::td/following-sibling::td/input[@type='checkbox']";
    public static final String chkbox_Locked_Out_Userpage ="Lockout in userpage#xpath=//span[text()='Locked Out']/parent::td/following-sibling::td/input[@type='checkbox']";
  	public static final String EditUserPage_Header = "Edit User Page Header#xpath=//table[@id='UserDialog_DialogTable']//td[@class='dialog_top']";
  	public static final String btn_Userpage_Save_Button = "Save Button For Edit Users Page#id=SaveButton";

	
	public UsersPage(BaseClass obj) {
		super(obj);
	}
	
	public Boolean verifyUserIsPresent(String UserName) {
		boolean status = false;
		try {
			mouseOver(OR.btn_Admin_Tab);
			clickOn(btn_Admin_User_Icon);
			if (elementPresent(users_page_header)) {
				testStepPassed("user Page is displayed");
				
				List<WebElement> users = driver.findElementsByXPath("//a[contains(@href,'UserView')]");
				for (WebElement ele:users) {
					String Guiusername = ele.getText();
					if (Guiusername.equals(UserName)) {
						status = true;
						break;
					}
				}
			}
			else {
				testStepFailed("User Page is not displayed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;  
	}
	
	public void createNewUsers(String Usersname, String DisplayName, String EmailAddress, String Password,
			String ConfirmPassword, String TwoFactory, String EnabledUser,String LockedOut) {
		
		if (verifyUserIsPresent(Usersname)) {
			testStepInfo("User Is Already Created");
			clickOn(OR.btn_home_icon);
		}
		else {
			
			clickOn(btn_CreteNewUser_User_page);
			if (elementPresent(EditUserPage_Header)) {
				testStepPassed("Edit user page is displayed");
				
				waitTime(3);
				typeIn(txtbox_Username_Userpage, Usersname);
				typeIn(txtbox_DispalyName_Userpage, DisplayName);
				typeIn(txtbox_Email_Address_Userpage, EmailAddress);
				typeIn(txtbox_Password_Userpage, Password);
				typeIn(txtbox_confirmpassword_Userpage, ConfirmPassword);
				selectFromDropdown(OR.drd_Two_Factor_Userpage, TwoFactory);
				if (EnabledUser.equals("Enable")) {
					selectCheckBox(chkbox_Enable_Userpage);
				}
				else if(EnabledUser.equals("Disable")) {
					unSelectCheckBox(chkbox_Enable_Userpage);
				}
				if (LockedOut.equals("Enable")) {
					selectCheckBox(chkbox_Locked_Out_Userpage);
				}
				else if(LockedOut.equals("Disable")) {
					unSelectCheckBox(chkbox_Locked_Out_Userpage);
				}
				
				clickOn(OR.btn_Userpage_Save_Button);
				String Guiusername = getText("New user name after#id=UserNameLabel");
				if (Guiusername.equals(Usersname)) {
					testStepPassed(Usersname+" New User is created successfully");
				}
				else {
					testStepFailed(Usersname+" Users is not cretes");
				}
			}
			else {
				testStepFailed("Edit user page is not displayed");
			}
		}
	}
}
