package testScripts;

import org.testng.annotations.Test;

import supportClasses.AutoITWindowsGUIAutomationFileUpload;
import supportClasses.CaptureVideo;
import supportClasses.HighlightElement;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GMailSwitchMediaTest {
	/*Please input variables to control the data of the test
	 */
	
	//To enable video capturing of test execution set this variable to True
	Boolean CaptureVideoEnabled=false;
	
	// Set your email address to Sign-in to GMail account
	String SignInEmail="sabbirswitchmediatest@gmail.com";
	
	// Set your email address to Sign-in to GMail account
	String SignInEmailPassword="SwitchMedia";
	
	// Set your To email address that will receive the email
	String ToEmailAddress="sabbir_ss@hotmail.com";
		
	/*----End of variable section----*/
	
	//Creating Webdriver object
	public WebDriver driver;
	
	//First we instantiate an object of CaptureVidep class
 	CaptureVideo captureTestExecution=new CaptureVideo();
 	
	Instant start = Instant.now();

	  @BeforeClass
	  
	  public void setup() throws InterruptedException{
		  
		 //Prints Out the Test Case Name in the console for debugging purpose
		  String TestCaseName = this.getClass().getName();
		 //find out working parent directory to save the Test Execution video
		  String WorkingDirectory=System.getProperty("user.dir");
		  //System.out.println("Working Directory = "+System.getProperty("user.dir"));
		  //System.out.println("TEST CASE RUNNING :"+ TestCaseName);
		  
		  
		  
		/*Now we pass TestCaseName as parameter. Please, note that video filed will be created 
		under C:\\SeleniumScriptVideos\\ folder with File name like "TestVideo-TestCase-<TestCaseName>-DateTime-<currentDateTime>"*/ 
		  if(CaptureVideoEnabled){
			  captureTestExecution.captureVideo(TestCaseName,WorkingDirectory);
			  // Start the capture of the video
			  captureTestExecution.startVideo();
		  	}
		  
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		  driver = new ChromeDriver();
		  //Add 40 secs implicit wait for each web elements
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  //Add 60 secs for all page load
		  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		  //Maximize browser window
		  driver.manage().window().maximize();
		  //go to GMail page
		  driver.get("https://mail.google.com/");
		  
	  }
	  
  @Test
  public void testCaseOne() {
	  //Starting Stop watch
		  
	  //Creating a Highlight  object
	  HighlightElement highlight=new HighlightElement();
	  
	  
	  //Enter Email address
	  WebElement googleEmail=driver.findElement(By.xpath("//*[@id='identifierId']"));
	  
	  //Get the text in Email ID text box
	  String googleEmailText=googleEmail.getAttribute("aria-label");
	  
	  
	  //Assert if mail ID text box has this text Email or phone
	  try{
		  System.out.println(googleEmailText);
		  Assert.assertTrue(googleEmailText.contains("Email or phone"));
		  System.out.println("!----Assertion  for Email Input field validation is successful---!");
		  
	  }
	  catch (AssertionError e){
		  System.out.println("!----Start of Assertion Failed for Email Input field validation---!");
			e.printStackTrace();	  		   
		   	System.out.println("!----End of Assertion Failed for Email Input field validation---!");
	  }
	  
	  highlight.highlightElement(driver, googleEmail);
	  googleEmail.sendKeys(SignInEmail);
	  
	  //Click Next button
	  WebElement googleNextButton=driver.findElement(By.xpath("//*[@id='identifierNext']/content/span"));
	  highlight.highlightElement(driver, googleNextButton);
	  
	  //Get the text in Next button
	  String googleNextButtonText=googleNextButton.getText();
	  
	//Assert if mail ID text box has this text Email or phone
		try{
				  System.out.println(googleNextButtonText);
				  Assert.assertTrue(googleNextButtonText.contains("NEXT"));
				  System.out.println("!----Assertion  for Next button validation is successful---!");
				  
		}
		catch (AssertionError e){
				  System.out.println("!----Start of Assertion Failed for Next button validation---!");
					e.printStackTrace();	  		   
				   	System.out.println("!----End of Assertion Failed for Next button validation---!");
			}
	  
	  //Click Next
	  googleNextButton.click();
	  
	  
	  //Now find and enter google password
	  WebElement googlePassword=driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
	  highlight.highlightElement(driver,googlePassword);
	  
	  //Verifying the existence of Gmail Password field 
	  //Get the text in Email ID text box
	  String googlePasswordText=googlePassword.getAttribute("aria-label");
	  
	  
	  //Assert if mail ID text box has this text Email or phone
	  try{
		  System.out.println(googlePasswordText);
		  Assert.assertTrue(googlePasswordText.contains("Enter your password"));
		  System.out.println("!----Assertion  for Email Password field validation is successful---!");
		  
	  }
	  catch (AssertionError e){
		  System.out.println("!----Start of Assertion Failed for Email Password  field validation---!");
			e.printStackTrace();	  		   
		   	System.out.println("!----End of Assertion Failed for Email Password field validation---!");
	  }
	  
	  //Enter Password
	  googlePassword.sendKeys(SignInEmailPassword);
	  
	  
	  //Now find and click sign in button
	  WebElement googleSigninButton=driver.findElement(By.xpath("//*[@id='passwordNext']"));
	  highlight.highlightElement(driver,googleSigninButton);
	  googleSigninButton.click(); 
	  
	//Verifying the existence of Gmail Sign-in field 
	  String googleSigninButtonText=googleSigninButton.getText();
	  //System.out.println("Sign in  button:"+googleSigninButtonText);
    
	  //Find and Click on Compose button
	  
	  WebElement ComposeEmail=driver.findElement(By.xpath("//div[text()='COMPOSE']"));
	  highlight.highlightElement(driver,ComposeEmail);
	  ComposeEmail.click();
	  
	  
	  //Find and enter email address to To Email
	  WebElement ToEmailInput=driver.findElement(By.xpath("//span[text()='To']/../../following-sibling::td//textarea"));
	  highlight.highlightElement(driver, ToEmailInput);
	  
	  //enter an email address
	  ToEmailInput.sendKeys(ToEmailAddress);
	  
	//Find and enter email subject to Subject
	  WebElement EmailSubjectInput=driver.findElement(By.xpath("//input[@name='subjectbox']"));
	  highlight.highlightElement(driver, EmailSubjectInput);
	  
	  //enter an email subject
	  EmailSubjectInput.sendKeys("Subject Automation Test");
	  
	  
	  //Find and enter email Body Text  to Body of Email
	  WebElement EmailBodyInput=driver.findElement(By.xpath("//div[@role='textbox']"));
	  highlight.highlightElement(driver, EmailBodyInput);
	  
	  //enter an email body
	  EmailBodyInput.sendKeys("Email Body Automation Test");
	  
	  //file upload 
	  WebElement FileUpload=driver.findElement(By.xpath("//div[@data-tooltip='Attach files']/div/div/div"));
	  highlight.highlightElement(driver, FileUpload);
	  //Click file upload button
	  FileUpload.click();
	  
	 
	  
	  //sleep
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	  //file upload page  open
	  /*------AutoIT script will handle window AutoMantion
	   * https://www.autoitscript.com
	   */
	  String AutoITFileName="ChromeFileUploadAutoITScript.exe";//should be in the project path
	  AutoITWindowsGUIAutomationFileUpload runAutoITFileUploadScript=new AutoITWindowsGUIAutomationFileUpload();
	  runAutoITFileUploadScript.AutoITWindowsGUIAutomationFileUpload(AutoITFileName);
	  //sleep--wait for upload to finish
	  try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	  
	  
	  
	  
	  //Find and enter email Send button and  click
	  WebElement EmailSendButton=driver.findElement(By.xpath("//*[text()='Send']"));
	  highlight.highlightElement(driver, EmailSendButton);
	  
	  //Click send button
	  EmailSendButton.click();
	  
	  //sleep
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	  
	  
	  //Find and click signout  Icon and  click
	  WebElement SignoutButtonIcon=driver.findElement(By.xpath("//a[contains(@title,'Google Account')]"));
	  highlight.highlightElement(driver, SignoutButtonIcon);
	  
	  //Click Signout Icon on top right corner
	  SignoutButtonIcon.click();
	  
	  //sleep
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	  
	  //Find and click signout  button and  click
	  WebElement SignoutButton=driver.findElement(By.xpath("//a[text()='Sign out']"));
	  highlight.highlightElement(driver, SignoutButton);
	  
	  //Click signout button
	  SignoutButton.click();
	  
	  //sleep
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	  
		  	 
  }
  


  @AfterClass
  public void close(){
	  Instant end = Instant.now();
	  Duration timeElapsed = Duration.between(start, end);
	  System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
	  //Now we stop capturing the test video
	  if(CaptureVideoEnabled){
		  captureTestExecution.stopVideo();
	  }
	  driver.quit();
  }

}
