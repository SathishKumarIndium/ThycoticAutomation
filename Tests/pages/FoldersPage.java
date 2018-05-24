package pages;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;


public class FoldersPage  extends ApplicationKeywords  {
	
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

	
	
	public FoldersPage(BaseClass obj) {
		super(obj);
	}
	
	
	public boolean createNewFolder(String foldername, String FolderIcon, String SecretPolicy, 
			String PermissionsName, String FolderPermissionsValue, String SecretPermissionsValue, String Overridevalue, 
			String AddGroupUser, String NewUsername,  String UserFolderPermissionstype, String UserSecretPermissions, String UserOverview) {
		
		boolean Status = false;
		
		mouseOver(OR.btn_Admin_Tab);
		clickOn(btn_Admin_Folders_Icon);
		
		if (elementPresent(Folder_page_header)) {
			testStepPassed("Folder page is displayed");
			deleteFolder(foldername);
			clickOn(btn_New_Folder_button);
			if (elementPresent(Create_new_folder_page_header)) {
				testStepPassed("Create New Folder Page is dispalyed");
				typeIn(txt_box_Folder_name, foldername);
				selectFromDropdown(drd_folder_icon, FolderIcon);
				selectFromDropdown(drd_SecretPolicy_folderpage, SecretPolicy);
				SetPermissionForFolders(PermissionsName, FolderPermissionsValue, SecretPermissionsValue, Overridevalue);
				selectFromDropdown(drd_Add_User_Group, AddGroupUser);
				SetPermissionForFolders(NewUsername, UserFolderPermissionstype, UserSecretPermissions, UserOverview);
				clickOn(btn_Create_NewFolder_Save_Button);
				if (elementPresent("Folder name #xpath=//a[text()='"+foldername+"']")) {
					testStepPassed("Folder is created successfully");
					Status = true;
				}
				else {
					testStepFailed("Folder is not created");
					Status = false;
				}
			}
			else {
				testStepFailed("Create New Folder page is not displayed");
			}
		}
		else {
			testStepFailed("Folder page is not dispalyed");
		}
		clickOn(OR.btn_home_icon);
		return Status;
	}

	public void deleteFolder(String Foldername) {
		try {
			mouseOver(OR.btn_Admin_Tab);
			clickOn(btn_Admin_Folders_Icon);
			if (elementPresent("Folder name #xpath=//a[text()='"+Foldername+"']")) {
				clickOn("Folder name #xpath=//a[text()='"+Foldername+"']");
				clickOn("delete button for folders#xpath=//button[text()='Delete']");
				alertOk();
				if (!elementPresent("Folder name #xpath=//a[text()='"+Foldername+"']")) {
					testStepPassed("Folder is deleted successfully");
				}
				else {
					testStepFailed("Folder is not delete Successfully");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SetPermissionForFolders(String PermissionsName, String FolderPermissionsValue, String SecretPermissionsValue, String Override) {
		
		selectFromDropdown("Folder Permission in permission table#xpath=//span[text()='"+PermissionsName+"']/parent::td/following-sibling::td/select", FolderPermissionsValue);
		
		
		if (Override.equals("Enable")) {
		    selectCheckBox("override check box in permission#xpath=//span[text()='"+PermissionsName+"']/parent::td/following-sibling::td/table//td/nobr[contains(text(),'Override')]/input[@type='checkbox']");
		    selectFromDropdown("Secret Permissions in permission table#xpath=//span[text()='"+PermissionsName+"']/parent::td/following-sibling::td/table//td/select", SecretPermissionsValue);
		}
		
	}
}
