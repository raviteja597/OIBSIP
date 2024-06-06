import java.util.Scanner;

class OnlineExam {
    private boolean isLoggedIn = false;

    public boolean login(String username, String password) {
       if ((username.equals("user123") && password.equals("pass123")) || (username.equals("admin123") && password.equals("pass456"))) {
           isLoggedIn = true;
           return true;
       } else {
           return false;
       }
    }
    public void updateProfile() {
        if (isLoggedIn) {
            System.out.println("Updating profile...");
        } else {
            System.out.println("Login required for this action.");
        }
    }

    public void selectAnswers() {
        if (isLoggedIn) {
            System.out.println("Selecting answers for MCQs...");
        } else {
            System.out.println("Login required for this action.");
        }
    }

    public void timerAndAutoSubmit() {
        if (isLoggedIn) {
            System.out.println("Timer started. Auto-submitting answers...");
        } else {
            System.out.println("Login required for this action.");
        }
    }

    public void closeSession() {
        if (isLoggedIn) {
            System.out.println("Closing session and logging out...");
            isLoggedIn = false;
        } else {
            System.out.println("Already logged out.");
        }
    }
}

public class OnlineExamination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OnlineExam onlineExam = new OnlineExam();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (onlineExam.login(username, password)) {
            System.out.println("Login successful. Welcome!");
            while (true) {
                System.out.println("\nSelect an action:");
                System.out.println("1. Update Profile and Password");
                System.out.println("2. Select answers for MCQs");
                System.out.println("3. Timer and Auto Submit");
                System.out.println("4. Close session and Logout");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        onlineExam.updateProfile();
                        break;
                    case 2:
                        onlineExam.selectAnswers();
                        break;
                    case 3:
                        onlineExam.timerAndAutoSubmit();
                        break;
                    case 4:
                        onlineExam.closeSession();
                        break;
                    case 5:
                        System.out.println("Exiting the system.");
                        onlineExam.closeSession();
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Login failed.");
        }
    }
}
