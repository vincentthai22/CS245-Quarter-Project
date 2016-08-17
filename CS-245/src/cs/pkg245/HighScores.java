/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.pkg245;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class HighScores extends javax.swing.JFrame {
    ArrayList<String> list = new ArrayList<>(5);
    
    FileWriter f;
    /**
     * Creates new form HighScores
     */
    public HighScores() throws IOException {
        initComponents();
        f = new FileWriter("highscores.txt");
        list = f.list;
        for(int i = 0 ; i < list.size(); i++){
            System.out.println("iter");
            if( i == 4)
                firstScore.setText(list.get(i));
            if( i == 3)
                secondScore.setText(list.get(i));
            if( i == 2)
                thirdScore.setText(list.get(i));
            if( i == 1)
                fourthScore.setText(list.get(i));
            if( i == 0)
                fifthScore.setText(list.get(i));
        }
//        
//        list.add(firstScore.getText());
//        list.add(secondScore.getText());
//        list.add(thirdScore.getText());
//        list.add(fourthScore.getText());
//        list.add(fifthScore.getText());
    }
    public HighScores(boolean isLoading) throws IOException{
        f = new FileWriter("highscores.txt");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        firstScore = new javax.swing.JLabel();
        secondScore = new javax.swing.JLabel();
        thirdScore = new javax.swing.JLabel();
        fourthScore = new javax.swing.JLabel();
        fifthScore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("HIGHSCORES");

        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBack(evt);
            }
        });

        firstScore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstScore.setText("ABC....0001");

        secondScore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        secondScore.setText("DEF....0002");

        thirdScore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        thirdScore.setText("GHI....0003");

        fourthScore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fourthScore.setText("JKL....0000");

        fifthScore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fifthScore.setText("MNO....0000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(secondScore)
                            .addComponent(firstScore)
                            .addComponent(fourthScore)
                            .addComponent(fifthScore)
                            .addComponent(thirdScore)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1)))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(firstScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(thirdScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fourthScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fifthScore, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBack(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack
        // TODO add your handling code here:
        this.dispose();
        StartFrame frame = new StartFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_goBack

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
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HighScores().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(HighScores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public ArrayList getScores(){
        return list;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fifthScore;
    private javax.swing.JLabel firstScore;
    private javax.swing.JLabel fourthScore;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel secondScore;
    private javax.swing.JLabel thirdScore;
    // End of variables declaration//GEN-END:variables
}
