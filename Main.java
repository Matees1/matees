package net.matees;

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
                    mainMenu();
                    return;
                }

                Scanner accountPinScanner_bank = new Scanner(System.in);
                System.out.println("What would you like your account pin to be?");
                System.out.println("This must be 4 digits long!");

                String pin = accountPinScanner_bank.nextLine();

                if (pin.length() != 4) {
                    System.out.println("That was not 4!");
                    System.out.println("RESTART!");

                    Thread.sleep(1000);

                    mainMenu();
                    return;
                }

                Scanner accountParentalScanner_bank = new Scanner(System.in);
                System.out.println("Would you like this account to be a parental controlled account?");
                System.out.println("Please answer using y/n");
                String accountParentalString = accountParentalScanner_bank.nextLine();

                boolean parental;


                if (accountParentalString.equalsIgnoreCase("y")) {
                    parental = true;
                } else if (accountParentalString.equalsIgnoreCase("n")) {
                    parental = false;
                } else {
                    System.out.println("Please enter a valid response next time! Now you will have to restart the process!");
                    mainMenu();
                    return;
                }

                BankAccount account = new BankAccount(accountName, parental, Short.parseShort(pin));

                if (pin.length() == 4) {
                    accountStorage.getHashMap().put(accountName, account);
                    System.out.println("Account successfully put into the system!");

                    Thread.sleep(1000);

                    mainMenu();
                    return;
                } else {
                    System.out.println("This pin is not 4 digits, now you must repeat the process!");
                    mainMenu();
                    return;
                }

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
                Thread.sleep(2000);

                Scanner bankAccountLogin_name_ = new Scanner(System.in);
                System.out.println("What is the name of your bank account?");
                String bankAccountLoginNameIn = bankAccountLogin_name_.nextLine();

                if (accountStorage.getHashMap().containsKey(bankAccountLoginNameIn)) {
                    Thread.sleep(1500);

                    BankAccount bankAccount = accountStorage.getHashMap().get(bankAccountLoginNameIn);

                    System.out.println("\nSuccessfully logged in!\n");

                    //get account details
                    try {
                        System.out.println("Your debitcard's account name is " + bankAccount.getDebitCard().getAccountName());
                    } catch (NullPointerException e) {
                        System.out.println("You do not have a debit card linked to your account.");
                        Thread.sleep(1000);
                    }

                    System.out.println("\nYour account name is " + bankAccount.getAccountName());

                    Thread.sleep(300);

                    System.out.println("\nYour account balance is " + bankAccount.getBalance());

                    Thread.sleep(300);

                    System.out.println("\nYour account pin is " + bankAccount.getPin());

                    Thread.sleep(300);

                    if (bankAccount.isParental()) {
                        System.out.println("\nYour account is parental controlled\n");
                    } else {
                        System.out.println("\nYour account is not parental controlled\n");
                    }

                    Scanner mainMenuQuestionScanner = new Scanner(System.in);
                    System.out.println("Would you like to go the main menu or exit? Please type Exit or Menu");

                    switch (mainMenuQuestionScanner.nextLine().toLowerCase()) {
                        case "menu":
                            mainMenu();
                            return;

                        case "exit":
                            return;

                        default:
                            System.out.println("Going to main menu because you did not put a valid answer");
                            mainMenu();
                            return;
                    }

                } else {
                    System.out.println("Cant find that account, please put in proper credentials!");
                    mainMenu();
                    return;
                }

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

                Scanner bankAccountLogin_name = new Scanner(System.in);
                System.out.println("Please type in your bank account's name.");
                String bankAccountLogin_nameIn = bankAccountLogin_name.nextLine();

                if (accountStorage.getHashMap().containsKey(bankAccountLogin_nameIn)) {
                    System.out.println("Successfully logged in!");
                } else {
                    System.out.println("\n Not a valid account!");
                    System.out.println("Now you must restart the process!");
                    mainMenu();
                    return;
                }

                Scanner configWhatScanner = new Scanner(System.in);
                System.out.println("\n \nWhat would you like to configure with your bank account?");
                System.out.println("Your options are: \n");

                Thread.sleep(1000);

                System.out.println("-DebitCard (With this you can set a DebitCard to your bank account)");

                String configWhatString = configWhatScanner.nextLine();

                switch (configWhatString.toLowerCase()) {
                    case "debitcard":
                        Thread.sleep(3000);

                        System.out.println("\n\nGreat, now you can link your bank account to your DebitCard! \n");
                        Thread.sleep(200);
                        System.out.println("But first you have to log in to your Bank account. \n");

                        Thread.sleep(600);

                        Scanner bankAccountLoginScanner = new Scanner(System.in);
                        System.out.println("Please enter in your bank account's username.");
                        String bankAccountLoginIn = bankAccountLoginScanner.nextLine();

                        if (!accountStorage.getHashMap().containsKey(bankAccountLoginIn)) {
                            System.out.println("\nThat is not a proper account, please login with an actual account next time!");

                            System.out.println("Returning to the main menu...");
                            Thread.sleep(1500);

                            mainMenu();
                            return;
                        }

                        System.out.println("Thanks.");

                        Thread.sleep(800);

                        Scanner debitCardLoginScanner = new Scanner(System.in);
                        System.out.println("\nWhat is the name of your DebitCard account?");
                        String debitCardLoginIn = debitCardLoginScanner.nextLine();


                        for (String accountNameForLoop : accountStorage.getCardBankDetails().keySet()) {
                            if (accountNameForLoop.equals(debitCardLoginIn)) {
                                BankAccount bankAccount = accountStorage.getHashMap().get(bankAccountLoginIn);
                                DebitCard cardAccount = accountStorage.getCardBankDetails().get(accountNameForLoop);

                                accountStorage.setBankCardLinkStorage(bankAccount, cardAccount);

                                bankAccount.registerCard(cardAccount);
                                cardAccount.setBankAccount(bankAccount);

                                Thread.sleep(500);

                                System.out.println("Successfully linked accounts!");
                                System.out.println("Returning to the main menu!");

                                Thread.sleep(2000);

                                mainMenu();
                                return;
                            } else {
                                System.out.println("\n Account not found! Please enter a valid account! Restarting process!");
                                Thread.sleep(1800);
                                mainMenu();
                                return;
                            }
                        }
                        break;

                    default:
                        System.out.println("You did not write a proper response, now you must repeat the process!");

                        mainMenu();
                        return;
                }
                break;

            default:
                System.out.println("Please enter in a valid response!");

                Thread.sleep(2000);

                mainMenu();
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

                    Thread.sleep(3000);

                    mainMenu();
                    return;

                } else {
                    System.out.println("This account name is already taken, please restart the process.");
                    debitCardMenu();
                    return;
                }

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
                    if (accountNameForLoop.equals(accountNameLoginScannerIn)) {

                        System.out.println("\n");
                        System.out.println("\n");

                        System.out.println("Fetching account...");

                        DebitCard card = accountStorage.getCardBankDetails().get(accountNameForLoop);

                        Thread.sleep(4000);

                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");

                        try {
                            System.out.println("Your bank account's name, which is linked to this card is " + card.getBankAccount().getAccountName());
                        } catch (NullPointerException e) {
                            System.out.println("You do not have a bank account linked to this debit card.");
                        }

                        System.out.println("Your account balance is " + card.getBalance());

                        Thread.sleep(300);

                        System.out.println("And your account name is " + card.getAccountName() + "\n");

                        Thread.sleep(300);


                        System.out.println("Your card number is " + card.getCardNumber());

                        Thread.sleep(300);


                        Scanner mainMenuQuestionScanner = new Scanner(System.in);
                        System.out.println("Would you like to go the main menu or exit? Please type Exit or Menu");

                        switch (mainMenuQuestionScanner.nextLine().toLowerCase()) {
                            case "menu":
                                mainMenu();
                                return;

                            case "exit":
                                return;

                            default:
                                System.out.println("Going to main menu because you did not put a valid answer.");
                                mainMenu();
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

    public static void atmMenu() throws InterruptedException {
        //line breaks
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        //line breaks

        Thread.sleep(1000);
        Scanner actionAtmSacnner = new Scanner(System.in);
        System.out.println("What would you like to do in the atm?");
        System.out.println("Your options are Withdraw, and Deposit");
        String actionAtmScannerIn = actionAtmSacnner.nextLine();

        switch (actionAtmScannerIn.toLowerCase()) {
            case "withdraw":

                break;

            case "deposit":
                Thread.sleep(800);
                System.out.println("\nTo deposit, you will have to log in to your bank account then your debitcard.\n");

                Scanner bankAccountLogin = new Scanner(System.in);
                System.out.println("Please enter in yor bank account name");
                String bankAccountLoginIn = bankAccountLogin.nextLine();

                Thread.sleep(500);

                Scanner debitcardAccountLogin = new Scanner(System.in);
                System.out.println("Now please enter in your debitcard account's name");
                String debitcardAccountLoginIn = debitcardAccountLogin.nextLine();

                if (accountStorage.getHashMap().containsKey(bankAccountLoginIn)) {
                    if (accountStorage.getCardBankDetails().containsKey(debitcardAccountLoginIn)) {
                        BankAccount bankAccount = accountStorage.getHashMap().get(bankAccountLoginIn);
                        DebitCard cardAccount = accountStorage.getCardBankDetails().get(debitcardAccountLoginIn);

                        //checks if the accounts are linked
                        if (accountStorage.getBankCardLinkStorage().containsKey(bankAccount)) {
                            if (accountStorage.getBankCardLinkStorage().get(bankAccount) == cardAccount) {
                                Scanner ammount_deposit = new Scanner(System.in);
                                System.out.println("What is the amount that you would you like to deposit into your bank account");
                                String ammountDepoIn = ammount_deposit.nextLine();

                                long depoAmmount = Long.parseLong(ammountDepoIn);

                                Long cardBalance = cardAccount.getBalance();
                                Long bankBalance = bankAccount.getBalance();

                                //String cardBalance_string = Long.toString(cardBalance);
                                //String bankBalance_string = Long.toString(bankBalance);

                                if (depoAmmount <= cardBalance) {
                                    cardAccount.setBalance(cardAccount.getBalance() - depoAmmount);
                                    bankAccount.setBalance(bankAccount.getBalance() + depoAmmount);

                                    System.out.println("Successfully deposited money!");

                                    Thread.sleep(1000);

                                    System.out.println("Returning to main menu!");

                                    Thread.sleep(500);

                                    mainMenu();
                                    return;
                                } else {
                                    System.out.println("The amount you specified is larger than your balance! Returning to menu");

                                    Thread.sleep(1800);

                                    mainMenu();
                                    return;
                                }
                            } else {
                                System.out.println("The account you specified is not linked to this card but another!");

                                Thread.sleep(2000);

                                mainMenu();
                                return;
                            }

                        } else {
                            System.out.println("This bank account is not linked to anything! Returning to menu.");
                            System.out.println(accountStorage.getBankCardLinkStorage());

                            Thread.sleep(1800);
                            mainMenu();
                            return;
                        }
                    } else {
                        System.out.println("That was not a valid account! Returning to main menu!");

                        Thread.sleep(1800);

                        mainMenu();
                        return;
                    }
                } else {
                    System.out.println("That was not a valid account! Returning to main menu!");

                    Thread.sleep(1800);

                    mainMenu();
                    return;
                }

            default:
                System.out.println("That was not a proper response, returning to main menu!");

                Thread.sleep(1800);

                mainMenu();
                return;
        }
    }
}