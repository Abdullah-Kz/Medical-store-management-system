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

public class UpdateUserPasswordFrame extends JFrame {

    public UpdateUserPasswordFrame(Admin admin) {

        setTitle("Abdullah Pharmacy");
    setSize(600, 300);
        setResizable(false);
        ImageIcon image = new ImageIcon("download.png");
        setIconImage(image.getImage());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
           panel.setBackground(new Color(	51,153,255));

        JLabel username = new JLabel();
           username.setText("Username:");
        username.setVerticalAlignment(JLabel.CENTER);
         username.setHorizontalAlignment(JLabel.CENTER);
        panel.add(username);

        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        JLabel newpassword = new JLabel();
          newpassword.setText("New Password:");
        newpassword.setVerticalAlignment(JLabel.CENTER);
         newpassword.setHorizontalAlignment(JLabel.CENTER);
        panel.add(newpassword);

        JPasswordField newPasswordField = new JPasswordField();
        panel.add(newPasswordField);

        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(255,153, 0));
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String newPassword = new String(newPasswordField.getPassword());
                admin.updateUserPassword(username, newPassword);
                JOptionPane.showMessageDialog(null, "Password updated successfully");
                dispose();
            }
        });
        panel.add(updateButton);

        add(panel);
    }
}
