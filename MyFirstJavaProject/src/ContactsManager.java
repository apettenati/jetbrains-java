//This class adds and searches for contacts

public class ContactsManager {
    //Fields:
    //Store contacts in an array
    Contact [] myFriends;
    //Store quantity of contacts in the array
    int friendsCount;
    String searchName;

    //Constructor:
    ContactsManager() {
        //Initialize friend count to 0
        this.friendsCount = 0;
        //Contact array must be initialized  using new
        //This array can store up to 500 contacts
        this.myFriends = new Contact[500];
    }

    //Methods:

    //This method takes a Contact object as an input parameter
    void addContact(Contact contact) {
        //friendsCount is used to fill the slot in the array with the contact passed into the method
        myFriends[friendsCount] = contact;
        //Increment the friendsCount
        friendsCount++;
    }

    //Search through array using name and return Contact object once found
    Contact searchContact (String searchName) {
        for(int i=0; i < friendsCount; i++) {
            if(myFriends[i].name.equals(searchName)) {
                return myFriends[i];
            }
        }
        return null;
        }
    }
