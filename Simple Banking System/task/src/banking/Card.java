package banking;

public class Card {
    private String cardNumber;
    private final String pin;
    private double balance;


    public Card(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance =0;
    }

    public String getPin() {

        return this.pin;
    }

    public String getCardNumber() {

        return this.cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String toString(){

        return this.cardNumber + " " + this.pin;
    }


}
