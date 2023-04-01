package Lab1Question2;

import javax.swing.*;
import java.awt.event.*;

public class MonthlySalesTax extends JFrame {
    private JPanel panel;
    private JLabel totalMonthSalesLabel;
    private JTextField totalMonthSales;

    private JButton calcButton;

    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 250;

    final double STATE_TAX_RATE = 0.4;
    final double COUNTY_TAX_RATE = 0.2;
    public MonthlySalesTax(){
        //Set this window's title
        setTitle("Monthly Sales Tax Calculator");
        //set the size of this window
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Specify what happens when the close button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //build the panel and add it to the frame
        buildPanel();
        add(panel);
        // Display the window
        setVisible(true);
    }
    private void buildPanel(){
        totalMonthSalesLabel = new JLabel("Enter total sales for the month");
        totalMonthSales = new JTextField(8);
        calcButton = new JButton("Calculate");
        calcButton.addActionListener(new CalcButtonListener());
        panel = new JPanel();
        panel.add(totalMonthSalesLabel);
        panel.add(totalMonthSales);
        panel.add(calcButton);




    }
    private class CalcButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String input;
            double monthlySales;
            double countyTax;
            double salesTax;
            input = totalMonthSales.getText();
            System.out.println("Reading " + input + " from the text field.");
            monthlySales = Double.parseDouble(input);
            System.out.println("Converted value: " + monthlySales);
            countyTax = monthlySales * COUNTY_TAX_RATE;
            salesTax = monthlySales * STATE_TAX_RATE;
            JOptionPane.showMessageDialog(null, "Total County Tax: " +
                    countyTax + "\nTotal Sales Tax: "+ salesTax + "\nTotal Tax: "+ (countyTax + salesTax));



        }
    }




}
