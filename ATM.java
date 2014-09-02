package atmdemofinal;

import java.util.Random;
import java.util.Scanner;

/**describes the actions of an ATM machine*/
public class ATM {
    public ATM(Bank aBank){
        //creates an ATM with no customer requests
        myBank = aBank;
        customer_number_pin_request_count = 0;
        currentChecking = new BankAccount();
        currentSavings = new BankAccount();
    }
    
     /**
     start of ATM which displays a welcome message and resets initial values of 
     * customer_number_pin_request_count, customer_number, and PIN
     */
    public void start(){
        customer_number_pin_request_count = 0;
        int customer_number = 00000;
        int PIN = 0000;
        
        System.out.println("Welcome to Grayson National Bank!");
        this.ask_customer_number_pin();
}
        /**
     asks customer to input customer number and and pin and 
     * verifies using customer class 
     * if customer number and pin matches a customer number on file
     */
    public void ask_customer_number_pin(){
        System.out.println("Please enter your customer number and PIN:");
        Scanner keyboard = new Scanner(System.in);
        int customer_number = keyboard.nextInt();
        int PIN = keyboard.nextInt();
        currentCustomer = myBank.find(customer_number, PIN);
        while(customer_number_pin_request_count < 3){
        if(currentCustomer == null){
           System.out.println("Customer number and/or PIN incorrect. Please try again.");
           customer_number_pin_request_count++;
           this.ask_customer_number_pin();
        }
        else{
            System.out.println("Welcome customer:" + customer_number);
           customer_number_pin_request_count++;
           this.select_account_type();   
       }
        }
       if(customer_number_pin_request_count >= 3){
          System.out.println("Customer does not match our records. Please contact the bank.");
           this.start();
        } 
}
        /**
     asks customer to select either a checking account or a savings account
     */
    public void select_account_type(){
        System.out.println("Please select either a checking or savings account:");
        System.out.println("1) Checking Account");
        System.out.println("2) Savings Account");
        Scanner keyboard = new Scanner(System.in);
        int selected_account = keyboard.nextInt();
        if(selected_account == 1){
            this.select_checking_account_options();
        }
        else if(selected_account == 2){
            this.select_savings_account_options();
        }
        else{
           System.out.println("Please select either 1 or 2");
        }
    }
       /**
     asks customer to select the checking account option to get a balance, deposit, withdraw,
     * transfer to savings, or exit
     */
    public void select_checking_account_options(){
        
        System.out.println(currentChecking.getBalance());
        
        System.out.println("Please select one of the following options:");
        System.out.println("1) Display current balance");
        System.out.println("2) Deposit money");
        System.out.println("3) Withdraw money");
        System.out.println("4) Transfer money to savings account");
        System.out.println("5) Exit");
        Scanner keyboard = new Scanner(System.in);
        int selected_option = keyboard.nextInt();
        if(selected_option == 1){
            System.out.println("The current balance in your checking account is $" + currentChecking.getBalance());
            this.select_checking_account_options();
        }
        else if(selected_option == 2){
            System.out.println("Enter the amount of money to be deposited:");
            double amount = keyboard.nextDouble();
            System.out.println("Confirm that the amount to deposit is $" + amount + " by selecting Y or N");
            String confirm = keyboard.next();
            if(confirm.equalsIgnoreCase("Y")){
                currentChecking.deposit(amount);
                Random generator = new Random();
                int TransactionNumber = generator.nextInt(9999999);
                System.out.println("Transaction Number:" + TransactionNumber);
                System.out.println("Current balance:" + currentChecking.getBalance());
                System.out.println("Perform another transaction: Y or N");
                String another_transaction = keyboard.next();
                if(another_transaction.equalsIgnoreCase("Y")){
                this.select_checking_account_options();
                }
                else if(another_transaction.equalsIgnoreCase("N")){
                    this.exit();
                }
                else{
                    System.out.println("Select Y or N");
                }
            }
            else if(confirm.equalsIgnoreCase("N")){
                this.select_checking_account_options();
            }
            else{
                System.out.println("Please select either Y or N");  
            }           
        }
        else if(selected_option == 3){
            System.out.println("Enter the amount of money to be withdrawn:");
            double amount = keyboard.nextDouble();
            System.out.println("Confirm that the amount to withdrawn is $" + amount + " by selecting Y or N");
            String confirm = keyboard.next();
            if(confirm.equalsIgnoreCase("Y")){
                currentChecking.withdraw(amount);
                Random generator = new Random();
                int TransactionNumber = generator.nextInt(9999999);
                System.out.println("Transaction Number:" + TransactionNumber);
                System.out.println("Current balance:" + currentChecking.getBalance());
                System.out.println("Perform another transaction: Y or N");
                String another_transaction = keyboard.next();
                if(another_transaction.equalsIgnoreCase("Y")){
                this.select_checking_account_options();
                }
                else if(another_transaction.equalsIgnoreCase("N")){
                    this.exit();
                }
                else{
                    System.out.println("Select Y or N");
                }
            }
            else if(confirm.equalsIgnoreCase("N")){
                this.select_checking_account_options();
            }
            else{
                System.out.println("Please select either Y or N");  
            } 
        }
        else if(selected_option == 4){
        System.out.println("Enter the amount of money to be transferred:");
            double amount = keyboard.nextDouble();
            System.out.println("Confirm that the amount to be transferred is $" + amount + " by selecting Y or N");
            String confirm = keyboard.next();
            if(confirm.equalsIgnoreCase("Y")){
                currentChecking.withdraw(amount);
                currentSavings.deposit(amount);
                Random generator = new Random();
                int TransactionNumber = generator.nextInt(9999999);
                System.out.println("Transaction Number:" + TransactionNumber);
                
                System.out.println("Current checking account balance:" + currentChecking.getBalance());
               
                System.out.println("Current savings account balance:" + currentSavings.getBalance());
                System.out.println("Perform another transaction: Y or N");
                String another_transaction = keyboard.next();
                if(another_transaction.equalsIgnoreCase("Y")){
                this.select_checking_account_options();
                }
                else if(another_transaction.equalsIgnoreCase("N")){
                    this.exit();
                }
                else{
                    System.out.println("Select Y or N");
                }
            }
            else if(confirm.equalsIgnoreCase("N")){
                this.select_checking_account_options();
            }
            else{
                System.out.println("Please select either Y or N");  
            }
    }
        else if(selected_option == 5){
            this.exit();   
        }
        else{
            System.out.println("Please select either 1, 2, 3, 4, or 5.");
            this.select_checking_account_options();
        }
}
    /**
     asks customer to select the saving account option to get a balance, deposit, withdraw,
     * transfer to checking, or exit
     */
    public void select_savings_account_options(){
        System.out.println(currentSavings.getBalance());
        System.out.println("Please select one of the following options:");
        System.out.println("1) Display current balance");
        System.out.println("2) Deposit money");
        System.out.println("3) Withdraw money");
        System.out.println("4) Transfer money to checking account");
        System.out.println("5) Exit");
        Scanner keyboard = new Scanner(System.in);
        int selected_option = keyboard.nextInt();
        if(selected_option == 1){
            System.out.println("The current balance in your savings account is $" + currentSavings.getBalance());
            this.select_savings_account_options();
        }
        else if(selected_option == 2){
            System.out.println("Enter the amount of money to be deposited:");
            double amount = keyboard.nextDouble();
            System.out.println("Confirm that the amount to deposit is $" + amount + " by selecting Y or N");
            String confirm = keyboard.next();
            if(confirm.equalsIgnoreCase("Y")){
                currentSavings.deposit(amount);
                Random generator = new Random();
                int TransactionNumber = generator.nextInt(9999999);
                System.out.println("Transaction Number:" + TransactionNumber);
                System.out.println("Current balance:" + currentSavings.getBalance());
                System.out.println("Perform another transaction: Y or N");
                String another_transaction = keyboard.next();
                if(another_transaction.equalsIgnoreCase("Y")){
                this.select_savings_account_options();
                }
                else if(another_transaction.equalsIgnoreCase("N")){
                    this.exit();
                }
                else{
                    System.out.println("Select Y or N");
                }
            }
            else if(confirm.equalsIgnoreCase("N")){
                this.select_savings_account_options();
            }
            else{
                System.out.println("Please select either Y or N");  
            }           
        }
        else if(selected_option == 3){
            System.out.println("Enter the amount of money to be withdrawn:");
            double amount = keyboard.nextDouble();
            System.out.println("Confirm that the amount to withdrawn is $" + amount + " by selecting Y or N");
            String confirm = keyboard.next();
            if(confirm.equalsIgnoreCase("Y")){
                currentSavings.withdraw(amount);
                Random generator = new Random();
                int TransactionNumber = generator.nextInt(9999999);
                System.out.println("Transaction Number:" + TransactionNumber);
                System.out.println("Current balance:" + currentSavings.getBalance());
                System.out.println("Perform another transaction: Y or N");
                String another_transaction = keyboard.next();
                if(another_transaction.equalsIgnoreCase("Y")){
                this.select_savings_account_options();
                }
                else if(another_transaction.equalsIgnoreCase("N")){
                    this.exit();
                }
                else{
                    System.out.println("Select Y or N");
                }
            }
            else if(confirm.equalsIgnoreCase("N")){
                this.select_savings_account_options();
            }
            else{
                System.out.println("Please select either Y or N");  
            } 
        }
        else if(selected_option == 4){
        System.out.println("Enter the amount of money to be transferred:");
            double amount = keyboard.nextDouble();
            System.out.println("Confirm that the amount to be transferred is $" + amount + " by selecting Y or N");
            String confirm = keyboard.next();
            if(confirm.equalsIgnoreCase("Y")){
                currentSavings.withdraw(amount);
                currentChecking.deposit(amount);
                Random generator = new Random();
                int TransactionNumber = generator.nextInt(9999999);
                System.out.println("Transaction Number:" + TransactionNumber);
                
                System.out.println("Current savings account balance:" + currentSavings.getBalance());
               
                System.out.println("Current checking account balance:" + currentChecking.getBalance());
                System.out.println("Perform another transaction: Y or N");
                String another_transaction = keyboard.next();
                if(another_transaction.equalsIgnoreCase("Y")){
                this.select_savings_account_options();
                }
                else if(another_transaction.equalsIgnoreCase("N")){
                    this.exit();
                }
                else{
                    System.out.println("Select Y or N");
                }
            }
            else if(confirm.equalsIgnoreCase("N")){
                this.select_savings_account_options();
            }
            else{
                System.out.println("Please select either Y or N");  
            }
    }
        else if(selected_option == 5){
            this.exit();   
        }
        else{
            System.out.println("Please select either 1, 2, 3, 4, or 5.");
            this.select_savings_account_options();
        }
}
      /**
     outputs a goodbye message and returns ATM to initial start by calling
     * the start()
     */
    public void exit(){
        System.out.println("Thank you for using the Grayson National Bank ATM!");
        System.out.println("Have a wonderful day!");
        System.out.printf("%n");
        this.start();
}
    private int customer_number_pin_request_count;
    private BankAccount currentChecking;
    private BankAccount currentSavings;
    private Bank myBank;
    private Customer currentCustomer;
}
    
