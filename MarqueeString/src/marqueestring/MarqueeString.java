/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marqueestring;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author salma
 */
public class MarqueeString extends JFrame implements Runnable {

    JLabel javaWorld = new JLabel();
    Thread th;
    int x = -100;
    int y=130;
    int width=100;
    int height=100;
    public MarqueeString() {
        this.setLayout(null);
        this.setTitle("Java World");
        String str="Java World";
        javaWorld.setText(str);
        javaWorld.setBounds(x,y,width,height);
        this.add(javaWorld);
        th = new Thread(this);
        th.start();
    }

    public static void main(String[] args) {
        MarqueeString app = new MarqueeString();
        app.setBounds(50, 50, 600, 400);
        app.setVisible(true);
    }

    @Override
    public void run() {
        while(true){
            
            x++;
            javaWorld.setBounds(x,y,width,height); 
            if(x>=this.getWidth())
                    x=-100;
            try {
                Thread.sleep(10);
               
            } catch (InterruptedException ex) {
                System.out.println("handle interruptedException here");
            }
        }
        
    }

}
