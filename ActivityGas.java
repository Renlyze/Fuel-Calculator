import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ActivityGas extends JFrame {

    // Constants for gas prices...
    private static final double unleadedPrice = 63.25;
    private static final double premiumPrice = 64.75;
    private static final double vpowerGasPrice = 66.03;
    private static final double dieselPrice = 57.80;
    private static final double vpowerDieselPrice = 61.45;
    private static final double kerosenePrice = 45.07;

    // Components...
    private JComboBox<String> OPTIONS;
    private JTextField costPerLiter;
    private JTextField totalAmount;
    private JTextField discountTextField;
    private JTextField discountedTotal;
    private JTextField totalLiters;
    private JButton enterButton;
    private JButton exitButton;
    private JButton clearButton;
    private JPanel mainPanel;

    // Constructor...
    public ActivityGas() {
        // Setting up the main frame...
        setContentPane(mainPanel);
        setTitle("Gas Station");
        setSize(750, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Initialize the combo box...
        OPTIONS.setSelectedIndex(0);

        // Action listener for enterButton...
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validation for empty text field...
                String textFieldValue = totalAmount.getText();
                if (textFieldValue.isEmpty()) {
                    JOptionPane.showMessageDialog(ActivityGas.this, "Text field cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        double numericValue = Double.parseDouble(textFieldValue);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(ActivityGas.this, "Invalid numeric format.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                // Main calculation logic...
                double amount = Double.parseDouble(totalAmount.getText());
                double priceofGas = getPrice();
                double liters = amount / priceofGas;
                totalLiters.setText(String.format("%.2f", liters));

                double discount = 0;
                if (liters >= 30) {
                    discount = amount * 0.09;
                } else if (liters >= 20) {
                    discount = amount * 0.07;
                } else if (liters >= 10) {
                    discount = amount * 0.05;
                }
                discountTextField.setText(String.format("%.2f", discount));
                double totalCost = amount - discount;
                discountedTotal.setText(String.format("%.2f", totalCost));
                costPerLiter.setText(String.format("%.2f", priceofGas));
            }
        });

        // Action listener for clearButton...
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clearing the text fields...
                OPTIONS.setSelectedIndex(0);
                totalAmount.setText("");
                totalLiters.setText("");
                discountTextField.setText("");
                totalLiters.setText("");
                costPerLiter.setText("");
                discountedTotal.setText("");
                OPTIONS.setSelectedIndex(0);
            }
        });

        // Action listener for exitButton...
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exiting the application...
                System.exit(0);
            }
        });

        // Action listener for OPTIONS combo box...
        OPTIONS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update text fields based on the selected option...
                updateTextField();
            }
        });
    }

    // Method to update the costPerLiter text field based on the selected option...
    private void updateTextField() {
        String selectedOption = (String) OPTIONS.getSelectedItem();
        if ("Unleaded".equals(selectedOption)) {
            costPerLiter.setText("62.25");
        } else if ("Premium".equals(selectedOption)) {
            costPerLiter.setText("64.75");
        } else if ("Vpower Gas".equals(selectedOption)) {
            costPerLiter.setText("66.03");
        } else if ("Diesel".equals(selectedOption)) {
            costPerLiter.setText("57.80");
        } else if ("Vpower Diesel".equals(selectedOption)) {
            costPerLiter.setText("61.45");
        } else if ("Kerosene".equals(selectedOption)) {
            costPerLiter.setText("45.07");
        }
    }

    // Method to get the price based on the selected option...
    private double getPrice() {
        switch (OPTIONS.getSelectedIndex()) {
            case 0:
                return unleadedPrice;
            case 1:
                return premiumPrice;
            case 2:
                return vpowerGasPrice;
            case 3:
                return dieselPrice;
            case 4:
                return vpowerDieselPrice;
            case 5:
                return kerosenePrice;
            default:
                throw new IllegalArgumentException("Invalid gasoline type selected");
        }
    }

    // Main method to run the application...
    public static void main(String[] args) {
        ActivityGas active = new ActivityGas();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setForeground(new Color(-11648795));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("BankGothic Lt BT", -1, 31, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-10331931));
        label1.setText("GAS STATION");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("BankGothic Lt BT", -1, -1, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Cost Per Liter");
        panel2.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        costPerLiter = new JTextField();
        costPerLiter.setEditable(false);
        costPerLiter.setText("");
        panel2.add(costPerLiter, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        totalAmount = new JTextField();
        panel2.add(totalAmount, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("BankGothic Lt BT", -1, 14, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Total Liters");
        panel2.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        totalLiters = new JTextField();
        totalLiters.setEditable(false);
        panel2.add(totalLiters, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("BankGothic Lt BT", -1, 14, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setText("Amount");
        panel2.add(label4, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        OPTIONS = new JComboBox();
        OPTIONS.setEditable(false);
        OPTIONS.setEnabled(true);
        Font OPTIONSFont = this.$$$getFont$$$("BankGothic Md BT", -1, 15, OPTIONS.getFont());
        if (OPTIONSFont != null) OPTIONS.setFont(OPTIONSFont);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("");
        defaultComboBoxModel1.addElement("Unleaded");
        defaultComboBoxModel1.addElement("Premium");
        defaultComboBoxModel1.addElement("Vpower Gas");
        defaultComboBoxModel1.addElement("Diesel");
        defaultComboBoxModel1.addElement("Vpower Diesel");
        defaultComboBoxModel1.addElement("Kereosene");
        OPTIONS.setModel(defaultComboBoxModel1);
        OPTIONS.setVisible(true);
        mainPanel.add(OPTIONS, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        enterButton = new JButton();
        Font enterButtonFont = this.$$$getFont$$$("BankGothic Md BT", -1, 14, enterButton.getFont());
        if (enterButtonFont != null) enterButton.setFont(enterButtonFont);
        enterButton.setText("Enter");
        mainPanel.add(enterButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$("BankGothic Lt BT", -1, 14, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setText("Discounted Total:");
        panel3.add(label5, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("BankGothic Lt BT", -1, 14, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setText("Discount");
        panel3.add(label6, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        discountTextField = new JTextField();
        discountTextField.setEditable(false);
        discountTextField.setText("");
        panel3.add(discountTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        discountedTotal = new JTextField();
        discountedTotal.setEditable(false);
        discountedTotal.setText("");
        panel3.add(discountedTotal, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        clearButton = new JButton();
        Font clearButtonFont = this.$$$getFont$$$("BankGothic Lt BT", -1, 14, clearButton.getFont());
        if (clearButtonFont != null) clearButton.setFont(clearButtonFont);
        clearButton.setText("Clear");
        mainPanel.add(clearButton, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        exitButton = new JButton();
        Font exitButtonFont = this.$$$getFont$$$("BankGothic Lt BT", -1, 14, exitButton.getFont());
        if (exitButtonFont != null) exitButton.setFont(exitButtonFont);
        exitButton.setText("Exit");
        mainPanel.add(exitButton, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}


