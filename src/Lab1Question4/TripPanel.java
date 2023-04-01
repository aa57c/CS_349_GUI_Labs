package Lab1Question4;

import javax.swing.*;
import java.awt.*;

public class TripPanel extends JPanel {
    private static final int ALLOWED_EXPENSES = 8000;

    private JLabel numofDays = new JLabel(" days on the trip");
    private JLabel airExpenses = new JLabel(" air expenses");
    private JLabel carRental = new JLabel(" car rental fees");

    private JLabel milesDriven = new JLabel(" miles driven");
    private JLabel parkingFees = new JLabel(" parking fees");
    private JLabel taxiCharge = new JLabel(" taxi charge");

    private JLabel conference = new JLabel(" conference fee");
    private JLabel lodging = new JLabel(" lodging charge");

    private JTextField days = new JTextField(5);
    private JTextField airfare = new JTextField(5);
    private JTextField carRentalFees = new JTextField(5);

    private JTextField miles = new JTextField(5);
    private JTextField parking = new JTextField(5);
    private JTextField taxi = new JTextField(5);

    private JTextField conferenceFee = new JTextField(5);
    private JTextField lodgingFee = new JTextField(5);

    private double totalExpenses = 0.0;

    public TripPanel(){
        buildPanel();
    }
    private void buildPanel(){
        setLayout(new GridLayout(8, 8));
        setBackground(Color.decode("#E7B8FE"));

        add(numofDays);
        add(days);

        add(airExpenses);
        add(airfare);

        add(carRental);
        add(carRentalFees);

        add(milesDriven);
        add(miles);

        add(parkingFees);
        add(parking);

        add(taxiCharge);
        add(taxi);

        add(conference);
        add(conferenceFee);

        add(lodging);
        add(lodgingFee);

        setStyle();



    }
    private void setStyle(){
        numofDays.setForeground(Color.WHITE);
        airExpenses.setForeground(Color.WHITE);
        carRental.setForeground(Color.WHITE);
        milesDriven.setForeground(Color.WHITE);
        parkingFees.setForeground(Color.WHITE);
        taxiCharge.setForeground(Color.WHITE);
        conference.setForeground(Color.WHITE);
        lodging.setForeground(Color.WHITE);

        days.setBackground(Color.CYAN);
        days.setForeground(Color.BLACK);

        airfare.setBackground(Color.CYAN);
        airfare.setForeground(Color.BLACK);

        carRentalFees.setBackground(Color.CYAN);
        carRentalFees.setForeground(Color.BLACK);

        miles.setBackground(Color.CYAN);
        miles.setForeground(Color.BLACK);

        parking.setBackground(Color.CYAN);
        parking.setForeground(Color.BLACK);

        taxi.setBackground(Color.CYAN);
        taxi.setForeground(Color.BLACK);

        conferenceFee.setBackground(Color.CYAN);
        conferenceFee.setForeground(Color.BLACK);

        lodgingFee.setBackground(Color.CYAN);
        lodgingFee.setForeground(Color.BLACK);




    }
    private int getDays(){
        int Days = 0;
        if(!days.getText().isEmpty()){
            Days = Integer.parseInt(days.getText());
        }
        return Days;
    }

    private double getExpenses(){
        totalExpenses += (getDays() * 37);
        if(!airfare.getText().isEmpty()){
            double airFare = Double.parseDouble(airfare.getText().toString());
            totalExpenses += airFare;
        }
        if(!lodgingFee.getText().isEmpty()){
            double lodgingfee = Double.parseDouble(lodgingFee.getText().toString());
            totalExpenses += lodgingfee;
        }
        if(!conferenceFee.getText().isEmpty()){
            double conf = Double.parseDouble(conferenceFee.getText().toString());
            totalExpenses += conf;
        }
        if(!taxi.getText().isEmpty()){
            totalExpenses += (getDays() * 20);
        }
        if(!miles.getText().isEmpty()){
            double Miles = Double.parseDouble(miles.getText());
            if(Miles >= 0){
                totalExpenses += Miles * 0.27;

            }
            else{
                totalExpenses += 0;
            }
        }
        if(!carRentalFees.getText().isEmpty()){
            totalExpenses += Double.parseDouble(carRentalFees.getText());

        }
        return totalExpenses;



    }
    public double getTotalExpenses(){
        return getExpenses();
    }
    public double getTotalAllowedExpenses(){
        return ALLOWED_EXPENSES;
    }
    public double getExcess(){
        double excess = 0;
        if(totalExpenses > ALLOWED_EXPENSES){
            excess = ALLOWED_EXPENSES - totalExpenses;
        }
        else{
            excess = 0;
        }
        return excess;
    }
    public double getSavedAmount(){
        double amount = 0;

        if(totalExpenses < ALLOWED_EXPENSES){
            amount = ALLOWED_EXPENSES - totalExpenses;
        }
        else{
            amount = 0;
        }
        return amount;
    }
}
