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

public class DeleteUserFrame extends JFrame {

    public DeleteUserFrame(Admin admin) {

        setTitle("Abdullah Pharmacy");
      setSize(600, 300);
        setResizable(false);
        ImageIcon image = new ImageIcon("download.png");
        setIconImage(image.getImage());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
           panel.setBackground(new Color(	51,153,255));

        JLabel username = new JLabel("Username:");
          username.setText("Username:");
        username.setVerticalAlignment(JLabel.CENTER);
         username.setHorizontalAlignment(JLabel.CENTER);
        panel.add(username);

        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(255,153, 0));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                admin.deleteUser(username);
                JOptionPane.showMessageDialog(null, "User deleted successfully");
                dispose();
            }
        });
        panel.add(deleteButton);

        add(panel);
    }
}
