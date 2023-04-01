package Lab1Question9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MPG_Calculator extends JFrame {
    private JPanel panel;
    private JLabel number_of_gallons;
    private JLabel number_of_miles;
    private JTextField gallons;
    private JTextField miles;
    private JButton calcBtn;
    private final int WINDOW_WIDTH = 350;
    private final int WINDOW_HEIGHT = 250;

    public MPG_Calculator(){
        setTitle("Miles Per Gallon Calculator");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);
    }
    private void buildPanel(){
        number_of_gallons = new JLabel("Number of gallons the car holds");
        number_of_miles = new JLabel("Number of miles on a full tank");
        gallons = new JTextField(3);
        miles = new JTextField(3);
        calcBtn = new JButton("Calculate");
        calcBtn.addActionListener(new CalcButtonListener());

        panel = new JPanel();
        panel.add(number_of_gallons);
        panel.add(gallons);
        panel.add(number_of_miles);
        panel.add(miles);
        panel.add(calcBtn);


    }
    private class CalcButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int Gallons;
            double Miles;
            double mpg;
            Gallons = Integer.parseInt(gallons.getText());
            Miles = Integer.parseInt(miles.getText());
            mpg = Miles / Gallons;
            JOptionPane.showMessageDialog(null, "Max Miles Per Gallon: "+ mpg);



        }
    }
    public static void main(String[] args){
        new MPG_Calculator();
    }
}
