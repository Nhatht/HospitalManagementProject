package runtime;

import java.util.Scanner;

public class Menu {

    public static int getChoice(Object[] options) {
        Scanner sc = new Scanner(System.in);
        boolean cont;
        int input = 0;
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        do {
            try {
                System.out.print("Please choose 1.." + options.length + ": ");
                input = Integer.parseInt(sc.nextLine().trim());
                cont = false;
                if (input <= 0 || input > options.length) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("*** Invalid value. Please try again! ***");
                cont = true;
            }

        } while (cont);
        return input;
    }

  
}
