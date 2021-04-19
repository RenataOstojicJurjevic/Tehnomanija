package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TehnomanijaHomePage extends TehnomanijaCommonPage{

    WebDriver driver;

    public TehnomanijaHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //private By prijava = By.xpath("//span[text()='Prijava']");
    @FindBy(xpath ="//span[text()='Prijava']" )
    WebElement prijava;

    //private By acceptCookies = By.xpath("//a[@class='cookie-agree fnc-accept-cookies']");
    @FindBy(xpath ="//a[@class='cookie-agree fnc-accept-cookies']" )
    WebElement acceptCookies;
   // private By registrujteSe = By.xpath("//a[text()='Registrujte se']");
    @FindBy(xpath ="//a[text()='Registrujte se']" )
    WebElement registrujteSe;



    public void clickPrijava() {
        //click na PRIJAVA na Homepage
        //driver.findElement(prijava).click();
        clickElement(prijava);
    }

    public void clickRegistrujSe() {
        //click na Registrujte se
        clickElement(registrujteSe);

    }


    public void clickCookies(){
        //Klik na Slažem se za kolačiće
        clickElement(acceptCookies);
    }

    public void checkTitle() {
        //provjera naslova stranice
        Assert.assertEquals(driver.getTitle(), "Tehnomanija 🛒 Mesto gde se kupuje tehnika");
    }




}
