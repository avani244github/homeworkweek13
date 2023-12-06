package homepage;

import desktop.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TopMenuTest extends BaseClass {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";
        @Before
        public void setUp(){
            openBrowser(baseUrl);
        }
        public void selectMenu(String menu) {
            WebElement elements = driver.findElement(By.xpath(menu));
            elements.click();
        }


        @Test
        public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
            Actions actions = new Actions(driver);
            WebElement desktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
            actions.moveToElement(desktops).click().build().perform();

//call selectMenu method and pass the menu = “Show All Desktops”
            selectMenu("//ul[@class='nav navbar-nav']/li[1]/div/a");

            //Verify the text ‘Desktops’
            String actualResult = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
            System.out.println(actualResult);
            String expectedResult = "Desktops";
            Assert.assertEquals(expectedResult,actualResult);
        }
@Test
public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
    Actions actions = new Actions(driver);
    WebElement laptopAndNotebook = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
    actions.moveToElement(laptopAndNotebook).click().build().perform();
    selectMenu("//ul[@class='nav navbar-nav']/li[2]/div/a");
    String actualText2 =driver.findElement(By.tagName("h2")).getText();
    System.out.println(actualText2);
    String expectedResult2 = "Laptops & Notebooks";
    Assert.assertEquals(actualText2, expectedResult2);
}
@Test
public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
    Actions actions = new Actions(driver);
    WebElement component = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a"));
    actions.moveToElement(component).click().build().perform();
    selectMenu("//ul[@class='nav navbar-nav']/li[3]/div/a");
    String actualResult3 = driver.findElement(By.tagName("h2")).getText();
    System.out.println(actualResult3);
    String expectedResult3 = "Components";
    Assert.assertEquals(actualResult3, expectedResult3);

}
        @After
        public void endTest() {
             closeBrowser();
        }
    }

