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
	
	public void VerifyLockGenerateButtonWithPasseord() {
		
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
			
			System.out.println("te  st");
			
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
