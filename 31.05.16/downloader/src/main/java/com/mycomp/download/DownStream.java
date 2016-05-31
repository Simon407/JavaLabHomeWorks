package com.mycomp.download;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Date;

public class DownStream extends JFrame implements Runnable {
    private static String link;

    public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        createGUI();
    }

    public DownStream(String link) {
        this.link = link;
    }

    public static void createGUI() {
        JFrame frame = new JFrame("Loading process");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel();
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        frame.getContentPane().add(label, BorderLayout.CENTER);

        JButton button = new JButton("Загрузить картинку");
        button.setFocusable(false);
        button.setFont(new Font("Verdana", Font.PLAIN, 12));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Image img = loadImage();
                label.setIcon(new ImageIcon(img, "Google logo"));
            }
        });
        frame.getContentPane().add(button, BorderLayout.SOUTH);

        frame.setPreferredSize(new Dimension(285, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static Image loadImage() {
        try {

            String fileName = link.split("/")[3]+"g.png";

            BufferedImage img = ImageIO.read(new URL(link));
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            ImageIO.write(img, "png", file);
            return img;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
