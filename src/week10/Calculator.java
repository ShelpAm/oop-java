package shelpam.week10;

class SignFormatException extends Exception {}

public class Calculator {
    static char parseOperator(String s) throws SignFormatException {
        if (s.length() != 1) {
            throw new SignFormatException();
        }

        String available = "+-*/";
        if (!available.contains(s)) {
            throw new SignFormatException();
        }
        return s.charAt(0);
    }

    public static int compute(int lhs, int rhs, char op) {
        if (op == '+') {
            return lhs + rhs;
        } else if (op == '-') {
            return lhs - rhs;
        } else if (op == '*') {
            return lhs * rhs;
        } else if (op == '/') {
            return lhs / rhs;
        }

        return -1; // Unreachable
    }
}
