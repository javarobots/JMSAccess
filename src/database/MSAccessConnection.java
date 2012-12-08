package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javarobots74
 */
public class MSAccessConnection {

    private MSAccessConfiguration configuration;
    private Connection connection;

    public MSAccessConnection(MSAccessConfiguration configuration){
        this.configuration = configuration;
    }

    public Connection getConnection()throws SQLException{
        if (connection == null){
                String connectString = "jdbc:odbc:" + configuration.getDataSourceName();
                connection = DriverManager.getConnection(connectString);
        }
        return connection;

    }

//    public static void main(String[] args){
//
//        try {
//
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from TestTable");
//            while(rs.next()){
//                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
//            }
//        }
//        catch (Exception ex){
//
//        }
//
//    }

    public String getDataSourceName() {
        return configuration.getDataSourceName();
    }

    public String getDataSourceFileName() {
        return configuration.getDataSourceFileName();
    }

}
