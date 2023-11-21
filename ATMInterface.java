import java.util.Scanner;

class ATM {
    private boolean isUserAuthenticated = false;
    private double balance = 1000;
    public boolean authenticate(int userId, int userPin) {
        if (userId == 1234 && userPin == 5678) {
            isUserAuthenticated = true;
            return true;
        } else {
            return false;
        }
    }

    public void showOptions() {
        if (isUserAuthenticated) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("ATM Options:");
                System.out.println("1. Transactions History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Check Balance");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Transaction history:");
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        if (withdrawAmount > 0 && withdrawAmount <= balance) {
                            balance -= withdrawAmount;
                            System.out.println("Withdrawn: $" + withdrawAmount);
                        } else {
                            System.out.println("Invalid amount or insufficient balance.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        if (depositAmount > 0) {
                            balance += depositAmount;
                            System.out.println("Deposited: $" + depositAmount);
                        } else {
                            System.out.println("Invalid amount.");
                        }
                        break;
                    case 4:
                        System.out.println("Transfer options:");
                        break;
                    case 5:
                        System.out.println("Current Balance: $" + balance);
                        break;
                    case 6:
                        System.out.println("Exiting ATM.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("User login required for these actions.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        if (atm.authenticate(userId, pin)) {
            System.out.println("Login successful. Welcome to the ATM.");

            atm.showOptions();
        } else {
            System.out.println("Login failed.");
        }
    }
}
