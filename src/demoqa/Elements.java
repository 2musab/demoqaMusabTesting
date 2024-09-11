package demoqa;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Elements extends Parameters {

	@BeforeTest
	public void mySetup() {

		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(enabled = false)
	public void textArea() {

		driver.get("https://demoqa.com/text-box");

		WebElement userName = driver.findElement(By.id("userName"));
		userName.sendKeys(mName + " " + surName);

		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys(mName + surName + "@gmail.com");

		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("Amman, Shafa Badran");

		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
		permanentAddress.sendKeys("Al Riyadh, Namoothajiya");

		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();

		WebElement name = driver.findElement(By.id("name"));

		boolean actaulText = name.getText().contains("Name");

		Assert.assertEquals(actaulText, true);
	}

	@Test(enabled = false)
	public void checkBox() throws InterruptedException {

		driver.get("https://demoqa.com/checkbox");

		WebElement Home = driver.findElement(By.tagName("ol"));

		WebElement homeButton = Home.findElement(By.cssSelector("button[title='Toggle']"));
		homeButton.click();

		WebElement documentsButton = driver
				.findElement(By.cssSelector("li:nth-child(2) span:nth-child(1) button:nth-child(1)"));
		documentsButton.click();

		WebElement officeCheck = driver
				.findElement(By.cssSelector("label[for='tree-node-office'] span[class='rct-checkbox']"));
		officeCheck.click();

		boolean actualResult = driver.findElement(By.id("result")).getText().contains("selected");

		System.out.println(actualResult);
		Assert.assertEquals(actualResult, true);
	}

	@Test(enabled = false)
	public void webtables() throws InterruptedException {

		driver.get("https://demoqa.com/webtables");

		WebElement add = driver.findElement(By.id("addNewRecordButton"));
		add.click();

		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys(mName);

		WebElement LastName = driver.findElement(By.id("lastName"));
		LastName.sendKeys(surName);

		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys(mName + surName + "@gmail.com");

		WebElement age = driver.findElement(By.id("age"));
		age.sendKeys("36");

		WebElement salary = driver.findElement(By.id("salary"));
		salary.sendKeys("350");

		WebElement dept = driver.findElement(By.id("department"));
		dept.sendKeys("IT");

		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();

		System.out.println("Name : " + mName + " " + surName);
		System.out.println("Email : " + mName + surName + "@gmail.com");

		WebElement container = driver
				.findElement(By.cssSelector("div[class='rt-tr -even'] div[class='action-buttons']"));
		WebElement delete = container.findElement(By.id("delete-record-2"));
		delete.click();

	}

	@Test(invocationCount = 10)
	public void click() throws InterruptedException {

		driver.get("https://demoqa.com/buttons");

		Actions action = new Actions(driver);
		WebElement DoubleClick = driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(DoubleClick).perform();

		WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
		action.contextClick(rightClick).perform();

		WebElement dynamic = driver
				.findElement(By.cssSelector("div[class='col-12 mt-4 col-md-6'] div div:nth-child(4)"));
		List<WebElement> dynamicClickList = dynamic.findElements(By.tagName("button"));
		String id = dynamicClickList.getLast().getAttribute("id");

		System.out.println(id);

		WebElement dynamicId = driver.findElement(By.id(id));

		dynamicId.click();

	}

	@Test(enabled = false)
	public void radio() {

		driver.get("https://demoqa.com/radio-button");

		WebElement impressive = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
		impressive.click();

		String actualRadio = driver.findElement(By.cssSelector(".mt-3")).getText();
		String expectedRadio = "You have selected Impressive";

		Assert.assertEquals(actualRadio, expectedRadio);
	}

	@Test(enabled = false)
	public void dyanamic() throws InterruptedException {

		driver.get("https://demoqa.com/dynamic-properties");

		WebElement enabledButton = driver.findElement(By.id("enableAfter"));
		Thread.sleep(5000);
		enabledButton.click();

	}

}