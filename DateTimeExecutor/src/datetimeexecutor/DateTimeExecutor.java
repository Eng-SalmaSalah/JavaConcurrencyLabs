/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetimeexecutor;

import java.awt.BorderLayout;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author salma
 */
public class DateTimeExecutor extends JFrame {

    Date d = new Date();
    JLabel timeLabel = new JLabel();

    public DateTimeExecutor() {
        this.setTitle("Date & Time Frame Application");
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setText(d.toString());
        this.add(timeLabel, BorderLayout.CENTER);
        ScheduledExecutorService scheduledExecutorService
                = Executors.newScheduledThreadPool(1);
        
        Runnable task = () -> {
            d = new Date();
            timeLabel.setText(d.toString());
        };
        scheduledExecutorService.scheduleAtFixedRate(task, 0, 1,
                TimeUnit.SECONDS);
        

    }

    public static void main(String[] args) {
        DateTimeExecutor app = new DateTimeExecutor();
        app.setBounds(50, 50, 600, 400);
        app.setVisible(true);

    }
}
