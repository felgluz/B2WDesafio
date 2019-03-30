package framework.base;

import framework.config.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverContext {
    public static WebDriver Driver;

    public static Browser Browser;

    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }

    public static void WaitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(Driver, 20);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver;

        ExpectedCondition<Boolean> jsLoad = WebDriver -> ((JavascriptExecutor) Driver)
                .executeScript("return document.readyState").toString().equals("complete");

        //Get JS Ready
        boolean jsReady = jsExecutor.executeScript("return document.readyState")
                .toString().equals("complete");

        if (!jsReady)
            wait.until(jsLoad);
        else
            Settings.Logs.Write("Página carregada!");
    }

    public static void WaitForElementVisible(final WebElement elementFindBy) {
        WebDriverWait wait = new WebDriverWait(Driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));
    }

    public static void WaitForElementTextVisible(final WebElement elementFindBy, String text) {
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(elementFindBy, text));
    }

    public static void WaitForElementTextDisplayed(final By element, String text) {
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(textDisplayed(element, text));
    }

    private static ExpectedCondition<Boolean> textDisplayed(final By elementFindBy, String text) {
        return webDriver -> webDriver.findElement(elementFindBy).getText().contains(text);
    }

    public static void WaitForElementEnabled(final By elementFindBy) {
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(webDriver -> webDriver.findElement(elementFindBy).isEnabled());
    }

    public static void ChangeToFrame(String path) {
        WebElement frame = DriverContext.Driver.findElement(By.xpath(path));
        DriverContext.Driver.switchTo().frame(frame);
    }

    public static void ScrollDownUntilElementDisplayed(String texto) {
        JavascriptExecutor js = (JavascriptExecutor) Driver;
        WebElement element = Driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", texto)));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void WaitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void ActionsFocusAndClickElement(WebElement element, String text){
        Actions actions = new Actions(Driver);
        actions.moveToElement(element);
        actions.sendKeys(text);
        actions.build().perform();
    }
}
