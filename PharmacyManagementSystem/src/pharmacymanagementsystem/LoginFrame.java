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

public class LoginFrame extends JFrame {

    public LoginFrame(Admin admin) {

        setTitle("Abdullah Pharmacy");
        setSize(300, 250);
        setResizable(false);
        ImageIcon image = new ImageIcon("download.png");
        setIconImage(image.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
       
        panel.setBackground(new Color(	51,153,255));

        JLabel userTypeLabel = new JLabel("   Login as  ");
        panel.add(userTypeLabel);

        
        JComboBox<String> userTypeCombo = new JComboBox<>(new String[]{"User", "Admin"});
        userTypeCombo.setPreferredSize(new Dimension(250 ,30));
        panel.add(userTypeCombo);

        JLabel usernameLabel = new JLabel("   Username  ");
        panel.add(usernameLabel);

        JTextField usernameField = new JTextField();
          usernameField.setPreferredSize(new Dimension(250 ,30));
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("    Password  ");
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
         passwordField.setPreferredSize(new Dimension(250 ,30));
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(255,153, 0));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (userTypeCombo.getSelectedItem().equals("Admin")) {
                    if (admin.authenticate(username, password)) {
                        new AdminDashboard(admin).setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid admin credentials");
                    }
                } else {
                    User user = admin.getUser(username);
                    if (user != null && user.getPassword().equals(password)) {
                        new UserDashboard(user, admin).setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid user credentials");
                    }
                }
            }
        });
        panel.add(loginButton);

        add(panel);
    }
}
