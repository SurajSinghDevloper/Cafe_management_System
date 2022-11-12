/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author suraj
 */
public class OpenPdf {
    public static void openById(String id){
        try {
            if((new File("E:\\"+id+".pdf")).exists()){
//            Process p=Runtime
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
