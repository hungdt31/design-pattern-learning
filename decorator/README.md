# Decorator

## Mục tiêu

- Là mẫu thiết kết cấu trúc (structural design pattern) cho phép bạn đính kèm các hành vi mới vào các đối tượng bằng cách đặt các đối tượng này bên trong các đối tượng bao bọc đặc biệt có chứa các hành vi đó.

![Ảnh minh họa](/decorator/images/1.bmp)

## Vấn đề

Mở rộng phương thức theo cách tĩnh có nhiều bất cập:
- Ta thường mở rộng phương thức cho một đối tượng bằng cách kế thừa, cần phải triển khai code để mở rộng lớp có sẵn và viết lại (overide) các phương thức của lớp đó.
- Cho lớp cơ sở:
```c++
public class Coffee {
  public String getDescription() {
    return "Coffee";
  }

  public double cost() {
    return 5.0;
  }
}
```

- Các lớp kế thừa:
```c++
public class Espresso extends Coffee {
  @Override
  public String getDescription() {
    return "Espresso";
  }

  @Override
  public double cost() {
    return 6.0;
  }
}

public class Latte extends Coffee {
  @Override
  public String getDescription() {
    return "Latte";
  }

  @Override
  public double cost() {
    return 7.0;
  }
}
```

- Khi bạn muốn thêm một loại cà phê mới, bạn phải tạo một lớp mới và viết lại phương thức của lớp cơ sở.

- Nếu có nhiều loại cà phê với các thành phần thêm vào khác nhau, bạn sẽ gặp khó khăn trong việc quản lý mã nguồn và mở rộng.

## Giải pháp

Mở rộng theo cách linh động là chúng ta sẽ cung cấp một cơ cấu mà cơ cấu này cho phép chúng ta thay đổi một đối tượng đã tồn tại nhưng không làm ảnh hưởng đến các đối tượng khác của cùng lớp đó.

**Decorator Pattern:** Sử dụng mô hình Decorator để thêm các chức năng mới cho các đối tượng mà không cần phải thay đổi các lớp cơ sở hoặc tạo nhiều lớp con.

## Thực thi

Những thành phần trong mẫu thiết kế Decorator:

- **Component:** giao diện (interface) chung để các đối tượng cần thêm chức năng trong quá trình chạy thì triển khai giao diện này.

- **ConcreteComponent:** Một cài đặt cho giao diện Component mà nó định nghĩa một đối tượng cần thêm các chức năng trong quá trình chạy.

- **Decorator:** một lớp trừu tượng dùng để duy trì một tham chiếu của đối tượng thành phần và đồng thời cài đặt các thành phần của giao diện.

- **ConcreteDecorator:** Một cài đặt của Decorator, nó cài đặt thêm các thành phần vào đầu của các đối tượng thành phần.

Class Diagram về thiết kế MilkTea:

![Decorator Diagram](/decorator/images/diagram.png)

## Tài liệu tham khảo

[https://refactoring.guru/design-patterns/decorator](https://refactoring.guru/design-patterns/decorator)

[https://viblo.asia/p/hieu-biet-co-ban-ve-decorator-pattern-pVYRPjbVG4ng](https://viblo.asia/p/hieu-biet-co-ban-ve-decorator-pattern-pVYRPjbVG4ng)

[Decorator Design Pattern: Phân tích và ví dụ](https://www.youtube.com/watch?v=to5yJ54AxOg)

[Decorator Design Pattern: Thiết kế Class Diagram](https://www.youtube.com/watch?v=MpteSKnnDZc)

[Decorator Design Pattern: Áp dụng vào code, thử vài trường hợp (C#)](https://www.youtube.com/watch?v=U2XUrAefHME&t=612s)
