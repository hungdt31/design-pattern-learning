package concrete.light;

import interfaces.*;

/**
 * Lớp này tạo ra các thành phần giao diện theo chủ đề Light
 */
public class LightFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public TextField createTextField() {
        return new LightTextField();
    }

    @Override
    public Window createWindow() {
        return new LightWindow();
    }
    
    @Override
    public Calculator createCalculator() {
        return new LightCalculator();
    }
} 