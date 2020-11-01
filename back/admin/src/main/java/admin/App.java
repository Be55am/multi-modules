package admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The App Main class
 */
@SpringBootApplication
@ComponentScan(basePackages = {"goldminds.controllers", "goldminds.oauthsecurity"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
