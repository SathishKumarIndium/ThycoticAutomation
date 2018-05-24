package pages;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;

public class SecretPage extends ApplicationKeywords{
	
    public static final String Secret_Page_Title = "Secret page title#xpath=//table[@id='SecretViewDialog_DialogTable']//a[contains(text(),'General')]";
	public static final String Secret_template_fields = "Secret template fields#xpath=//span";
	public static final String SecretNamexpath = "Secret Name#id=SecretNameTextBox";
	public static final String Domainxpath = "Domain name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox";
	public static final String UsernameXpath= "Secret User name#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox";
	public static final String NoteXpath = "Secret Note#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox";
	public static final String btn_Generat_field = "generate button#id=SecretItemDisplay_SecretItemsRepeater_ctl02_GeneratePassword";
	public static final String txt_password_field = "password text field#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox";
	public static final String txt_Strongxpath = "//span[text()='Strong']" ;
	
	public SecretPage(BaseClass obj) {
		super(obj);
	}
	
	public void SelectSecretInNewTab(String SecretTempalte) {
		
		openSecreteTemplatePage(SecretTempalte);
		
		if (elementPresent(Secret_Page_Title)) {
			testStepPassed("New Secret Create Page is present");
			vstsTestStepPassed("New Secret Create Page is present", true);
		}
		else {
			testStepFailed("New Secret Create Page is not present");
			vstsTestStepFailed("New Secret Create Page is not present", true);
		}
		
	}
	
	public void validateSecretWithfields(String SecretTempalte, String SecretName, String Domain,
			String Username, String Note, String SecretTemplateFields) {
		SelectSecretInNewTab(SecretTempalte);
		
		if (validateAllElementisDisplay(Secret_template_fields, SecretTemplateFields)) {
			testStepPassed("All Fields are present");
			vstsTestStepPassed("All fields are present", true);
		}
		else {
			testStepFailed("Some fields are not present");
			vstsTestStepFailed("Some fields are not present", false);
		}
		
		typeIn(SecretNamexpath, SecretName);
		typeIn(Domainxpath, Domain);
		typeIn(UsernameXpath, Username);
		typeIn(NoteXpath, Note);
		
		if (ValidateEnterValusInTextField(SecretNamexpath, SecretName, "SecretName") && ValidateEnterValusInTextField(Domainxpath, Domain, "Domain")
				&& ValidateEnterValusInTextField(UsernameXpath, Username, "UserName") && ValidateEnterValusInTextField(NoteXpath, Note, "Note")) {
			testStepPassed("values entered in the specified fields should be displayed");
			vstsTestStepPassed("values entered in the specified fields should be displayed", true);
		}
		else {
			testStepFailed("values entered in the specified fields should not be displayed");
			vstsTestStepFailed("values entered in the specified fields should not be displayed", true);
		}	
	}
	
	
	public void validateGenerateButtonWithPasseords(String SecretTempalte, String SecretName, String Domain,
			String TemplateUsername, String Note, String SecretTemplateFields) {
		
		validateSecretWithfields(SecretTempalte,  SecretName, Domain, TemplateUsername, Note, SecretTemplateFields);
		
		if (elementPresent(btn_Generat_field)) {
			testStepPassed("Generate button is present");
			vstsTestStepPassed("Generate button is present", true);
		}
		else {
			testStepFailed("Generate button is not present");
			vstsTestStepFailed("Generate button is not present", true);
		}
		
		clickOn(btn_Generat_field);
		
		waitTime(3);
		waitForElementToDisplay("xpath for folders#xpath="+txt_Strongxpath, 10);
		
		String Passwordvalue = getAttributeValue(txt_password_field, "value");
		if (!Passwordvalue.isEmpty()) {
			testStepPassed("Password field have values after clicking generate button");
			vstsTestStepPassed("Password field have values after clicking generate button", true);
		}
		else {
			testStepFailed("password have no values after clicking generate button");
			vstsTestStepFailed("password have no values after clicking generate button", true);
		}
		
		if (elementDisplayed(txt_Strongxpath, "Strong")) {
			testStepPassed("Strong field is displayed");
			vstsTestStepPassed("Strong field is displayed", true);
		}
		else {
			testStepFailed("Strong field is not displayed");
			vstsTestStepFailed("Strong field is not displayed", true);
		}
	}
	
}
