/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package datemarqueebounce;

import java.awt.BorderLayout;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author salma
 */
public class DateMarqueeBounce extends JFrame implements Runnable {
//show date

    Thread showDate;
    Date d = new Date();
    JLabel timeLabel = new JLabel();
    JPanel panel = new JPanel();

//show MarqueString
    JLabel javaWorld = new JLabel();
    Thread showMarquee;
    int x = -100;
    int y = 130;
    int width = 100;
    int height = 100;
    
//show BouncingBall
    Thread showBall;
    static JLabel ball = new JLabel();
    boolean endX =false;
    boolean endY=false;
    int xBall = 0;
    int yBall=0;
    int widthBall=57;
    int heightBall=57;

    public DateMarqueeBounce() {
        //show date
        this.setLayout(new BorderLayout());
        this.setTitle("Multi Application");
        this.add(panel, BorderLayout.CENTER);
        //timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setText(d.toString());
        timeLabel.setBounds(200,50,200,200);
        panel.setLayout(null);
        panel.add(timeLabel);
        showDate = new Thread(this);
        showDate.start();

        //show Marquee
        String str = "Java World";
        javaWorld.setText(str);
        javaWorld.setBounds(x, y, width, height);
        panel.add(javaWorld);
        showMarquee = new Thread(this);
        showMarquee.start();
        
        //show bouncingBall
        ImageIcon img = new ImageIcon("/football2.gif");
        ball.setIcon(img);
        panel.add(ball);
        ball.setBounds(xBall,yBall,widthBall,heightBall);
        showBall = new Thread(this);
        showBall.start();
        
     
    }

    public static void main(String[] args) {
        DateMarqueeBounce app = new DateMarqueeBounce();
        app.setBounds(50, 50, 600, 400);
        app.setVisible(true);
    }

    @Override
    public void run() {
        if (Thread.currentThread() == showDate) {
            while (true) {
                d = new Date();
                timeLabel.setText(d.toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("handle interruptedException here");
                }

            }
        }
        if (Thread.currentThread() == showMarquee) {
            while (true) {

                x++;
                javaWorld.setBounds(x, y, width, height);
                if (x >= this.getWidth()) {
                    x = -100;
                }
                try {
                    Thread.sleep(10);

                } catch (InterruptedException ex) {
                    System.out.println("handle interruptedException here");
                }

            }
        }
        
        if (Thread.currentThread() == showBall) {
        while(true){
            
            if(endX==false)
            {
                xBall++;
                if(xBall>=(panel.getWidth()-ball.getWidth()))
                    endX=true;
            }
            
            else if (endX==true)
            {
                xBall--;
                if(xBall<=0)
                    endX=false;
            }    
            if(endY==false)
            {
                yBall++;
                if(yBall>=panel.getHeight()-ball.getHeight())
                    endY=true;
            }
            
            else if (endY==true)
            {
                yBall--;
                if(yBall<=0)
                    endY=false;
            }
            ball.setBounds(xBall,yBall,widthBall,heightBall); 
            
                
            try {
                Thread.sleep(10);
               
            } catch (InterruptedException ex) {
                System.out.println("handle interruptedException here");
            }
        }
        }

    }}
