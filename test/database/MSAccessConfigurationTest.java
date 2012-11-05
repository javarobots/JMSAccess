
package database;

import java.io.File;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author javarobots74
 */
public class MSAccessConfigurationTest {

    /**
     * Test of loadDriver method, of class MSAccessConfiguration.
     */
    @Test
    public void testLoadDriver() {
        System.out.println("loadDriver");
        MSAccessConfiguration instance = new MSAccessConfiguration("JUnit", "test.mdb");
        boolean expResult = true;
        boolean result = instance.loadDriver();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataSourceName method, of class MSAccessConfiguration.
     */
    @Test
    public void testGetDataSourceName() {
        System.out.println("getDataSourceName");
        MSAccessConfiguration instance = new MSAccessConfiguration("JUnit", "test.mdb");
        String expResult = "JUnit";
        String result = instance.getDataSourceName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataSourceName method, of class MSAccessConfiguration.
     */
    @Test
    public void testSetDataSourceName() {
        System.out.println("setDataSourceName");
        String dataSourceName = "newJUnit";
        MSAccessConfiguration instance = new MSAccessConfiguration("JUnit", "test.mdb");
        instance.setDataSourceName(dataSourceName);
        String newName = instance.getDataSourceName();
        assertEquals(dataSourceName, newName);
    }

    /**
     * Test of getJdbcOdbcDriver method, of class MSAccessConfiguration.
     */
    @Test
    public void testGetJdbcOdbcDriver() {
        System.out.println("getJdbcOdbcDriver");
        MSAccessConfiguration instance = new MSAccessConfiguration("JUnit", "test.mdb");
        String expResult = "sun.jdbc.odbc.JdbcOdbcDriver";
        String result = instance.getJdbcOdbcDriver();
        assertEquals(expResult, result);
    }

    /**
     * Test of verifyDataSourceDirectory method, of class MSAccessConfiguration.
     */
    @Test
    public void testVerifyDataSourceDirectory() {
        System.out.println("veryDataSourceDirectory");
        MSAccessConfiguration instance = new MSAccessConfiguration("JUnit", "test.mdb");        
        boolean expResult = false;
        File directory = new File(instance.getDataSourceLocation());
        assertEquals(expResult, directory.exists());
        instance.verifyDataSourceDirectory();
        expResult = true;
        assertEquals(expResult, directory.exists());
        directory.delete();
        expResult = false;
        assertEquals(expResult, directory.exists());
    }
    
    /**
     * Test copyDatabaseFile method, of class MSAccessConfiguration.
     */
    @Test
    public void testCopyDatabaseFile() {
        System.out.println("copyDatabaseFile");
        MSAccessConfiguration instance = new MSAccessConfiguration("JUnit", "test.mdb");
        boolean expResult = true;
        instance.copyDatabaseFile();
        File dataSourceFile = new File(instance.getDataSourceLocation(), instance.getDataSourceFileName());
        assertEquals(expResult, dataSourceFile.exists());
        dataSourceFile.delete();
        (new File(instance.getDataSourceLocation())).delete();
    }
}
