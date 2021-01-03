package Polytech.Labaratory4.controller;

import Polytech.Labaratory4.exceptions.BadCredentialsException;
import Polytech.Labaratory4.exceptions.UnacceptableUsernameException;
import Polytech.Labaratory4.exceptions.UserNameAlreadyTakenException;
import Polytech.Labaratory4.model.User;
import Polytech.Labaratory4.service.TicketService;
import Polytech.Labaratory4.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreen {

    private static User currentUser = null;

    private static UserService userService = UserService.getInstance();

    public static void main(String[] args) throws IOException {
        showWelcomeScreen();
    }

    private static void showWelcomeScreen() {
        showWelcomeScreen("");
    }

    private static void showWelcomeScreen(final String message) {
         Polytech.Labaratory4.controller.DisplayUtils.clearScreen();
        Polytech.Labaratory4.controller.DisplayUtils.showUserMessage(message);
        System.out.println("1. Sign in" +
                System.lineSeparator() +
                "2. Sign up" +
                System.lineSeparator() +
                "Choose option..."
        );

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String option = reader.readLine();
            if (option.equals("1")) {
                showSignInScreen();
            } else if (option.equals("2")) {
                showSignUpScreen();
            }else{
                //System.out.println("WRONG INPUT");
                showWelcomeScreen("WRONG INPUT");
            }
            // TODO: else ... process unexpected input {sout(WRONG INPUT); showLoginScreen()}
        } catch (IOException e) {
            showWelcomeScreen();
        }
    }

    private static void showSignInScreen() throws IOException {
        showSignInScreen("");
    }

    private static void showSignInScreen(final String message) throws IOException {
        DisplayUtils.clearScreen();
        DisplayUtils.showUserMessage(message);
        System.out.println("Press esc to go back to welcome screen.");
        System.out.println("Type login: ");

        // check if user clicked esc

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String username = reader.readLine();

        System.out.println("Type password: ");
        String password = reader.readLine();

        try {
            currentUser = userService.login(username, password);
            System.out.println("Your initialization is successful");
            // TODO: open next screen
        } catch (BadCredentialsException e) {
            showSignInScreen("Your username or login is incorrect.\nPlease try again.");
        }
    }

    private static void showSignUpScreen() throws IOException {
        showSignUpScreen("");
    }

    private static void showSignUpScreen(final String message) throws IOException {
        DisplayUtils.clearScreen();
        DisplayUtils.showUserMessage(message);
        System.out.println("Press esc to go back to welcome screen.");
        System.out.println("Create your login: ");
        // check if user clicked esc
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // or here check if user clicked esc
        String username = reader.readLine();

        System.out.println("Create your password:");
        String password = reader.readLine();

        try {
            userService.createUser(username, password);
        } catch (UnacceptableUsernameException | UserNameAlreadyTakenException e) {
            showSignUpScreen(e.getMessage());
        }
        showWelcomeScreen("User was successfully created.");
    }


    public static void logOut() {
        currentUser = null;
        showWelcomeScreen("Good bye");
    }
}
