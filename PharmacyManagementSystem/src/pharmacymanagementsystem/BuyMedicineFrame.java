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
import java.util.List;

public class BuyMedicineFrame extends JFrame {

    public BuyMedicineFrame(User user, Admin admin) {

        setTitle("Abdullah Pharmacy");
        setSize(800, 800);
        setResizable(false);
        ImageIcon image = new ImageIcon("download.png");
        setIconImage(image.getImage());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> medicineList = new JList<>(listModel);
        List<Medicine> medicines = admin.getMedicines();
        for (Medicine medicine : medicines) {
            listModel.addElement(medicine.getName() + " - $" + medicine.getPrice() + " per unit - " + medicine.getQuantity() + " units available");
        }
        panel.add(new JScrollPane(medicineList), BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2, 2));
           panel.setBackground(new Color(	51,153,255));

        JLabel quantity = new JLabel();
        quantity.setText("Quantity");
        quantity.setVerticalAlignment(JLabel.CENTER);
         quantity.setHorizontalAlignment(JLabel.CENTER);
        southPanel.add(quantity);

        JTextField quantityField = new JTextField();
        southPanel.add(quantityField);

        JButton buyButton = new JButton("Buy");
        buyButton.setBackground(new Color(255,153, 0));
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = medicineList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Medicine selectedMedicine = medicines.get(selectedIndex);
                    int quantity = Integer.parseInt(quantityField.getText());
                    if (quantity <= selectedMedicine.getQuantity()) {
                        selectedMedicine.setQuantity(selectedMedicine.getQuantity() - quantity);
                        user.buyMedicine(new Medicine(selectedMedicine.getName(), selectedMedicine.getPrice(), quantity), quantity);
                        admin.saveMedicines();
                        JOptionPane.showMessageDialog(null, "Medicine bought successfully");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Not enough stock available");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a medicine");
                }
            }
        });
        southPanel.add(buyButton);
//            new BuyMedicineFrame(user, admin).setVisible(true);

        panel.add(southPanel, BorderLayout.SOUTH);

        add(panel);
    }
}
