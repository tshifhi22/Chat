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
public class SendingMessagesTest {
    
    public SendingMessagesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
        String expResult = "";
        String result = SendingMessages.generateMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMessage method, of class SendingMessages.
     */
    @Test
    public void testDisplayMessage() {
        System.out.println("displayMessage");
        SendingMessages instance = null;
        String expResult = "";
        String result = instance.displayMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class SendingMessages.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        SendingMessages instance = null;
        String expResult = "";
        String result = instance.checkRecipientCell();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessage method, of class SendingMessages.
     */
    @Test
    public void testCheckMessage() {
        System.out.println("checkMessage");
        SendingMessages instance = null;
        String expResult = "";
        String result = instance.checkMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValid method, of class SendingMessages.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        SendingMessages instance = null;
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class SendingMessages.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        SendingMessages instance = null;
        String expResult = "";
        String result = instance.createMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class SendingMessages.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        SendingMessages instance = null;
        String expResult = "";
        String result = instance.storeMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageDetails method, of class SendingMessages.
     */
    @Test
    public void testGetMessageDetails() {
        System.out.println("getMessageDetails");
        SendingMessages instance = null;
        String expResult = "";
        String result = instance.getMessageDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessages method, of class SendingMessages.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        String expResult = "";
        String result = SendingMessages.printMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class SendingMessages.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int expResult = 0;
        int result = SendingMessages.returnTotalMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearMessages method, of class SendingMessages.
     */
    @Test
    public void testClearMessages() {
        System.out.println("clearMessages");
        SendingMessages.clearMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageID method, of class SendingMessages.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        SendingMessages instance = null;
        boolean expResult = false;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SentMessage method, of class SendingMessages.
     */
    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        int option = 0;
        SendingMessages instance = null;
        String expResult = "";
        String result = instance.SentMessage(option);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
