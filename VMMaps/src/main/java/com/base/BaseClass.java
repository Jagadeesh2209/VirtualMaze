package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import javax.lang.model.element.Element;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\pbrad\\eclipse-workspace\\VMMaps\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\pbrad\\eclipse-workspace\\Mavenprojectclass\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("Invalid browser");
		}
		return driver;

	}

	public static void launchUrl(String url) {

		driver.get(url);

	}

	public static void navigateTo(String url) {

		driver.navigate().to(url);

	}

	public static void navigateForward() {

		driver.navigate().forward();

	}

	public static void navigateBack() {

		driver.navigate().back();

	}

	public static void navigateRefresh() {

		driver.navigate().refresh();

	}

	public static void threadSleep(int milliSeconds) throws InterruptedException {

		Thread.sleep(milliSeconds);

	}

	public static void implicitWait(int seconds) {

		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

	}

	public static void explicitWait(WebElement element, int expectedDurationSec, String clickableOrSelectedOrPresence,
			String xPathForPresence) {

		if (clickableOrSelectedOrPresence.equalsIgnoreCase("clickable")) {

			WebDriverWait wait = new WebDriverWait(driver, expectedDurationSec);
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} else if (clickableOrSelectedOrPresence.equalsIgnoreCase("Selected")) {

			WebDriverWait wait = new WebDriverWait(driver, expectedDurationSec);
			wait.until(ExpectedConditions.elementToBeSelected(element));

		} else if (clickableOrSelectedOrPresence.equalsIgnoreCase("Presence")) {

			WebDriverWait wait = new WebDriverWait(driver, expectedDurationSec);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathForPresence)));

		}

	}

	public static void fluentWait(int withTimeOut, int pollingSeconds, String exceptionType, String xpath) {

		if (exceptionType.equalsIgnoreCase("NoSuchElement")) {

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(withTimeOut))
					.pollingEvery(Duration.ofSeconds(pollingSeconds)).ignoring(NoSuchElementException.class);

			wait.until(new Function<WebDriver, WebElement>() {

				public WebElement apply(WebDriver driver) {

					return driver.findElement(By.xpath(xpath));

				}

			});

		} else if (exceptionType.equalsIgnoreCase("ElementNotSelectable")) {

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(withTimeOut))
					.pollingEvery(Duration.ofSeconds(pollingSeconds)).ignoring(ElementNotSelectableException.class);

			wait.until(new Function<WebDriver, WebElement>() {

				public WebElement apply(WebDriver driver) {

					return driver.findElement(By.xpath(xpath));

				}

			});

		} else if (exceptionType.equalsIgnoreCase("ElementNotVisible")) {

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(withTimeOut))
					.pollingEvery(Duration.ofSeconds(pollingSeconds)).ignoring(ElementNotVisibleException.class);

			wait.until(new Function<WebDriver, WebElement>() {

				public WebElement apply(WebDriver driver) {

					return driver.findElement(By.xpath(xpath));

				}

			});

		} else {
			System.out.println("Invalid Input In FluentWait");
		}

	}

	public static List<WebElement> findElementsXpath(String elements_Xpath) {

		List<WebElement> findElements = driver.findElements(By.xpath(elements_Xpath));
		return findElements;

	}

	public static List<WebElement> findElementsId(String elements_Id) {

		List<WebElement> findElements = driver.findElements(By.id(elements_Id));
		return findElements;

	}

	public static List<WebElement> findElementsClassName(String elements_className) {

		List<WebElement> findElements = driver.findElements(By.className(elements_className));
		return findElements;

	}

	public static List<WebElement> findElementsLinkText(String elements_LinkText) {

		List<WebElement> findElements = driver.findElements(By.linkText(elements_LinkText));
		return findElements;

	}

	public static List<WebElement> findElementsName(String elements_Name) {

		List<WebElement> findElements = driver.findElements(By.name(elements_Name));
		return findElements;

	}

	public static List<WebElement> findElementsTagName(String elements_TagName) {

		List<WebElement> findElements = driver.findElements(By.tagName(elements_TagName));
		return findElements;

	}

	public static List<WebElement> findElementsPartialLinkText(String elements_PartialLinkText) {

		List<WebElement> findElements = driver.findElements(By.partialLinkText(elements_PartialLinkText));
		return findElements;

	}

	public static List<WebElement> findElementscssSelector(String elements_cssSelector) {

		List<WebElement> findElements = driver.findElements(By.cssSelector(elements_cssSelector));
		return findElements;
	}

	public static WebElement findElementXpath(String element_Xpath) {

		WebElement findElement = driver.findElement(By.xpath(element_Xpath));
		return findElement;

	}

	public static WebElement findElementId(String element_Id) {

		WebElement findElement = driver.findElement(By.id(element_Id));
		return findElement;

	}

	public static WebElement findElementClassName(String element_className) {

		WebElement findElement = driver.findElement(By.className(element_className));
		return findElement;

	}

	public static WebElement findElementLinkText(String element_LinkText) {

		WebElement findElement = driver.findElement(By.linkText(element_LinkText));
		return findElement;
	}

	public static WebElement findElementName(String element_Name) {

		WebElement findElement = driver.findElement(By.name(element_Name));
		return findElement;
	}

	public static WebElement findElementTagName(String element_TagName) {

		WebElement findElement = driver.findElement(By.tagName(element_TagName));
		return findElement;

	}

	public static WebElement findElementPartialLinkText(String element_PartialLinkText) {

		WebElement findElement = driver.findElement(By.partialLinkText(element_PartialLinkText));
		return findElement;

	}

	public static WebElement findElementcssSelector(String element_cssSelector) {

		WebElement findElement = driver.findElement(By.cssSelector(element_cssSelector));
		return findElement;

	}

	public static void click(WebElement element) {

		element.click();

	}

	public static void sendkeys(WebElement element, String sendKeys) {

		element.sendKeys(sendKeys);

	}

	public static void elementClear(WebElement element) {

		element.clear();

	}

	public static boolean checkIsDisplayed(WebElement element) {

		boolean displayed = element.isDisplayed();
		System.out.println("Is Displayed = " + displayed);
		return displayed;

	}

	public static boolean checkIsEnabled(WebElement element) {

		boolean enabled = element.isEnabled();
		System.out.println("Is Enabled = " + enabled);
		return enabled;

	}

	public static boolean checkIsSelected(WebElement element) {

		boolean selected = element.isSelected();
		System.out.println("Is Selected = " + selected);
		return selected;

	}

	public static List<WebElement> getOptions(WebElement element) {

		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		System.out.println("Options:");
		for (WebElement iterable_element : options) {
			System.out.println(iterable_element.getText());
		}
		return options;

	}

	public static void moveToElement(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();

	}

	public void contestClick() {

		Actions actions = new Actions(driver);
		actions.contextClick().build().perform();

	}

	public static void doubleClick() {

		Actions actions = new Actions(driver);
		actions.doubleClick().build().perform();

	}

	public static String getText(WebElement element) {

		String text = element.getText();
		System.out.println("Text In Element:");
		System.out.println(text);
		return text;

	}

	public static int elementsSize(List<WebElement> elements) {

		int size = elements.size();
		System.out.println("Number Of Elements:");
		System.out.println(size);
		return size;

	}

	public static String getTitle() {

		String title = driver.getTitle();
		System.out.println("Title:");
		System.out.println(title);
		return title;

	}

	public static String getCurrentUrl() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL:");
		System.out.println(currentUrl);
		return currentUrl;

	}

	public static String windowHandle() {

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window Id:");
		System.out.println(parentWindow);
		return parentWindow;

	}

	public static Set<String> windowsHandle() {

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Window Handles Id Of All Current Opened Windows:");
		for (String string : windowHandles) {
			System.out.println(string);
		}
		return windowHandles;
	}

	public static void switchWindow(String WindowUniqueId) {

		driver.switchTo().window(WindowUniqueId);

	}

	public static String getAttribute(WebElement element, String attributeName) {

		String attributevalue = element.getAttribute(attributeName);
		System.out.println("The Attribute Value of Attribute Name(" + attributeName + "):");
		System.out.println(attributevalue);
		return attributevalue;
	}

	public static boolean isMultiple(WebElement element) {

		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		System.out.println("Dropdown Is Multiple Select:" + multiple);
		return multiple;

	}

	public static void singleDropDownSelect(WebElement element, String selectByType, String dropdownToSelect) {

		Select select = new Select(element);

		if (selectByType.equalsIgnoreCase("value")) {
			select.selectByValue(dropdownToSelect);
		} else if (selectByType.equalsIgnoreCase("visibletext")) {
			select.selectByVisibleText(dropdownToSelect);
		} else if (selectByType.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(dropdownToSelect);
			select.selectByIndex(index);
		}

	}

	public static void singleDropDownDeselect(WebElement element, String deSelectByType, String dropdownToDeselect) {

		Select select = new Select(element);

		if (deSelectByType.equalsIgnoreCase("value")) {
			select.deselectByValue(dropdownToDeselect);
		} else if (deSelectByType.equalsIgnoreCase("visibletext")) {
			select.deselectByVisibleText(dropdownToDeselect);
		} else if (deSelectByType.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(dropdownToDeselect);
			select.deselectByIndex(index);
		}

	}

	public static void multipleDropdownDeselectAll(WebElement element) {

		Select select = new Select(element);
		select.deselectAll();

	}

	public static List<WebElement> getAllSelectedOptions(WebElement element) {

		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		System.out.println("All Selected Options:");
		for (WebElement webElement : allSelectedOptions) {
			String text = webElement.getText();
			System.out.println(text);
		}
		return allSelectedOptions;
	}

	public static WebElement getFirstSelectedOption(WebElement element) {

		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		System.out.println("First Selected Option:");
		String text = firstSelectedOption.getText();
		System.out.println(text);
		return firstSelectedOption;

	}

	public static void switchToSingleFrame(WebElement frameElement, String frameIdOrElement, String frameToSwitchId) {

		if (frameIdOrElement.equalsIgnoreCase("Id")) {
			driver.switchTo().frame(frameToSwitchId);
		} else if (frameIdOrElement.equalsIgnoreCase("Element")) {
			driver.switchTo().frame(frameElement);
		} else {
			System.out.println("Invalid Frame Selection");
		}

	}

	public static void switchToMultipleFrame(int frameIndex) {

		driver.switchTo().frame(frameIndex);

	}

	public static void swithToDefaultFrame() {

		driver.switchTo().defaultContent();

	}

	public static void keyboardaction(String keyPressOrKeyRelease, String key) throws AWTException {

		Robot keyboardaction = new Robot();
		if (keyPressOrKeyRelease.equalsIgnoreCase("keyPress")) {

			if (key.equalsIgnoreCase("Enter")) {
				keyboardaction.keyPress(KeyEvent.VK_ENTER);
			} else if (key.equalsIgnoreCase("Shift")) {
				keyboardaction.keyPress(KeyEvent.VK_SHIFT);
			} else if (key.equalsIgnoreCase("Control")) {
				keyboardaction.keyPress(KeyEvent.VK_CONTROL);
			} else if (key.equalsIgnoreCase("Alt")) {
				keyboardaction.keyPress(KeyEvent.VK_ALT);
			} else if (key.equalsIgnoreCase("CapsLock")) {
				keyboardaction.keyPress(KeyEvent.VK_CAPS_LOCK);
			} else if (key.equalsIgnoreCase("Up")) {
				keyboardaction.keyPress(KeyEvent.VK_UP);
			} else if (key.equalsIgnoreCase("Down")) {
				keyboardaction.keyPress(KeyEvent.VK_DOWN);
			} else if (key.equalsIgnoreCase("Left")) {
				keyboardaction.keyPress(KeyEvent.VK_LEFT);
			} else if (key.equalsIgnoreCase("Right")) {
				keyboardaction.keyPress(KeyEvent.VK_RIGHT);
			} else if (key.equalsIgnoreCase("V")) {
				keyboardaction.keyPress(KeyEvent.VK_V);
			} else if (key.equalsIgnoreCase("Tab")) {
				keyboardaction.keyPress(KeyEvent.VK_TAB);
			} else if (key.equalsIgnoreCase("C")) {
				keyboardaction.keyPress(KeyEvent.VK_C);
			} else if (key.equalsIgnoreCase("X")) {
				keyboardaction.keyPress(KeyEvent.VK_X);
			} else if (key.equalsIgnoreCase("esc")) {
				keyboardaction.keyPress(KeyEvent.VK_ESCAPE);
			} else {
				System.out.println("Invalid Key Or Key Not Included In Base");
			}

		} else if (keyPressOrKeyRelease.equalsIgnoreCase("KeyRelease")) {

			if (key.equalsIgnoreCase("Enter")) {
				keyboardaction.keyRelease(KeyEvent.VK_ENTER);
			} else if (key.equalsIgnoreCase("Shift")) {
				keyboardaction.keyRelease(KeyEvent.VK_SHIFT);
			} else if (key.equalsIgnoreCase("Control")) {
				keyboardaction.keyRelease(KeyEvent.VK_CONTROL);
			} else if (key.equalsIgnoreCase("Alt")) {
				keyboardaction.keyRelease(KeyEvent.VK_ALT);
			} else if (key.equalsIgnoreCase("CapsLock")) {
				keyboardaction.keyRelease(KeyEvent.VK_CAPS_LOCK);
			} else if (key.equalsIgnoreCase("Up")) {
				keyboardaction.keyRelease(KeyEvent.VK_UP);
			} else if (key.equalsIgnoreCase("Down")) {
				keyboardaction.keyRelease(KeyEvent.VK_DOWN);
			} else if (key.equalsIgnoreCase("Left")) {
				keyboardaction.keyRelease(KeyEvent.VK_LEFT);
			} else if (key.equalsIgnoreCase("Right")) {
				keyboardaction.keyRelease(KeyEvent.VK_RIGHT);
			} else if (key.equalsIgnoreCase("V")) {
				keyboardaction.keyRelease(KeyEvent.VK_V);
			} else if (key.equalsIgnoreCase("Tab")) {
				keyboardaction.keyRelease(KeyEvent.VK_TAB);
			} else if (key.equalsIgnoreCase("C")) {
				keyboardaction.keyRelease(KeyEvent.VK_C);
			} else if (key.equalsIgnoreCase("X")) {
				keyboardaction.keyRelease(KeyEvent.VK_X);
			} else if (key.equalsIgnoreCase("esc")) {
				keyboardaction.keyRelease(KeyEvent.VK_ESCAPE);
			} else {
				System.out.println("Invalid Key Or Key Not Included In Base");
			}

		} else {
			System.out.println("Wrong Input In String Value keyPressOrKeyRelease");
		}
	}

	public static void alerts(String handleAlertBy, String alertInput) {

		Alert alert = driver.switchTo().alert();
		if (handleAlertBy.equalsIgnoreCase("Accept")) {
			alert.accept();
		} else if (handleAlertBy.equalsIgnoreCase("Dismiss")) {
			alert.dismiss();
		} else if (handleAlertBy.equalsIgnoreCase("SendKeys")) {
			alert.sendKeys(alertInput);
		} else {
			System.out.println("Invalid Alert Action");
		}

	}

	public static void scanner(String nextOrNextLine) {

		Scanner scanner = new Scanner(System.in);

		if (nextOrNextLine.equalsIgnoreCase("next")) {
			String scan = scanner.next();
		} else if (nextOrNextLine.equalsIgnoreCase("NextLine")) {
			String scan = scanner.next();
			scan = scan + scanner.nextLine();
		} else {
			System.out.println("Invalid Scan");
		}

	}

	public static void scrollIntoView(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public static void scrollTo(String scrollside, String axis_X_Y_Locate) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (scrollside.equalsIgnoreCase("Xaxis")) {
			js.executeScript("window.scroll" + axis_X_Y_Locate, "");
		} else if (scrollside.equalsIgnoreCase("Yaxis")) {
			js.executeScript("", "window.scroll" + axis_X_Y_Locate);
		}

	}

	public static File printScreen(String filename) throws IOException {

		TakesScreenshot tss = (TakesScreenshot) driver;
		File source = tss.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\pbrad\\eclipse-workspace\\Mavenprojectclass\\screenshots\\" + filename + ".png");
		FileUtils.copyFile(source, destination);
		return source;
	}

	public static void closeBrowser() {

		driver.close();

	}

	public static void quitBrowser() {

		driver.quit();

	}

}
