import java.util.LinkedList;
import java.util.Scanner;

public class phonebook {
    //start of menu method
    public static int menu(){
        System.out.println("Weclome to phone book please press...");
        System.out.println("1 to add a new entry");
        System.out.println("2 to print out phonebook entries");
        System.out.println("3 to search for an entry");
        System.out.println("4 to change an entry");
        System.out.println("5 to delete an entry");
        System.out.println("6 to quit");

        Scanner standIn = new Scanner(System.in);
        int input = standIn.nextInt();
        return input;
    }
    //end of menu method

    //start of menu reaction
    //this method creates a while loop and runs based off of what your input was.
    public static void menuReaction(){
        int input = menu();
        LinkedList<String> ll = new LinkedList<>();
        while(input != 6){
            if(input == 1){
                menuInput1(ll, input, 9999);
            }
            else if(input == 2){
                ll = linkedList(0, null, null, null, null, null, input, ll, 9999, 9999);
            }
            else if(input == 3){
                
            }
            else if(input == 4){
                System.out.println("Which entry would you like to change?");
                Scanner editStandIn = new Scanner(System.in);
                int editInput = editStandIn.nextInt();
                editInput = editInput - 1;
                ll = linkedList(0, null, null, null, null, null, input, ll, 9999, editInput);
            }
            else if(input == 5){
                System.out.println("Which entry would you like to delete?");
                Scanner deleteStandIn = new Scanner(System.in);
                int deleteInput = deleteStandIn.nextInt();
                deleteInput = deleteInput - 1;
                ll = linkedList(0, null, null, null, null, null, input, ll, deleteInput, 9999);
            }
            else if(input != 6){
                System.out.println("Incorrect input, please try again.");
            }
            input = menu();
        }
    }//end of menu reaction

    //menu input 1 method
    private static void menuInput1(LinkedList<String> ll, int input, int editInput){
        input = 1;
        //entry number
        System.out.println("Please enter which row you'd like this entry to be on.");
        Scanner entryStandIn = new Scanner(System.in);
        int entry = entryStandIn.nextInt();
        entry = entry - 1;
        //first name
        System.out.println("Please type first name.");
        Scanner firstNameStandIn = new Scanner(System.in);
        String firstName = firstNameStandIn.nextLine();
        //last name
        System.out.println("Please type last name.");
        Scanner lastNameStandIn = new Scanner(System.in);
        String lastName = lastNameStandIn.nextLine();
        //adress
        System.out.println("Please type address.");
        Scanner adressStandIn = new Scanner(System.in);
        String adress = adressStandIn.nextLine();
        //city
        System.out.println("Please type city name.");
        Scanner cityStandIn = new Scanner(System.in);
        String city = cityStandIn.nextLine();
        //phone number
        System.out.println("Please type phone number.");
        Scanner phoneNumberStandIn = new Scanner(System.in);
        String phoneNumber = phoneNumberStandIn.nextLine();
        //bring info to ll method
        ll = linkedList(entry, firstName, lastName, adress, city, phoneNumber, input, ll, 9999, editInput);
    }
//end of menu input 1 method

    //start of Linked list main method
    private static LinkedList<String> linkedList(int entry, String firstName, String lastName, String adress, 
    String city, String phoneNumber, int input, LinkedList<String> ll, int deleteInput, int editInput) {
        if(input == 1){
            //concatinates first name last name etc.. into one string
            String llString = firstName + " " + lastName + " " + adress + " " + city + " " + phoneNumber;
            if(editInput != 9999){
                ll.add(editInput, llString);
            }
            else{
                if (entry >= 0 && entry < ll.size()){
                    ll.add(entry, llString);
                }
                else{
                    entry = ll.size();
                    ll.add(entry, llString);
                }
            }
            
        }
        if(input == 2){
            System.out.println("Phonebook entries:");
            for(String llpart: ll) {
                System.out.print(llpart);
                System.out.println();
            }
        }
        if(input == 3){
            System.out.println("What do you want to search for?");
            Scanner searchStandIn = new Scanner(System.in);
            String searchInput = searchStandIn.next();
            for(int i = 0; i < ll.size()*5; i++) {
                for(String llpart: ll) {
                    System.out.println("lltest");
                    if(ll.get(i).equals("4")){
                    System.out.println("Results found at index" + i);
                    }
                }
            }
        }
        if(input == 4){
            ll.remove(editInput);
            menuInput1(ll, input, editInput);
            
        }
        if(input == 5){
            ll.remove(deleteInput);
        }
        System.out.println();

        return ll;
    }
}