package Lab2Question1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.text.DecimalFormat;

public class ScrollableTaxCalculator extends JFrame implements ChangeListener{
    private JPanel main = new JPanel();
    private JPanel purchase = new JPanel();
    private JPanel result = new JPanel();
    private JPanel sliderP = new JPanel();

    private JLabel purchase_amount = new JLabel("Purchase Amount: $");
    private JTextField paT = new JTextField(10);

    private JLabel amount = new JLabel("Amount: $");
    private JTextField aTF = new JTextField(10);

    private JLabel salesTax = new JLabel("Sales Tax: $");
    private JTextField sTF = new JTextField(10);

    private JLabel total_amount = new JLabel("Total: $");
    private JTextField taTF = new JTextField(10);

    private JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 2);

    public ScrollableTaxCalculator(){
        setTitle("Tax Calculator");
        buildPanel();
        add(main, BorderLayout.NORTH);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void buildPanel(){
        main.setLayout(new BorderLayout());
        main.setBorder(new EmptyBorder(20,20,20,20));

        //purchase panel
        purchase.setLayout(new GridLayout(1, 2));
        purchase.add(purchase_amount);
        purchase.add(paT);

        purchase.setBorder(BorderFactory.createTitledBorder("Purchase"));

        //result panel
        result.setLayout(new GridLayout(3, 2));
        result.add(amount);
        result.add(aTF);
        result.add(salesTax);
        result.add(sTF);
        result.add(total_amount);
        result.add(taTF);

        result.setBorder(BorderFactory.createTitledBorder("Results"));

        //slider panel
        sliderP.setBorder(BorderFactory.createTitledBorder("Tax"));
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(2);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        sliderP.add(slider);
        slider.addChangeListener(this);

        // set result text fields to uneditable
        aTF.setEditable(false);
        sTF.setEditable(false);
        taTF.setEditable(false);

        main.add(purchase, BorderLayout.NORTH);
        main.add(result, BorderLayout.CENTER);
        main.add(sliderP, BorderLayout.SOUTH);





    }
    public void stateChanged(ChangeEvent e){
        DecimalFormat df = new DecimalFormat("#,###.00");
        if(!paT.getText().isEmpty()){
            double purchaseAmount = Double.parseDouble(paT.getText());
            double salesTax = slider.getValue();
            double subTotal = (purchaseAmount * (salesTax/100));
            double total = subTotal + purchaseAmount;

            aTF.setText(df.format(purchaseAmount));
            sTF.setText(df.format(subTotal));
            taTF.setText(df.format(total));
        }

    }
    public static void main(String[] args){
        new ScrollableTaxCalculator();
    }

}
