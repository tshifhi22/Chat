/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package chat.newpackage;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tshik
 */
public class StoreAndDisplayReportIT {

    public StoreAndDisplayReportIT() {
    }

    // empty the arrays so every test starts fresh
    @Before
    public void setUp() {
        StoreAndDisplayReport.clearArrays();
    }

    // adds test messages 1 to 5 from the brief
    // choice: 1 = sent, 2 = disregarded, 3 = stored
    private void addTestData() {
        // message 1: sent
        StoreAndDisplayReport.addMessage("1000000001", "10:0:DIDCAKE", "+27834557896", "Did you get the cake?", 1);
        // message 2: stored
        StoreAndDisplayReport.addMessage("1000000002", "10:1:WHERETIME", "+27838884567", "Where are you? You are late! I have asked you to be on time.", 3);
        // message 3: disregarded
        StoreAndDisplayReport.addMessage("1000000003", "10:2:YOHOOOOGATE", "+27834484567", "Yohoooo, I am at your gate.", 2);
        // message 4: sent
        StoreAndDisplayReport.addMessage("1000000004", "10:3:ITTIME", "0838884567", "It is dinner time!", 1);
        // message 5: stored
        StoreAndDisplayReport.addMessage("1000000005", "10:4:OKYOU", "+27838884567", "Ok, I am leaving without you.", 3);
    }

    // Test of addMessage: one message goes into every array
    @Test
    public void testAddMessage() {
        System.out.println("addMessage");
        StoreAndDisplayReport.addMessage("1000000001", "10:0:DIDCAKE", "+27834557896", "Did you get the cake?", 1);

        assertEquals(1, StoreAndDisplayReport.allMessages.size());
        assertEquals("Did you get the cake?", StoreAndDisplayReport.sentMessages.get(0));
        assertEquals("1000000001", StoreAndDisplayReport.messageIDs.get(0));
        assertEquals("10:0:DIDCAKE", StoreAndDisplayReport.messageHashes.get(0));
    }

    // Test that the sent messages array has the right messages
    @Test
    public void testSentMessagesArray() {
        System.out.println("sentMessagesArray");
        addTestData();

        // messages 1 and 4 were sent
        assertEquals(2, StoreAndDisplayReport.sentMessages.size());
        assertEquals("Did you get the cake?", StoreAndDisplayReport.sentMessages.get(0));
        assertEquals("It is dinner time!", StoreAndDisplayReport.sentMessages.get(1));
    }

    // Test of loadStoredMessages
    // this reads storedMessages.json, so the answer depends on whether the file exists
    @Test
    public void testLoadStoredMessages() {
        System.out.println("loadStoredMessages");
        String result = StoreAndDisplayReport.loadStoredMessages();

        boolean isExpected = result.equals("Stored messages are loaded")
                || result.equals("No stored messages found");
        assertTrue(isExpected);
    }

    // Test of displaySendersAndRecipient: messages 2 and 5 are stored
    @Test
    public void testDisplaySendersAndRecipient() {
        System.out.println("displaySendersAndRecipient");
        addTestData();

        String expResult = "Sender: Tshifhiwa\nRecipient: +27838884567\n\n"
                + "Sender: Tshifhiwa\nRecipient: +27838884567\n\n";
        String result = StoreAndDisplayReport.displaySendersAndRecipient("Tshifhiwa");
        assertEquals(expResult, result);
    }

    // Test of getLongestMessage: message 2 is the longest stored message
    @Test
    public void testGetLongestMessage() {
        System.out.println("getLongestMessage");
        addTestData();

        String expResult = "Where are you? You are late! I have asked you to be on time.";
        String result = StoreAndDisplayReport.getLongestMessage();
        assertEquals(expResult, result);
    }

    // Test of getLongestMessageDetails
    @Test
    public void testGetLongestMessageDetails() {
        System.out.println("getLongestMessageDetails");
        addTestData();

        String expResult = "Message ID: 1000000002\n"
                + "Message Hash: 10:1:WHERETIME\n"
                + "Recipient: +27838884567\n"
                + "Message: Where are you? You are late! I have asked you to be on time.";
        String result = StoreAndDisplayReport.getLongestMessageDetails();
        assertEquals(expResult, result);
    }

    // Test of findMessageIndex: message 4 is in position 3 (the list starts at 0)
    @Test
    public void testFindMessageIndex() {
        System.out.println("findMessageIndex");
        addTestData();

        int expResult = 3;
        int result = StoreAndDisplayReport.findMessageIndex("1000000004");
        assertEquals(expResult, result);
    }

    // Test of searchByMessageID: search with the ID of message 4
    @Test
    public void testSearchByMessageID() {
        System.out.println("searchByMessageID");
        addTestData();

        String expResult = "It is dinner time!";
        String result = StoreAndDisplayReport.searchByMessageID("1000000004");
        assertEquals(expResult, result);
    }

    // Test of searchbyRecipientByMessageID: message 4 has the recipient 0838884567
    @Test
    public void testSearchbyRecipientByMessageID() {
        System.out.println("searchbyRecipientByMessageID");
        addTestData();

        String expResult = "0838884567";
        String result = StoreAndDisplayReport.searchbyRecipientByMessageID("1000000004");
        assertEquals(expResult, result);
    }

    // Test of searchByRecipient: messages 2 and 5 go to +27838884567
    @Test
    public void testSearchByRecipient() {
        System.out.println("searchByRecipient");
        addTestData();

        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Where are you? You are late! I have asked you to be on time.");
        expResult.add("Ok, I am leaving without you.");

        ArrayList<String> result = StoreAndDisplayReport.searchByRecipient("+27838884567");
        assertEquals(expResult, result);
    }

    // Test of deleteMessageByHash: delete message 2
    @Test
    public void testDeleteMessageByHash() {
        System.out.println("deleteMessageByHash");
        addTestData();

        String expResult = "Message:\"Where are you? You are late! I have asked you to be on time.\" successfully deleted";
        String result = StoreAndDisplayReport.deleteMessageByHash("10:1:WHERETIME");
        assertEquals(expResult, result);
    }

    // Test of displayReport: all 5 messages
    @Test
    public void testDisplayReport() {
        System.out.println("displayReport");
        addTestData();

        String expResult = "----MESSAGE REPORT----\n"
                + "Hash:  10:0:DIDCAKE  |  Recipient:  +27834557896  |  Message:  Did you get the cake?  |  Flag:  Sent\n"
                + "Hash:  10:1:WHERETIME  |  Recipient:  +27838884567  |  Message:  Where are you? You are late! I have asked you to be on time.  |  Flag:  Stored\n"
                + "Hash:  10:2:YOHOOOOGATE  |  Recipient:  +27834484567  |  Message:  Yohoooo, I am at your gate.  |  Flag:  Disregard\n"
                + "Hash:  10:3:ITTIME  |  Recipient:  0838884567  |  Message:  It is dinner time!  |  Flag:  Sent\n"
                + "Hash:  10:4:OKYOU  |  Recipient:  +27838884567  |  Message:  Ok, I am leaving without you.  |  Flag:  Stored\n";
        String result = StoreAndDisplayReport.displayReport();
        assertEquals(expResult, result);
    }

    // Test of clearArrays: everything is empty afterwards
    @Test
    public void testClearArrays() {
        System.out.println("clearArrays");
        addTestData();

        StoreAndDisplayReport.clearArrays();

        assertTrue(StoreAndDisplayReport.allMessages.isEmpty());
        assertTrue(StoreAndDisplayReport.sentMessages.isEmpty());
        assertTrue(StoreAndDisplayReport.storedMessages.isEmpty());
        assertTrue(StoreAndDisplayReport.disregardedMessages.isEmpty());
    }

}
