import java.util.*;
class BankAccount {
    private String accountHolder;
    private String password;
    private double balance;
    public BankAccount(String accountHolder, String password, double balance) {
        this.accountHolder = accountHolder;
        this.password = password;
        this.balance = balance;
    }
    public boolean login(String enteredName, String enteredPassword) {
        return accountHolder.equals(enteredName) && password.equals(enteredPassword);
    }
    public void deposit(double amount) {
        if(amount > 0){
            balance=balance+amount;
            System.out.println("Rs." + amount + " deposited successfully.");
        }
		else{
            System.out.println("Invalid Deposit. Enter positive amount.");
        }
    }
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance=balance-amount;
            System.out.println("Rs." + amount + " withdrawn successfully.");
        }
		else if (amount > balance) {
            System.out.println("Insufficient balance!");
        }
		else{
            System.out.println("Invalid withdrawal amount!");
        }
    }
    public void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }
}
public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount("Prathyusha", "1234",0);
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        if (account.login(name, pass)) {
            int choice;
            do {
				System.out.println();
                System.out.println("--- Banking Menu ---");
                System.out.println("1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
				System.out.println();
                System.out.print("Choose an option: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        account.checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for banking with us!");
                        break;
                    default:
                        System.out.println("Invalid option! Try again.");
                }
            }while (choice != 4);
        }
		else{
            System.out.println("Login failed! Invalid name or password.");
        }
    }
}
