package concrete.dark;

import interfaces.Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Máy tính đơn giản với giao diện kiểu Dark
 */
public class DarkCalculator implements Calculator, ActionListener {
    private JPanel calculatorPanel;
    private JTextField display;
    private JTextField expressionDisplay; // Hiển thị phép tính
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton equButton, clrButton, decButton;
    private Font buttonFont;
    private Font displayFont;
    
    private double num1, num2, result;
    private char operator;
    private boolean startNewInput = true;
    private String currentExpression = "";
    
    public DarkCalculator() {
        // Khởi tạo fonts
        buttonFont = new Font("SansSerif", Font.PLAIN, 14);
        displayFont = new Font("SansSerif", Font.BOLD, 18);
        
        // Khởi tạo các giá trị ban đầu
        num1 = num2 = result = 0;
        operator = ' ';
    }
    
    @Override
    public JPanel render() {
        calculatorPanel = new JPanel();
        calculatorPanel.setLayout(new BorderLayout(5, 5));
        calculatorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        calculatorPanel.setBackground(new Color(40, 40, 40));
        
        // Panel chứa cả hai màn hình hiển thị
        JPanel displayPanel = new JPanel(new BorderLayout(0, 5));
        displayPanel.setBackground(new Color(40, 40, 40));
        
        // Phần hiển thị phép tính kiểu Dark
        expressionDisplay = new JTextField("");
        expressionDisplay.setFont(new Font("SansSerif", Font.PLAIN, 14));
        expressionDisplay.setHorizontalAlignment(JTextField.RIGHT);
        expressionDisplay.setEditable(false);
        expressionDisplay.setBackground(new Color(60, 63, 65));
        expressionDisplay.setForeground(new Color(180, 180, 180));
        expressionDisplay.setCaretColor(Color.WHITE);
        expressionDisplay.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(80, 80, 80), 1),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        
        // Phần hiển thị kết quả kiểu Dark
        display = new JTextField("0");
        display.setFont(displayFont);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(new Color(60, 63, 65));
        display.setForeground(new Color(230, 230, 230));
        display.setCaretColor(Color.WHITE);
        display.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(80, 80, 80), 1),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        
        // Thêm cả hai màn hình vào panel
        displayPanel.add(expressionDisplay, BorderLayout.NORTH);
        displayPanel.add(display, BorderLayout.CENTER);
        
        calculatorPanel.add(displayPanel, BorderLayout.NORTH);
        
        // Panel chứa các nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 8, 8));
        buttonPanel.setBackground(new Color(40, 40, 40));
        
        // Khởi tạo các nút số - kiểu Dark
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(buttonFont);
            numberButtons[i].setFocusPainted(false);
            numberButtons[i].setBackground(new Color(40, 40, 45));
            numberButtons[i].setForeground(new Color(250, 250, 250));
            numberButtons[i].setBorder(BorderFactory.createLineBorder(new Color(60, 60, 70), 1));
            numberButtons[i].addActionListener(this);
        }
        
        // Khởi tạo các nút chức năng
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        decButton = new JButton(".");
        
        // Đặt mảng các nút chức năng
        functionButtons = new JButton[] {
            addButton, subButton, mulButton, divButton, equButton, clrButton, decButton
        };
        
        // Thiết lập giao diện cho các nút chức năng kiểu Dark
        for (JButton button : functionButtons) {
            button.setFont(buttonFont);
            button.setFocusPainted(false);
            button.setBackground(new Color(45, 50, 55));
            button.setForeground(new Color(250, 250, 250));
            button.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 70), 1));
            button.addActionListener(this);
        }
        
        // Màu sắc đặc biệt cho Dark mode
        equButton.setBackground(new Color(0, 100, 175));
        equButton.setForeground(Color.WHITE);
        clrButton.setBackground(new Color(150, 50, 50));
        clrButton.setForeground(Color.WHITE);
        
        // Tạo JPanel trống cho các vị trí không cần nút
        JPanel emptyPanel1 = new JPanel();
        JPanel emptyPanel2 = new JPanel();
        JPanel emptyPanel3 = new JPanel();
        emptyPanel1.setBackground(new Color(40, 40, 40));
        emptyPanel2.setBackground(new Color(40, 40, 40));
        emptyPanel3.setBackground(new Color(40, 40, 40));
        
        // Thêm các nút vào panel theo thứ tự
        buttonPanel.add(clrButton);
        buttonPanel.add(emptyPanel1);
        buttonPanel.add(emptyPanel2);
        buttonPanel.add(divButton);
        
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(mulButton);
        
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(subButton);
        
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(addButton);
        
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(decButton);
        buttonPanel.add(emptyPanel3);
        buttonPanel.add(equButton);
        
        calculatorPanel.add(buttonPanel, BorderLayout.CENTER);
        
        return calculatorPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Xử lý cho các nút số
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                if (display.getText().equals("0") || startNewInput) {
                    display.setText(String.valueOf(i));
                    startNewInput = false;
                } else {
                    display.setText(display.getText() + i);
                }
                return;
            }
        }
        
        // Xử lý cho nút dấu thập phân
        if (e.getSource() == decButton) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
                startNewInput = false;
            }
        } 
        // Xử lý cho nút xóa
        else if (e.getSource() == clrButton) {
            display.setText("0");
            expressionDisplay.setText("");
            currentExpression = "";
            num1 = num2 = 0;
            operator = ' ';
            startNewInput = true;
        } 
        // Xử lý cho các phép toán
        else if (e.getSource() == addButton || e.getSource() == subButton || 
                e.getSource() == mulButton || e.getSource() == divButton) {
            
            // Lưu số đầu tiên và toán tử
            num1 = Double.parseDouble(display.getText());
            
            // Xác định toán tử
            if (e.getSource() == addButton) {
                operator = '+';
            } else if (e.getSource() == subButton) {
                operator = '-';
            } else if (e.getSource() == mulButton) {
                operator = '*';
            } else if (e.getSource() == divButton) {
                operator = '/';
            }
            
            // Cập nhật biểu thức hiển thị
            String displayNum = formatNumber(num1);
            String operatorSymbol = getOperatorSymbol(operator);
            
            // Nếu là phép tính mới
            if (currentExpression.isEmpty()) {
                currentExpression = displayNum + " " + operatorSymbol;
            } else {
                // Nếu đã có phép tính trước đó và đã nhấn =
                if (startNewInput && !expressionDisplay.getText().endsWith("=")) {
                    currentExpression = displayNum + " " + operatorSymbol;
                } else if (expressionDisplay.getText().endsWith("=")) {
                    // Nếu tiếp tục tính toán sau khi đã có kết quả
                    currentExpression = displayNum + " " + operatorSymbol;
                } else {
                    // Tính toán kết quả trung gian nếu đã có phép tính trước đó
                    num2 = Double.parseDouble(display.getText());
                    try {
                        calculateResult();
                        displayNum = formatNumber(result);
                        num1 = result; // Lưu kết quả làm số đầu tiên cho phép tính tiếp theo
                        currentExpression = displayNum + " " + operatorSymbol;
                    } catch (Exception ex) {
                        display.setText("Lỗi");
                        expressionDisplay.setText("Lỗi");
                        startNewInput = true;
                        return;
                    }
                }
            }
            
            expressionDisplay.setText(currentExpression);
            startNewInput = true;
        } 
        // Xử lý cho nút bằng
        else if (e.getSource() == equButton) {
            // Chỉ thực hiện khi đã có phép tính
            if (operator != ' ') {
                num2 = Double.parseDouble(display.getText());
                
                // Cập nhật biểu thức hiển thị
                String displayNum2 = formatNumber(num2);
                String fullExpression = currentExpression + " " + displayNum2 + " =";
                expressionDisplay.setText(fullExpression);
                
                try {
                    calculateResult();
                    
                    // Hiển thị kết quả
                    if (result == (int)result) {
                        display.setText(String.valueOf((int)result));
                    } else {
                        display.setText(String.valueOf(result));
                    }
                    
                } catch(Exception ex) {
                    display.setText("Lỗi");
                    expressionDisplay.setText("Lỗi");
                }
                
                startNewInput = true;
            }
        }
    }
    
    /**
     * Tính toán kết quả dựa trên toán tử và hai số
     */
    private void calculateResult() throws ArithmeticException {
        switch(operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Chia cho 0");
                }
                result = num1 / num2;
                break;
        }
    }
    
    /**
     * Lấy ký hiệu toán tử để hiển thị
     */
    private String getOperatorSymbol(char op) {
        switch(op) {
            case '+': return "+";
            case '-': return "-";
            case '*': return "×";
            case '/': return "÷";
            default: return "";
        }
    }
    
    /**
     * Định dạng số để hiển thị (loại bỏ .0 nếu là số nguyên)
     */
    private String formatNumber(double number) {
        if (number == (int)number) {
            return String.valueOf((int)number);
        } else {
            return String.valueOf(number);
        }
    }
} 