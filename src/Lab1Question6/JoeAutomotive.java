package Lab1Question6;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

public class JoeAutomotive extends JFrame implements ItemListener, ActionListener {
    private static double OIL_CHANGE = 26.00;
    private static double LUBE_JOB = 18.00;
    private static double RADIATOR_FLUSH = 30.00;
    private static double TRANSMISSION_FLUSH = 80.00;
    private static double INSPECTION = 15.00;
    private static double MUFFLER_REPLACE = 100.00;
    private static double TIRE_ROTATION = 20.00;
    private JCheckBox oil_chg = new JCheckBox("Oil Change");
    private JCheckBox lb = new JCheckBox("Lube job");
    private JCheckBox radiator_flush = new JCheckBox("Radiator Flush");
    private JCheckBox transmission_flush = new JCheckBox("Transmission Flush");
    private JCheckBox inspection = new JCheckBox("Inspection");
    private JCheckBox muffler_replacement = new JCheckBox("Muffler Replacement");

    private JCheckBox tire_rotation = new JCheckBox("Tire Rotation");

    private JCheckBox nonRoutine = new JCheckBox("Non routine");

    private JLabel hoursLabel = new JLabel("\tHours");
    private JTextField hoursText = new JTextField(10);
    private JButton calcBtn = new JButton("Calculate");
    private JButton exitBtn = new JButton("Exit");

    private JPanel mainPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JPanel btnPanel = new JPanel();

    private static double total = 0;
    private static double LABOR_PER_HOUR = 20.00;

    public JoeAutomotive(){
        super("Joe's Automotive");
        buildPanel();
        getContentPane().setBackground(Color.decode("#17A589"));
        add(mainPanel, BorderLayout.NORTH);
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void buildPanel(){
        hoursLabel.setVisible(false);
        hoursText.setVisible(false);
        mainPanel.setBackground(Color.decode("#F1948A"));
        btnPanel.setBackground(Color.decode("#EC7063"));

        panel.setLayout(new GridLayout(8, 2));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));

        panel.setBackground(Color.decode("#CB4335"));

        panel.add(oil_chg);
        oil_chg.addItemListener(this);
        oil_chg.setForeground(Color.BLACK);
        panel.add(lb);
        lb.setForeground(Color.BLACK);
        lb.addItemListener(this);
        panel.add(radiator_flush);
        radiator_flush.setForeground(Color.BLACK);
        radiator_flush.addItemListener(this);
        panel.add(transmission_flush);
        transmission_flush.setForeground(Color.BLACK);
        transmission_flush.addItemListener(this);
        panel.add(inspection);
        inspection.setForeground(Color.BLACK);
        inspection.addItemListener(this);
        panel.add(muffler_replacement);
        muffler_replacement.setForeground(Color.BLACK);
        muffler_replacement.addItemListener(this);
        panel.add(tire_rotation);
        tire_rotation.setForeground(Color.BLACK);
        tire_rotation.addItemListener(this);
        panel.add(nonRoutine);
        nonRoutine.setForeground(Color.BLACK);
        nonRoutine.addItemListener(this);

        btnPanel.setBorder(new EmptyBorder(20,20,20,20));
        hoursLabel.setForeground(Color.WHITE);
        hoursText.setBackground(Color.decode("#CB4335"));
        hoursText.setForeground(Color.WHITE);

        btnPanel.setLayout(new GridLayout(2, 2));
        btnPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        btnPanel.add(hoursLabel);
        btnPanel.add(hoursText);
        btnPanel.add(exitBtn);
        btnPanel.add(calcBtn);

        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        mainPanel.add(panel, BorderLayout.CENTER);

        calcBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        calcBtn.setBackground(Color.PINK);
        calcBtn.setOpaque(true);
        calcBtn.setForeground(Color.BLACK);
        calcBtn.setBorderPainted(false);

        exitBtn.setBackground(Color.PINK);
        exitBtn.setOpaque(true);
        exitBtn.setForeground(Color.BLACK);
        exitBtn.setBorderPainted(false);












    }


    @Override
    public void actionPerformed(ActionEvent e) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        double laborCharge = 0;
        if(nonRoutine.isSelected()){
            hoursText.setVisible(true);
            hoursLabel.setVisible(true);
            if(!hoursText.getText().isEmpty()){
                int hours = Integer.parseInt(hoursText.getText());
                laborCharge = hours * LABOR_PER_HOUR;
            }
        }
        if(e.getSource() == exitBtn){
            System.exit(0);
        }
        else if(e.getSource() == calcBtn){
            JOptionPane.showMessageDialog(null, "Total: $" + df.format(total)
            + "\nLabor charge: $" + df.format(laborCharge), "Joe's Automotive", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==nonRoutine && nonRoutine.isSelected()){
            hoursLabel.setVisible(true);
            hoursText.setVisible(true);
        }
        else{
            hoursLabel.setVisible(false);
            hoursText.setVisible(false);
        }
        if(e.getSource() == oil_chg && oil_chg.isSelected()){
            total += OIL_CHANGE;
        }
        if(e.getSource() == lb && lb.isSelected()){
            total += LUBE_JOB;
        }
        if(e.getSource() == radiator_flush && radiator_flush.isSelected()){
            total += RADIATOR_FLUSH;
        }
        if(e.getSource() == transmission_flush && transmission_flush.isSelected()){
            total += TRANSMISSION_FLUSH;
        }
        if(e.getSource() == muffler_replacement && muffler_replacement.isSelected()){
            total += MUFFLER_REPLACE;
        }
        if(e.getSource() == inspection && inspection.isSelected()){
            total += INSPECTION;
        }
        if(e.getSource() == tire_rotation && tire_rotation.isSelected()){
            total += TIRE_ROTATION;
        }



    }
    public static void main(String[] args){
        new JoeAutomotive();
    }
}
