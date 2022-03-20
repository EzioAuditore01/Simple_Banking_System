package banking;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    CardGenerator cd = new CardGenerator();
    DatabaseManager dbm = new DatabaseManager();
    StringBuilder sb = new StringBuilder();

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
        String pin = cd.createPin();
        System.out.println(pin);
        cd.createCard(cardNumber, pin);
        dbm.insertCard(cardNumber, String.valueOf(pin));
    }

    public boolean logToAcc() {
        System.out.println();
        System.out.println("Enter your card number:");
        String cardNumberX = scanner.nextLine();
        System.out.println("Enter your PIN:");
        String pinX = (scanner.nextLine());

        System.out.println();
        if (cd.checkCardList(cardNumberX, pinX)) {
            while (true) {
                System.out.println("1. Balance");
                System.out.println("2. Add income");
                System.out.println("3. Do transfer");
                System.out.println("4. Close account");
                System.out.println("5. Log out");
                System.out.println("0. Exit");
                int inputX = Integer.parseInt(scanner.nextLine());

                if (inputX == 1) {
                    System.out.println();
                    System.out.println("Balance: " + dbm.selectBalance(cardNumberX));
                    System.out.println();
                    continue;
                }

                if (inputX == 2) {
                    System.out.println();
                    System.out.println("Enter income:");
                    Integer amount = Integer.parseInt(scanner.nextLine());
                    dbm.addBalance(amount, cardNumberX);
                    System.out.println("Income was added!");
                    System.out.println();
                }

                if (inputX == 3) {
                    System.out.println();
                    System.out.println("Transfer");
                    System.out.println("Enter card number:");
                    String cardNum = scanner.nextLine();

                    //Checking if the card is passing Luhn algorithm
                    if (cd.checkSum(sb.append(cardNum).deleteCharAt(sb.length() - 1)) != Character.getNumericValue(cardNum.charAt(cardNum.length() - 1))) {
                        System.out.println("Probably you made a mistake in the card number. Please try again!");
                        System.out.println();
                        continue;
                    }

                    if (!dbm.cardExistance(cardNum)) {
                        System.out.println("Such a card does not exist.");
                        System.out.println();
                        continue;
                    }

                    if (cardNumberX.equals(cardNum)) {
                        System.out.println("You can't transfer money to the same account!");
                        System.out.println();
                        continue;
                    }
                    System.out.println("Enter how much money you want to transfer:");
                    Integer amount = Integer.parseInt(scanner.nextLine());

                    if (dbm.selectBalance(cardNumberX) < amount) {
                        System.out.println("Not enough money!");
                        System.out.println();
                        continue;
                    } else {
                        dbm.addBalance(amount, cardNum);
                        dbm.removeBalance(amount, cardNumberX);
                        System.out.println("Success!");
                        System.out.println();
                        continue;
                    }

                }

                if (inputX == 4) {
                    dbm.removeRecord(cardNumberX);
                    System.out.println("The account has been closed!");
                    System.out.println();
                    break;
                }


                if (inputX == 5) {
                    System.out.println("You have successfully logged out!");
                    break;
                }


                if (inputX == 0) {
                    return false;
                }

            }
        } else {
            System.out.println("Wrong card number or PIN!");
        }

        return true;
    }
}

