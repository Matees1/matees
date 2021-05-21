package net.matees.Bank;

public class bankAccountActions {

    public void createBankAccount(DebitCard card, String accountName, boolean parental, short pin) {
        BankAccount account = new BankAccount(accountName, parental, pin);

        //Card
        account.registerCard(card);
        account.getDebitCard().setBankAccount(account);
    }
}
