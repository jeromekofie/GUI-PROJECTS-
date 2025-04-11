import java.awt.*;
import java.io.*;
import javax.swing.*;

public class StudentDatabaseApp extends JFrame {
    private static final String FILE_PATH = "students.txt"; // File to store student data
    
    private JTextField idField, nameField;
    private JTextArea outputArea;
    
    public StudentDatabaseApp() {
        setTitle("Student Database Manager");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        inputPanel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        inputPanel.add(idField);
        
        inputPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        
        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(e -> insertStudent());
        inputPanel.add(addButton);
        
        JButton deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(e -> deleteStudent());
        inputPanel.add(deleteButton);
        
        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private void insertStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            
            // Write to file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                writer.write(id + "," + name);
                writer.newLine();
                outputArea.append("✓ Student " + name + " (ID: " + id + ") added successfully\n");
            }
        } catch (NumberFormatException e) {
            outputArea.append("✗ Invalid ID format. Please enter a number.\n");
        } catch (IOException e) {
            outputArea.append("✗ File error: " + e.getMessage() + "\n");
        }
    }
    
    private void deleteStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            File inputFile = new File(FILE_PATH);
            File tempFile = new File("temp.txt");
            
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                String line;
                boolean found = false;
                
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (Integer.parseInt(parts[0]) != id) {
                        writer.write(line);
                        writer.newLine();
                    } else {
                        found = true;
                    }
                }
                
                if (found) {
                    outputArea.append("✓ Student with ID " + id + " deleted successfully\n");
                } else {
                    outputArea.append("✗ No student found with ID " + id + "\n");
                }
            }
            
            // Delete the original file and rename the temp file
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (NumberFormatException e) {
            outputArea.append("✗ Invalid ID format. Please enter a number.\n");
        } catch (IOException e) {
            outputArea.append("✗ File error: " + e.getMessage() + "\n");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentDatabaseApp();
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}