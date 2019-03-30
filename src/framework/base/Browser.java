package framework.base;

import org.openqa.selenium.WebDriver;

public class Browser {
    public Browser(WebDriver driver) {
        _driver = driver;
    }

    private WebDriver _driver;

    public BrowserType Type;

    public enum BrowserType {
        Chrome,
        Firefox,
        Chrome_Headless,
        IE,
        Edge
    }

    public void GoToUrl(String url) {
        _driver.get(url);
    }

    public void Maximize() {
        _driver.manage().window().maximize();
    }
}
