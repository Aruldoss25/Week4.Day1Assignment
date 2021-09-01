package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver service=new ChromeDriver();
		service.get("https://dev113545.service-now.com/");
		service.manage().window().maximize();
		service.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		
		
		service.switchTo().frame("gsft_main");
		service.findElement(By.id("user_name")).sendKeys("admin");
		service.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
		service.findElement(By.id("sysverb_login")).click();
		WebElement findElement = service.findElement(By.id("filter"));
		findElement.sendKeys("incident");
		findElement.click();
		Thread.sleep(2000);
		
		service.findElement(By.xpath("//li[@id=\"concourse_module_b55b4ab0c0a80009007a9c0f03fb4da9\"]/div/div/a/div/div")).click();
		Thread.sleep(2000);
		
		service.switchTo().frame("gsft_main");
		service.findElement(By.xpath("//button[text()=\"New\"]")).click();
		service.findElement(By.xpath("//span[@class=\"icon icon-search\"][1]")).click();
		
		String incidentNum = service.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident No : " + incidentNum);
		
		Set<String> windowSet=service.getWindowHandles();
		List<String> windowList= new ArrayList<String>(windowSet);
		
		service.switchTo().window(windowList.get(1));
		service.findElement(By.xpath("//a[text()=\"Abraham Lincoln\"]")).click();
		WebDriver tit = service.switchTo().window(windowList.get(0));
		String t=tit.getTitle();
		System.out.println("The title of the page is :" +t);
		Thread.sleep(2000);
		
		service.switchTo().frame("gsft_main");
		service.findElement(By.xpath("//input[@id=\"incident.short_description\"]")).sendKeys("hi");
		
		service.findElement(By.xpath("//button[text()=\"Submit\"][1]")).click();
		
		WebElement selectWebElememt = service.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn1 = new Select(selectWebElememt);
		drpdwn1.selectByValue("number");
		
		WebElement incidentSearchElement = service.findElement(By.xpath("//input[@class='form-control']"));
		incidentSearchElement.sendKeys(incidentNum);
		incidentSearchElement.sendKeys(Keys.ENTER);
		
		WebElement incidentNum1 = service.findElement(By.xpath("//div[@class='vcr_controls']//span"));
		String rowValue = incidentNum1.getText();
		System.out.println("Incident displayed after searching : " + rowValue);
		if (rowValue.contains("Showing rows 1 ")) {
			System.out.println("Incident created successfully");
		} else
			System.out.println("Incident not created");

		File pic = service.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snap/ServiceNow.png");
		FileUtils.copyFile(pic, dst);
	}
		
		
		
		
	

}


