package testScripts;

import org.testng.annotations.Test;

import supportClasses.AutoITWindowsGUIAutomationFileUpload;
import supportClasses.CaptureVideo;
import supportClasses.HighlightElement;
import supportClasses.WebEventListener;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class jqueryuiDragAndDropTest {

	//URL to Navigate
	private String URL="http://jqueryui.com/resources/demos/droppable/default.html";
		
	
	//Creating Webdriver object
	private WebDriver Chromedriver;
	private WebEventListener eventListener;
	private EventFiringWebDriver driver;

	  @BeforeClass
	  
	  public void setup() throws InterruptedException{
		  

		// Optional, if not specified, WebDriver will search your path for chromedriver.
		  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		  Chromedriver = new ChromeDriver();
		  
			// Initializing EventFiringWebDriver using Chrome WebDriver instance
			driver = new EventFiringWebDriver(Chromedriver);

			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();

			driver.register(eventListener);
			
		  //Add 40 secs implicit wait for each web elements
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  //Add 60 secs for all page load
		  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		  //Maximize browser window
		  driver.manage().window().maximize();
	
		  
	  }
	  
  @Test
  public void testCaseOne() throws InterruptedException {
	  
		  
	  //Creating a Highlight  object
	  HighlightElement highlight=new HighlightElement();
	  
	  //navigate to https://www.w3schools.com/html/html5_draganddrop.asp
	  driver.navigate().to(URL);
	  
	// Add 5 seconds wait
	  Thread.sleep(3000);
	   
	  // Create object of actions class
	  Actions act=new Actions(driver);
	   
	  // find element which we need to drag
	  WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));
	   
	  // find element which we need to drop
	  WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));
	   
	  // this will drag element to destination
	  act.dragAndDrop(drag, drop).build().perform();
	  
	// Add 5 seconds wait
		  Thread.sleep(3000);
		   
	  //End of drag and drop
	  
	 
		  	 
  }
  


  @AfterClass
  public void close(){
	
	  driver.quit();
  }

}
