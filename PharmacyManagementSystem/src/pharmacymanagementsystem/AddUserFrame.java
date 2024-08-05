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

public class AddUserFrame extends JFrame {

    public AddUserFrame(Admin admin) {

        setTitle("Abdullah Pharmacy");
  setSize(600, 300);
        setResizable(false);
        ImageIcon image = new ImageIcon("download.png");
        setIconImage(image.getImage());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
           panel.setBackground(new Color(51,153,255));

        JLabel username = new JLabel();
        username.setText("ADD USER");
        username.setVerticalAlignment(JLabel.CENTER);
         username.setHorizontalAlignment(JLabel.CENTER);
        panel.add(username);

        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        JLabel password = new JLabel();
         password.setText("Password:");
        password.setVerticalAlignment(JLabel.CENTER);
         password.setHorizontalAlignment(JLabel.CENTER);
        panel.add(password);

        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(255,153, 0));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                admin.addUser(new User(username, password));
                JOptionPane.showMessageDialog(null, "User added successfully");
                dispose();
            }
        });
        panel.add(addButton);

        add(panel);
    }
}
