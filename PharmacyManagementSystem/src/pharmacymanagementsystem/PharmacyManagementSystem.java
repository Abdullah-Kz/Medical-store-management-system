/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pharmacymanagementsystem;

import javax.swing.SwingUtilities;

/**
 *
 * @author abdul
 */
public class PharmacyManagementSystem {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
        Admin admin = new Admin("1", "1");
        admin.loadUsers();
        admin.loadMedicines();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame(admin).setVisible(true);
            }
        });
    }
}
