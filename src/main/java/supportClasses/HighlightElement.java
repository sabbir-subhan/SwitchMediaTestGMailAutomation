package supportClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement {
	//static WebDriver driver;
    public void highlightElement(WebDriver driver,WebElement element) {
    	
    	JavascriptExecutor js=(JavascriptExecutor)driver; 

    	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

    	//2 seconds  pause after highlighting
    	try 
    	{    		
    	Thread.sleep(2000);
    	} 
    	catch (InterruptedException e) {

    	System.out.println(e.getMessage());
    	} 

    	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
    	
    }
}