package br.edu.ifb.aop.trabalho1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Trabalho1Application {

    public static void main(String[] args) {
        SpringApplication.run(Trabalho1Application.class, args);
    }

}
