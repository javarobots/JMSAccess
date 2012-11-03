package database;

import java.sql.Connection;
import org.junit.Test;

/**
 *
 * @author javarobots74
 */
public class MSAccessConnectionTest {
    
    public MSAccessConnectionTest() {
    }

    /**
     * Test of getConnection method, of class MSAccessConnection.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        MSAccessConfiguration testConfig = new MSAccessConfiguration("test");
        MSAccessConnection instance = new MSAccessConnection(testConfig);
        Connection result = instance.getConnection();
        org.junit.Assert.assertNotNull(result);
    }
    
    @Test
    public void testInvalidConnection() {
        System.out.println("invalidConnection");
        MSAccessConfiguration testConfig = new MSAccessConfiguration("JUnit");
        MSAccessConnection instance = new MSAccessConnection(testConfig);
        Connection result = instance.getConnection();
        org.junit.Assert.assertNull(result);
    }
}
