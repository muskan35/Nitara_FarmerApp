package com.nitara.PageObjects;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;
import com.nitara.utils.DriverManager;
import com.nitara.utils.TestUtils;

public class BasePage {

	private AndroidDriver<?> driver;
	TestUtils utils = new TestUtils();

	public BasePage() {
		this.driver = (AndroidDriver<?>) new DriverManager().getDriver();
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		


	}

	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void waitVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, TestUtils.OTP_WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void clear(MobileElement e) {
		waitForVisibility(e);
		e.clear();
	}

	public void click(MobileElement e) {
		waitForVisibility(e);
		WebDriverWait w = new WebDriverWait(driver, 1000);
		w.until((ExpectedCondition<Boolean>) driver -> e.isEnabled());
		e.click();
	}

	public void click(MobileElement e, String msg) {
		
	}

	public void sendKeys(MobileElement e, int txt) {
		waitForVisibility(e);
		// utils.log().info(msg);
		e.sendKeys(String.valueOf(txt));
	}
	
	public void sendKeys(MobileElement e, String txt) {
		waitForVisibility(e);
		// utils.log().info(msg);
		e.sendKeys(txt);
	}

	public String getAttribute(MobileElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}

	public String getText(MobileElement e) {
		String txt;
		txt = getAttribute(e, "text");
		return txt;
	}


	public void closeApp() {
		((InteractsWithApps) driver).closeApp();
	}

	public void launchApp() {
		((InteractsWithApps) driver).launchApp();
	}


	public boolean find(final MobileElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					if (element.isDisplayed()) {
						return true;
					}
					return false;
				}
			});
		} catch (Exception e) {
			return false;
		}
	}

	public boolean find(final By element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					if (driver.findElement(element).isDisplayed()) {
						return true;
					}
					return false;
				}
			});
		} catch (Exception e) {
			return false;
		}
	}


	public String captureToast() {
		WebDriverWait waitForToast = new WebDriverWait(driver,25);
		waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		String toastMessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
		return toastMessage;
	}
	
	public void select_dropdown(String value) {
		driver.findElement(By.xpath("//*[@text='" + value + "']")).click();
	}
	

	public void findElement(String text) {
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+text+"\")").click();
	}
	
	public void scrollfindElement(String myText) {
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(textContains(\""+myText+"\"))").click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
    ".scrollIntoView(new UiSelector().textContains(\""+myText+"\"))");
	}
	public void scrollTofindElement(String id) {
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).resourceId(\""+myText+"\"))").click();
		MobileElement el = (MobileElement) driver.findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().resourceIdMatches(\"" +id+ "\"));");
		el.click();
	}
	
	public void hideKeyboard() {
		driver.hideKeyboard();
	}
	
	
	

}



