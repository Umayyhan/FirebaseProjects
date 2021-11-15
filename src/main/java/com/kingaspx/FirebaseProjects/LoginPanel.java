/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.kingaspx.FirebaseProjects;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class LoginPanel extends javax.swing.JPanel {

    public LoginPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        email_field = new javax.swing.JTextField();
        name_field = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 30, 250, 50);

        password_field.setText("jPasswordField1");
        password_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(password_field);
        password_field.setBounds(80, 180, 250, 30);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(140, 230, 120, 25);

        email_field.setText("Email");
        email_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(email_field);
        email_field.setBounds(80, 140, 250, 30);

        name_field.setText("Name");
        name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(name_field);
        name_field.setBounds(80, 100, 250, 30);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void password_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_fieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getDataByEmail();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    private void getDataByEmail(){
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(email_field.getText());
           // System.out.println("Successfully fetched user data: " + userRecord);//+userRecord.getEmail() yazarsan emaili ile gösterir consolda
            var email= userRecord.getEmail();
            var name= userRecord.getDisplayName();
            var uid= userRecord.getUid();
            var password=  "123456"; //STORE PASSWORD IN DATABASE
            //var password= userRecord.getPassword();
            System.out.println(email);
            System.out.println(name);
            System.out.println(uid);
            
            if(password.equals(password_field.getText())){
                JOptionPane.showMessageDialog(null,"Welcome "+ email);      
            }else{
                JOptionPane.showMessageDialog(null,"Invalid Credentials");      
            }
            //System.out.println(""); 
            //recoverUserData(uid);
        } catch (FirebaseAuthException ex) {
            JOptionPane.showMessageDialog(null,"Invalid Credentials");      
        }
        // See the UserRecord reference doc for the contents of userRecord.
    }
    private void recoverUserData(String uid){
        UserRecord userRecord;
        try {
            userRecord = FirebaseAuth.getInstance().getUser(uid);
            System.out.println("Successfully fetched user data: " + userRecord.getUid());

        } catch (FirebaseAuthException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void email_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_fieldActionPerformed

    private void name_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_fieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name_field;
    private javax.swing.JPasswordField password_field;
    // End of variables declaration//GEN-END:variables
}
