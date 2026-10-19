package chat.newpackage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tshik
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class SendingMessages {
    private static final String FILE_PATH = "storedMessages.json";
    
        private String messageID;
        private int messageNumber;
        private String recipient;
        private String message;
        private String messageHash;
       
        
     //Stores all messages to hold messages sent
     private static final ArrayList<SendingMessages> sentMessages = new ArrayList<>();
  
     //Stores all messages that were stored to send later
     private static final ArrayList<SendingMessages> storedMessages = new ArrayList<>();
     
      //Constructor
       public  SendingMessages(String messageID, int messageNumber, String recipient, String message) {
        this.messageID = messageID; //fix initialise to generateMessageID()
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        this.messageHash = createMessageHash();
        
       }
       //Random 10 digits created     
      public static String generateMessageID() {
          Random random = new Random();
          String ID = "" ;
          
          for (int i=0; i< 10; i++){
              ID = ID + random.nextInt (10);
             }
                return ID;
            }     
      
            // Display the message ID
            public String displayMessage() {
                return "Message ID generated:" + messageID;
            }
            
            //Checking the recipient cellphone number
            public String checkRecipientCell() {
                Login login = new Login();
                
                if (login.checkCellPhoneNumber(recipient)) {
                    return "Cell phone number is successfully captured.";
                } else {
                  return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
                }
            }
            
            //Checking if messages are not more than 250 characters
            public String checkMessage() {
                if (message.length()<= 250){
                    return "Message sent";
                } else {
                   return "Please enter a message of less than 250 characters.";
                }
            }
            
            public boolean isValid() {
            boolean valid = false;
            Login login = new Login();

            if (login.checkCellPhoneNumber(recipient) && message.length() <= 250) {
            valid = true;
            }
            return valid;                       
            }
           
            public String createMessageHash() {
                
                String firstTwoNumbers;
                 if (messageID.length() >= 2 ) {
                     firstTwoNumbers = messageID.substring (0,2);                                                       
                 } else {
                     firstTwoNumbers = messageID;
                    }
                 String firstWord = "";
                 String lastWord = "";
                 
                    if (message !=null && !message.trim(). isEmpty()) {
                        
                        String cleanMessage = message.trim();
                        String[] words = cleanMessage.split("\\s+");
                        firstWord = words [0];
                        lastWord = words [words.length -1];
                        
                        //This part is for removing the puncuations
                        firstWord = firstWord.replaceAll("[^a-zA-Z0-9]", "");
                        lastWord = lastWord.replaceAll("[^a-zA-Z0-9]", "");
                    }
                    return (firstTwoNumbers + ":" + messageNumber + ":" + firstWord+lastWord) .toUpperCase();               
            }
            
                public String storeMessage() {
    storedMessages.add(this);
    // Create json file

    // This array will hold all the stored messages
    JSONArray messageArray = new JSONArray();

    // Go through every stored message and turn it into a JSON object
    for (int i = 0; i < storedMessages.size(); i++) {
        SendingMessages msg = storedMessages.get(i);

        JSONObject messageObj = new JSONObject();
        messageObj.put("messageID", msg.messageID);
        messageObj.put("messageNumber", msg.messageNumber);
        messageObj.put("recipient", msg.recipient);
        messageObj.put("message", msg.message);
        messageObj.put("messageHash", msg.messageHash);

        messageArray.add(messageObj);
    }

    // Write the array to the json file
    try {
        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write(messageArray.toJSONString());
        writer.flush();
        writer.close();
        return "Message successfully stored";
    } catch (IOException e) {
        return "Message could not be stored";
    }
}
                
                public String getMessageDetails() {
                    return "Message ID: " + messageID + "\n"+ "Message Hash :" + messageHash + "\n" + "Recipient :" + recipient+ "\n" + "Message:" + message;
                    }
            
                  //Returns all the messages that were sent
                  public static String printMessages() {
                  if (sentMessages.isEmpty()) {
                      return "No messages have been sent.";
                    }

                    String all = "";
                    for (int i = 0; i < sentMessages.size(); i++) {
                        all = all + sentMessages.get(i).getMessageDetails() + "\n\n";
                    }
                    return all;
                   }

                 //Returns how many messages were sent
                 public static int returnTotalMessages() {
                    return sentMessages.size();
                }

                //Empties both lists (only the unit tests use this)
                public static void clearMessages() {
                    sentMessages.clear();
                    storedMessages.clear();
                }
                
                public boolean checkMessageID() {
                if (messageID.length() <= 10) {
                    return true;
                }
                return false;
            }

          
            public String SentMessage(int option) {
                
                if (option == 1) {
                    sentMessages.add(this);
                    return "Message successfully sent";
                } else if (option == 2) {
                    return "Press 0 to delete the message";
                } else if (option == 3) {
                    return storeMessage();
                } else {
                    return "Invalid option.";
                }
            }
            
            
     }   
          
      