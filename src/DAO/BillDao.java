/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Bill;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author suraj
 */
public class BillDao {
    
    public static String getId(){
        int id=1;
        try {
            ResultSet rs=DbOperations.getData("select max(id)from bill");
            if(rs.next()){
                id=rs.getInt(id);
                id=id+1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    
    public static void save(Bill bill){
        String query="insert into bill values('"+bill.getId()+"','"+bill.getName()+"','"+bill.getMobileNumber()+"','"+bill.getEmail()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getCreatedBy()+"')";
        DbOperations.setDataorDelete(query, "Bill Details added successfully");
    }
}
