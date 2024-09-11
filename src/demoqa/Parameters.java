package demoqa;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Parameters {

	WebDriver driver = new ChromeDriver();
	Random rand = new Random();

	String[] femaleNames = { "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Mia", "Charlotte", "Amelia", "Harper",
			"Evelyn" };

	String[] maleNames = { "Liam", "Noah", "Oliver", "Elijah", "James", "William", "Benjamin", "Lucas", "Henry",
			"Alexander" };

	String[] lastNames = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore",
			"Taylor" };

	int femaleNamesLength = femaleNames.length;
	int randomFemaleName = rand.nextInt(femaleNamesLength);
	String fName = femaleNames[randomFemaleName];

	int maleNamesLength = maleNames.length;
	int randomMaleName = rand.nextInt(maleNamesLength);
	String mName = maleNames[randomMaleName];

	int lastNamesLength = lastNames.length;
	int randomLastName = rand.nextInt(lastNamesLength);
	String surName = lastNames[randomLastName];
	
	Actions action = new Actions(driver);
	Actions right = new Actions(driver);
	

}
