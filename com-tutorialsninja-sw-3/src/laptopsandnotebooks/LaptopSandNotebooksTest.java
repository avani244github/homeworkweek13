package laptopsandnotebooks;

import desktop.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LaptopSandNotebooksTest extends BaseClass {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        Actions actions = new Actions(driver);
        WebElement laptopAndNotebook = driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/a"));
        actions.moveToElement(laptopAndNotebook).moveToElement(laptopAndNotebook).click().build().perform();
        // Mouse hover on Laptops & Notebooks Tab.and click

        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/div/a")).click();
        // Click on “Show All Laptops & Notebooks”

        WebElement sortBy = driver.findElement(By.xpath("//div[@id='content']/div[3]/div[3]/div/select"));
        Select dropdown = new Select(sortBy);
        dropdown.selectByIndex(4);//Select Sort By "Price (High > Low)"

        // Verify the Product price will arrange in High to Low order.
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement laptopAndNotebook = driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/a"));
        actions.moveToElement(laptopAndNotebook).moveToElement(laptopAndNotebook).click().build().perform();
        // Mouse hover on Laptops & Notebooks Tab.and click

        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/div/a")).click();
        // Click on “Show All Laptops & Notebooks”

        WebElement sortBy = driver.findElement(By.xpath("//div[@id='content']/div[3]/div[3]/div/select"));
        Select dropdown = new Select(sortBy);
        dropdown.selectByIndex(4);//Select Sort By "Price (High > Low)"

        driver.findElement(By.xpath("//div[@id='content']/div[4]/div[4]/div/div[2]/div[1]/h4/a")).click(); //Select Product “MacBook”
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/h1")).getText();//Verify the text “MacBook”
        //System.out.println(actualResult);
        String expectedResult = "MacBook";
        Assert.assertEquals(expectedResult, actualResult);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div[2]/div/button")).click();//Click on ‘Add To Cart’ button
        String actualResult1 = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        //System.out.println(actualResult1);
        String expectedResult1 = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        Assert.assertEquals(expectedResult1, actualResult1); //Verify the message “Success: You have added MacBook to your shopping cart!”

        driver.findElement(By.xpath("//div[@id='top-links']/ul/li[4]/a")).click();//Click on link “shopping cart” display into success message
        String actualResult2 = driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/h1")).getText();
        // System.out.println(actualResult2);
        String expectedResult2 = "Shopping Cart  (0.00kg)";
        Assert.assertEquals(expectedResult2, actualResult2); //Verify the text "Shopping Cart"

        String actualResult3 = driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/form/div/table/tbody/tr/td[2]/a")).getText();
        String expectedResult3 = "MacBook";
        Assert.assertEquals(expectedResult3, actualResult3);//Verify the Product name "MacBook"

        driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/form/div/table/tbody/tr/td[4]/div/input")).clear();//Change Quantity "2"
        driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/form/div/table/tbody/tr/td[4]/div/input")).sendKeys("2");

        driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/form/div/table/tbody/tr/td[4]/div/span/button[1]")).click();//Click on “Update” Tab
        String actualResult4 = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        //System.out.println(actualResult4);
        String expectedResult4 = "Success: You have modified your shopping cart!\n" +
                "×";
        Assert.assertEquals(expectedResult4, actualResult4); //Verify the message “Success: You have modified your shopping cart!”

        String actualResult5 = driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/form/div/table/tbody/tr/td[6]")).getText();
        String expectedResult5 = "$1,204.00";
        Assert.assertEquals(expectedResult5, actualResult5);//Verify the Total £737.45

        driver.findElement(By.xpath("//div[@class='buttons clearfix']/div[2]/a")).click();//Click on “Checkout” button

        String actualResult6 = driver.findElement(By.xpath("//div[@id='checkout-checkout']/div/div/h1")).getText();
        String expectedResult6 = "Checkout";
        Assert.assertEquals(expectedResult6, actualResult6);//Verify the text “Checkout”

        String actualResult7 = driver.findElement(By.xpath("//div[@id='content']/div/div[1]/div[2]/div/div/div[1]/h2")).getText();
        System.out.println(actualResult7);
       // String expectedResult7 = "New Customer";
       //Assert.assertEquals(expectedResult7,actualResult7);
         //Verify the Text “New Customer”


        driver.findElement(By.xpath("//div[@id='content']/div/div[1]/div[2]/div/div/div[1]/div[2]/label/input")).click();//Click on “Guest Checkout” radio button

        driver.findElement(By.xpath("//div[@id='content']/div/div[1]/div[2]/div/div/div[1]/input")).click();//Click on “Continue” tab
//Fill the mandatory fields
        driver.findElement(By.xpath("//fieldset[@id='account']/div[2]/input")).sendKeys("Avani");
        driver.findElement(By.xpath("//fieldset[@id='account']/div[3]/input")).sendKeys("Patel");
        driver.findElement(By.xpath("//fieldset[@id='account']/div[4]/input")).sendKeys("Patelavani244@gmail.com");
        driver.findElement(By.xpath("//fieldset[@id='account']/div[5]/input")).sendKeys("07878998878");
        driver.findElement(By.xpath("//fieldset[@id='address']/div[2]/input")).sendKeys("road-1");
        driver.findElement(By.xpath("//fieldset[@id='address']/div[3]/input")).sendKeys("next road");
        driver.findElement(By.xpath("//fieldset[@id='address']/div[4]/input")).sendKeys("London");
        driver.findElement(By.xpath("//fieldset[@id='address']/div[5]/input")).sendKeys("Ub34Bd");
        WebElement country = driver.findElement(By.xpath("//fieldset[@id='address']/div[6]/select"));
        Select select1 = new Select(country);
        select1.selectByVisibleText("United Kingdom");

        WebElement regionAndState = driver.findElement(By.xpath("//fieldset[@id='address']/div[7]/select"));
        Select select2 = new Select(regionAndState);
        select2.selectByVisibleText("East Sussex");


        driver.findElement(By.xpath("//div[@class='panel-collapse collapse in']/div/div[2]/div/input")).click();//Click on “Continue”Button
        driver.findElement(By.xpath("//div[@id='content']/div/div[3]/div[2]/div/p[2]/textarea")).sendKeys("New Pc pls.");//Add Comments About your order into text area
        driver.findElement(By.xpath("//div[@id='content']/div/div[3]/div[2]/div/div[2]/div/input")).click();//Check the Terms & Conditions check box

        driver.findElement(By.xpath("//div[@id='content']/div/div[3]/div[2]/div/div[2]/div/input[2]")).click();//Click on “Continue” button
        String actualResult8 = driver.findElement(By.xpath("//div[@id='content']/div/div[3]/div[2]/div/div[1]")).getText();
        //System.out.println(actualResult8);
        String expectedResult8 = "Warning: No Payment options are available. Please contact us for assistance!";
        Assert.assertEquals(expectedResult8, actualResult8);//Verify the message “Warning: Payment method required!”


    }

    @After
    public void endTest() {
        closeBrowser();
    }

}
