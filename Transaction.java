/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FriendZone;

/**
 *
 * @author choyan
 */
public class Transaction {
    private String id;
    private String name;
    private String category;
    private String address;
    private String mobile;
    private String email;
    private String fb;
    
    public Transaction(String a, String b, String c, String d, String e, String f, String g) {
        id = a;
        name = b;
        category = c;
        address = d;
        mobile = e;
        email = f;
        fb = g;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getFb() {
        return fb;
    }
    
}
