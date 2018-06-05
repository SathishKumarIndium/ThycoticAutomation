package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.reporters.jq.TestPanel;

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
	
	public static final String Basic_link = "Basic link in Dashboard#id=BasicLabel";
	public static final String btn_create_secret_button = "Create a secret button in Basic#id=secretCreateContainer";

	public static final String secret_save_button = "save button#id=SaveEditButton";
	
	public static final String Select_new_frameid= "ifram#xpath=//iframe[@id='popupFrame']";
	public static final String select_folder_header= "//div[text()='Select a Folder']";
	public static final String folderpath_list = "//li[@class='ui-menu-item']/div";
	public static final String foldersearch_box = "search box for folder path#xpath=//span[text()='Folder Search']/following-sibling::input";
	public static final String link_folder_name = "No Selected Folder#id=SecretFolderPicker_FolderLink";
	
	public static final String secret_template_name = "secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span";
	
	public static final String Basic_link_page_title = "Basic link page#xpath=//div[@id='homeContainer']/fieldset[@class='searchContainer']";
	public static final String Basic_creat_new_secretpage = "Create New Secret Page#xpath=//table[@id='SecretViewDialog_DialogTable']//td[@class='dialog_top']";
	public static final String drp_secret_template = "select a Secret template#xpath=//select[@id='SecretTypeDropDown']";
	public static final String drp_selcttemplate_Convertion = "select a secret from dropdown#xpath=//select[@id='SecretTypeToDropDownList']";
	
	
	public static final String btn_convert_button = "convert button#id=ConvertSecretButton";
	//public static final String txt_convert_header = "Convert header#xpath=//table[@id='SecretViewDialog_DialogTable']//td[contains(text(),'ConvertionSecret')]";
	
	
	
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
	
	
	public void ValidateCreateWindowsAccount(String SecretItem, String SecretName, String Server, String Username, String Password, 
			String Notes, String folderPath, String folderName, String Secretfields, String DefaultFolder, boolean Basiclink) {
		
		CreateSecretuptofoldersteps(SecretItem, SecretName, Server, Username, Password, Notes, Secretfields, DefaultFolder, Basiclink);
		
		folderfunctionincreatesecret(folderName, folderPath, true);
		
		clickOn(secret_save_button);
		if (elementPresent(secret_template_name)) {
			String SecretnameGUI =  getText(secret_template_name);
			if (SecretnameGUI.equals(SecretName)) {
				testStepPassed("Secret Name is same : "+SecretName);
				vstsTestStepPassed("Secret Name is same : "+SecretName, true);
			}
			else {
				testStepFailed("Secret Name is different : "+SecretName);
				vstsTestStepFailed("Secret Name is different : "+SecretName, true);
			}
		}
		
		validateSecretispresent(SecretName, folderName, true);
		
	}
	
	
	public void ValidatecreatePinaccountInBasiclink(String SecretItem, String SecretName, String Server, 
			String Notes, String folderPath, String folderName, String Secretfields, String DefaultFolder, boolean Basiclink) {
		
		CreateSecretuptofoldersteps(SecretItem, SecretName, Server, null, null, Notes, Secretfields, DefaultFolder, Basiclink);
		folderfunctionincreatesecret(folderName, folderPath, true);
		
		if (validateAllElementisDisplay(Secret_template_fields, "Inherit Secret Policy")) {
			testStepPassed("Inherit Secret Policy is displayed after select folder");
			vstsTestStepPassed("Inherit Secret Policy is displayed after select folder", true);
		}
		else {
			testStepFailed("Inherit Secret Policy is not displayed after select folder");
			vstsTestStepFailed("Inherit Secret Policy is not displayed after select folder", true);
		}
		
		clickOn(secret_save_button);
		if (elementPresent(secret_template_name)) {
			String SecretnameGUI =  getText(secret_template_name);
			if (SecretnameGUI.equals(SecretName)) {
				testStepPassed("Secret Name is same : "+SecretName);
				vstsTestStepPassed("Secret Name is same : "+SecretName, true);
			}
			else {
				testStepFailed("Secret Name is different : "+SecretName);
				vstsTestStepFailed("Secret Name is different : "+SecretName, true);
			}
		}
		
		clickOn(OR.btn_home_icon);
		if(elementPresent("new secret#xpath=//label[text()='"+SecretName+"']")) {
			testStepPassed("secret is created");
			vstsTestStepPassed("secret is created", true);
		}
		else {
			testStepFailed("Secret is not created");
			vstsTestStepFailed("Secret is not created", true);
		}
		
	}
	
	
	
	public void CreateSecretuptofoldersteps(String SecretItem, String SecretName, String Server, String Username, String Password, 
			String Notes, String Secretfields, String DefaultFolder, boolean Basiclink) {
		if (Basiclink) {
			
			clickOn(Basic_link);
			if (elementPresent(Basic_link_page_title)) {
				testStepPassed("Simple page is displayed");
				vstsTestStepPassed("Simple page is not displayed", true);
			}
			else {
				testStepFailed("Simple page is not displayed");
				vstsTestStepFailed("Simple page is not displayed", true);
			}
			
			clickOn(btn_create_secret_button);
			waitTime(2);
			
			if (elementPresent(Basic_creat_new_secretpage)) {
				testStepPassed("Create New Secret page is displayed");
				vstsTestStepPassed("Create New Secret page is displayed", true);
			}
			else {
				testStepFailed("Create New Secret page is not displayed");
				vstsTestStepFailed("Create New Secret page is displayed", true);
			}
			
			selectFromDropdown(drp_secret_template, SecretItem);
			
		}
		else {
			switchTofolders(DefaultFolder);
			
			SelectSecretInNewTab(SecretItem);
		}
		
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
			String gettextselectfolder = getText(link_folder_name);
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
		
	public void folderfunctionincreatesecret(String folderName, String folderPath, boolean FolderpathStatus) {
		clickOn(link_folder_name);
		
		if (elementDisplayed(select_folder_header, "select folder Folder")) {
			testStepPassed("The Select Folder dialog box should be opened");
			vstsTestStepPassed("The Select Folder dialog box should be opened", true);
			
			switchToFrame(Select_new_frameid);
			typeIn(foldersearch_box, folderName);
							
			if (FolderpathStatus) {
				if (validateWebElements(folderpath_list, folderPath)) {
					testStepPassed("foldder path is displayed in dropdown");
					vstsTestStepPassed("folder path is displayed in dropdown", true);
				} else {
					testStepFailed("Selete folder path is not displayed in dropdown");
					vstsTestStepFailed("Seleted folder path is not displayed in dropdown", true);
				} 
			}
			
			clickOn("click on folder#xpath=//div[text()='"+folderPath+"']");
			waitTime(3);
			
			String gettextselectfolder = getText(link_folder_name);
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
			testStepFailed("The Select Folder dialog box should not opened");
			vstsTestStepFailed("The Select Folder dialog box should not opened", true);
		}
	}
	
	public void ValidateConvertActiveDirectorytoWindows(String PresentSecretTemplate, String NewSecrettemplate, String SecretName, 
			String PreSecretFields, String PresentSecretFields, String InvalidSeleteoption, String ValidSeleteoption, 
			String SecretDataValue, String ExpectedMessage) {
		
		clickOn("Clicking "+SecretName+" Secret in DashBoard#xpath=//td[text()='"+SecretName+"']");
		
		if (isElementDisplayed(OR.btn_Secret_view_button)) {
			testStepPassed("Secret Is Expended");
			vstsTestStepPassed("Secret Is Expended", false);
		}
		else {
			testStepFailed("Secret is not Expended");
			vstsTestStepFailed("Secret is not Expended", true);
		}
		
		clickOn(OR.btn_Secret_view_button);
		
		if (isElementDisplayed("Secret Server Page#xpath=//td[@class='dialog_top' and contains(text(),'"+SecretName+"')]")) {
			testStepPassed("Secret Server page is Displayes");
			vstsTestStepPassed("Secret Server page is Displayes", false);
		}
		else {
			testStepFailed("Secret Server Page is Not Displayed");
			vstsTestStepFailed("Secret Server Page is Not Displayed", true);
		}
		
		clickOn(btn_convert_button);
		
		if (elementPresent("Convert header#xpath=//table[@id='SecretViewDialog_DialogTable']//td[contains(text(),'"+SecretName+"')]")) {
			testStepPassed("convert page is displayed");
			vstsTestStepPassed("Convertion page is displayed", true);
		}
		else {
			testStepFailed("Convertion page is not displayed");
			vstsTestStepFailed("Convertion page is not displayed", true);
		}
		
		String GuiSelectDropDrown = getAttributeValue(SecretNamexpath, "value");
		
		if (GuiSelectDropDrown.equals(SecretName)) {
			testStepPassed("Existing Secret Name is displayed in convert page");
			vstsTestStepPassed("Existing Name is displayed in convert page", true);
		}
		else {
			testStepFailed("Exisiting Secret Name is not displayed");
			vstsTestStepFailed("Exisiting Secret Name is not displayed in convert page", true);
		}
		
		selectFromDropdown(drp_selcttemplate_Convertion, PresentSecretTemplate);
		
		if (validatefieldspresentinconvertion(PreSecretFields, PresentSecretFields)) {
			testStepPassed("All element is reflected in specified template");
			vstsTestStepPassed("All element is reflected in specified template", true);
		}
		else {
			testStepFailed("Some element are not reflected in specified template");
			vstsTestStepFailed("Some element are not reflected in specified template", true);
		}
		
		waitTime(3);
	
		SelectConvertonwithoptions(InvalidSeleteoption, ExpectedMessage, null);
		
		SelectConvertonwithoptions(ValidSeleteoption, "", SecretDataValue);		
	}
	
	public void deleteSecret(String createSec_elements,String SecretName,String Tabs, String AlertMessage,String foldername)
	{


		clickOn("Secret Name#xpath=//table[@id='secretTable_2']//td[@title='"+SecretName+"']");

		if(validateAllElementisDisplay(OR.lst_SecretElements, createSec_elements)==true)
		{
			testStepPassed("The Secret Elements are found");
			vstsTestStepPassed("The Secret Elements are found", false);
		}
		else
		{
			testStepFailed("The Secret element is not found");
			vstsTestStepFailed("The Secret element is not found", true);
		}

		clickOn("View button#xpath=//a[text()='View']");

		if(validateElementisDisplay(OR.lbl_SecretPageTitle, SecretName)==1)
		{
			testStepPassed("Secret Page is validated");
			vstsTestStepPassed("Secret Page is validated", false);
		}
		else
		{
			testStepFailed("Unable to navigate to Secretpage");
			vstsTestStepFailed("Unable to navigate to Secretpage", true);
		}

		if(validateAllElementisDisplay(OR.lbl_secretPagetabs, Tabs)==true)
		{
			testStepPassed("Elements validated in secrets page");
			vstsTestStepPassed("Elements validated in secrets page", false);
		}
		else
		{
			testStepFailed("Unable to Elements in secrets page");
			vstsTestStepFailed("Unable to Elements in secrets page", true);
		}

		clickOn("DeleteButton#xpath=//button[@name='DeleteButton']");

		String alertText = getAlertText();

		if(alertText.contains(AlertMessage))
		{
			testStepPassed("Deletion Pop-Up is displayed");
			vstsTestStepPassed("Deletion Pop-Up is displayed", false);
		}
		else
		{
			testStepFailed("Deletion Pop-Up is not displayed");
			vstsTestStepFailed("Deletion Pop-Up is not displayed", true);
		}

		alertOk();

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

		switchTofolders(foldername);

		if (!elementPresent("Secret in Dashboard Page#xpath=//td[text()='"+SecretName+"']")) {
			testStepPassed("Secret is not present in Dashboard page");
			vstsTestStepPassed("Secret is not present in Dashboard page", false);
		}
		else {
			testStepFailed("Secret is  present in Dashboard page");
			vstsTestStepFailed("Secret is  present in Dashboard page", true);
		}

	}
	
	public void PerformingSecretActionswithAD(String SecretItem,String SecretName,String Domain, String Username,String Password,String Notes,String folderPath, String folderName,String Inherit,String Secret_Policy, String AutoChange)
	{
		openSecreteTemplatePage(SecretItem);

		if(validateElementisDisplay("Validating Header New in Secrets#xpath=//table[@id='SecretViewDialog_DialogTable']//td", "New")==1)
		{
			testStepPassed("Navigated to the secret page");
			vstsTestStepPassed("Navigated to the secret page", false);
		}
		else
		{
			testStepFailed("Unable to navigate to Secret page");
			vstsTestStepFailed("Unable to navigate to Secret page", true);
		}

		//String SecretType = getText("Getting secret Type#xpath=//select[@name='SecretTypeDropDown']/option[@selected='selected']");

		if(elementPresent("Active Directory Account#xpath=//select[@name='SecretTypeDropDown']/option[@selected='selected' and text()='"+SecretItem+"']"))
		{
			testStepPassed("Verified Presence of Active directory Account");
			vstsTestStepPassed("Verified Presence of Active directory Account", false);
		}
		else
		{
			testStepFailed("Unable to verify the presence of Active Directory Account");
			vstsTestStepFailed("Unable to verify the presence of Active Directory Account", true);
		}



		clickOn("Clear button#xpath=//td//a[text()='Clear']");

		if(elementPresent(OR.btn_newFolder))
		{
			testStepPassed("Folder path cleared");
			vstsTestStepPassed("Folder path cleared", false);
		}
		else
		{
			testStepFailed("Unable to clear folder");
			vstsTestStepFailed("Unable to clear folder", true);
		}

		typeIn("Secret Name#id=SecretNameTextBox", SecretName);
		typeIn("Entering Server or Doman name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", Domain);
		typeIn("Entering Username textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", Username);
		typeIn("Entering Password textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", Password);
		typeIn("Entering Note textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox", Notes);

		boolean secName = ValidateEnterValusInTextField("Secret Name#id=SecretNameTextBox", SecretName, SecretName);
		boolean dom = ValidateEnterValusInTextField("Entering Server or Doman name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", Domain, Domain);
		boolean usr = ValidateEnterValusInTextField("Entering Username textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", Username, Username);
		boolean pwd = ValidateEnterValusInTextField("Entering Password textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", Password, Password);
		boolean note = ValidateEnterValusInTextField("Entering Note textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox", Notes, Notes);

		if(secName==true&&dom==true&&usr==true&&pwd==true&&note==true)
		{
			testStepPassed("Able to enter text in respective text fields");
			vstsTestStepPassed("Able to enter text in respective text fields", false);
		}
		else
		{
			testStepFailed("Unable to enter text in respective text fields");
			vstsTestStepFailed("Unable to enter text in respective text fields", true);
		}

		clickOn(OR.btn_newFolder);

		if(elementPresent("Select a folder#xpath=//div[@id='popupTitle' and text()='Select a Folder']"))
		{
			testStepPassed("Select a folder pop up is present");
			vstsTestStepPassed("Select a folder pop up is present", false);
		}
		else
		{
			testStepFailed("Select a folder pop up is not present");
			vstsTestStepFailed("Select a folder pop up is not present", true);
		}

		switchToFrame("iframe#xpath=//iframe[@id='popupFrame']");

		typeIn("Folder Search#xpath=//div[@id='FolderSearchControl']/input[@name='SearchTextBox']", folderName);

		if(elementPresent("Link of folder#xpath=//li[@class='ui-menu-item']/div[@class='ui-menu-item-wrapper']"))
		{
			testStepPassed("The link is present after entering folder name");
			vstsTestStepPassed("The link is present after entering folder name", false);
		}
		else
		{
			testStepFailed("The link is not present after entering folder name");
			vstsTestStepFailed("The link is not present after entering folder name", true);
		}

		clickOn("Link of folder#xpath=//li[@class='ui-menu-item']/div[@class='ui-menu-item-wrapper']");

		clickOn("click on SaveandNew#xpath=//button[@name='SaveAndAddNewButton']");

		if(validateElementisDisplay("Validating Header New in Secrets#xpath=//table[@id='SecretViewDialog_DialogTable']//td", "New")==1)
		{
			testStepPassed("Navigated to the secret page");
			vstsTestStepPassed("Navigated to the secret page", false);
		}
		else
		{
			testStepFailed("Unable to navigate to Secret page");
			vstsTestStepFailed("Unable to navigate to Secret page", true);
		}


	}
	
	
	
	public void validationAddShareWithAD(String AdminPermission,String UserPermission,String Addgrp_userDrpdown,String Usersname,String Admindrp,String SecretTemplateItem,String ADpageElements,String SecretName,String Domain, String Username,String Password,String Notes,String folderPath, String folderName,String Inherit,String Secret_Policy, String AutoChange)
	{
		clickOn(OR.btn_advancedTab_dashboard);
		openSecreteTemplatePage(SecretTemplateItem);
		
		if(validateElementisDisplay("Validating Header New in Secrets#xpath=//table[@id='SecretViewDialog_DialogTable']//td", "New")==1)
		{
			testStepPassed("Navigated to the secret page");
			vstsTestStepPassed("Navigated to the secret page", false);
		}
		else
		{
			testStepFailed("Unable to navigate to Secret page");
			vstsTestStepFailed("Unable to navigate to Secret page", true);
		}
		
		

		
		
		if(elementPresent("Selected option in Secret#xpath=//select[@name='SecretTypeDropDown']/option[@selected='selected' and text()='Active Directory Account']"))
		{
			testStepPassed("Verified Presence of Active directory Account");
			vstsTestStepPassed("Verified Presence of Active directory Account", false);
		}
		else
		{
			testStepFailed("Unable to verify the presence of Active Directory Account");
			vstsTestStepFailed("Unable to verify the presence of Active Directory Account", true);
		}
		
		if(validateAllElementisDisplay("AD secret elements#xpath=//td[contains(@class,'FormFieldLabelContainer')]/span", ADpageElements))
		{
			testStepPassed("Elements pesent in AD page");
			vstsTestStepPassed("Elements pesent in AD page", false);
		}
		else
		{
			testStepFailed("Elements not pesent in AD page");
			vstsTestStepFailed("Elements not pesent in AD page", true);
			
		}
		
		if(elementPresent("Folder link#xpath=//a[@id='SecretFolderPicker_FolderLink']"))
		{
			testStepPassed("Link pesent in AD page");
			vstsTestStepPassed("Link pesent in AD page", false);
		}
		else
		{
			testStepFailed("Link not pesent in AD page");
			vstsTestStepFailed("Link not pesent in AD page", true);
		}
		
		clickOn("Clear button#xpath=//td//a[text()='Clear']");

		if(elementPresent(OR.btn_newFolder))
		{
			testStepPassed("Folder path cleared");
			vstsTestStepPassed("Folder path cleared", false);
		}
		else
		{
			testStepFailed("Unable to clear folder");
			vstsTestStepFailed("Unable to clear folder", true);
		}
		
		typeIn("Secret Name#id=SecretNameTextBox", SecretName);
		typeIn("Entering Server or Doman name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", Domain);
		typeIn("Entering Username textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", Username);
		typeIn("Entering Password textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", Password);
		typeIn("Entering Note textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox", Notes);

		boolean secName = ValidateEnterValusInTextField("Secret Name#id=SecretNameTextBox", SecretName, SecretName);
		boolean dom = ValidateEnterValusInTextField("Entering Server or Doman name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", Domain, Domain);
		boolean usr = ValidateEnterValusInTextField("Entering Username textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", Username, Username);
		boolean pwd = ValidateEnterValusInTextField("Entering Password textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", Password, Password);
		boolean note = ValidateEnterValusInTextField("Entering Note textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox", Notes, Notes);

		if(secName==true&&dom==true&&usr==true&&pwd==true&&note==true)
		{
			testStepPassed("Able to enter text in respective text fields");
			vstsTestStepPassed("Able to enter text in respective text fields", false);
		}
		else
		{
			testStepFailed("Unable to enter text in respective text fields");
			vstsTestStepFailed("Unable to enter text in respective text fields", true);
		}
		
		if(elementPresent(OR.btn_newFolder))
			
		{
			testStepPassed("New folder is present");
			vstsTestStepPassed("New folder is present", false);
		}
		else
		{
			testStepFailed("New folder is not present");
			vstsTestStepFailed("New folder is not present", true);
		}
		
		clickOn(OR.btn_newFolder);

		if(elementPresent("Select a folder#xpath=//div[@id='popupTitle' and text()='Select a Folder']"))
		{
			testStepPassed("Select a folder pop up is present");
			vstsTestStepPassed("Select a folder pop up is present", false);
		}
		else
		{
			testStepFailed("Select a folder pop up is not present");
			vstsTestStepFailed("Select a folder pop up is not present", true);
		}

		switchToFrame("iframe#xpath=//iframe[@id='popupFrame']");

		typeIn("Folder Search#xpath=//div[@id='FolderSearchControl']/input[@name='SearchTextBox']", folderName);

		if(elementPresent("Link of folder#xpath=//li[@class='ui-menu-item']/div[@class='ui-menu-item-wrapper']"))
		{
			testStepPassed("The link is present after entering folder name");
			vstsTestStepPassed("The link is present after entering folder name", false);
		}
		else
		{
			testStepFailed("The link is not present after entering folder name");
			vstsTestStepFailed("The link is not present after entering folder name", true);
		}

		clickOn("Link of folder#xpath=//li[@class='ui-menu-item']/div[@class='ui-menu-item-wrapper']");
		
		unSelectCheckBox("Inherit Secret policy#xpath=//input[@id='EnableInheritSecretPolicyCheckBox']");
		
		if(!elementPresent("Inherit Secret Policy#xpath=//input[@id='EnableInheritSecretPolicyCheckBox' and @checked='checked']"))
		{
			testStepPassed("The Inherit Secret Policy is unchecked");
			vstsTestStepPassed("The Inherit Secret Policy is unchecked", false);
		}
		else
		{
			testStepFailed("The Inherit Secret Policy is checked");
			vstsTestStepFailed("The Inherit Secret Policy is checked", true);
		}
		
		
		
		if(elementPresent("Local Option in Site#xpath=//option[@selected='selected' and text()='Local']"))
		{
			testStepPassed("Local option is present in site drop down");
			vstsTestStepPassed("Local option is present in site drop down", false);
		}
		else
		{
			testStepFailed("Local option is not present in site drop down");
			vstsTestStepFailed("Local option is not present in site drop down", true);
		}
		
		clickOn(OR.btn_SaveAndShare);
		
		
		
		if(elementPresent("Secret share page#xpath=//span[text()='Secret Share']"))
		{
			testStepPassed("Navigated to Secret Share Page");
			vstsTestStepPassed("Navigated to Secret Share Page", false);
		}
		else
		{
			testStepFailed("Unable to navigate to Secret Share Page");
			vstsTestStepFailed("Unable to navigate to Secret Share Page", true);
		}
		
		mouseOver("Secret permissions help#xpath=//div[@id='SecretPermissionExplanationReadOnly']");
		
		if(elementPresent("Secret Permission help msg#xpath=//div[@class='balloon-tooltip' and contains(text(),'Edit - Able to edit details of Secrets')]"))
		{
			testStepPassed("Help message is present");
			vstsTestStepPassed("Help message is not present", false);
		}
		else
		{
			testStepFailed("Help message is not present");
			vstsTestStepFailed("Help message is not present", true);
		}
		
		unSelectCheckBox(OR.chk_InheritSecretFolders);
		
		if(elementPresent(OR.lbl_Sharedwith) && elementPresent(OR.lbl_AddGroup_User))
		{
			testStepPassed("Add Group/user and shared with options are present");
			vstsTestStepPassed("Add Group/user and shared with options are present", false);
		}
		else
		{
			testStepFailed("Add Group/user and shared with options are not present");
			vstsTestStepFailed("Add Group/user and shared with options are not present", true);
		}
		
		if(validateAllElementisDisplay(OR.drp_adminDropdown, Admindrp))
		{
			testStepPassed("The permissions are present in Admin Dropdown");
			vstsTestStepPassed("The permissions are present in Admin Dropdown", false);
		}
		else
		{
			testStepFailed("The permissions are not present in Admin Dropdown");
			vstsTestStepFailed("The permissions are not present in Admin Dropdown", true);
		}
		
		if(elementPresent("Owner option#xpath=//select[contains(@data-bind,'options')]/option[text()='Owner']"))
		{
			testStepPassed("The Owner permission is present by default");
			vstsTestStepPassed("The Owner permission is present by default", false);
		}
		else
		{
			testStepFailed("The Owner permission is not present by default");
			vstsTestStepFailed("The Owner permission is not present by default", true);
		}
		
		
		
		selectFromDropdown(""+AdminPermission+" option#xpath=//select[contains(@data-bind,'options')]", AdminPermission);
		
		if(elementPresent(""+AdminPermission+" option#xpath=//select[contains(@data-bind,'options')]/option[text()='"+AdminPermission+"']"))
		{
			testStepPassed("Permission can be changed to Edit/View/List");
			vstsTestStepPassed("Permission can be changed to Edit/View/List", false);
		}
		else
		{
			testStepFailed("Permission cannot be changed to Edit/View/List");
			vstsTestStepFailed("Permission cannot be changed to Edit/View/List", true);
		}
		
		if(validateAllElementisDisplay("Usergrp#xpath=//select[@class='UserGroupDropdown']/option", Addgrp_userDrpdown))
		{
			testStepPassed("User elements found");
			vstsTestStepPassed("User elements found", false);
		}
		else
		{
			testStepFailed("User elements not found");
			vstsTestStepFailed("User elements not found", true);
		}
		
		selectFromDropdown(OR.drp_AddGroup_User, Usersname);
		
		if(elementPresent("User present in Share with#xpath=//span[@id='EditPermissionsTableContainer']//span[@class='UserIconImage' and text()='"+Usersname+"']"))
		{
			testStepPassed("User is present in Share with table");
			vstsTestStepPassed("User is present in Share with table", false);
		}
		else
		{
			testStepFailed("User is not present in Share with table");
			vstsTestStepFailed("User is not present in Share with table", true);
		}
		
		
		
		if(validateAllElementisDisplay("User dropdown#xpath=//span[text()='"+Usersname+"']/../following-sibling::td/select/option", Admindrp))
		{
			testStepPassed("The permissions are present in user Dropdown");
			vstsTestStepPassed("The permissions are present in user Dropdown", false);
		}
		else
		{
			testStepFailed("The permissions are not present in user Dropdown");
			vstsTestStepFailed("The permissions are not present in user Dropdown", true);
		}
		
		if(validateAllElementisDisplay("User dropdown#xpath=//span[text()='"+Usersname+"']/../following-sibling::td/select/option", Admindrp))
		{
			testStepPassed("The permissions are present in user Dropdown");
			vstsTestStepPassed("The permissions are present in user Dropdown", false);
		}
		else
		{
			testStepFailed("The permissions are not present in user Dropdown");
			vstsTestStepFailed("The permissions are not present in user Dropdown", true);
		}
		
		selectFromDropdown("user drp#xpath=//span[text()='"+Usersname+"']/../following-sibling::td/select", UserPermission);
		
		if(elementPresent(""+UserPermission+" option#xpath=//span[text()='"+Usersname+"']/../following-sibling::td/select/option[text()='"+UserPermission+"']"))
		{
			testStepPassed("Permission can be changed to Edit/View/List");
			vstsTestStepPassed("Permission can be changed to Edit/View/List", false);
		}
		else
		{
			testStepFailed("Permission cannot be changed to Edit/View/List");
			vstsTestStepFailed("Permission cannot be changed to Edit/View/List", true);
		}
		
		clickOn("Remove User Group#xpath=//span[text()='NewUser']/../following-sibling::td//button");
		
		if(!elementPresent("User present in Share with#xpath=//span[@id='EditPermissionsTableContainer']//span[@class='UserIconImage' and text()='"+Usersname+"']"))
		{
			testStepPassed("User is not present in Share with table");
			vstsTestStepPassed("User is not present in Share with table", false);
		}
		else
		{
			testStepFailed("User is present in Share with table");
			vstsTestStepFailed("User is present in Share with table", true);
		}
		
		clickOn(OR.btn_Configuration_Page_Save_button);
		if(elementPresent("No Longer Owner Message#xpath=//span[text()='No Longer Owner']"))
		{
			testStepPassed("No Longer message is Present");
			vstsTestStepPassed("No Longer message is Present", false);
		}
		else
		{
			testStepFailed("No Longer message is not Present");
			vstsTestStepFailed("No Longer message is not Present", true);
		}
		
		clickOn("OK Button#xpath=//div[@aria-describedby='AreYouSureOwnerRemovalModal']//button[contains(@class,'okButton')]");
		
		
		if(elementPresent("Select option msg#xpath=//div[text()='Please select at least one Secret owner permission for this Secret.']"))
		{
			testStepPassed("Please select atleast one owner for secret message is Present");
			vstsTestStepPassed("Please select atleast one owner for secret message is Present", false);
		}
		else
		{
			testStepFailed("Please select atleast one owner for secret message is not Present");
			vstsTestStepFailed("Please select atleast one owner for secret message is not Present", true);
		}
		
	}
	
	public void PerformsqlServerAccountValidation(String SecretItem,String SecretName, String Server,String Username,String Password,String Notes,String folderPath, String folderName,String Inherit,String Secret_Policy, String AutoChange,String sqlpageElements)
	{


		openSecreteTemplatePage(SecretItem);

		if(validateElementisDisplay("Validating Header New in Secrets#xpath=//table[@id='SecretViewDialog_DialogTable']//td", "New")==1)
		{
			testStepPassed("Navigated to the secret page");
			vstsTestStepPassed("Navigated to the secret page", false);
		}
		else
		{
			testStepFailed("Unable to navigate to Secret page");
			vstsTestStepFailed("Unable to navigate to Secret page", true);
		}

		//String SecretType = getText("Getting secret Type#xpath=//select[@name='SecretTypeDropDown']/option[@selected='selected']");

		if(elementPresent("Selected option in Secret#xpath=//select[@name='SecretTypeDropDown']/option[@selected='selected' and text()='"+SecretItem+"']"))
		{
			testStepPassed("Verified Presence of Active directory Account");
			vstsTestStepPassed("Verified Presence of Active directory Account", false);
		}
		else
		{
			testStepFailed("Unable to verify the presence of Active Directory Account");
			vstsTestStepFailed("Unable to verify the presence of Active Directory Account", true);
		}

		if(validateAllElementisDisplay("Elements in sql page#xpath=//td[contains(@class,'FormFieldLabelContainer')]/span", sqlpageElements))
		{
			testStepPassed("Elements validated in sql page");
			vstsTestStepPassed("Elements validated in sql page", false);
		}
		else
		{
			testStepFailed("Unable to validate in sql page");
			vstsTestStepFailed("Unable to validate in sql page", true);
		}

		if(elementPresent("Folder Link#xpath=//a[@id='SecretFolderPicker_FolderLink']"))
		{
			testStepPassed("Validated the presence of folder link");
			vstsTestStepPassed("Validated the presence of folder link", false);
		}
		else
		{
			testStepFailed("Unable to validate the presence of folder link");
			vstsTestStepFailed("Unable to validate the presence of folder link", true);
		}

		if(elementPresent("clear#xpath=//a[@class='PickerClearLink']"))
		{
			testStepPassed("Element found");
			vstsTestStepPassed("Element found", false);
		}
		else
		{
			testStepFailed("Element not found");
			vstsTestStepFailed("Element not found", true);
		}

		clickOn("Clear button#xpath=//td//a[text()='Clear']");

		if(elementPresent(OR.btn_newFolder))
		{
			testStepPassed("Folder path cleared");
			vstsTestStepPassed("Folder path cleared", false);
		}
		else
		{
			testStepFailed("Unable to clear folder");
			vstsTestStepFailed("Unable to clear folder", true);
		}

		typeIn("Secret Name#id=SecretNameTextBox", SecretName);
		typeIn("Entering Server or Doman name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", Server);
		typeIn("Entering Username textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", Username);
		typeIn("Entering Password textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", Password);
		typeIn("Entering Note textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox", Notes);

		boolean secName = ValidateEnterValusInTextField("Secret Name#id=SecretNameTextBox", SecretName, SecretName);
		boolean dom = ValidateEnterValusInTextField("Entering Server or Doman name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", Server, Server);
		boolean usr = ValidateEnterValusInTextField("Entering Username textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", Username, Username);
		boolean pwd = ValidateEnterValusInTextField("Entering Password textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", Password, Password);
		boolean note = ValidateEnterValusInTextField("Entering Note textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox", Notes, Notes);

		if(secName==true&&dom==true&&usr==true&&pwd==true&&note==true)
		{
			testStepPassed("Able to enter text in respective text fields");
			vstsTestStepPassed("Able to enter text in respective text fields", false);
		}
		else
		{
			testStepFailed("Unable to enter text in respective text fields");
			vstsTestStepFailed("Unable to enter text in respective text fields", true);
		}

		clickOn(OR.btn_newFolder);

		if(elementPresent("Select a folder#xpath=//div[@id='popupTitle' and text()='Select a Folder']"))
		{
			testStepPassed("Select a folder pop up is present");
			vstsTestStepPassed("Select a folder pop up is present", false);
		}
		else
		{
			testStepFailed("Select a folder pop up is not present");
			vstsTestStepFailed("Select a folder pop up is not present", true);
		}

		switchToFrame("iframe#xpath=//iframe[@id='popupFrame']");

		typeIn("Folder Search#xpath=//div[@id='FolderSearchControl']/input[@name='SearchTextBox']", folderName);

		if(elementPresent("Link of folder#xpath=//li[@class='ui-menu-item']/div[@class='ui-menu-item-wrapper']"))
		{
			testStepPassed("The link is present after entering folder name");
			vstsTestStepPassed("The link is present after entering folder name", false);
		}
		else
		{
			testStepFailed("The link is not present after entering folder name");
			vstsTestStepFailed("The link is not present after entering folder name", true);
		}

		clickOn("Link of folder#xpath=//li[@class='ui-menu-item']/div[@class='ui-menu-item-wrapper']");

		String site = getText("site#xpath=//select[@name='SiteDropDownList']/option[@selected='selected']");

		if(site.equalsIgnoreCase("Local"))
		{
			testStepPassed("Local is selected by default");
			vstsTestStepPassed("Local is selected by default", false);
		}
		else
		{
			testStepFailed("Local is not selected by default");
			vstsTestStepFailed("Local is not selected by default", true);
		}

		clickOn("SecretTemplate Save button#id=SaveEditButton");

		if(isElementDisplayed("secret saved#xpath=//td[@class='dialog_top' and contains(text(),'"+SecretName+"')]"))
		{
			testStepPassed("secret saved");
			vstsTestStepPassed("secret saved", false);
		}
		else
		{
			testStepFailed("Secret not saved");
			vstsTestStepFailed("Secret not saved", true);
		}

		clickOn("back#xpath=//button[@value='Back']");

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

		clickOn(OR.btn_home_icon);

	}
	
	public void addSharePinSecretValidation(String SecretItem,String SecretName, String PIN,String Notes,String folderPath, String folderName,String pinPageElements,String Admindrp,String usersdrp)
	{
		clickOn(OR.btn_BasicTab);

		if(elementPresent(OR.lbl_BasicPage))
		{
			testStepPassed("Navigated to basic page");
			vstsTestStepPassed("Navigated to basic page", false);
		}
		else
		{
			testStepFailed("Unable to navigate to basic page");
			vstsTestStepFailed("Unable to navigate to basic page", true);
		}

		clickOn(OR.btn_BasicPage_createNew);

		if(validateElementisDisplay("Validating Header New in Secrets#xpath=//table[@id='SecretViewDialog_DialogTable']//td", "New")==1)
		{
			testStepPassed("Navigated to the secret page");
			vstsTestStepPassed("Navigated to the secret page", false);
		}
		else
		{
			testStepFailed("Unable to navigate to Secret page");
			vstsTestStepFailed("Unable to navigate to Secret page", true);
		}

		clickOn("Secret dropdown#xpath=//a[@class='chosen-single']");
		
		if(elementPresent("Search box#xpath=//div[@class='chosen-search']/input"))
		{
			typeIn("Search box#xpath=//div[@class='chosen-search']/input", SecretItem);
			clickOn("Secret item#xpath=//div[@class='chosen-search']/following-sibling::ul/li/em");
		}
		else
		{
			selectFromDropdown("Secret Dropdown#id=SecretTypeDropDown", SecretItem);
		}

		

		//String SecretType = getText("Getting secret Type#xpath=//select[@name='SecretTypeDropDown']/option[@selected='selected']");

		if(elementPresent("Selected option in Secret#xpath=//select[@name='SecretTypeDropDown']/option[@selected='selected' and text()='"+SecretItem+"']"))
		{
			testStepPassed("Verified Presence of "+SecretItem+"");
			vstsTestStepPassed("Verified Presence of "+SecretItem+"", false);
		}
		else
		{
			testStepFailed("Unable to verify the presence of "+SecretItem+"");
			vstsTestStepFailed("Unable to verify the presence of "+SecretItem+"", true);
		}

		if(validateAllElementisDisplay("Elements in sql page#xpath=//td[contains(@class,'FormFieldLabelContainer')]/span", pinPageElements))
		{
			testStepPassed("Elements validated in sql page");
			vstsTestStepPassed("Elements validated in sql page", false);
		}
		else
		{
			testStepFailed("Unable to validate in sql page");
			vstsTestStepFailed("Unable to validate in sql page", true);
		}

		if(elementPresent("Default folder#xpath=//a[@id='SecretFolderPicker_FolderLink']"))
		{
			testStepPassed("Validated the presence of folder link");
			vstsTestStepPassed("Validated the presence of folder link", false);
		}
		else
		{
			testStepFailed("Unable to validate the presence of folder link");
			vstsTestStepFailed("Unable to validate the presence of folder link", true);
		}

		clickOn("Clear button#xpath=//td//a[text()='Clear']");

		if(elementPresent(OR.btn_newFolder))
		{
			testStepPassed("Folder path cleared");
			vstsTestStepPassed("Folder path cleared", false);
		}
		else
		{
			testStepFailed("Unable to clear folder");
			vstsTestStepFailed("Unable to clear folder", true);
		}

		typeIn("Secret Name#id=SecretNameTextBox", SecretName);
		typeIn("PIN code#xpath=//input[contains(@id,'SecretItemDisplay') and @class='SecretViewTextbox']", PIN);
		typeIn("Entering Note textbox#xpath=//textarea[@class='SecretViewTextbox']", Notes);


		boolean secName = ValidateEnterValusInTextField("Secret Name#id=SecretNameTextBox", SecretName, SecretName);
		boolean pin = ValidateEnterValusInTextField("Entering pin#xpath=//input[contains(@id,'SecretItemDisplay') and @class='SecretViewTextbox']", PIN, PIN);
		boolean note = ValidateEnterValusInTextField("Entering Note textbox#xpath=//textarea[@class='SecretViewTextbox']", Notes, Notes);


		if(secName&&note&&pin)
		{
			testStepPassed("Values sucessfuly entered in textbox");
			vstsTestStepPassed("Values sucessfuly entered in textbox", false);
		}
		else
		{
			testStepFailed("Unable to enter values");
			vstsTestStepFailed("Unable to enter values", true);
		}

		clickOn("folder link#xpath=//a[@id='SecretFolderPicker_FolderLink']");

		if(elementPresent("Select a folder#xpath=//div[@id='popupTitle' and text()='Select a Folder']"))
		{
			testStepPassed("Select a folder pop up is present");
			vstsTestStepPassed("Select a folder pop up is present", false);
		}
		else
		{
			testStepFailed("Select a folder pop up is not present");
			vstsTestStepFailed("Select a folder pop up is not present", true);
		}

		switchToFrame("iframe#xpath=//iframe[@id='popupFrame']");

		typeIn("Folder Search#xpath=//div[@id='FolderSearchControl']/input[@name='SearchTextBox']", folderName);



		boolean input = ValidateEnterValusInTextField("folder Searchbox#xpath=//input[@id='SearchTextBox']", folderName, folderName);

		if(input)
		{
			testStepPassed("Value Entered in folder Search");
			vstsTestStepPassed("Value Entered in folder Search", false);
		}
		else
		{
			testStepFailed("Unable to enter values in folder");
			vstsTestStepFailed("Unable to enter values in folder", false);
		}

		if(elementPresent("Link of folder#xpath=//li[@class='ui-menu-item']/div[@class='ui-menu-item-wrapper']"))
		{
			testStepPassed("The link is present after entering folder name");
			vstsTestStepPassed("The link is present after entering folder name", false);
		}
		else
		{
			testStepFailed("The link is not present after entering folder name");
			vstsTestStepFailed("The link is not present after entering folder name", true);
		}

		clickOn("Link of folder#xpath=//li[@class='ui-menu-item']/div[@class='ui-menu-item-wrapper']");

		if(elementPresent("Inherit secret#xpath=//span[text()='Inherit Secret Policy']"))
		{
			testStepPassed("Element Inherit secret policy is present");
			vstsTestStepPassed("Element Inherit secret policy is present", false);
		}
		else
		{
			testStepFailed("Element Inherit secret policy is not present");
			vstsTestStepFailed("Element Inherit secret policy is not present", true);
		}

		clickOn(OR.btn_SaveAndShare);


		if(elementPresent("Inherit secret folders#xpath=//input[@id='EnableInheritPermissionsCheckbox' and @checked='checked']"))
		{
			testStepPassed("Checkbox checked");
			vstsTestStepPassed("Checkbox checked", false);
		}
		else
		{
			testStepFailed("Unable to check checkbox");
			vstsTestStepFailed("Unable to check checkbox", true);
		}

		unSelectCheckBox("Inherit secret folders#xpath=//input[@id='EnableInheritPermissionsCheckbox' and @checked='checked']");

		int addUsergrp = validateElementisDisplay("Add user group dropdown#xpath=//div[@id='GroupUserSelectionControl_AddNewGroupPanel']//span", "Add Group/User");
		boolean admindrp = elementPresent("Admin drp down#xpath=//select[contains(@data-bind,'options')]");

		if(addUsergrp==1 && admindrp)
		{
			testStepPassed("Elementspresent");
			vstsTestStepPassed("Elementspresent", false);
		}
		else
		{
			testStepFailed("Element not present");
			vstsTestStepFailed("Element not present", true);
		}

		if(validateAllElementisDisplay("admin drp elements#xpath=//select[contains(@data-bind,'options')]/option", Admindrp))
		{
			testStepPassed("drop down elements present");
			vstsTestStepPassed("drop down elements present", false);
		}
		else
		{
			testStepFailed("drop down elements not present");
			vstsTestStepFailed("drop down elements not present", true);
		}

		if(validateAllElementisDisplay("admin drp elements#xpath=//select[@class='UserGroupDropdown']/option", usersdrp))
		{
			testStepPassed("drop down elements present");
			vstsTestStepPassed("drop down elements present", false);
		}
		else
		{
			testStepFailed("drop down elements not present");
			vstsTestStepFailed("drop down elements not present", true);
		}

		selectFromDropdown("users drop down#xpath=//select[@class='UserGroupDropdown']", "Everyone");


		if(elementPresent("Everyone option#xpath=//a[@class='GroupIconImage' and contains(text(),'Everyone')]"))
		{
			testStepPassed("Everyone option is present");
			vstsTestStepPassed("Everyone option is present", false);
		}
		else
		{
			testStepFailed("Everyone option is not present");
			vstsTestStepFailed("Everyone option is not present", true);
		}


		if(elementPresent("Everyone option#xpath=//a[@class='GroupIconImage']/../following-sibling::td/select/option[text()='View']"))
		{
			testStepPassed("able to do operation");
			vstsTestStepPassed("able to do operation", false);
		}
		else
		{
			testStepFailed("Unable to do operation");
			vstsTestStepFailed("Unable to do operation", true);
		}

		if(elementPresent("Everyone option#xpath=//a[@class='GroupIconImage']/../following-sibling::td/select/option[text()='Owner']"))
		{
			testStepPassed("able to do operation");
			vstsTestStepPassed("able to do operation", false);
		}
		else
		{
			testStepFailed("Unable to do operation");
			vstsTestStepFailed("Unable to do operation", true);
		}

		clickOn("Remove everyone#xpath=//tr[@class='DataGridAlternatingItem']//td/button");

		if(!elementPresent("Everyone option#xpath=//a[@class='GroupIconImage' and contains(text(),'Everyone')]"))
		{
			testStepPassed("Everyone option is not present");
			vstsTestStepPassed("Everyone option is not present", false);
		}
		else
		{
			testStepFailed("Everyone option is present");
			vstsTestStepFailed("Everyone option is present", true);
		}

		clickOn(OR.btn_Configuration_Page_Save_button);

		if(validateElementisDisplay("secret saved#xpath=//td", SecretName)==1)
		{
			testStepPassed("secret saved");
			vstsTestStepPassed("secret saved", false);
		}
		else
		{
			testStepFailed("secret not saved");
			vstsTestStepFailed("secret not saved", true);
		}

		clickOn(OR.btn_home_icon);
		clickOn(OR.btn_advancedTab_dashboard);

	}
	
	public void ValidatingPinSecretDetails(String SecretName,String SecretItem,String PinsSecretElements,String Admindrp,String usersdrp,String Usersname)
	{
		clickOn("Secret#xpath=//tr//td[text()='"+SecretName+"']");

		if(validateAllElementisDisplay("Secret details of pin secret#xpath=//a", PinsSecretElements))
		{
			testStepPassed("Pin Secret deatails Validated");
			vstsTestStepPassed("Pin Secret deatails Validated", false);
		}
		else
		{
			testStepFailed("Unable to validate pin details ");
			vstsTestStepFailed("Unable to validate pin details", true);
		}

		clickOn(OR.btn_shareButtonInSecretDetails);

		boolean shareViewHeader = elementPresent("Share view page Header#xpath=//span[@id='SecretShareViewLabel']");
		boolean sharedwith = elementPresent("Shared with#xpath=//span[@id='ViewPermissionsTableContainer']//table[@class='DataGrid']//span[text()='Admin']/../following-sibling::td/span");


		if(shareViewHeader && sharedwith)
		{
			testStepPassed("Shared Page sucessfully validated");
			vstsTestStepPassed("Shared Page sucessfully validated", false);
		}
		else
		{
			testStepFailed("Unable to validate Shared page");
			vstsTestStepFailed("Unable to validate Shared page", true);
		}
		clickOn("Edit button#xpath=//button[@name='EditButton']");

		if(elementPresent("Inherit folder permission#xpath=//input[@id='EnableInheritPermissionsCheckbox']"))
		{
			testStepPassed("Checkbox present");
			vstsTestStepPassed("Checkbox present", false);
		}
		else
		{
			testStepFailed("Check box is not present");
			vstsTestStepFailed("Check box is not present", true);
		}

		unSelectCheckBox("Inherit folder permission#xpath=//input[@id='EnableInheritPermissionsCheckbox']");

		int addUsergrp = validateElementisDisplay("Add user group dropdown#xpath=//div[@id='GroupUserSelectionControl_AddNewGroupPanel']//span", "Add Group/User");
		boolean admindrp = elementPresent("Admin drp down#xpath=//select[contains(@data-bind,'options')]");

		if(addUsergrp==1 && admindrp)
		{
			testStepPassed("Elementspresent");
			vstsTestStepPassed("Elementspresent", false);
		}
		else
		{
			testStepFailed("Element not present");
			vstsTestStepFailed("Element not present", true);
		}

		if(validateAllElementisDisplay("admin drp elements#xpath=//select[contains(@data-bind,'options')]/option", Admindrp))
		{
			testStepPassed("drop down elements present");
			vstsTestStepPassed("drop down elements present", false);
		}
		else
		{
			testStepFailed("drop down elements not present");
			vstsTestStepFailed("drop down elements not present", true);
		}

		if(validateAllElementisDisplay("admin drp elements#xpath=//select[@class='UserGroupDropdown']/option", usersdrp))
		{
			testStepPassed("drop down elements present");
			vstsTestStepPassed("drop down elements present", false);
		}
		else
		{
			testStepFailed("drop down elements not present");
			vstsTestStepFailed("drop down elements not present", true);
		}

		selectFromDropdown("users drop down#xpath=//select[@class='UserGroupDropdown']", Usersname);


		if(elementPresent("Everyone option#xpath=//span[@id='EditPermissionsTableContainer']//table//span[contains(text(),'"+Usersname+"')]"))
		{
			testStepPassed("Everyone option is present");
			vstsTestStepPassed("Everyone option is present", false);
		}
		else
		{
			testStepFailed("Everyone option is not present");
			vstsTestStepFailed("Everyone option is not present", true);
		}

		

		if(validateAllElementisDisplay("Everyone option#xpath=//span[@id='PermissionsTable']/table//td/span[text()='Admin']/../following-sibling::td/select/option", Admindrp))
		{
			testStepPassed("able to do operation");
			vstsTestStepPassed("able to do operation", false);
		}
		else
		{
			testStepFailed("Unable to do operation");
			vstsTestStepFailed("Unable to do operation", true);
		}
		
		clickOn(OR.btn_Configuration_Page_Save_button);
		
		if(validateDashboardwithVSTS())
		{
			testStepPassed("Navigated to Dashboard page");
			vstsTestStepPassed("Navigated to Dashboard page", false);
		}
		else
		{
			testStepFailed("Unable to navigate to dashboard page");
			vstsTestStepFailed("Unable to navigate to dashboard page", true);
		}
	}
	
	
	
	
	
	
	
	public void SelectConvertonwithoptions(String ConvertionDatasfields, String Expectedmessage, String SecretValuesAfterConvertion) {
		String[] fields = ConvertionDatasfields.split("##");
		boolean status = false;
		for (String element: fields) {
			String[] Con_Fields = element.split(":");  
			String selectoptionxpath = "select field in "+Con_Fields[0]+"#xpath=//span[text()='"+Con_Fields[0]+"']/parent::td/following-sibling::td/select";

			clickOn(selectoptionxpath);
			waitTime(2);
			clickOn(Con_Fields[1]+" select#xpath=//span[text()='"+Con_Fields[0]+"']/parent::td/following-sibling::td/select/option[text()='"+Con_Fields[1]+"']");
	
			status = true;
		}
		
		if(status) {
			testStepPassed("All element are reflected");
			vstsTestStepPassed("All element are reflected", true);
		}
		else {
			testStepFailed("Some element is not reflected");
			vstsTestStepFailed("Some element is not reflected", true);
		}
		
		clickOn("convert button#id=ConvertButton");
		
		if (!Expectedmessage.isEmpty()) {
			String Errormessage = getText("Error message for convertion#id=ValidationSummary");
			if (Expectedmessage.equals(Errormessage)) {
				testStepPassed("Error message is getting");
				vstsTestStepPassed("Error message is dispalyed", true);
			}
			else {
				testStepFailed("Error message is not displayed");
				vstsTestStepFailed ("Error message is not dispalyed", true);
			}
		}
		else {
			validatefieldsafterconvertion(SecretValuesAfterConvertion);
		}
	}
	
	
	
	
	
	
	
	public void ValidateCreateCustomSecretTemplate(String newSecretTemp, String Field)
	{
		DradDrop("Welcome",OR.drag_src_Welcome, OR.drop_Destination);
		clickOn("Create custom secret temp#xpath=//a[text()='Create custom Secret Templates']");
		
		boolean info = elementPresent("User guide#xpath=//a[text()='More Information in User Guide']");
		boolean create= elementPresent("Create btn#xpath=//a[text()='Create']");
		boolean cancel = elementPresent("cancel btn#xpath=//a[@class='Button' and text()='Dismiss']");
		
		if(info&&create&&cancel)
		{
			testStepPassed("Welcome Elements found");
			vstsTestStepPassed("Welcome Elements found", false);
		}
		else
		{
			testStepFailed("Welcome Elements not found");
			vstsTestStepFailed("Welcome Elements not found", true);
		}
		
		clickOn("Create btn#xpath=//a[text()='Create']");
		
		switchtoTab(1);
		
		String header = getText(OR.Header_anypage);
		
		if(header.contains("Create"))
		{
			testStepPassed("Navigated to create new secret template page");
			vstsTestStepPassed("Navigated to create new secret template page", false);
		}
		else
		{
			testStepFailed("Not Navigated to create new secret template page");
			vstsTestStepFailed("Not Navigated to create new secret template page", true);
			
		}
		
		typeIn("Secret Name#xpath=//input[@id='SecretTypeTextBox']", newSecretTemp);
		
		if(ValidateEnterValusInTextField("Secret Name#xpath=//input[@id='SecretTypeTextBox']", newSecretTemp, newSecretTemp))
		{
			testStepPassed("Secret name is Entered");
			vstsTestStepPassed("Secret name is Entered", false);
		}
		else
		{
			testStepFailed("Secret name is not Entered");
			vstsTestStepFailed("Secret name is not Entered", true);
		}
		
		clickOn("Create btn#xpath=//button[text()='Create']");
		
		if(elementPresent(OR.Header_anypage))
		{
			testStepPassed("Navigated to create new secret template Designer");
			vstsTestStepPassed("Navigated to create new secret template Designer", false);
		}
		else
		{
			testStepFailed("Not Navigated to create new secret template Designer");
			vstsTestStepFailed("Not Navigated to create new secret template Designer", true);	
		}
		
		typeIn("Fields textbox#xpath=//input[@name='SecretBinderDataGrid$ctl02$SecretFieldDisplayFooterTextBox']", Field);
		
		if(ValidateEnterValusInTextField("Fields textbox#xpath=//input[@name='SecretBinderDataGrid$ctl02$SecretFieldDisplayFooterTextBox']", Field, Field))
		{
			testStepPassed("Field name is Entered");
			vstsTestStepPassed("Field name is Entered", false);
		}
		else
		{
			testStepFailed("Field name is not Entered");
			vstsTestStepFailed("Field name is not Entered", true);
		}
		
		clickOn("+ (save button)#xpath=//button[contains(@name,'SecretBinderDataGrid')]");
		
		
		
		if(elementPresent("Fileld in table#xpath=//span[text()='"+Field+"']"))
		{
			testStepPassed(""+Field+" is present in table");
			vstsTestStepPassed(""+Field+" is present in table", false);
		}
		else
		{
			testStepFailed(""+Field+" is not present in table");
			vstsTestStepFailed(""+Field+" is not present in table", true);	
		}
		
		clickOn("Copy secret button#xpath=//span[text()='Copy Secret Template']");
		
		
		
		if(elementPresent("Dialogue box#xpath=//span[text()='Name new Secret Template']"))
		{
			testStepPassed("Dialogue box is present");
			vstsTestStepPassed("Dialogue box is present", false);
		}
		else
		{
			testStepFailed("Dialogue box is not present");
			vstsTestStepFailed("Dialogue box is not present", true);	
		}
		
		typeIn("New secret temp#xpath=//input[@id='newSecretTypeName']", newSecretTemp+"1");
		
		if(ValidateEnterValusInTextField("New secret temp#xpath=//input[@id='newSecretTypeName']", newSecretTemp+"1", newSecretTemp+"1"))
		{
			testStepPassed("new Field name is Entered");
			vstsTestStepPassed("new Field name is Entered", false);
		}
		else
		{
			testStepFailed("new Field name is not Entered");
			vstsTestStepFailed("new Field name is not Entered", true);
		}
		
		clickOn("Ok btn#xpath=//button[text()='OK']");
		
		if(elementPresent("Completed message#xpath=//h2[text()='The Secret Template was successfully copied.']"))
		{
			testStepPassed("Completed message is present");
			vstsTestStepPassed("Completed message is present", false);
		}
		else
		{
			testStepFailed("Completed message is not present");
			vstsTestStepFailed("Completed message is not present", true);	
		}
		clickOn(OR.btn_home_icon);
		
		
		if(elementPresent("Field is present in create new#xpath=//select[@id='CreateSecretWidget_1002']/option[text()='"+newSecretTemp+"1"+"']"))
		{
			testStepPassed(""+newSecretTemp+" is Present in drop down");
			vstsTestStepPassed(""+newSecretTemp+" is Present in drop down", false);
		}
		else
		{
			testStepFailed(""+newSecretTemp+" is not Present in drop down");
			vstsTestStepFailed(""+newSecretTemp+" is not Present in drop down", true);	
		}
	}
	
	
	
	
	
	public void validatefieldsafterconvertion(String SecretValuesAfterConvertion) {
		String[] fields = SecretValuesAfterConvertion.split("##");
		String textfieldxpath= null;
		String textfieldvalue = null;
		boolean ValidateStatus = false;
		
		for (String element: fields) {
			boolean status = false;
			String[] Con_Fields = element.split(":"); 
			if((Con_Fields[0].equalsIgnoreCase("password"))) {
				
				clickOn("unlock a password#xpath=//span[text()='Password']/parent::td/following-sibling::td/a[@class='iconlink fa-fw fa fa-lock']");
				waitTime(1);
				textfieldxpath = "get text for password field#xpath=//span[text()='Password']/parent::td/following-sibling::td//span[@class='PasswordDisplayField']";
			}
			else {
				textfieldxpath = "get text for "+Con_Fields[0]+" field#xpath=//span[text()='"+Con_Fields[0]+"']/parent::td/following-sibling::td//span";
			}
			textfieldvalue = getText(textfieldxpath);
			if (textfieldvalue.equals(Con_Fields[1])) {
				testStepInfo(Con_Fields[1]+" is same");
				status = true;
			}
			else {
				status = false;
				testStepFailed(Con_Fields[0] +" is different");
			}
			
			if (!status && !ValidateStatus) {
				ValidateStatus = true;
			}
		}
		
		if (!ValidateStatus) {
			testStepPassed("All elements are mapped");
			vstsTestStepPassed("All element value are mapped", true);
		}
		else {
			testStepFailed("Some elements are not mapped");
			vstsTestStepFailed("Some elements are not mapped", true);
		}
	}
	
	public boolean validatefieldspresentinconvertion(String convertfields, String Prereq_fields) {
		boolean status = false;

		try {
			String[] Prereq = Prereq_fields.split("##");
			
			for (String Prereq_elem : Prereq) {
				String xpath = "//span[text()='"+Prereq_elem+"']/parent::td/following-sibling::td/select/option";
				if(validateWebElements(xpath, convertfields)) {
					status = true;
				}
				else {
					status = false;
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public void ValidatingWindowsWithDoubleLock(String SecretName,String Buttons,String securityPageDetailFields,String DoubleLockName)
	{
		try {
			
			if(clickonSecret(SecretName, "No", "NO", "Yes", Buttons))
			{
				testStepPassed("Validated the Buttons in secret");
				vstsTestStepPassed("Validated the Buttons in secret", false);
			}
			else
			{
				testStepFailed("Unable to validate buttons");
				vstsTestStepFailed("Unable to validate buttons", true);
			}
			
			clickOn(OR.btn_Secret_view_button);
			
			if(elementPresent(OR.Header_anypage))
			{
				testStepPassed("Navigated to secret page");
				vstsTestStepPassed("Navigated to secret page", false);
			}
			else
			{
				testStepFailed("Unable to Navigate to Secret page");
				vstsTestStepFailed("Unable to Navigate to Secret page", true);
			}
			
			clickOn(OR.btn_Secret_Security_tab);
			
			if(validateAllElementisDisplay("Secret_security page elements#xpath=//td[@class='TDShrinkNoWrap']//span", securityPageDetailFields))
			{
				testStepPassed("Elements displayed in Security Page");
				vstsTestStepPassed("Elements displayed in Security Page", false);
			}
			else
			{
				testStepFailed("Elements not displayed in Security Page");
				vstsTestStepFailed("Elements not displayed in Security Page", true);
			}
			clickOn(OR.btn_Configuration_Page_Edit_button);
			
			if(elementPresent("Edit Fields#xpath=//input[@type='checkbox']"))
			{
				testStepPassed("The Fields are in editable format");
				vstsTestStepPassed("The Fields are in editable format", false);
			}
			else
			{
				testStepFailed("Unable to Edit fields");
				vstsTestStepFailed("Unable to Edit fields", true);
			}
			
			if(elementPresent("Enable doublelock#xpath=//input[@id='EnableDoubleLockCheckBox']"))
			{
				testStepPassed("Doublelock is Editable");
				vstsTestStepPassed("Doublelock is Editable", false);
			}
			else
			{
				testStepFailed("Doublelock is not Editable");
				vstsTestStepFailed("Doublelock is not Editable", true);
			}
			
			
			selectCheckBox("Enable doublelock#xpath=//input[@id='EnableDoubleLockCheckBox']");
			
			if(elementPresent("Enable doublelock#xpath=//input[@id='EnableDoubleLockCheckBox' and @checked='checked']"))
			{
				testStepPassed("Doublelock is enabled");
				vstsTestStepPassed("Doublelock is enabled", false);
			}
			else
			{
				testStepFailed("Doublelock is disabled");
				vstsTestStepFailed("Doublelock is disabled", true);
			}
			
			selectFromDropdown("Double lock dropdown#xpath=//select[@name='DoubleLockDropDownList']", DoubleLockName);
			
			
			if(elementPresent("Double lock dropdown#xpath=//select[@name='DoubleLockDropDownList']/option[@selected='selected' and text()='"+DoubleLockName+"']"))
			{
				testStepPassed("User is able to select doublelock");
				vstsTestStepPassed("User is able to select doublelock", false);
			}
			else
			{
				testStepFailed("User is unable to select doublelock");
				vstsTestStepFailed("User is unable to select doublelock", true);
			}
			clickOn(OR.btn_Configuration_Page_Save_button);
			
			
		}catch(Exception ex)
		{
		  ex.printStackTrace();
		}
	}
	
}
