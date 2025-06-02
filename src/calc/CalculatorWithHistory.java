package calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorWithHistory
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> history = new ArrayList<>();
        double num1, num2, result;
        String operator;

        System.out.println("=== Calculator with History ===");
        System.out.println("Supported operations: +  -  *  /  %  ^  sqrt");
        System.out.println("Type 'history' to view past calculations.");
        System.out.println("Type 'exit' to quit.\n");

        while (true) {
            System.out.print("Enter first number (or 'exit'/'history'): ");
            String input1 = scanner.next();

            if (input1.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (input1.equalsIgnoreCase("history")) {
                if (history.isEmpty()) {
                    System.out.println("No history yet.");
                } else {
                    System.out.println("=== History ===");
                    for (String entry : history) {
                        System.out.println(entry);
                    }
                }
                continue;
            }

            try {
                num1 = Double.parseDouble(input1);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
                continue;
            }

            System.out.print("Enter operator (+, -, *, /, %, ^, sqrt): ");
            operator = scanner.next();

            if (operator.equalsIgnoreCase("sqrt")) {
                if (num1 < 0) {
                    System.out.println("Error: Cannot take square root of a negative number.");
                    continue;
                }
                result = Math.sqrt(num1);
                String entry = "sqrt(" + num1 + ") = " + result;
                history.add(entry);
                System.out.println("Result: " + result);
                continue;
            }

            System.out.print("Enter second number: ");
            String input2 = scanner.next();

            try {
                num2 = Double.parseDouble(input2);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
                continue;
            }

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                case "%":
                    result = num1 % num2;
                    break;
                case "^":
                    result = Math.pow(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operator.");
                    continue;
            }

            String entry = num1 + " " + operator + " " + num2 + " = " + result;
            history.add(entry);
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}
