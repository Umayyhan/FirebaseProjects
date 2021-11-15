/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.kingaspx.FirebaseProjects;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.awt.List;
import java.util.ArrayList;


public class FetchDatabase extends javax.swing.JPanel {
     
    final FirebaseDatabase database = FirebaseDatabase.getInstance("add your firebase url");
    DatabaseReference ref = database.getReference();

    public FetchDatabase() {
        initComponents();
              
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        child_field = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fetch Database");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 10, 250, 50);

        jButton1.setBackground(new java.awt.Color(204, 0, 204));
        jButton1.setText("Fetch");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(140, 230, 120, 25);

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 380, 130);

        child_field.setBackground(new java.awt.Color(255, 255, 255));
        child_field.setForeground(new java.awt.Color(0, 0, 0));
        child_field.setText("clicks");
        child_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                child_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(child_field);
        child_field.setBounds(10, 60, 380, 19);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ref.child(child_field.getText()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                var result = dataSnapshot.getValue().toString().split("}");
                var number = result.length;
                distance test= new distance();
                //var result= new String [100]; 
                //var sentence= new String [100];
                var node= new String [number];
                var lng= new String [number];
                var lat= new String [number]; 
                
                double koordx[];
		koordx = new double[number];
                
                double koordy[];
		koordy = new double[number];
                
                double mesafe[][];
		mesafe = new double[number][number];
                var j=0;
                var k=0;
                var l=0;
                var z=0;
                var f=0;
                var a=0;
                
                
                //result = dataSnapshot.getValue().toString().split("}");
                //node =result.toString().split("[={]");
                var sentence= dataSnapshot.getValue().toString().replace(" ","").replace("-","").split("[={},]");
                //sentence= dataSnapshot.getValue().toString().replace(" ","").replace("-","").split("[={},]");
                var textareas = dataSnapshot.getValue().toString().replace("{", "").replace("}", "").split(",");
                for (String result1 : textareas) {
                    jTextArea1.append(result1 + "\n");
                     
                }
                
                for(var i=0; i<sentence.length;i++){
                    
                    if(i%9 == 1){
                        
                        node[j]= sentence[i];
                        System.out.println("node"+j+"-> "+node[j]);
                        j++; 
                    }
                    else if(i%9 == 4){
                        lng[k]= sentence[i];
                        
                        koordy[k]= Double.parseDouble(lng[k]); 
                        //System.out.println("lng"+k+"-> "+lng[k]);
                        System.out.println("koordy"+k+"-> "+koordy[k]);
                        //lng[k] = sentence[i];
                        k++;
                    }
                    else if(i%9 == 6){
                        lat[l]= sentence[i];
                        koordx[l]= Double.parseDouble(lat[l]);
                        //lat[l]= sentence[i];
                        //System.out.println("lat"+l+"-> "+lat[l]);
                        System.out.println("koordx"+l+"-> "+koordx[l]);
                        l++;
                    }
                    else{
                        continue;
                    }
                }
                              
                for (z=0; z<koordx.length;z++){
                    for( a=0;a<koordy.length; a++ ){
                        mesafe[z][a]= test.distance(koordx[z], koordy[z],koordx[a], koordy[a]);
                        //f++;
                        //System.out.println("mesafe"+f+"-> "+mesafe[f]);
                    }
                }
                for(var u=0; u<mesafe.length;u++){
                    for(f=0;f<mesafe.length;f++){
                        System.out.print("[mesafe"+u+","+f+"->"+mesafe[u][f]+"]\t\t");
                    }
                    System.out.print("\n");
                }
                
                PGraph g = new PGraph();
                g.Prim(mesafe, number);
                
            }
            
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void child_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_child_fieldActionPerformed
// Attach a listener to read the data at our posts reference
                
    }//GEN-LAST:event_child_fieldActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField child_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}



