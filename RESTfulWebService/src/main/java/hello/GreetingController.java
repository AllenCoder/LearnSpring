package hello;

import org.springframework.http.*;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Allen on 2017/6/29.
 */
@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping(value = "/greeting")
    public HttpEntity<byte[]> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name,
            @RequestParam(value = "value", required = false, defaultValue = "World") String value) throws IOException {
        File file = new File("170717007.xml");
        byte[] document = FileCopyUtils.copyToByteArray(file);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "xml"));
        header.set("Content-Disposition", "inline; filename=" + file.getName());
        header.setContentLength(document.length);
        return new HttpEntity<>(document, header);
    }

    @RequestMapping(value = "getJson")
    public HttpEntity<Greeting> getJson(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name,
            @RequestParam(value = "value", required = false, defaultValue = "World") String value) {
        Greeting greeting = new Greeting(String.format(TEMPLATE, name), value);
        greeting.add(linkTo(methodOn(GreetingController.class).getJson(name, value)).withSelfRel());
        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }

    @RequestMapping(value = "activities")
    public HttpEntity<Greeting> getActivities(
            @RequestBody Upload upload) {
        Greeting greeting = new Greeting(String.format(TEMPLATE, "name"), "value");
        greeting.add(linkTo(methodOn(GreetingController.class).getJson("name", "value")).withSelfRel());
        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }

}