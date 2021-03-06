package pe.edu.upc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProgramacionWebSpringSi63Application implements CommandLineRunner {

    @Autowired
    private PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(ProgramacionWebSpringSi63Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String pass = "gerson";

        System.out.println(encoder.encode(pass));
    }

}