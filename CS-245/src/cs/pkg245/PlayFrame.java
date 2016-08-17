/***************************************************************
* file: StartFrame.java
* author: Vincent Thai && Luis Lopez
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: program 1
* date last modified: 8/10/2016
*
* purpose: Play Frame allows user to play hang man.
*
****************************************************************/ 
package cs.pkg245;

import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.JButton;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import jdk.nashorn.internal.codegen.CompilerConstants;
/**
 *
 * @author Luis
 */
public class PlayFrame  extends javax.swing.JFrame  implements MouseListener{
    
    
    private String[] dictionary = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
    private String word, temp;
    private int points, attempts, gameState, max;
    private final int MAX_LETTERS = 9;
    private boolean controlDecrease, gameOver;
    private Timer t;
    private PlayFrame tempFrame;
    /**
     * Creates new form PlayFrame
     */
    public PlayFrame() {
        tempFrame = this;
        getContentPane().setBackground(Color.white);
        points = 100;
        gameState = 0;
        controlDecrease = true;
        gameOver = false;
       
        ActionListener updateDate = new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){           //UPDATES TIME
                Date d = new Date();                                        //CREATE NEW DATE OBJECT EACH TIME
                String date;                                                //TO GET NEW TIME
                date = d.toString();                                        //STORE IN STRING.. IDK WHY LOL
                jLabel1.setText(date);
                checkWord();
                checkVictory();
                if(gameState > 6 && points < 0)
                    points = 0;
            }
        };
        t = new Timer(1000, updateDate);
        t.start();
        initComponents();
        gameOverLabel.setVisible(false);
        wordLabel.setVisible(false);
        jLabel9.setVisible(false);
        generateWord();
        setPoints();
        
        
    }
    public void checkVictory(){
        String temp = "";
        for(int i = 0 ; i < this.temp.length(); i++){
            if(i == 0)
                temp += jLabel3.getText();
            if(i == 1)
                temp += jLabel4.getText();
            if(i == 2)
                temp += jLabel7.getText();
            if(i == 3)
                temp += jLabel6.getText();
            if(i == 4)
                temp += jLabel5.getText();
            if(i == 5)
                temp += jLabel8.getText();
            if(i == 6)
                temp += jLabel10.getText();
            if(i == 7)
                temp += jLabel11.getText();
            if(i == 8)
                temp += jLabel9.getText();
        }
        if(this.temp.equals(temp))
                victory();
    }
    public void generateNewImage(){
        if(gameState == 0)
            //jLabel2.setIcon(null);
            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs/pkg245/head.png")));
        if(gameState == 1)
            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs/pkg245/head body.png")));
        if(gameState == 2)
            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs/pkg245/onearm.png")));
        if(gameState == 3)
            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs/pkg245/twoarms.png")));
        if(gameState == 4)
            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs/pkg245/oneleg.png")));
        if(gameState == 5){
            gameOver();
            
        }
        gameState++;
    }
    public void checkWord(){
        int counter = 0;
        char c;
        jLabel12.setText("Score: " + points);
        if(!jButton2.isEnabled()){
            counter = 0;
            c = 'a';
            if(!word.contains("a")){
                generateNewImage();
               word += "a";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton3.isEnabled()){
            counter = 0;
            c = 'b';
            if(!word.contains("b")){
                generateNewImage();
               word += "b";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton4.isEnabled()){
            counter = 0;
            c = 'c';
            if(!word.contains("c")){
                generateNewImage();
               word += "c";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton5.isEnabled()){
            counter = 0;
            c = 'd';
            if(!word.contains("d")){
                generateNewImage();
               word += "d";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton6.isEnabled()){
            counter = 0;
            c = 'e';
            if(!word.contains("e")){
                generateNewImage();
               word += "e";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton7.isEnabled()){
            counter = 0;
            c = 'f';
            if(!word.contains("f")){
                generateNewImage();
               word += "f";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton8.isEnabled()){
            counter = 0;
            c = 'g';
            if(!word.contains("g")){
                generateNewImage();
               word += "g";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton9.isEnabled()){
            counter = 0;
            c = 'h';
            if(!word.contains("h")){
                generateNewImage();
               word += "h";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton10.isEnabled()){
            counter = 0;
            c = 'i';
            if(!word.contains("i")){
                generateNewImage();
               word += "i";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton11.isEnabled()){
            counter = 0;
            c = 'j';
            if(!word.contains("j")){
                generateNewImage();
               word += "j";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton12.isEnabled()){
            counter = 0;
            c = 'k';
            if(!word.contains("k")){
                generateNewImage();
               word += "k";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton13.isEnabled()){
            counter = 0;
            c = 'l';
            if(!word.contains("l")){
                generateNewImage();
               word += "l";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton14.isEnabled()){
            counter = 0;
            c = 'm';
            if(!word.contains("m")){
                generateNewImage();
               word += "m";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton21.isEnabled()){
            counter = 0;
            c = 'u';
            if(!word.contains("u")){
                generateNewImage();
               word += "u";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton15.isEnabled()){
            counter = 0;
            c = 'o';
            if(!word.contains("o")){
                generateNewImage();
               word += "o";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton16.isEnabled()){
            counter = 0;
            c = 'p';
            if(!word.contains("p")){
                generateNewImage();
               word += "p";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton17.isEnabled()){
            counter = 0;
            c = 'q';
            if(!word.contains("q")){
                generateNewImage();
               word += "q";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton18.isEnabled()){
            counter = 0;
            c = 'r';
            if(!word.contains("r")){
                generateNewImage();
               word += "r";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton19.isEnabled()){
            counter = 0;
            c = 's';
            if(!word.contains("s")){
                generateNewImage();
               word += "s";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton20.isEnabled()){
            counter = 0;
            c = 't';
            if(!word.contains("t")){
                generateNewImage();
               word += "t";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton22.isEnabled()){
            counter = 0;
            c = 'n';
            if(!word.contains("n")){
                generateNewImage();
               word += "n";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton23.isEnabled()){
            counter = 0;
            c = 'v';
            if(!word.contains("v")){
                generateNewImage();
               word += "v";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton24.isEnabled()){
            counter = 0;
            c = 'w';
            if(!word.contains("w")){
                generateNewImage();
               word += "w";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton25.isEnabled()){
            counter = 0;
            c = 'x';
            if(!word.contains("x")){
                generateNewImage();
               word += "x";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        if(!jButton26.isEnabled()){
            counter = 0;
            c = 'y';
            if(!word.contains("y")){
                generateNewImage();
               word += "y";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
        
        if(!jButton27.isEnabled()){
            counter = 0;
            c = 'z';
            if(!word.contains("z")){
                generateNewImage();
               word += "z";
            }else{
                for(char i : word.toCharArray()){
                    if(i == c)
                        printChar(counter);
                    counter++;
                    
                }
            }    
        }
                    
                
    }
    public void printChar(int index){
       if(index < max)
       switch(index){
           case 0:
               jLabel3.setText(word.charAt(index)+"");
               break;
           case 1:
               jLabel4.setText(word.charAt(index)+"");
               break;
           case 2:
               jLabel7.setText(word.charAt(index)+"");
               break;
           case 3:
               jLabel6.setText(word.charAt(index)+"");
               break;
           case 4:
               jLabel5.setText(word.charAt(index)+"");
               break;
           case 5:
               jLabel8.setText(word.charAt(index)+"");
               break;
           case 6:
               jLabel10.setText(word.charAt(index)+"");
               break;
           case 7:
               jLabel11.setText(word.charAt(index)+"");
               break;
           case 8:
               jLabel9.setText(word.charAt(index)+"");
               break;
           default:
               break;
               
       }
        
    }
    public void generateWord(){
        Random r = new Random();
        int num = r.nextInt(5);
        temp = this.word = dictionary[num];
        max = word.length();
        System.out.println("in generateWord method the number is " + num + " the word is " + word);
        //return dictionary[r.nextInt(5)];
        for (int i = 0 ; i < MAX_LETTERS;i++ )
            if(i > word.length()){
                if(i == 5)
                    jLabel8.setText("");
                if(i==6)
                    jLabel9.setText("");
                if(i==7)
                    jLabel10.setText("");
                if(i==8)
                    jLabel11.setText("");
                if(i==10)
                    jLabel12.setText("");
            }
    }

    public void setPoints() {
        this.points = 100;
    }

    public int getPoints() {
        return points;
    }
    
    public int decreasePoints() {
        return points -= 10;
    }

    public int getAttempts() {
        return attempts;
    }
    
    public void incrementAttempts() {
        attempts++;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        skipButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        gameOverLabel = new javax.swing.JLabel();
        wordLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        skipButton.setText("Skip");
        skipButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                skip(evt);
            }
        });
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        jButton2.setText("A");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickA(evt);
            }
        });

        jButton3.setText("B");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickB(evt);
            }
        });

        jButton4.setText("C");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickC(evt);
            }
        });

        jButton5.setText("D");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickD(evt);
            }
        });

        jButton6.setText("E");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickE(evt);
            }
        });

        jButton7.setText("F");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickF(evt);
            }
        });

        jButton8.setText("G");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickG(evt);
            }
        });

        jButton9.setText("H");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickH(evt);
            }
        });

        jButton10.setText("I");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickI(evt);
            }
        });

        jButton11.setText("J");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickJ(evt);
            }
        });

        jButton12.setText("K");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickK(evt);
            }
        });

        jButton13.setText("L");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickL(evt);
            }
        });

        jButton14.setText("M");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickM(evt);
            }
        });

        jButton15.setText("O");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickO(evt);
            }
        });

        jButton16.setText("P");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickP(evt);
            }
        });

        jButton17.setText("Q");
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickQ(evt);
            }
        });

        jButton18.setText("R");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickR(evt);
            }
        });

        jButton19.setText("S");
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickS(evt);
            }
        });

        jButton20.setText("T");
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickT(evt);
            }
        });

        jButton21.setText("U");
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickU(evt);
            }
        });

        jButton22.setText("N");
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickN(evt);
            }
        });

        jButton23.setText("V");
        jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickV(evt);
            }
        });

        jButton24.setText("W");
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickW(evt);
            }
        });

        jButton25.setText("X");
        jButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickX(evt);
            }
        });

        jButton26.setText("Y");
        jButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickY(evt);
            }
        });

        jButton27.setText("Z");
        jButton27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickZ(evt);
            }
        });

        jLabel1.setText("Date / Time");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs/pkg245/poll.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setText("_");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setText("_");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel5.setText("_");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setText("_");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel7.setText("_");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel8.setText("_");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel9.setText("_");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel10.setText("_");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel11.setText("_");

        jLabel12.setText("Score: 100");

        gameOverLabel.setText("GAME OVER!");

        wordLabel.setText("Word: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton13))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton21)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton23)
                            .addComponent(jButton14))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jButton24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton27))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton18)))
                        .addContainerGap(184, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4)
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton8))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(wordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(gameOverLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton10)
                                    .addComponent(jLabel12))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(skipButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel12))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(gameOverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wordLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(skipButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(132, 132, 132))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4)
                                    .addComponent(jButton5)
                                    .addComponent(jButton6)
                                    .addComponent(jButton7)
                                    .addComponent(jButton8)
                                    .addComponent(jButton9)
                                    .addComponent(jButton10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton18)
                                    .addComponent(jButton17)
                                    .addComponent(jButton16)
                                    .addComponent(jButton15)
                                    .addComponent(jButton22)
                                    .addComponent(jButton14)
                                    .addComponent(jButton13)
                                    .addComponent(jButton12)
                                    .addComponent(jButton11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton19)
                                    .addComponent(jButton20)
                                    .addComponent(jButton21)
                                    .addComponent(jButton23)
                                    .addComponent(jButton24)
                                    .addComponent(jButton25)
                                    .addComponent(jButton26)
                                    .addComponent(jButton27))
                                .addGap(19, 19, 19))))))
        );

        jLabel1.getAccessibleContext().setAccessibleName("realTime");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void skip(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skip
        
    }//GEN-LAST:event_skip

    private void clickA(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickA
        // TODO add your handling code here:
        //System.out.println("in click a " + word);
        if(word.contains("a")) {
            System.out.println("cs.pkg245.PlayFrame.clickA() | letter in here");
            //the word has a letter a in it
            //no change to user's score
            // the uncoverA method is used to uncover the letter from the screen
            //uncoverA;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickA() | letter not here");
            decreasePoints();
            //the letter "a" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            
        }
        //disable the button since it was clicked
        jButton2.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickA
private void gameOver(){
    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs/pkg245/twoLegs.png")));
    gameOverLabel.setVisible(true);
    wordLabel.setText(wordLabel.getText() + temp);
    wordLabel.setVisible(true);
    terminate();
}
private void victory(){
    gameOverLabel.setText("VICTORY!");
    gameOverLabel.setVisible(true);
    terminate();
    temp += "s";
}
private void terminate(){
    ActionListener  nextScreen = new ActionListener(){
            boolean hasDisposed = false;
            public void actionPerformed(ActionEvent actionEvent){           
                if(!hasDisposed){
                    //f.dispose();
                    BGame endFrame = new BGame(points);
                    endFrame.setLocationRelativeTo(null);
                    endFrame.setBackground(Color.white);
                    endFrame.setVisible(true);
                    hasDisposed = true;
                    PlayFrame f = tempFrame;
                    f.dispose();
                }
            }
        };
        Timer t = new Timer(1000, nextScreen);
        t.setInitialDelay(1500);
        t.start();
}
    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        // TODO add your handling code here:
        //go to end frame...we still need to display scores and etc
        points = 0;
        gameOverLabel.setVisible(true);
        wordLabel.setText(wordLabel.getText() + temp);
        wordLabel.setVisible(true);
        terminate();
    }//GEN-LAST:event_skipButtonActionPerformed

    private void clickB(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickB
        // TODO add your handling code here:
        //System.out.println("in click b " + word);
        if(word.contains("b")) {
            System.out.println("cs.pkg245.PlayFrame.clickB() | letter in here");
            //the word has b letter a in it
            //no change to user's score
            // the uncoverB method is used to uncover the letter from the screen
            //uncoverB;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickB() | letter not in here" );
            //the letter "b" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
            
        }
        //disable the button since it was clicked
        jButton3.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickB

    private void clickC(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickC
        // TODO add your handling code here:
        //System.out.println("in click c " + word);
        if(word.contains("c")) {
            System.out.println("cs.pkg245.PlayFrame.clickC() | letter in here");
            //the word has c letter a in it
            //no change to user's score
            // the uncoverC method is used to uncover the letter from the screen
            //uncoverC;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickC() | letter not in here" );
            //the letter "c" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton4.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickC

    private void clickD(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickD
        // TODO add your handling code here:
                //System.out.println("in click d " + word);
        if(word.contains("d")) {
            System.out.println("cs.pkg245.PlayFrame.clickD() | letter in here");
            //the word has d letter a in it
            //no change to user's score
            // the uncoverD method is used to uncover the letter from the screen
            //uncoverD;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickD() | letter not in here" );
            //the letter "d" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton5.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickD

    private void clickE(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickE
        // TODO add your handling code here:
        //System.out.println("in click e " + word);
        if(word.contains("e")) {
            System.out.println("cs.pkg245.PlayFrame.clickE() | letter in here");
            //the word has e letter a in it
            //no change to user's score
            // the uncoverE method is used to uncover the letter from the screen
            //uncoverE;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickE() | letter not in here" );
            //the letter "e" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton6.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickE

    private void clickF(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickF
        // TODO add your handling code here:
                //System.out.println("in click F " + word);
        if(word.contains("f")) {
            System.out.println("cs.pkg245.PlayFrame.clickF() | letter in here");
            //the word has f letter a in it
            //no change to user's score
            // the uncoverF method is used to uncover the letter from the screen
            //uncoverF;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickF() | letter not in here" );
            //the letter "f" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton7.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickF

    private void clickG(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickG
        // TODO add your handling code here:
                //System.out.println("in click G " + word);
        if(word.contains("g")) {
            System.out.println("cs.pkg245.PlayFrame.clickG() | letter in here");
            //the word has g letter a in it
            //no change to user's score
            // the uncoverG method is used to uncover the letter from the screen
            //uncoverG;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickG() | letter not in here" );
            //the letter "g" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton8.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickG

    private void clickH(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickH
        // TODO add your handling code here:
                //System.out.println("in click h " + word);
        if(word.contains("h")) {
            System.out.println("cs.pkg245.PlayFrame.clickH() | letter in here");
            //the word has h letter a in it
            //no change to user's score
            // the uncoverH method is used to uncover the letter from the screen
            //uncoverH;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickH() | letter not in here" );
            //the letter "h" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton9.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickH

    private void clickI(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickI
        // TODO add your handling code here:
                //System.out.println("in click I " + word);
        if(word.contains("i")) {
            System.out.println("cs.pkg245.PlayFrame.clickI() | letter in here");
            //the word has i letter a in it
            //no change to user's score
            // the uncoverI method is used to uncover the letter from the screen
            //uncoverI;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickI() | letter not in here" );
            //the letter "i" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton10.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickI

    private void clickJ(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickJ
        // TODO add your handling code here:
                        //System.out.println("in click J " + word);
        if(word.contains("J")) {
            System.out.println("cs.pkg245.PlayFrame.clickJ() | letter in here");
            //the word has j letter a in it
            //no change to user's score
            // the uncoverJ method is used to uncover the letter from the screen
            //uncoverJ;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickJ() | letter not in here" );
            //the letter "j" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton11.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickJ

    private void clickK(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickK
        // TODO add your handling code here:
                        //System.out.println("in click K " + word);
        if(word.contains("k")) {
            System.out.println("cs.pkg245.PlayFrame.clickK() | letter in here");
            //the word has k letter a in it
            //no change to user's score
            // the uncoverI method is used to uncover the letter from the screen
            //uncoverK;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickK() | letter not in here" );
            //the letter "k" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton12.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickK

    private void clickL(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickL
        // TODO add your handling code here:
                        //System.out.println("in click L " + word);
        if(word.contains("l")) {
            System.out.println("cs.pkg245.PlayFrame.clickL() | letter in here");
            //the word has l letter a in it
            //no change to user's score
            // the uncoverL method is used to uncover the letter from the screen
            //uncoverL;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickI() | letter not in here" );
            //the letter "l" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton13.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickL

    private void clickM(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickM
        // TODO add your handling code here:
                        //System.out.println("in click M " + word);
        if(word.contains("m")) {
            System.out.println("cs.pkg245.PlayFrame.clickM() | letter in here");
            //the word has m letter a in it
            //no change to user's score
            // the uncoverM method is used to uncover the letter from the screen
            //uncoverM;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickM() | letter not in here" );
            //the letter "m" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton14.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickM

    private void clickN(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickN
        // TODO add your handling code here:
                        //System.out.println("in click I " + word);
        if(word.contains("n")) {
            System.out.println("cs.pkg245.PlayFrame.clickN() | letter in here");
            //the word has n letter a in it
            //no change to user's score
            // the uncoverN method is used to uncover the letter from the screen
            //uncoverN;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickN() | letter not in here" );
            //the letter "n" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton22.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickN

    private void clickO(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickO
        // TODO add your handling code here:
                        //System.out.println("in click O " + word);
        if(word.contains("o")) {
            System.out.println("cs.pkg245.PlayFrame.clickO() | letter in here");
            //the word has o letter a in it
            //no change to user's score
            // the uncoverO method is used to uncover the letter from the screen
            //uncoverO;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickO() | letter not in here" );
            //the letter "o" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton15.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickO

    private void clickP(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickP
        // TODO add your handling code here:
                        //System.out.println("in click P " + word);
        if(word.contains("p")) {
            System.out.println("cs.pkg245.PlayFrame.clickP() | letter in here");
            //the word has p letter a in it
            //no change to user's score
            // the uncoverP method is used to uncover the letter from the screen
            //uncoverP;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickP() | letter not in here" );
            //the letter "p" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton16.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickP

    private void clickQ(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickQ
        // TODO add your handling code here:
                                //System.out.println("in click Q " + word);
        if(word.contains("q")) {
            System.out.println("cs.pkg245.PlayFrame.clickQ() | letter in here");
            //the word has q letter a in it
            //no change to user's score
            // the uncoverQ method is used to uncover the letter from the screen
            //uncoverQ;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickQ() | letter not in here" );
            //the letter "q" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton17.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickQ

    private void clickR(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickR
        // TODO add your handling code here:
                                //System.out.println("in click R " + word);
        if(word.contains("r")) {
            System.out.println("cs.pkg245.PlayFrame.clickR() | letter in here");
            //the word has r letter a in it
            //no change to user's score
            // the uncoverR method is used to uncover the letter from the screen
            //uncoverR;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickR() | letter not in here" );
            //the letter "r" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton18.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickR

    private void clickS(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickS
        // TODO add your handling code here:
                                //System.out.println("in click S " + word);
        if(word.contains("s")) {
            System.out.println("cs.pkg245.PlayFrame.clickS() | letter in here");
            //the word has s letter a in it
            //no change to user's score
            // the uncoverS method is used to uncover the letter from the screen
            //uncoverS;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickS() | letter not in here" );
            //the letter "s" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton19.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickS

    private void clickT(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickT
        // TODO add your handling code here:
                                //System.out.println("in click T " + word);
        if(word.contains("t")) {
            System.out.println("cs.pkg245.PlayFrame.clickT() | letter in here");
            //the word has t letter a in it
            //no change to user's score
            // the uncoverT method is used to uncover the letter from the screen
            //uncoverT;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickT() | letter not in here" );
            //the letter "t" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton20.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickT

    private void clickU(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickU
        // TODO add your handling code here:
                                //System.out.println("in click U " + word);
        if(word.contains("u")) {
            System.out.println("cs.pkg245.PlayFrame.clickU() | letter in here");
            //the word has u letter a in it
            //no change to user's score
            // the uncoverU method is used to uncover the letter from the screen
            //uncoverU;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickU() | letter not in here" );
            //the letter "u" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton21.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickU

    private void clickV(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickV
        // TODO add your handling code here:
                                //System.out.println("in click V " + word);
        if(word.contains("v")) {
            System.out.println("cs.pkg245.PlayFrame.clickV() | letter in here");
            //the word has v letter a in it
            //no change to user's score
            // the uncoverV method is used to uncover the letter from the screen
            //uncoverV;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickV() | letter not in here" );
            //the letter "v" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton23.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickV

    private void clickW(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickW
        // TODO add your handling code here:
                                //System.out.println("in click W " + word);
        if(word.contains("w")) {
            System.out.println("cs.pkg245.PlayFrame.clickW() | letter in here");
            //the word has w letter a in it
            //no change to user's score
            // the uncoverW method is used to uncover the letter from the screen
            //uncoverW;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickW() | letter not in here" );
            //the letter "w" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton24.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickW

    private void clickX(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickX
        // TODO add your handling code here:
                                //System.out.println("in click X " + word);
        if(word.contains("x")) {
            System.out.println("cs.pkg245.PlayFrame.clickX() | letter in here");
            //the word has x letter a in it
            //no change to user's score
            // the uncoverX method is used to uncover the letter from the screen
            //uncoverX;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickX() | letter not in here" );
            //the letter "x" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton25.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickX

    private void clickY(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickY
        // TODO add your handling code here:
                                //System.out.println("in click Y " + word);
        if(word.contains("y")) {
            System.out.println("cs.pkg245.PlayFrame.clickY() | letter in here");
            //the word has y letter a in it
            //no change to user's score
            // the uncoverY method is used to uncover the letter from the screen
            //uncoverY;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickY() | letter not in here" );
            //the letter "y" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton26.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickY

    private void clickZ(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickZ
        // TODO add your handling code here:
                                //System.out.println("in click Z " + word);
        if(word.contains("z")) {
            System.out.println("cs.pkg245.PlayFrame.clickZ() | letter in here");
            //the word has z letter a in it
            //no change to user's score
            // the uncoverZ method is used to uncover the letter from the screen
            //uncoverZ;
            
        } else {
            System.out.println("cs.pkg245.PlayFrame.clickZ() | letter not in here" );
            //the letter "z" is not found within the word
            //we need to add a body part to the picture
            //decrease the user's points
            decreasePoints();
        }
        //disable the button since it was clicked
        jButton27.setEnabled(false);
        incrementAttempts();
    }//GEN-LAST:event_clickZ

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayFrame().setVisible(true);
            }
        });
        
        
               
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel gameOverLabel;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton skipButton;
    private javax.swing.JLabel wordLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        checkWord();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        checkWord();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        checkWord();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
