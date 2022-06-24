package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/checkbox.html");
		driver.findElement(By.xpath("//div[@id=\"contentblock\"]//div[1]//input[1]")).click();
		driver.findElement(By.xpath("//div[@id=\"contentblock\"]//div[1]//input[3]")).click();
		WebElement seleniumIsChecked=driver.findElement(By.xpath("//div[@id=\"contentblock\"]//div[2]//input[1]"));
		System.out.println(seleniumIsChecked.isEnabled());
		WebElement deselect=driver.findElement(By.xpath("//div[@id=\"contentblock\"]//div[3]//input[2]"));
		deselect.click();
		List<WebElement> selectAll=driver.findElementsByXPath("//div[@id=\"contentblock\"]//div[4]//input");
		int size=selectAll.size();
		System.out.println(size);
		for(int i=0;i<size;i++)
		{
			selectAll.get(i).click();
		}
		
		

	}

}
