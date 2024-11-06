package shelpam.week10;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainWindow extends JFrame {
    private JTextField lhs = new JTextField();
    private JTextField rhs = new JTextField();
    private JTextField op = new JTextField();
    private JLabel calculationResult = new JLabel("");

    public MainWindow() {
        super("Basic calculator"); // Name for the window.

        setSize(800, 600);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font f = lhs.getFont().deriveFont(32f);

        lhs.setFont(f);
        rhs.setFont(f);
        op.setFont(f);

        Dimension operandSize = new Dimension(200, 100);

        lhs.setPreferredSize(operandSize);
        rhs.setPreferredSize(operandSize);
        op.setPreferredSize(new Dimension(80, 80));

        var equalSign = new JLabel("=");
        equalSign.setFont(f);

        calculationResult.setFont(f);

        add(lhs);
        add(op);
        add(rhs);
        add(equalSign);
        add(calculationResult);

        KeyAdapter listener = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateCalculationResult();
            }
        };

        lhs.addKeyListener(listener);
        op.addKeyListener(listener);
        rhs.addKeyListener(listener);
    }

    private static class SignFormatException extends Exception {}

    private char parseOperator(String s) throws SignFormatException {
        if (s.length() != 1) {
            throw new SignFormatException();
        }

        String available = "+-*/";
        if (!available.contains(s)) {
            throw new SignFormatException();
        }
        return s.charAt(0);
    }

    private int calculateResult() throws SignFormatException {
        int lhs = Integer.parseInt(this.lhs.getText());
        char op = parseOperator(this.op.getText());
        int rhs = Integer.parseInt(this.rhs.getText());

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

    private void updateCalculationResult() {
        try {
            int result = calculateResult();
            calculationResult.setText(String.valueOf(result));
        } catch (SignFormatException e) {
            calculationResult.setText("");
        } catch (NumberFormatException e) {
            calculationResult.setText("");
        }
    }
}
