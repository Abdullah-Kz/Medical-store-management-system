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


public class UserDashboard extends JFrame {


    public UserDashboard(User user, Admin admin) {

        setTitle("Abdullah Pharmacy");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
        ImageIcon image = new ImageIcon("download.png");
        setIconImage(image.getImage());
       
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
           panel.setBackground(new Color(	51,153,255));
           ImageIcon plus = new ImageIcon("plus.png");
ImageIcon logout = new ImageIcon("logout.png");
ImageIcon bill = new ImageIcon("bill.png");

        JButton buyMedicineButton = new JButton("Buy Medicine");
        buyMedicineButton.setBackground(new Color(255,153, 0));
        buyMedicineButton.setIcon(plus);
        buyMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BuyMedicineFrame(user, admin).setVisible(true);
            }
        });
        panel.add(buyMedicineButton);

        JButton printBillButton = new JButton("Show Bill");
        printBillButton.setBackground(new Color(255,153, 0));
         printBillButton.setIcon(bill);
        printBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.generateBill();
            }
        });
        panel.add(printBillButton);

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
