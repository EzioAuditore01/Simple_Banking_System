package banking;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        CardGenerator cd = new CardGenerator();
        UserInterface ui = new UserInterface();

        while (true) {

            ui.printInstructions();

            int input = Integer.parseInt(scanner.nextLine());

            if (input == 1) {

                ui.createAcc();

            }

            if (input == 2) {

                ui.logToAcc();

            }

        }

    }


}

