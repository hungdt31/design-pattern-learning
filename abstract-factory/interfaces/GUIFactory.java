package interfaces;

/**
 * Interface GUIFactory định nghĩa các phương thức tạo ra các thành phần giao diện
 * theo các chủ đề khác nhau (Light và Dark)
 */
public interface GUIFactory {
    Button createButton();
    TextField createTextField();
    Window createWindow();
    Calculator createCalculator();
    Label createLabel();
} 