package com.ui.companyName.projectName.helper.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.companyName.projectName.helper.logger.LoggerHelper;

public class WaitHelper {

	WebDriver driver ;
	
	public WaitHelper(WebDriver driver) {
		
		this.driver = driver ;
	}
	
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public void setImplicitWait(long timeOut ,TimeUnit unit) {
		
		log.info("Implicit wait has been set to: "+ timeOut +""+unit);
		
		driver.manage().timeouts().implicitlyWait(timeOut, unit);
	}
	
	
	public WebDriverWait getWait(int timeOutInSeconds ,int  pollingInMilliSec){
		
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
	//	wait.pollingEvery(pollingInMilliSec);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
	
		return null;
		
		
	}
	
	/**
	 * This method will check for element visibility
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingInMilliSec
	 */
	
	public void waitForElementVisible(WebElement element , int timeOutInSeconds , int  pollingInMilliSec){
		log.info("Waiting for " +element.toString() + "for" + timeOutInSeconds+ " seconds");
		WebDriverWait wait = getWait(timeOutInSeconds,pollingInMilliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info( element.toString() +" element is visible");
	}

	
}
