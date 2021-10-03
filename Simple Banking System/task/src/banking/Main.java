package banking;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        DatabaseManager dbm = new DatabaseManager();
        Scanner scanner = new Scanner(System.in);
        dbm.createNewTable();
        dbm.deleteRecords();

        UserInterface ui = new UserInterface();


        while (true) {

            ui.printInstructions();

            int input = Integer.parseInt(scanner.nextLine());

            if (input == 1) {

                ui.createAcc();

            }

            if (input == 2) {

                if (!ui.logToAcc()) {
                    break;
                }
            }

            if (input == 0) {
                break;
            }

        }

        System.out.println("Bye!");

    }


}

