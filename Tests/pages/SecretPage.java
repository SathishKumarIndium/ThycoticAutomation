package pages;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;

public class SecretPage extends ApplicationKeywords{
	
    public static final String Secret_Page_Title = "Secret page title#xpath=//table[@id='SecretViewDialog_DialogTable']//a[contains(text(),'General')]";
	public static final String Secret_template_fields = "Secret template fields#xpath=//span";
	public static final String SecretNamexpath = "Secret Name#id=SecretNameTextBox";
	public static final String Domainxpath = "Domain name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox";
	public static final String UsernameXpath= "Secret User name#xpath=//span[text()='Username']/parent::td/following-sibling::td//input[@class='SecretViewTextbox']";
	public static final String NoteXpath = "Secret Note#xpath=//span[text()='Notes']/parent::td/following-sibling::td//textarea[@class='SecretViewTextbox']";
	public static final String btn_Generat_field = "generate button#id=SecretItemDisplay_SecretItemsRepeater_ctl02_GeneratePassword";
	public static final String txt_password_field = "password text field#xpath=//span[text()='Password']/parent::td/following-sibling::td//input[@class='SecretPasswordTextbox PasswordDisplayField']";
	public static final String txt_Strongxpath = "//span[text()='Strong']" ;
	//public static final String Password_with_mask = "paswwork is mask#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox";
	//public static final String Password_with_unmask = "password is unmasked#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox_unmasked";
	public static final String btn_lock_field = "clicking lock item#xpath=//a[@id='SecretItemDisplay_SecretItemsRepeater_ctl02_UnMaskPasswordEditLink']";
	public static final String Open_lock_class = "Opening lock class#xpath=//a[@class='iconlink fa fa-lock fa-fw fa-unlock']";
	public static final String Close_lock_class = "Close lock icon#xpath=//a[@class='iconlink fa fa-lock fa-fw']";
	public static final String Password_with_mask = "//input[@id='SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox']";
	public static final String Password_with_unmask = "//input[@id='SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox_unmasked']";
	public static final String drp_txt_secretTemplate = "dropdown text value in secret template#xpath=//select[@id='SecretTypeDropDown']/option[@selected='selected']";
	public static final String default_Folder = "default folder#id=SecretFolderPicker_FolderLink";
	public static final String link_clear_folder     = "clear folder#id=SecretFolderPicker_ClearFolderLink";
	public static final String txt_pin_field = "pin text field#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox" ;     

	public static final String secret_save_button = "save button#id=SaveEditButton";
	
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
		if (!Passwordvalue.isEmpty() && elementDisplayed(Password_with_mask, "Password is unmasked")) {
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
	
	public void validateLockIconWithPassword(String SecretTempalte, String SecretName, String Domain,
			String TemplateUsername, String Note, String SecretTemplateFields) {
		
		validateSecretWithfields(SecretTempalte,  SecretName, Domain, TemplateUsername, Note, SecretTemplateFields);
		
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
		
		if (elementDisplayed(Password_with_mask, "Password is unmasked")) {
			testStepPassed("The field should contain the encrpted password");
			vstsTestStepPassed("The field should contain the encrpted password", true);
		}
		else {
			testStepFailed("The field should not contain the encrpted password");
			vstsTestStepFailed("The field should not contain the encrpted password", true);
		}
		
		clickOn(btn_lock_field);
		if (elementPresent(Open_lock_class) && elementDisplayed(Password_with_unmask, "Password is unmasked")) {
			testStepPassed("Lock is open and password is not masked");
			vstsTestStepPassed("Lock is open and password is not masked", true);
		}
		else {
			testStepFailed("Lock is not open or password is  masked");
			vstsTestStepFailed("Lock is not open or password is  masked", true);
		}
		
		clickOn(btn_lock_field);
		waitTime(2);
		if (elementPresent(Close_lock_class) && elementDisplayed(Password_with_mask, "Password is masked")) {
			testStepPassed("Lock is closed and password is  masked");
			vstsTestStepPassed("Lock is closed and password is  masked", true);
		}
		else {
			testStepFailed("Lock is not closed or password is unmasked");
			vstsTestStepFailed("Lock is not closed or password is  unmasked", true);
		}
	}
	
	
	public void validateCreateSecret(String SecretItem, String SecretName, String Server, String Username, String Password, 
			String Notes, String folderPath, String folderName, String Secretfields, String DefaultFolder) {
		
		switchTofolders(DefaultFolder);
		
		SelectSecretInNewTab(SecretItem);
		
		String getsecretname = getText(drp_txt_secretTemplate);
		
		if (getsecretname.equalsIgnoreCase(SecretItem)) {
			testStepPassed("Secret Template selected in the create new Secret page is same");
			vstsTestStepPassed("Secret Template selected in the create new Secret page is same", true);
		}
		else {
			testStepFailed("Secret Template selected in the create new Secret page is different");
			vstsTestStepFailed("Secret Template selected in the create new Secret page is different", true);
		}
		
		if (validateAllElementisDisplay(Secret_template_fields, Secretfields)) {
			testStepPassed("All element is present in secret template page");
			vstsTestStepPassed("All element is present in secret template page", true);
			
		}else {
			testStepFailed("Some element is not present");
			vstsTestStepFailed("Some element is not present", true);
		}
		
		if (DefaultFolder.equalsIgnoreCase("Admin") || DefaultFolder.equalsIgnoreCase("Admin_ss")) {
			DefaultFolder = "\\Personal Folders\\"+DefaultFolder;
		}
		else {
			DefaultFolder = "\\"+DefaultFolder;
		}
		
		String getDefaultfoldertext = getText(default_Folder);
		
		if (getDefaultfoldertext.equalsIgnoreCase(DefaultFolder)) {
			testStepPassed("Link for default folder path is present");
			vstsTestStepPassed("Link for default folder is present", true);
		}else {
			testStepFailed("Link for default folder path is not present");
			vstsTestStepFailed("Link for default folder path is not present", true);
		}
		
		if (elementPresent(link_clear_folder)) {
			clickOn("clear folder#id=SecretFolderPicker_ClearFolderLink");
			String gettextselectfolder = getText("No Selected Folder#id=SecretFolderPicker_FolderLink");
			if (gettextselectfolder.equals("No Selected Folder")) { 
				testStepPassed("Selected folder link is present after clicking clear link");
				vstsTestStepPassed("Selected folder link is present after clicking clear link", true);
			}
			else {
				testStepFailed("Seleted folder link is not present after clicking clear link");
				vstsTestStepFailed("Seleted folder link is not present after clicking clear link", true);
			}
		}
		else {
			testStepFailed("Clear link is not present");
			vstsTestStepFailed("clear link is not present", true);
		}
		
		boolean textfields = validatetextfieldinsecrets(SecretItem, SecretName, Username, Password, Server, Notes);
		if (textfields) {
			testStepPassed("User able to add a value in textfields");
			vstsTestStepPassed("User able to add a value in textfields", true);
		}
		else {
			testStepFailed("User not able to add a values");
			vstsTestStepFailed("User not able to add a values", true);
		}
		
		if (SecretItem.equals("Generic Discovery Credentials")) {
			// code for check the generate ssh
			// validate alert box message
			// clickon ok button
			// validate browser button is disable
		}
		
		folderfunctioninsecret(SecretItem, folderName, folderPath);
		
		if (SecretItem.equals("Pin") && SecretItem.equals("Generic Discovery Credentials")) {
			if (validateAllElementisDisplay(Secret_template_fields, "Inherit Secret Policy")) {
				testStepPassed("Inherit Secret Policy is displayed after select folder");
				vstsTestStepPassed("Inherit Secret Policy is displayed after select folder", true);
			}
			else {
				testStepFailed("Inherit Secret Policy is not displayed after select folder");
				vstsTestStepFailed("Inherit Secret Policy is not displayed after select folder", true);
			}
		}
		else if(SecretItem.equals("SQL Server Account")) {
			// Local' should be selected in site dropdown as default
		}
		
		if (SecretItem.equalsIgnoreCase("Active Directory Account")) {
			// clickon save and share button
		}
		else {
			clickOn(secret_save_button);
			if (elementPresent("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span")) {
				String SecretnameGUI =  getText("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span");
				if (SecretnameGUI.equals(SecretName)) {
					testStepPassed("Secret Name is same : "+SecretName);
					vstsTestStepPassed("Secret Name is same : "+SecretName, true);
				}
				else {
					testStepFailed("Secret Name is different : "+SecretName);
					vstsTestStepFailed("Secret Name is different : "+SecretName, true);
				}
			}
			else {
				testStepFailed("Secrete Template is not created");
				vstsTestStepFailed("Secret Name is different : "+SecretName, true);
			}
			
			if (SecretItem.equals("SQL Server Account")) {
				clickOn("clicking back button#id=BackToSearchResultsButton");
			}
			
			validateSecretispresent(SecretName, folderName, true);
		
		}
		
	}
	
	public boolean validatetextfieldinsecrets(String Secrettemplate, String Secretname, 
				String Username, String Password, String Domain, String Note) {
		
		boolean status = false;
		if (Secrettemplate.equalsIgnoreCase("Pin")) {
			if (ValidatetextfieldwithEnteringtext(SecretNamexpath, Secretname, "Username") &&
					ValidatetextfieldwithEnteringtext(txt_pin_field, Domain, "Pin") && ValidatetextfieldwithEnteringtext(NoteXpath, Note, "Note")) {
				status = true;
			}
		}
		else if(Secrettemplate.equalsIgnoreCase("Generic Discovery Credentials")) {
			if (ValidatetextfieldwithEnteringtext(SecretNamexpath, Secretname, "SecretName") &&  ValidatetextfieldwithEnteringtext(UsernameXpath, Username, "UserName") &&
					ValidatetextfieldwithEnteringtext(txt_password_field, Password, "Password") &&	ValidatetextfieldwithEnteringtext(NoteXpath, Note, "Note")) {
				status = true;
			}
		}
		else {
			if (ValidatetextfieldwithEnteringtext(SecretNamexpath, Secretname, "SecretName") &&  ValidatetextfieldwithEnteringtext(UsernameXpath, Username, "UserName") &&
					ValidatetextfieldwithEnteringtext(txt_password_field, Password, "Password") &&	ValidatetextfieldwithEnteringtext(NoteXpath, Note, "Note")
					&& ValidatetextfieldwithEnteringtext(Domainxpath, Domain, "Domain or server")) {
				status = true;
			}
		}
		return status;
	}
	
	public boolean validateSecretispresent(String SecretName, String foldername, boolean WithvstsUpdate) {

		boolean Status = false;
		clickOn(OR.btn_home_icon);
		switchTofolders(foldername);
		
		if (elementPresent("Secret in Dashboard Page#xpath=//td[text()='"+SecretName+"']")) {
			testStepPassed("Secret is present in Dashboard page");
			Status = true;
			if (WithvstsUpdate)
				vstsTestStepPassed("Secret is present in Dashboard page", false);
		}
		else {
			testStepFailed("Secret is not present in Dashboard page");
			Status = false;
			if (WithvstsUpdate)
				vstsTestStepFailed("Secret is not present in Dashboard page", true);
		}
		return Status;
	}
	
	public void folderfunctioninsecret(String SecretItem, String folderName, String folderPath) {
		
		if (SecretItem.equals("Generic Discovery Credentials") && SecretItem.equals("Active Directory Account")) {
			clickOn("No Selected Folder#id=SecretFolderPicker_FolderLink");
			
			switchToFrame("ifram#xpath=//iframe[@id='popupFrame']");
			if (elementDisplayed("//div[text()='Select a Folder']", "select folder Folder")) {
				testStepPassed("The Select Folder dialog box should be opened");
				vstsTestStepPassed("The Select Folder dialog box should be opened", true);
				typeIn("search box for folder path#xpath=//span[text()='Folder Search']/following-sibling::input", folderName);
				clickOn("click on folder#xpath=//div[text()='"+folderPath+"']");
				waitTime(3);
				String gettextselectfolder = getText("No Selected Folder#id=SecretFolderPicker_FolderLink");
				if (gettextselectfolder.equals("\\"+folderPath)) { 
					testStepPassed("Selected folder link is present after clicking clear link");
					vstsTestStepPassed("Selected folder link is present after clicking clear link", true);
					System.out.println("verify");
					
				}
				else {
					testStepFailed("Seleted folder link is not present after clicking clear link");
					vstsTestStepFailed("Seleted folder link is not present after clicking clear link", true);
				}
			}
			else {
				testStepFailed("The Select Folder dialog box should not opened");
				vstsTestStepFailed("The Select Folder dialog box should not opened", true);
			}
		}
		else {
			clickOn("No Selected Folder#id=SecretFolderPicker_FolderLink");
			
			if (elementDisplayed("//div[text()='Select a Folder']", "select folder Folder")) {
				testStepPassed("The Select Folder dialog box should be opened");
				vstsTestStepPassed("The Select Folder dialog box should be opened", true);
				
				switchToFrame("ifram#xpath=//iframe[@id='popupFrame']");
				typeIn("search box for folder path#xpath=//span[text()='Folder Search']/following-sibling::input", folderName);
								
				if (validateWebElements("//li[@class='ui-menu-item']/div", folderPath)) {
					testStepPassed("foldder path is displayed in dropdown");
					vstsTestStepPassed("folder path is displayed in dropdown", true);
					clickOn("click on folder#xpath=//div[text()='"+folderPath+"']");
					waitTime(3);
					String gettextselectfolder = getText("No Selected Folder#id=SecretFolderPicker_FolderLink");
					if (gettextselectfolder.equals("\\"+folderPath)) { 
						testStepPassed("Selected folder link is present after clicking clear link");
						vstsTestStepPassed("Selected folder link is present after clicking clear link", true);
					}
					else {
						testStepFailed("Seleted folder link is not present after clicking clear link");
						vstsTestStepFailed("Seleted folder link is not present after clicking clear link", true);
					}
				}
				else {
					testStepFailed("Selete folder path is not displayed in dropdown");
					vstsTestStepFailed("Seleted folder path is not displayed in dropdown", true);
				}
				
			}
			else {
				testStepFailed("The Select Folder dialog box should not opened");
				vstsTestStepFailed("The Select Folder dialog box should not opened", true);
			}
		}
	}
	
	
}
