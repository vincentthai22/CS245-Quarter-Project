/*
 * Vincent Thai 
 * 
 * 
 */
package cs.pkg245;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import java.util.Random;
/**
 *
 * @author Vincent
 */
public class BubbleGen implements Icon{
    private int xPos, yPos;
    private final int WIDTH = 100, HEIGHT = 100;
    private Color color;
    private Color colors[] = { Color.red, Color.yellow, Color.green, Color.blue, Color.magenta };
    private Graphics2D g2;
    Ellipse2D.Double circle;
    private Rectangle bounds;
    
    public BubbleGen(int width, int height, Color color){
        Random r = new Random();
        xPos = r.nextInt(width);
        yPos = r.nextInt(height);
        this.color = color;
        bounds = new Rectangle(xPos,yPos,WIDTH, HEIGHT);
        
    }
    public Rectangle getBound(){
        return bounds;
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g2 = (Graphics2D)g;
        circle = new Ellipse2D.Double(0, 0, WIDTH, HEIGHT);
        g2.setColor(color);
        g2.fill(circle);
    }
    public int getX(){
        return xPos;
    }
    public void setColor(Color newColor){
        g2.setColor(newColor);
        g2.fill(circle);
    }
    public Graphics getGraphics(){
        return g2;
    }
    public Shape getCircle(){
        return circle;
    }
    public int getY(){
        return yPos;
    }
    public Color getColor(){
        return color;
    }
    @Override
    public int getIconWidth() {
        return WIDTH;
    }

    @Override
    public int getIconHeight() {
        return HEIGHT;
    }
    
}
