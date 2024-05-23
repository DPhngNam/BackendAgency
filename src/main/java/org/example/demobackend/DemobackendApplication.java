package org.example.demobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemobackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemobackendApplication.class, args);
    }

}
