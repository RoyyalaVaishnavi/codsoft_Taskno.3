import java.util.*;
public class ATM {
    private BankAccount bankAccount;
    private Scanner sc = new Scanner(System.in);
    public ATM(BankAccount account) {
        bankAccount = account;
    }
    public void withdraw() {
        System.out.println("Enter the amount you want to withdraw:");
        int amount = sc.nextInt();
        if(bankAccount.getBalance() < amount) {
            System.out.println("Insufficient Balance");
        }else {
            bankAccount.withdraw(amount);
            System.out.println("Rupees " + amount + " withdraw successfully. ");
        }
    }
    public void deposit() {
        System.out.println("Enter the amount you want to deposit:");
        int amount = sc.nextInt();
        bankAccount.deposit(amount);
        System.out.println("Rupees " + amount + " deposited successfully. ");
    }
    private void checkBalance() {
        System.out.println("Your account balance is: " + bankAccount.getBalance());
    }
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        ATM atm = new ATM(bankAccount);
        int choice;
        do { 
            System.out.println("\n===ATM Menu===");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = atm.sc.nextInt();
            switch (choice) {
                case 1:
                atm.withdraw();
                break;
                case 2:
                atm.deposit();
                break;
                case 3:
                atm.checkBalance();
                break;
                case 4:
                System.out.println("Exiting ATM.Goodbye!");
                break;
                default:
                System.out.println("Inavalid choice,please try again.");
            }
        } while (choice!=4);
        atm.sc.close();
    }
}


Bank Account :
public class BankAccount {
    private int balance;
    public BankAccount(int initialbalance) {
        balance = initialbalance;
    }
    public void withdraw(int amount) {
        if(balance < amount) {
            System.out.println("Insufficient Balance");
        }
        balance -= amount;
    }
    public void deposit(int amount) {
        balance += amount;
    }
    public int getBalance() {
        return balance;
    }
}