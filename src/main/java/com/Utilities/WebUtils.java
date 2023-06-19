package com.Utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebUtils extends FileUtils {


	public static WebDriver driver = null;
	public static Actions act ;
	public static Select sel;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports reports;
	public static ExtentTest test;

	public static void startReport() {
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/AutomationTestReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
	}

	public static void stopReport() {
		reports.flush();
	}

	public static boolean browserlaunch(String value) {
		boolean flag = false;
		try {
			switch (value) {
			case  "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				flag = true;
				test.log(Status.INFO,"Chrome browser launched");
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				flag = true;
				test.log(Status.INFO,"Edge browser launched");
				break;
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				flag = true;
				test.log(Status.INFO,"Firefox browser launched");
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		implicitWait(10);
		return flag;
	}

	public static boolean browserClose() {
		boolean flag = false;
		try {
			driver.close();
			test.log(Status.INFO,"Browser Closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  flag;
	}


	public static boolean browserQuit() {
		boolean flag = false;
		try {
			driver.quit();
			test.log(Status.INFO,"Browser Quitted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  flag;
	}

	public static boolean  implicitWait(int value) {
		boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(value,TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean explicitWait(WebElement element, int value) {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, value);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return flag;
	}

	public static boolean geturl(String value) {
		boolean flag = false;
		try {
			driver.get(value);
			test.log(Status.INFO,"Navigated to : "+value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean clickbtn(WebElement element) {
		boolean flag= false;
		try {
			explicitWait(element, 10);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean sendkey(WebElement element, String value) {
		boolean flag = false;
		try {
			explicitWait(element, 10);
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  flag;
	}

	public static boolean pageRefresh() {
		boolean flag = false;
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  flag;
	}

	public static boolean windowHandles() {
		boolean flag = false;
		try {
			Set<String> alldata = driver.getWindowHandles();
			for (String data: alldata) {
				driver.switchTo().window(data).getTitle();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void naviBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void naviForward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean clearText(WebElement element) {
		boolean flag = false;
		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  flag;
	}

	public static boolean dragAndDrop(WebElement element, String value) {
		boolean flag = false;
		try {
			act = new Actions(driver);
			act.dragAndDrop(element, element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean mouseClick(WebElement element) {
		boolean flag = false;
		try {
			explicitWait(element, 10);
			act = new Actions(driver);
			act.click().perform();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean sleep(int sec)  throws Throwable {
		boolean flag = false;
		try {
			Thread.sleep(sec);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}




	public static boolean enterKey(WebElement element) {
		boolean flag = false;
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}

	public static String getText(WebElement element) {
		String value = null;
		try {
			explicitWait(element, 5);
			value = element.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value;
	}


	public static void selectDownIndex(WebElement element, int value) {

		try {
			sel = new Select(element);
			sel.selectByIndex(value);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void selectDownValue(WebElement element, String value) {

		try {
			sel = new Select(element);
			sel.selectByValue(value);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectDownVisible(WebElement element, String value) {
		try {
			sel = new Select(element);
			sel.selectByVisibleText(value);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getTitle() {
		String value = null;
		try {
			value = driver.getTitle();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String currenturl() {
		String value = null;
		try {
			value = driver.getCurrentUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}


	public static void getScreenShot(String screenshotName ){
		try {
			implicitWait(10);
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("./Screenshots/"+screenshotName+".png");
			FileHandler.copy(source, destination);
		}  catch (Exception e) {
			e.printStackTrace();
		}
	} 

	public static void alertNo() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jsclick(WebElement element) {
		try {
			explicitWait(element, 20);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",element);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static void frameIn(WebElement element) {
		try {
			explicitWait(element, 10);
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void frameOut() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}




