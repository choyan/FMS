/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FriendZone;
import java.sql.*;
import java.util.Arrays;

/**
 *
 * @author choyan
 */
public class categoryTest {
    //Database URL
    static final String DATABASE_URL = "jdbc:mysql://localhost/friendzone";

    public static void main (String args []) {

        Connection c = null; //Manages Connection
        Statement s = null; //Query Statement

        ResultSet r = null; //Manages Results        
        ResultSet count = null;

        try {
            //Establish Connection to Database
            c = DriverManager.getConnection(DATABASE_URL, "choyan", "91929394");
            //Create Statement for querying database
            s = c.createStatement();
            //Query Database
                        
            count = s.executeQuery("Select count(*) from category");
            int numberofRows = 0;
            
            while(count.next()){
                numberofRows = count.getInt(1);
            }
            System.out.println(numberofRows);
            
            
            r = s.executeQuery("Select name from category");
            
            String[] categories = new String[numberofRows];

            while(r.next()) {
                for (int i=1; i<=numberofRows; i++){
                    categories[i] = (String) r.getObject(i);
                }
            }
            System.out.println(Arrays.toString(categories));
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
