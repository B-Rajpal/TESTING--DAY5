package SKCET.Day5;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task5 {
	public static void main(String args[]) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("apple",Keys.ENTER);
	
		
		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenieum",Keys.ENTER);
		
		
		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Cucumber",Keys.ENTER);
		
		Set<String> s= driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		
		while(I1.hasNext()) {
			String child = I1.next();
			driver.switchTo().window(child);
			System.out.println(driver.getWindowHandle()+" "+driver.getTitle());
		}
		System.out.println("No of tabs opened : "+s.size());
		
		
	}
}
