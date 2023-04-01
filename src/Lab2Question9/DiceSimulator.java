package Lab2Question9;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceSimulator extends JFrame {
    private JPanel mainPanel = new JPanel();
    private JPanel labelPanel = new JPanel();
    private JPanel btnPanel = new JPanel();

    private String[] images = {
            "C:\\Users\\ashna\\Documents\\CS_349\\Lab_GUI\\src\\Lab2Question9\\dice_1.png",
            "C:\\Users\\ashna\\Documents\\CS_349\\Lab_GUI\\src\\Lab2Question9\\dice_2.png",
            "C:\\Users\\ashna\\Documents\\CS_349\\Lab_GUI\\src\\Lab2Question9\\dice_3.svg",
            "C:\\Users\\ashna\\Documents\\CS_349\\Lab_GUI\\src\\Lab2Question9\\dice_4.png",
            "C:\\Users\\ashna\\Documents\\CS_349\\Lab_GUI\\src\\Lab2Question9\\dice_5.png",
            "C:\\Users\\ashna\\Documents\\CS_349\\Lab_GUI\\src\\Lab2Question9\\dice_6.png"

    };
    private JButton rollBtn = new JButton("Roll");
    private JButton exitBtn = new JButton("Exit");
    private JLabel label_1;
    private JLabel label_2;

    private int num_1 = 3, num_2 = 5;
    public DiceSimulator(){
        super("Dice Simulator");
        buildPanel();
        getContentPane().setBackground(Color.CYAN);
        setSize(600, 600);
        add(mainPanel, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
    private void buildPanel(){
        mainPanel.setBackground(Color.RED);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(50,20,20,20));
        label_1 = new JLabel(new ImageIcon(images[num_1]));
        label_2 = new JLabel(new ImageIcon(images[num_2]));

        labelPanel.setLayout(new GridLayout(1, 2));
        labelPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        labelPanel.setBackground(Color.LIGHT_GRAY);

        labelPanel.add(label_1);
        labelPanel.add(label_2);

        btnPanel.setLayout(new GridLayout(1, 2));
        btnPanel.add(exitBtn);
        btnPanel.add(rollBtn);

        mainPanel.add(labelPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        btnPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        btnPanel.setBackground(Color.LIGHT_GRAY);

        rollBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                num_1 = rand.nextInt(6-1+1) + 1;
                num_2 = rand.nextInt(6-1+1) + 1;
                System.out.println(num_1);

                label_1.setIcon(new ImageIcon(images[num_1]));
                label_2.setIcon(new ImageIcon(images[num_2]));

            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
    public static void main(String[] args){
        new DiceSimulator();
    }

}
