import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;

public class MainFrame extends JFrame {
    private JTextField tfName, tfEmail, tfPhone, tfAddress;
    private JButton btnAdd, btnClear, btnDelete;
    private JTable tableClients;
    private DefaultTableModel model;

    public MainFrame() {
        initComponents();
        loadData();
    }

    private void initComponents() {
        // Initialize components and layout
        // Add action listeners for buttons
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClient();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteClient();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                saveData();
            }
        });
    }

    private void addClient() {
        if (tfName.getText().isEmpty() || tfEmail.getText().isEmpty() || 
            tfPhone.getText().isEmpty() || tfAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }
        model.addRow(new Object[]{tfName.getText(), tfEmail.getText(), 
                                  tfPhone.getText(), tfAddress.getText()});
        clearFields();
    }

    private void clearFields() {
        tfName.setText("");
        tfEmail.setText("");
        tfPhone.setText("");
        tfAddress.setText("");
    }

    private void deleteClient() {
        int selectedRow = tableClients.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to delete!");
        }
    }

    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clients.dat"))) {
            Vector<Vector> data = model.getDataVector();
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clients.dat"))) {
            Vector<Vector> data = (Vector<Vector>) ois.readObject();
            for (Vector row : data) {
                model.addRow(row);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}