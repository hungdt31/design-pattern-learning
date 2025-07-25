#!/bin/bash

# --- Màu sắc ---
GREEN="\033[1;32m"
YELLOW="\033[1;33m"
CYAN="\033[1;36m"
RED="\033[1;31m"
RESET="\033[0m"

# --- Bước 1: Lấy danh sách thư mục ---
ignore=(".git" ".idea" ".vscode")
folders=()
while IFS= read -r -d '' dir; do
  name="$(basename "$dir")"
  if [[ ! " ${ignore[*]} " =~ " ${name} " ]]; then
    folders+=("$name")
  fi
done < <(find . -maxdepth 1 -type d ! -path . -print0)

# --- Bước 2: In tiêu đề UI ---
echo -e "${CYAN}"
echo "==============================================="
echo "     CHỌN THƯ MỤC EXAMPLE DESIGN PATTERN"
echo "==============================================="
echo -e "${RESET}"

# --- Bước 3: Menu chọn ---
PS3="$(echo -e ${YELLOW}'Nhập số để chọn thư mục: '${RESET})"
select selected in "${folders[@]}"; do
  if [[ -n $selected ]]; then
    echo -e "${GREEN}Bạn đã chọn: ${selected}${RESET}"
    cd "$selected" || exit 1

    # --- Bước 4: Compile & run Java ---
    JAVA_FILE=${1:-Main}
    mkdir -p target
    echo -e "${CYAN}Đang biên dịch ${JAVA_FILE}.java ...${RESET}"
    javac -d ./target "$JAVA_FILE.java"

    if [[ $? -eq 0 ]]; then
      echo -e "${GREEN}Chạy chương trình...${RESET}"
      java -cp "./target" "$JAVA_FILE"
    else
      echo -e "${RED}Biên dịch thất bại. Vui lòng kiểm tra mã nguồn.${RESET}"
    fi
    break
  else
    echo -e "${RED}Lựa chọn không hợp lệ.${RESET}"
  fi
done
