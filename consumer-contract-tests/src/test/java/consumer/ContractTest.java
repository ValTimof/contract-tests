package consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(
        ids = {"com.github.epam-valerii:producer-contact-tests:+:stubs:+"},
        stubsMode = StubRunnerProperties.StubsMode.CLASSPATH)
public class ContractTest {
    @LocalServerPort
    private int consumerPort;
    @StubRunnerPort("producer-contact-tests")
    private int producerPort;

    @Test
    void test1() {
//        given()
//                .log().all()
//                .when()
//                .post(url + RELOAD_DAILY_RUN)
//
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body(MESSAGE_PATH, containsString(SUCCESSFUL_MESSAGE_VALUE))
//                .body(JOB_ID_PATH, containsString(JOB_ID));
    }
}
