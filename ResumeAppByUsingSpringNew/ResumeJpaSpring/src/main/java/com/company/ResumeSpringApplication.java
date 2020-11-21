package com.company;

import com.company.dao.impl.UserRepository;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResumeSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResumeSpringApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<User> list = userRepository.getAll(null, null, null);
                System.out.println(list);
            }
        };
        return clr;
    }
}


