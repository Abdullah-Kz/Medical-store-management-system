/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacymanagementsystem;

/**
 *
 * @author abdul
 */
import java.io.*;
import java.util.*;


public class Admin extends User {
    private List<User> users;
    private List<Medicine> medicines;

    public Admin(String username, String password) {
        super(username, password);
        users = new ArrayList<>();
        medicines = new ArrayList<>();
    }

    public boolean authenticate(String username, String password) {
        return getUsername().equals(username) && getPassword().equals(password);
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    public void deleteUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
        saveUsers();
    }

    public void updateUserPassword(String username, String newPassword) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.setPassword(newPassword);
                saveUsers();
                return;
     }
     }
    }

    public User getUser(String username) {
     for (User user : users) {
       if (user.getUsername().equals(username)) {
       return user;
     }
      }
        return null;
    }

    public List<Medicine> getMedicines() {
   return medicines;
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
        saveMedicines();
    }

    public void deleteMedicine(String name) {
        medicines.removeIf(medicine -> medicine.getName().equals(name));
        saveMedicines();
    }

    public void saveUsers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("users.txt"))) {
            for (User user : users) {
                writer.println(user.getUsername() + "," + user.getPassword());
    }
    } catch (IOException e) {
            e.printStackTrace();
    }
    }

    public void loadUsers() {
        users.clear();
        File file = new File("users.txt");
        if (!file.exists()) {
       try {
                file.createNewFile();
      } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new User(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveMedicines() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("medicines.txt"))) {
            for (Medicine medicine : medicines) {
                writer.println(medicine.getName() + "," + medicine.getPrice() + "," + medicine.getQuantity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMedicines() {
        medicines.clear();
        File file = new File("medicines.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    medicines.add(new Medicine(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
