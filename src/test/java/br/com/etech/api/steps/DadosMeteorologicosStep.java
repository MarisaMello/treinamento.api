package br.com.etech.api.steps;

import br.com.etech.api.funcionalidades.DadosMeteorologicosFunc;
import br.com.etech.commons.VariaveisEstaticas;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class DadosMeteorologicosStep {

    DadosMeteorologicosFunc dadosMeteorologicosFunc = new DadosMeteorologicosFunc();

    @Dado("^recuperar os parametros necessarios para localização pelo nome \"([^\"]*)\"$")
    public void recuperarOsParametrosNecessarios(String nome){
        dadosMeteorologicosFunc.getParamsByCountry(nome);
    }

    @Quando("^realizar uma requisição GET no serviço pelo nome do país$")
    public void realizarUmaRequisiçãoGETNoServiçoPeloNomeDoPaís() {
        dadosMeteorologicosFunc.requisicaoByCountry();
    }

    @Então("^devo validar o nome \"([^\"]*)\" no retorno do serviço$")
    public void devoValidarONomeNoRetornoDoServiço(String nome) {
        Assert.assertEquals(nome, VariaveisEstaticas.getBody());
    }

    // geographiCoordinates

    @Dado("^recuparar os parametros lat \"([^\"]*)\" e long \"([^\"]*)\"$")
    public void recupararOsParametrosLatELong(String lat, String lon) {
        dadosMeteorologicosFunc.getParamsCoordenadas(lat, lon);
    }

    @E("^informo o appid$")
    public void informoOAppid() {
        dadosMeteorologicosFunc.getParamsAppid();

    }

    @Quando("^realizar uma requisição GET no serviço para cordenadas$")
    public void realizarUmaRequisiçãoGETNoServiçoParaCordenadas() {
        dadosMeteorologicosFunc.requisicaoCoordenadas();
    }

    // zip code

    @Dado("^recuperar os parametros Zip Code \"([^\"]*)\"$")
    public void recuperarOsParametrosZipCode(String zip)  {
        dadosMeteorologicosFunc.getParamsZip(zip);

    }

    @Quando("^realizar uma requisição GET no serviço para zip code$")
    public void realizarUmaRequisiçãoGETNoServiçoParaZipCode() {
        dadosMeteorologicosFunc.requisicaoZipCode();
    }
     // bbox

    @Dado("^recuperar os parametros bbox \"([^\"]*)\"$")
    public void recuperarOsParametrosBbox(String bbox)  {
        dadosMeteorologicosFunc.getParamsBbox(bbox);

    }

    @Quando("^realizar uma requisição GET no serviço para a área retangular$")
    public void realizarUmaRequisiçãoGETNoServiçoParaAÁreaRetangular() {
        dadosMeteorologicosFunc.requisicaoBbox();
    }

    @Então("^devo validar a \"([^\"]*)\"$")
    public void devoValidarA(String list)  {
        Assert.assertNotNull(list, VariaveisEstaticas.getBody());

    }
      // Cities Circle
    @Dado("^recuparar os parametros lat \"([^\"]*)\", long \"([^\"]*)\",cnt \"([^\"]*)\"$")
    public void recupararOsParametrosLatLongCnt(String lat, String lon, String cnt)  {
        dadosMeteorologicosFunc.getparamsCircle(lat,lon,cnt);

    }

    @Quando("^realizar uma requisição GET no serviço para a cidade de circulo$")
    public void realizarUmaRequisiçãoGETNoServiçoParaACidadeDeCirculo() {
        dadosMeteorologicosFunc.requisicaoCircle();
    }
}
