package poep3;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

//Java string - javatpoint (no date) www.javatpoint.com. Available at: https://www.javatpoint.com/java-string (Accessed: 09 June 2023). 
//Hartman, J. (2023) Java string manipulation: Functions and methods with example, Guru99. Available at: https://www.guru99.com/java-strings.html (Accessed: 09 June 2023). 
//https://www.google.com/search?q=how+to+handle+strings+java+netbeans&biw=1280&bih=577&tbm=vid&sxsrf=APwXEdeEhU4YHq6-xD4ZqRA4Ct3-w1rVrA%3A1686311944071&ei=CBSDZNztA-aC9u8P4YyN6AM&ved=0ahUKEwjckaDDkbb_AhVmgf0HHWFGAz0Q4dUDCA0&uact=5&oq=how+to+handle+strings+java+netbeans&gs_lcp=Cg1nd3Mtd2l6LXZpZGVvEAMyBQghEKABOgQIIxAnOgUIABCABDoGCAAQFhAeOggIABAWEB4QCjoICCEQFhAeEB06BwghEKABEAo6CAgAEAgQHhANOggIABCKBRCGA1C7Blj0OmDaQWgAcAB4AIABzgOIAcUqkgEGMy0xMy4ymAEAoAEBwAEB&sclient=gws-wiz-video#fpstate=ive&vld=cid:0a052a4d,vid:J8JHOFwB6oM
//Add junit5 jar files.2022.Youtube.added by VCSOIT.[Online].Available at:https://www.youtube.com/watch?v=fQaUsfEzGdw&list=PL480DYS-b_kfHSYf2yzLgto_mwDr_U-Q6&index=3 [Accessed 30 April 2023]

public class PoeP3 {
    public static String firstname;
    public static String lastname;
    public static String username;
    public static String userpassword;
    public static boolean loggedIn = false;
    public static int Totalhours = 0;
    public static int taskCount = 0;
    public static List<String> developerList = new ArrayList<>();
    public static List<String> taskNamesList = new ArrayList<>();
    public static List<String> taskIDList = new ArrayList<>();
    public static List<Integer> taskDurationList = new ArrayList<>();
    public static List<String> taskStatusList = new ArrayList<>();
    

  
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

   //Loops in java: Java for loop (syntax, program, example) - javatpoint (no date) www.javatpoint.com. Available at: https://www.javatpoint.com/java-for-loop (Accessed: 09 June 2023). 
   //Java for loop (no date) Programiz. Available at: https://www.programiz.com/java-programming/for-loop (Accessed: 09 June 2023). 
   //(No date a) Programiz. Available at: https://www.programiz.com/java-programming/for-loop (Accessed: 09 June 2023). 
   //(No date a) Google search. Google. Available at: https://www.google.com/search?q=creating%2Band%2Bworking%2Bwith%2Bloops%2Bjava&amp;sxsrf=APwXEdd_QtS66YwBKnB-i55O9YGzYK4Zow%3A1686312393005&amp;source=lnms&amp;tbm=vid&amp;sa=X&amp;ved=2ahUKEwiLgqmZk7b_AhWEilwKHfMVAEAQ_AUoAXoECAEQAw&amp;biw=1280&amp;bih=577&amp;dpr=1.5#fpstate=ive&amp;vld=cid:7a19a459,vid:hs45eeZ326U (Accessed: 09 June 2023)
   //(2023) GeeksforGeeks. GeeksforGeeks. Available at: https://www.geeksforgeeks.org/java-do-while-loop-with-examples/ (Accessed: 09 June 2023). 
    
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
        firstname = JOptionPane.showInputDialog("Please enter your name:");
        lastname = JOptionPane.showInputDialog("Please enter your surname:");
        username = JOptionPane.showInputDialog("Please enter a username (No longer than 5 characters and must contain an underscore):");

        while (!usernameValidity(username)) {
            username = JOptionPane.showInputDialog("The username is invalid, please try again:");
        }

        userpassword = JOptionPane.showInputDialog("Please enter a password (At least 8 characters, must contain a capital letter, digit, and special character):");

        while (!passwordComplexity(userpassword)) {
            userpassword = JOptionPane.showInputDialog("Password is invalid, please try again:");
        }

        return "Registration successful";
    }

   
    public static boolean loginUser() {
        while (!loggedIn) {
            String loginUsername = JOptionPane.showInputDialog("Please enter your username to login:");
            String loginPassword = JOptionPane.showInputDialog("Please enter your password to login:");

            if (loginUsername.equals(username) && loginPassword.equals(userpassword)) {
                loggedIn = true;
            } else {
                JOptionPane.showMessageDialog(null, "Username or password is incorrect, please try again");
            }
        }
        return loggedIn;
    }

   
    public static boolean loginStatus() {
        loggedIn = true;
        JOptionPane.showMessageDialog(null, "Welcome " + firstname + " " + lastname + ", it is good to see you again!");
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");

        return loggedIn;
    }

    
    public static void addTaskDetails(TaskClass task) {
        developerList.add(task.getDeveloperFirstName() + " " + task.getDeveloperLastName());
        taskNamesList.add(task.getTaskName());
        taskIDList.add(task.getTaskID());
        taskDurationList.add(task.getTaskDuration());
        taskStatusList.add(task.getTaskStatus());
    }

    // Method to display tasks with status "done"
    public static void displayTasksWithStatusDone() {
        StringBuilder output = new StringBuilder("Tasks with status 'done':\n");

        for (int i = 0; i < taskStatusList.size(); i++) {
            if (taskStatusList.get(i).equalsIgnoreCase("done")) {
                output.append("Developer: ").append(developerList.get(i)).append("\n");
                output.append("Task Name: ").append(taskNamesList.get(i)).append("\n");
                output.append("Task Duration: ").append(taskDurationList.get(i)).append(" hours\n");
                output.append("------------------------\n");
            }
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }

    
    public static void displayTaskWithLongestDuration() {
        int maxDuration = -1;
        int maxDurationIndex = -1;

        for (int i = 0; i < taskDurationList.size(); i++) {
            if (taskDurationList.get(i) > maxDuration) {
                maxDuration = taskDurationList.get(i);
                maxDurationIndex = i;
            }
        }

        if (maxDurationIndex != -1) {
            StringBuilder output = new StringBuilder("Task with longest duration:\n");
            output.append("Developer: ").append(developerList.get(maxDurationIndex)).append("\n");
            output.append("Task Duration: ").append(maxDuration).append(" hours\n");
            output.append("------------------------\n");

            JOptionPane.showMessageDialog(null, output.toString());
        }
    }

   
    public static void searchTaskByName(String taskName) {
        StringBuilder output = new StringBuilder("Search results for task name: ").append(taskName).append("\n");

        for (int i = 0; i < taskNamesList.size(); i++) {
            if (taskNamesList.get(i).equalsIgnoreCase(taskName)) {
                output.append("Task Name: ").append(taskNamesList.get(i)).append("\n");
                output.append("Developer: ").append(developerList.get(i)).append("\n");
                output.append("Task Status: ").append(taskStatusList.get(i)).append("\n");
                output.append("------------------------\n");
            }
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }

    
    public static void searchTasksByDeveloper(String developerName) {
        StringBuilder output = new StringBuilder("Tasks assigned to developer: ").append(developerName).append("\n");

        for (int i = 0; i < developerList.size(); i++) {
            if (developerList.get(i).equalsIgnoreCase(developerName)) {
                output.append("Task Name: ").append(taskNamesList.get(i)).append("\n");
                output.append("Task Status: ").append(taskStatusList.get(i)).append("\n");
                output.append("------------------------\n");
            }
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }

   
    public static void deleteTaskByName(String taskName) {
        int index = -1;
        for (int i = 0; i < taskNamesList.size(); i++) {
            if (taskNamesList.get(i).equalsIgnoreCase(taskName)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            developerList.remove(index);
           taskNamesList.remove(index);
            taskIDList.remove(index);
            taskDurationList.remove(index);
            taskStatusList.remove(index);
            JOptionPane.showMessageDialog(null, "Task '" + taskName + "' has been deleted.");
        } else {
            JOptionPane.showMessageDialog(null, "Task '" + taskName + "' not found.");
        }
    }

    
    public static void displayTaskReport() {
        StringBuilder output = new StringBuilder("Task Report:\n");

        for (int i = 0; i < taskNamesList.size(); i++) {
            output.append("Task Name: ").append(taskNamesList.get(i)).append("\n");
            output.append("Developer: ").append(developerList.get(i)).append("\n");
            output.append("Task ID: ").append(taskIDList.get(i)).append("\n");
            output.append("Task Duration: ").append(taskDurationList.get(i)).append(" hours\n");
            output.append("Task Status: ").append(taskStatusList.get(i)).append("\n");
            output.append("------------------------\n");
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }

   
    public static void addTasks(int count) {
        for (int i = 0; i < count; i++) {
            TaskClass task = createTask();
            JOptionPane.showMessageDialog(null, "Task successfully captured\n" + task.printTaskDetails());
            addTaskDetails(task);
            taskCount++;

            if (taskCount == count) {
                JOptionPane.showMessageDialog(null, "All tasks have been captured. Total hours of all tasks: " + calculateTotalHours());
            }
        }
    }

   
    public static int calculateTotalHours() {
        int totalHours = 0;
        for (int i = 0; i < taskDurationList.size(); i++) {
            totalHours += taskDurationList.get(i);
        }
        return totalHours;
    }

  
    public static TaskClass createTask() {
        String taskName = JOptionPane.showInputDialog("Enter the task name:");
        String taskDescription = JOptionPane.showInputDialog("Enter the task description (max 50 characters):");

        while (taskDescription.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            taskDescription = JOptionPane.showInputDialog("Enter the task description (max 50 characters):");
        }

        String developerFirstName = JOptionPane.showInputDialog("Enter the developer's first name:");
        String developerLastName = JOptionPane.showInputDialog("Enter the developer's last name:");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration in hours:"));

        String[] statusOptions = {"To Do", "Done", "Doing"};
        int statusChoice = JOptionPane.showOptionDialog(null, "Select the task status:", "Task Status",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, statusOptions, statusOptions[0]);

        String taskStatus = statusOptions[statusChoice];

        return new TaskClass(taskName, taskDescription, developerFirstName, developerLastName, taskDuration, taskStatus);
    }

    public static void main(String[] args) {
        registerUser();
        if (loginUser()) {
            loginStatus();
            handleMenuOptions();
        } else {
            JOptionPane.showMessageDialog(null, "Username or password is incorrect.");
        }
    }

    public static void handleMenuOptions() {
        boolean quit = false;
        while (!quit) {
            String option = JOptionPane.showInputDialog(
                    "Please select an option:\n"
                            + "1) Add tasks\n"
                            + "2) Show report\n"
                            + "3) Display tasks with status 'done'\n"
                            + "4) Display task with longest duration\n"
                            + "5) Search task by name\n"
                            + "6) Search tasks by developer\n"
                            + "7) Delete task by name\n"
                            + "8) Quit"
            );

            switch (option) {
                case "1":
                    int taskCount = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasksto add:"));
                    addTasks(taskCount);
                    break;
                case "2":
                    displayTaskReport();
                    break;
                case "3":
                    displayTasksWithStatusDone();
                    break;
                case "4":
                    displayTaskWithLongestDuration();
                    break;
                case "5":
                    String taskName = JOptionPane.showInputDialog("Enter the task name to search:");
                    searchTaskByName(taskName);
                    break;
                case "6":
                    String developerName = JOptionPane.showInputDialog("Enter the developer name to search tasks:");
                    searchTasksByDeveloper(developerName);
                    break;
                case "7":
                    String taskToDelete = JOptionPane.showInputDialog("Enter the task name to delete:");
                    deleteTaskByName(taskToDelete);
                    break;
                case "8":
                    quit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }
}
