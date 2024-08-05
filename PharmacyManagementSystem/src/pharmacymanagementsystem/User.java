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
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String username;
    private String password;
    private List<Medicine> purchasedMedicines;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.purchasedMedicines = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Medicine> getPurchasedMedicines() {
        return purchasedMedicines;
    }

    public void buyMedicine(Medicine medicine, int quantity) {
        medicine.setQuantity(quantity);
        purchasedMedicines.add(medicine);
        System.out.println(username + " bought " + quantity + " units of " + medicine.getName());
    }

    public void generateBill() {
        Billing bill = new Billing(this, purchasedMedicines);
        bill.printBill();
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Password: " + password;
    }
}
