package BankJava;

import java.util.Scanner;

class Bank {
    private String accno;
    private String name;
    private long balance;

    Scanner KB = new Scanner(System.in);

    //method to open an account
    void openAccount() {
        System.out.print("Enter account number: ");
        accno = KB.next();
        System.out.print("Enter name: ");
        name = KB.next();
        System.out.print("Enter balance: ");
        balance = KB.nextLong();
    }

    //method to display account details
    void showAccount() {
        System.out.println(accno + "," + name + "," + balance);
    }

    //method to deposit money
    void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit : ");
        amt = KB.nextLong();
        balance = balance + amt;
    }

    //method to withdraw 🤑💰 
    void withdrawal() {
        long amt;
        System.out.println("Enter the amount you want to withdraw : ");
        amt = KB.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
        } else {
            System.out.println("You don't have enough balance... Transaction Failed ");
        }
    }

    //method to search an account number
    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
       return (false);
    }
}

public class BankSystem {
    public static void main(String arg[]) {
        Scanner KB = new Scanner(System.in);

        //create initial accounts
        System.out.print("How many customer you want to input : ");
        int n = KB.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].openAccount();
        }

        //run loop until menu 5 is not pressed
        int ch;
        do {
            System.out.println("Main Menu\n1. Display all account details\n 2. Search by account number\n 3. Deposit the amount\n 4. Withdraw the amount\n 5.E xit ");
                System.out.println("Enter the number of your choice :"); ch = KB.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
                            C[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.print("Enter account number you want to search: ");
                        String acn = KB.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed... Account Not Exist");
                        }
                        break;

                    case 3:
                        System.out.print("Enter account number: ");
                        acn = KB.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].deposit();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed... Account Not Exist");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account number: ");
                        acn = KB.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {     
                            found = C[i].search(acn);
                            if (found) {
                                C[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed... Account Not Exist");
                        }
                        break;

                    case 5:
                        System.out.println("Transaction Ended");
                        break;
                }
            }
            while (ch != 5);
        }
    }
