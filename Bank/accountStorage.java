package net.matees.Bank;

import java.util.HashMap;

public class accountStorage {
    private static HashMap<String, BankAccount> hashMap = new HashMap<String, BankAccount>();

    private static HashMap<String, DebitCard> cardBankStorage = new HashMap<String, DebitCard>();

    private static HashMap<BankAccount, DebitCard> bankCardLinkStorage = new HashMap<BankAccount, DebitCard>();

    public static HashMap<BankAccount, DebitCard> getBankCardLinkStorage() {
        return bankCardLinkStorage;
    }

    public static HashMap<String, DebitCard> getCardBankDetails() {
        return cardBankStorage;
    }

    public static void addCardToBank(String cardName, DebitCard card) {
        cardBankStorage.put(cardName, card);
    }


    public static HashMap<String, BankAccount> getHashMap() {
        return hashMap;
    }

    public static void addAccount(String accountName, BankAccount acc) {
        hashMap.put(accountName, acc);
    }

    public static void setBankCardLinkStorage(BankAccount account, DebitCard cardAccount) {
        bankCardLinkStorage.put(account, cardAccount);
    }
}
