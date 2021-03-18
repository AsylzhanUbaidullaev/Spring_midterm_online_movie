package com.asylzhan.spring;

import com.asylzhan.spring.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        MoviePlayer moviePlayer = context.getBean("moviePlayer", MoviePlayer.class);
        moviePlayer.runMoviePlayer();
    }
}
