package Lab1Question4;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TravelExpenses extends JFrame {
    private JPanel mainPanel = new JPanel();
    private TripPanel tripPanel = new TripPanel();

    private JPanel btnPanel = new JPanel();
    private JButton calcButton = new JButton("Calculate");
    private JButton exitButton = new JButton("Exit");

    public TravelExpenses(){
        super("Travel Expenses");
        buildPanel();

        getContentPane().setBackground(Color.LIGHT_GRAY);
        add(mainPanel, BorderLayout.NORTH);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void buildPanel(){
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20 , 20));
        mainPanel.setBackground(Color.decode("#B00A0A"));
        btnPanel.setLayout(new GridLayout(1, 2));
        btnPanel.add(exitButton);
        btnPanel.add(calcButton);

        btnPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        mainPanel.add(tripPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        btnPanel.setBackground(Color.decode("#F55239"));
        exitButton.addActionListener(new ExitButtonListener());
        calcButton.addActionListener(new CalcButtonListener());
    }
    private class CalcButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DecimalFormat df = new DecimalFormat("#,###.00");
            JOptionPane.showMessageDialog(null,"\nTotal Expenses: $" +
                    df.format(tripPanel.getTotalExpenses()) + "\nTotal Allowed Expenses: $" +
                    df.format(tripPanel.getTotalAllowedExpenses()) + "\nExcess: $" +
                    df.format(tripPanel.getExcess()) + "\nSaved Amount: $" +
                    df.format(tripPanel.getSavedAmount()), "Expenses", JOptionPane.INFORMATION_MESSAGE
            );



        }
    }
    private class ExitButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);

        }
    }
    public static void main(String[] args){
        new TravelExpenses();
    }
}
