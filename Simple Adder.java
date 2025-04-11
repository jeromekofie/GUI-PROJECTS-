import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleAdder {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Simple Adder");
        frame.setSize(250, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        // Create components
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

        // Add components to frame
        frame.add(num1Label);
        frame.add(num1Field);
        frame.add(num2Label);
        frame.add(num2Field);
        frame.add(addButton);
        frame.add(resultLabel);
        frame.add(resultField);

        // Make the frame visible
        frame.setVisible(true);
    }
}