package atmdemofinal;

import java.io.IOException;

public class ATMDemoFinal {

    public static void main(String[] args) {
        
        try{
            Bank myBank = new Bank();
            String fileName = "//Users//janina//Documents//customers_final.txt";
            myBank.readFile(fileName);
            ATM program = new ATM(myBank);
           
            program.start();
        }
        catch(IOException e){
            System.out.println("File error");
        }
      
    }
}
