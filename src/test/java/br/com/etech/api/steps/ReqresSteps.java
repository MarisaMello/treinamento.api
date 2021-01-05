package br.com.etech.api.steps;

import br.com.etech.api.funcionalidades.ReqresFuncionalidade;
import br.com.etech.commons.VariaveisEstaticas;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class ReqresSteps {

    ReqresFuncionalidade reqresFuncionalidade = new ReqresFuncionalidade();

    // lista do usuário

    @Dado("^recuperar as informações da pagina \"([^\"]*)\" da lista de usuário$")
    public void recuperarAsInformaçõesDaPaginaDaListaDeUsuário(String valor) {
        reqresFuncionalidade.getParams("page", valor);
    }

    @Quando("^realizar as requisição GET no serviço para listar os usuários$")
    public void realizarAsRequisiçãoGETNoServiçoParaListarOsUsuários() {
        reqresFuncionalidade.requisicaoListaUsuario();
    }

    @Então("^validar que a pagina \"([^\"]*)\" da lista foi mostrada com sucesso$")
    public void validarQueAPaginaDaListaFoiMostradaComSucesso(String valor) {
        Assert.assertEquals(valor, VariaveisEstaticas.getBody());
    }
    // lista unico usuário

    @Dado("^recuperar as informações do id \"([^\"]*)\" da lista de usuário$")
    public void recuperarAsInformaçõesDoIdDaListaDeUsuário(String valor)  {
        reqresFuncionalidade.getParams("id", valor);
    }

    @Quando("^realizar uma requisição GET no serviço para listar um unico usuários$")
    public void realizarUmaRequisiçãoGETNoServiçoParaListarUmUnicoUsuários() {
        reqresFuncionalidade.requisicaoListaUnicoUsuario();
    }

    @Então("^validar que o id \"([^\"]*)\" da lista foi mostrada com sucesso$")
    public void validarQueOIdDaListaFoiMostradaComSucesso(String valor) {
        Assert.assertEquals(valor, VariaveisEstaticas.getBody());

    }
        //Usuario não encontrado

    @Então("^validar que o id \"([^\"]*)\" da lista não foi encontrado$")
    public void validarQueOIdDaListaNãoFoiEncontrado(String valor)  {
        Assert.assertNotEquals(valor, VariaveisEstaticas.getBody());

    }
     // Recurso da Lista

    @Quando("^realizar as requisição GET no serviço para  usuário desconhecido$")
    public void realizarAsRequisiçãoGETNoServiçoParaUsuárioDesconhecido() {
        reqresFuncionalidade.requisicaoRecurso();
    }
     // Unico usuário desconhecido

    @Quando("^realizar as requisição GET no serviço para unico usuario$")
    public void realizarAsRequisiçãoGETNoServiçoParaUnicoUsuario() {
        reqresFuncionalidade.requisicaoRecurso();
    }

    @Quando("^realizar as requisições Get  no serviço pra listar usuario não encontrado$")
    public void realizarAsRequisiçõesGetNoServiçoPraListarUsuarioNãoEncontrado() {
        reqresFuncionalidade.requisicaoRecursoNaoEncontrado();
    }

    // Registro de usuario

    @Dado("^recuperar as informações de um email \"([^\"]*)\" e senha \"([^\"]*)\" válido$")
    public void recuperarAsInformaçõesDeUmEmailESenhaVálido(String email, String senha )  {
        reqresFuncionalidade.getBodyUser(email, senha);
    }

    @Quando("^realizar uma requisição POST no serviço para registro do usuário$")
    public void realizarUmaRequisiçãoPOSTNoServiçoParaRegistroDoUsuário() {
        reqresFuncionalidade.requisicaoRegistroUsuario();
    }
    //  Sem registro

    @Quando("^realizar uma requisição POST no serviço para registro$")
    public void realizarUmaRequisiçãoPOSTNoServiçoParaRegistro() {
        reqresFuncionalidade.requisicaoSemRegistro();
    }

    @Então("^validar a mensagem de erro  \"([^\"]*)\"$")
    public void validarAMensagemDeErro(String mensagem)  {
        Assert.assertEquals(mensagem, VariaveisEstaticas.getBody());

    }
      // login com sucesso
    @Então("^validar a mensagem na tela \"([^\"]*)\"$")
    public void validarAMensagemNaTela(String mensagem)  {
        Assert.assertEquals(mensagem, VariaveisEstaticas.getBody());

    }

    @Quando("^realizar uma requisição POST no serviço para o login$")
    public void realizarUmaRequisiçãoPOSTNoServiçoParaOLogin() {
        reqresFuncionalidade.requisicaoLogin();
    }


    @Quando("^realizar uma requisição POST no serviço para do login$")
    public void realizarUmaRequisiçãoPOSTNoServiçoParaDoLogin() {
        reqresFuncionalidade.requisicaoSemLogin();
    }
}

