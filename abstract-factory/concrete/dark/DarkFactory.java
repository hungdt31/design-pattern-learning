package concrete.dark;

import interfaces.*;

/**
 * Lớp này tạo ra các thành phần giao diện theo chủ đề Dark
 */
public class DarkFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public TextField createTextField() {
        return new DarkTextField();
    }

    @Override
    public Window createWindow() {
        return new DarkWindow();
    }
    
    @Override
    public Calculator createCalculator() {
        return new DarkCalculator();
    }

    @Override
    public Label createLabel() {
        return new DarkLabel();
    }
} 