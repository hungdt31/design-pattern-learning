# Strategy Pattern

## Khái niệm

**Strategy Pattern** là mẫu thiết kế hành vi cho phép định nghĩa một nhóm các thuật toán, đóng góp từng thuật toán lại, và làm cho chúng có thể hoán đổi cho nhau.

- Cho phép thuật toán biến đổi độc lập với cách khách hàng sử dụng nó.
- Tăng cường tính mô-đun và tái sử dụng của mã, bởi vì nó tách rời việc triển khai của các thuật toán từ các lớp sử dụng chúng.

## Cấu trúc của Strategy Pattern

![Strategy Pattern Structure](https://refactoring.guru/images/patterns/diagrams/strategy/structure.png)

1. **Context (Ngữ cảnh)**: Lưu trữ tham chiếu đến một Strategy cụ thể và giao tiếp với đối tượng này.
2. **Strategy (Chiến lược)**: Interface chung cho tất cả các chiến lược cụ thể.
3. **Concrete Strategies (Chiến lược cụ thể)**: Triển khai các thuật toán khác nhau mà Context có thể sử dụng.
4. **Client (Khách hàng)**: Tạo đối tượng Strategy cụ thể và truyền nó vào Context.

## Ưu điểm của Strategy Pattern

1. **Tính mở rộng**: Dễ dàng thêm các thuật toán mới mà không cần sửa đổi code hiện có.
2. **Tính linh hoạt**: Có thể thay đổi thuật toán tại runtime.
3. **Tách biệt**: Tách biệt code triển khai thuật toán khỏi code sử dụng nó.
4. **Nguyên tắc Open/Closed**: Tuân thủ nguyên tắc "mở để mở rộng, đóng để sửa đổi".
5. **Nguyên tắc Single Responsibility**: Mỗi chiến lược chỉ thực hiện một nhiệm vụ duy nhất.

## Ví dụ trong workspace: Tính điểm GPA

Trong workspace này, Strategy Pattern được áp dụng để tính toán điểm GPA theo các thang điểm khác nhau:

### Cấu trúc của mã nguồn:

1. **Context (GPAContext.java)**: Lớp ngữ cảnh chứa tham chiếu đến chiến lược tính GPA.

```java
public class GPAContext {
    private GPAStrategy strategy;
    
    public void setStrategy(GPAStrategy strategy) {
        this.strategy = strategy;
    }
    
    public float calculateGPA(List<Course> courses) {
        return strategy.calculateGPA(courses);
    }
}
```

2. **Strategy (GPAStrategy.java)**: Giao diện chung định nghĩa phương thức tính GPA.

```java
public interface GPAStrategy {
    float calculateGPA(List<Course> courses);
}
```

3. **Concrete Strategies**:
   - **GPAScale10.java**: Tính GPA theo thang điểm 10.
   - **GPAScale4.java**: Tính GPA theo thang điểm 4.

4. **Model (Course.java)**: Đại diện cho một môn học với thông tin cần thiết.

### Luồng thực thi:

1. Chương trình đọc danh sách môn học từ file `points.txt`.
2. Tạo đối tượng `GPAContext`.
3. Để tính GPA theo thang điểm 10:
   - Thiết lập chiến lược GPAScale10 cho context.
   - Gọi phương thức calculateGPA().
4. Để tính GPA theo thang điểm 4:
   - Thiết lập chiến lược GPAScale4 cho context.
   - Gọi phương thức calculateGPA().
5. Hiển thị kết quả trong giao diện người dùng.

### Ưu điểm của việc áp dụng Strategy Pattern trong ví dụ này:

1. **Dễ mở rộng**: Có thể dễ dàng thêm chiến lược tính điểm mới (ví dụ: GPAScale100 cho thang điểm 100) mà không cần sửa đổi code hiện có.
2. **Đóng gói thuật toán**: Mỗi chiến lược đóng gói một thuật toán tính điểm, làm cho code dễ hiểu và bảo trì.
3. **Linh hoạt trong runtime**: Có thể chuyển đổi giữa các chiến lược tính điểm khác nhau tại runtime.
4. **Tách biệt trách nhiệm**: Context không cần biết cách tính toán GPA, nó chỉ cần biết cách sử dụng Strategy.

## Kết luận

Strategy Pattern là một mẫu thiết kế rất hữu ích khi bạn cần xử lý các thuật toán khác nhau cho cùng một vấn đề, và muốn có khả năng thay đổi thuật toán một cách linh hoạt. Trong ví dụ về tính điểm GPA, mẫu thiết kế này cho phép dễ dàng mở rộng hệ thống để hỗ trợ các thang điểm khác nhau mà không cần thay đổi code của lớp GPAContext.
