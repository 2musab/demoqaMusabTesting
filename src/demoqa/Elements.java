package demoqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Elements extends Parameters {

	@BeforeTest
	public void mySetup() {

		driver.get("https://demoqa.com/");

	}

	@Test(priority = 1, enabled = false)
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

	}

	@Test(priority = 2)
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
		
		Thread.sleep(5000);
		
		boolean actualResult = driver.findElement(By.id("result")).getText().contains("selected");
		
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, true);
	}

}
