package interfaces;

import javax.swing.JComponent;

/**
 * Interface TextField định nghĩa hành vi của trường nhập liệu trong giao diện
 */
public interface TextField {
    /**
     * Render trường nhập liệu và nút Edit/Cancel để chỉnh sửa tên
     * @return JComponent chứa trường nhập liệu và các nút điều khiển
     */
    JComponent render();
    
    /**
     * Thiết lập tên người dùng
     * @param name Tên người dùng mới
     */
    void setUserName(String name);
    
    /**
     * Lấy tên người dùng hiện tại
     * @return Tên người dùng
     */
    String getUserName();
} 