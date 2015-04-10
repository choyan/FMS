/**
 *
 * @author choyan
 */

package FriendZone;

import javax.swing.*;
import java.awt.event.*;

public class main extends JFrame {
    
    private JMenu file;
    private JMenu friend;
    private JMenu listing;
    private JMenu all;
    
    private JMenuItem close;
    private JMenuItem addFriend;
    private JMenuItem schoolfriend;
    private JMenuItem collegefriend;
    private JMenuItem universityfriend;
    private JMenuItem localfriend;
    private JMenuItem allfriend;

    
    private JMenuBar menubar;
    private JDesktopPane desktopPane;
    private JInternalFrame internalFrame;
    
    public main() {
        
        super("Friend Zone");
        desktopPane = new JDesktopPane();
        getContentPane().add(desktopPane);
        
        menubar = new JMenuBar();

        file = new JMenu("File");
        friend = new JMenu("Friend");
        listing = new JMenu("Listing");
        all = new JMenu("All");
        
        
        // Close option
        close = new JMenuItem("Close");
        close.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent we) 
            {
             System.exit(1);
            }
         });
        file.add(close);
        
        addFriend = new JMenuItem("Add Friend");
        addFriend.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent we) {
                internalFrame = new AddFriend();
                desktopPane.add(internalFrame);
                internalFrame.show();
            }
        });
        friend.add(addFriend);
        
        schoolfriend = new JMenuItem("School Friend");
        schoolfriend.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent we) {
                internalFrame = new SchoolFriend();
                desktopPane.add(internalFrame);
                internalFrame.show();
            }
        });
        listing.add(schoolfriend);

        collegefriend = new JMenuItem("College Friend");
        collegefriend.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent we) {
                internalFrame = new CollegeFriend();
                desktopPane.add(internalFrame);
                internalFrame.show();
            }
        });
        listing.add(collegefriend);        

        universityfriend = new JMenuItem("University Friend");
        universityfriend.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent we) {
                internalFrame = new UniversityFriend();
                desktopPane.add(internalFrame);
                internalFrame.show();
            }
        });
        listing.add(universityfriend);        
        
        localfriend = new JMenuItem("Local Friend");
        localfriend.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent we) {
                internalFrame = new LocalFriend();
                desktopPane.add(internalFrame);
                internalFrame.show();
            }
        });
        listing.add(localfriend);        

        allfriend = new JMenuItem("All Friend");
        allfriend.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent we) {
                internalFrame = new AllFriend();
                desktopPane.add(internalFrame);
                internalFrame.show();
            }
        });
        all.add(allfriend);        
        
        menubar.add(file);
        menubar.add(friend);
        menubar.add(listing);
        menubar.add(all);
        
        
        setJMenuBar(menubar);
        setSize(700, 700);
        setVisible(true);

    }
            
    public static void main(String[] args) {
        new main();
    }
    
}
