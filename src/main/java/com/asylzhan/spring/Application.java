package com.asylzhan.spring;

import com.asylzhan.spring.config.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        MoviePlayer moviePlayer = context.getBean("moviePlayer", MoviePlayer.class);
        moviePlayer.runMoviePlayer();
    }

}
