package scenarios;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.BasicPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SecretPage;


public class SecretScenarios extends ApplicationKeywords{

	BaseClass obj;
	LoginPage loginpage  ;
	SecretPage secretpage ;
	DashboardPage dashboardpage ;
	
	private Boolean status = false;

	
	public SecretScenarios(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj=obj;
	}
	public SecretScenarios() {

		// TODO Auto-generated constructor stub
	}
	
	public void VerifyGenerateButtonWithPasseord() {
		
		try {
			loginpage = new LoginPage(obj);
			secretpage = new SecretPage(obj);
			
			String url = retrieve("Secret server URL");
			String Username = retrieve("User Name");
			String Password = retrieve("Password");
			String SecretTempalte =  retrieve("Secret Template Type");
			String SecretName =  retrieve("Secret Name");
			String Domain =  retrieve("Domain");
			String TemplateUsername =  retrieve("Directory UserName");
			String Note =   retrieve("Note") ;
			String SecretTemplateFields=   retrieve("Secret Fields");
			
			
			loginpage.LaunchUrl(url, "No");
			loginpage.Login(Username, Password, "Yes");
			secretpage.validateGenerateButtonWithPasseords(SecretTempalte,  SecretName, Domain, TemplateUsername, Note, SecretTemplateFields);
						
			loginpage.Logout();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || secretpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
		
	}
	
	public void VerifyLockIconWithGeneratePassword() {
		try {
			loginpage = new LoginPage(obj);
			secretpage = new SecretPage(obj);
			
			String url = retrieve("Secret server URL");
			String Username = retrieve("User Name");
			String Password = retrieve("Password");
			String SecretTempalte =  retrieve("Secret Template Type");
			String SecretName =  retrieve("Secret Name");
			String Domain =  retrieve("Domain");
			String TemplateUsername =  retrieve("Directory UserName");
			String Note =   retrieve("Note") ;
			String SecretTemplateFields=   retrieve("Secret Fields");
			
			
			loginpage.LaunchUrl(url, "No");
			loginpage.Login(Username, Password, "Yes");
			secretpage.validateLockIconWithPassword(SecretTempalte,  SecretName, Domain, TemplateUsername, Note, SecretTemplateFields);
						
			loginpage.Logout();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || secretpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void CreateSecretWindowsAccount() {
		try {
			loginpage = new LoginPage(obj);
			secretpage = new SecretPage(obj);
			
			String url = retrieve("Secret server URL");
			String Username = retrieve("User Name");
			String Password = retrieve("Password");
			String SecretTempalte =  retrieve("Secret Template Type");
			String SecretName =  retrieve("Secret Name");
			String Machine =  retrieve("Machine");
			String TemplateUsername =  retrieve("Machine UserName");
			String TemplatePassword = retrieve("Machine Password");
			String Note = retrieve("Note") ;
			String SecretTemplateFields = retrieve("Secret Fields");
			String FolderPath = retrieve("Folder Path");
			String FolderName = retrieve("Folder Name");
			String DefaultFolder = retrieve("Default Folder");
			
			
			loginpage.LaunchUrl(url, "No");
			loginpage.Login(Username, Password, "Yes");
			secretpage.ValidateCreateWindowsAccount(SecretTempalte,  SecretName, Machine, TemplateUsername, TemplatePassword,
					Note, FolderPath, FolderName, SecretTemplateFields, DefaultFolder, false);
			deleteSecretfromdashboard(SecretName);
						
			loginpage.Logout();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || secretpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void CreateSecretPinAccountInBasiclink() {
		try {
			loginpage = new LoginPage(obj);
			secretpage = new SecretPage(obj);
			
			String url = retrieve("Secret server URL");
			String Username = retrieve("User Name");
			String Password = retrieve("Password");
			String SecretTempalte =  retrieve("Secret Template Type");
			String SecretName =  retrieve("Secret Name");
			String Machine =  retrieve("Pin Code");
			String Note = retrieve("Note") ;
			String SecretTemplateFields = retrieve("Secret Fields");
			String FolderPath = retrieve("Folder Path");
			String FolderName = retrieve("Folder Name");
			String DefaultFolder = retrieve("Default Folder");
			
			
			loginpage.LaunchUrl(url, "No");
			loginpage.Login(Username, Password, "Yes");
			secretpage.ValidatecreatePinaccountInBasiclink(SecretTempalte,  SecretName, Machine,
					Note, FolderPath, FolderName, SecretTemplateFields, DefaultFolder, true);
			deleteSecretfromdashboard(SecretName);
						
			loginpage.Logout();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || secretpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	
	public void ValidateConvertionSecretFromActiveDirectoryToWindow() {
		try {
			String Secrettemplate = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String Machine = retrieve("Machine");
			String MachineUserName = retrieve("Machine UserName");
			String MachinePassword = retrieve("Machine Password");
			String Note = retrieve("Note");
			String FolderPath = retrieve("Folder Path");
			String FolderName = retrieve("Folder Name");
			String InhertPolicy =  retrieve("Inherit Secret Policy");
			String SecretPolicy = retrieve("Secret Policy");
        	String AutoChange = retrieve("AutoChange");
        	
        	String Convertion_Secret = retrieve("Convertion Secret Template");
        	String PreSecretFields  = retrieve("Pre Secret Fields");
        	String PresentSecretFields = retrieve("Present Secret Fields");
        	String InvalidSecretFields = retrieve("Invalid Select option");
        	String ValidSecretFields = retrieve("valid Select option");
        	String DataValues = retrieve("Convert Data Value");
        	String ExpectedMessage = retrieve("ExpectedMessage");
			
			loginpage = new LoginPage(obj);
			secretpage = new SecretPage(obj);
			dashboardpage = new DashboardPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			CreateSqlSecretTemplate(Secrettemplate, SecretName, Machine, MachineUserName, MachinePassword,  
					Note, FolderPath, FolderName, InhertPolicy, SecretPolicy, AutoChange);
			dashboardpage.validateSecretispresent(SecretName,FolderName, true);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
			secretpage.ValidateConvertActiveDirectorytoWindows(Convertion_Secret, Secrettemplate, SecretName, PreSecretFields,
					PresentSecretFields, InvalidSecretFields, ValidSecretFields, DataValues, ExpectedMessage);

			deleteSecretfromdashboard(SecretName);
						
			loginpage.Logout();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || secretpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
		
}
