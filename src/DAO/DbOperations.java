/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author suraj
 */
public class DbOperations {
    public static void setDataorDelete(String Query, String msg){
        try{
            Connection con= ConnctionProvider.getCon();
                 System.out.println(con);
            System.out.println("Connection established");
            Statement st=con.createStatement();
       
            System.out.println("Connection established");
            st.executeUpdate(Query);
            if(!msg.equals(""))
                JOptionPane.showMessageDialog(null, msg);
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null,e,"Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ResultSet getData(String query){
        try{
            Connection con=ConnctionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            return rs;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e,"Message",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
