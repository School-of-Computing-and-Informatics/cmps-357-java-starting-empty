import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
