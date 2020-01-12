package consumer;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import static io.restassured.RestAssured.given;

@RestController
public class UpperCaseGreetingController {

    private RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://localhost:8080")
            .build();

    @GetMapping(value = "/greeting")
    public String greetingUpperCase(@RequestParam(value = "name", defaultValue = "default") String name) {
        try {
//            String content = given().baseUri(PRODUCER_URL)
//                    .param("name", name)
            String content = requestSpecification
                    .param("name", name)
                    .get("/greeting")
                    .path("content");

            return content.toUpperCase();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
        }
    }
}
