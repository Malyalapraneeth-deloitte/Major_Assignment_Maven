package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Cust_Login_Page extends Driver_Class  {


    public void clickCustomerLogin() throws InterruptedException {
        WebElement loginElement = driver.findElement(By.xpath("//button[@ng-click='customer()']"));
        loginElement.click();
        Thread.sleep(2000);
    }
    public void selectCustomerLoginName() throws InterruptedException {
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='userSelect']"));
        Select objSelect = new Select(selectElement);
        objSelect.selectByVisibleText("Malyala Sai Praneeth");
        Thread.sleep(2000);
        WebElement ClickLogin = driver.findElement(By.xpath("//button[text()='Login']"));
        ClickLogin.click();
        Thread.sleep(2000);
    }
    public void selectDeposit() throws InterruptedException {
        WebElement selctDeposit = driver.findElement(By.xpath("//button[@ng-click='deposit()']"));
        selctDeposit.click();
        Thread.sleep(2000);
        String actualBalance = driver.findElement(By.xpath("//div[@ng-hide='noAccount']/strong[2]")).getText();
        WebElement addDep = driver.findElement(By.xpath("//input[@placeholder='amount']"));
        addDep.sendKeys("1000");
        Thread.sleep(2000);
        WebElement addAmount = driver.findElement(By.xpath("//button[text()='Deposit']"));
        addAmount.click();
        Thread.sleep(2000);
        boolean showMessageDeposit = driver.findElement(By.xpath("//span[text()='Deposit Successful']")).isDisplayed();
        if (showMessageDeposit) {
            System.out.println("Amount Deposit Done Successfully");
        }
        String afterBal = driver.findElement(By.xpath("//div[@ng-hide='noAccount']/strong[2]")).getText();
        int actualB = Integer.parseInt(actualBalance);
        int afterB = Integer.parseInt(afterBal);
        if(afterB ==(actualB+1000)){
            System.out.println(" deposited Amount updated successfully");
        }
    }
    public void selectWithdraw() throws InterruptedException {
        WebElement selctWDraw = driver.findElement(By.xpath("//button[@ng-click='withdrawl()']"));
        selctWDraw.click();
        Thread.sleep(2000);
        String actualBal = driver.findElement(By.xpath("//div[@ng-hide='noAccount']/strong[2]")).getText();
        WebElement withDrawl = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
        withDrawl.sendKeys("500");
        Thread.sleep(2000);
        WebElement clickWDraw = driver.findElement(By.xpath("//button[text()='Withdraw']"));
        clickWDraw.click();
        Thread.sleep(2000);
        boolean showMessageWithdraw = driver.findElement(By.xpath("//span[text()='Transaction successful']")).isDisplayed();
        String text = driver.findElement(By.xpath("//span[text()='Transaction successful']")).getText();
        if (showMessageWithdraw) {
            System.out.println(text);
        }
        String afterBal = driver.findElement(By.xpath("//div[@ng-hide='noAccount']/strong[2]")).getText();
        int actualB = Integer.parseInt(actualBal);
        int afterB = Integer.parseInt(afterBal);
        if(afterB ==(actualB-500)){
            System.out.println(" withdraw of amount updated successfully");
        }
    }
    public void exceedMountDraw() throws InterruptedException {
        WebElement exceedDraw = driver.findElement(By.xpath("//input[@placeholder='amount']"));
        exceedDraw.sendKeys("800");
        Thread.sleep(2000);
        WebElement exceedWithdraw = driver.findElement(By.xpath("//button[text()='Withdraw']"));
        exceedWithdraw.click();
        Thread.sleep(2000);
        boolean withdraw = driver.findElement(By.xpath("//span[text()='Transaction Failed. You can not withdraw amount more than the balance.']")).isDisplayed();
        String text = driver.findElement(By.xpath("//span[text()='Transaction Failed. You can not withdraw amount more than the balance.']")).getText();
        if(withdraw){
            System.out.println(text);
        }
    }
    public void verifyTransactions() throws InterruptedException {
        WebElement transactions = driver.findElement(By.xpath("//button[@ng-click='transactions()']"));
        transactions.click();
        Thread.sleep(2000);
        String depositType = driver.findElement(By.xpath("//tr[@id='anchor0']/td[3]")).getText();
        String depositAmount = driver.findElement(By.xpath("//tr[@id='anchor0']/td[2]")).getText();

        if(depositType.contains("Credit")){
            if(depositAmount.contains("1000")){
                System.out.println("Transaction is updated as per action performed for crediting");
            }
        }
        String WdrawType = driver.findElement(By.xpath("//tr[@id='anchor1']/td[3]")).getText();
        String WdrawAmount = driver.findElement(By.xpath("//tr[@id='anchor1']/td[2]")).getText();
        if(WdrawType.contains("Debit")){
            if(WdrawAmount.contains("500")){
                System.out.println("Transaction is updated as per action performed for withdrawal");
            }
        }
    }

}

