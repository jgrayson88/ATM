package atmdemofinal;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**describes the bank*/
public class Bank {
    /**creates an arraylist of customers*/
    public Bank(){
        customerAccounts = new ArrayList<Customer>();
    }
    
    /**reads customer_final.txt and 
        creates a customer object*/
    public void readFile(String file) throws IOException{
        
        FileReader reader = new FileReader(file);
        try{
            Scanner in = new Scanner(reader);
            while(in.hasNext()){
                int customer_number = in.nextInt();
                int PIN = in.nextInt();
                Customer c = new Customer(customer_number, PIN);
                this.createCustomer(c);
            }
        }
        finally{
            reader.close();}      
    }
    
    /**creates a customer with a customer number and pin from the file and
        adds the customers to the arraylist*/
    public void createCustomer(Customer c){     
        customerAccounts.add(c);
    }
    
    /**enhanced for loop that searches through the 
        customer objects in the arraylist
        */
    public Customer find(int customer_number, int PIN){     
        for(Customer c: customerAccounts){
            if(c.verify_number_and_pin(customer_number, PIN)){            
                return c;}   
        }
        return null; //no match
        }  
    private ArrayList<Customer> customerAccounts;
}


