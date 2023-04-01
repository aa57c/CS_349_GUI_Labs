package Lab2Question3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class DormAndMealPlan extends JFrame {
    private JPanel mainPanel = new JPanel();
    private JPanel dormPanel = new JPanel();
    private JPanel mealPanel = new JPanel();
    private JPanel cartPanel = new JPanel();

    private JPanel btnPanel = new JPanel();

    private JList<String> dorms;

    private JList<String> meals;

    private JList<String> cart;

    private JButton removeBtn = new JButton("Remove");
    private JButton exitBtn = new JButton("Exit");
    private JButton clearBtn = new JButton("Clear");
    private JButton checkOutBtn = new JButton("Check Out");

    public DormAndMealPlan(){
        super("Dorm and Meal Plan Calculator");
        mainPanel.setLayout(new BorderLayout());
        build_dorms_panel();
        build_meals_panel();
        build_cart_panel();
        build_button_panel();
        add(mainPanel, BorderLayout.NORTH);
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    private void build_cart_panel(){
        cartPanel.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));
        DefaultListModel<String> model = new DefaultListModel<>();
        dorms.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    String str = (String) dorms.getSelectedValue();
                    model.addElement(str);
                }

            }
        });
        meals.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    String str = (String) meals.getSelectedValue();
                    model.addElement(str);
                }

            }
        });

        cart = new JList<String>(model);
        JScrollPane scroll = new JScrollPane(cart);

        cartPanel.add(scroll);
        mainPanel.add(cartPanel, BorderLayout.EAST);
    }
    private void build_dorms_panel(){
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));
        dormPanel.setBorder(BorderFactory.createTitledBorder("Dorms"));
        ArrayList<String> Dorms = new ArrayList<>();
        DefaultListModel<String> model = new DefaultListModel<String>();
        Dorms.add("Allen Hall");
        Dorms.add("Pike Hall");
        Dorms.add("Farthing Hall");
        Dorms.add("University Suites");
        for(String dorm : Dorms){
            model.addElement(dorm);

        }
        dorms = new JList<String>(model);
        JScrollPane scroll = new JScrollPane(dorms);
        dormPanel.add(scroll);
        mainPanel.add(dormPanel, BorderLayout.WEST);



    }
    private void build_meals_panel(){
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));
        mealPanel.setBorder(BorderFactory.createTitledBorder("Meals"));
        ArrayList<String> Meals = new ArrayList<>();
        DefaultListModel<String> model = new DefaultListModel<String>();
        Meals.add("7 meals per week");
        Meals.add("14 meals per week");
        Meals.add("Unlimited meals");
        for(String meal : Meals){
            model.addElement(meal);

        }
        meals = new JList<String>(model);
        JScrollPane scroll = new JScrollPane(meals);
        mealPanel.add(scroll);
        mainPanel.add(mealPanel, BorderLayout.CENTER);



    }
    private void build_button_panel(){
        btnPanel.setBorder(BorderFactory.createTitledBorder("Check Out"));
        btnPanel.add(removeBtn);
        btnPanel.add(clearBtn);
        btnPanel.add(exitBtn);
        btnPanel.add(checkOutBtn);

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<String> model = (DefaultListModel<String>) cart.getModel();
                if(!model.isEmpty()){
                    model.removeAllElements();
                }
            }
        });
        checkOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) cart.getModel();
                double total = 0;
                ArrayList<String> selection = new ArrayList<>();
                for(int i = 0; i < model.size(); i++){
                    selection.add(model.getElementAt(i).toString());
                    switch(model.getElementAt(i).toString()){
                        case "Allen Hall", "Unlimited meals":
                            total += 1500;
                            break;
                        case "Pike Hall":
                            total += 1600;
                            break;
                        case "Farthing Hall":
                            total += 1200;
                            break;
                        case "University Suites":
                            total += 1800;
                            break;
                        case "7 meals per week":
                            total += 560;
                            break;
                        case "14 meals per week":
                            total += 1095;
                            break;
                        default:

                    }


                }
                DecimalFormat df = new DecimalFormat("#,###.00");
                JOptionPane.showMessageDialog(null, "Total for the semester: $" + df.format(total));

            }
        });
        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) cart.getModel();
                String selection = (String) cart.getSelectedValue();
                model.removeElement(selection);

            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

    }
    public static void main(String args[]){
        new DormAndMealPlan();
    }



}
