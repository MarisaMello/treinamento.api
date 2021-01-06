package br.com.etech.api.funcionalidades;

import br.com.etech.commons.PropertiesManager;
import br.com.etech.commons.VariaveisEstaticas;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.*;


public class DadosMeteorologicosFunc {

    Map<String, String> params = new HashMap<>();

    public void getParamsByCountry(String nome) {
        params.put("q", nome);
        params.put("appid", "cc7d547753a20fb8fd136a18c5e22eff");

        VariaveisEstaticas.setParams(params);

    }


    public void requisicaoByCountry() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                        .when()
                        .get("https://api.openweathermap.org/data/2.5/weather?q={q}&appid={appid}")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("name").toString());

    }

    public void getParamsCoordenadas(String latitude, String longitude) {
        params.put("lat", latitude);
        params.put("lon", longitude);

        VariaveisEstaticas.setParams(params);
    }


    public void getParamsAppid() {
        params.put("appid", PropertiesManager.getPropertiesValue("TOKEN"));

    }


    public void requisicaoCoordenadas() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                        .when()
                        .get("https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={appid}")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("name").toString());
    }
     // Zip Code

    public void getParamsZip(String zip) {
        params.put("zip",zip);

        VariaveisEstaticas.setParams(params);
    }

    public void requisicaoZipCode() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                        .when()
                        .get("https://api.openweathermap.org/data/2.5/weather?zip={zip}&appid={appid}")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("name").toString());
    }
    // Bbox
    public void getParamsBbox(String bbox) {
        params.put("bbox",bbox);

        VariaveisEstaticas.setParams(params);
    }

    public void requisicaoBbox() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                        .when()
                        .get("https://api.openweathermap.org/data/2.5/box/city?bbox={bbox}&appid={appid}")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("list").toString());
    }
    // Circle

    public void getparamsCircle(String lat, String lon, String cnt) {
        params.put("lat", lat);
        params.put("lon", lon);
        params.put("cnt", cnt);

        VariaveisEstaticas.setParams(params);
    }

    public void requisicaoCircle() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                        .when()
                        .get("https://api.openweathermap.org/data/2.5/find?lat={lat}&lon={lon}&cnt={cnt}&appid={appid}")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("list").toString());
    }

    public void getParamsId(String id) {
        params.put("id", id);

        VariaveisEstaticas.setParams(params);
    }

    public void requisicaoId() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                        .when()
                        .get("https://api.openweathermap.org/data/2.5/group?id={id}&appid={appid}")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("list").toString());
    }
}
