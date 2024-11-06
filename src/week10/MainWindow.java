package shelpam.week10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainWindow extends JFrame {
    private JTextField lhs = new JTextField();
    private JTextField rhs = new JTextField();
    private JTextField op = new JTextField();
    private JTextField calculationResult = new JTextField();

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
        calculationResult.setPreferredSize(operandSize);

        var equalSign = new JButton("=");
        equalSign.setFont(f);

        calculationResult.setFont(f);
        // calculationResult.setEnabled(false); // Because setEnable(false)
        // makes foreground color permanently grey, we don't use this. As a
        // replacement, setEditable is suitable.
        calculationResult.setEditable(false);
        calculationResult.setBackground(Color.WHITE); // setEditable makes
        // background color grey (or transparent; I didn't notice).


        add(lhs);
        add(op);
        add(rhs);
        add(equalSign);
        add(calculationResult);

        equalSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCalculationResult();
            }
        });
        // This may be better, because it don't require user to click on the
        // button. As opposed to it, the following code automatically update the
        // result when some key released.

        // KeyAdapter listener = new KeyAdapter() {
        //     @Override
        //     public void keyReleased(KeyEvent e) {
        //         updateCalculationResult();
        //     }
        // };

        // lhs.addKeyListener(listener);
        // op.addKeyListener(listener);
        // rhs.addKeyListener(listener);

    }

    private int calculateResult() throws SignFormatException {
        int lhs = Integer.parseInt(this.lhs.getText());
        char op = Calculator.parseOperator(this.op.getText());
        int rhs = Integer.parseInt(this.rhs.getText());

        return Calculator.compute(lhs, rhs, op);
    }

    private void updateCalculationResult() {
        try {
            int result = calculateResult();
            calculationResult.setText(String.valueOf(result));
        } catch (SignFormatException e) {
            calculationResult.setText("");
        } catch (NumberFormatException e) {
            calculationResult.setText("");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
