package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.base.DriverContext;
import framework.base.FrameworkInitialize;
import framework.config.ConfigReader;
import framework.config.Settings;
import framework.utilities.LogUtil;

import java.io.IOException;

public class TestInitialize extends FrameworkInitialize {

    @Before
    public void Initialize() throws IOException {
        //Initialize config
        ConfigReader.PopulateSettings();

        //Log
        Settings.Logs = new LogUtil();
        Settings.Logs.CreateLogFile();
        Settings.Logs.Write("Framework inicializado");

        Settings.Logs.Write("Ciclo de Teste Criado");
        InitializeBrowser(Settings.BrowserType);
        Settings.Logs.Write("Browser Inicializado");
        DriverContext.Browser.GoToUrl(Settings.AUT);
        Settings.Logs.Write("Navegou para a URL " + Settings.AUT);
        //DriverContext.Browser.Maximize();
    }

    @After
    public void Close(){
        DriverContext.Driver.close();
        DriverContext.Driver.quit();
    }
}
