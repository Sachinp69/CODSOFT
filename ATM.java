package CODSOFT;

import java.util.Scanner;

public class ATM {
    private BankAccount bankAccount;
    private Scanner sc;

    public ATM() {
        bankAccount = new BankAccount();
        sc = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the ATM!");
        System.out.println("Please select an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");

        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("Enter the amount to withdraw:");
                double withdrawAmount = sc.nextDouble();
                bankAccount.withdraw(withdrawAmount);
                break;
            case 2:
                System.out.println("Enter the amount to deposit:");
                double depositAmount = sc.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.println("Your current balance is: " + bankAccount.checkBalance());
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }

        run();
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}

class BankAccount {
    private double balance;

    public BankAccount() {
        balance = 0.0;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public double checkBalance() {
        return balance;
    }
}
