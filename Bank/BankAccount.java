package net.matees.Bank;

public class BankAccount {
    private DebitCard card;
    private long balance = 0;
    private String accountName;
    private boolean parental;
    private short pin;

    public BankAccount(String accountName, boolean parental, short pin) {
        if (Short.toString(pin).length() == 4 && !accountStorage.getHashMap().containsKey(accountName)) {
            this.accountName = accountName;
            this.parental = parental;
            this.pin = pin;
        }
    }

    public void registerCard(DebitCard card) {
        this.card = card;
    }

    public DebitCard getDebitCard() {
        return this.card;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public boolean isParental() {
        return parental;
    }

    public void setParental(boolean parental) {
        this.parental = parental;
    }

    public short getPin() {
        return pin;
    }

    public void setPin(short pin) {
        this.pin = pin;
    }
}
