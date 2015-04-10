package FriendZone;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import javax.swing.table.*;

/**
 *
 * @author choyan
 */
class AllFriend extends JInternalFrame {

    private JTable table;
    private SModel model;
    
    public  String columns[] = {"Id", "Name", "Category", "Address", "Mobile", "Email", "Facebook"};
  
    public AllFriend() {
                
        super("All Friend", false, true, true, true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new SModel(); //Create table model
        table = new JTable(); //Create jtable
        
        table.setAutoCreateColumnsFromModel(false);
        
        table.setModel(model);//set jtable model 
        
        table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        if (table.isEditing()){
            table.getCellEditor().stopCellEditing();
        }
        //Create columns
        TableColumn column = new TableColumn(0, 2000, null, null);
        table.addColumn(column); // Friend id column
        
        column = new TableColumn(1, 2000, null, null);
        table.addColumn(column); // name column
        
        column = new TableColumn(2, 2000, null, null);
        table.addColumn(column); // category column
        
        column = new TableColumn(3, 2000, null, null);
        table.addColumn(column); // Mobile Column
        
        column = new TableColumn(4, 2000, null, null);
        table.addColumn(column); // Email Column

        column = new TableColumn(5, 2000, null, null);
        table.addColumn(column); // Fb Column

        column = new TableColumn(6, 2000, null, null);
        table.addColumn(column); // Fb Column

        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel addButton = new JPanel();
        
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        
        addButton.add(update);
        addButton.add(delete);
        
        JPanel stat = new JPanel();

        stat.add(new JScrollPane(table)); //Add table to panel
        
        // Creates the bottom table with the button
        JPanel p1 = new JPanel();


        try {
            StatementI statement = null;
            statement = new StatementI();
 
            statement.getStatement();
            
            Vector v = statement.getTransactions();
            if(v.size() > 0) {
                model.vector = v; //Set the new vector v as the new model vector
                model.fireTableDataChanged(); //Notify JTable that data has changed it should redraw
            }
            else {
                JOptionPane.showMessageDialog(null, "Sorry no transactios ");
            }

        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occured " + e.getMessage());
            e.printStackTrace();
        }
        
        delete.addActionListener(new ActionListener() { // add action listener to the button
            public void actionPerformed(ActionEvent we) {
                System.out.println("Delete button is clicked");

                String meh = table.getValueAt(table.getSelectedRow(),0).toString();
                System.out.print(meh);            
                
                try {
                    StatementI statement = null;

                    statement = new StatementI();

                    statement.deleteFriend(meh);

            //        Vector v = statement.getTransactions();
    
              //      model.vector = v; //Set the new vector v as the new model vector

            //        model.fireTableDataChanged();
                }  catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Error Occured " + e.getMessage());
                    e.printStackTrace();
                }

            }
        });
        
        update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent we) {
                System.out.println("Update button clicked");
                
                String id = table.getValueAt(table.getSelectedRow(),0).toString();
                String name = table.getValueAt(table.getSelectedRow(), 1).toString();
                String category = table.getValueAt(table.getSelectedRow(), 2).toString();
                String address = table.getValueAt(table.getSelectedRow(), 3).toString();
                String mobile = table.getValueAt(table.getSelectedRow(), 4).toString();
                String email = table.getValueAt(table.getSelectedRow(), 5).toString();
                String facebook = table.getValueAt(table.getSelectedRow(), 6).toString();
                
//                String category = table.setValueAt(textField.getText(), table.getSelectedRow(), 0).toString();

                
                System.out.println(address);
                
                try {
                    StatementI statement = null;

                    statement = new StatementI();

                    statement.updateFriend(id, name, category, address, mobile, email, facebook);
                }  catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Error Occured " + e.getMessage());
                    e.printStackTrace();
                }
                
            }
        });
        
        
        c.add("North", new JScrollPane(stat));
        c.add("South", addButton); //add panel to form
        
       
        setResizable(true);
        setSize(600, 600);
    }

    
        //This class represent a custom table model
    class SModel extends AbstractTableModel {
        protected Vector vector;
        

        public SModel() {
            vector = new Vector();
        }

        public int getRowCount() {
            return vector==null ? 0 : vector.size();
        }

        public int getColumnCount() {
            return columns.length;
        }

        public String getColumnName(int column) {
            return columns[column];
        }

        public boolean isCellEditable(int nRow, int nCol) {
            return true;
        }
        
        public void setValueAt(Object value, int row, int col) {
            //data[row][col] = value;
            fireTableCellUpdated(row, col);
        }

        public Object getValueAt(int nRow, int nCol) {
            if (nRow < 0 || nRow >= getRowCount())
                return "";

           Transaction t = (Transaction)vector.elementAt(nRow);

            switch(nCol) {
                case 0: return t.getId();
                case 1: return t.getName(); //Date column
                case 2: return t.getCategory(); //Description column
                case 3: return t.getAddress(); // Receipt column
                case 4: return t.getMobile();
                case 5: return t.getEmail();
                case 6: return t.getFb(); // Payment column
            }
            return "";
        }

        public void add(Object o) {
            vector.addElement(o);
        }

        public void remove() {
            vector.removeAllElements();
        }

    }//End of SModel inner class
}
