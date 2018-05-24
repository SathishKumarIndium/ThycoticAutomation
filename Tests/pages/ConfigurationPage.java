package pages;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;


public class ConfigurationPage  extends ApplicationKeywords  {
	
	public static final String btn_Admin_configuration_Icon = "Configuration in admin tab#xpath=//a[text()='Configuration']";
  	public static final String txt_configuration_page_header = "Configuration page header#xpath=//td[@class='dialog_top' and text()='Configuration']";
  	public static final String btn_Configuration_Page_Edit_button = "configuration page edit button#id=EditButton";
  	public static final String drd_Default_SecretPermissions = "select Default secret permission option#xpath=//span[text()='Default Secret Permissions']/parent::td/following-sibling::td/select";
  	public static final String btn_Configuration_Page_Save_button = "Configuration page save button#id=SaveButton";
  	public static final String txt_Default_Secret_Permissions  = "Text for Default Secret Permissions in configuration page#xpath=//span[text()='Default Secret Permissions']/parent::td/following-sibling::td/span";
  	
	
	public ConfigurationPage(BaseClass obj) {
		super(obj);
	}
	
	public boolean SetDefaultSecretPermissions(String DefaultSecretPermissionParams) {
		boolean Status = false;
		mouseOver(OR.btn_Admin_Tab);
		clickOn(btn_Admin_configuration_Icon);
		
		if (elementPresent(txt_configuration_page_header)) {
			testStepInfo("Configuration Page is displayed");
			
			String Secretpermission = getText(txt_Default_Secret_Permissions);
			
			if (Secretpermission.equals(DefaultSecretPermissionParams)) {
				testStepInfo("Default Secret Permission value is" + DefaultSecretPermissionParams);
				Status = true;
				clickOn(OR.btn_home_icon);
			}
			else {
				clickOn(btn_Configuration_Page_Edit_button);
				selectFromDropdown(drd_Default_SecretPermissions, DefaultSecretPermissionParams);
				clickOn(btn_Configuration_Page_Save_button);
				
				String SetSecretpermission = getText(txt_Default_Secret_Permissions);
				if (SetSecretpermission.equals(DefaultSecretPermissionParams)) {
					testStepPassed("Selected from 'Default Secret Permission' is same"+DefaultSecretPermissionParams);
					Status = true;
				}
				else {
					testStepFailed("Selected from 'Default Secret Permission' is not same "+DefaultSecretPermissionParams);
				}
			}			
		}
		else {
			testStepFailed("Configuration page is not displayed");
		}
		return Status;
	}
}
