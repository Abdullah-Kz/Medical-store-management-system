/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacymanagementsystem;

/**
 *
 * @author abdul
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMedicineFrame extends JFrame {

    public AddMedicineFrame(Admin admin) {

        setTitle("Abdullah Pharmacy");
        setSize(600, 300);
        setResizable(false);
        ImageIcon image = new ImageIcon("download.png");
        setIconImage(image.getImage());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
           panel.setBackground(new Color(	51,153,255));

        JLabel Medicinename = new JLabel();
        Medicinename.setText("Medicine Name:");
        Medicinename.setVerticalAlignment(JLabel.CENTER);
         Medicinename.setHorizontalAlignment(JLabel.CENTER);
        panel.add(Medicinename);

        JTextField nameField = new JTextField();
        panel.add(nameField);

        JLabel price = new JLabel();
        price.setText("Price per unit:");
        price.setVerticalAlignment(JLabel.CENTER);
         price.setHorizontalAlignment(JLabel.CENTER);
        panel.add(price);

        JTextField priceField = new JTextField();
        panel.add(priceField);

        JLabel quantity = new JLabel();
       quantity.setText("Quantity:");
        quantity.setVerticalAlignment(JLabel.CENTER);
         quantity.setHorizontalAlignment(JLabel.CENTER);
        panel.add(quantity);

        JTextField quantityField = new JTextField();
        panel.add(quantityField);

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(255,153, 0));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                admin.addMedicine(new Medicine(name, price, quantity));
                JOptionPane.showMessageDialog(null, "Medicine added successfully");
                dispose();
            }
        });
        panel.add(addButton);

        add(panel);
    }
}
