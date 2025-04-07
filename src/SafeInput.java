import java.util.Scanner;
import java.util.regex.Pattern;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String input;
        do {
            System.out.print(prompt + " ");
            input = pipe.nextLine().trim();
        } while (input.length() == 0);
        return input;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input;
        boolean valid;
        do {
            System.out.print(prompt + " ");
            input = pipe.nextLine().trim();
            valid = Pattern.matches(regEx, input);
            if (!valid) {
                System.out.println("Invalid input Try again");
            }
        } while (!valid);
        return input;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int input;
        while (true) {
            System.out.print(prompt + " ");
            if (pipe.hasNextInt()) {
                input = pipe.nextInt();
                pipe.nextLine(); // consume newline
                if (input >= low && input <= high) {
                    return input;
                } else {
                    System.out.println("Input out of range. Try again.");
                }
            } else {
                System.out.println("Invalid input. Enter an integer.");
                pipe.nextLine();
            }
        }
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        do {
            System.out.print(prompt + " (Y/N): ");
            input = pipe.nextLine().trim().toUpperCase();
        } while (!input.equals("Y") && !input.equals("N"));
        return input.equals("Y");
    }
}
