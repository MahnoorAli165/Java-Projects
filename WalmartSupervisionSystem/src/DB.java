/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usama
 */
import oracle.jdbc.driver.OracleDriver;
import java.sql.*;
import javax.swing.JOptionPane;
public class DB {
        
    static String[] username, password, role ;
    
    public static void connAndLogins(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","wss1","wss1");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            
            username = new String[5];
            password = new String[5];
            role = new String[5];
            
            int i = 0;
            
            while(rs.next() && i!=6 ){
                if(rs.getInt(8) == 0){
                    System.out.println(rs.getString(2) + "(" +  rs.getString(5) + ") --- Role: " + rs.getString(4) );
                    username[i] = (rs.getString(2));
                    password[i] = rs.getString(5);
                    role[i] = rs.getString(4);
                    i++;
                }
                
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static ResultSet executeQuery(String query){
        ResultSet rs = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","wss1","wss1");
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "There is an Exception");
        }
        return rs;
    }
    
    
    
    public static void main(String[] args){
        DB.connAndLogins();
        
        
    }
    
    
}
