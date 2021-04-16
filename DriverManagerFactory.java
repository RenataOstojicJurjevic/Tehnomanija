package selenium_core;

public class DriverManagerFactory {

    public static  DriverManager getDriverManager(String driverType){
        DriverManager driverManager ;

        switch (driverType){
            case "CHROME": {
                driverManager = new ChromeDriverManager();
            } break;
            case "FIREFOX": {
                driverManager = new FirefoxDriverManager();
            } break;

            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }




}
