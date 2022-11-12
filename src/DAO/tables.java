/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;

/**
 *
 * @author suraj
 */
public class tables {

    public static void main(String[] args) {
        try {
            String userTable = "create table user(id int AUTO_INCREMENT primary key, name varchar(200), email varchar(200), mobileNumber varchar(13), address varchar(500),password varchar(100), securityQuestion varchar(200), answer varchar(200), status varchar(20),UNIQUE(email));";
            String adminDetails = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status)  values('Admin','admin@gmail.com','1234567890','India','admin','What primary school did you attend?','DAV','true')";
            DbOperations.setDataorDelete(userTable, "userTale created sucessfully");
            DbOperations.setDataorDelete(adminDetails, "Admin Details Added Successfully");
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200));";
            DbOperations.setDataorDelete(categoryTable, "Category Table Created Successfully");
            String productTable = "create table product (id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200));";
            DbOperations.setDataorDelete(productTable, "Product Table Created Successfully");
            //Place Order 
            String billTable = "create table bill(id int primary key,name varchar(200),mobileNo varchar(12),email varchar(200), date varchar(50),total varchar(200),createdBy varchar(200));";
            DbOperations.setDataorDelete(billTable, "Bill Table Created Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
