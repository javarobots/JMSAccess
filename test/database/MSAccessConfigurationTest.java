
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
        MSAccessConfiguration instance = new MSAccessConfiguration("JUnit");
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
        MSAccessConfiguration instance = new MSAccessConfiguration("JUnit");
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
        MSAccessConfiguration instance = new MSAccessConfiguration("JUnit");
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
        MSAccessConfiguration instance = new MSAccessConfiguration("JUnit");
        String expResult = "sun.jdbc.odbc.JdbcOdbcDriver";
        String result = instance.getJdbcOdbcDriver();
        assertEquals(expResult, result);
    }

    @Test
    public void veryDataSourceDirectory() {
        System.out.println("veryDataSourceDirectory");
        MSAccessConfiguration instance = new MSAccessConfiguration("JUnit");
        String dataSourceDirectory = instance.getDataSourceLocation();
        boolean expResult = false;
        File directory = new File(dataSourceDirectory);
        assertEquals(expResult, directory.exists());
        instance.veryDataSourceDirectory();
        expResult = true;
        assertEquals(expResult, directory.exists());
        directory.delete();
        expResult = false;
        assertEquals(expResult, directory.exists());
    }
}
