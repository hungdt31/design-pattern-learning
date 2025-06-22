import interfaces.*;
import javax.swing.*;
import java.awt.*;

/**
 * Lớp Application sử dụng các thành phần giao diện thông qua các interfaces
 * mà không cần quan tâm đến việc triển khai cụ thể (Light hay Dark)
 */
public class Application {
    private interfaces.TextField textField;
    private interfaces.Label label;
    private interfaces.Window window;
    private interfaces.Calculator calculator;
    private GUIFactory factory;
    private JFrame currentFrame;
    private String userName = "Nguyen Van A";

    public Application(GUIFactory factory) {
        this.factory = factory;
    }

    /**
     * Tạo giao diện người dùng với các thành phần từ factory
     */
    public void createUI() {
        textField = factory.createTextField();
        window = factory.createWindow();
        calculator = factory.createCalculator();

        // Thiết lập tên người dùng
        textField.setUserName(userName);

        // Lấy JFrame từ window
        JFrame frame = window.render();

        // Lấy panel chính từ frame để thêm các component vào
        Container contentPane = frame.getContentPane();

        // Tìm JPanel chính (là phần nội dung của cửa sổ)
        JPanel mainContent = null;
        if (contentPane instanceof JPanel) {
            mainContent = (JPanel) contentPane;
        } else {
            for (Component comp : contentPane.getComponents()) {
                if (comp instanceof JPanel
                        && ((BorderLayout) contentPane.getLayout()).getLayoutComponent(BorderLayout.CENTER) == comp) {
                    mainContent = (JPanel) comp;
                    break;
                }
            }
        }

        // Thay đổi layout của mainContent thành BorderLayout với khoảng cách
        if (mainContent != null) {
            mainContent.setLayout(new BorderLayout(20, 20));

            // Panel phía trên chứa các component cơ bản
            JPanel topPanel = new JPanel(new BorderLayout(10, 0));
            topPanel.setOpaque(false);

            // Panel chứa label hiển thị chào mừng
            JPanel greetingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            greetingPanel.setOpaque(false);
            label = factory.createLabel();
            greetingPanel.add(label.render());

            // Thêm các thành phần vào topPanel
            topPanel.add(greetingPanel, BorderLayout.WEST);
            topPanel.add(textField.render(), BorderLayout.CENTER);

            // Thêm panel phía trên và máy tính vào mainContent
            mainContent.add(topPanel, BorderLayout.NORTH);
            mainContent.add(calculator.render(), BorderLayout.CENTER);
        }

        this.currentFrame = frame;
    }

    /**
     * Hiển thị giao diện
     */
    public void showUI() {
        if (currentFrame != null) {
            currentFrame.setVisible(true);
        }
    }

    /**
     * Ẩn giao diện hiện tại
     */
    public void hideUI() {
        if (currentFrame != null) {
            currentFrame.setVisible(false);
            currentFrame.dispose();
        }
    }

    /**
     * Đổi giao diện và giữ nguyên tên người dùng
     */
    public void changeTheme(GUIFactory newFactory) {
        // Lưu tên người dùng trước khi đổi giao diện
        if (textField != null) {
            this.userName = textField.getUserName();
        }

        this.factory = newFactory;
        hideUI();
        createUI();
        showUI();

        // Tùy chỉnh thông báo dựa trên theme
        // if (newFactory instanceof concrete.dark.DarkFactory) {
        //     UIManager.put("OptionPane.background", new Color(50, 50, 50));
        //     UIManager.put("Panel.background", new Color(50, 50, 50));
        //     UIManager.put("OptionPane.messageForeground", Color.WHITE);
        // } else {
        //     UIManager.put("OptionPane.background", UIManager.getColor("Panel.background"));
        //     UIManager.put("Panel.background", UIManager.getColor("Panel.background"));
        //     UIManager.put("OptionPane.messageForeground", UIManager.getColor("Label.foreground"));
        // }

        // JOptionPane.showMessageDialog(currentFrame, "Theme conversion successful!");
    }
}