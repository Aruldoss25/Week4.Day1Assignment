package week4.day1.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunWithFrame {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver frame=new ChromeDriver();
		frame.get("http://leafground.com/pages/frame.html");
		frame.manage().window().maximize();
		frame.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		
		WebElement frame1 = frame.findElement(By.xpath("//iframe[@src=\"default.html\"]"));
		frame.switchTo().frame(frame1);
		frame.findElement(By.xpath("//button[@id=\"Click\"]")).click();
		
		frame.switchTo().defaultContent();
		
		WebElement frame2 = frame.findElement(By.xpath("//iframe[@src=\"page.html\"]"));
		frame.switchTo().frame(frame2);
		
		WebElement frame3 = frame.findElement(By.xpath("//iframe[@src=\"nested.html\"]"));
		frame.switchTo().frame(frame3);
		
		frame.findElement(By.xpath("//button[@id=\"Click1\"]")).click();
		
		frame.switchTo().defaultContent();
		
		List<WebElement> tag = frame.findElements(By.tagName("iframe"));
		System.out.println("The frames in the page is : "+ tag.size());
		
		
	
		
		
	}

}
