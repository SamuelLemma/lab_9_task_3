package com.company;
import java.util.UUID;

public class Account {
    private static int balance;
    private static String owner, accountNumber;

    Account(int balance, String owner, String accountNumber) {
        Account.balance = balance;
        Account.owner = owner;
        Account.accountNumber = accountNumber;
    }

    Account() {
        super();
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static void Cal(int withdraw) {
        int result = balance > withdraw ? balance -= withdraw : balance;
        System.out.println("Total balance: " + result);
    }
}

class NotEnoughMoney extends Exception {
    public NotEnoughMoney() {
        super("Not enough money to withdraw, please check the balance carefully.");
    }

    public NotEnoughMoney(String message) {
        super(message);
    }
}



class Main {
    static UUID rawID = UUID.randomUUID();
    static String ID = rawID.toString();

    public static void main(String[] args) throws NotEnoughMoney {
        int withdraw = 20001, balance = 20000;
        Account acc = new Account(balance, "Tony", ID);
        try {
            if (balance >= withdraw)
                acc.Cal(withdraw);
            else
                throw new NotEnoughMoney();
        } catch (NotEnoughMoney e) {
            System.out.println(e.getMessage());
        } finally {
            acc.Cal(withdraw);
        }
    }
}