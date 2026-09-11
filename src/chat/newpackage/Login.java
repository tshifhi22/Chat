/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat.newpackage;
/**
 *
 * @author tshik
 */
public class Login {
    
    private static final String cellPhoneNumberRegex = "^(0[6-8][0-9]{8}|\\+27[6-8][0-9]{8})$";
    
    //Declarations 
    String registeredUserName ;
    String registeredCellPhoneNumber;
    String registeredPassword;
    String registeredFirstName;
    String registeredLastName;
   
    
    public static boolean checkUserName (String username) {
        boolean hasUsernameCorrect = false;
            
        if (username.contains("_") && username.length() <=5) {
            hasUsernameCorrect = true;
        } 
       return hasUsernameCorrect;   
              }
    public  boolean checkCellPhoneNumber (String cellPhoneNumber) {
      if (cellPhoneNumber == null) {
            return false;
        }
      
        return cellPhoneNumber.matches(cellPhoneNumberRegex);
    }
    
    public static boolean checkPasswordComplexity(String password){
        
     // Password must be at least 8 characters
      if (password.length() < 8) {
        return false;
         }

         boolean hasCapital = false;
         boolean hasSpecialCharacter = false;
         boolean hasNumber = false;

          // Go through each character in the password
           for (int i = 0; i < password.length(); i++) {

             char ch = password.charAt(i);

              // Check for capital letter
             if (Character.isUpperCase(ch)) {
              hasCapital = true;
              }

             // Check for number
             if (Character.isDigit(ch)) {
              hasNumber = true;
              }

             // Check for special character
              if (!Character.isLetterOrDigit(ch)) {
               hasSpecialCharacter = true;
             }

            }     
             return hasCapital & hasNumber & hasSpecialCharacter ;
         }
     boolean loginSuccess = false;      
    public  boolean loginUser(String strUsername, String strPassword){
        
        if (strUsername == null) {
            loginSuccess = false;
        }else if (registeredUserName.equals(strUsername) && registeredPassword.equals(strPassword)) {
            loginSuccess = true;
        }else {
            loginSuccess = false;
        }
        return loginSuccess;
    }
    
    public String registerUser(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        
        if ( !checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length";
        }       
        if (!checkPasswordComplexity (password)) {
            return " The password does not meet the complexity requirements";        
        }
        
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "The  cellphone number incorretcly formatted or does not contain international code";
        }
            
          if (checkUserName(username) && checkPasswordComplexity(password) && checkCellPhoneNumber(cellPhoneNumber)) {         
             registeredUserName  = username ;
             registeredCellPhoneNumber = cellPhoneNumber;
             registeredPassword = password;
             registeredFirstName = firstName;
             registeredLastName= lastName;
             
             
          }     
              return " The user has been registered successfully";
    }
    
    public String returnLoginStatus(boolean success) {
        
        if (loginSuccess == true) {
            return "Welcome" + registeredFirstName + "," + registeredLastName + " ,it is great to see you";
        }else {
            return "Username or password is incorrect, please try again";
        }
       
    }
}
    
