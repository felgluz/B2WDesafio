package pages;

import framework.base.BasePage;
import framework.base.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FormPage extends BasePage {
    public FormPage() {
        super();
    }

    @CacheLookup
    @FindBy(how = How.CSS, using = "[aria-label='Qual seu nome completo?']")
    public WebElement txtNome;

    @CacheLookup
    @FindBy(how = How.CSS, using = "[aria-label='Qual seu e-mail?']")
    public WebElement txtEmail;

    @FindAll({
            @FindBy(how = How.CSS, using = "[aria-label='Verde']"),
            @FindBy(how = How.CSS, using = "[aria-label='Azul']"),
            @FindBy(how = How.CSS, using = "[aria-label='Vermelho']")
    })
    public List<WebElement> listaCores;

    @FindAll({
            @FindBy(how = How.CSS, using = "[aria-label=Sorvete]"),
            @FindBy(how = How.CSS, using = "[aria-label='Bolo']"),
            @FindBy(how = How.CSS, using = "[aria-label='Fruta']"),
            @FindBy(how = How.CSS, using = "[aria-label='Other:']")
    })
    public List<WebElement> listaSobremesa;

    @FindBy(how = How.CSS, using = "[aria-label='Other response']")
    public WebElement txtOutro;

    //region <Lista de comidas favoritas>
    @FindBy(how = How.CSS, using = "[data-value='Todas']")
    public List<WebElement> comidaTodas;

    @FindBy(how = How.CSS, using = "[data-value='Legumes']")
    public List<WebElement> comidaLegumes;

    @FindBy(how = How.CSS, using = "[data-value='Massas']")
    public List<WebElement> comidaMassas;

    @FindBy(how = How.CSS, using = "[data-value='Carnes']")
    public List<WebElement> comidaCarnes;

    @FindBy(how = How.XPATH, using = "//content[contains(text(),'Escolher')]")
    public WebElement dropdownComida;
    //endregion

    @FindBy(how = How.XPATH, using = "//label[starts-with(@class,'freebirdMaterialScalecontentColumn')]")
    public List<WebElement> listaNumeroAnimais;

    //region <Lista esportes>
    @FindAll({
            @FindBy(how = How.CSS, using = "[aria-label=Futebol] [data-value=Ruim]"),
            @FindBy(how = How.CSS, using = "[aria-label=Futebol] [data-value='Mediano']"),
            @FindBy(how = How.CSS, using = "[aria-label=Futebol] [data-value='Bom']"),
            @FindBy(how = How.CSS, using = "[aria-label=Futebol] [data-value='Ótimo']")
    })
    public List<WebElement> listaFutebol;

    @FindAll({
            @FindBy(how = How.CSS, using = "[aria-label=Rugby] [data-value='Ruim']"),
            @FindBy(how = How.CSS, using = "[aria-label=Rugby] [data-value='Mediano']"),
            @FindBy(how = How.CSS, using = "[aria-label=Rugby] [data-value='Bom']"),
            @FindBy(how = How.CSS, using = "[aria-label=Rugby] [data-value='Ótimo']")
    })
    public List<WebElement> listaRugby;

    @FindAll({
            @FindBy(how = How.CSS, using = "[aria-label=eSport] [data-value='Ruim']"),
            @FindBy(how = How.CSS, using = "[aria-label=eSport] [data-value='Mediano']"),
            @FindBy(how = How.CSS, using = "[aria-label=eSport] [data-value='Bom']"),
            @FindBy(how = How.CSS, using = "[aria-label=eSport] [data-value='Ótimo']")
    })
    public List<WebElement> listaEsport;

    @FindAll({
            @FindBy(how = How.CSS, using = "[aria-label=Baseball] [data-value='Ruim']"),
            @FindBy(how = How.CSS, using = "[aria-label=Baseball] [data-value='Mediano']"),
            @FindBy(how = How.CSS, using = "[aria-label=Baseball] [data-value='Bom']"),
            @FindBy(how = How.CSS, using = "[aria-label=Baseball] [data-value='Ótimo']")
    })
    public List<WebElement> listaBaseball;

    //endregion

    //region <Lista de ingredientes>
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Xburguer')]/following-sibling::label")
    public List<WebElement> listaXburguer;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Hamburguer')]/following-sibling::label")
    public List<WebElement> listaHamburguer;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Vegetariano')]/following-sibling::label")
    public List<WebElement> listaVegetariano;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'EggXburger')]/following-sibling::label")
    public List<WebElement> listaEggXburger;
    //endregion

    @FindBy(how = How.CSS, using = "[type='date']")
    public WebElement txtData;

    //@FindBy(how = How.CSS, using = "[class='quantumWizTextinputPaperinputInputArea']")
    @FindBy(how = How.XPATH, using = "//*[@id=\"mG61Hd\"]/div/div[2]/div[2]/div[10]/div/div[2]/div[1]/div[2]/div[1]/div/div[1]")
    public WebElement txtHora;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[10]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]")
    public WebElement txtMin;

    @FindBy(how = How.CSS, using = "[data-value='AM']")
    public WebElement dropdownAM;

    @FindBy(how = How.CSS, using = "[data-value='PM']")
    public WebElement dropdownPM;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Enviar')]")
    public WebElement btnSubmit;

    @FindBy(how = How.XPATH, using = "//div[@id='i.err.338029540']")
    public WebElement msgErroNome;

    @FindBy(how = How.XPATH, using = "//div[@id='i.err.2081699196']")
    public WebElement msgErroEmail;

    public boolean EstaNaPagina() {
        DriverContext.WaitForElementVisible(txtNome);
        return txtNome.isDisplayed();
    }

    public void InsereNome(String text) {
        DriverContext.WaitForElementVisible(txtNome);
        txtNome.clear();
        txtNome.sendKeys(text);
    }

    public void InsereEmail(String text) {
        DriverContext.WaitForElementVisible(txtEmail);
        //DriverContext.ScrollDownAteElementoVisivel(txtEmail);
        txtEmail.clear();
        txtEmail.sendKeys(text);
    }

    public void EscolheCor(String cor) {
        DriverContext.WaitForElementVisible(listaCores.get(0));
        //DriverContext.ScrollDownAteElementoVisivel(listaCores.get(2));
        switch (cor) {
            case "Verde":
                listaCores.get(0).click();
                break;
            case "Azul":
                listaCores.get(1).click();
                break;
            case "Vermelho":
                listaCores.get(2).click();
                break;
        }
    }

    public void EscolheSobremesa(String sobremesa) {
        DriverContext.WaitForElementVisible(listaSobremesa.get(0));
        switch (sobremesa) {
            case "Sorvete":
                listaSobremesa.get(0).click();
                break;
            case "Bolo":
                listaSobremesa.get(1).click();
                break;
            case "Fruta":
                listaSobremesa.get(2).click();
                break;
            case "Outros":
                listaSobremesa.get(3).click();
                break;
        }
    }

    public void InsereTxtOutros(String texto) {
        DriverContext.WaitForElementVisible(txtOutro);
        txtOutro.clear();
        txtOutro.sendKeys(texto);
    }

    public void EscolheComida(String comida) throws InterruptedException {
        DriverContext.WaitForElementVisible(dropdownComida);
        //DriverContext.ScrollDownAteElementoVisivel(dropdownComida);
        dropdownComida.click();
        Thread.sleep(500);
        DriverContext.WaitForElementToBeClickable(comidaTodas.get(1));
        switch (comida) {
            case "Legumes":
                comidaLegumes.get(1).click();
                break;
            case "Todas":
                comidaTodas.get(1).click();
                break;
            case "Carnes":
                comidaCarnes.get(1).click();
                break;
            case "Massas":
                comidaMassas.get(1).click();
                break;
        }
    }

    public void EscolheNumeroAnimais(String numero) {
        DriverContext.WaitForElementVisible(listaNumeroAnimais.get(0));
        //DriverContext.ScrollDownAteElementoVisivel(listaNumeroAnimais.get(0));
        switch (numero) {
            case "1":
                listaNumeroAnimais.get(0).click();
                break;
            case "2":
                listaNumeroAnimais.get(1).click();
                break;
            case "3":
                listaNumeroAnimais.get(2).click();
                break;
            case "4":
                listaNumeroAnimais.get(3).click();
                break;
            case "5":
                listaNumeroAnimais.get(4).click();
                break;
            case "6":
                listaNumeroAnimais.get(5).click();
                break;
            case "7":
                listaNumeroAnimais.get(6).click();
                break;
            case "8":
                listaNumeroAnimais.get(7).click();
                break;
            case "9":
                listaNumeroAnimais.get(8).click();
                break;
            case "10":
                listaNumeroAnimais.get(9).click();
                break;
        }
    }

    public void EscolheEsporte(String esporte, String consideracao) {
        if (esporte.equals("Rugby")) {
            switch (consideracao) {
                case "Ruim":
                    listaRugby.get(0).click();
                    break;
                case "Mediano":
                    listaRugby.get(1).click();
                    break;
                case "Bom":
                    listaRugby.get(2).click();
                    break;
                case "Otimo":
                    listaRugby.get(3).click();
                    break;
            }
        }
        if (esporte.equals("eSport")) {
            switch (consideracao) {
                case "Ruim":
                    listaEsport.get(0).click();
                    break;
                case "Mediano":
                    listaEsport.get(1).click();
                    break;
                case "Bom":
                    listaEsport.get(2).click();
                    break;
                case "Otimo":
                    listaEsport.get(3).click();
                    break;
            }
        }
        if (esporte.equals("Futebol")) {
            switch (consideracao) {
                case "Ruim":
                    listaFutebol.get(0).click();
                    break;
                case "Mediano":
                    listaFutebol.get(1).click();
                    break;
                case "Bom":
                    listaFutebol.get(2).click();
                    break;
                case "Otimo":
                    listaFutebol.get(3).click();
                    break;
            }
        }
        if (esporte.equals("Baseball")) {
            switch (consideracao) {
                case "Ruim":
                    listaBaseball.get(0).click();
                    break;
                case "Mediano":
                    listaBaseball.get(1).click();
                    break;
                case "Bom":
                    listaBaseball.get(2).click();
                    break;
                case "Otimo":
                    listaBaseball.get(3).click();
                    break;
            }
        }
    }

    public void EscolheIngredientesSanduiche(String sanduiche) {
        switch (sanduiche) {
            case "Hamburguer":
                listaHamburguer.get(0).click();
                listaHamburguer.get(1).click();
                break;
            case "Xburguer":
                listaXburguer.get(0).click();
                listaXburguer.get(1).click();
                listaXburguer.get(2).click();
                listaXburguer.get(3).click();
                listaXburguer.get(4).click();
                break;
            case "Vegetariano":
                listaVegetariano.get(0).click();
                listaVegetariano.get(4).click();
                break;
            case "EggXburger":
                listaEggXburger.get(0).click();
                listaEggXburger.get(1).click();
                listaEggXburger.get(3).click();
                break;
        }
    }

    public void InsereDataAtual() {
        DriverContext.WaitForElementVisible(txtData);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        String data = dtf.format(localDate);

        txtData.sendKeys(data);
    }

    public void InsereDataAtrasada() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = dateFormat.format(date);

        String[] data = formattedDate.split(":");
        String hora = data[0];
        String minutos = data[1];

        int result = Integer.parseInt(hora) + 1;
        String horaAtrasada = Integer.toString(result);

        txtHora.click();
        DriverContext.ActionsFocusAndClickElement(txtHora, horaAtrasada);
        txtMin.click();
        DriverContext.ActionsFocusAndClickElement(txtMin, minutos);


        //Dropdown de AM/PM saiu
        /*if (result == 01 || result > 12) {
            dropdownPM.click();
        } else {
            dropdownAM.click();
        }*/
    }

    public FormEnviadoPage ClicarBtnSubmit() {
        DriverContext.WaitForElementVisible(btnSubmit);
        btnSubmit.click();
        return CriarInstancia(FormEnviadoPage.class);
    }

    public boolean MsgErroNomeExibe() {
        return msgErroNome.isDisplayed();
    }

    public boolean MsgErroEmailExibe() {
        return msgErroEmail.isDisplayed();
    }

    public boolean CheckboxOutrosPreenchido() {
        String textoPreenchido = txtOutro.getText();
        try {
            textoPreenchido.equals("");
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
}
