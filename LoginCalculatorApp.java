import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginCalculatorApp {
    private static HashMap<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        // Initialize user database
        userDatabase.put("admin", "1234");
        userDatabase.put("user", "password");

        // Create the login frame
        JFrame loginFrame = new JFrame("Login System");
        loginFrame.setSize(300, 180);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel statusLabel = new JLabel(" ");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                    statusLabel.setText("Login successful!");
                    loginFrame.dispose(); // Close login frame
                    showCalculator(); // Show calculator
                } else {
                    statusLabel.setText("Invalid credentials.");
                }
            }
        });

        loginFrame.add(userLabel);
        loginFrame.add(userField);
        loginFrame.add(passLabel);
        loginFrame.add(passField);
        loginFrame.add(loginButton);
        loginFrame.add(statusLabel);

        loginFrame.setVisible(true);
    }

    private static void showCalculator() {
        // Create the calculator frame
        JFrame calculatorFrame = new JFrame("Simple Adder");
        calculatorFrame.setSize(250, 200);
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setLayout(new GridLayout(4, 2));

        JLabel num1Label = new JLabel("Number 1:");
        JTextField num1Field = new JTextField();
        JLabel num2Label = new JLabel("Number 2:");
        JTextField num2Field = new JTextField();
        JButton addButton = new JButton("Add");
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        // Add ActionListener to the button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    resultField.setText(String.valueOf(num1 + num2));
                } catch (NumberFormatException ex) {
                    resultField.setText("Invalid input");
                }
            }
        });

        // Add components to calculator frame
        calculatorFrame.add(num1Label);
        calculatorFrame.add(num1Field);
        calculatorFrame.add(num2Label);
        calculatorFrame.add(num2Field);
        calculatorFrame.add(addButton);
        calculatorFrame.add(resultLabel);
        calculatorFrame.add(resultField);

        // Make the calculator frame visible
        calculatorFrame.setVisible(true);
    }
}