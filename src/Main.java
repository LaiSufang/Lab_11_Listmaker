import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> MyArray = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String choice = "";
        boolean done = false;

        do {
            //display the menu
            displayMenu();
            //get the choice
            choice = getUserChoice().toUpperCase();
            //execute the choice
            userChoiceExecution(choice);
        } while (!done);
    }

    private static void userChoiceExecution(String userChoice) {
        switch (userChoice) {
            case"A":
                addToList();
                break;
            case"D":
                deleteItemFromList();
                break;
            case"I":
                insertItemIntoList();
                break;
            case"P":
                printList();
                break;
            case"Q":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }


    }

    private static void printList() {
        for (int i = 0; i < MyArray.size(); i++) {
            System.out.println( "Item" + (i+1) + ":" + MyArray.get(i));
        }
    }

    private static void insertItemIntoList() {
        printList();
        int insertIndex = SafeInput.getRangedInt(in,"Enter a location where you want to insert an item: ", 0, MyArray.size());
        in.nextLine();
        String insertItem = SafeInput.getNonZeroLenString(in,"Enter the name of the item you want to insert into the list: ");
        MyArray.add(insertIndex, insertItem);
        printList();
    }

    private static void deleteItemFromList() {
        printList();
        String itemToDelete = SafeInput.getNonZeroLenString(in, "Enter the item name you want to delete from the list: ");
        if (MyArray.contains(itemToDelete)) {
            MyArray.remove(itemToDelete);
        }
        else {
            System.out.println("The item you entered is not found in the list");
        }
        printList();
    }

    private static void addToList() {
        String item = SafeInput.getNonZeroLenString(in,"Please enter an item you want to add to the list: ");
        MyArray.add(item);
        printList();

    }

    private static void displayMenu() {
        System.out.println("********************************************************************");
        System.out.println("\t\t\t\t\t\t\tMenu\n\n" +
                            "\t\t\t\tA – Add an item to the list\n" +
                            "\t\t\t\tD – Delete an item from the list\n" +
                            "\t\t\t\tI – Insert an item into the list\n" +
                            "\t\t\t\tP – Print (i.e. display) the list\n" +
                            "\t\t\t\tQ – Quit");
        System.out.println("********************************************************************");
    }


    private static String getUserChoice() {
        return SafeInput.getNonZeroLenString(in,"Please enter your choice: ");
    }
}






