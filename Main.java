package net.matees;

import java.util.Locale;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        mainMenu();
    }

    public static void mainMenu() throws InterruptedException {
        Scanner menuScanner = new Scanner(System.in);

        System.out.println("Where would you like to go?");
        System.out.println("....Bank, or DebitCard? Please type one.");

        String response = menuScanner.nextLine();

        if (response.equalsIgnoreCase("bank")) {
            bankMenu();
        }else if(response.equalsIgnoreCase("debitcard")){
            debitCardMenu();
        }else{
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

        //Scanner
        Scanner bankActionScan = new Scanner(System.in);

        System.out.println("Would you like to see your account or create a new account?");
        System.out.println("View or Create? Please enter one.");

        String response = bankActionScan.nextLine();

        if (response.equalsIgnoreCase("view")) {
            //"Logging into the account"

            Scanner accountName = new Scanner(System.in);
            System.out.println("Please enter the account name of the account that you would like to access.");
            String accountNameResponse = accountName.nextLine();

            Scanner pin = new Scanner(System.in);
            System.out.println("Now please enter the pin for the account.");
            String pinResponse = pin.nextLine();




        }else if(response.equalsIgnoreCase("create")){

        }else{
            System.out.println("Please enter in a valid response!");

            Thread.sleep(2000);

            bankMenu();
        }

    }

    public static void debitCardMenu() {
        System.out.println("DebitCard");
    }
}
