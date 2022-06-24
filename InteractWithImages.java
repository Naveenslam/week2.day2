package week2.day2;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithImages {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
	verifyBrokenImages();  
	}
		public static void verifyBrokenImages() throws Exception 
		{
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver =new ChromeDriver();
			driver.get("http://www.leafground.com/pages/Image.html");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img")).click();
			driver.navigate().back();
			Thread.sleep(5000);
			List<WebElement>images=driver.findElementsByTagName("img");
			System.out.println(images.size());
	       for (WebElement img : images) {
			
	    	   String imgsrc=img.getAttribute("src");
	    	   try {
				URL url=new URL(imgsrc);
				   URLConnection urlConnection=url.openConnection();
				   HttpURLConnection httpUrl=(HttpURLConnection) urlConnection;
				   httpUrl.setConnectTimeout(7000);
				   httpUrl.connect();
				   if(httpUrl.getResponseCode()==200)
				   {
					   System.out.println(imgsrc + " "+ httpUrl.getResponseCode() + " " +httpUrl.getResponseMessage());
				   }
					   else
					   {
						   System.err.println(imgsrc + " "+ httpUrl.getResponseCode() + " " +httpUrl.getResponseMessage());
						   
						   httpUrl.disconnect();
				   }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(imgsrc);
			}
	       }  
	       //to click an image from keyboard
	       Actions action = new Actions(driver); 
	       WebElement perform  = driver.findElement(By.xpath("//div[@class='example'][3]//div/div/img"));
	       action.click(perform).perform();
	      
	       //using click action method
	       driver.close();
		}
	}
	    	   
		
			
		
     		
		   
	       
		
		
		

		