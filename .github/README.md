# 🗨️ ChatChit – Hệ thống quản lý đoạn chat giữa người dùng

## 📌 Giới thiệu

**ChatChit** là một ứng dụng backend sử dụng Spring Boot, cung cấp các API để quản lý các đoạn chat giữa người dùng. Ứng dụng hỗ trợ các chức năng cơ bản như:

- Tạo cuộc trò chuyện giữa 2 người dùng
- Gửi và nhận tin nhắn
- Lưu trữ lịch sử tin nhắn
- Truy vấn các đoạn chat theo người dùng hoặc cuộc hội thoại
- Hỗ trợ phân quyền người dùng (User/Admin)
- Xác thực người dùng qua JWT

Ứng dụng phù hợp để tích hợp làm backend cho ứng dụng nhắn tin thời gian thực hoặc hệ thống CRM có phần nhắn tin nội bộ.

---

## ⚙️ Công nghệ sử dụng

- Java 17
- Spring Boot 3.x
- Spring Security (JWT)
- Spring Data JPA (Hibernate)
- PostgreSQL
- Lombok
- MapStruct (mapper)
- Swagger / OpenAPI
- JUnit 5 (test)

---

## 🧩 Chức năng chính

| Module | Mô tả |
|--------|------|
| 👤 Người dùng | Đăng ký, đăng nhập, xác thực JWT |
| 💬 Tin nhắn | Gửi/nhận tin nhắn, truy xuất lịch sử, phân trang |
| 🧵 Cuộc hội thoại | Tạo cuộc trò chuyện, lấy danh sách theo người dùng |
| 🔐 Phân quyền | Role-based access control (USER / ADMIN) |
| 📂 API | RESTful endpoints với chuẩn JSON |

---

Swagger Link: /swagger-ui/index.html
