package net.matees.Bank;

import java.util.HashMap;

public class accuontStorage {
    private static HashMap<String, Short> hashMap = new HashMap<String, Short>();

    public static HashMap<String, Short> getHashMap() {
        return hashMap;
    }

    public static void addAccount(String accountName, Short pin) {
        hashMap.put(accountName, pin);
    }
}
