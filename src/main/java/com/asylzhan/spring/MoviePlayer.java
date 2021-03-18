package com.asylzhan.spring;

import com.asylzhan.spring.controller.MovieController;
import com.asylzhan.spring.controller.UserController;
import com.asylzhan.spring.entity.Movie;
import com.asylzhan.spring.entity.User;
import com.asylzhan.spring.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MoviePlayer {
    Scanner in = new Scanner(System.in);

    @Autowired
    private UserController userController;
    @Autowired
    private MovieController movieController;
    @Autowired
    private MovieRepo movieRepo;

    private boolean authStatus;
    private boolean isClient;
    private String currentEmail;

    public MoviePlayer() {
        this.authStatus = false;
        this.isClient = false;
        this.currentEmail = null;
    }

    private void signIn() {
        System.out.print("Email: ");
        String email = in.next();
        System.out.print("Password:");
        String password = in.next();

        if(userController.hasUser(email, password)) {
            this.authStatus = true;
            this.isClient = true;
            this.currentEmail = email;
            System.out.println("Welcome " + email);
        } else {
            System.out.println("Email or password is incorrect");
        }
    }

    private void signUp() {
        System.out.println("Email: ");
        String email = in.next();

        // checking email
        if(!userController.hasUser(email)) {
            System.out.print("Password: ");
            String password = in.next();
            System.out.print("Name: ");
            String firstName = in.next();
            System.out.print("Surname: ");
            String lastName = in.next();

            userController.saveUser(new User(firstName, lastName, email, password));
        } else {
            System.out.println("Please, choose other email");
        }
    }

    public void runMoviePlayer() {
        int choice = -1;

        while(choice != 0) {
            if(!authStatus) {
                System.out.println("Please, log in");
                System.out.println("1. Sign in");
                System.out.println("2. Sign up");
                System.out.println("0. Exit");

                choice = in.nextInt();

                switch (choice) {
                    case 1:
                        signIn();
                        break;
                    case 2:
                        signUp();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Incorrect choice");
                }
            } else if(authStatus && isClient) {
                System.out.println("Welcome to Online Movie App");
                System.out.println("1. Show all movie list");
                System.out.println("2. Find movie by genre");
                System.out.println("0. Log out");

                choice = in.nextInt();

                switch (choice) {
                    case 1:
                        List<Movie> movies = movieController.getAllMovies();
                        for(int i = 0; i < movies.size(); i++) {
                            System.out.println(i + ") Movie name: " + movies.get(i).getName());
                            System.out.println("  Movie genre: " + movies.get(i).getGenre());
                            System.out.println("  Movie premiere: " + movies.get(i).getPremiere());
                            System.out.println("  Movie director: " + movies.get(i).getDirector());
                            System.out.println("========================");
                        }
                        break;
                    case 2:
                        System.out.print("Enter a genre: ");
                        String genre = in.next();
                        System.out.println(movieRepo.getMovieByGenre(genre));
//                        movieRepo.getMovieByGenre(genre);
//                        movieController.getAllMoviesByGenre(genre);
//                        for(int i = 0; i < movies.size(); i++){
//                            if(genre.equals(movies.get(i).getGenre())) {
//                                System.out.println(i + ") Movie name: " + movies.get(i).getName());
//                                System.out.println("  Movie genre: " + movies.get(i).getGenre());
//                                System.out.println("  Movie premiere: " + movies.get(i).getPremiere());
//                                System.out.println("  Movie director: " + movies.get(i).getDirector());
//                                System.out.println("========================");
//                            } else if(!genre.equals(movies.get(i).getGenre())) {
//                                continue;
//                            } else {
//                                System.out.println("There isn't movie for this genre");
//                            }
//                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Incorrect choice");
                }
            }
        }
    }
}
