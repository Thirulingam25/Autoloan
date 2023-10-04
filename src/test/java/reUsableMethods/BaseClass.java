package reUsableMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebElement element;
    public static String value = "";
    public static String url = "";
    
    
    public static void launchChrome(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);

	}
    
    public static void launchEdge(String url) {
    	WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new EdgeDriver(options); 
		driver.get(url);
    }

    
    public static void doWindowMaximize() {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doSendKeys(String xpath, String name) {
		try {
			element = driver.findElement(By.xpath(xpath));
			element.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doClickAndSendKeys(String xpath, String name) {
		try {
			element = driver.findElement(By.xpath(xpath));
			element.click();
			element.sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doClick(String xpath) {
    	try {
			element = driver.findElement(By.xpath(xpath));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doFrameSwitchByIndex(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doFrameSwitchByNameId(String id) {
		try {
			driver.switchTo().frame(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doFrameSwitch(WebElement frameElement) {
		try {
			driver.switchTo().frame(frameElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doSwitchToDefault() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doWebHandle(int index) {
		try {
			String parentid = driver.getWindowHandle();
			Set<String> allwindows = driver.getWindowHandles();
			List<String> list = new ArrayList<>(allwindows);
			System.out.println(list);
			driver.switchTo().window(list.get(index));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doDoubleClick(String xpath) {
		try {
			element = driver.findElement(By.xpath(xpath));
			Actions a = new Actions(driver);
			a.doubleClick(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doContextClick(String xpath) {
		try {
			element = driver.findElement(By.xpath(xpath));
			Actions a = new Actions(driver);
			a.contextClick(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doMouseOver(String xpath) {
		try {
			element = driver.findElement(By.xpath(xpath));
			Actions a = new Actions(driver);
			a.moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doDragAndDrop(WebElement sc, WebElement tg) {
		try {
			Actions a = new Actions(driver);
			a.dragAndDrop(sc, tg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doSingleClick(int key) throws AWTException {
		try {
			Robot r = new Robot();
			r.keyPress(key);
			r.keyRelease(key);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
    
    public static void doDoubleClick(int key1, int key2) throws AWTException {
		try {
			Robot r = new Robot();
			r.keyPress(key1);
			r.keyPress(key2);
			r.keyRelease(key2);
			r.keyRelease(key1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
    
    public static void doDropDownSelectByIndex(String xpath, int index) {
		try {
			element = driver.findElement(By.xpath(xpath));
			Select s = new Select(element);
			s.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doDropDownSelectByValue(String xpath, String value) {
    	try {
			element = driver.findElement(By.xpath(xpath));
			Select s = new Select(element);
			s.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doDropDownSelectByVisibleText(String xpath, String value) {
    	try {
			element = driver.findElement(By.xpath(xpath));
			Select s = new Select(element);
			s.selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doDeselectAll(String xpath) {
    	try {
			element = driver.findElement(By.xpath(xpath));
			Select s = new Select(element);
			s.deselectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doDropDownDeSelectByIndex(String xpath, int index) {
    	try {
			element = driver.findElement(By.xpath(xpath));
			Select s = new Select(element);
			s.deselectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doDropDownDeSelectByValue(String xpath, String value) {
    	try {
			element = driver.findElement(By.xpath(xpath));
			Select s = new Select(element);
			s.deselectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doDropDownDeSelectByVisibleText(String xpath, String value) {
    	try {
			element = driver.findElement(By.xpath(xpath));
			Select s = new Select(element);
			s.deselectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doScreenShot(String name, String extension) {
		try {
			TakesScreenshot ss = (TakesScreenshot) driver;
			File temp = ss.getScreenshotAs(OutputType.FILE);
			File perm = new File(
					"C://Users//sivaraam.t//eclipse-workspace//sampleProject//IbpsScreenShot//" + name + "." + extension);
			FileUtils.copyFile(temp, perm);
		
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}
    
    public static void doWebhandles(int num) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> list = new ArrayList<>(allWindows);
			System.out.println(list);
			driver.switchTo().window(list.get(num));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void doThreadSleep(int timeInSeconds)  {
		try {
			Thread.sleep(timeInSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
    public static void doAcceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static String getProperty(String Key, String path) {
		try {
			FileReader reader = new FileReader(path);
			Properties p = new Properties();
			p.load(reader);
			value = p.getProperty(Key);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
		

	}
    
    public static void setProperty(String path, String key, String value, String comments) throws Exception {
		try {
			Properties p = new Properties();
			p.put(key, value);
			FileOutputStream reader = new FileOutputStream(path);
			p.store(reader, comments);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
    public static void doImplicitWait(int time) {
    	driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
    }
    
    public static void fluentWaitByXpath(String xpath) {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(Duration.ofSeconds(30))
			    .pollingEvery(Duration.ofSeconds((long) 0.25))
			    .ignoring(Exception.class);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    
    public static void fluentWait(String id) {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(Duration.ofSeconds(30))
			    .pollingEvery(Duration.ofSeconds((long) 0.25))
			    .ignoring(Exception.class);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(id)));
    }
    
    public static void dropDownSelectInInputTag(String xpath,int count)  {
    	try {
			driver.findElement(By.xpath(xpath)).click();
			Thread.sleep(5000);
			for(int i=1;i<count;i++) {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(5000);
			}
			Robot r = new Robot();
			Thread.sleep(5000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void doClear(String xpath) {
    	element = driver.findElement(By.xpath(xpath));
    	element.clear();
    }
    
    public static String getText(String xpath) {
        String text = driver.findElement(By.xpath(xpath)).getText();
        return text;
    }
    
    public static void simpleDatePick(WebElement element,String mmyyy,String dd,List<WebElement> elements,WebElement title,WebElement button,WebElement title2) throws InterruptedException {
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String text4 = title.getText();
        while (mmyyy!=text4) {
        	button.click();
            String text5= title2.getText();
            if (mmyyy.equalsIgnoreCase(text5)) {
            	break;
                        }
        }
        for (int i = 0; i <=elements.size(); i++) {
        	WebElement date = elements.get(i);
        	String text3 = date.getText();
            if (text3.equalsIgnoreCase(dd)) {
             date.click();
              }
        	}

    }
    public static void documentUploadfromSystem(String fileLocation) throws Exception {
    	Robot robot = new Robot();
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection filepath = new StringSelection(fileLocation);
        systemClipboard.setContents(filepath, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
