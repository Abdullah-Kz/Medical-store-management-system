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

public class AdminDashboard extends JFrame {


    public AdminDashboard(Admin admin) {

        setTitle("Abdullah Pharmacy");
        setSize(800, 800);
        setResizable(false);
        ImageIcon image = new ImageIcon("download.png");
        setIconImage(image.getImage()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
      
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBackground(new Color(0,255,51));
//        JLabel text = new JLabel();
//        text.setLayout(new BorderLayout());
//        text.setText("Welcome to Admin Dashboard");
//panel.add(text);
ImageIcon plus = new ImageIcon("plus.png");
ImageIcon delete = new ImageIcon("delete.png");
ImageIcon update = new ImageIcon("update.png");
ImageIcon logout = new ImageIcon("logout.png");
        JButton addUserButton = new JButton("Add User");
        addUserButton.setBackground(new Color(255,153, 0));
        addUserButton.setIcon(plus);
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUserFrame(admin).setVisible(true);
            }
        });
        panel.add(addUserButton);
        
         JButton addMedicineButton = new JButton("Add Medicine");
        addMedicineButton.setBackground(new Color(255,153, 0));
        addMedicineButton.setIcon(plus);
        addMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddMedicineFrame(admin).setVisible(true);
            }
        });
        panel.add(addMedicineButton);

        JButton deleteUserButton = new JButton("Delete User");
        deleteUserButton.setBackground(new Color(255,153, 0));
              deleteUserButton.setIcon(delete);
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteUserFrame(admin).setVisible(true);
            }
        });
        panel.add(deleteUserButton);
        
        
        JButton deleteMedicineButton = new JButton("Delete Medicine");
        deleteMedicineButton.setBackground(new Color(255,153, 0));
          deleteMedicineButton.setIcon(delete);
        
        deleteMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteMedicineFrame(admin).setVisible(true);
            }
        });
        panel.add(deleteMedicineButton);
        

        JButton updateUserButton = new JButton("Update User Password");
        updateUserButton.setBackground(new Color(255,153, 0));
       updateUserButton.setIcon(update);
        updateUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateUserPasswordFrame(admin).setVisible(true);
            }
        });
        panel.add(updateUserButton);

       

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(255,153, 0));
         logoutButton.setIcon(logout);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame(admin).setVisible(true);
                dispose();
            }
        });
        panel.add(logoutButton);

        add(panel);
    }
}
