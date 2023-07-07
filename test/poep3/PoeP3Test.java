/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package poep3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lab_services_student
 */
public class PoeP3Test {
    
    public PoeP3Test() {
    }

    @Test
    public void testPasswordComplexity() {
       Assertions.assertTrue(PasswordValidator.testPasswordComplexity("Abc@123"));
        Assertions.assertTrue(PasswordValidator.testPasswordComplexity("OpenAI!2023"));
        Assertions.assertFalse(PasswordValidator.testPasswordComplexity("password123")); 
        Assertions.assertFalse(PasswordValidator.testPasswordComplexity("PASS123")); 
        Assertions.assertFalse(PasswordValidator.testPasswordComplexity("OpenAI2023"));  
    }

    @Test
    public void testUsernameValidity() {
         Assertions.assertTrue(UsernameValidator.testUsernameValidity("Mike Smith"));
        Assertions.assertTrue(UsernameValidator.testUsernameValidity( "Samantha Paulson"));
        Assertions.assertFalse(UsernameValidator.testUsernameValidity("john.doe")); 
        Assertions.assertFalse(UsernameValidator.testUsernameValidity("john@doe")); 
        Assertions.assertFalse(UsernameValidator.testUsernameValidity("")); 
    }

  
    public void testRegisterUser() {
        Assertions.assertTrue(userRegistration.registerUser("John", "Doe", "john.doe@example.com", "Abc@123"));
        Assertions.assertTrue(userRegistration.registerUser("Alice", "Smith", "alice.smith@example.com", "OpenAI!2023"));
        Assertions.assertFalse(userRegistration.registerUser("Jane", "Doe", "jane.doe@example.com", "password123")); 
        Assertions.assertFalse(userRegistration.registerUser("Bob", "Johnson", "bob.johnson@example.com", "Pass123")); 
    }

    @Test
    public void testLoginUser() {
        Assertions.assertTrue(userLogin.loginUser("alice.smith@example.com", "OpenAI!2023"));
        Assertions.assertFalse(userLogin.loginUser("john.doe@example.com", "password123")); 
        Assertions.assertFalse(userLogin.loginUser("bob.johnson@example.com", "Pass123")); 
    }

    @Test
    public void testLoginStatus() {
    }

    @Test
    public void testAddTaskDetails() {
    }

    @Test
    public void testDisplayTasksWithStatusDone() {
    }

    @Test
    public void testDisplayTaskWithLongestDuration() {
    }

    @Test
    public void testSearchTaskByName() {
    }

    @Test
    public void testSearchTasksByDeveloper() {
    }

    @Test
    public void testDeleteTaskByName() {
    }

    @Test
    public void testDisplayTaskReport() {
    }

    @Test
    public void testAddTasks() {
    }

    @Test
    public void testCalculateTotalHours() {
    }

    @Test
    public void testCreateTask() {
    }

    @Test
    public void testMain() {
    }

    @Test
    public void testHandleMenuOptions() {
    }
    
}
