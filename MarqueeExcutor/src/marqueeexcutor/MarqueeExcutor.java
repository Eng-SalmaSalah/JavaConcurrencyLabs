/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marqueeexcutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author salma
 */
public class MarqueeExcutor extends JFrame {

    JLabel javaWorld = new JLabel();
    int x = -100;
    int y = 130;
    int width = 100;
    int height = 100;

    public MarqueeExcutor() {
        this.setLayout(null);
        this.setTitle("Java World");
        String str = "Java World";
        javaWorld.setText(str);
        javaWorld.setBounds(x, y, width, height);
        this.add(javaWorld);
        ScheduledExecutorService scheduledExecutorService
                = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            x++;
            javaWorld.setBounds(x, y,width,height);
            if (x >= getWidth()) {
                x = -100;
            }
        };

        scheduledExecutorService.scheduleAtFixedRate(task, 0, 10,
                TimeUnit.MILLISECONDS);

    }

    public static void main(String[] args) {
        MarqueeExcutor app = new MarqueeExcutor();
        app.setBounds(50, 50, 600, 400);
        app.setVisible(true);
    }

}
