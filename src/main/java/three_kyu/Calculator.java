package three_kyu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static Double evaluate(String expression) {
        return Double.valueOf(evaluateIter(expression));
    }

    private static String evaluateIter(String expression) {
        String result = "";
        String parenthesis = "([\\(](?!(.*\\()).*?[\\)])";
        Pattern parenthesisPattern = Pattern.compile(parenthesis);
        Matcher priorityGroupOne = parenthesisPattern.matcher(expression);

        while (priorityGroupOne.find()) {
            String temp = priorityGroupOne.group(1);
            temp = temp.substring(1, temp.length() - 1);
            String expResult = evaluateIter(temp);
            StringBuilder sb = new StringBuilder(expression);
            expression = sb.replace(priorityGroupOne.start(), priorityGroupOne.end(), expResult).toString();
            expression = expression.replaceAll("\\-\\-|\\+\\+","");
            expression = expression.replaceAll("\\+\\-|\\-\\+","-");
            priorityGroupOne = parenthesisPattern.matcher(expression);
        }

        String multiplicationDivision = "([-]*\\d+[.]*\\d*[E]*\\d*)\\s*([*|/])\\s*([-]*\\d+[.]*\\d*[E]*\\d*)";
        Pattern multiplicationDivisionPattern = Pattern.compile(multiplicationDivision);
        Matcher priorityGroupTwo = multiplicationDivisionPattern.matcher(expression);

        String additionSubtraction = "([-]*\\d+[.]*\\d*[E]*\\d*)\\s*([+|-])\\s*([-]*\\d+[.]*\\d*[E]*\\d*)";
        Pattern additionSubtractionPattern = Pattern.compile(additionSubtraction);
        Matcher priorityGroupThree = additionSubtractionPattern.matcher(expression);

        if (priorityGroupTwo.find()) {
            double operand1 = Double.parseDouble(priorityGroupTwo.group(1));
            double operand2 = Double.parseDouble(priorityGroupTwo.group(3));
            String operator = priorityGroupTwo.group(2);

            double newValue = calculate(operand1, operand2, operator);
            StringBuilder sb = new StringBuilder(expression);
            sb.replace(priorityGroupTwo.start(), priorityGroupTwo.end(), String.valueOf(newValue));
            result = evaluateIter(sb.toString());
        } else if (priorityGroupThree.find()) {
            double operand1 = Double.parseDouble(priorityGroupThree.group(1));
            double operand2 = Double.parseDouble(priorityGroupThree.group(3));
            String operator = priorityGroupThree.group(2);

            double newValue = calculate(operand1, operand2, operator);
            StringBuilder sb = new StringBuilder(expression);
            sb.replace(priorityGroupThree.start(), priorityGroupThree.end(), String.valueOf(newValue));
            result = evaluateIter(sb.toString());
        } else {
            result = expression;
        }

        return result;
    }

    private static double calculate(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
        }
        return 0;
    }
}
