package contactsApp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        while (true) {
            int userInput = ContactsUpdate.mainMenu();
            if (userInput == 1)
                ContactsUpdate.printList();
            else if (userInput == 2)
                ContactsUpdate.addPerson();
            else if (userInput == 3)
                ContactsUpdate.searchLastName();
            else if (userInput == 4) {
                ContactsUpdate.deleteContact();
            } else if (userInput == 5) {
                ContactsUpdate.exit();
            }
        }
    }
}
