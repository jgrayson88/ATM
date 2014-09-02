package atmdemofinal;
/**BankAccount class defines what all bank accounts can do*/
public class BankAccount {
    /**creates BankAccount with a 0 balance*/
    public BankAccount(){
        balance = 0;
    }
    
    /**creates BankAccount with an initial balance*/
    public BankAccount(double initialBalance){        
        balance = initialBalance;
    }
    
    /**deposits money into the selected account*/
    public void deposit(double amount){   
        double newBalance = balance + amount;
        balance = newBalance;
}

    /**withdraws money from the selected account*/
    public void withdraw(double amount){
        double newBalance = balance - amount;
        balance = newBalance;
    }
    
    /**Returns account balance*/
    public double getBalance(){
        return balance;
    }  
    private double balance;
}
