/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetimeapp;

import java.awt.BorderLayout;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author salma
 */
public class DateTimeApp extends JFrame implements Runnable {

    Thread th;
    Date d = new Date();
    JLabel timeLabel = new JLabel();

    public DateTimeApp() {
        this.setTitle("Date & Time Frame Application");
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setText(d.toString());
        this.add(timeLabel, BorderLayout.CENTER);
        th = new Thread(this);
        th.start();
    }

    public static void main(String[] args) {
        DateTimeApp app = new DateTimeApp();
        app.setBounds(50, 50, 600, 400);
        app.setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            d = new Date();
            timeLabel.setText(d.toString());
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException ex) {
                System.out.println("handle interruptedException here");
            }

        }
    }
}
