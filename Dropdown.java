package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		Select dropDown1 = new Select(driver.findElement(By.id("dropdown1")));
		dropDown1.selectByIndex(1);
		Select dropDown2 = new Select(driver.findElement(By.name("dropdown2")));
		dropDown2.selectByVisibleText("Appium");
		Select dropDown3 = new Select(driver.findElement(By.id("dropdown3")));
		dropDown3.selectByValue("3");
		Select dropDown4 = new Select(driver.findElement(By.className("dropdown")));
		List<WebElement> allDropDown4 = dropDown4.getOptions();
		System.out.println(allDropDown4.size());
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select")).sendKeys("Loadrunner");
		Select dropDown5 = new Select(driver.findElement(By.xpath("//div[@class='example'][6]//select")));
		dropDown5.selectByValue("4");
		driver.close();

	}

}
