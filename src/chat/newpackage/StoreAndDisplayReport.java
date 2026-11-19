/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat.newpackage;

/**
 *
 * @author tshik
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StoreAndDisplayReport {
    private static final String FILE_PATH = "storedMessages.json";
        
      public static ArrayList <String> sentMessages = new ArrayList<>();
      public static ArrayList <String> disregardedMessages = new ArrayList<>();
      public static ArrayList <String> storedMessages = new ArrayList<>();
      public static ArrayList <String> messageHashes = new ArrayList<>();
      public static ArrayList <String> messageIDs= new ArrayList<>();
      
      //Parallel arrays
      public static ArrayList <String> recipients = new ArrayList<>();
      public static ArrayList <String> allMessages= new ArrayList<>();
       public static ArrayList<Integer> flags = new ArrayList<>();
       
      public static void addMessage (String messageID, String messageHash, String recipient, String message, int choice) {
      
          //Parallel arrays for each message sent
          messageIDs.add(messageID);
          messageHashes.add(messageHash);
          recipients.add(recipient);
          allMessages.add(message);
          flags.add(choice);
          
          //Every option goes hand in hand with its message text
          if (choice == 1){
              sentMessages.add(message);
          } 
          else if (choice == 2) {
          disregardedMessages.add(message);
          }
          else if (choice == 3){
          storedMessages.add(message);
          }      
      }
      
      public static String loadStoredMessages() {
          try{
              FileReader reader = new FileReader (FILE_PATH);
              JSONParser parser = new JSONParser();
              JSONArray messageArray = (JSONArray) parser.parse(reader);
              
              for (int i = 0; i<messageArray.size(); i++) {
                  JSONObject messageObj = (JSONObject) messageArray.get(i);
                  
                  String messageID = (String)messageObj.get("messageID");
                  String messageHash = (String) messageObj.get("messageHash");
                  String recipient = (String) messageObj.get("recipient");
                  String message = (String) messageObj.get("message");
                  
                  addMessage(messageID, messageHash,recipient, message, 3);
              }
              
              reader.close();
              return"Stored messages are loaded";
              }
              catch (IOException e){
              return"No stored messages found";
              }
              catch(ParseException e) {
              return"Stored messages file could not read";
              }
          }
      
      //Options and their functions
      public static String displaySendersAndRecipient (String sender) {
          if (storedMessages.isEmpty()) {
            return "There is no stored messages.";
          }
          String all="";
             for (int i = 0; i < allMessages.size(); i++) {
              if (flags.get(i) == 3) {
              all = all + "Sender: " + sender + "\n" + "Recipient: " + recipients.get(i) + "\n\n";    
              }                  
          }
          return all;
       }
      
      //Returning the longest message stored
      public static String getLongestMessage() {
          if (storedMessages.isEmpty()) {
          return "There is no stored messages";
         }
          String longest = storedMessages.get(0);
          for (int i = 1; i < storedMessages.size(); i++){
              if (storedMessages.get(i) . length()> longest.length()){
              longest = storedMessages.get(i);
              }
           }
            return longest;
       }
         //Longest stored messages deatils
      public static String getLongestMessageDetails() {
          if (storedMessages.isEmpty()) {
            return"There is no stored messages.";
          }
          
          String longest = getLongestMessage();
          int index = allMessages.indexOf(longest);
          
          return "Message ID: " + messageIDs.get(index) + "\n" 
                 + "Message Hash: " + messageHashes.get(index) + "\n" 
                 + "Recipient: " + recipients.get(index) + "\n"
                 + "Message: " +longest;                                 
         }
      
      //Position of message ID
      public static int findMessageIndex (String messageID) {
          int index = -1;
           for (int i = 0;i < messageIDs.size(); i++){
            if (messageIDs.get(i). equals(messageID)) {
            index = i;
            }
          }          
          return index;
        }
      
      //Searching for message ID and return mesage
      public static String searchByMessageID (String messageID) {
         int index = findMessageIndex (messageID);
         
         if (index == -1) {
          return "No message found with that ID";
         } else {
             return allMessages.get(index);
         }
      }
      
      //Searching for message ID, returning the recipient
      public static String searchbyRecipientByMessageID (String messageID) {
        int index = findMessageIndex (messageID);
        
        if (index == -1) {
        return "No message found with the ID";
        } else {
            return recipients.get(index);
        }
      }
      
      //Option 4 : Returning the stored message for one recipient
      public static ArrayList <String> searchByRecipient (String recipient) {
         ArrayList <String> found = new ArrayList<>();
         
         for (int i = 0; i < recipients.size();i++) {
            if (recipients.get(i). equals(recipient) && (flags.get(i) == 1 || flags.get(i) == 3)) {
              found.add(allMessages. get(i));
            }
         }         
         return found;               
      } 
      
      //Delete message using 
      public static String deleteMessageByHash(String messageHash) {
          int index = messageHashes.indexOf(messageHash);
      
      if (index == -1) {
        return "No message found with that hash" ;
       }
      
      String message = allMessages.get(index);
      int flag = flags.get(index);
      
      if (flag == 1) { 
          sentMessages.remove(message);
      } else if (flag == 2 ) {
       disregardedMessages.remove(message);
      } else if (flag == 3) {
      storedMessages.remove(message);
      }
      
      messageIDs.remove(index);
      messageHashes.remove(index);
      recipients .remove(index);
      allMessages.remove  (index);
      flags.remove(index);
      
      return "Message:\""+ message + "\" successfully deleted" ;                   
     }
      
      //Return a report of all sent and stored messages
      public static String displayReport() {
         if (allMessages.isEmpty()) {
           return"There are no messages to report";
         }
         
         String report= "----MESSAGE REPORT----\n";
            for (int i = 0; i < allMessages.size() ; i++) {
                String flagText= "";
                if (flags.get(i) == 1 ) flagText = "Sent";
                else if (flags.get(i) == 2) flagText = "Disregard";
                else if (flags.get(i) == 3) flagText = "Stored";
                
                    report = report + "Hash:  " +messageHashes.get(i)
                            +"  |  Recipient:  "  +recipients.get(i)
                            +"  |  Message:  "  +allMessages.get(i)
                            +"  |  Flag:  " + flagText+ "\n";
            }
            
            return report;
      }
      //All arrays are emptyed
      public static void clearArrays() {
          sentMessages.clear();
          disregardedMessages.clear();
          storedMessages.clear();
          messageHashes.clear();
          messageIDs.clear();
          recipients.clear();
          allMessages.clear();
          flags.clear();
                    
      }      
   }

   
    

