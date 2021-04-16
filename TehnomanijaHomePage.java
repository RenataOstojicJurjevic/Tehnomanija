package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TehnomanijaHomePage extends TehnomanijaCommonPage{

    WebDriver driver;

    public TehnomanijaHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By prijava = By.xpath("//span[text()='Prijava']");
    private By acceptCookies = By.xpath("//a[@class='cookie-agree fnc-accept-cookies']");
    private By registrujteSe = By.xpath("//a[text()='Registrujte se']");



    public void clickPrijava() {
        //click na PRIJAVA na Homepage
        driver.findElement(prijava).click();

    }

    public void clickRegistrujSe() {
        //click na Registrujte se
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(registrujteSe)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(registrujteSe)));
        driver.findElement(registrujteSe).click();
    }


    public void clickCookies(){
        //Klik na Slažem se za kolačiće
       // driver.findElement(acceptCookies).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(acceptCookies)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(acceptCookies)));
        driver.findElement(acceptCookies).click();
    }

    public void checkTitle() {
        //provjera naslova stranice
        Assert.assertEquals(driver.getTitle(), "Tehnomanija 🛒 Mesto gde se kupuje tehnika");

    }




}
