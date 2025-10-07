import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactPhoneBook {

    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println(" Welcome to the Contact Phone Book!");
        System.out.println("Available commands: add, search, list, quit");

        while (true) {
            System.out.print("\nEnter command: ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine().trim();


                    if (phoneBook.containsKey(name)) {
                        System.out.println("Contact '" + name + "' already exists. Updating number...");
                    }
                    phoneBook.put(name, phone);
                    System.out.println(" Contact saved successfully!");
                    break;

                case "search":
                    System.out.print("Enter contact name to search: ");
                    String searchName = scanner.nextLine().trim();

                    if (phoneBook.containsKey(searchName)) {
                        System.out.println(" " + searchName + " → " + phoneBook.get(searchName));
                    } else {
                        System.out.println(" Contact not found.");
                    }
                    break;

                case "list":
                    if (phoneBook.isEmpty()) {
                        System.out.println(" Phone book is empty.");
                    } else {
                        System.out.println("\n All Contacts:");
                        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                            System.out.println(entry.getKey() + " → " + entry.getValue());
                        }
                    }
                    break;

                case "quit":
                    System.out.println(" Exiting Phone Book. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("⚠ Invalid command. Please use: add, search, list, or quit.");
            }
        }
    }
}
