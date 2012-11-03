package database;

/**
 * The configuration object holds the default driver String
 * and data source name. The name is set at the time of
 * construction and can be changed at any time.
 * 
 * @author javarobots74
 */
public class MSAccessConfiguration {
    
    private String dataSourceName;
    private String jdbcOdbcDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
    
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

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public String getJdbcOdbcDriver() {
        return jdbcOdbcDriver;
    }    
    
}
