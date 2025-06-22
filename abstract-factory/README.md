# Mẫu Thiết Kế Abstract Factory với Light và Dark Mode

Đây là ứng dụng Java minh họa mẫu thiết kế Abstract Factory, cho phép người dùng chuyển đổi trực quan giữa giao diện Light và Dark mode. Ứng dụng có chức năng máy tính đơn giản với các phép tính cơ bản và quản lý tên người dùng.

## Cấu trúc của dự án

- **interfaces/**: Chứa các giao diện định nghĩa các thành phần UI
  - `GUIFactory.java`: Factory chính để tạo các thành phần UI
  - `Button.java`: Giao diện cho nút, trả về JComponent
  - `TextField.java`: Giao diện cho trường nhập liệu tên người dùng, trả về JComponent
  - `Window.java`: Giao diện cho cửa sổ, trả về JFrame
  - `Calculator.java`: Giao diện cho máy tính, trả về JPanel

- **concrete/light/**: Các lớp triển khai cho giao diện Light Mode
  - `LightFactory.java`: Factory tạo các thành phần UI Light
  - `LightButton.java`: Triển khai nút kiểu Light
  - `LightTextField.java`: Triển khai trường nhập tên kiểu Light
  - `LightWindow.java`: Triển khai cửa sổ kiểu Light
  - `LightCalculator.java`: Triển khai máy tính kiểu Light

- **concrete/dark/**: Các lớp triển khai cho giao diện Dark Mode
  - `DarkFactory.java`: Factory tạo các thành phần UI Dark
  - `DarkButton.java`: Triển khai nút kiểu Dark
  - `DarkTextField.java`: Triển khai trường nhập tên kiểu Dark
  - `DarkWindow.java`: Triển khai cửa sổ kiểu Dark
  - `DarkCalculator.java`: Triển khai máy tính kiểu Dark

- **Application.java**: Lớp chính sử dụng GUIFactory để tạo và hiển thị giao diện Swing
- **Main.java**: Entry point của ứng dụng với giao diện đồ họa cho phép người dùng chuyển đổi giao diện

## Chức năng chính

### Quản lý tên người dùng

- Hiển thị tên người dùng trong trường văn bản
- Nút "Edit" cho phép chỉnh sửa tên
- Nút "Cancel" để hủy bỏ chỉnh sửa và khôi phục tên cũ
- Lưu và hiển thị tên người dùng
- Tên người dùng được lưu giữ khi chuyển đổi giữa các chủ đề

### Máy tính đơn giản

Ứng dụng máy tính đơn giản cung cấp các phép tính cơ bản:

- Cộng (+)
- Trừ (-)
- Nhân (×)
- Chia (÷)
- Hỗ trợ số thập phân
- Hiển thị lỗi khi chia cho 0

## Cách chạy

```bash
# Biên dịch và chạy ứng dụng
bash run.sh Main
```

## Sơ đồ lớp

```[txt]
                              +-------------+
                              | GUIFactory  |
                              +-------------+
                              | createButton|
                              | createField |
                              | createWindow|
                              |createCalc   |
                              +------+------+
                                     ^
                                     |
                  +------------------+------------------+
                  |                                     |
         +----------------+                   +----------------+
         |  LightFactory  |                   |  DarkFactory   |
         +----------------+                   +----------------+
         | createButton   |                   | createButton   |
         | createField    |                   | createField    |
         | createWindow   |                   | createWindow   |
         | createCalc     |                   | createCalc     |
         +-------+--------+                   +-------+--------+
                 |                                    |
 +----------------+---------------+    +----------------+---------------+
 |        |            |          |    |        |            |          |
+------+  +------+  +------+  +------+ +------+ +------+  +------+  +------+
|Light |  |Light |  |Light |  |Light | | Dark | | Dark |  | Dark |  | Dark |
|Window|  |Button|  |Field |  |Calc  | |Window| |Button|  |Field |  | Calc |
+------+  +------+  +------+  +------+ +------+ +------+  +------+  +------+
```

## Tính năng

- Chuyển đổi giao diện thời gian thực giữa Light và Dark mode
- Hiển thị cửa sổ, nút, và trường văn bản theo hai chủ đề khác nhau
- Chức năng chỉnh sửa tên người dùng với nút Edit và Cancel
- Máy tính đơn giản với các phép tính cơ bản tuân theo phong cách giao diện
- Thiết kế mẫu Abstract Factory cho phép thêm các chủ đề mới dễ dàng
