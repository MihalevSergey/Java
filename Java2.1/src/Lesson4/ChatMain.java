package Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChatMain {
    public static void main(String[] args) {
        ChatWindow cw = new ChatWindow();
    }
}

class ChatWindow extends JFrame {
    public ChatWindow() throws HeadlessException {
        setTitle("Java GUI");
        setBounds(800, 300, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        centerPanel.setBackground(Color.pink);
        bottomPanel.setBackground(Color.pink);

        bottomPanel.setPreferredSize(new Dimension(1, 40));

        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
        bottomPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new BorderLayout());

        JButton jb = new JButton("Send");

        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        centerPanel.add(jsp, BorderLayout.CENTER);

        JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(300, 28));

        jta.setEditable(false);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
                jtf.grabFocus();
            }
        });

        jb.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jta.append(jtf.getText() + "\n");
                    jtf.setText("");
                    jtf.grabFocus();
                }

            }
        });

        bottomPanel.add(jtf);
        bottomPanel.add(jb);


        setVisible(true);
    }

}
