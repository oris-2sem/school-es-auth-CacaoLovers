package ru.itis;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.app.Client;

@SpringBootApplication
@EnableJpaRepositories
@AllArgsConstructor
public class SchoolBasicCrudApplication {

    /*public final Client client;

    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            client.work();
            client.workWithData();
        };
    }*/


    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(SchoolBasicCrudApplication.class, args);
    }

}
