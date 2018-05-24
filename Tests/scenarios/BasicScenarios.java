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

public class BasicScenarios extends ApplicationKeywords{
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

	public BasicScenarios(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj=obj;
	}
	public BasicScenarios() {

		// TODO Auto-generated constructor stub
	}
	
	public void verifySQLServerLaunch() {
		try{
			
			String Secrettemplate = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String Server = retrieve("Server");
			String SqlUserName = retrieve("Sql UserName");
			String SqlPassword = retrieve("Sql Password");
			String Note = retrieve("Note");
			String FolderPath = retrieve("Folder Path");
			String FolderName = retrieve("Folder Name");
			String InhertPolicy =  retrieve("Inherit Secret Policy");
			String SecretPolicy = retrieve("Secret Policy");
        	String AutoChange = retrieve("AutoChange");
			
			
			loginpage  = new LoginPage(obj);
			basicpage = new BasicPage(obj);
			dashboardpage = new DashboardPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			CreateSqlSecretTemplate(Secrettemplate, SecretName, Server, SqlUserName, SqlPassword,  
					Note, FolderPath, FolderName, InhertPolicy, SecretPolicy, AutoChange);
//			
			dashboardpage.validateSecretispresent(SecretName,FolderName, true);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");	
			basicpage.VerifySqlServerLaunch(SecretName);
			deleteSecretfromdashboard(SecretName);
			
			loginpage.Logout();
		
		
        	
			
		
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || basicpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void verifyRemoteMachineLaunch() {
		try{
			
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
			
			
			loginpage  = new LoginPage(obj);
			basicpage = new BasicPage(obj);
			dashboardpage = new DashboardPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			CreateSqlSecretTemplate(Secrettemplate, SecretName, Machine, MachineUserName, MachinePassword,  
					Note, FolderPath, FolderName, InhertPolicy, SecretPolicy, AutoChange);
			dashboardpage.validateSecretispresent(SecretName,FolderName, true);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");	
			basicpage.VerifyRemortMachineLaunch(SecretName);
			deleteSecretfromdashboard(SecretName);
			
			loginpage.Logout();
			System.out.println("Changes");
			
			

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || basicpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
		
	}
	
	
	
	
}