package net.matees;

import java.util.Locale;
import java.util.Scanner;

import net.matees.Bank.*;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        mainMenu();
    }

    public static void mainMenu() throws InterruptedException {

        //line breaks
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        //line breaks


        Scanner menuScanner = new Scanner(System.in);

        System.out.println("Where would you like to go?");
        System.out.println("....Bank, Atm, or DebitCard? Please type one.");

        String response = menuScanner.nextLine();

        if (response.equalsIgnoreCase("bank")) {
            bankMenu();
        } else if (response.equalsIgnoreCase("debitcard")) {
            debitCardMenu();
        } else if (response.equalsIgnoreCase("atm")) {
            atmMenu();
        } else {
            System.out.println("Please enter a valid menu to go to!");
            System.out.println("\n");
            System.out.println("\n");

            Thread.sleep(2000);

            mainMenu();
        }
    }

    public static void bankMenu() throws InterruptedException {

        //line breaks
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        //line breaks

        Scanner selectionBank = new Scanner(System.in);
        System.out.println("What would you like to do? View bank account, configure it, or Create a bank account?");
        System.out.println("Please write either Configure, Create, or View");

        switch (selectionBank.nextLine().toLowerCase()) {
            case "create":
                //line breaks
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                //line breaks

                Scanner accountNameScanner_bank = new Scanner(System.in);
                System.out.println("What would you like your account name to be?");
                System.out.println("Must be unique!");

                String accountName = accountNameScanner_bank.nextLine();
                if (accountStorage.getHashMap().containsKey(accountName)) {
                    System.out.println("This account name has already been taken, now you have to restart the process!");
                    bankMenu();
                    return;
                }

                Scanner accountPinScanner_bank = new Scanner(System.in);
                System.out.println("What would you like your account pin to be?");
                System.out.println("This must be 4 digits long!");

                String pin = accountPinScanner_bank.nextLine();

                Scanner accountParentalScaner_bank = new Scanner(System.in);
                System.out.println("Would you like this account to be a parental controlled account?");
                System.out.println("Please answer using y/n");
                String accountParentalString = accountNameScanner_bank.nextLine();

                boolean parental;


                if (accountParentalString.equalsIgnoreCase("y")) {
                    parental = true;
                } else if (accountParentalString.equalsIgnoreCase("n")) {
                    parental = false;
                } else {
                    System.out.println("Please enter a valid response next time! Now you will have to restart the process!");
                    bankMenu();
                    return;
                }

                BankAccount account = new BankAccount(accountName, parental, Short.parseShort(pin));

                if (pin.length() == 4) {
                    accountStorage.getHashMap().put(accountName, account);
                    System.out.println("Account successfully put into the system!");

                } else {
                    System.out.println("This pin is not 4 digits, now you must repeat the process!");
                    bankMenu();
                    return;
                }
                break;

            case "view":
                System.out.println("view");
                break;

            case "configure":

                //line breaks
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                //line breaks

                Scanner configWhatScanner = new Scanner(System.in);
                System.out.println("What would you like to configure with your bank account?");
                System.out.println("Your options are: \n");

                Thread.sleep(1000);

                System.out.println("-DebitCard  -- With this you can set a DebitCard to your bank account");
                break;

            default:
                System.out.println("Please enter in a valid response!");

                Thread.sleep(2000);

                bankMenu();
                break;
        }
    }

    public static void debitCardMenu() throws InterruptedException {
        //line breaks
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        //line breaks


        Scanner debitCardMenuScan = new Scanner(System.in);
        System.out.println("Hello, what would you like to do? View or Create a/your credit card?");

        switch (debitCardMenuScan.nextLine().toLowerCase()) {
            case "create":

                //line breaks
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                //line breaks

                Scanner namePromptScanner = new Scanner(System.in);
                System.out.println("What would you like the name of your DebitCard account to be?");
                String accountNameLine = namePromptScanner.nextLine();

                Thread.sleep(2000);

                System.out.println("What would you like your card number to be?");
                Scanner cardNumberScanner = new Scanner(System.in);
                int cardNumberLine = Integer.parseInt(cardNumberScanner.nextLine());

                if (!accountStorage.getCardBankDetails().containsKey(accountNameLine)) {
                    DebitCard card = new DebitCard(cardNumberLine, accountNameLine);

                    accountStorage.addCardToBank(card.getAccountName(), card);
                    cardStorage.addCard(card.getAccountName(), card.getCardNumber());

                    Thread.sleep(1000);

                    System.out.println("Okay, your account is now officially active");

                    System.out.println("\n");

                    System.out.println("Your account name is " + card.getAccountName());

                    Thread.sleep(1000);

                    System.out.println("\n");

                    System.out.println("And your DebitCard number is " + card.getCardNumber());

                    Thread.sleep(1000);

                    System.out.println("As a bonus, you get free money! 1000");

                    card.setBalance(card.getBalance() + 1000);

                    Thread.sleep(500);

                    System.out.println("Your DebitCard balance is " + card.getBalance());

                    mainMenu();
                    return;

                } else {
                    System.out.println("This account name is already taken, please restart the process.");

                    debitCardMenu();
                }

                break;

            case "view":
                //line breaks
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
                //line breaks


                Scanner accountNameLoginScanner = new Scanner(System.in);
                System.out.println("Please enter your account name.");

                String accountNameLoginScannerIn = accountNameLoginScanner.nextLine();

                for (String accountNameForLoop : accountStorage.getCardBankDetails().keySet()) {
                    if (accountNameForLoop.equals(accountNameForLoop)) {

                        System.out.println("\n");
                        System.out.println("\n");

                        System.out.println("Fetching account...");

                        DebitCard card = accountStorage.getCardBankDetails().get(accountNameForLoop);

                        Thread.sleep(4000);

                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");

                        System.out.println("Your account balance is " + card.getBalance());
                        System.out.println("Your card number is " + card.getCardNumber());
                        System.out.println("And your account name is " + card.getAccountName());

                        Scanner mainMenuQuestionScanner = new Scanner(System.in);
                        System.out.println("Would you like to go the main menu or exit? Please type Exit or Menu");

                        switch (mainMenuQuestionScanner.nextLine().toLowerCase()) {
                            case "menu":
                                mainMenu();
                                return;

                            case "exit":
                                return;

                            default:
                                System.out.println("Exiting.");
                                return;

                        }
                    } else {
                        System.out.println("The account is not valid!");
                        debitCardMenu();
                        return;
                    }
                }

                break;

            default:

                System.out.println("Please enter a valid response!");

                Thread.sleep(2000);

                debitCardMenu();
                break;
        }
    }

    public static void atmMenu() {
        System.out.println("Atm");
    }
}
