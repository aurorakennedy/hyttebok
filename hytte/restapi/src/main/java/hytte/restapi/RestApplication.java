package hytte.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//launches spring boot server in terminal
@SpringBootApplication
public class RestApplication { //launch using mvn spring-boot:run
    public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
}
