package week4.day1.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver frame=new ChromeDriver();
		frame.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		frame.manage().window().maximize();
		frame.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		
	WebElement farme = frame.findElement(By.xpath("//iframe[@id=\"frame1\"]"));
	frame.switchTo().frame(farme);
    frame.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Hi Hello");
		
	
    WebElement farme1 = frame.findElement(By.xpath("//iframe[@id=\"frame3\"]"));
    frame.switchTo().frame(farme1);
    
    frame.findElement(By.xpath("//input[@id=\"a\"]")).click();
    
   frame.switchTo().defaultContent();
   
   WebElement farme2 = frame.findElement(By.xpath("//iframe[@id=\"frame2\"]"));
   frame.switchTo().frame(farme2);
   
   WebElement drop = frame.findElement(By.id("animals"));
   Select dropDown=new Select(drop);
dropDown.selectByValue("babycat");
	}

}
