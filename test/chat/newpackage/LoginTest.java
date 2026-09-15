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
public class LoginTest {

    public LoginTest() {
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
     * Test of checkUserName method, of class Login.
     * Valid: contains underscore, no more than five characters.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        // Valid case - "kyl_1" has an underscore and is exactly 5 characters
        assertTrue(Login.checkUserName("kyl_1"));
        // Invalid case - "kyle!!!!!!" has no underscore and is too long
        assertFalse(Login.checkUserName("kyle!!!!!!"));
    }

    /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        Login instance = new Login();
        // Valid case - correct SA international format
        assertTrue(instance.checkCellPhoneNumber("+27838968976"));
        // Invalid case - missing international code
        assertFalse(instance.checkCellPhoneNumber("08966553"));
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     * Valid: at least 8 characters, a capital letter, a number, a special character.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        // Valid case
        assertTrue(Login.checkPasswordComplexity("Ch&&sec@ke99!"));
        // Invalid case - no capital, number, or special character
        assertFalse(Login.checkPasswordComplexity("password"));
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        Login instance = new Login();

        // Valid case - all fields meet the rules
        String expResult = " The user has been registered successfully";
        String result = instance.registerUser("Tshifhiwa", "Tshikalange", "tshi_", "Ch&&sec@ke99!", "+27838968976");
        assertEquals(expResult, result);
    }

    /**
     * Test of loginUser method, of class Login.
     * Must register a user first so registeredUserName/registeredPassword are populated.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        Login instance = new Login();
        instance.registerUser("Tshifhiwa", "Tshikalange", "tshi_", "Ch&&sec@ke99!", "+27838968976");

        // Correct credentials - should succeed
        assertTrue(instance.loginUser("tshi_", "Ch&&sec@ke99!"));

        // Incorrect credentials - should fail
        assertFalse(instance.loginUser("tshi_", "wrongPassword1!"));
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     * Must register a user first so the welcome message has a name to use.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        Login instance = new Login();
        instance.registerUser("Tshifhiwa", "Tshikalange", "tshi_", "Ch&&sec@ke99!", "+27838968976");

        // Successful login message
        String expSuccessResult = "Welcome Tshifhiwa, Tshikalange it is great to see you again.";
        assertEquals(expSuccessResult, instance.returnLoginStatus(true));

        // Failed login message
        String expFailResult = "Username or password is incorrect, please try again";
        assertEquals(expFailResult, instance.returnLoginStatus(false));
    }

}