import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TableCreator creator = new TableCreator();
        AddExpenses add = new AddExpenses();
        ListExpenses list = new ListExpenses();
        MainMenu menu = new MainMenu();
        UpdateClass update = new UpdateClass();
        DeleteClass delete = new DeleteClass();
        creator.tableCreator();

        System.out.println("Welcome to Music App!");
        while (true) {
            menu.mainMenu(); //Calling menu function in MainMenu class
            int choice = scanner.nextInt(); // Reading user input (1 - 5)
            scanner.nextLine();

            switch (choice) { // choosing option
                case 1:
                    System.out.println("Enter Description, amount, cost:");

                    add.addexpenses(
                            scanner.nextLine(),
                            Integer.parseInt(scanner.nextLine()),
                            Double.parseDouble(scanner.nextLine())
                    );
                    continue;
                case 2:
                    list.listExpenses();
                    continue;
                case 3:
                    System.out.println("Enter ID, new description, new amount, new cost:");

                    update.updateClass(Integer.parseInt(scanner.nextLine()),
                            scanner.nextLine(),
                            Integer.parseInt(scanner.nextLine()),
                            Double.parseDouble(scanner.nextLine())
                            );
                    continue;
                case 4:
                    System.out.print("Enter ID to delete your expense: ");
                    delete.deleteClass(Integer.parseInt(scanner.nextLine())
                    );
                    continue;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}