import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginSystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login System");
        frame.setSize(300, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel statusLabel = new JLabel(" ");

        HashMap<String, String> userDatabase = new HashMap<>();
        userDatabase.put("admin", "1234");
        userDatabase.put("user", "password");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                    statusLabel.setText("Login successful!");
                } else {
                    statusLabel.setText("Invalid credentials.");
                }
            }
        });

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(statusLabel);

        frame.setVisible(true);
    }
}
