import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create 5 sample BankAccount objects
        BankAccount acct1 = new BankAccount("Alice Smith", "ACCT1001", new BigDecimal("500.00"));
        BankAccount acct2 = new BankAccount("Bob Johnson", "ACCT1002", new BigDecimal("1250.75"));
        BankAccount acct3 = new BankAccount("Carla Green", "ACCT1003", new BigDecimal("0.00"));
        BankAccount acct4 = new BankAccount("David Lee", "ACCT1004", new BigDecimal("9999.99"));
        BankAccount acct5 = new BankAccount("Evelyn White", "ACCT1005", new BigDecimal("250.50"));

        // Print confirmation for quick testing
        System.out.println("Created 5 BankAccount objects for testing:");
        System.out.println("1: " + acct1);
        System.out.println("2: " + acct2);
        System.out.println("3: " + acct3);
        System.out.println("4: " + acct4);
        System.out.println("5: " + acct5);

        // --- Test 1: payBills on acct2 with 3+ transactions ---
        List<String> bills1 = List.of(
                "CGI 123.45",
                "Bellsouth_Telecom 56.78",
                "WaterDept 42.00",
                "ElectricCo 88.10"
        );
        System.out.println("Before (acct2) balance: " + acct2.getBalance());
        acct2.payBills(bills1);
        System.out.println("After  (acct2) balance: " + acct2.getBalance());
        System.out.println("Transactions (acct2):");
        for (String t : acct2.listTransactions()) {
            System.out.println("  " + t);
        }
        System.out.println();

        // --- Test 2: payBills on acct4 with 3+ transactions ---
        List<String> bills2 = List.of(
                "City_Taxes 350.00",
                "InsuranceCo 225.50",
                "InternetISP 79.99",
                "GymMembership 29.99"
        );
        System.out.println("Before (acct4) balance: " + acct4.getBalance());
        acct4.payBills(bills2);
        System.out.println("After  (acct4) balance: " + acct4.getBalance());
        System.out.println("Transactions (acct4):");
        for (String t : acct4.listTransactions()) {
            System.out.println("  " + t);
        }


        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();  // Display the menu options
            System.out.print("Enter your choice: ");

            // Input validation: keep asking until the user types an integer
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // discard the invalid token
            }
            choice = scanner.nextInt(); // read the valid integer

            // Switch executes based on the user's menu choice
            switch (choice) {
                case 1:
                    System.out.println("[View Account Details selected]");

                    break;
                case 2:
                    System.out.println("[Transfer Funds selected]");
                    break;
                case 3:
                    System.out.println("[Pay Bills selected]");
                    break;
                case 4:
                    System.out.println("[Transaction History selected]");
                    break;
                case 5:
                    System.out.println("[Settings selected]");
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    // Runs when the user enters a number not listed in the menu
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // blank line for readability

        } while (choice != 0); // repeat menu until user chooses Exit

        scanner.close(); // release system resources
    }

    // Prints the list of menu options
    private static void printMenu() {
        System.out.println("===== Main Menu =====");
        System.out.println("1. View Account Details");
        System.out.println("2. Transfer Funds");
        System.out.println("3. Pay Bills");
        System.out.println("4. Transaction History");
        System.out.println("5. Settings");
        System.out.println("0. Exit");
    }
}
