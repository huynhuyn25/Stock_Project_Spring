# Stock_Project_Spring
Stock Web Backend Java Spring Boot Project

- Công nghệ sử dụng: Java Spring Boot
- IDE: InteliJ

Mô tả: Backend WebService sử dụng RestfulAPI và WebSocket cho hệ thống hiển thị bảng giá chứng khoán - xử lý msg SI và TP

Luồng xử lý:
- Đọc message FIX từ file
- Convert msg FIX thành Object bằng thư viện QuickFIX/J
- Lọc msg SI và TP, xử lý các msg trùng lặp
- Xử lý thông tin chứa trong msg SI và TP
- Gửi thông tin cho Client

Chức năng
- API: getAll data của các mã chứng khoán ở thời điểm load lại trang
- WebSocket: send data tới các Client subscribe Topic mỗi khi có sự thay đổi từ các msg
