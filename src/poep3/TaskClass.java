package poep3;

class TaskClass {

    public static String Taskname;
    public static String TaskDescription;
    public static String DeveloperFirstname;
    public static String DeveloperLastname;
    private int Taskduration;
    private int TaskNumber;
    private String TaskID;
    private String Taskstatus;
    private static int Totalhours = 0;

    public TaskClass(String taskName, String taskDescription, String developerFirstName, String developerLastName,
            int taskDuration, String taskStatus) {
        this.Taskname = taskName;
        this.TaskDescription = taskDescription;
        this.DeveloperFirstname = developerFirstName;
        this.DeveloperLastname = developerLastName;
        this.Taskduration = taskDuration;
        this.TaskNumber = PoeP3.taskCount;
        this.TaskID = createTaskID();
        this.Taskstatus = taskStatus;
        Totalhours += taskDuration;
    }

    public String getTaskName() {
        return Taskname;
    }

    public String getTaskDescription() {
        return TaskDescription;
    }

    public String getDeveloperFirstName() {
        return DeveloperFirstname;
    }

    public String getDeveloperLastName() {
        return DeveloperLastname;
    }

    public int getTaskDuration() {
        return Taskduration;
    }

    public int getTaskNumber() {
        return TaskNumber;
    }

    public String getTaskID() {
        return TaskID;
    }

    public String getTaskStatus() {
        return Taskstatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.Taskstatus = taskStatus;
    }


    public boolean checkTaskDescription() {
        return TaskDescription.length() <= 50;
    }


    private String createTaskID() {
        String firstTwoLetters = Taskname.substring(0, Math.min(Taskname.length(), 2)).toUpperCase();
        String lastThreeLetters = DeveloperLastname.substring(Math.max(0, DeveloperLastname.length() - 3)).toUpperCase();
        return firstTwoLetters + ":" + TaskNumber + ":" + lastThreeLetters;
    }


    public String printTaskDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Task Name: ").append(Taskname).append("\n")
                .append("Task Number: ").append(TaskNumber).append("\n")
                .append("Task Description: ").append(TaskDescription).append("\n")
                .append("Developer Details: ").append(DeveloperFirstname).append(" ").append(DeveloperLastname).append("\n")
                .append("Task Duration: ").append(Taskduration).append(" hours").append("\n")
                .append("Task ID: ").append(TaskID).append("\n")
                .append("Task Status: ").append(Taskstatus);
        return details.toString();
    }

}
