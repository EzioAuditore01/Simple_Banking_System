package banking;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    CardGenerator cd = new CardGenerator();

    public void printInstructions() {
        System.out.println();
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    public void createAcc() {
        System.out.println();
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        String cardNumber = cd.createNumber();
        System.out.println(cardNumber);
        System.out.println("Your card PIN:");
        int pin = cd.createPin();
        System.out.println(pin);
        cd.createCard(cardNumber, pin);
    }

    public void logToAcc() {
        System.out.println();
        System.out.println("Enter your card number:");
        String cardNumberX = scanner.nextLine();
        System.out.println("Enter your PIN:");
        int pinX = Integer.parseInt(scanner.nextLine());

        if (cd.checkCardList(cardNumberX, pinX)) {
            System.out.println();
            while (true) {

                System.out.println("1. Balance");
                System.out.println("2. Log out");
                System.out.println("0. Exit");
                int inputX = Integer.parseInt(scanner.nextLine());

                if (inputX == 1) {
                    System.out.println();
                    System.out.println("Balance: " + cd.getBalance(cardNumberX, pinX));
                    System.out.println();
                    continue;
                }

                if (inputX == 2) {
                    System.out.println("You have successfully logged out!");
                    break;
                }

                if (inputX == 3) {
                    break;
                }

            }
        }else {
            System.out.println();
            System.out.println("Wrong card number or PIN!");
        }
    }
}
