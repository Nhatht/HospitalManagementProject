package validation;

import java.util.Scanner;

public class MyValidation {

    public static Scanner sc = new Scanner(System.in);

    public static String readPattern(String message, String regex) {
        String input;
        boolean cont;
        do {
            System.out.print(message);
            input = sc.nextLine().trim();
            cont = false;
            if (input.isEmpty()) {
                System.out.println("\t*** Can not be empty! ***");
                cont = true;
            } else if (!input.matches(regex)) {
                System.out.println("\t*** Invalid value. Please try again! ***");
                cont = true;
            }
        } while (cont);
        return input.toUpperCase();
    }

    public static String readPatternUpdate(String message, String regex) {
        String input;
        boolean cont;
        do {
            System.out.print(message);
            input = sc.nextLine().trim();
            cont = false;
            if (!input.matches(regex) && !input.isEmpty()) {
                System.out.println("\t*** Invalid value. Please try again! ***");
                cont = true;
            }
        } while (cont);
        return input.toUpperCase();
    }
}
