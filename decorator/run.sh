#!/bin/bash

# Tên file Java (không có phần mở rộng .java)
JAVA_FILE=$1 # Tham số đầu tiên

# Biên dịch file Java vào thư mục ./target
javac -d ./target $JAVA_FILE.java

# Kiểm tra xem file có biên dịch thành công không
if [ $? -eq 0 ]; then
  # Chạy file Java đã biên dịch
  java -cp "./target" $JAVA_FILE
else
  echo "Biên dịch thất bại. Vui lòng kiểm tra lại mã nguồn."
fi