package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

/**
 * Created by Allen on 2017/6/30.
 */
@SpringBootApplication
@ImportResource("/hello/integration.xml")
public class IntegratingApplication {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new SpringApplication(IntegratingApplication.class).run(args);
        System.out.println("args = [" + args + "]");
        System.in.read();
        ctx.close();
    }
}
