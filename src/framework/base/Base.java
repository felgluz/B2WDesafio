package framework.base;

import org.openqa.selenium.support.PageFactory;

public class Base {

    public static BasePage PaginaAtual;

    //criar uma instância da BasePage
    public <TPage extends BasePage> TPage CriarInstancia(Class<TPage> page)
    {
        Object obj = PageFactory.initElements(DriverContext.Driver, page);
        //vai retornar a página casteada com a instância criada aqui
        return page.cast(obj);
    }
}
