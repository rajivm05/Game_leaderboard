/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_score_board;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rajiv
 */
public class Intermediate extends javax.swing.JFrame {

    /**
     * Creates new form Intermediate
     */
    public Intermediate(int loginid) {
        initComponents();
        this.getContentPane().setBackground(Color.black);
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        loginid_label.setText(""+loginid);
        loginid_label.setVisible(false);
        jButton6.setBackground(new Color(230,25,56));jButton8.setBackground(new Color(230,25,56));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        loginid_label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("View Overall Leaderboard");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 270, 40));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("View DOTA Scoreboard");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 270, 40));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setText("View CSGO Scoreboard");
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 270, 40));

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton10.setText("Update Profile");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 270, 40));
        getContentPane().add(loginid_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game_score_board/xgames.jpeg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 386, 328));

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton11.setText("Logout");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 270, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
this.dispose();
new overall_leaderboard(Integer.parseInt(loginid_label.getText())).setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
this.dispose();
new dota_scoreboard(Integer.parseInt(loginid_label.getText())).setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
this.dispose();
new update_profile(Integer.parseInt(loginid_label.getText())).setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
this.dispose();
new csgo_scoreboard(Integer.parseInt(loginid_label.getText())).setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
int ID=Integer.parseInt(loginid_label.getText());
String sql="SELECT gameid,game_no from login_gameID where loginid="+ID+" order by game_no";
Connection conn=null;
String url="jdbc:sqlite:C:\\Rajiv\\SQL\\Sqlite\\game_database.db";
try
{
    conn = DriverManager.getConnection(url);
    Statement stmt  = conn.createStatement();
    ResultSet rs    = stmt.executeQuery(sql);
    while(rs.next())
    {
        if(rs.getInt("game_no")==1)
        {
            int n=JOptionPane.showConfirmDialog(null,"Would you like to update your csgo stats?");
            if(n==0)
            {
                int kills=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the new number of kills: "));
                int hours_played=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the new number of hours played: "));
                int points=kills*hours_played;
                String update_query="UPDATE csgo SET kills="+kills+",hours_played="+hours_played+",points="+points+" WHERE gameid='"+rs.getString("gameid")+"';";
                Statement stmt2  = conn.createStatement();
                stmt2.executeUpdate(update_query);
                JOptionPane.showMessageDialog(null,"Updated!");
            }
        }
        if(rs.getInt("game_no")==2)
        {
            int n=JOptionPane.showConfirmDialog(null,"Would you like to update your dota stats?");
            if(n==0)
            {
                int kills=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the new number of kills: "));
                int hours_played=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the new number of hours played: "));
                int points=kills*hours_played;
                String update_query="UPDATE dota SET kills="+kills+",hours_played="+hours_played+",points="+points+" WHERE gameid='"+rs.getString("gameid")+"';";
                Statement stmt2  = conn.createStatement();
                stmt2.executeUpdate(update_query);
                JOptionPane.showMessageDialog(null,"Updated!");
            }
        }
        
    }
    conn.close();
    this.dispose();
    new Login_Page().setVisible(true);
}
catch(SQLException e)
{
    System.out.println(e.getMessage());
}
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Intermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Intermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Intermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Intermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        int loginid=0;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Intermediate(loginid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel loginid_label;
    // End of variables declaration//GEN-END:variables
}