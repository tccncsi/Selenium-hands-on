import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class practice {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\mine\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.cleartrip.com/hotels");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

//		driver.findElement(By.xpath(" (//*[name()='svg'][@class=' c-pointer c-neutral-900'])[1]")).click();
		new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.xpath(" (//*[name()='svg'][@class=' c-pointer c-neutral-900'])[1]"))).click();
//		driver.findElement(By.id("prefix__flights")).click();
		driver.findElement(By.name("search")).sendKeys("New Delhi");
		driver.findElement(By.xpath("//button[@name='from'] ")).click();
		driver.findElement(By.xpath("//div[@class=\\\"DayPicker-Day DayPicker-Day--start DayPicker-Day--end DayPicker-Day--selected\\\"]")).click();
		driver.findElement(By.xpath("//button[@name='to']")).click();
		driver.findElement(By.xpath("//div[@class=\\\"p-1 day-gridContent flex flex-middle flex-column flex-center Round-trip monthEnd\\\"]")).click();

}

	private static WebDriver getWebDriver() {
		// TODO Auto-generated method stub
		return null;
	}
}