package shelpam.week10;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please input two integers and one operator");
        boolean ok = false;
        Scanner sc = new Scanner(System.in);
        while (!ok) {
            ok = true;
            try {
                int lhs = sc.nextInt();
                int rhs = sc.nextInt();
                char op = Calculator.parseOperator(sc.next());

                int result = Calculator.compute(lhs, rhs, op);

                System.out.println(result);
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e);
                System.out.println("Please re-input two integers and one operator");
                ok = false;
                sc.next();
            } catch (Exception e) {
                System.out.println("Error: " + e);
                System.out.println("Please re-input two integers and one operator");
                ok = false;
            }
        }

        new MainWindow();
    }
}
