package contactsApp;

public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + "Phone number: " + this.phoneNumber;
    }

}