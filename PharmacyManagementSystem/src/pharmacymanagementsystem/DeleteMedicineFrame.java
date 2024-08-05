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

public class DeleteMedicineFrame extends JFrame {

    public DeleteMedicineFrame(Admin admin) {

        setTitle("Abdullah Pharmacy");
     setSize(600, 300);
        setResizable(false);
        ImageIcon image = new ImageIcon("download.png");
        setIconImage(image.getImage());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
           panel.setBackground(new Color(	51,153,255));

        JLabel medicinename = new JLabel();
        medicinename.setText("Medicine Name:");
        medicinename.setVerticalAlignment(JLabel.CENTER);
         medicinename.setHorizontalAlignment(JLabel.CENTER);
        panel.add(medicinename);

        JTextField nameField = new JTextField();
        panel.add(nameField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(255,153, 0));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                admin.deleteMedicine(name);
                JOptionPane.showMessageDialog(null, "Medicine deleted successfully");
                dispose();
            }
        });
        panel.add(deleteButton);

        add(panel);
    }
}

