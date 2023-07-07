package poep3;

import javax.swing.JOptionPane;
import static poep3.PoeP3.loggedIn;
import static poep3.PoeP3.firstname;
import static poep3.PoeP3.userpassword;
import static poep3.PoeP3.lastname;
import static poep3.PoeP3.username;

//Arrays in Java (2023) GeeksforGeeks. Available at: https://www.geeksforgeeks.org/arrays-in-java/ (Accessed: 07 July 2023). 
//Java arrays (no date) Programiz. Available at: https://www.programiz.com/java-programming/arrays (Accessed: 07 July 2023). 
//Vora, B. (2022) Array in Java (with examples), Scaler Topics. Available at: https://www.scaler.com/topics/java/array-in-java/ (Accessed: 07 July 2023). 
//Unit testing: Software testing (2023) GeeksforGeeks. Available at: https://www.geeksforgeeks.org/unit-testing-software-testing/ (Accessed: 07 July 2023). 
public class Login {
    
    public static boolean passwordComplexity(String password) {
        boolean eightCharacters = password.length() >= 8;
        boolean capitalLetter = false;
        boolean digit = false;
        boolean specialCharacter = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                capitalLetter = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if ("!@#$%^&*+=".indexOf(c) >= 0) {
                specialCharacter = true;
            }
        }
        return eightCharacters && capitalLetter && digit && specialCharacter;
    }

   
    public static boolean usernameValidity(String username) {
        boolean fiveCharacters = username.length() == 5;
        boolean underscore = false;

        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            if ("_".indexOf(ch) >= 0) {
                underscore = true;
            }
        }
        return fiveCharacters && underscore;
    }

    
    public static String registerUser() {
        System.out.println("Please enter your name: ");
        firstname = JOptionPane.showInputDialog("Please enter your name:");

        System.out.println("Please enter your surname: ");
        lastname = JOptionPane.showInputDialog("Please enter your surname:");

        System.out.println("Please enter a username(No longer than 5 characters and must contain an underscore): ");
        username = JOptionPane.showInputDialog("Please enter a username(No longer than 5 characters and must contain an underscore):");

        while (!usernameValidity(username)) {
            System.out.println("The username is invalid please try again: ");
            username = JOptionPane.showInputDialog("The username is invalid please try again:");
        }

        System.out.println("Please enter a password(At least 8 characters, must contain a capital letter, digit, and special character): ");
        userpassword = JOptionPane.showInputDialog("Please enter a password(At least 8 characters, must contain a capital letter, digit, and special character):");

        while (!passwordComplexity(userpassword)) {
            System.out.println("Password is invalid please try again: ");
            userpassword = JOptionPane.showInputDialog("Password is invalid please try again:");
        }

        return "Registration successful";
    }

    
    public static boolean loginUser(String loginUsername, String loginPassword) {
        while (!loggedIn) {
            loginUsername = JOptionPane.showInputDialog("Please enter your username to login:");
            loginPassword = JOptionPane.showInputDialog("Please enter your password to login:");

            if (loginUsername.equals(username) && loginPassword.equals(userpassword)) {
                loggedIn = true;
            } else {
                JOptionPane.showMessageDialog(null, "Username or Password is incorrect, please try again");
            }
        }
        return loggedIn;
    }

  
    public static boolean loginStatus() {
        loggedIn = true;
        JOptionPane.showMessageDialog(null, "You have successfully logged in!");

        return loggedIn;
    }
}
