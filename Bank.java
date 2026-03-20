// Bank Management System
// Created by Praneeth Kadiyala

import java.util.Scanner;

class BankAccount {
    String name;
    int accNo;
    double balance;

    BankAccount(String name, int accNo, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully!");
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        }
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Account No: " + accNo);
        System.out.println("Balance: " + balance);
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount account = null;

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter account number: ");
                    int accNo = sc.nextInt();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();

                    account = new BankAccount(name, accNo, balance);
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                    } else {
                        System.out.println("Create account first!");
                    }
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double wd = sc.nextDouble();
                        account.withdraw(wd);
                    } else {
                        System.out.println("Create account first!");
                    }
                    break;

                case 4:
                    if (account != null) {
                        account.display();
                    } else {
                        System.out.println("Create account first!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}