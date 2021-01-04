package br.com.etech.api.funcionalidades;

import br.com.etech.commons.VariaveisEstaticas;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class UsuariosFunc {

    Faker faker = new Faker(new Locale("pt-BR"));
    Map<String, String> params = new HashMap<>();
    String job = faker.job().field();
    String url = "https://reqres.in/api/users/";

    public void getBodyUser(){
        params.put("name", faker.name().firstName());
        params.put("job", job);

        VariaveisEstaticas.setRequestBody(params);
    }

    public void putBodyUser(){
        params.put("name", faker.name().firstName());
        params.put("job", job);

        VariaveisEstaticas.setRequestBody(params);
    }

    public void requisicaoPostUser(){
        Response response =
            given()
                .contentType("application/json; charset=utf-8")
                .body(VariaveisEstaticas.getRequestBody())
            .when()
                .post(url)
            .then()
                .log().all()
                .statusCode(201)
                .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("id").toString());
    }

    public void requisicaoPutUser(){
        Response response =
            given()
                .contentType("application/json; charset=utf-8")
                .body(VariaveisEstaticas.getRequestBody())
            .when()
                .put(url + "3")
            .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("updatedAt").toString());
    }

    public void requisicaoDeleteUser(){
        Response response =
            given()
                .contentType("application/json; charset=utf-8")
            .when()
                .delete(url + "2")
            .then()
                .log().all()
                .statusCode(204)
                .extract().response();

        VariaveisEstaticas.setCookie(response.getCookie("__cfduid"));
    }
}
