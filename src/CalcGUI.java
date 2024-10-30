import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcGUI {

    private JTextField textField;
    private int[] values;
    private String operator;

    public CalcGUI() {
        values = new int[2];
    }

    public void setGUI() {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(28,28,28));

        textField = new JTextField();
        frame.add(textField,BorderLayout.NORTH);
        textField.setBackground(new Color(28,28,28));
        textField.setForeground(new Color(212,212,210));
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setFont(new Font("Arial", Font.PLAIN, 32));

        JPanel buttonPanel = new JPanel(new GridLayout(4,4));

        String[] buttons = {"7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0"," ","=","+"};

        for (String text : buttons) {
            JButton button = new JButton(text);
            buttonPanel.add(button);
            button.setBackground(new Color(80,80,80));
            button.setForeground(new Color(212,212,210));
            button.setBorderPainted(false);

            if (button.getText().equals("+") || button.getText().equals("-") || button.getText().equals("*") || button.getText().equals("/")) {
                button.setBackground(new Color(255,149,0));
            }

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String buttonText = e.getActionCommand();

                    if(buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")){
                        operator = buttonText;
                        values[0] = (Integer.parseInt(textField.getText()));
                        textField.setText("");
                    } else if(buttonText.equals("=")){
                        values[1] = (Integer.parseInt(textField.getText()));
                        int result = calculate(values[0], values[1], operator);
                        textField.setText(String.valueOf(result));
                    } else {
                        textField.setText(textField.getText() + buttonText);
                    }

                }
            });
        }

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public Integer calculate(int a, int b, String operator) {

        switch(operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default :
                return null;
        }
    }

}
