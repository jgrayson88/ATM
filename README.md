ATM
===

The goal of this project was to create a text-based automatic teller machine (ATM) using the spiral model of software development. Bank customers will use the ATM and each customer will have a customer number and personal identification number (PIN) that will provide them access to their checking account and their savings account. Customer numbers and PIN numbers are read from a text file. A formatted example is below:
- 12345 9876 
- 67890 4321 
- 62781 5489 
- 19284 1221
- 83728 4389

The project was implemented in Java using Netbeans as an IDE.

Program execution details:
The program simulates an actual ATM. The program starts by outputting a welcome message and then asks the bank customer to input their customer number and PIN. If the input does not match a customer number and PIN from the text file, then the program will output an error message stating that the customer number or the PIN is incorrect and to please try again. If the wrong customer number and PIN are entered a total of three times, the program will return to the beginning welcome message. 

If the customer number and PIN match what is in the text file, then the program will ask the customer to select a checking account or a savings account. If the customer selects a checking account, the program will display the balance and then output the option to display the current balance, to deposit money into the checking account, to withdraw money from the checking account, to transfer money from the checking account to the customer’s savings account, or to exit the program. If the customer selects a savings account, the program will display the balance and then output the option to display the current balance, to deposit money into the savings account, to withdraw money from the savings account, to transfer money from the savings account to the customer’s checking account, or to exit the program. 

If the balance option is selected, the program will display the customer’s current balance in the checking or savings account. If the deposit option is selected, the program will ask the customer to input the amount of money to be deposited, confirm that it is the correct amount, and then display the transaction number and a current balance. If the withdrawal option is selected, the program will ask the customer to input the amount of money to be withdrawn, confirm that it is the correct amount, and then display the transaction number and a current balance. If the transfer option is selected, the program will ask the customer to input the amount of money to be transferred, confirm that it is the correct amount, and then display the transaction number and the current balance of both the checking and the savings account. If the exit option is selected, the program will output a thank you message and then start the program again by displaying the welcome message.

