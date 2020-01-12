package consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;

@Service
public class GreetingService {

    @Value("${producer.url}")
    private String producerUrl;

    public String greeting(String name) {
        return given()
                .baseUri(producerUrl)
                .param("name", name)
                .get("/greeting")
                .path("content");
    }
}
