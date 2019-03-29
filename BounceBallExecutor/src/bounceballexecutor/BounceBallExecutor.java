/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceballexecutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author salma
 */
public class BounceBallExecutor extends JFrame {

    static JLabel ball = new JLabel();
    JPanel panel = new JPanel(null);
    JButton pause = new JButton("pause");
    JButton resume = new JButton("resume");

    int x = 0;
    int y = 0;
    int width = 57;
    int height = 57;
    boolean endX = false;
    boolean endY = false;
    volatile boolean checkStatus = true;

    public BounceBallExecutor() {

        this.setLayout(new BorderLayout());
        panel.setBackground(Color.white);
        this.setTitle("Bouncing Ball");
        ImageIcon img = new ImageIcon("C:\\Users\\salma\\Documents\\NetBeansProjects\\BouncingBall\\src\\bouncingball\\football2.gif");
        ball.setIcon(img);
        panel.setLayout(null);
        panel.add(ball);
        ball.setBounds(x, y, width, height);
        panel.add(pause);
        pause.setBounds(100, 20, 80, 40);
        resume.setBounds(400, 20, 80, 40);
        panel.add(resume);
        this.add(panel, BorderLayout.CENTER);

        pause.addActionListener((e) -> {
            checkStatus = false;
        });
        resume.addActionListener((e) -> {
            checkStatus = true;
        });
        ScheduledExecutorService scheduledExecutorService
                = Executors.newScheduledThreadPool(1);
        
        Runnable task = () -> {
            if (checkStatus == true) {
                if (endX == false) {
                    x++;
                    if (x >= (panel.getWidth() - ball.getWidth())) {
                        endX = true;
                    }
                } else if (endX == true) {
                    x--;
                    if (x <= 0) {
                        endX = false;
                    }
                }
                if (endY == false) {
                    y++;
                    if (y >= panel.getHeight() - ball.getHeight()) {
                        endY = true;
                    }
                } else if (endY == true) {
                    y--;
                    if (y <= 0) {
                        endY = false;
                    }
                }
                ball.setBounds(x, y, width, height);

            }
        };
            scheduledExecutorService.scheduleAtFixedRate(task, 0, 10,
                    TimeUnit.MILLISECONDS);

        
    }

    public static void main(String[] args) {
        BounceBallExecutor app = new BounceBallExecutor();

        app.setBounds(50, 50, 600, 400);
        app.setVisible(true);
    }}
