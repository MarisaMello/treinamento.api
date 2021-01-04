package br.com.etech.api.funcionalidades;

import br.com.etech.commons.VariaveisEstaticas;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ReqresFuncionalidade {

    public void getParams(String chave, String valor) {
        Map<String, String> params = new HashMap<>();
        params.put(chave, valor);

        VariaveisEstaticas.setParams(params);

    }
    public void requisicaoListaUsuario(){
        Response response =
                given().pathParams(VariaveisEstaticas.getParams())
                .when().get("https://reqres.in/api/users?page={page}")
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("page").toString());

    }

    public void requisicaoListaUnicoUsuario() {
        Response response =
                given()
                    .pathParams(VariaveisEstaticas.getParams())
                .when()
                    .get("https://reqres.in/api/users/{id}")
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().response();

        VariaveisEstaticas.setBody(response.getBody().asPrettyString());
    }
    public void requisicaoRecurso() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                        .when()
                        .get("https://reqres.in/api/desconhecido/{id}")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("data.id").toString());
    }
    public void requisicaoRecursoNaoEncontrado() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                        .when()
                        .get("https://reqres.in/api/desconhecido/{id}")
                        .then()
                        .log().all()
                        .statusCode(404)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().asPrettyString());
    }

      // Registro usuario

    public void getBodyUser(String email, String senha){
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", senha);

        VariaveisEstaticas.setRequestBody(params);

    }

    public void requisicaoRegistroUsuario() {
        Response response =
                given()
                        .contentType("application/json; charset=utf-8")
                        .body(VariaveisEstaticas.getRequestBody())
                        .when()
                        .post("https://reqres.in/api/register")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();
        VariaveisEstaticas.setBody(response.getBody().path("id").toString());
    }

    public void requisicaoSemRegistro() {
        Response response =
                given()
                        .contentType("application/json; charset=utf-8")
                        .body(VariaveisEstaticas.getRequestBody())
                        .when()
                        .post("https://reqres.in/api/register")
                        .then()
                        .log().all()
                        .statusCode(400)
                        .extract().response();
        VariaveisEstaticas.setBody(response.getBody().path("error").toString());
    }

    public void requisicaoLogin() {
        Response response =
                given()
                        .contentType("application/json; charset=utf-8")
                        .body(VariaveisEstaticas.getRequestBody())
                        .when()
                        .post("https://reqres.in/api/login")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();
        VariaveisEstaticas.setBody(response.getBody().path("token").toString());
    }
}

