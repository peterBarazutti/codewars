import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolishCalc {
    private static List<String> operators = new ArrayList(Arrays.asList("+", "-", "*", "/"));

    public double evaluate(String expr) {
        List<String> exprArr = new ArrayList(Arrays.asList(expr.split(" ")));
        return singleOperation(exprArr);
    }

    private double singleOperation(List<String> exprArr) {
        if (exprArr.size() == 0) return 0;
        for (int i = 0; i < exprArr.size(); i++) {
            if (operators.contains(exprArr.get(i)) && isNumeric(exprArr.get(i-1)) && isNumeric(exprArr.get(i-2))) {
                exprArr.set(i-2, doCalc(exprArr.get(i), exprArr.get(i-1), exprArr.get(i-2)));
                exprArr.remove(i);
                exprArr.remove(i-1);
                singleOperation(exprArr);
                int asd;
            }
        }/*
        for (String str: exprArr) {
            System.out.println(str);
        }*/
        return Double.parseDouble(exprArr.get(0));
    }

    private String doCalc(String operator, String operand1, String operand2) {
        Double op1 = Double.parseDouble(operand1);
        Double op2 = Double.parseDouble(operand2);
        /*switch (operator) {
            case "+":
                return String.valueOf(op1 + op2);
            case "-":
                return String.valueOf(op1-op2);
            case "*":
                return String.valueOf(op1*op2);
            case "/":
                return String.valueOf(op1/op2);
        }*/
        return null;
    }

    private boolean isNumeric (String ch){
        try {
            Integer num = Integer.parseInt(ch);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
