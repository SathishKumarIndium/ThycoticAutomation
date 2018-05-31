package pages;

import java.io.IOException;

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
	public static final String btn_Unlock_password = "unlock a password#xpath=//span[text()='Password']/parent::td/following-sibling::td/a[@class='iconlink fa-fw fa fa-lock']";
	
	public static final String txt_Security_fields = "Security fields#xpath=//table[@class='formTable']//td[@class='TDShrinkNoWrap']/span";
	
	public static final String btn_GenericDis_fileupdate = "choose file path#xpath=//input[@id='SecretItemDisplay_SecretItemsRepeater_ctl03_FileUploadControl']";
	
	public static final String Publickey_file_update = "public key file update#id=SecretItemDisplay_SecretItemsRepeater_ctl04_FileUploadControl";
	
	
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
		
		ClickSaveAndSecretisCreated(SecretName);
		
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
		
//		clickOn(secret_save_button);
//		if (elementPresent(secret_template_name)) {
//			String SecretnameGUI =  getText(secret_template_name);
//			if (SecretnameGUI.equals(SecretName)) {
//				testStepPassed("Secret Name is same : "+SecretName);
//				vstsTestStepPassed("Secret Name is same : "+SecretName, true);
//			}
//			else {
//				testStepFailed("Secret Name is different : "+SecretName);
//				vstsTestStepFailed("Secret Name is different : "+SecretName, true);
//			}
//		}
		
		ClickSaveAndSecretisCreated(SecretName);
		
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
	
	
	public void ValidateActiveDirectorySecretwithcheckinhert(String SecretItem, String SecretName, String Server, String Username, String Password, 
			String Notes, String folderPath, String folderName, String Secretfields, String DefaultFolder, boolean Basiclink, String Securityfields) {
		
		CreateSecretuptofoldersteps(SecretItem, SecretName, Server, Username, Password, Notes, Secretfields, DefaultFolder, Basiclink);
		
		folderfunctionincreatesecret(folderName, folderPath, true);
		
		if (validateAllElementisDisplay(Secret_template_fields, "Inherit Secret Policy")) {
			testStepPassed("Inherit Secret Policy is displayed after select folder");
			vstsTestStepPassed("Inherit Secret Policy is displayed after select folder", true);
		}
		else {
			testStepFailed("Inherit Secret Policy is not displayed after select folder");
			vstsTestStepFailed("Inherit Secret Policy is not displayed after select folder", true);
		}
		
		selectCheckBox("Inherit Secret Policy#id=EnableInheritSecretPolicyCheckBox"); 
		ValidateCheckboxischecked("//input[@id='EnableInheritSecretPolicyCheckBox']", "Inherit Secret Policy");
		
		ClickSaveAndSecretisCreated(SecretName);
		
		clickOn("Security#xpath=//a[@title='Security']");
		
		if (validateAllElementisDisplay(txt_Security_fields, Securityfields)) {
			testStepPassed("The fields under the Securtiy tab should be displayed");
			vstsTestStepPassed("The fields under the Securtiy tab should be displayed", true);
		}
		else {
			testStepFailed("Some fields under the Securtiy tab should be not displayed");
			vstsTestStepFailed("Some fields under the Securtiy tab should be not displayed", true);
		}
		
		clickOn("Security#id=EditButton");
		
		if (ValidateElementisEditable(Securityfields)) {
			vstsTestStepPassed("All element are Editable", true);
		}
		else {
			vstsTestStepFailed("Some element are not editable", true);
		}
		
		String DisableDoublelock = getAttributeValue("fields for secrity#xpath=//span[text()='Enable DoubleLock']/parent::td/following-sibling::td//input[@type='checkbox']", "disabled");
			
		if (DisableDoublelock != null && DisableDoublelock.equalsIgnoreCase("true")) {
			testStepPassed("Enable DoubleLock is disable");
			vstsTestStepPassed("Enable DoubleLock is disable", true);
		}
		else {
			testStepFailed("Enable DoubleLock is not Disable");
			vstsTestStepFailed("Enable DoubleLock is not Disable", true);
		}
	
	}
	
	public void GenericDiscoveryUpdatingKeyfile(String SecretItem, String SecretName, String Username, String Password, 
			String Notes, String folderPath, String folderName, String Secretfields, String DefaultFolder, boolean Basiclink, String Updatefilepath ) {
		
		String dir = System.getProperty("user.dir");
		
		try {
			CreateSecretuptofoldersteps(SecretItem, SecretName, null, Username, Password, Notes, Secretfields, DefaultFolder, Basiclink);
			
			clickOn(btn_GenericDis_fileupdate);
			
			waitTime(3);
			if (validatetitleWithAutoit(dir+"\\AutoIt\\ReturnTitle.exe "+"Open", "File &name:")) {
				testStepPassed("File upload box should be displayed");
				vstsTestStepPassed("File upload box should be displayed", true);
			}
			else {
				testStepFailed("File upload box should not displayed");
				vstsTestStepFailed("File upload box should not displayed", true);
			}
			
			String updatefilepath = dir+"\\AutoIt\\"+Updatefilepath;
			
			if (validatetitleWithAutoit(dir+"\\AutoIt\\Updateakeyfile.exe "+updatefilepath, updatefilepath)) {
				testStepPassed("File upload path is same");
				vstsTestStepPassed("File upload path is same", true);
			}
			else {
				testStepFailed("File upload path is Different");
				vstsTestStepFailed("File upload path is Different", true);
			}
			
			Runtime.getRuntime().exec(dir+"\\AutoIt\\ClickingokButton.exe");
			
			
			waitTime(5);
			
			
			String filepath = getAttributeValue(btn_GenericDis_fileupdate, "value");
			
			if (filepath.contains(Updatefilepath)) {
				testStepPassed("File updated successfully");
				vstsTestStepPassed("File updated successfully", true);
			}
			else {
				testStepFailed("File is not updated successfully");
				vstsTestStepFailed("File is not updated successfully", true);
			}
			
			folderfunctionincreatesecret(folderName, folderPath, true);
			
			if (validateAllElementisDisplay(Secret_template_fields, "Inherit Secret Policy") &&
					validateAllElementisDisplay(Secret_template_fields, "Secret Policy") ) {
				testStepPassed("Inherit Secret Policy and Secret Policy is displayed after select folder");
				vstsTestStepPassed("Inherit Secret Policy and Secret Policy is displayed after select folder", true);
			}
			else {
				testStepFailed("Inherit Secret Policy or Secret Policy is not displayed after select folder");
				vstsTestStepFailed("Inherit Secret Policy or Secret Policy is not displayed after select folder", true);
			}
			
			String loclstatus = getAttributeValue("default local value#xpath=//select[@id='SiteDropDownList']/option[text()='Local']", "Selected");
			if(loclstatus != null && loclstatus.equalsIgnoreCase("true")) {
				testStepPassed("Local should be selected as default in Site field");
				vstsTestStepPassed("Local should be selected as default in Site field", true);
			}
			else {
				testStepFailed("Local should be selected as not a default in Site field");
				vstsTestStepFailed("Local should be selected as not a default in Site field", true);
			}
			
			ClickSaveAndSecretisCreated(SecretName);
			
			validateSecretispresent(SecretName, folderName, true);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ValidateCreateUnixAccount(String SecretItem, String SecretName, String Machine, String Username, String Password, 
			String Notes, String folderPath, String folderName, String Secretfields, String DefaultFolder, boolean Basiclink, String Updatefilepath ) {
		String dir = System.getProperty("user.dir");
		
		try {
			CreateSecretuptofoldersteps(SecretItem, SecretName, Machine, Username, Password, Notes, Secretfields, DefaultFolder, Basiclink);
						
			clickOn(Publickey_file_update);

			waitTime(3);
			if (validatetitleWithAutoit(dir+"\\AutoIt\\ReturnTitle.exe "+"Open", "File &name:")) {
				testStepPassed("File upload box should be displayed");
				vstsTestStepPassed("File upload box should be displayed", true);
			}
			else {
				testStepFailed("File upload box should not displayed");
				vstsTestStepFailed("File upload box should not displayed", true);
			}
			
			String updatefilepath = dir+"\\AutoIt\\"+Updatefilepath;
			
			if (validatetitleWithAutoit(dir+"\\AutoIt\\Updateakeyfile.exe "+updatefilepath, updatefilepath)) {
				testStepPassed("File upload path is same");
			}
			else {
				testStepFailed("File upload path is Different");
			}
			
			Runtime.getRuntime().exec(dir+"\\AutoIt\\ClickingokButton.exe");
			
			
			waitTime(5);
			
			String filepath = getAttributeValue(Publickey_file_update, "value");
			
			if (filepath.contains(Updatefilepath)) {
				testStepPassed("File updated successfully");
				vstsTestStepPassed("File updated successfully", true);
			}
			else {
				testStepFailed("File is not updated successfully");
				vstsTestStepFailed("File is not updated successfully", true);
			}
			
			folderfunctionincreatesecret(folderName, folderPath, true);
			
			ClickSaveAndSecretisCreated(SecretName);
			
			clickOn("back button from secret#id=BackToSearchResultsButton");
			
			String confirmDashboard = getText(OR.lbl_Browse);
			if(confirmDashboard.equalsIgnoreCase("Browse")) {
				testStepPassed("Dashboard page is displayed");
				vstsTestStepPassed("Dashboard page is displayed", true);
			}
			else {
				testStepFailed("Dashboard page is not displayed");
				vstsTestStepFailed("Dashboard page is not displayed", true);
			}
			
			validateSecretispresent(SecretName, folderName, true);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/*public void validateSendEmailWhenChangedSecret(String SecretName) {
		switchTofolders(foldername);
		
		clickOn("Expaending Secret is present#xpath=//td[text()='"+SecretName+"']");
		
		if(elementPresent("xpath=")) {
			
		}
		else {
			
		}
		
		
	}*/
	
	public boolean ValidateElementisEditable(String fields) {
		boolean Mainstatus = true;
		
		String[] SecurityFields = fields.split("##");
		
		for(String elem: SecurityFields) {
			boolean Status = false;
			if(elementPresent("fields for secrity#xpath=//span[text()='"+elem+"']/parent::td/following-sibling::td//input[@type='checkbox']")) {
				testStepInfo(elem+" is eaditable");
				Status = true;
			}
			else {
				testStepFailed(elem+" is not eaditable");
			}
			if (Mainstatus && !Status) {
				Mainstatus = false;
			}
		}
		return Mainstatus;
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
	
	
	
	
	public void validatefieldsafterconvertion(String SecretValuesAfterConvertion) {
		String[] fields = SecretValuesAfterConvertion.split("##");
		String textfieldxpath= null;
		String textfieldvalue = null;
		boolean ValidateStatus = false;
		
		for (String element: fields) {
			boolean status = false;
			String[] Con_Fields = element.split(":"); 
			if((Con_Fields[0].equalsIgnoreCase("password"))) {
				
				clickOn(btn_Unlock_password);
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
	
	public void ClickSaveAndSecretisCreated(String SecretName) {
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
	}
	
	public void ValidateCheckboxischecked(String xpath, String element) {

		try {

			System.out.println("SSS"+xpath);

			if (driver.findElementByXPath(xpath).isEnabled()) {
				testStepPassed(element+" is checked");
				vstsTestStepPassed(element+" is checked", false);
			}
			else {
				testStepFailed(element+ " is not checked");
				vstsTestStepFailed(element+ " is not checked", true);
			}
		}
		catch(Exception e) {
			vstsTestStepFailed(element+ " is not checked", true);
			e.printStackTrace();
		}
	}
	
}
