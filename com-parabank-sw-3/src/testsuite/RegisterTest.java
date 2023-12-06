package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
public void verifyThatSigningUpPageDisplay() throws InterruptedException {
//* click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();

        //Thread.sleep(2000);
//* Verify the text ‘Signing up is easy!’
        String  actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]")).getText();
        //System.out.println(actualResult);
        String expectedResult = "Signing up is easy!";
        Assert.assertEquals(expectedResult,actualResult);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
//click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
//Enter First name
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[1]/td[2]/input")).sendKeys("Avinshi");
//Enter Last name
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[2]/td[2]/input")).sendKeys("Pandyata");
//Enter Address
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[3]/td[2]/input")).sendKeys("Wembley");
//Enter City
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[4]/td[2]/input")).sendKeys("London");
//Enter State
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[5]/td[2]/input")).sendKeys("London");
//Enter Zip Code
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[6]/td[2]/input")).sendKeys("UH76Uh");
//Enter Phone
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[7]/td[2]/input")).sendKeys("07984447656");
//Enter SSN
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[8]/td[2]/input")).sendKeys("143");
//Enter Username
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[10]/td[2]/input")).sendKeys("apera1378");
//Enter Password
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[11]/td[2]/input")).sendKeys("1223009900");
//Enter Confirm
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[12]/td[2]/input")).sendKeys("1223009900");
//Click on REGISTER button
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
//Verify the text'Your account was created successfully. You are now logged in.
        String actualText1 = driver.findElement(By.xpath("//div[@id=\"rightPanel\"]/p")).getText();
       // System.out.println(actualText1);
       String expectedText1 = "Your account was created successfully. You are now logged in.";
       Assert.assertEquals(expectedText1,actualText1);
    }
    @After
    public void endTest() {

        closeBrowser();
    }
}
