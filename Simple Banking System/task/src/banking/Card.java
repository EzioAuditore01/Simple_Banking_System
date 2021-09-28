package banking;

public class Card {

    private String cardNumber;
    private int pin;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Card(String cardNumber, int pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance =0;
    }

    public int getPin() {
        return this.pin;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String toString(){
        return this.cardNumber + " " + this.pin;
    }

}
