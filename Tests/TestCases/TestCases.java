package TestCases;

import org.testng.annotations.AfterClass;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import AutomationFramework.GenericKeywords;
import baseClass.BaseClass;
import scenarios.BasicScenarios;
import scenarios.DashboardScenarios;
import scenarios.HelpPageScenarios;
import scenarios.LicenseScenarios;
import scenarios.LoginScenario;
import scenarios.MyProfilePageScenarios;
import scenarios.SecretScenarios;

@Listeners({Utilities.HtmlReport.class})  
public class TestCases
{
	String machineName = "";
	BaseClass obj;
	LoginScenario loginScenario;
	DashboardScenarios dashboardscenarios;
	BasicScenarios basicscenarios;
	HelpPageScenarios helppagescenarios;
	MyProfilePageScenarios myprofilepagescenarios;
	LicenseScenarios licensescenarios;
	SecretScenarios secretscenarios;
	
	////////////////////////////////////////////////////////////////////////////////
	//Function Name  :
	//Purpose    	 :
	//Parameters  	 :
	//Return Value   :
	//Created by     :
	//Created on     :     
	//Remarks        :
	/////////////////////////////////////////////////////////////////////////////////
 
	public void TestStart(String testCaseDescription,String hostName,String testCaseName)
	{	
		
		obj.currentTestCaseName=testCaseName;
		obj.setEnvironmentTimeouts();
		obj.reportStart(testCaseDescription,hostName);
		obj.iterationCount.clear();
		obj.iterationCountInTextData();
		GenericKeywords.stepCount = 1;
		//obj.stepCount = 1;
	}
	
	@BeforeClass
	@Parameters({"selenium.machinename","selenium.host", "selenium.port", "selenium.browser", "selenium.os", "selenium.browserVersion", "selenium.osVersion","TestData.SheetNumber"})
	public void precondition(String machineName,String host,String port,String browser,String os,String browserVersion,String osVersion,String sheetNo)
	{
		
		//module2functionalities.udid="ZX1D64HN6H";
		obj=new BaseClass();
		//obj.udid="4d00b71fb67630f5";
		obj.udid = "ZX1D64HN6H";
		if(os.contains("Android"))
		{
			obj.startServer(host,port);
			obj.waitTime(10);
		}
		obj.setup(machineName,host, port, browser,os,browserVersion,osVersion,sheetNo);
		obj.createTestRun();
		System.out.println("ssssssssssssssssssss");
	}

	@AfterClass
	public void closeSessions()
	{
		obj.closeAllSessions();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43709(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validating element are displayed in login Page",machineName,method.getName());
		loginScenario = new LoginScenario(obj);
		for(int i=0;i<loginScenario.iterationCount.size();i++)
		{
			
			loginScenario.dataRowNo=Integer.parseInt(loginScenario.iterationCount.get(i).toString());
			loginScenario.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", loginScenario.currentExecutionMachineName, loginScenario.currentTestCaseName);
			loginScenario.ValidateLoginPageFields();			
		}
		obj.testFailure=loginScenario.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43710(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validating successfully login in secret server",machineName,method.getName());
		loginScenario = new LoginScenario(obj);
		for(int i=0;i<loginScenario.iterationCount.size();i++)
		{
			
			loginScenario.dataRowNo=Integer.parseInt(loginScenario.iterationCount.get(i).toString());
			loginScenario.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", loginScenario.currentExecutionMachineName, loginScenario.currentTestCaseName);
			loginScenario.ValidateLoginPageFieldswithLogin();			
		}
		obj.testFailure=loginScenario.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43711(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Verify Login failed Message is displayed when entering invalid credentials",machineName,method.getName());
		loginScenario = new LoginScenario(obj);
		for(int i=0;i<loginScenario.iterationCount.size();i++)
		{
			
			loginScenario.dataRowNo=Integer.parseInt(loginScenario.iterationCount.get(i).toString());
			loginScenario.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", loginScenario.currentExecutionMachineName, loginScenario.currentTestCaseName);
			loginScenario.InvaildLogincredentials();			
		}
		obj.testFailure=loginScenario.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43712(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("validation message on clicking 'Login' button with blank entries in 'Username' and 'Password' fields",machineName,method.getName());
		loginScenario = new LoginScenario(obj);
		for(int i=0;i<loginScenario.iterationCount.size();i++)
		{
			
			loginScenario.dataRowNo=Integer.parseInt(loginScenario.iterationCount.get(i).toString());
			loginScenario.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", loginScenario.currentExecutionMachineName, loginScenario.currentTestCaseName);
			loginScenario.ValidatblankUserAndPassworkErrorMessage();			
		}
		obj.testFailure=loginScenario.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43713(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("validation message on clicking 'Login' button with blank entries in 'Password' fields",machineName,method.getName());
		loginScenario = new LoginScenario(obj);
		for(int i=0;i<loginScenario.iterationCount.size();i++)
		{
			
			loginScenario.dataRowNo=Integer.parseInt(loginScenario.iterationCount.get(i).toString());
			loginScenario.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", loginScenario.currentExecutionMachineName, loginScenario.currentTestCaseName);
			loginScenario.validateblankPasswordErrorMsg();			
		}
		obj.testFailure=loginScenario.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43714(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("validation message when entering valid Username with blank entries in UserName field",machineName,method.getName());
		loginScenario = new LoginScenario(obj);
		for(int i=0;i<loginScenario.iterationCount.size();i++)
		{
			
			loginScenario.dataRowNo=Integer.parseInt(loginScenario.iterationCount.get(i).toString());
			loginScenario.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", loginScenario.currentExecutionMachineName, loginScenario.currentTestCaseName);
			loginScenario.ValidatblankUserNameErrorMessage();			
		}
		obj.testFailure=loginScenario.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43715(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Verify the user is able to view 'Thycotic' page by clicking 'Copyright' link in the Login page",machineName,method.getName());
		loginScenario = new LoginScenario(obj);
		for(int i=0;i<loginScenario.iterationCount.size();i++)
		{
			
			loginScenario.dataRowNo=Integer.parseInt(loginScenario.iterationCount.get(i).toString());
			loginScenario.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", loginScenario.currentExecutionMachineName, loginScenario.currentTestCaseName);
			loginScenario.ValidateThycoticpagedisplayed();			
		}
		obj.testFailure=loginScenario.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43716(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Verify the user is able to 'Refresh' the page on clicking 'Thycotic Logo'",machineName,method.getName());
		loginScenario = new LoginScenario(obj);
		for(int i=0;i<loginScenario.iterationCount.size();i++)
		{
			
			loginScenario.dataRowNo=Integer.parseInt(loginScenario.iterationCount.get(i).toString());
			loginScenario.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", loginScenario.currentExecutionMachineName, loginScenario.currentTestCaseName);
			loginScenario.ValidateRefreshthepageafterclickinglogo();			
		}
		obj.testFailure=loginScenario.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43717(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Verify the user is able to view 'thycotic' page by clicking Thycotic Logo in the footer section",machineName,method.getName());
		loginScenario = new LoginScenario(obj);
		for(int i=0;i<loginScenario.iterationCount.size();i++)
		{
			
			loginScenario.dataRowNo=Integer.parseInt(loginScenario.iterationCount.get(i).toString());
			loginScenario.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", loginScenario.currentExecutionMachineName, loginScenario.currentTestCaseName);
			loginScenario.ValidateThycoticpagedisplayedclickingThycotic();			
		}
		obj.testFailure=loginScenario.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42340(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("verifing help fields are present in Help Pages",machineName,method.getName());
		helppagescenarios = new HelpPageScenarios(obj);
		for(int i=0;i<helppagescenarios.iterationCount.size();i++)
		{
			
			helppagescenarios.dataRowNo=Integer.parseInt(helppagescenarios.iterationCount.get(i).toString());
			helppagescenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", helppagescenarios.currentExecutionMachineName, helppagescenarios.currentTestCaseName);
			helppagescenarios.Verifyhelppagelayout();			
		}
		obj.testFailure=helppagescenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42377(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Add and verify ColumnSelection in Secretgrid ",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.verifyColumnselectionInSecretGrid();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42351(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Delete the secret widget element from dashboard",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.deleteSecretWidgeInDashboard();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42389(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Add and verify ColumnSelection in Secretgrid ",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.addNewTabByDraggingFolder();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42414(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Add and verify ColumnSelection in Secretgrid ",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.VerifyCurrentSessionPage();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42401(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Create doublelock password in profile page",machineName,method.getName());
		myprofilepagescenarios = new MyProfilePageScenarios(obj);
		for(int i=0;i<myprofilepagescenarios.iterationCount.size();i++)
		{
			
			myprofilepagescenarios.dataRowNo=Integer.parseInt(myprofilepagescenarios.iterationCount.get(i).toString());
			myprofilepagescenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", myprofilepagescenarios.currentExecutionMachineName, myprofilepagescenarios.currentTestCaseName);
			myprofilepagescenarios.createDoubleLockPasswordInProfile();			
		}
		obj.testFailure=myprofilepagescenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42420(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Performing delete function in BulkOperation",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.DeleteInBulkOperation();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42442(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Performing disable Comment on view function in BulkOperation",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.DisableCommentInBulkOperation();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42443(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validate Error message for Assign Secret Policy function in BulkOperation",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.ValidateErrorMessageAssignSecretPolicy();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42444(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("validating inherite Secret policy in Assign Secret Policy",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.ValidateInheritSecretPolicyInAssignSecretPolicy();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42453(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("validating Disable Check out in bulk operation",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.DisableCheckoutInBulkOperation();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42459(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("validating Enable Check out in bulk operation",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.EnableCheckoutInBulkOperation();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42468(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("validating Enable Autochange in bulk operation",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.EnableAutochangeInBulkOperation();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42469(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("validating Disable Autochange bulk operation",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.DisableAutochangeInBulkOperation();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}

	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42471(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validating Heartbeat Option Present in  BulkOperation ",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.verifyHeartbeatOptioninBulk();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42473(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("validate Enable Heartbeat in Bulk Operation",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.EnableHeartbeatOptioninBulk();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42475(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("validate Disable Heartbeat in Bulk Operation",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.DisableHeartbeatOptioninBulk();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
		
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42478(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("validate Run Heartbeat in Bulk Operation",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.RunHeartbeatOptioninBulk();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}

	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42482(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validating a Error Message after disable Heartbeat in Secret Template",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.verifyErrorMessageEnableHeartbeatInBulkOperation();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42484(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validating  Create DoubleLock Password without entering values in fields",machineName,method.getName());
		myprofilepagescenarios = new MyProfilePageScenarios(obj);
		for(int i=0;i<myprofilepagescenarios.iterationCount.size();i++)
		{
			
			myprofilepagescenarios.dataRowNo=Integer.parseInt(myprofilepagescenarios.iterationCount.get(i).toString());
			myprofilepagescenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", myprofilepagescenarios.currentExecutionMachineName, myprofilepagescenarios.currentTestCaseName);
			myprofilepagescenarios.verifyDoubleLockPasswordWithoutEnteringfilelds();			
		}
		obj.testFailure=myprofilepagescenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42485(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validating Create DoubleLock Password entering Lessthan 8 characters",machineName,method.getName());
		myprofilepagescenarios = new MyProfilePageScenarios(obj);
		for(int i=0;i<myprofilepagescenarios.iterationCount.size();i++)
		{
			
			myprofilepagescenarios.dataRowNo=Integer.parseInt(myprofilepagescenarios.iterationCount.get(i).toString());
			myprofilepagescenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", myprofilepagescenarios.currentExecutionMachineName, myprofilepagescenarios.currentTestCaseName);
			myprofilepagescenarios.verifyDoubleLockPasswordLessCharacters();			
		}
		obj.testFailure=myprofilepagescenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42486(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validating create DoubleLock password on entering password that does not Match",machineName,method.getName());
		myprofilepagescenarios = new MyProfilePageScenarios(obj);
		for(int i=0;i<myprofilepagescenarios.iterationCount.size();i++)
		{
			
			myprofilepagescenarios.dataRowNo=Integer.parseInt(myprofilepagescenarios.iterationCount.get(i).toString());
			myprofilepagescenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", myprofilepagescenarios.currentExecutionMachineName, myprofilepagescenarios.currentTestCaseName);
			myprofilepagescenarios.verifyDoubleLockPasswordNotMatch();			
		}
		obj.testFailure=myprofilepagescenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42488(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validating Resetting DoubleLock password",machineName,method.getName());
		myprofilepagescenarios = new MyProfilePageScenarios(obj);
		for(int i=0;i<myprofilepagescenarios.iterationCount.size();i++)
		{
			myprofilepagescenarios.dataRowNo=Integer.parseInt(myprofilepagescenarios.iterationCount.get(i).toString());
			myprofilepagescenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", myprofilepagescenarios.currentExecutionMachineName, myprofilepagescenarios.currentTestCaseName);
			myprofilepagescenarios.ResetDoubleLockPassword();			
		}
		obj.testFailure=myprofilepagescenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42495(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Adding licenses via SecretServerSetup page and verify licenses are present in Licenses Page",machineName,method.getName());
		licensescenarios = new LicenseScenarios(obj);
		for(int i=0;i<licensescenarios.iterationCount.size();i++)
		{
			licensescenarios.dataRowNo=Integer.parseInt(licensescenarios.iterationCount.get(i).toString());
			licensescenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", licensescenarios.currentExecutionMachineName, licensescenarios.currentTestCaseName);
			licensescenarios.AddLicensesViaSecretServerSetup();			
		}
		obj.testFailure=licensescenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42496(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Verify licenses are present in Licenses Page and Removing a licenses via SecretServerSetup Page",machineName,method.getName());
		licensescenarios = new LicenseScenarios(obj);
		for(int i=0;i<licensescenarios.iterationCount.size();i++)
		{
			licensescenarios.dataRowNo=Integer.parseInt(licensescenarios.iterationCount.get(i).toString());
			licensescenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", licensescenarios.currentExecutionMachineName, licensescenarios.currentTestCaseName);
			licensescenarios.verifyRemoveLicensesViaSecretServerSetup();			
		}
		obj.testFailure=licensescenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42541(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validate Enable disable heartbeat in bulkoperation",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.verifyHBInBulkOperationWhenDisableHBInSecretTemplate();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42543(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("perform 'EnableCommentonView' bulk operation for secrets that has already set 'Enablecommentonview' option ",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.EnableCommentInBulkOperation();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42550(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Deleting current session and Validating SecretServer is logout automatically after clicking Logo in home page ",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.DeleteCurrentSession();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42561(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Perfoming Commentonview bulk operation with newfolders Edit permission "
				+ "'Default Secret Permissions' as ''",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.EnableCommentonViewInBulkWithEditPermission();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42578(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Perfoming Add Share  bulk operation with newfolders Edit permission"
				+ "'Default Secret Permissions' as 'New Secrets copy permissions from folder'",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.AddShareOptionInBulkWithViewFolderPermission();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42565(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Perfoming Add Share  bulk operation with newfolders List permission"
				+ "'Default Secret Permissions' as ''",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.AddShareOptionInBulkWithListFolderPermission();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42587(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Perfoming Hid launcher Password in Bulk Operation with new folader has Edit permission"
				+ " 'Default Secret Permissions' to 'New Secrets copy permissions from folder ",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.HideLauncherInBulkWithListFolderPermission();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42598(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Perfoming Commentonview bulk operation in newfolders with List permission and "
				+ " 'Default Secret Permissions' to 'Only creator has permissions ",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.EnableCommentonViewInBulkWithListPermission();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42599(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Perfoming Commentonview bulk operation in newfolders with Edit permission has  "
				+ "'Default Secret Permissions' to 'Only creator has permissions ",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.AddShareBulkWithOnlyCreatorHasPermissions();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42625(String machineName,Method method) throws MalformedURLException 
	{
		TestStart("Perfoming Run HeartBeat bulk operation in newfolders with Edit permission and "
				+ " 'Default Secret Permissions' to 'Only creator has permissions ",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.HeathBeatWithDifferentFolderPermission();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42627(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Perfoming Enable HeartBeat bulk operation in newfolders with Edit permission and "
				+ " 'Default Secret Permissions' to 'Only creator has permissions ",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.HeathBeatWithDifferentFolderPermission();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42776(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validating Search opertion in Basic link Functions",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.VerifySecretSearchInBasicLink();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42778(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Validating Search opertion in Basic link Functions",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{
			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.verifyCreateSecretInBasicPage();			
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42782(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Verify the user is able launch the sql server",machineName,method.getName());
		basicscenarios = new BasicScenarios(obj);
		for(int i=0;i<basicscenarios.iterationCount.size();i++)
		{
			
			basicscenarios.dataRowNo=Integer.parseInt(basicscenarios.iterationCount.get(i).toString());
			basicscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", basicscenarios.currentExecutionMachineName, basicscenarios.currentTestCaseName);
			basicscenarios.verifySQLServerLaunch();			
		}
		obj.testFailure=basicscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42788(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("Verify the user is able to connect the Remort Machine ",machineName,method.getName());
		basicscenarios = new BasicScenarios(obj);
		for(int i=0;i<basicscenarios.iterationCount.size();i++)
		{
			
			basicscenarios.dataRowNo=Integer.parseInt(basicscenarios.iterationCount.get(i).toString());
			basicscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", basicscenarios.currentExecutionMachineName, basicscenarios.currentTestCaseName);
			basicscenarios.verifyRemoteMachineLaunch();			
		}
		obj.testFailure=basicscenarios.testFailure;
		TestEnd();
	}
	
	
	
	//sathish
	
//	@Test(alwaysRun=true)
//	@Parameters({ "selenium.machinename"})
//	public void TC_42340(String machineName,Method method) throws MalformedURLException 
//	{
//
//		TestStart("Create new SBD Contract",machineName,method.getName());
//		loginScenario = new LoginScenario(obj);
//		for(int i=0;i<loginScenario.iterationCount.size();i++)
//		{
//
//			loginScenario.dataRowNo=Integer.parseInt(loginScenario.iterationCount.get(i).toString());
//			loginScenario.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", loginScenario.currentExecutionMachineName, loginScenario.currentTestCaseName);
//			loginScenario.scenario1();			
//		}
//		obj.testFailure=loginScenario.testFailure;
//		TestEnd();
//	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42342(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.dashboard_MyProfile();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42380(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.dashboard_DragAndDrop();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}

	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42397(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.UpdatePassword();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42439(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.commentOnView();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}

	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42440(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.disable_CommentonView();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42441(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.disable_CommentonViewWithMultipleSecrets();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42447(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.single_EnableCheckOut();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42451(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.EnableCheckOutWith_MultipleSecrets();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}



	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42456(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.ValidatingWelcomeInContents();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42457(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.HideLauncherPassword();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42467(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.RemotePasswordStatusChange();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42487(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.FavouriteSecrets();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}

	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42535(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.MultiplePinSecret();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42536(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.EnableAutochangeRemotePassword();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}

	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42542(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.RunHeartbeatwithHeartbeatDisabled();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42545(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.Disableheartbeat_HeartbeatDisabled();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42547(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.CurrentLoggedIn_Sessions();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42569(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.unableToPerformBulkOperation();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42584(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.unableToPerformBulkOperationNewSecretscopypermissionsfromfolder();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}

	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42606(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.ableToPerformCheckOutWithEditPermission();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}


	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42616(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.EnableHeartbeatWithListPermission();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42624(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.RunHeartbeat_ViewPermission();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42635(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.RunHeartbeatWithListPermission();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42638(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.EnableHeartbeatWithViewPermission();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42643(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.DisableHeartbeatWithViewPermission();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42649(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.RunHeartbeatWithListPermission_onlyCreatorhasPermissions();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42791(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.BasicTabValidation();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42559(String machineName,Method method) throws MalformedURLException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.ValidatingGettingStarted();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_42786(String machineName,Method method) throws IOException 
	{

		TestStart("Validating My Profile elememts",machineName,method.getName());
		dashboardscenarios = new DashboardScenarios(obj);
		for(int i=0;i<dashboardscenarios.iterationCount.size();i++)
		{

			dashboardscenarios.dataRowNo=Integer.parseInt(dashboardscenarios.iterationCount.get(i).toString());
			dashboardscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", dashboardscenarios.currentExecutionMachineName, dashboardscenarios.currentTestCaseName);
			dashboardscenarios.copyToClipBoard();	
		}
		obj.testFailure=dashboardscenarios.testFailure;
		TestEnd();
	}
	
	
//SecretScenarios secretscenarios;
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43381(String machineName,Method method) throws IOException 
	{

		TestStart("Validate Strong field is displayed after clicking generate button",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.VerifyGenerateButtonWithPasseord();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43384(String machineName,Method method) throws IOException 
	{

		TestStart("Validate Strong field is displayed after clicking generate button",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.VerifyLockIconWithGeneratePassword();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43458(String machineName,Method method) throws IOException 
	{

		TestStart("create a New Secret for the template Windows Account",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.CreateSecretWindowsAccount();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43460(String machineName,Method method) throws MalformedURLException 
	{
	
		TestStart("verify the search box function in Basic link ",machineName,method.getName());
		basicscenarios = new BasicScenarios(obj);
		for(int i=0;i<basicscenarios.iterationCount.size();i++)
		{
			
			basicscenarios.dataRowNo=Integer.parseInt(basicscenarios.iterationCount.get(i).toString());
			basicscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", basicscenarios.currentExecutionMachineName, basicscenarios.currentTestCaseName);
			basicscenarios.verifySecretSearchboxwithvalues();			
		}
		obj.testFailure=basicscenarios.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43463(String machineName,Method method) throws IOException 
	{

		TestStart("create a New Secret for the template Pin Account in basic link page",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.CreateSecretPinAccountInBasiclink();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43469(String machineName,Method method) throws IOException 
	{

		TestStart("create a New Secret for the template Pin Account in basic link page",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.ValidateConvertionSecretFromActiveDirectoryToWindow();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43380(String machineName,Method method) throws IOException 
	{

		TestStart("Validate Strong field is displayed after clicking generate button",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.ableToDeleteSecret();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43394(String machineName,Method method) throws IOException 
	{

		TestStart("Validate Strong field is displayed after clicking generate button",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.PerformingSecretActionswithActiveDirectory();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43447(String machineName,Method method) throws IOException 
	{

		TestStart("Validate Strong field is displayed after clicking generate button",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.sqlServerAccountValidation();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43462(String machineName,Method method) throws IOException 
	{

		TestStart("Validate Strong field is displayed after clicking generate button",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.pinTemplateValidation();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43468(String machineName,Method method) throws IOException 
	{

		TestStart("Validate Strong field is displayed after clicking generate button",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.PinSecretDetailsValidation();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43476(String machineName,Method method) throws IOException 
	{

		TestStart("Validate Strong field is displayed after clicking generate button",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.createCustomSecretTemplate();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun=true)
	@Parameters({ "selenium.machinename"})
	public void TC_43515(String machineName,Method method) throws IOException 
	{

		TestStart("Validate Strong field is displayed after clicking generate button",machineName,method.getName());
		secretscenarios = new SecretScenarios(obj);
		for(int i=0;i<secretscenarios.iterationCount.size();i++)
		{

			secretscenarios.dataRowNo=Integer.parseInt(secretscenarios.iterationCount.get(i).toString());
			secretscenarios.writeHtmlTestStepReport("<font size=4 style='color:blue'>DataSet:"+(i+1)+"</font><br/>", secretscenarios.currentExecutionMachineName, secretscenarios.currentTestCaseName);
			secretscenarios.saveAndShareUsingActiveDirectory();	
		}
		obj.testFailure=secretscenarios.testFailure;
		TestEnd();
	}
	
	
	public void TestEnd() {
		obj.waitTime(1);
		if (obj.testFailure) {
			obj.completeRun("Failed");
			GenericKeywords.testFailed();
		}
		else{
			obj.completeRun("Passed");
		}
	}
	
	@BeforeMethod
	public void before()
	{
		obj.testFailure=false;
	}
	
}
