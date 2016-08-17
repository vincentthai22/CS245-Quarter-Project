/*
 * Vincent Thai 
 * 
 * 
 */
package cs.pkg245;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Vincent
 */
public class BGame extends javax.swing.JFrame{
    
    private String words[] = { "RED", "YELLOW", "GREEN", "BLUE", "PURPLE" };
    private Color colors[] = { Color.red, Color.yellow, Color.green, Color.blue, Color.magenta };
    JLabel[] arrCircles;
    BubbleGen bubble;
    JLabel jb;
    Color color;
    String word;
    MyMouseListener m;// = new MyMouseListener();
    Random r = new Random();
    private final int WIDTH = 500, HEIGHT = 300, MAX_ROUNDS = 5;
    private int counter, points;
    BGame b = this;
    /**
     * Creates new form BGame
     */
    public BGame(int points){
        this.points = points;
        initComponents();
        gameOverLabel.setVisible(false);
        pointsLabel.setText(pointsLabel.getText() + points + "");
        arrCircles = new JLabel[5];
        this.setLocationRelativeTo(null);
        counter = 0;
        m = new MyMouseListener();
        setTimer();
        createCircles();
    }
    public BGame() {
        initComponents();
        gameOverLabel.setVisible(false);
        arrCircles = new JLabel[5];
        this.setLocationRelativeTo(null);
        counter = 0;
        m = new MyMouseListener();
        setTimer();
        createCircles();
        
    }
    public void setTimer(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                dateLabel.setText(d.toString());   
            }
        };
        Timer t = new Timer(1000, al);
        t.start();
    }
    
    public void createCircles(){
        word = words[r.nextInt(5)];
        color = colors[r.nextInt(5)];
        colorLabel.setForeground(color);
        colorLabel.setText(word);
        for(int i = 0 ; i < arrCircles.length; i++){
            bubble = new BubbleGen(WIDTH, HEIGHT, colors[i]);
            System.out.println("Max : " + i);
            while(checkBounds(bubble,i) != true){
                bubble = new BubbleGen(WIDTH,HEIGHT,colors[i]);
            }
            
            jb = new JLabel();
            System.out.println(bubble.getX());
            jb.setBounds(bubble.getX(), bubble.getY(), bubble.getIconWidth(), bubble.getIconHeight());
            jb.setIcon(bubble);
            arrCircles[i] = jb;
            System.out.println(i + " :" + arrCircles[i].getBounds().toString());
            this.add(arrCircles[i]);
            arrCircles[i].addMouseListener(m);
           
        }
//        if(counter > 0)
//            relocate();
    }
    public void relocate(){
        if(counter >= 5)
            gameOver();
        word = words[r.nextInt(5)];
        color = colors[r.nextInt(5)];
        colorLabel.setForeground(color);
        colorLabel.setText(word);
        for(int i = 0 ; i < arrCircles.length;i++){
            bubble = new BubbleGen(WIDTH, HEIGHT, colors[i]);
            System.out.println("Max : " + i);
            while(checkBounds(bubble,i) != true){
                bubble = new BubbleGen(WIDTH,HEIGHT,colors[i]);
            }
            arrCircles[i].setBounds(bubble.getX(), bubble.getY(), bubble.getIconWidth(), bubble.getIconHeight());
            
        }
        for(int i = 0; i < arrCircles.length; i++){
            arrCircles[i].setLocation(arrCircles[i].getX(), arrCircles[i].getY());
        }
    }
    public void gameOver(){
        BGame f = this;
        gameOverLabel.setVisible(true);
        ActionListener  nextScreen = new ActionListener(){
            boolean hasDisposed = false;
            public void actionPerformed(ActionEvent actionEvent){           
                if(!hasDisposed){
                    EndFrame endFrame = null;
                    try {
                        endFrame = new EndFrame(points);
                    } catch (IOException ex) {
                        Logger.getLogger(BGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    endFrame.setLocationRelativeTo(null);
                    endFrame.setBackground(Color.white);
                    endFrame.setVisible(true);
                    hasDisposed = true;
                    f.dispose();
                }
            }
        };
        Timer t = new Timer(1000, nextScreen);
        t.setInitialDelay(1500);
        t.start();
    }
    public boolean checkBounds(BubbleGen b,int max){
        //boolean isValid = true;
        System.out.println("Test bubble:" + b.getBound().toString());
        for(int i = 0; i < max; i++){
            if(b.getX() >= arrCircles[i].getX() && b.getX()<= arrCircles[i].getX() + 100){
                if(b.getY() >= arrCircles[i].getY() && b.getY()<=arrCircles[i].getY() + 100)
                    return false;
                if(b.getY() <= arrCircles[i].getY() && b.getY() >= arrCircles[i].getY() - 100)
                    return false;
            }
            if(b.getY() > arrCircles[i].getY() && b.getY()<arrCircles[i].getY() + 100)
                if(b.getX() > arrCircles[i].getX() && b.getX()<arrCircles[i].getX() + 100)
                    return false;
            if(arrCircles[i].getX() > b.getX() && arrCircles[i].getX() < b.getX() + 100)
                if(arrCircles[i].getY() > b.getY() && arrCircles[i].getY() < b.getY() + 100)
                    return false;
            if(arrCircles[i].getY() > b.getY() && arrCircles[i].getY() < b.getY() + 100)
                if(arrCircles[i].getX() > b.getX() && arrCircles[i].getX() < b.getX() + 100)
                    return false;
            if(b.getY() < arrCircles[i].getY() && b.getY() > arrCircles[i].getY() - 100)
                    if(b.getX() < arrCircles[i].getX() && b.getX() > arrCircles[i].getX() - 100)
                        return false;
            if(b.getX() <= arrCircles[i].getX() && b.getX() >= arrCircles[i].getX() - 100){
                if(b.getY() <= arrCircles[i].getY() && b.getY() >= arrCircles[i].getY() - 100)
                    return false;
                if(b.getY() >= arrCircles[i].getY() && b.getY() <= arrCircles[i].getY() + 100)
                    return false;
            }
            if(b.getBound().intersects(colorLabel.getBounds()))
                return false;
        }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        matteBorder1 = new javax.swing.border.MatteBorder(null);
        softBevelBorder1 = new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED);
        compoundBorder1 = javax.swing.BorderFactory.createCompoundBorder();
        colorLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        pointsLabel = new javax.swing.JLabel();
        gameOverLabel = new javax.swing.JLabel();
        roundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        colorLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        colorLabel.setText("colorLabel");

        dateLabel.setText(" ");

        pointsLabel.setText("POINTS: ");

        gameOverLabel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        gameOverLabel.setText("GAME OVER!");

        roundLabel.setText("Round: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pointsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateLabel)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(colorLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(gameOverLabel)))
                .addContainerGap(205, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roundLabel)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(pointsLabel))
                .addGap(36, 36, 36)
                .addComponent(colorLabel)
                .addGap(65, 65, 65)
                .addComponent(gameOverLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(roundLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(BGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel colorLabel;
    private javax.swing.border.CompoundBorder compoundBorder1;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel gameOverLabel;
    private javax.swing.border.MatteBorder matteBorder1;
    private javax.swing.JLabel pointsLabel;
    private javax.swing.JLabel roundLabel;
    private javax.swing.border.SoftBevelBorder softBevelBorder1;
    // End of variables declaration//GEN-END:variables

    class MyMouseListener extends MouseAdapter{
       /* JLabel[] labels;
        Color color;
        MyMouseListener(JLabel[] labels, Color color){
            this.labels = labels;
            this.color = color;
            
        }*/
        public void mouseClicked(MouseEvent e){
            JLabel l = (JLabel)e.getSource();
            BubbleGen g = (BubbleGen)l.getIcon();
            if(g.getColor().equals(color)){
                points += 100;
                pointsLabel.setText("Points: " + points + "");
                roundLabel.setText("Round: " + ++counter + "");
                System.out.println("You Win!");
               // createCircles();
               relocate();
                
            }else{
                pointsLabel.setText("Points: " + points + "");
                roundLabel.setText("Round: " + ++counter + "");
                relocate();
            }
          
        }
        public void mouseEntered(MouseEvent e){
            JLabel l = (JLabel)e.getSource();
            for(JLabel labels : arrCircles){
                if(l.equals(labels))
                    System.out.println("yes");
            }
        }
    }
}
