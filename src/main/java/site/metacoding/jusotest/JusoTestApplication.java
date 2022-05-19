package site.metacoding.jusotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JusoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JusoTestApplication.class, args);
	}

}
