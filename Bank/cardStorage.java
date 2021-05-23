package net.matees.Bank;

import java.util.HashMap;

public class cardStorage {
    private static HashMap<String, Integer> cardStorage = new HashMap<String, Integer>();

    public static HashMap<String, Integer> getCardStorage() {
        return cardStorage;
    }

    public static void addCard(String accountName, int pin) {
        cardStorage.put(accountName, pin);
    }
}
