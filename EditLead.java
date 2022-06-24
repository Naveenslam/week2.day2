package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByPartialLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Infosys");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("RamKumar");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("s");
		driver.findElement(By.name("firstNameLocal")).sendKeys("manikandan");
		driver.findElement(By.name("departmentName")).sendKeys("Healthcare");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Ramslami321@gmail.com");
		driver.findElement(By.name("description")).sendKeys("Previous work experience as a automation test engineer ");
		Select stateName = new Select(driver.findElement(By.name("generalStateProvinceGeoId")));
		stateName.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElementByPartialLinkText("Edit").click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.name("importantNote")).sendKeys("Project management skills");
		driver.findElement(By.name("submitButton")).click();
		System.out.println(driver.getTitle());
		driver.close();
		

	}

}
