package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
//Enter valid username
        driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("apera1378");
//Enter valid password
        driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("1223009900");
//Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[3]/input")).click();
//Verify the ‘Accounts Overview’ text is display
        String actualResult = driver.findElement(By.xpath("//div[@id=\"rightPanel\"]/div[1]/div[1]/h1")).getText();
       //System.out.println(actualResult);
        String expectedResult = "Accounts Overview";
        Assert.assertEquals(expectedResult,actualResult);
    }
    @Test
    public void verifyTheErrorMessage(){
//Enter invalid username
        driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("agasi89");
//Enter invalid password
        driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("484595");
//Click on Login button
        driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[3]/input")).click();
//Verify the error message ‘The username and password could not be verified.’
        String actualResult1 = driver.findElement(By.xpath("//div[@id=\"rightPanel\"]/p")).getText();
      // System.out.println(actualResult1);
        String expectedResult1 = "The username and password could not be verified.";
       Assert.assertEquals(expectedResult1,actualResult1);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
//Enter valid username
        driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("apera1378");
//Enter valid password
        driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("1223009900");
//Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[3]/input")).click();
//Click on ‘Log Out’ link
        driver.findElement(By.xpath("//div[@id=\"leftPanel\"]/ul/li[8]/a")).click();
//Verify the text ‘Customer Login’
        String actualResult2 = driver.findElement(By.xpath("//div[@id=\"leftPanel\"]/h2")).getText();
       // System.out.println(actualResult2);
        String expectedResult2 = "Customer Login";
        Assert.assertEquals(expectedResult2,actualResult2);
    }
    @After
    public void endTest() {

        closeBrowser();
    }
}
