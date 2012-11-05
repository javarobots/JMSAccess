package database;

import java.io.File;

/**
 * The configuration object holds the default driver String
 * and data source name. The name is set at the time of
 * construction and can be changed at any time. Database
 * directory verification is also handled.
 *
 * @author javarobots74
 */
public class MSAccessConfiguration {

    private String dataSourceName;
    private String jdbcOdbcDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
    private String dataSourceLocation = "C:/Program Files/Java DSN";

    /**
     * The configuration object is needed to hold information about the
     * database. The constructor requires the data source name which must
     * be configured in the ODBC Data Source Administrator
     * @param dataSourceName
     */
    public MSAccessConfiguration(String dataSourceName){
        this.dataSourceName = dataSourceName;
    }

    /**
     * Loads the jdbcOdbcDriver
     * @return true if driver loads successfully
     */
    public boolean loadDriver(){
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    /**
     * Verify the directory for the database. If the directory is not
     * present it will be created. This is a preparatory step to
     * installing/copying the empty database from resources.
     * @return true upon successful verification
     */
    public boolean verifyDataSourceDirectory() {
        File directory = new File(this.dataSourceLocation);
        boolean result = false;
        if (!directory.exists()){
            result = directory.mkdirs();
        }
        return result;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public String getJdbcOdbcDriver() {
        return jdbcOdbcDriver;
    }

    public String getDataSourceLocation() {
        return dataSourceLocation;
    }

    public void setDataSourceLocation(String dataSourceLocation) {
        this.dataSourceLocation = dataSourceLocation;
    }

}
