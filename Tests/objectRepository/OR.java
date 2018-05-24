package objectRepository;

public class OR 
{
	
	//Login Page
    public static final String txt_ThycoticLoginPage   = "thycotic login page#id=LoginDialog_DialogTable";
    public static final String typin_Username          = "entry value in username#id=LoginUserControl1_UserNameTextBox";
    public static final String typin_Password          = "entry value in password field#id=LoginUserControl1_PasswordTextBox";
    public static final String btn_login_page          = "clicking login button#id=LoginUserControl1_LoginButton";
    
    //Dashboard
    public static final String btn_Profile_Icon        = "Profile Icon in Dashboard#xpath=//a[contains(@href,'Profile/Home')]/i";
    public static final String btn_My_Profile          = "To Validate The profile name#xpath=//a[contains(text(),'My Profile')]";
    public static final String btn_Logout              = "click on logout button#xpath=//a[@href='/SecretServer/Logout.aspx' and text()='Logout']";
    public static final String link_Advancelink              = "Advancelink#xpath=//a[@class='AdvancedLink' and text()='Advanced']";
    public static final String lbl_General = "To find whether the General Label is present#xpath=//legend[text()='General']";
    public static final String drd_Tamplate_Field   = "template field#xpath=//select[@id='templateList']";
    public static final String drd_advanced_status  ="advanced status field#xpath=//select[@id='statusList']";
    public static final String checkbox_Include_Subfolders =  "advanced Include Subfolders#xpath=//span[@id='SubfolderLabel']/parent::td/following-sibling::td/input";
    public static final String btn_Column_Selection_ok= "OK Button in Column Selection window#xpath=//button[text()='OK']";
    public static final String link_Column_select = "click on columnselect#id=ColumnSelectionLink";
    
    public static final String btn_content = "To click the content button#xpath=//span[text()='Content']";
    
    public static final String btn_AdbancedTab = "click on advanced tab#xpath=//span[text()='Advanced']";

    
    //Dashboard elements
    public static final String lbl_Browse = "To retrive the browse label#xpath=//td[contains(@id,'pinTab') and text()='Browse']";
    public static final String btn_home_icon = "home icon in dashboard#xpath=//a[contains(@id,'HomeLink') and text()='Home']";
    public static final String txt_Browser = "Browser element in dashboard#xpath=//td[text()='Browse']";
    public static final String btn_NewTab_Icon = "NewTab Icon in dashboard#id=NewTab";
    public static final String btn_Expend_button= "expend button in dashboard#id=CollapseFolderTree";
    public static final String Search_Field = "Search Text box#id=TextSearch";
    public static final String tab_Secret = "Secret in Dashboard#xpath=//div[contains(@id,'secretTable') and text()='Secret']";
    public static final String drd_Bulk_Operation= "Bulk Operation in Dashboard#id=OperationDropDownList";
    public static final String Delete_Icon = "Delete Icon in DashBoard#xpath=//td[text()='< All Folders >']/following-sibling::td/span[contains(@class,'ui-icon-close')]";
    public static final String  txt_NewTab = "text field for new tab#id=newTabInput";
    public static final String tab_Create_Secret = "tab create secret in left tab#xpath=//h2[text()='Create Secret']";
    
    public static final String drpdown_Selectbulkoperation = "To click the dropdown#xpath=//select[@id='OperationDropDownList']";
    public static final String btn_logo_icon = "Logo Icon in Dashboard#xpath=//div[@class='logoImage']"; 
    
    public static final String btn_Personal_Folders_DashBoard = "Personal Folders button#xpath=//label[text()='Personal Folders']";
    public static final String btn_Admin_Folder_DashBoard = "Admin Folders button#xpath=//label[text()='Admin']";
    public static final String drd_Shared_User_Group = "User/Group dropdown box#id=UserGroupList";
    
    
    //help 
    public static final String bth_help_icon           = "Help icon button#xpath=//a[@href='Help']/i";
    public static final String txt_help_filelds        = "help page fields#xpath=(//div[text()='Help']/parent::div/parent::div/parent::h1/following-sibling::div/ul)//a[2]";
    public static final String btn_home_page_help      = "home page from helppage#id=HomeLink";
    public static final String btn_Getting_Started_tab  = "Getting Started tab for secret#xpath=//a[text()='Getting Started']";
    
    // Licenses
    public static final String btn_Licenses_tab = "click on Licens tab in Getting Started page#id=LicensingWizardTab";
    public static final String btn_Getting_Started_page_header = "Header tab for Getting Started#xpath=//table[@id='WizardDialog_DialogTable']//td[@class='dialog_body']";
    public static final String txtbox_License_Name = "Entering license name#id=NewLicenseName";
    public static final String txtbox_License_Key = "Entering License Key#id=NewLicenseKey";
    public static final String btn_add_license_icon = "clicking add license#xpath=//input[@id='NewLicenseKey']/parent::td/following-sibling::td/a[@title='Add']"; 
    public static final String btn_Admin_Licenses_tab = "clicking on Licenses tab#xpath=//a[text()='Licenses']";
    public static final String Licenses_page_header = "License Page title#xpath=//td[text()='Licenses']";
    
    
    
    
    // profile page
    public static final String txt_Session_page = "title for session page#xpath=//table[@id='SessionsDialog_DialogTable']//td[@class='dialog_top' and contains(text(),'Current')]";
    public static final String tab_Session = "Session Link#xpath=//ul[@class='linkList']/li/a[text()='Sessions']";
    public static final String btn_changePassword = "To click on change the password#xpath=//ul[@class='linkList']/li//a[(text()='Change Password')]";
    
    // Session Page
    
    public static final String btn_Delete_Current_Session_button = "Delete icon in current session#xpath=//tbody[@data-bind='foreach:items']//td/span";
    
    //DoubleLock
    public static final String Link_Create_DoubleLock     = "link for create doublelock password#xpath=//a[text()='Create DoubleLock Password']";
    public static final String txtbox_Doublelock_password = "password field for DoubleLock#xpath=//input[@id='PasswordTextBox']";
    public static final String txtbox_Doublelock_Confirm_Password  = "Doublelock Confirm Password#id=ConfirmPasswordTextBox";
    public static final String btn_CreatePasswordButton = "Save Button for create doublelock password#id=CreatePasswordButton";
    public static final String link_Reset_Doublelock = "link for reset doublelock password#xpath=//a[text()='Reset DoubleLock Password']";
    public static final String txtbox_Reset_Doublelock_password = "Reset password field for DoubleLock#xpath=//input[@id='PasswordTextBox']";
    
    public static final String btn_ResetPasswordButton = "Button for reset Doublelock#id=ResetPasswordButton";
    
    public static final String txt_DoublelockSuccessmsg = "success message for Doublelock password#xpath=//span[@id='ExplanationLabel']";
    public static final String btn_Doublelock_Back  = "Back button for doublelock button#id=BackButton";
    
    //Bulk Operation
    public static final String msg_delete_secret= "message text for delete secret#id=BulkModal";
    public static final String btn_bulk_delete_ok_button= "Ok button for Delete in Secret#xpath=//div[@class='ui-dialog-buttonset']/button[text()='OK']";
    public static final String btn_bulk_close_button = "close button #xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']";
    
    public static final String txt_BulKoption_Error_Msg = "Bulk Operation Error Message#xpath=//div[@id='ValidationSummary']";
    public static final String btn_Secret_view_button= "Clicking on View Button in Secret #xpath=//a[text()='View' and @class='Button']";
    public static final String btn_bulk_operation_ok_button = "Ok button in Bulk Option#xpath=//div[@class='ui-dialog-buttonset']/button[text()='OK']";
    public static final String btn_bulk_operation_close_button = "close button #xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']";
    
    
    
    //public static final String secret_General_tab = "";
    public static final String btn_Secret_Security_tab = "security tab for secret#xpath=//a[@title='Security']";
    public static final String txt_Check_Out_Interval = "check out interval value in secret security page#xpath=//span[text()='Require Check Out']/parent::td/following-sibling::td/span[@id='EnableCheckOutLabel']";
    public static final String btn_Remort_Change_Password_tab = "Remort Password Change tab for secret#xpath=//a[@title='Remote Password Changing']";
    public static final String txt_AutoChange          = "Auto Change field value in #id=AutoChangeLabel";
    public static final String txt_Heartbeat_status= "Last Heartbeat status in secret page#id=HeartbeatStatusLabel";
    
    //
    public static final String chk_Inherit_Secret_Policy = "Inherit Secret Policy in Bulk Option Pages#xpath=//span[text()='Inherit Secret Policy']/parent::td/following-sibling::td//input[@type='checkbox']";
    public static final String drd_Secret_Policy = "Secret Policy in Bulk Option Pages#xpath=//span[text()='Secret Policy']/parent::td/following-sibling::td/select[@id='SecretPolicyDropDownList']";
    public static final String txt_inciden_secret = "Text for incident secret policy in Secret Page#xpath=//span[text()='Inherit Secret Policy']/parent::td/following-sibling::td/span[@id='EnableInheritSecretPolicyLabel']";
    
    
    
    //change password
	
  	public static final String txt_currentPassword = "To enter the old password#xpath=//input[contains(@name,'CurrentPassword')]";
  	public static final String txt_newPassword = "To enter the new password#xpath=//input[contains(@name,'NewPassword')]";
  	public static final String txt_ConfirmPassword = "confirm the entered password#xpath=//input[contains(@name,'Confirm')]";
    
  	// SSh Acount 
  	public static final String chk_Cissco_SSh_Inherit_secret_policy = "Inherit Secret policy checkbox in  Account #xpath=//span[@id='EnableInheritSecretPolicyFieldLabel']/parent::td/following-sibling::td/span/input[@type='checkbox']";
  	public static final String chk_Cissco_SSh_AutoChange  = "Autochange for Cisho Account#xpath=//span[text()='AutoChange?']/parent::td/following-sibling::td/span/input[@type='checkbox']";
    
  	
    // Admin Page
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
  	
  	// Folders
    public static final String btn_Admin_Folders_Icon = "Folders icon in Admin Tab#xpath=//a[text()='Folders']";
    public static final String btn_New_Folder_button  = "New button in folders page#id=CreateNewButton";
    public static final String txt_box_Folder_name = "Entering folder name#id=FolderNameTextBox";
    public static final String drd_folder_icon = "folder icon#id=FolderTypeDropDownList";
    public static final String drd_SecretPolicy_folderpage = "Secret Policy#id=SecretPolicyDropDownList";
  	public static final String drd_folder_permission = "Folder Permission in permission table#xpath=//span[text()='Admin']/parent::td/following-sibling::td/select";
  	public static final String drd_Secret_Permissions = "Secret Permissions in permission table#xpath=//span[text()='Admin']/parent::td/following-sibling::td/table//td/select";
  	public static final String chk_box_Override_permission = "override check box in permission#xpath=//span[text()='Admin']/parent::td/following-sibling::td/table//td/nobr[contains(text(),'Override')]/input[@type='checkbox']";
  	public static final String drd_Add_User_Group = "Add user/grop for permission#id=GroupUserSelectionControl_AssignGroupDropDownList";
   	public static final String Folder_page_header = "folder page header#xpath=//td[@class='dialog_top' and text()='Folders']";
  	public static final String Create_new_folder_page_header= "Create New folder Page header#xpath=//table[@id='EditFolderDialog_DialogTable']//td[@class='dialog_top']";
  	public static final String btn_Create_NewFolder_Save_Button = "Save Button For Create New folder Page#id=FolderSaveButton";
   	
  	//user
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
  	
  	//Configuration
  	public static final String btn_Admin_configuration_Icon = "Configuration in admin tab#xpath=//a[text()='Configuration']";
  	public static final String txt_configuration_page_header = "Configuration page header#xpath=//td[@class='dialog_top' and text()='Configuration']";
  	public static final String btn_Configuration_Page_Edit_button = "configuration page edit button#id='EditButton'";
  	public static final String drd_Default_SecretPermissions = "select Default secret permission option#xpath=//span[text()='Default Secret Permissions']/parent::td/following-sibling::td/select";
  	public static final String btn_Configuration_Page_Save_button = "Configuration page save button#id='SaveButton'";
  	public static final String txt_Default_Secret_Permissions  = "Text for Default Secret Permissions in configuration page#xpath=//span[text()='Default Secret Permissions']/parent::td/following-sibling::td/span";
  	
  	
  	// Heartbeat
    public static final String Enable_Heartbeat = "Bulk opertion for Enable Heartbeat#xpath=//select[@id='OperationDropDownList']//option[text()='Enable Heartbeat']";
  	public static final String Disable_Heartbeat = "Bulk opertion for Disable Heartbeat#xpath=//select[@id='OperationDropDownList']//option[text()='Disable Heartbeat']";
  	public static final String Run_Heartbeat = "Bulk opertion for Run Heartbeat#xpath=//select[@id='OperationDropDownList']//option[text()='Run Heartbeat']"; 
  	
  	//logout
    public static final String Logout_Dialogbox        = "Logout Dialog box#id=NewDialogLogout_DialogTable";
    
    // sathish
	public static final String drag_src_Welcome = "//li/nobr[text()='Welcome']";
	public static final String drop_Destination = "//ul[@id='Ul3']";
	public static final String drag_src_FavoriteSecrets = "//li/nobr[text()='Favorite Secrets']";
    
}
