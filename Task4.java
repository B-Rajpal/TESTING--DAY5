package SKCET.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 {
	public static void main(String args[]) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		
		driver.get("https://www.abhibus.com/bus-ticket-booking");
		WebElement source = driver.findElement(By.xpath("//*[@id=\"source\"]"));
		WebElement destination = driver.findElement(By.xpath("//*[@id=\"destination\"]"));
		source.sendKeys("Chennai"+Keys.ENTER);
		destination.sendKeys("Coimbatore"+Keys.ENTER);
		WebElement date = driver.findElement(By.xpath("//*[@id=\"datepicker1\"]"));
		
//		
//		date.click();
//		WebElement date1 = driver.findElement(By.xpath("//a[text()=17]"));
//		date1.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','17/04/2023')", date);
		
		}
}
