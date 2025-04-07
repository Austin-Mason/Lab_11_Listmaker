import java.util.Scanner;

public class SafeInput {
    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            while (!console.hasNextInt()) {
                System.out.print("Invalid input. " + prompt + " [" + low + " - " + high + "]: ");
                console.next();
            }
            input = console.nextInt();
        } while (input < low || input > high);
        return input;
    }

    public static boolean getYNConfirm(Scanner console, String prompt) {
        System.out.print(prompt + " (Y/N): ");
        String response;
        do {
            response = console.next().trim().toUpperCase();
        } while (!response.equals("Y") && !response.equals("N"));
        return response.equals("Y");
    }
}
