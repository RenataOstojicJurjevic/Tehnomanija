package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    DriverManager driverManager;

    public void init(String url, int time) //ovdje ide i String browser, al vidi kako treba zbog paralel
    {
        //ovo treba biti browser umjesto zakucave CHROME, a u testng  napišeš vrijednost parametra, a u  i TehnomanijaTest parametar
        driverManager = DriverManagerFactory.getDriverManager("CHROME");
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.get(url);
    }
    public void takeScreenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file , new File("src/screenshots/"+fileName+".png"));
    }

    public void quitDriver()
    {
        driverManager.quitWebDriver();
    }

}
