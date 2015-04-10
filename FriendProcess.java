package FriendZone;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author choyan
 */
public class FriendProcess {
    
    public FriendProcess() {
        super();
    }
    
    public void CreateAccount(String n, String c, String a, String m, String e, String f) throws SQLException {
        
        PreparedStatement st = null;
        Connection con = null;
        if(n.isEmpty()) {

            JOptionPane.showMessageDialog(null,"Please insert a name");
        
        } else {
           
            // Building the SQL queary
            String sql = "INSERT INTO friendinfo(name, category, address, mobile, email, fb) VALUES(?, ?, ?, ?, ?, ?)";

            try {
                con = Database.getConnection();

                // Preparing the request
                st = con.prepareStatement(sql);
                st.setString(1, n);
                st.setString(2, c);
                st.setString(3, a);
                st.setString(4, m);
                st.setString(5, e);
                st.setString(6, f);


                // Executing the SQL queary
                st.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Account has been added");

            } catch(SQLException err) {
            
                throw err; //Rethrow the exception to the client
            
            } finally {
              
                st.close();
           
            }
        
        }        
    }
    
    public void allFriendList() {
        
    }
    
}
