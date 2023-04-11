package SKCET.Day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 {
	public static void main(String args[]) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		WebElement cid = driver.findElement(By.xpath("//*[@name=\"cusid\"]"));
		cid.sendKeys("401");
		WebElement idsub = driver.findElement(By.xpath("//*[@name=\"submit\"]"));
		idsub.click();
		Thread.sleep(1000);
//		driver.switchTo().alert().dismiss()/;
		Alert alert1 = driver.switchTo().alert();
		alert1.dismiss();
		cid.clear();
		
		cid.sendKeys("402");
		idsub.click();
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();

		Alert alert3 = driver.switchTo().alert();
		String str = alert3.getText();
		alert3.accept();
		System.out.println(str);
		
	}
}
