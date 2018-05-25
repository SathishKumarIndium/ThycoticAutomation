package scenarios;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.LoginPage;
import pages.SecretPage;


public class SecretScenarios extends ApplicationKeywords{

	BaseClass obj;
	LoginPage loginpage  ;
	SecretPage secretpage ;
	
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
			secretpage.validateCreateSecret(SecretTempalte,  SecretName, Machine, TemplateUsername, TemplatePassword,
					Note, FolderPath, FolderName, SecretTemplateFields, DefaultFolder);
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
