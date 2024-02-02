package CODSOFT;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount newBankAccount;

    public ATM(BankAccount newBankAccount) {
        this.newBankAccount = newBankAccount;
    }

    public void startATM() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nWelcome to the ATM. Please choose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Withdraw
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    newBankAccount.withdraw(withdrawAmount);
                    break;
                case 2: // Deposit
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    newBankAccount.deposit(depositAmount);
                    break;
                case 3: // Check Balance
                    System.out.println("Current balance: " + newBankAccount.checkBalance());
                    break;
                case 4: // Exit
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();


    }
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000);
        ATM atm = new ATM(userAccount);
        atm.startATM();
    }
}

