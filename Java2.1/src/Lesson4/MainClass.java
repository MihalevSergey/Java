package Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainClass {
    public static void main(String[] args) {
        MyWindow mw = new MyWindow();
    }
}

class MyWindow extends JFrame {
    public MyWindow() throws HeadlessException {
        setTitle("Java GUI");
        setBounds(800,300, 300,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int sizeW = 600;
        int sizeH = 500;

        int locatonX = (screenSize.width - sizeW) / 2;
        int locatonY = (screenSize.height - sizeH) / 2;

        setBounds(locatonX, locatonY, sizeW , sizeH);

//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLayout(new FlowLayout());

        JButton jbt1 = new JButton("jbt1");

        jbt1.setPreferredSize(new Dimension(200, 100));

        JButton jbt2 = new JButton("jbt2");
        JButton jbt3 = new JButton("jbt3");
        JButton jbt4 = new JButton("jbt4");


        add(jbt1);
        add(jbt2);
        add(jbt3);
        add(jbt4);

        jbt1.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                System.out.println(getClass().getName());
            }
        });

        jbt1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println("Привет))");
                }

            }
        });


//        panel.setLayout(null);

//        panel.add(btn1);
//        panel.add(btn2);
//
//        add(panel);

//        JPanel panel = new JPanel(new GridLayout(1,2));
//


//        JButton btn1 = new JButton("btn1");
//        JButton btn2 = new JButton("btn2");
//        JButton btn3 = new JButton("btn3");
//        JButton btn4 = new JButton("btn4");
//        JButton btn5 = new JButton("btn5");
//        panel.add(btn4);
//        panel.add(btn5);
//        add(btn1, BorderLayout.EAST);
//        add(btn2, BorderLayout.WEST);
//        add(btn3, BorderLayout.SOUTH);
//        add(panel, BorderLayout.NORTH);


        setVisible(true);


    }
}


//    JButton btn1 = new JButton("btn1");
//    JButton btn2 = new JButton("btn2");
//        btn1.setBounds(5,5,85,30);
//                btn2.setBounds(65,45,65,30);
//                panel.add(btn1);
//                panel.add(btn2);
//
//                add(panel);