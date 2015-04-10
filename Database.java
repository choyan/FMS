package FriendZone;


import java.sql.*;
import java.sql.Statement;

/**
 *
 * @author choyan
 */
public class Database {

    private static Statement stmt;
    private static Statement stmtScrollable;
    private static Connection connection;


    // The constructor of the class
    private Database() {
    
    }

    static {
        try {
            String url = "jdbc:mysql://localhost/friendzone";

            connection =  DriverManager.getConnection(url, "choyan", "91929394");
            stmtScrollable = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_READ_ONLY);

            stmt = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
     }

    // Returns the connection when requested by other classes
    public static Connection getConnection() {
        return connection;
    }
    
    public static ResultSet getScrollableRecord( String  strSql ) throws SQLException {
        return stmtScrollable.executeQuery( strSql );
    }
    
    public void close() throws SQLException {
        stmt.close();
        stmtScrollable.close();
        connection.close();
    }
}
