//Calculator Program (Methods, Loops, and Conditionals) 

import java.util.Scanner;

public class Calculator {

    // static method for addition
    public double addition(double a, double b) {
        double sum = a + b;
        return sum;
    }

//non static method for subtraction
    public double subtraction(double a, double b) {
        double difference = a - b;
        return difference;
    }

//static method for Division
    public double division(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0;
        }
        double quotient = a / b;
        return quotient;
    }

    // Main method to run the calculator program
    public static void main(String[] args) {
        Scanner calculator = new Scanner(System.in);
        Calculator calc = new Calculator();
        int choice;

        do {
            
            System.out.println("\n--- Calculator Program Menu ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Division");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = calculator.nextInt();

            
            if (choice == 4) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            if (choice >= 1 && choice <= 3) {
                System.out.print("Enter first number: ");
                double a = calculator.nextDouble();
                System.out.print("Enter second number: ");
                double b = calculator.nextDouble();

                //Implement switch-case statements for menu selection
                switch (choice) {
                    case 1: 
                        double sum = calc.addition(a, b);
                        System.out.println("Result: " + a + " + " + b + " = " + sum);
                        break;

                    case 2: 
                        double diff = calc.subtraction(a, b);
                        System.out.println("Result: " + a + " - " + b + " = " + diff);
                        break;

                    case 3: 
                        double quotient = calc.division(a, b);
                        if (a != 0) { 
                            System.out.println("Result: " + a + " / " + b + " = " + quotient);
                        }
                        break;

                    default:
                        System.out.println("Invalid choice! Please select 1-4.");
                }
            } else {
                System.out.println("Invalid choice! Please select 1-4.");
            }
        } while (true); 

        calculator.close();
    }

    
}
