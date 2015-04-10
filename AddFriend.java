package FriendZone;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author choyan
 */
class AddFriend extends JInternalFrame {
    
    private JTextField name;
    private JComboBox category;
    private JTextField address;
    private JTextField mobile;
    private JTextField email;
    private JTextField fb;
    
    public AddFriend() {

        super("Add new Friend", false, true, true, true);
        
        String[] petStrings = { "School", "College", "University", "Local" };
        
        name = new JTextField(50);
        category =  new JComboBox(petStrings);
        address =  new JTextField(100);
        mobile =   new JTextField(20);
        email =  new JTextField(25);
        fb =  new JTextField(20);
        
        Container mainContainer = getContentPane();
        mainContainer.setLayout(new BorderLayout());
    
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(6, 2));
        
        form.add(new JLabel("Friend Name"));
        form.add(name);
        
        form.add(new JLabel("Category"));
        form.add(category);
        
        form.add(new JLabel("Address"));
        form.add(address);
        
        form.add(new JLabel("Mobile No."));
        form.add(mobile);

        form.add(new JLabel("Email"));
        form.add(email);

        form.add(new JLabel("Facebook User name"));
        form.add(fb);
    
        // Creates the bottom table with the three buttons
        JPanel buttons = new JPanel();
        JButton add = new JButton("Add");

        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent we) {
                String type = "";
                String getName = name.getText();
                String getCategory = category.getSelectedItem().toString();
                String getAddress = address.getText();
                String getMobile = mobile.getText();
                String getEmail = email.getText();
                String getFb = fb.getText();
                
                // Running the function createAccount()
                try {
                    //get a Account Inteface from the RMI Registry
                    FriendProcess addFriend = new FriendProcess();
                    addFriend.CreateAccount(getName, getCategory, getAddress, getMobile, getEmail, getFb);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Error Occured " + e.getMessage());
                    e.printStackTrace();
                }
                
            }
        });
        buttons.add(add);
        
        mainContainer.add("South", buttons);
        mainContainer.add(form);
        // Setting characteristics of the window
        setResizable(false);
        setSize(400, 240);
    }
}
