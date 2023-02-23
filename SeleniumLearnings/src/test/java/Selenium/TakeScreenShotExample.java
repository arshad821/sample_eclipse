package Selenium;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShotExample {

	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//take screenshot code
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("C:\\Users\\2143925\\OneDrive - Cognizant\\Desktop\\Screenshot\\screenshot.png");
		FileHandler.copy(sourcefile, destinationfile);

		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/button")).click();
		

		//to take full size screen shot
		
		Robot robot= new Robot();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(screensize);
		BufferedImage sourcefile1 =	robot.createScreenCapture(rectangle);
		File destfile = new File("C:\\Users\\2143925\\OneDrive - Cognizant\\Desktop\\Screenshot\\screenshot1.png");
		ImageIO.write(sourcefile1, "png", destfile);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.quit();

	}

}
