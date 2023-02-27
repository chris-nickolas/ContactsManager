package contactsApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ContactsUpdate {
    public static List<Contact> Personlist = new ArrayList<>();

    public static int mainMenu() {

        System.out.println("-----------------------------");
        System.out.println("\n     Main Menu");
        System.out.println("-----------------------------");
        System.out.println("  1. View contacts.");
        System.out.println("  2. Add a new contact.");
        System.out.println("  3. Search for a contact using name or phone number.");
        System.out.println("  4. Delete an existing contact.");
        System.out.println("  5. Exit.");
        System.out.print("\nEnter an option (1, 2, 3, 4 or 5): ");
        System.out.println("\n-----------------------------");

        Scanner input = new Scanner(System.in);
        int userSelection = input.nextInt();
        System.out.println("-----------------------------");
        return userSelection;
    }

    public static void addPerson() throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println(" 1. Add a New Contact ");
        System.out.print("  First Name: ");
        String firstName = input.nextLine();
        System.out.print("  Last Name : ");
        String lastName = input.nextLine();
        System.out.print("  Phone Number : ");
        String phoneNumber = input.nextLine();

        Files.write(Paths.get("contactsApp/contacts.txt"),
                Arrays.asList(firstName + " " + lastName + " | " + phoneNumber),
                StandardOpenOption.APPEND
        );
        Personlist.add(new Contact(firstName, lastName, phoneNumber));
        System.out.println(firstName + " " + lastName + " Has been added to the Contacts. ");
    }

    public static void printList() {
        System.out.println("Name | Phone number ");
        System.out.println("-----------------------------");
        Path ContactsPath = Paths.get("contactsApp/contacts.txt");
        List<String> Personlist = null;
        try {
            Personlist = Files.readAllLines(ContactsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Personlist.size(); i += 1) {
            System.out.println((i + 1) + ": " + Personlist.get(i));

        }
    }

    public static void searchLastName() {

        System.out.println("3. Get contacts by name or phone number. ");
        System.out.print(" Name or Number: ");

        Scanner input = new Scanner(System.in);

        String searchedLastName = input.nextLine();
        Path ContactsPath = Paths.get("contactsApp/contacts.txt");
        List<String> Personlist;

        try {
            Personlist = Files.readAllLines(ContactsPath);
            for (String person : Personlist) {
                if (person.toLowerCase().contains(searchedLastName.toLowerCase())) {
                    System.out.println("Contact:\n" + person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Contact not found.");
        System.out.println("-----------------------------");
        System.out.println(" Redirecting to Main Menu");
    }

    public static void deleteContact() {

        System.out.println("4. Delete contacts from the list by name or phone number. ");
        System.out.print(" Name or Number: ");

        Scanner input = new Scanner(System.in);
        String searchedName = input.nextLine();
        Path ContactsPath = Paths.get("contactsApp/contacts.txt");
        List<String> Personlist;

        try {
            Personlist = Files.readAllLines(ContactsPath); // imports list from original file
            List<String> newList = new ArrayList<>(); // creates empty list
            for (String person : Personlist) {
                if (person.toLowerCase().contains(searchedName)) {
                    continue; // skips a searched name
                }
                newList.add(person); // adds names
            }
            for (String name : newList) {
                System.out.println(name);
            }
            Files.write(ContactsPath, newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // exits program
    public static void exit() {
        System.out.println("Cya!");
        System.exit(0);
    }
}