package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		WebElement radio1 = driver.findElement(By.id("yes"));
		WebElement radio2 = driver.findElement(By.id("no"));
		radio1.click();
		System.out.println(radio1.isSelected());
		WebElement defaultRadio2 = driver
				.findElement(By.xpath("//div[@class=\"example\"][2]/div/div/input[@value='1']"));
		System.out.println(defaultRadio2.isSelected());
		WebElement defaultRadio1 = driver
				.findElement(By.xpath("//div[@class=\"example\"][2]/div/div/input[@value='0']"));
		System.out.println(defaultRadio1.isSelected());
		WebElement isChecked = driver
				.findElement(By.xpath("//div[@class=\"example\"][3]//div//div/input[contains(text(),checked)][2]"));
		System.out.println(isChecked.isSelected());

	}

}
