import java.util.Scanner;

public class Main {

    public static void main (String [] args) {
        // Create ContactsManager object
        ContactsManager myContactManager = new ContactsManager();

        Contact Amanda = new Contact();
        Amanda.name = "Amanda";
        Amanda.phoneNumber = "417-262-6322";

        myContactManager.addContact(Amanda);

        Contact Nate = new Contact();
        Nate.name = "Nathan";
        Nate.phoneNumber = "920-827-6283";

        myContactManager.addContact(Nate);

        Contact Matt = new Contact();
        Matt.name = "Matthew";
        Matt.phoneNumber = "336-462-8844";

        myContactManager.addContact(Matt);

        System.out.println(Matt.phoneNumber);

        myContactManager.searchContact("Nathan");

        System.out.println(myContactManager.friendsCount);

        System.out.println("Enter your address: ");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();
        System.out.println("You live at: " + address);

    }

}

