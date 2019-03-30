package pages;

import framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FormEnviadoPage extends BasePage {
    //Não estou conseguindo dar submit no formulário
    @FindBy(how = How.CSS, using = "")
    public WebElement elemento;

    public boolean FormEnviado(){
        return elemento.isDisplayed();
    }
}
