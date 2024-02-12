import java.io.File;
import java.io.IOException;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class SeleniumAdvance2 {
	WebDriver dr1;
	Actions ac = new Actions(dr1);
	WebElement ele;
	
	
	public void MultipolEWindowHandle() {
		String pwin = dr1.getWindowHandle();
		Actions ac = new Actions(dr1);
		ac.click(ele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
		sendKeys(Keys.ENTER);
		Set<String> cwin = dr1.getWindowHandles();
		for (String win:cwin){
			if (!win.equals(pwin)) {
				dr1.switchTo().window(win);
			}
			
		}
		
		dr1.switchTo().defaultContent();
		// defaultContent for back to parent window

		 
			
			
		}
	public void mouseRelatedMethod () {
		ac.click().build().perform();
		//all mouseRelatedMethod will be build and perform method
		ac.clickAndHold ();
		ac.contextClick();
		ac.doubleClick();
		ac.dragAndDrop(ele, ele);
		ac.dragAndDropBy(ele, 100, 50);
		ac.keyUp(Keys.ARROW_UP);
		ac.moveToElement(ele);
		//moveToElrment is for hover over
		ac.pause(2000).release();
		
		
		
	
	}
	public void iframeHandling () {
		
		dr1.switchTo().frame("demo");
		ac.dragAndDrop(ele, ele);
		//if any element under iframe tag then first need to
		//switch driver to the frame then action 
	}
	public void cookieRelated(String cookiename) {
		//cookieRelated is under manage
		Set<Cookie> allCookie=dr1.manage().getCookies();
		for ( Cookie oneCookie:allCookie) {
			if (oneCookie.getName().equals(cookiename));
			dr1.manage().deleteCookie(oneCookie);
			break ;
		}
	}
	public void alartMethod() {
		//java script base window popup
		Alert a = dr1.switchTo().alert();
		a.accept();//click ok button
		a.dismiss();//click cancel button
		a.getText();//get thread text from alert box
		a.sendKeys("jkjj");//type on TeX box 
		//if it is web base popup then we will click on cross button 
		//to handle 
		
		
	}
	public void waitForElement(WebElement ele) {
		dr1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//explicit for particular element and it will
		//wait based on the logic
		WebDriverWait wait =new WebDriverWait (dr1,10);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public void screenShot() {
		
		File f = ((TakesScreenshot)dr1).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(f,new File ("/Users/tohuraakter/Downloads/BTC_"
					+ "JH230809E_MavenClass_TestNg/src/"
					+ "test/java/Shathy"));
		} catch (IOException e) {
			
			e.printStackTrace();
			
			
		}
			
		
	}
		 
	
	WebDriver dr;
	
	public void seleniumMethod() {
		dr1.close();
		
		WebElement element= dr1.findElement(By.id(""));
		
		element.clear();
		element.click();
		element.findElement(By.id(""));
		element.findElements(By.id(""));
		element.getAttribute("type");
		element.getCssValue("font - size");
		element.getLocation().getX(); 
		//this method helps to get x and y against an element 
		element.getTagName();
		element.getText();
		int x = Integer.parseInt("1");
		//Double.parseDouble("3.5");
		element.isDisplayed();
		element.isEnabled();
		element.isSelected();
		element.sendKeys("");
		element.sendKeys(Keys.ENTER);
		element.submit();
		// submit method will click without click method 
		
		List<WebElement> elements= dr1.findElements(By.id(" "));
		dr1.get("url");
		dr1.getCurrentUrl();
		dr1.getPageSource().contains("Shathy");
		dr1.getTitle();
		String pwin = dr1.getWindowHandle();
		Set<String> cwin = dr1.getWindowHandles();
		Options opt = dr1.manage();
		Navigation nav =dr1.navigate();
		dr1.quit();
		TargetLocator tarl = dr1.switchTo();
		
	
	}

}



