/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacymanagementsystem;

/**
 *
 * @author abdul
 */
import java.io.Serializable;
import java.util.List;

public class Billing implements Serializable {
    private User user;
    private List<Medicine> purchasedMedicines;
    private double totalAmount;

    public Billing(User user, List<Medicine> purchasedMedicines) {
        this.user = user;
        this.purchasedMedicines = purchasedMedicines;
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        double total = 0;
        for (Medicine medicine : purchasedMedicines) {
            total += medicine.getPrice() * medicine.getQuantity();
        }
        return total;
    }

    public void printBill() {
        System.out.println("Billing Information:");
        System.out.println("User: " + user.getUsername());
        System.out.println("Medicines Purchased:");
        for (Medicine medicine : purchasedMedicines) {
            System.out.println(medicine.getName() + " - " + medicine.getQuantity() + " units - $" + medicine.getPrice() + " each");
        }
        System.out.println("Total Amount: $" + totalAmount);
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

