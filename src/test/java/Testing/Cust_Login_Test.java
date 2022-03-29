package Testing;

import Pages.Cust_Login_Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Pages.Cust_Login_Page;


public class Cust_Login_Test extends Bank_Login_Test
{
    Cust_Login_Page Customer;

    public Cust_Login_Test()
    {
        Customer = new Cust_Login_Page();
    }
    @Test(priority = 7)
    public void validateClickCustomerLogin()
            throws InterruptedException
    {
        Customer.clickCustomerLogin();
    }
    @Test(priority = 8 )
    public void validateSelectCustomer()
            throws InterruptedException
    {
        Customer.selectCustomerLoginName();
    }
    @Test(priority = 9)
    public void validateSelectDeposit()
            throws InterruptedException
    {
        Customer.selectDeposit();
    }
    @Test(priority = 10)
    public void validateSelectWithdraw()
            throws InterruptedException
    {
        Customer.selectWithdraw();
    }
    @Test(priority = 11)
    public void validateExceedAmount()
            throws InterruptedException
    {
        Customer.exceedMountDraw();
    }
    @Test(priority = 12)
    public void validateVerifyTransac()
            throws InterruptedException
    {
        Customer.verifyTransactions();
    }
    @AfterTest
    public void exit()
    {
        driver.quit();
    }

}