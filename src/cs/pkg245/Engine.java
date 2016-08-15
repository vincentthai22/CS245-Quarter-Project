/***************************************************************
* file: StartFrame.java
* author: Vincent Thai && Luis Lopez
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: program 1
* date last modified: 8/10/2016
*
* purpose: Starter of the program. Initializes starting screen for Hang man.
*
****************************************************************/
package cs.pkg245;

import java.awt.Color;

/**
 *
 * @author Luis
 */
public class Engine {
    public static void main(String[] args) throws InterruptedException{
        TitleFrame title =  new TitleFrame();
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        title.setVisible(true);
        title.setLocationRelativeTo(null);
        title.setTitle("Hangman, The Game");
        title.setBackground(Color.yellow);
        Thread.sleep(3000);
        title.dispose();
        
        StartFrame start = new StartFrame();
        start.setTitle("Hangman, The Game");
        start.setVisible(true);
        start.setLocationRelativeTo(null);
        
    }
}
