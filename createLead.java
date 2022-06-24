package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("Demosalesmanager");
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys("crmsfa");
		WebElement login = driver.findElementByClassName("decorativeSubmit");
		login.click();
		driver.findElementByLinkText("CRM/SFA").click();
		WebElement leadsClick = driver.findElementByLinkText("Leads");
		leadsClick.click();
		driver.findElementByLinkText("Create Lead").click();
		WebElement className = driver.findElement(By.id("createLeadForm_companyName"));
		className.sendKeys("Infosys");
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.sendKeys("RamKumar");
		WebElement lastName = driver.findElement(By.id("createLeadForm_lastName"));
		lastName.sendKeys("s");
		driver.findElement(By.name("departmentName")).sendKeys("Healthcare");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Ramscorpio321@gmail.com");
		driver.findElement(By.name("description")).sendKeys(
				"A key role within the testing center excellence, the roles and responsibilities of automation tester include automating the test effort as much as possible.");
		Select stateName = new Select(driver.findElement(By.name("generalStateProvinceGeoId")));
		stateName.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
