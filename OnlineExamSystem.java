import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }
}

public class OnlineExamSystem {
    private static User currentUser;
    private static Timer timer;
    private static int timeRemaining = 60; // Exam duration in seconds

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dummy data for users and questions
        User[] users = {new User("user1", "password1"), new User("user2", "password2")};
        Question[] questions = {
            new Question("What is 2 + 2?", new String[]{"A) 3", "B) 4", "C) 5", "D) 6"}, 1),
            new Question("Which planet is known as the Red Planet?", new String[]{"A) Venus", "B) Mars", "C) Jupiter", "D) Saturn"}, 1),
            new Question("What is the capital of France?", new String[]{"A) London", "B) Berlin", "C) Madrid", "D) Paris"}, 3)
        };

        while (true) {
            if (currentUser == null) {
                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        currentUser = login(users, scanner);
                        if (currentUser != null) {
                            startExam(questions, scanner);
                        }
                        break;
                    case 2:
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("1. Update Profile and Password");
                System.out.println("2. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        updateProfile(users, currentUser, scanner);
                        break;
                    case 2:
                        currentUser = null;
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static User login(User[] users, Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                System.out.println("Login successful.");
                return user;
            }
        }

        System.out.println("Login failed. Invalid username or password.");
        return null;
    }

    private static void startExam(Question[] questions, Scanner scanner) {
        System.out.println("Welcome to the Online Exam!");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeRemaining--;
                if (timeRemaining == 0) {
                    System.out.println("Time's up! Exam submitted.");
                    submitExam(questions, scanner);
                }
            }
        }, 1000, 1000); // Timer updates every second

        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            Question question = questions[i];
            System.out.println("Question " + (i + 1) + ": " + question.getQuestion());
            String[] options = question.getOptions();
            for (String option : options) {
                System.out.println(option);
            }
            System.out.print("Your choice (enter A, B, C, or D): ");
            String choice = scanner.nextLine().toUpperCase();
            int answer = choice.charAt(0) - 'A';

            if (answer >= 0 && answer < options.length) {
                if (question.isCorrect(answer)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong answer.");
                }
            } else {
                System.out.println("Invalid choice. Skipping this question.");
            }
        }

        timer.cancel();
        System.out.println("Exam finished. Your score: " + score + " out of " + questions.length);
        submitExam(questions, scanner);
    }

    private static void submitExam(Question[] questions, Scanner scanner) {
        timer.cancel();
        System.out.println("Exam submitted. Returning to the main menu.");
        currentUser = null;
        timeRemaining = 60; // Reset timer
    }

    private static void updateProfile(User[] users, User currentUser, Scanner scanner) {
        System.out.print("Enter your new password: ");
        String newPassword = scanner.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(currentUser.getUsername())) {
                user = new User(user.getUsername(), newPassword);
                currentUser = user; // Update the currentUser with the new password
                System.out.println("Password updated successfully.");
                return;
            }
        }
    }
}
