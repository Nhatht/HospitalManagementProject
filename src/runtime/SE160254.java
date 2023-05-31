

package runtime;

import ObjectList.DepartmentList;
import ObjectList.DoctorList;
import ObjectList.Transcript;

public class SE160254 {

    public static void main(String[] args) {
        String[] mainMenu = {"Show information", "Add new", "Update information", "Delete", "Search information", "Store data to file", "Quit"};
        String[] showMenu = {"Show doctor", "Show department", "Back to main menu"};
        String[] addMenu = {"Add new doctor", "Add new department", "Back to main menu"};
        String[] upMenu = {"Update doctor", "Update department", "Back to main menu"};
        String[] deMenu = {"Delete doctor", "Delete department", "Back to main menu"};
        String[] searchMenu = {"Search doctor", "Search  department", "Back to main menu"};
        String[] storeMenu = {"Store doctor", "Store department", "Back to main menu"};
        DoctorList docList = new DoctorList();
        DepartmentList depList = new DepartmentList();
        Transcript transcript = new Transcript(depList, docList);
        int choice;
        docList.loadFile("Doctor.dat");
        depList.loadFile("Department.dat");
        do {
            System.out.println("\n\t*** Main Menu ***");
            choice = Menu.getChoice(mainMenu);

            switch (choice) {
                case 1:
                    int showChoice = 0;
                    while (showChoice != 3) {
                        System.out.println("\n\t*** Show Information Menu ***");
                        showChoice = Menu.getChoice(showMenu);
                        if (showChoice == 1) {
                            docList.showList();
                        }
                        if (showChoice == 2) {
                            depList.showList();
                        }
                    }
                    break;
                case 2:
                    int addChoice = 0;
                    while (addChoice != 3) {
                        System.out.println("\n\t*** Add Menu ***");
                        addChoice = Menu.getChoice(addMenu);
                        if (addChoice == 1) {
                            transcript.addDoc();
                        }
                        if (addChoice == 2) {
                            transcript.addDep();
                        }
                    }
                    break;
                case 3:
                    int upChoice = 0;
                    while (upChoice != 3) {
                        System.out.println("\n\t*** Update Menu ***");
                        upChoice = Menu.getChoice(upMenu);
                        if (upChoice == 1) {
                            transcript.updateDoc();
                        }
                        if (upChoice == 2) {
                            transcript.updateDep();

                        }
                    }
                    break;
                case 4:
                    int deChoice = 0;
                    while (deChoice != 3) {
                        System.out.println("\n\t*** Delete Menu ***");
                        deChoice = Menu.getChoice(deMenu);
                        if (deChoice == 1) {
                            transcript.removeDoc();
                        }
                        if (deChoice == 2) {
                            transcript.removeDep();
                        }
                    }
                    break;
                case 5:
                    int searchChoice = 0;
                    while (searchChoice != 3) {
                        System.out.println("\n\t*** Search Menu ***");
                        searchChoice = Menu.getChoice(searchMenu);
                        if (searchChoice == 1) {
                            transcript.searchDoc();
                        }
                        if (searchChoice == 2) {
                            transcript.searchDep();
                        }
                    }
                    break;
                case 6:
                    int storeChoice = 0;
                    while (storeChoice != 3) {
                        System.out.println("\n\t*** Store Menu ***");
                        storeChoice = Menu.getChoice(storeMenu);
                        if (storeChoice == 1) {
                            docList.writeToFile("Doctor.dat");
                        }
                        if (storeChoice == 2) {
                            depList.writeToFile("Department.dat");
                        }
                    }
                    break;
                default:
                    System.out.println("Good bye!");
            }
        } while (choice < 7);

    }
}
