import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> stringArrayList = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static boolean done = false;

    public static void main(String[] args) {
        String choice;


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
                quitProgram();
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }


    }

    private static void quitProgram() {
        boolean quit = SafeInput.getYNConfirm(in, "Are you sure you want to quit?[Y/N]:");
        if (quit) {
            System.out.println("Thanks for using our program! See you next time!");
            done = true;
        }
    }

    private static void printList() {
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println( "Item" + (i+1) + ":" + stringArrayList.get(i));
        }
    }

    private static void insertItemIntoList() {
        printList();
        int insertIndex = SafeInput.getRangedInt(in,"Enter a location where you want to insert an item: ", 0, stringArrayList.size());
        in.nextLine();
        String insertItem = SafeInput.getNonZeroLenString(in,"Enter the name of the item you want to insert into the list: ");
        stringArrayList.add(insertIndex, insertItem);
        printList();
    }

    private static void deleteItemFromList() {
        printList();
        String itemToDelete = SafeInput.getNonZeroLenString(in, "Enter the item name you want to delete from the list: ");
        if (stringArrayList.contains(itemToDelete)) {
            stringArrayList.remove(itemToDelete);
        }
        else {
            System.out.println("The item you entered is not found in the list");
        }
        printList();
    }

    private static void addToList() {
        String item = SafeInput.getNonZeroLenString(in,"Please enter an item you want to add to the list: ");
        stringArrayList.add(item);
        printList();

    }

    private static void displayMenu() {
        System.out.println("********************************************************************");
        System.out.println("""
                \t\t\t\t\t\t\tMenu
                
                \t\t\t\tA – Add an item to the list
                \t\t\t\tD – Delete an item from the list
                \t\t\t\tI – Insert an item into the list
                \t\t\t\tP – Print (i.e. display) the list
                \t\t\t\tQ – Quit""");
        System.out.println("********************************************************************");
    }


    private static String getUserChoice() {
        return SafeInput.getNonZeroLenString(in,"Please enter your choice: ");
    }
}






