//Part 2: Factorial Program (Recursion)
/*Problem Statement:
Design a Java program that computes the **factorial** of a given non-negative 
integer using recursion.Factorial is defined as: n! = n×(n−1)×(n−2)×...×1
Input: 5
Output: 5! = 120
 */

import java.util.Scanner;

public class FactorialCalculator {

    static long factorial(int n) {

        // Base Case: If `n == 0` or `n == 1`, return `1`
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive case: n * factorial(n-1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prompt the user for a non-negative integer:");
        int n = scanner.nextInt();

        // Validate the input (reject negative numbers)
        if (n < 0) {
            System.out.println("Error: Factorial is not defined for negative numbers.");
        } else {
            // a recursive function to compute the factorial
            long ans = factorial(n);
            System.out.println(n + "! = " + ans);
        }

        scanner.close();
    }
}
