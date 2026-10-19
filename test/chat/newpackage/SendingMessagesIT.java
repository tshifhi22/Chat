/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package chat.newpackage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tshik
 */
public class SendingMessagesIT {

    // Test data for Message 1
    private String id1 = "1234567890";
    private String recipient1 = "+27718693002";
    private String message1 = "Hi Mike, can you join us for dinner tonight?";

    // Test data for Message 2
    private String id2 = "0987654321";
    private String recipient2 = "08575975889";
    private String message2 = "Hi Keegan, did you receive the payment?";

    public SendingMessagesIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Empty the message lists before each test
        SendingMessages.clearMessages();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of generateMessageID method, of class SendingMessages.
     */
    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");

        // The ID is random, so we only check that it is 10 characters long
        String result = SendingMessages.generateMessageID();
        assertEquals(10, result.length());
    }

    /**
     * Test of displayMessage method, of class SendingMessages.
     */
    @Test
    public void testDisplayMessage() {
        System.out.println("displayMessage");

        SendingMessages instance = new SendingMessages(id1, 1, recipient1, message1);
        String expResult = "Message ID generated:" + id1;
        String result = instance.displayMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkRecipientCell method, of class SendingMessages.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");

        // Message 1 has a valid number with +27
        SendingMessages msg1 = new SendingMessages(id1, 1, recipient1, message1);
        assertEquals("Cell phone number is successfully captured.", msg1.checkRecipientCell());

        // Message 2 has no international code
        SendingMessages msg2 = new SendingMessages(id2, 2, recipient2, message2);
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", msg2.checkRecipientCell());
    }

    /**
     * Test of checkMessage method, of class SendingMessages.
     */
    @Test
    public void testCheckMessage() {
        System.out.println("checkMessage");

        // Both messages are under 250 characters
        SendingMessages msg1 = new SendingMessages(id1, 1, recipient1, message1);
        assertEquals("Message sent", msg1.checkMessage());

        SendingMessages msg2 = new SendingMessages(id2, 2, recipient2, message2);
        assertEquals("Message sent", msg2.checkMessage());
    }

    /**
     * Test of isValid method, of class SendingMessages.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");

        // Message 1 has a valid number and a short message
        SendingMessages msg1 = new SendingMessages(id1, 1, recipient1, message1);
        assertEquals(true, msg1.isValid());

        // Message 2 has an invalid number
        SendingMessages msg2 = new SendingMessages(id2, 2, recipient2, message2);
        assertEquals(false, msg2.isValid());
    }

    /**
     * Test of createMessageHash method, of class SendingMessages.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");

        // First two digits of the ID : message number : first word + last word
        SendingMessages msg1 = new SendingMessages(id1, 1, recipient1, message1);
        assertEquals("12:1:HITONIGHT", msg1.createMessageHash());

        SendingMessages msg2 = new SendingMessages(id2, 2, recipient2, message2);
        assertEquals("09:2:HIPAYMENT", msg2.createMessageHash());
    }

    /**
     * Test of storeMessage method, of class SendingMessages.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");

        SendingMessages instance = new SendingMessages(id1, 1, recipient1, message1);
        String expResult = "Message successfully stored";
        String result = instance.storeMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMessageDetails method, of class SendingMessages.
     */
    @Test
    public void testGetMessageDetails() {
        System.out.println("getMessageDetails");

        SendingMessages instance = new SendingMessages(id1, 1, recipient1, message1);
        String expResult = "Message ID: " + id1 + "\n" + "Message Hash :12:1:HITONIGHT" + "\n" + "Recipient :" + recipient1 + "\n" + "Message:" + message1;
        String result = instance.getMessageDetails();
        assertEquals(expResult, result);
    }

    /**
     * Test of printMessages method, of class SendingMessages.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");

        // Nothing has been sent yet
        assertEquals("No messages have been sent.", SendingMessages.printMessages());

        // Send message 1 and check it is printed
        SendingMessages msg1 = new SendingMessages(id1, 1, recipient1, message1);
        msg1.SentMessage(1);

        String expResult = msg1.getMessageDetails() + "\n\n";
        assertEquals(expResult, SendingMessages.printMessages());
    }

    /**
     * Test of returnTotalMessages method, of class SendingMessages.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");

        SendingMessages msg1 = new SendingMessages(id1, 1, recipient1, message1);
        SendingMessages msg2 = new SendingMessages(id2, 2, recipient2, message2);

        msg1.SentMessage(1); // Send
        msg2.SentMessage(2); // Discard

        // Only message 1 was sent
        int expResult = 1;
        int result = SendingMessages.returnTotalMessages();
        assertEquals(expResult, result);
    }

    /**
     * Test of clearMessages method, of class SendingMessages.
     */
    @Test
    public void testClearMessages() {
        System.out.println("clearMessages");

        // Send a message so the list is not empty
        SendingMessages msg1 = new SendingMessages(id1, 1, recipient1, message1);
        msg1.SentMessage(1);

        SendingMessages.clearMessages();

        // The list should be empty after clearing
        assertEquals(0, SendingMessages.returnTotalMessages());
    }

    /**
     * Test of checkMessageID method, of class SendingMessages.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");

        // The ID is 10 digits, so it is not more than 10 characters
        SendingMessages instance = new SendingMessages(id1, 1, recipient1, message1);
        boolean expResult = true;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
    }

    /**
     * Test of SentMessage method, of class SendingMessages.
     */
    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");

        // Message 1: Select Send
        SendingMessages msg1 = new SendingMessages(id1, 1, recipient1, message1);
        assertEquals("Message successfully sent", msg1.SentMessage(1));

        // Message 2: Select Discard
        SendingMessages msg2 = new SendingMessages(id2, 2, recipient2, message2);
        assertEquals("Press 0 to delete the message", msg2.SentMessage(2));

        // An option that does not exist
        assertEquals("Invalid option.", msg1.SentMessage(9));
    }

}