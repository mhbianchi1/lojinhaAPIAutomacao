package modulos.produto;

import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UsuariosTest {
    @BeforeEach
    public void beforeEach() {
        //Configurando os dados da API Rest da Lojinha
        baseURI = "http://165.227.93.41";
        //port = 8080;
        basePath = "/lojinha";
    }

    Random gerador = new Random();

    @Test
    @DisplayName("Validar que ao inserir dados válidos um novo usuário será criado")
    public void testCriarUsuarioValido(){

        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.criarNovoUsuario("Maria Helena", "mhbianchi"+gerador, "123456"))
        .when()
            .post("/v2/usuarios")
        .then()
            .assertThat()
                .statusCode(201);
    }

    @Test
    @DisplayName("Validar que ao inserir dados de um usuário já existente será retornado status code 409")
    public void testCriarUsuarioRepetido(){
        given()
            .contentType(ContentType.JSON)
            .body(UsuarioDataFactory.criarNovoUsuarioRepetido())
        .when()
            .post("/v2/usuarios")
        .then()
            .assertThat()
                .statusCode(409);
    }

}
