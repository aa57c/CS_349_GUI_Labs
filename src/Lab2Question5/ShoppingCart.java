package Lab2Question5;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart extends JFrame {
    private JPanel mainPanel = new JPanel();
    private JPanel bookPanel = new JPanel();
    private JPanel cartPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();

    private JList<String> Books;
    private JList<String> cart;
    private ArrayList<Double> prices = new ArrayList<>();

    private JButton removeBtn = new JButton("Remove");
    private JButton exitBtn = new JButton("Exit");
    private JButton clearBtn = new JButton("Clear");
    private JButton checkOutBtn = new JButton("Check Out");

    public ShoppingCart(){
        super("Shopping Cart");
        mainPanel.setLayout(new BorderLayout());
        build_book_panel();
        build_cart_panel();
        setControlPanel();

        add(mainPanel, BorderLayout.NORTH);
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void build_cart_panel(){
        cartPanel.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));
        DefaultListModel<String> model = new DefaultListModel<>();
        Books.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    String str = (String) Books.getSelectedValue();
                    model.addElement(str);
                }

            }
        });
        cart = new JList<String>(model);
        JScrollPane scroll = new JScrollPane(cart);

        cartPanel.add(scroll);
        mainPanel.add(cartPanel, BorderLayout.EAST);


    }
    private void build_book_panel(){
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));
        ArrayList<String> books = new ArrayList<>();
        bookPanel.setBorder(BorderFactory.createTitledBorder("Books"));
        try{
            Scanner sc = new Scanner(new File("C:\\Users\\ashna\\Documents\\CS_349\\Lab_GUI\\src\\Lab2Question5\\BookPrices.txt"));
            while(sc.hasNext()){
                String[] split = sc.nextLine().split(",");
                prices.add(Double.parseDouble(split[1]));
                books.add(split[0]);
                DefaultListModel<String> model = new DefaultListModel<>();
                for(String book : books){
                    model.addElement(book);
                }
                Books = new JList<String>(model);


            }


        } catch (Exception e) {
            System.out.println(e);
        }
        JScrollPane scroll = new JScrollPane(Books);
        bookPanel.add(scroll);
        mainPanel.add(bookPanel, BorderLayout.WEST);

    }
    private void setControlPanel(){
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Check Out"));
        buttonPanel.add(removeBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(exitBtn);
        buttonPanel.add(checkOutBtn);

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
                double total = 0, subTotal = 0;
                ArrayList<String> selection = new ArrayList<>();
                for(int i = 0; i < model.size(); i++){
                    selection.add(model.getElementAt(i).toString());
                    switch(model.getElementAt(i).toString()){
                        case "I Did It Your Way":
                            subTotal += 11.95;
                            break;
                        case "The History of Scotland":
                            subTotal += 14.50;
                            break;
                        case "Learn Calculus in One Day":
                            subTotal += 29.95;
                            break;
                        case "Feel the Stress":
                            subTotal += 18.50;
                            break;
                        default:

                    }
                }
                DecimalFormat df = new DecimalFormat("#,###.00");
                JOptionPane.showMessageDialog(null, "Sub total: $" + subTotal
                        +"\nTax: $" + df.format((subTotal * 0.06)) + "\nTotal: $" + df.format((subTotal + (subTotal*0.06))));

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
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


    }
    public static void main(String args[]){
        new ShoppingCart();
    }

}
