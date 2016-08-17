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
import java.util.Date;
import java.util.Random;
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
public class BGame extends javax.swing.JFrame implements MouseListener{
    
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
    private int counter;
    BGame b = this;
    /**
     * Creates new form BGame
     */
    public BGame() {
        initComponents();
        arrCircles = new JLabel[5];
        this.setLocationRelativeTo(null);
        counter = 0;
        m = new MyMouseListener();
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                dateLabel.setText(d.toString());   
            }
        };
        Timer t = new Timer(1000, al);
        t.start();
        
       // jb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs/pkg245/redCircle.png")));
        //jb.setIcon();
        /*new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                System.out.println("hello");
                bubble.setColor(Color.yellow);
                jb.setIcon(bubble);
                jb.setBorder(BorderFactory.createLineBorder(Color.yellow));
            }
            public void mouseClicked(MouseEvent e){
                System.out.println("hllo");
                JLabel jb = new JLabel();
                jb.setBounds(bubble.getX(), bubble.getY(), bubble.getIconWidth()+25, bubble.getIconHeight()+25);
                new JFrame("frame");
                jb.setIcon(bubble);
            }
        }*/
        //jb.setBorder(compoundBorder1);
        createCircles();
        
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
    public boolean checkBounds(BubbleGen b,int max){
        //boolean isValid = true;
        System.out.println("Test bubble:" + b.getBound().toString());
        for(int i = 0; i < max; i++){
            if(b.getX() > arrCircles[i].getX() && b.getX()<arrCircles[i].getX() + 100){
                if(b.getY() > arrCircles[i].getY() && b.getY()<arrCircles[i].getY() + 100)
                    return false;
                if(b.getY() < arrCircles[i].getY() && b.getY() > arrCircles[i].getY() - 100)
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
            if(b.getX() < arrCircles[i].getX() && b.getX() > arrCircles[i].getX() - 100){
                if(b.getY() < arrCircles[i].getY() && b.getY() > arrCircles[i].getY() - 100)
                    return false;
                if(b.getY() > arrCircles[i].getY() && b.getY() < arrCircles[i].getY() + 100)
                    return false;
            }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        colorLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        colorLabel.setText("colorLabel");

        dateLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateLabel)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(colorLabel)
                .addContainerGap(267, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateLabel)
                .addGap(36, 36, 36)
                .addComponent(colorLabel)
                .addContainerGap(310, Short.MAX_VALUE))
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
    private javax.swing.border.MatteBorder matteBorder1;
    private javax.swing.border.SoftBevelBorder softBevelBorder1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel l =(JLabel) e.getSource();
        if(l.getName().equals(jb.getName()))
            System.out.println("in");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
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
                counter++;
                System.out.println("You Win!");
               // createCircles();
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
