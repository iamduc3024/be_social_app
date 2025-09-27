## Code style
- Java: camelCase cho biến và hàm, PascalCase cho class
- Không dùng tiếng Việt trong tên biến
- Service phải tách interface + implementation

## Test
- Mỗi chức năng phải có unit test

# Danh sách việc cần làm:

# 1. Chuẩn bị môi trường

## Backend (Spring Boot):

Spring Web, Spring Security (JWT/OAuth2).

Spring Data JPA + Database (MySQL/Postgres).

Spring WebSocket (STOMP, SockJS).

Frontend (React Native):

Expo hoặc CLI.

Thư viện WebSocket client (@stomp/stompjs, socket.io-client, hoặc native WebSocket).

Quản lý state: Redux Toolkit hoặc React Query.

# 2. Authentication

## BE:

API đăng ký/đăng nhập với JWT.

Bảng users (id, username, password hash, avatar…).

## FE:

Form login/signup.

Lưu JWT (AsyncStorage).

Middleware check token trước khi gọi API.

# 3. Chat cơ bản (1-1)

## BE:

Bảng conversations, messages.

REST API: tạo conversation, lấy lịch sử tin nhắn.

## WebSocket:

/ws/chat endpoint.

Topic theo room: /topic/conversation.{id}.

Khi user gửi tin nhắn → BE lưu DB → broadcast cho room.

## FE:

Màn hình chat (FlatList hiển thị tin nhắn).

Gửi tin → gọi WS gửi message.

Nhận tin → subscribe topic tương ứng → render ngay.

# 4. Danh sách chat & bạn bè

## BE:

API lấy danh sách conversation (cuộc trò chuyện có last message).

API lấy bạn bè (nếu có hệ thống bạn bè).

## FE:

Sidebar (hoặc tab) hiển thị danh sách chat.

Khi click → mở màn hình chat.

# 5. Trạng thái tin nhắn

## BE
Update status (sent, delivered, seen).

## WS
Thông báo khi message được đọc.

## FE
Hiển thị dấu tick/“đã xem”.

# 6. Online/Offline & Typing

## BE:

Redis hoặc in-memory map quản lý user online.

WS event "user online/offline".

## FE:

Hiện chấm xanh khi user online.

Emit sự kiện "typing" khi gõ → WS gửi cho người kia.

# 7. Group chat

## BE:

Conversation type = GROUP.

Thêm bảng conversation_members.

Broadcast message đến nhiều người.

## FE:

Hiển thị group name, danh sách thành viên.

UI giống 1-1 nhưng nhiều người.

# 8. Nâng cao

File/ảnh: BE lưu vào S3/MinIO, FE gửi file → nhận link.

Notification: Push notification (Firebase Cloud Messaging).

Voice/Video call: WebRTC integration.

# Thứ tự bạn nên làm:

Auth (Login/Register).

Chat 1-1 (REST + WS).

Danh sách chat.

Message status (delivered/seen).

Online/Typing.

Group chat.

Media/Call/Notification.
