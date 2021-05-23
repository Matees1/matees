package net.matees.Bank;

public class DebitCard {
    private long balance;
    //8 digit number
    private int cardNumber;
    private String accountName;
    private BankAccount bankAccount;

    public DebitCard(int cardNumber, String accountName) {
        this.cardNumber = cardNumber;
        this.accountName = accountName;

        if (!cardStorage.getCardStorage().containsKey(accountName)) {
            cardStorage.getCardStorage().put(accountName, cardNumber);
        }
    }

    public BankAccount getBankAccount() {
        return this.bankAccount;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
