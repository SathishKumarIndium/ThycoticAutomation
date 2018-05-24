package pages;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;


public class AdminPage  extends ApplicationKeywords  {
	
	public static final String btn_Admin_Tab = "Admin Tab#xpath=//a[contains(@id,'AdministrationLink') and text()='Admin']";
  	public static final String btn_Remote_Password_Change = "Remote Password Changeing tab in admin#xpath=//a[text()='Remote Password Changing']";
  	public static final String btn_Secret_Template = "Secret Templates in admin tab#xpath=//a[text()='Secret Templates']";
  	public static final String Remote_Password_Change_Page_dialog_top = "Admin page#xpath=//table[@id='PasswordChangeConfigurationDialog_DialogTable']//td[@class='dialog_top']";
  	public static final String txt_Remote_Pass_Change_field = "Status for Remote Password Change#id=EnablePasswordChangingValueLabel";
  	public static final String btn_Remote_Password_Change_Edit = "Edit for Remote Password Change Password#xpath=//button[text()='Edit']";
  	public static final String chk_Enable_Remote_Password_Change = "enibling 'Enable Remote Password Change' option#id=EnablePasswordChangingCheckBox";
  	public static final String btn_Remote_Password_Change_Save = "Save button for Remote Password Change#xpath=//button[text()='Save']";
  	
  	public static final String Secret_Template_Page= "Secret Template Page#xpath=//table[@id='SecretTypeDialog_DialogTable']//td[@class='dialog_top']";
  	public static final String Secret_Template_Edit_Page = "Secret Template Edit Page#xpath=//table[@id='SecretTypeEditDialog_DialogTable']//td[@class='dialog_body']";

	
	
	public AdminPage(BaseClass obj) {
		super(obj);
	}
	
//	public void EnableRemotePasswordChanging() {
//		mouseOver(btn_Admin_Tab);
//		clickOn(btn_Remote_Password_Change);
//		if (elementPresent(Remote_Password_Change_Page_dialog_top)) {
//			testStepPassed("Remote Password Change Page is displayed");
//			String RemotePasswordChangeStatus = getText(txt_Remote_Pass_Change_field);
//			
//			if (RemotePasswordChangeStatus.equals("Yes")) {
//				testStepInfo("Enable Remote Password Changing is checked");
//				vstsTestStepPassed("Enable Remote Password Changing is checked", false);
//				clickOn(OR.btn_home_icon);
//			}
//			else {
//				clickOn(btn_Remote_Password_Change_Edit);
//				selectCheckBox(chk_Enable_Remote_Password_Change);
//				clickOn(btn_Remote_Password_Change_Save);
//				String PasswordChangeStatus = getText(txt_Remote_Pass_Change_field);
//				if (PasswordChangeStatus.equals("Yes")) {
//					testStepPassed("Enable Remote Password Changing is checked");
//					vstsTestStepPassed("Enable Remote Password Changing is checked", false);
//				}
//				else {
//					System.out.println("PasswordChangeStatus"+PasswordChangeStatus);
//					testStepFailed("Enable Remote Password Changing is unchecked"+PasswordChangeStatus);
//					vstsTestStepFailed("Enable Remote Password Changing is unchecked", false);
//				}
//				
//			}
//		}
//		else {
//			testStepFailed("Remote Password Change Page is not displayed");
//		}
//	}
	
	public void ValidateRemotePasswordParamwithVsts(String RemortePassParams, String RemortPassParamStatus) {
		
		if(EnableDisableRemotePasswordChangingParameters(RemortePassParams, RemortPassParamStatus)) {
			vstsTestStepPassed(RemortePassParams+ " value is Same", false);
		}
		else {
			vstsTestStepFailed(RemortePassParams+" Value is Different", true);
		}
	}
	
	public void ValidateEnableDisableHBINSecretTemplate(String TemplateName, String SecretetemplateParas, String EnableHeartbeatSecret) {
		
		if(enableDiasableRemotePasswordandHBInSecretTemplates (TemplateName, SecretetemplateParas, EnableHeartbeatSecret)) {
			vstsTestStepPassed(SecretetemplateParas+ " value is Same", false);
		}
		else {
			vstsTestStepFailed(SecretetemplateParas+" Value is Different", true);
		}
	}
	
	
}
