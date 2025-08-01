package stepdefinitions;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import io.restassured.response.Response;
import utils.DBUtils;
import utils.DataGenerator;

public class NotificationSteps {
    private Response response;
    private String dni;

    @Given("el usuario con DNI {string} y email enrolado")
    public void el_usuario_con_dni_y_email_enrolado(String dni) throws Exception {
        assertTrue(DBUtils.usuarioTieneEmailEnrolado(dni));
        this.dni = dni;
    }

    @When("realiza una compra con tarjeta {string} de ${int} con autorización {string}")
    public void realiza_una_compra(String brand, Integer amount, String authCode) {
        String body = DataGenerator.buildNotificationJson(this.dni, brand, amount, authCode);
        response = given()
            .baseUri("https://cardsnotification")
            .header("Content-Type", "application/json")
            .body(body)
            .when()
            .post("/notify");
    }

    @Then("se genera una notificación con estado {string}")
    public void se_genera_notificacion(String estado) {
        response.then().statusCode(200);
        assertTrue(response.getBody().asString().contains(estado));
    }
}
