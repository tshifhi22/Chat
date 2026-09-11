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
            
        
            System.out.println();
            System.out.println("=== QuickChat Login ===");

            System.out.print("Enter your username: ");
            String strUsername = input.nextLine();

            System.out.print("Enter your password: ");
            String strPassword = input.nextLine();

            boolean success = object.loginUser(strUsername, strPassword);
            System.out.println(object.returnLoginStatus(true));
        

        input.close();                           
    }
    
}
