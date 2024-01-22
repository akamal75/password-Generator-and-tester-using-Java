import javax.swing.*;
import java.awt.*;
public class PasswordGeneratorUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField passwordLengthField;
    private JCheckBox uppercaseCheckbox;
    private JCheckBox lowercaseCheckbox;
    private JCheckBox digitsCheckbox;
    private JCheckBox specialCharsCheckbox;
    private JTextField generatedPasswordField;
    private JTextField testPasswordField;
    private JLabel testResultLabel;

    public PasswordGeneratorUI() {
        // Create the UI components

        frame = new JFrame("Password Generator and Tester");
        panel = new JPanel();
        passwordLengthField = new JTextField("");
        uppercaseCheckbox = new JCheckBox("Uppercase Letters");
        lowercaseCheckbox = new JCheckBox("Lowercase Letters");
        digitsCheckbox = new JCheckBox("Digits");
        specialCharsCheckbox = new JCheckBox("Special Characters");
        generatedPasswordField = new JTextField();
        testPasswordField = new JTextField();
        testResultLabel = new JLabel();

        // Add the UI components to the panel

        panel.setLayout(new GridLayout(0, 1));
        panel.add(new JLabel("Password Length:"));
        panel.add(passwordLengthField);
        panel.add(new JLabel("Password Complexity:"));
        panel.add(uppercaseCheckbox);
        panel.add(lowercaseCheckbox);
        panel.add(digitsCheckbox);
        panel.add(specialCharsCheckbox);
        
        panel.add(new JButton("Generate Password") {{
            addActionListener(e -> {
                int length = Integer.parseInt(passwordLengthField.getText());
                boolean uppercase = uppercaseCheckbox.isSelected();
                boolean lowercase = lowercaseCheckbox.isSelected();
                boolean digits = digitsCheckbox.isSelected();
                boolean specialChars = specialCharsCheckbox.isSelected();
                String password = PasswordGenerator.generatePassword(length, uppercase, lowercase, digits, specialChars); //Password Generator
                generatedPasswordField.setText(password);
            });
        }});
        panel.add(new JLabel("Generated Password:"));
        panel.add(generatedPasswordField);

        panel.add(new JLabel("Test Password:"));
        panel.add(testPasswordField);

        panel.add(new JButton("Test Password") {{
            addActionListener(e -> {
                String password = testPasswordField.getText();
                boolean result = PasswordTester.testPassword(password); //PasswordTester 
                if (result) {
                    testResultLabel.setText("  Strong Password ");
                } 
                else {
                    testResultLabel.setText("  Weak Password!  ");
                }
            });
        }});
        panel.add(testResultLabel);

        // Set up the frame

        frame.setContentPane(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PasswordGeneratorUI();
    }
}


