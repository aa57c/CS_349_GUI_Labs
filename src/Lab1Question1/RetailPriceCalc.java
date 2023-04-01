package Lab1Question1;

import javax.swing.*;
import java.awt.event.*;

public class RetailPriceCalc extends JFrame {
    private JPanel panel;
    private JLabel wholeSaleCostLabel;
    private JLabel markUpPercentLabel;
    private JTextField wholeSaleCost;
    private JTextField markUp;
    private JButton calcButton;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 250;
    public RetailPriceCalc(){

        //Set this window's title
        setTitle("Retail Price Calculator");
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
        wholeSaleCostLabel = new JLabel("Enter a cost");
        wholeSaleCost = new JTextField(5);
        markUpPercentLabel = new JLabel("Enter a markup percentage");
        markUp = new JTextField(3);
        calcButton = new JButton("Calculate");
        calcButton.addActionListener(new CalcButtonListener());

        panel = new JPanel();
        panel.add(wholeSaleCostLabel);
        panel.add(wholeSaleCost);
        panel.add(markUpPercentLabel);
        panel.add(markUp);
        panel.add(calcButton);


    }
    private class CalcButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String input1;
            double cost;
            String input2;
            double markup;
            double retailPrice;

            input1 = wholeSaleCost.getText();
            System.out.println("Reading " + input1 + " from the text field.");
            cost = Double.parseDouble(input1);
            System.out.println("Converted value: " + cost);
            input2 = markUp.getText();
            System.out.println("Reading " +input1 + " from the text field.");
            markup = Double.parseDouble(input2) / 100;
            System.out.println("Converted value: " + markup);
            retailPrice = cost + (markup * cost);
            JOptionPane.showMessageDialog(null, "Retail Price: " + retailPrice);
            System.out.println("Ready for the next input.");



        }
    }

}
