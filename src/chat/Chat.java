/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chat;

/**
 *
 * @author tshik
 */
import java.util.Scanner;
public class Chat {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Scanner input = new Scanner (System.in);
       String name;
       String lastName;
       String userName;
       String email;
       String password;
       
       //Request user to input name
        System.out.println("Please enter your name");
        name = input.nextLine();
        
        //Request user to input lastName
        System.out.println("Please enter your last name");
        lastName = input.nextLine();
        
        while (true) {
            System.out.println("Please enter your username");
            userName = input.nextLine();
            
            if (checkUserName(userName)){
                System.out.println("Username successfully captured");
                break;
            } else {
                System.out.println("Invalid username");
                System.out.println("");
            }
        }
        
        //Request user to input email address
        while(true) {
            System.out.println("Please enter your email addrerss");
            email = input.nextLine();
            
            if (checkEmail(email)) {
                System.out.println("Email has been successfully captured.");
                break;
            } else { 
                System.out.println("Invaild email address");
                System.out.println("Email must be in the format: example@gmail.com");
            }
        }
        
        //Request user to input password
        while (true) {  
            System.out.println("Enter your password");
            password = input.nextLine();
            
            if (checkPassword(password)) {
                System.out.println("Password was successfully captured.");
                break;
            } else {
                System.out.println ("Password is not entered coorrected.");
                System.out.println("Password must:");
                System.out.println("- Be at least 8 characters long");
                System.out.println("- Contain at least one capital letter");
                System.out.println("- Contain at  least one number");
                System.out.println("-Contain at least one special character");
            }
        }
        input.close();
       } 
    public static boolean checkPassword (String password) {
}
