package week2.day2;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyperlink {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Go to Home Page")).click();
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Find where am supposed to go without clicking me?")).sendKeys(Keys.ENTER);
		driver.navigate().back();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total links are "+ links.size());
		for(int i=0;i<links.size();i++)
		{
			WebElement element=links.get(i);
			String url=element.getAttribute("href");
			verifyLinkActive(url);
		}
		
		driver.findElement(By.partialLinkText("Go to Home Page")).click();
		driver.navigate().back();
		System.out.println("Total links are "+ links.size());
	}
		public static void verifyLinkActive(String linkUrl)
		{
	        try 
	        {
	           URL url = new URL(linkUrl);
	           
	           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	           
	           httpURLConnect.setConnectTimeout(3000);
	           
	           httpURLConnect.connect();
	           
	           if(httpURLConnect.getResponseCode()==200)
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	            }
	          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	            }
	        } catch (Exception e) {
	           
	        }
	    } 
		
		
		 

	
	 
		
		
		

	}


