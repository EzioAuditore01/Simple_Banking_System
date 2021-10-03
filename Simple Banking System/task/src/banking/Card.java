package banking;

public class Card {

    private String cardNumber;
    private String pin;
    private double balance;


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Card(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance =0;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin){
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
