package consumer;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UpperCaseGreetingController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UpperCaseGreetingController.class);

    @Autowired
    private GreetingService greetingService;

    @GetMapping(value = "/greeting")
    public String greetingUpperCase(@RequestParam(value = "name", defaultValue = "default") String name) {
        try {
            String content = greetingService.greeting(name);
            log.info(content);
            return content.toUpperCase();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
