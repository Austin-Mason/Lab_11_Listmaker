import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_Listmaker {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean done = false;
        String cmd;

        while (!done) {
            displayList();
            displayMenu();
            cmd = SafeInput.getRegExString(scanner, "Enter a command: ", "[AaDdIiPpQq]");

            switch (cmd.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?")) {
                        done = true;
                    }
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void displayList() {
        System.out.println("\nCurrent List:");
        if (list.isEmpty()) {
            System.out.println("[empty]");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d: %s\n", i + 1, list.get(i));
            }
        }
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to add:");
        list.add(item);
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        int index = SafeInput.getRangedInt(scanner, "Enter item number to delete:", 1, list.size());
        list.remove(index - 1);
    }

    private static void insertItem() {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to insert:");
        int index = SafeInput.getRangedInt(scanner, "Enter position to insert (1 to " + (list.size() + 1) + "):", 1, list.size() + 1);
        list.add(index - 1, item);
    }

    private static void printList() {
        displayList();
    }
}