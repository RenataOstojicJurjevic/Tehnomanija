package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.TehnomanijaHomePage;
import pom_classes.TehnomanijaRegistracijaPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

public class TehnomanijaTests {
    WebDriver driver;
    String URL = "https://www.tehnomanija.rs/";
    DriverManager driverManager;
    TehnomanijaRegistracijaPage tehnomanijaRegistracijaPage;
    TehnomanijaHomePage tehnomanijaHomePage;

    @BeforeMethod
    public void setup(){
        driverManager = DriverManagerFactory.getDriverManager("CHROME"); //ovo treba biti parametar, a u testng napišeš vrijednost parametra
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }


    @Test
    public void registerToTehnomanija(){
        tehnomanijaRegistracijaPage = new TehnomanijaRegistracijaPage(driver);
        tehnomanijaHomePage = new TehnomanijaHomePage(driver);

        tehnomanijaHomePage.checkTitle();
        tehnomanijaHomePage.checkPrijava();
        tehnomanijaHomePage.checkKorpa();
        tehnomanijaHomePage.clickCookies();
        tehnomanijaHomePage.checkSocialLinks();
        tehnomanijaHomePage.clickPrijava();
        tehnomanijaHomePage.clickRegistrujSe();
        /*
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.5'");
        */

        tehnomanijaRegistracijaPage.checkRegistrationPage();
        tehnomanijaRegistracijaPage.checkSocialLinks();
        tehnomanijaRegistracijaPage.register();



    }

    @AfterMethod
    public void tearDown(){

        //driverManager.quitWebDriver();
    }
}
