package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import framework.base.Base;
import framework.base.DriverContext;
import framework.utilities.CucumberUtil;
import org.junit.Assert;
import pages.FormEnviadoPage;
import pages.FormPage;

public class FormSteps extends Base {
    //region<Contexto>
    @Dado("^que entrei no link do desafio$")
    public void queEntreiNoLinkDoDesafio() {
        DriverContext.WaitForPageToLoad();
        PaginaAtual = CriarInstancia(FormPage.class);
    }

    @Então("^página é exibida$")
    public void páginaÉExibida() {
        Assert.assertTrue(PaginaAtual.Como(FormPage.class).EstaNaPagina());
    }
    //endregion

    @Dado("^que preencho os campos nome \"([^\"]*)\" e email \"([^\"]*)\"$")
    public void quePreenchoOsCamposNomeEEmail(String nome, String email) {
        DriverContext.ScrollDownUntilElementDisplayed("Qual seu nome completo?");
        PaginaAtual.Como(FormPage.class).InsereNome(nome);
        PaginaAtual.Como(FormPage.class).InsereEmail(email);
    }

    @Quando("^seleciono a cor \"([^\"]*)\" e sobremesa \"([^\"]*)\"$")
    public void selecionoACorESobremesa(String cor, String sobremesa) {
        DriverContext.ScrollDownUntilElementDisplayed("Qual sua cor favorita?");
        PaginaAtual.Como(FormPage.class).EscolheCor(cor);
        PaginaAtual.Como(FormPage.class).EscolheSobremesa(sobremesa);
    }

    @E("^seleciono minha comida \"([^\"]*)\"$")
    public void selecionoMinhaComida(String comida) throws InterruptedException {
        DriverContext.ScrollDownUntilElementDisplayed("Qual sua comida favorita?");
        PaginaAtual.Como(FormPage.class).EscolheComida(comida);
    }

    @E("^seleciono o número \"([^\"]*)\" do quanto gosto de animais$")
    public void selecionoONúmeroDoQuantoGostoDeAnimais(String numero) {
        PaginaAtual.Como(FormPage.class).EscolheNumeroAnimais(numero);
    }

    @E("^defino um número para cada esporte$")
    public void definoUmNúmeroParaCadaEsporte(DataTable table) {
        CucumberUtil.ConvertDataTableToDict(table);
        DriverContext.ScrollDownUntilElementDisplayed("Considere os esportes");

        int numeroLinha = 1;
        for (int i = 0; i < 4; i++) {
            PaginaAtual.Como(FormPage.class).EscolheEsporte(
                    CucumberUtil.GetCellValueWithRowIndex("Esporte", numeroLinha),
                    CucumberUtil.GetCellValueWithRowIndex("Consideracao", numeroLinha));
            numeroLinha++;
        }
    }

    @E("^seleciono os ingredientes de cada sanduíche$")
    public void selecionoOsIngredientesDeCadaSanduíche(DataTable table) {
        CucumberUtil.ConvertDataTableToDict(table);
        DriverContext.ScrollDownUntilElementDisplayed("Quais os ingredientes do sandwich?");

        int numeroLinha = 1;
        for (int i = 0; i < 4; i++) {
            PaginaAtual.Como(FormPage.class).EscolheIngredientesSanduiche(
                    CucumberUtil.GetCellValueWithRowIndex("Sanduiche", numeroLinha));
            numeroLinha++;
        }
    }

    @Então("^seleciono o dia de hoje$")
    public void selecionoODiaDeHoje() {
        DriverContext.ScrollDownUntilElementDisplayed("Que dia é hoje?");
        PaginaAtual.Como(FormPage.class).InsereDataAtual();

    }

    @E("^seleciono a hora daqui a uma hora$")
    public void selecionoAHoraDaquiAUmaHora() {
        PaginaAtual.Como(FormPage.class).InsereDataAtrasada();
    }

    @Quando("^clico no botão submit$")
    public void clicoNoBotãoSubmit() {
        PaginaAtual.Como(FormPage.class).ClicarBtnSubmit();
    }

    @Então("^formulário é enviado$")
    public void formulárioÉEnviado() {
        PaginaAtual = CriarInstancia(FormPage.class);
        Assert.assertTrue("Formulário não foi enviado",
                PaginaAtual.Como(FormEnviadoPage.class).FormEnviado());
    }

    @Então("^mensagem de erro para preencher o sobrenome é exibida$")
    public void mensagemDeErroParaPreencherOSobrenomeÉExibida() {
        Assert.assertTrue("Mensagem de erro não foi exibida",
                PaginaAtual.Como(FormPage.class).MsgErroNomeExibe());
        Assert.assertTrue("Mensagem de erro não foi exibida",
                PaginaAtual.Como(FormPage.class).MsgErroEmailExibe());
    }

    @Quando("^preencho o campo ˜Other˜ com texto \"([^\"]*)\"$")
    public void preenchoOCampoOtherComTexto(String texto) {
        PaginaAtual.Como(FormPage.class).InsereTxtOutros(texto);
    }

    @Então("^sobremesa Other é selecionada$")
    public void sobremesaOtherÉSelecionada() {
        Assert.assertTrue("Campo Outros não está preenchido",
                PaginaAtual.Como(FormPage.class).CheckboxOutrosPreenchido());
    }
}
