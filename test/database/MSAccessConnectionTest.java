package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            System.out.println("getConnection");
            MSAccessConfiguration testConfig = new MSAccessConfiguration("test", "test.mdb");
            MSAccessConnection instance = new MSAccessConnection(testConfig);
            Connection result = instance.getConnection();
            org.junit.Assert.assertNotNull(result);
        } catch (SQLException ex) {
            Logger.getLogger(MSAccessConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testInvalidConnection() {
        try {
            System.out.println("invalidConnection");
            MSAccessConfiguration testConfig = new MSAccessConfiguration("JUnit", "test.mdb");
            MSAccessConnection instance = new MSAccessConnection(testConfig);
            Connection result = instance.getConnection();
            org.junit.Assert.assertNull(result);
        } catch (SQLException ex) {
            Logger.getLogger(MSAccessConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
