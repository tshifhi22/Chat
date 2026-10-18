/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat.newpackage;

/**
 *
 * @author tshik
 */

import java.util.Scanner;
public class Main {
    private static final String cellPhoneNumberRegex = "^(0[6-8][0-9]{8}|\\+27[6-8][0-9]{8})$";
    public static void main(String[] args) {
          //declaration 
          Scanner input = new Scanner(System.in);
          Login object = new Login();
          
          String firstName;
          String lastName;
          String username;
          String password;
          String cellPhoneNumber;
          
          
          // Request user to input name
        System.out.println("Please enter your name");
        firstName = input.nextLine();

        // Request user to input last name
        System.out.println("Please enter your last name");
        lastName = input.nextLine();
        
            // Request user to input username
        while (true) {
            System.out.println("Please enter your username");
            username = input.nextLine();                 

            if (object.checkUserName(username)) {
                System.out.println("Username successfully captured");
                break;
            } else {
                System.out.println("Username not correctlty formatted;please ensure that your username:");
                System.out.println(" Username contains an underscore.");
                System.out.println("Username must be between no more than 5 characters.");
            }
        }
            // Request user to input password
            String registerMessage;
        while (true) {
            System.out.println("Enter your password");
            password = input.nextLine();

            if (object.checkPasswordComplexity(password)) {
                registerMessage = "Password was successfully captured.";
                break;
            } else {
                System.out.println("Password is not forrmatted correctly;");
                System.out.println("Please ensure that password :");
                System.out.println("- Contains least 8 characters long");
                System.out.println("- a capital letter");
                System.out.println("- a number");
                System.out.println("- and a special character");
            }       
        } 
                 //Request user to enter cell phone number
            while (true) {
            System.out.print("Please enter your cellphone number");
            cellPhoneNumber= input.nextLine().trim();

            if (object.checkCellPhoneNumber(cellPhoneNumber)) {
                System.out.println(" CellPhone has been successfully added.");
                break;
            } else {
                System.out.println(" CellPhone number incorrectly added or does not contain international .");
              }

              }
       
            registerMessage = object.registerUser(firstName, lastName, username, password, cellPhoneNumber);
            System.out.println(registerMessage);
        
            System.out.println();
            System.out.println("=== QuickChat Login ===");

            System.out.print("Enter your username: ");
            String strUsername = input.nextLine();

            System.out.print("Enter your password: ");
            String strPassword = input.nextLine();

           boolean success = object.loginUser(strUsername, strPassword);
           System.out.println(object.returnLoginStatus(success));
        
             if (!success) {
           
             System.out.println("The login was unsuccessfull, please log in the system.");
             input.close();
             return; 
             }
           
             //Welcome to QuickChat message
             System.out.println("Welcome to QuickChat.");
             
             //Ask user how many messages they want to enter
             System.out.println("How many messages do you want to enter?");
             int totalMessages = Integer.parseInt(input.nextLine()); 
             
                boolean allEntered = false;
                int option = 0;
                
                while (option !=3){
                        System.out.println("Menu");
                        System.out.println("Choose an option below:");
                        System.out.println("1. Send Messages");
                        System.out.println("2. Show recently sent messages");
                        System.out.println("3. Quit");
                        
                        System.out.println("Please enter your option.");
                        option = Integer.parseInt(input.nextLine());
                        
                        if (option == 1) {
                           if (allEntered ) {
                               System.out.println("You have entered your total messages limit");              
                              } else {
                               for (int i=0; i<totalMessages; i++) {  
                                   System.out.println("\nMessage" + (i + 1) + ":");
                                   System.out.println("Enter Recipient (+27.....) : ");
                                   String recipient = input.nextLine();
                                   System.out.print(" Enter messages that are not more than 250 characters");
                                   String message = input.nextLine();
                                                                                                          
                                                              
                                SendingMessages msg = new SendingMessages(SendingMessages.generateMessageID(), i, recipient, message);
                                
                               System.out.println( msg.checkRecipientCell());
                                if (!msg.checkRecipientCell().contains("successfully captured")){
                                    i--;
                                    continue;
                                }
                                
                                //Checking the length of the message
                                System.out.println(msg.checkMessage());
                                if (msg.checkMessage().contains("Please enter ")) {
                                    i--;
                                    continue;
                                }
                                
                                //Display message ID and Hash
                                System.out.println(msg.displayMessage());
                                System.out.println("Message Hash: " + msg.createMessageHash());
                                
                                //Prompting the user on what they want to do
                                System.out.println("Choose and option: 1.Send 2.Disregard  3. Store");
                                int choice = Integer.parseInt(input.nextLine());
                                System.out.println(msg.SentMessage(option));
                               
                                if (option == 1){
                                    System.out.println("-----Full Message-----");
                                    System.out.println(msg.getMessageDetails());
                                 }
                               }
                                allEntered = true;
                                
                                // Show total number of messages sent
                                System.out.println("\nTotal messages sent: " + SendingMessages.returnTotalMessages());
                                
                                }                 
                              } else if 
                                (option ==2) {
                                System.out.println("Coming Soon");
                                
                                } else if (option ==3){
                                System.out.println("Thank you, goodbye.");
                                }
                                else {
                                System.out.println("Invalid option");
                              }
                         
                     }
             
        input.close();                           
    }
    
  }
