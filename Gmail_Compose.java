package Basic;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail_Compose {

		public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", "path for Chrome Driver");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.gmail.com");
			//Email address
			driver.findElement(By.xpath("//input[@id='identifierId'][@type='email']")).sendKeys("User mail id");
		    driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
			
			//Password
			WebElement passwordButton = driver.findElement(By.xpath("//input[@name='password'][@type='password']"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
			passwordButton.sendKeys("Password for Email");
			driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
			
			//Click on Compose button
			driver.findElement(By.xpath("//div[text()='Compose']")).click();
			
			//Enter the Sender email id
			driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("Sender e-mail id");
			//Enter Subject to the email
			driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Testing");
			//Enter Email Body to the email
			driver.findElement(By.xpath("//div[contains(@class,'Am Al editable LW-avf tS-tW')][contains(@aria-label,'Message Body')]")).sendKeys("Selenium script to send mail");
			
			//Attach the full path of file
			driver.findElement(By.xpath("//input[@name='Filedata']")).sendKeys("D:\\Selenium\testing.txt");
			driver.findElement(By.xpath("//div[text()='Send']")).click();
		}
	}
}
