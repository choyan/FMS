/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FriendZone;


import java.sql.*;
import java.util.*;
import javax.swing.*;



/**
 *
 * @author choyan
 */
public class StatementI {
    

    private Vector transactions;
    
    // Constructor of the class
    public StatementI() {
        super();
        transactions = new Vector();
    }


    public Vector getTransactions () {
        return transactions;
    }

    //This funtion takes an account number, date from, date to and
    //returns a vector of all transactions between those periods for the account
    public void getStatement () throws SQLException {
        PreparedStatement st = null;
        Connection con = null;

        AddFriend a = new AddFriend(); //Create an account object

        String sqlr = "SELECT * FROM friendinfo";

        transactions.removeAllElements();
        try {
            con = Database.getConnection();
            st = con.prepareStatement(sqlr);   //Get all receipts
            ResultSet rst = st.executeQuery();
            while(rst.next()) {
                Transaction t = new Transaction(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("category"),
                    rst.getString("address"),
                    rst.getString("mobile"),
                    rst.getString("email"),
                    rst.getString("fb")
               );
               transactions.add(t);
           }

        }
        finally {
             st.close();
        }
    }

    public void deleteFriend(String m)  throws SQLException {
        PreparedStatement st = null;
        Connection con = null;
        
        String sql = "DELETE from friendinfo where id = ?";

            try {
                con = Database.getConnection();

                // Preparing the request
                st = con.prepareStatement(sql);
                st.setString(1, m);
                
                // Executing the SQL queary
                st.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Account has been deleted");

            } catch(SQLException err) {
            
                throw err; //Rethrow the exception to the client
            
            } finally {
              
                st.close();
           
            }

        
    }

    void updateFriend(String id, String name, String category, String address, String mobile, String email, String facebook) throws SQLException  {

        PreparedStatement st = null;
        Connection con = null;
        
        String sql = "UPDATE friendinfo SET name = ?, category = ?, address =?, mobile = ?, email = ?, fb = ? WHERE id = ?";

        try {
            con = Database.getConnection();

            // Preparing the request
            st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, category);
            st.setString(3, address);
            st.setString(4, mobile);
            st.setString(5, email);
            st.setString(6, facebook);
            st.setString(7, id);
            // Executing the SQL queary
            // Executing the SQL queary
            int rtn = st.executeUpdate();

            // Appropriate error message
            if(rtn == 0)
                throw new SQLException("The id you specied does not exist. No records changed");


//            JOptionPane.showMessageDialog(null,"Account has been Updated");

        } finally {

            st.close();

        }

    
    }

}


