package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver merge=new ChromeDriver();
		merge.get("http://leaftaps.com/opentaps/control/login");
		merge.manage().window().maximize();
		merge.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		
	merge.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
	merge.findElement(By.xpath("//input[@id=\'password\']")).sendKeys("crmsfa");
	merge.findElement(By.xpath("//input[@class=\'decorativeSubmit\']")).click();
	merge.findElement(By.xpath("//a[contains(text(),'CRM/')]")).click();
	merge.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
	merge.findElement(By.xpath("//a[text()=\"Merge Contacts\"]")).click();
 merge.findElement(By.xpath("//table[@class=\"twoColumnForm\"]/tbody/tr[1]/td[2]/a/img")).click();

 
 Set<String> windowSet = merge.getWindowHandles();
 ArrayList<String> windowList=new ArrayList<String>(windowSet);
WebDriver window = merge.switchTo().window(windowList.get(1));
System.out.println("The title of the windows is:"+ window.getTitle());
merge.findElement(By.xpath("//a[text()=\"12719\"]")).click();

merge.switchTo().window(windowList.get(0));

merge.findElement(By.xpath("//table[@class=\"twoColumnForm\"]/tbody/tr[2]/td[2]/a/img")).click();
Set<String> windowSet2 = merge.getWindowHandles();
ArrayList<String> windowList2=new ArrayList<String>(windowSet2);
merge.switchTo().window(windowList2.get(1));
merge.findElement(By.xpath("//a[@class='linktext'][1]")).click();
merge.switchTo().window(windowList2.get(0));

merge.findElement(By.xpath("//a[text()=\"Merge\"]")).click();

Alert alert1 = merge.switchTo().alert();
alert1.accept();

	}

}
