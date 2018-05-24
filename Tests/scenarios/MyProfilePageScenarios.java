package scenarios;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.AdminPage;
import pages.BasicPage;
import pages.ConfigurationPage;
import pages.DashboardPage;
import pages.FoldersPage;
import pages.HelpPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.UsersPage;

public class MyProfilePageScenarios extends ApplicationKeywords {
	
	BaseClass obj;
	LoginPage loginpage  ;
	DashboardPage dashboardpage ;
	HelpPage helppage ;
	ProfilePage profilepage;
	AdminPage adminpage;
	UsersPage userspage;
	ConfigurationPage configurationpage;
	FoldersPage folderspage;
	BasicPage basicpage;
	private Boolean status = false;

	
	public MyProfilePageScenarios(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj=obj;
	}
	public MyProfilePageScenarios() {

		// TODO Auto-generated constructor stub
	}
	
	public void createDoubleLockPasswordInProfile() {
		try{
			
			loginpage  = new LoginPage(obj);
			profilepage = new ProfilePage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"),"No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			profilepage.CreateDoubleLockPassword(retrieve("Password"), retrieve("DoubleLock Password"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || profilepage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
    public void verifyDoubleLockPasswordWithoutEnteringfilelds() {
		try{
			
			loginpage  = new LoginPage(obj);
			profilepage = new ProfilePage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			//profilepage.
			profilepage.openCreateDoubleLockPasswordPage(retrieve("Password"), true);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			profilepage.validateDoubleLockPasswordErrorMessage(retrieve("Password"), retrieve("Password"), retrieve("Password Error Message"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || profilepage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
    
    public void verifyDoubleLockPasswordLessCharacters() {
		try{
			
			loginpage  = new LoginPage(obj);
			profilepage = new ProfilePage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			//profilepage.
			profilepage.openCreateDoubleLockPasswordPage(retrieve("Password"), true);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			profilepage.validateDoubleLockPasswordErrorMessage(retrieve("DoubleLock Password"), retrieve("Doublelock Confirm Password"), retrieve("Password Error Message"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || profilepage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
    
    public void verifyDoubleLockPasswordNotMatch() {
		try{
			
			loginpage  = new LoginPage(obj);
			profilepage = new ProfilePage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			//profilepage.
			profilepage.openCreateDoubleLockPasswordPage(retrieve("Password"), true);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			profilepage.validateDoubleLockPasswordErrorMessage(retrieve("DoubleLock Password"), retrieve("Doublelock Confirm Password"), retrieve("Password Error Message"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || profilepage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
    
    public void ResetDoubleLockPassword() {
		try{
			
			loginpage  = new LoginPage(obj);
			profilepage = new ProfilePage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			profilepage.openCreateDoubleLockPasswordPage(retrieve("Password"), false);
			profilepage.CreateDoubleLockPasswordWithoutVsts(retrieve("Doublelock Password"), retrieve("Doublelock Confirm Password"));
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
			profilepage.ResetDoubleLockPassword(retrieve("Password"), retrieve("DoubleLock Password"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || profilepage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
}
