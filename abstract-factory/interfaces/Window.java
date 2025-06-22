package interfaces;

import javax.swing.JFrame;

/**
 * Interface Window định nghĩa hành vi của cửa sổ trong giao diện
 */
public interface Window {
    JFrame render();
    String getTitle();
    void setTitle(String title);
} 