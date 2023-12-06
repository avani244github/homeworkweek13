package desktop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DesktopsTest extends BaseClass {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        Actions actions = new Actions(driver);
        WebElement deskTop = driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[1]/a"));
        actions.moveToElement(deskTop).moveToElement(deskTop).click().build().perform();
        WebElement showAllElement = driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[1]/div/a"));
        showAllElement.click();
        WebElement sortBy = driver.findElement(By.xpath("//div[@id='content']/div[3]/div[3]/div/select"));
        Select dropdown = new Select(sortBy);
        dropdown.selectByIndex(2);

        //WebElement dropDown1 = driver.findElement(By.xpath("//div[@id='content']/div[3]/div[3]/div/select"));
        // Assert.assertTrue(dropDown1.isDisplayed());

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement deskTop = driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[1]/a"));
        actions.moveToElement(deskTop).moveToElement(deskTop).click().build().perform();
        WebElement showAllElement = driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[1]/div/a"));
        showAllElement.click();
        WebElement sortBy = driver.findElement(By.xpath("//div[@id='content']/div[3]/div[3]/div/select"));
        Select dropdown = new Select(sortBy);
        dropdown.selectByIndex(1);
        driver.findElement(By.xpath("//div[@id='content']/div[4]/div[3]/div/div[2]/div[1]/h4/a")).click();
        String expectedText= driver.findElement(By.xpath("//div[@id='content']/div/div[2]/h1")).getText();
        // System.out.println(actualText);
        String actualText = "HP LP3065";
        Assert.assertEquals(actualText,expectedText);
driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div[2]/div[1]/div/input")).clear();
driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div[2]/div[1]/div/input")).sendKeys("2022-11-30");
driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div[2]/div[2]/input[1]")).clear();
driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div[2]/div[2]/input[1]")).sendKeys("1");
driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div[2]/div[2]/button")).click();
String actualText7=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        System.out.println(actualText7);
        Thread.sleep(1000);
        String expectedText7="Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        Assert.assertEquals(expectedText7,actualText7);
        driver.findElement(By.xpath("//div[@id='cart']/button")).click();
driver.findElement(By.id("content")); //Verify the text "Shopping Cart"
        driver.findElement(By.xpath("//div[@id='top-links']/ul/li[4]/a")).click();

       String expextedResult1 = driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/form/div/table/tbody/tr/td[2]/a")).getText(); //Verify the Product name "HP LP3065"
        //System.out.println(expextedResult1);
        String actualResult1 ="HP LP3065";
        Assert.assertEquals(expextedResult1,actualResult1);

        String expectedResult2=driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/form/div/table/tbody/tr/td[2]/small")).getText();//Verify the Delivery Date "2022-11-30"
       // System.out.println(expectedResult2);
        String actualresult2 = "Delivery Date:2022-11-30";
        Assert.assertEquals(expectedResult2,actualresult2);

        String expectedResult3=driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/form/div/table/tbody/tr/td[3]")).getText();//Verify the Model "Product21"
       // System.out.println(expectedResult3);
        String actualResult3 = "Product 21";
        Assert.assertEquals(expectedResult3,actualResult3);

        String expectedResult4=driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/form/div/table/tbody/tr/td[6]")).getText();//Verify the Todat "£74.73"
        //System.out.println(expectedResult4);
        String actualResult4 = "$122.00";
        Assert.assertEquals(expectedResult4,actualResult4);
    }

            @After
            public void endTest() {

                 closeBrowser();
            }
        }


