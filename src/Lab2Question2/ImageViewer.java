package Lab2Question2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageViewer extends JFrame implements ActionListener {

    /*
    *  Change the file path string according to your file structure
    *
    *
    * */

    private String filePath = "C:\\Users\\ashna\\Documents\\CS_349\\Lab_GUI\\src\\Lab2Question2";
    private File file;

    private JPanel panel = new JPanel();
    private JPanel main = new JPanel();

    private JButton open = new JButton("Upload Picture");
    private JLabel picture = new JLabel();

    private JFileChooser filechooser = new JFileChooser(filePath);

    public ImageViewer(){
        super("Image Viewer");
        setSize(500,500);
        add(buildPanel(), BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private JPanel buildPanel(){
        main.setLayout(new BorderLayout());
        main.setBorder(new EmptyBorder(20,20,20,20));

        open.addActionListener(this);
        panel.add(open);
        panel.add(picture);
        getContentPane().setBackground(Color.BLACK);
        picture.setToolTipText("hide picture");
        main.add(panel, BorderLayout.CENTER);
        main.setBackground(Color.gray);
        panel.setBackground(Color.gray);

        return main;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        filechooser.setAcceptAllFileFilterUsed(false);
        int option = filechooser.showOpenDialog(ImageViewer.this);
        if(option == JFileChooser.APPROVE_OPTION){
            file = filechooser.getSelectedFile();
            ImageIcon image = new ImageIcon(new ImageIcon(String.valueOf(file))
                    .getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
            picture.setIcon(image);
        }

    }
    public static void main(String[] args){
        new ImageViewer();
    }
}
