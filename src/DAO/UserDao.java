/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author suraj
 */
public class UserDao {

    public static void save(User user) {
        String query = "insert into user(name, email,mobileNumber,address,password,securityQuestion,answer,status) values('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','false')";
        DbOperations.setDataorDelete(query, "Registered Succesfully! Wait for Admin Approval");
    }

    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select * from user where email='" + email + "' and password='" + password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select *from user where email='" + email + "'");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static void update(String email, String newPassword) {
        String query = "update user set password='" + newPassword + "' where email='" + email + "'";
        DbOperations.setDataorDelete(query, "Password Changed Sucessfully");
    }
    public static ArrayList<User>getAllRecord(String email){
        ArrayList<User>arrayList=new ArrayList<>();
        try {
           ResultSet rs = DbOperations.getData("select*from user where email like '%"+email+"'");
           while(rs.next()){
               User user=new User();
               user.setId(rs.getInt("ID"));
               user.setName(rs.getString("Name"));
               user.setEmail(rs.getString("Email"));
               user.setMobileNumber(rs.getString("MobileNumber"));
               user.setAddress(rs.getString("Address"));
               user.setSecurityQuestion(rs.getString("SecurityQuestion"));
               user.setStatus(rs.getString("Status"));
               arrayList.add(user);
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void changeStatus(String email,String status){
        String query="update user set status='"+status+"' where email='"+email+"'";
        DbOperations.setDataorDelete(query, "Status Changed Successfully!");
    }
}
