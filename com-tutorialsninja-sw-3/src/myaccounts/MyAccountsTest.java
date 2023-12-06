package myaccounts;

import desktop.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class MyAccountsTest extends BaseClass {
    public void selectMyAccountOptions(String option) {
        WebElement menu= driver.findElement(By.linkText(option));
        menu.click();
//        List<WebElement> optionElements = selectElement.findElements(By.tagName("option"));
//        List<WebElement> optionList = option.getOptions();
//        Assertions.assertEquals(optionElements, optionList);
    }
        String baseUrl = "https://tutorialsninja.com/demo/index.php";

        @Before
        public void setUp() {
            openBrowser(baseUrl);
        }

        @Test
        public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
// Click on My Account Link.
            driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a")).click();
//Call the method “selectMyAccountOptions” method and pass the parameter “Register”
            selectMyAccountOptions("Register");
//Verify the text “Register Account”.
            String actualText = driver.findElement(By.xpath("//div[@id='account-register']/div/div/h1")).getText();
            String expectedText = "Register Account";
            assertEquals(expectedText,actualText);

        }
        @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
//Click on My Account Link.
            driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a")).click();
//Call the method “selectMyAccountOptions” method and pass the parameter “Login”
            selectMyAccountOptions("Login");
//Verify the text “Returning Customer”.
            String actualText1 = driver.findElement(By.xpath("//div[@id='account-login']/div/div/div/div[2]/div/h2")).getText();
           // System.out.println(actualText1);
            String expectedText1 = "Returning Customer";
            assertEquals(expectedText1,actualText1);

        }
      @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
//Click on My Account Link.
          driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a")).click();
//Call the method “selectMyAccountOptions” method and pass the parameter “Register”
          selectMyAccountOptions("Register");
//Enter First Name
          driver.findElement(By.xpath("//fieldset[@id='account']/div[2]/div/input")).sendKeys("Avani");
//Enter Last Name
          driver.findElement(By.xpath("//fieldset[@id='account']/div[3]/div/input")).sendKeys("Patel");
//Enter Email
          driver.findElement(By.xpath("//fieldset[@id='account']/div[4]/div/input")).sendKeys("patelavani221@gmail.com");
//Enter Telephone
          driver.findElement(By.xpath("//fieldset[@id='account']/div[5]/div/input")).sendKeys("07932667778");
//Enter Password
          driver.findElement(By.xpath("//div[@id='content']/form/fieldset[2]/div[1]/div/input")).sendKeys("121223233413");
//Enter Password Confirm
          driver.findElement(By.xpath("//div[@id='content']/form/fieldset[2]/div[2]/div/input")).sendKeys("121223233413");
//Select Subscribe Yes radio button
          driver.findElement(By.xpath("//div[@id='content']/form/fieldset[3]/div/div/label[1]/input")).click();
//Click on Privacy Policy check box
          driver.findElement(By.xpath("//div[@id='content']/form/div/div/input[1]")).click();
//Click on Continue button
          driver.findElement(By.xpath("//div[@id='content']/form/div/div/input[2]")).click();
//Verify the message “Your Account Has Been Created!”
          String actualResult0 = driver.findElement(By.xpath("//div[@id='common-success']/div/div/h1")).getText();
          String expectedResult0 = "Your Account Has Been Created!";
          assertEquals(expectedResult0,actualResult0);
//Click on Continue button
         driver.findElement(By.xpath("//div[@id='common-success']/div/div/div/div/a")).click();
//Click on My Account Link.
         driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a")).click();
//Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
         selectMyAccountOptions("Logout");
//Verify the text “Account Logout”
         String actualResult = driver.findElement(By.xpath("//div[@id='common-success']/div/div/h1")).getText();
         String expectedResult = "Account Logout";
          Assert.assertEquals(expectedResult,actualResult);
//Click on Continue button
         driver.findElement(By.xpath("//div[@id='common-success']/div/div/div/div/a")).click();

     }
     @Test
     public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
//Click on My Account Link.
         driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a")).click();
//Call the method “selectMyAccountOptions” method and pass the parameter “Login”
          selectMyAccountOptions("Login");

//Enter Email address
          driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/form/div[1]/input")).sendKeys("patelavani21@gmail.com");

//Enter Password
          driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/form/div[2]/input")).sendKeys("12122323343");
//Click on Login button
          driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/form/input")).click();
//Verify text “My Account”
          String actualResult = driver.findElement(By.xpath("//div[@id='account-account']/div/div/h2[1]")).getText();
          String expectedResult = "My Account";
          Assert.assertEquals(expectedResult,actualResult);
//Click on My Account Link.
          driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a")).click();
//Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
          selectMyAccountOptions("Logout");
//Verify the text “Account Logout”
          String actualResult2 = driver.findElement(By.xpath("//div[@id='common-success']/div/div/h1")).getText();
          String expectedResult2 = "Account Logout";
          Assert.assertEquals(expectedResult2,actualResult2);
//Click on Continue button
          driver.findElement(By.xpath("//div[@id='common-success']/div/div/div/div/a")).click();
      }
    @After
    public void endTest() {
        // closeBrowser();
    }

}
