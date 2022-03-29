package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver_Class {
    public static WebDriver driver;

    public void driverCreation()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\malpraneeth\\Documents\\chromedriver.exe");
        String url="https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }


}