package framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class FrameworkInitialize extends Base {

    private void configureAuth(String username, String password) {
        DriverContext.Driver.get("chrome-extension://ggmdpepbjljkkkdaklfihhngmmgmpggp/options.html");

        String windowHandle = DriverContext.Driver.getWindowHandle();
        DriverContext.Driver.switchTo().window(windowHandle);

        DriverContext.Driver.findElement(By.id("login")).sendKeys(username);
        DriverContext.Driver.findElement(By.id("password")).sendKeys(password);
        DriverContext.Driver.findElement(By.id("retry")).clear();
        DriverContext.Driver.findElement(By.id("retry")).sendKeys("5");
        DriverContext.Driver.findElement(By.id("save")).click();
    }

    public void InitializeBrowser(Browser.BrowserType browserType) {

        WebDriver driver = null;
        switch (browserType) {
            case Chrome: {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Stefanini" +
                        "\\Documents\\Libs\\chromedriver.exe");
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.addExtensions(new File("C:\\Users\\Stefanini\\Documents" +
                        "\\Libs\\Proxy-Auto-Auth_v2.0.crx"));
                //DriverContext.Driver = new ChromeDriver(cOptions);
                driver = new ChromeDriver(cOptions);
                break;
            }
            case Firefox: {
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:\\Users\\Stefanini\\Documents\\Libs\\firefox.exe");

                FirefoxDriver driverFireFox = new FirefoxDriver(options);
                FirefoxOptions optionsFireFox = new FirefoxOptions();
                break;
            }
            case Chrome_Headless: {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");

                driver = new ChromeDriver(options);
                driver.manage().deleteAllCookies();
            }
        }
        //Set the driver
        DriverContext.setDriver(driver);
        //Browser
        DriverContext.Browser = new Browser(driver);

        //Configura extensão para o proxy
        configureAuth(
                "TR662920",
                "mB1fyGwa"
        );
    }
}
