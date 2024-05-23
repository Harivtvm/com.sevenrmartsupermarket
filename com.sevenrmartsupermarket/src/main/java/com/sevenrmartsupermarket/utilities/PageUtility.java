package com.sevenrmartsupermarket.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}
public void fileUpload(WebElement element,String path) throws Exception {
	Actions action=new Actions(driver);
	Robot robot=new Robot();
	Thread.sleep(1000);
	action.moveToElement(element).click().perform();
	StringSelection ss = new StringSelection(path);                             //for copying filepath to clipboard
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	robot.delay(2000);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	robot.delay(2000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public void select_ByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void select_ByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void select_ByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public boolean is_Selected(WebElement element) {
		return element.isSelected();
	}

	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean is_Enabled(WebElement element) {
		return element.isEnabled();
	}

	public void alert_Accept() {
		driver.switchTo().alert().accept();
	}

	public void alert_Dismiss() {
		driver.switchTo().alert().dismiss();
	}

	public void alert_GetText() {
		driver.switchTo().alert().getText();
	}

	public void alert_SendKeys(String key) {
		driver.switchTo().alert().sendKeys(key);
	}

	public void scrollAndClick(WebElement element) {
		int y = 0;
		while (clickStatus(element)) {
			js.executeScript("window.scrollBy(0," + y + ")");
			y = y + 5;
		}

	}

	public boolean clickStatus(WebElement element) {
		try {
			element.click();
			return false;
		} catch (Exception e) {
			return true;
		}
	}
}
