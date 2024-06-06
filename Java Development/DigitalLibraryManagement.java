import java.util.Scanner;

class Library {
    private boolean isAdminLoggedIn = false;

    public boolean adminLogin(String username, String password) {
        if (username.equals("admin123") && password.equals("pass456")) {
            isAdminLoggedIn = true;
            return true;
        } else {
            return false;
        }
    }

    public void adminActions() {
        if (isAdminLoggedIn) {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Admin actions:");
                System.out.println("1. Update records");
                System.out.println("2. Delete records");
                System.out.println("3. Modify records");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Updating records...");
                        break;
                    case 2:
                        System.out.println("Deleting records...");
                        break;
                    case 3:
                        System.out.println("Modifying records...");
                        break;
                    case 4:
                        System.out.println("Exiting admin session.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Admin login required for these actions.");
        }
    }

    public void userActions() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("User actions:");
            System.out.println("1. View books");
            System.out.println("2. Search for a book");
            System.out.println("3. Issue a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Viewing available books...");
                    break;
                case 2:
                    System.out.println("Searching for a book...");
                    break;
                case 3:
                    System.out.println("Issuing a book...");
                    break;
                case 4:
                    System.out.println("Returning a book...");
                    break;
                case 5:
                    System.out.println("Exiting user session.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

public class DigitalLibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();

        if (library.adminLogin(adminUsername, adminPassword)) {
            System.out.println("Admin login successful. Welcome!");
            library.adminActions();
        } else {
            System.out.println("Admin login failed.");
            System.out.println("Switching to user mode.");
            library.userActions();
        }
    }
}
