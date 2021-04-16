package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TehnomanijaCommonPage {

    WebDriver driver;

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


}
