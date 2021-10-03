package banking;

import java.util.ArrayList;
import java.util.Random;


public class CardGenerator {


    private final ArrayList<Card> cardList;


    public CardGenerator() {
        this.cardList = new ArrayList<Card>();

    }

    //Creating card and adding it to list.
    public void createCard(String cardNumber, String pin) {
        this.cardList.add(new Card(cardNumber, pin));

    }

    // Creating card number first 6 digits fixed next 9 random generated and also last one "luhn alg needed".
    public String createNumber() {
        StringBuilder cardNumber = new StringBuilder();
        Random rand = new Random();

        String bin = "400000";
        cardNumber.append(bin);

        for (int i = 0; i < 9; i++) {
            String randDigit = String.valueOf(rand.nextInt(10));
            cardNumber.append(randDigit);
        }


        String checkSum = String.valueOf(checkSum(cardNumber));
        cardNumber.append(checkSum);

        return String.valueOf(cardNumber);
    }


    // Creating PIN 4 numbers randomly generated
    public String createPin() {
        StringBuilder cardPin = new StringBuilder();
        Random randPin = new Random();
        for (int i = 0; i < 4; i++) {
            cardPin.append(randPin.nextInt(10));
        }

        return String.valueOf(cardPin);
    }

    //
    public ArrayList<Card> getCardListlist() {

        return this.cardList;
    }

    // Checking if there is a card which user have had requested
    public boolean checkCardList(String cardNumber, String pin) {

        for (Card card : this.cardList) {
            if (card.getCardNumber().equals(cardNumber) && card.getPin().equals(pin)) {
                System.out.println("You have successfully logged in!");
                return true;
            }

        }


        return false;
    }


    // This method gets balance of requested card
    public double getBalance(String cardNumber, String pin) {
        for (Card card : this.cardList) {
            if (card.getCardNumber().equals(cardNumber) && card.getPin().equals(pin)) {
                return card.getBalance();
            }
        }

        return 0;
    }

    // Implementing Luhn algorithm
    // Here i am passing 15 digit card number
    public int checkSum(StringBuilder cardNumber) {
        int x = 0;
        int checkSum;
        int[] array = new int[15];

        // Checking if the number is odd (1,2,3...15) and multiplying it by 2
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % 2 == 1) {
                array[i] = Character.getNumericValue(cardNumber.charAt(i)) * 2;
            } else {
                array[i] = Character.getNumericValue(cardNumber.charAt(i));
            }
        }

        // If the number at card is greater than 9 we substract 9 from it
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 9) {
                array[i] = array[i] - 9;
            }
        }

        int sum = 0;

        // Calculating the sum of numbers on card
        for (int j : array) {
            sum = sum + j;
        }

        // Calculation of check sum (60 % 10 ==0)
        while (true) {
            if ((sum + x) % 10 == 0) {
                checkSum = x;
                break;
            }
            x++;
        }

        return checkSum;
    }


}
