package atmdemofinal;
/**describes a customer of the bank*/
public class Customer {
    /**creates a customer with a customer number and pin*/
      public Customer(int a_customer_number, int a_PIN){          
        customer_number = a_customer_number;
        PIN = a_PIN;
    }
      
       /**verifies that customer number and pin entered match what is in the
          customer_final.txt file*/
      public boolean verify_number_and_pin(int a_customer_number, int a_PIN){
          if(customer_number == a_customer_number && PIN == a_PIN){
              return true;}
          else {
          return false;}
      }
 private int customer_number;
 private int PIN;
}

