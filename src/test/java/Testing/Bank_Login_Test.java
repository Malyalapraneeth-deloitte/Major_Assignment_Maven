package Testing;
import Pages.Driver_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.Bank_Login;
import java.io.IOException;


public class Bank_Login_Test extends Driver_Class {

    Bank_Login ManagerLogin;

    @BeforeTest
    public void setUp() throws IOException {
      driverCreation();
        ManagerLogin = new Bank_Login(super.driver);

    }

    @Test(priority = 1)
    public void validateBankMangerClick() {
        try {
            ManagerLogin.BankClick();
        } catch (Exception e) {
            System.out.println("opening manager bank is failed");
        }
    }

    @Test(priority = 2)
    public void validateAddCustomer() {
        try {
            ManagerLogin.enterFirstname();
            ManagerLogin.enterLastname();
            ManagerLogin.enterPin();
        } catch (Exception e) {
            System.out.println("adding to input data field is failed");

        }
    }

    @Test(priority = 3)
    public void validateADD() {
        try {
            ManagerLogin.clickAdd();
        } catch (Exception e) {
            System.out.println("adding customer details is failed");
        }
    }

    @Test(priority = 4)
    public void validateConfirmAdd() {
        try {
            ManagerLogin.confirmAdd();
        } catch (Exception e) {
            System.out.println("confirmation is failed");
        }
    }

    @Test(priority = 5)
    public void validateOpenCustomer() {
        try {
            ManagerLogin.openCustomer();
        } catch (Exception e) {
            System.out.println("open account button is failed");
        }
    }

    @Test(priority = 6)
    public void validateSelect() {
        try {
            ManagerLogin.selectCustomer();
            ManagerLogin.selectCurreny();
            ManagerLogin.process();
        } catch (Exception e) {
            System.out.println("selection is failed");
        }

    }
}
