package pom_classes;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;

public class TehnomanijaCommonPage {

    WebDriver driver;
    int WAIT = 30;

    public TehnomanijaCommonPage(WebDriver driver) {

        this.driver = driver;
    }
    private By prijava = By.xpath("//span[text()='Prijava']");
    private By korpa = By.xpath("//div[@class='basket-header js-basket-header']");
    private By fbLink = By.xpath("//li/a/i[@class='fa fa-facebook']/..");
    private By linkedInLink = By.xpath("//li/a/i[@class='fa fa-linkedin']/..");
    private By youTubeLink = By.xpath("//li/a/i[@class='fa fa-youtube']/..");
    private By instagramLink = By.xpath("//li/a/i[@class='fa fa-instagram']/..");


    public void checkSocialLinks(){

    Assert.assertTrue(driver.findElement(fbLink).isDisplayed());
    Assert.assertTrue(driver.findElement(fbLink).isEnabled());

    Assert.assertTrue(driver.findElement(linkedInLink).isDisplayed());
    Assert.assertTrue(driver.findElement(linkedInLink).isEnabled());

    Assert.assertTrue(driver.findElement(youTubeLink).isDisplayed());
    Assert.assertTrue(driver.findElement(youTubeLink).isEnabled());

    Assert.assertTrue(driver.findElement(instagramLink).isDisplayed());
    Assert.assertTrue(driver.findElement(instagramLink).isEnabled());


}
    public void checkKorpa(){
    Assert.assertTrue(driver.findElement(korpa).isDisplayed());

}

    public void checkPrijava(){
        Assert.assertTrue(driver.findElement(prijava).isDisplayed());

    }




    public void clickElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(element);
                actions.build().perform();
                element.click();
            } catch (StaleElementReferenceException e) {
                element.click();
            }
        } catch(Exception e){
            e.printStackTrace();

        }
    }

    public void typeText(WebElement element, String text){
        try{
            WebDriverWait wait = new WebDriverWait(driver,WAIT);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
            //element.sendKeys(Keys.ENTER);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String randomName() {
        Random r = new Random();
        int x = r.nextInt(10000);
        return "Name" + x;
    }

    public String randomSurname() {
        Random r = new Random();
        int x = r.nextInt(10000);
        return "Test" + x;
    }
    public String randomPhoneNr() {
        Random r = new Random();
        int x = r.nextInt(10000);
        return "01" + x;
    }

    public String randomLozinka() {
        Random r = new Random();
        int x = r.nextInt(10000);
        return "Passwo" + x + "!";
    }
    public String randomEmail() {
        Random r = new Random();
        int x = r.nextInt(10000);
        return "testmail" + x + "@gmail.com";
    }

}
